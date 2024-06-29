package com.parkly.main;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;
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

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ZOO.addAnimal(new Animal("Bob", "Possum", ""));
        ZOO.show();

        GAME_ENGINE.schedule(new GameEngine(), 0, GameEngine.PERIOD);

        // String jsonPath = "res/parkly-427911-3c077268a428.json";

        // GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(jsonPath));
        // ImageAnnotatorSettings settings = ImageAnnotatorSettings.newBuilder().setCredentialsProvider(FixedCredentialsProvider.create(credentials)).build();

        // try (ImageAnnotatorClient vision = ImageAnnotatorClient.create(settings)) {
        //     String imagePath = "res/image.png";
        //     detectLabels(vision, imagePath);
        // }
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

    private static void detectLabels(ImageAnnotatorClient vision, String filePath) throws IOException {
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
