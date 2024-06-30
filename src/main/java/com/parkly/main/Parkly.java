package com.parkly.main;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;
import com.github.sarxos.webcam.Webcam;
import com.google.api.gax.core.FixedCredentialsProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.parkly.graphics.Display;
import com.parkly.graphics.Window;

public class Parkly {
    public static final Inventory INVENTORY = new Inventory();

    public static final Window WINDOW = new Window();
    public static final Display DISPLAY = new Display();

    public static final Timer GAME_ENGINE = new Timer();

    public static final Zoo ZOO = new Zoo();

    public static final Webcamera WEBCAM = new Webcamera();

    public static final String PATH = "res/parkly-427911-2b052cb9b74a.json";
    
    public static GoogleCredentials credentials;
    public static ImageAnnotatorSettings settings;
    public static  ImageAnnotatorClient vision;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        credentials = GoogleCredentials.fromStream(new FileInputStream(PATH));
        settings = ImageAnnotatorSettings.newBuilder().setCredentialsProvider(FixedCredentialsProvider.create(credentials)).build();
        vision = ImageAnnotatorClient.create(settings);

        ZOO.addAnimal(new Animal("Bob", "Possum", "image2.png"));
        ZOO.addAnimal(new Animal("Dave", "Possum", "image2.png"));

        ZOO.addAnimal(new Animal("Carrot", "Cockatoo", "image3.png"));
        ZOO.addAnimal(new Animal("Hubert Blaine Wolfeschlegelsteinhausenbergerdorff Sr.", "Cockatoo", "image3.png"));
        ZOO.show();

        GAME_ENGINE.schedule(new GameEngine(), 0, GameEngine.PERIOD);

        detectLabels(vision, "res/selfie.jpg");
    }

    static class GameEngine extends TimerTask {
        public final static double FPS = 30;
        public final static int PERIOD = (int) (1000.0 / FPS);

        @Override
        public void run() {
            ZOO.update();
            DISPLAY.repaint();
        }
    }

    public static void detectLabels(ImageAnnotatorClient vision, String filePath) throws IOException {
        List<AnnotateImageRequest> requests = new ArrayList<>();

        ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));
        Image img = Image.newBuilder().setContent(imgBytes).build();
        Feature feat = Feature.newBuilder().setType(Feature.Type.LABEL_DETECTION).build();
        AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
                .addFeatures(feat)
                .setImage(img)
                .build();
        requests.add(request);

        BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
        List<AnnotateImageResponse> responses = response.getResponsesList();

        for (AnnotateImageResponse res : responses) {
            if (res.hasError()) {
                System.out.printf("Error: %s\n", res.getError().getMessage());
                return;
            }

            for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
                System.out.printf("Label: %s\n", annotation.getDescription());
                System.out.printf("Score: %.3f\n", annotation.getScore());
            }
        }
    }
}
