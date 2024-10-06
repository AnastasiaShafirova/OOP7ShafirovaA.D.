package model;

import java.time.LocalDateTime;

public class ImageNote extends Note{

    private String imageUrl;

    public ImageNote(String notes, LocalDateTime dateTime, String imageUrl) {
        super(notes, dateTime);
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (Image: %s)", getDateTime(), getNotes(), imageUrl);
    }
}
