package view;

import model.Note;

import java.time.LocalDateTime;
import java.util.List;

public interface NotebookView {
    void displayNotes(List<? extends Note> notes);
    String getInput();
    void showMessage(String message);
    LocalDateTime getDateTimeInput();

}
