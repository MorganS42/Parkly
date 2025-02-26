package com.parkly.main;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Graphics2D;
import com.parkly.graphics.*;
import com.parkly.graphics.Window;

public class PhotoLibrary extends Displayable {
    public static final int PHOTOS_PER_ROW = 2;
    public static final int PHOTOS_PER_COL = 3;
    public static final int PHOTOS_PER_PAGE = PHOTOS_PER_COL * PHOTOS_PER_ROW;
    public static final int FIRST_PHOTO_X = (int) Math.floor(Window.WIDTH * 0.05);
    public static final int FIRST_PHOTO_Y = (int) Math.floor(Window.HEIGHT * 0.05);
    public static final int PHOTO_WIDTH = (int) Math.floor(Window.HEIGHT * 0.2);
    public static final int PHOTO_HEIGHT = (int) Math.floor(Window.HEIGHT * 0.2);
    public static final int PHOTO_GAP_X = (int) Math.floor(Window.HEIGHT * 0.1);
    public static final int PHOTO_GAP_Y = (int) Math.floor(Window.HEIGHT * 0.1);

    static List<Photo> photos;
    static int currentPage;

    public PhotoLibrary() {
        super(new DisplayObject((Graphics2D g2, Display display) -> {
            displayPhotos(g2, display);
        }));

        photos = new ArrayList<Photo>();
        currentPage = 0;
    }

    public void addPhoto(String image, String name) {
        int listSize = photos.size();
        
        /* The x coord of the photo is equal to the x_coord of the first photo + (((the number of 
        photos in the list modulo the photos per page) modulo the number of photos per each row) 
        multiplied by the difference in x coordinates between each photo) */
        int x = FIRST_PHOTO_X + ((listSize % PHOTOS_PER_PAGE) % PHOTOS_PER_ROW) * (PHOTO_WIDTH + PHOTO_GAP_X);
        /*The y coord of the photo is equal to the y_coord of the first photo + (the floor of ((
        the number of photos in the list modulo the photos per page) divided by the number of photos 
        per each row) multiplied by the difference in y coordinates between each photo)*/
        int y = FIRST_PHOTO_Y + ((int) Math.floor((listSize % PHOTOS_PER_PAGE) / PHOTOS_PER_ROW)) * (PHOTO_HEIGHT + PHOTO_GAP_Y);
        int page = (int) Math.floor(listSize / PHOTOS_PER_PAGE);
        photos.add(new Photo(image, x, y, page, name));
    }

    public static void displayPhotos(Graphics2D g2, Display display) {
        // Draw the photobook background
        g2.setColor(Color.white);
        g2.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);
        for(int i = 0; i < photos.size(); i++) {
            if(photos.get(i).page == currentPage) {
                //Display the photo at the x and y coords
                //Change the nulls below!
                g2.drawImage(Utils.toImage(photos.get(i).image), photos.get(i).x, photos.get(i).y, PHOTO_WIDTH, PHOTO_HEIGHT, display);
            }
        }
    }

    public void show() {
        super.show();
    }

    public void hide() {
        super.hide();
    }

    public void forwardsOnePage() {
        currentPage++;
        if(currentPage > (int) Math.floor(photos.size() / PHOTOS_PER_PAGE)) {
            currentPage = 0;
        }
        //displayPhotos();
    }

    public void backwardsOnePage() {
        currentPage--;
        if(currentPage < 0) {
            currentPage = (int) Math.floor(photos.size() / PHOTOS_PER_PAGE);
        }
        //displayPhotos();
    }

    @Override
    public void update() {
    }
}
