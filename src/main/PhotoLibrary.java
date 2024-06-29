package main;
import java.util.ArrayList;
import java.util.List;

import graphics.Window;

public class PhotoLibrary {
    public static final int PHOTOS_PER_ROW = 2;
    public static final int PHOTOS_PER_COL = 3;
    public static final int PHOTOS_PER_PAGE = PHOTOS_PER_COL * PHOTOS_PER_ROW;
    public static final int FIRST_PHOTO_X = (int) Math.floor(Window.WIDTH * 0.05);
    public static final int FIRST_PHOTO_Y = (int) Math.floor(Window.HEIGHT * 0.05);
    public static final int PHOTO_WIDTH = (int) Math.floor(Window.HEIGHT * 0.4);
    public static final int PHOTO_HEIGHT = (int) Math.floor(Window.HEIGHT * 0.4);
    public static final int PHOTO_GAP_X = (int) Math.floor(Window.HEIGHT * 0.1);
    public static final int PHOTO_GAP_Y = (int) Math.floor(Window.HEIGHT * 0.1);

    List<Photo> photos;
    String photoBook;
    int bookPage;

    public PhotoLibrary(String photoBook) {
        this.photos = new ArrayList<Photo>();
        this.photoBook = photoBook;
        bookPage = 0;
    }

    public void addPhoto(String image, String name) {
        int listSize = photos.size();

        int x = FIRST_PHOTO_X + ((listSize % PHOTOS_PER_PAGE) % PHOTOS_PER_ROW) * (PHOTO_WIDTH + PHOTO_GAP_X);
        int y = FIRST_PHOTO_Y + ((int) Math.floor((listSize % PHOTOS_PER_PAGE) / PHOTOS_PER_ROW)) * (PHOTO_HEIGHT + PHOTO_GAP_Y);
        int page = (int) Math.floor(listSize / PHOTOS_PER_PAGE);
        photos.add(new Photo(image, x, y, page, name));
    }

    public void displayPhotos(int pageToDisplay) {
        //
        for(int i = 0; i < photos.size(); i++) {
            if (photos.get(i).page == pageToDisplay) {
                //Display the photo at the x and y coords
            }
        }
    }

    public void forwardsOnePage() {
        bookPage++;
        if (bookPage) {

        }
        displayPhotos(bookPage);
    }

}
