package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Note {
    private String text;
    private LocalDateTime dateTime;

    public Note(String notes, LocalDateTime dateTime) {
        this.text = notes;
        this.dateTime = dateTime;
    }

    public String getNotes() {

        return text;
    }

    public LocalDateTime getDateTime() {

        return dateTime;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", dateTime, text);
    }
}
