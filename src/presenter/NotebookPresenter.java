package presenter;

import model.ImageNote;
import model.Note;
import model.Notebook;
import model.TextNote;
import view.NotebookView;

import java.time.LocalDateTime;

public class NotebookPresenter {
    private Notebook notebook;
    private NotebookView view;

    public NotebookPresenter(Notebook notebook, NotebookView view){
        this.notebook = notebook;
        this.view = view;

    }

    public  void addTextNote(String text, LocalDateTime dateTime) {
        notebook.add(new TextNote(text, dateTime));
    }

    public void addImageNote(String text, LocalDateTime dateTime, String imageUrl){
        notebook.add(new ImageNote(text, dateTime, imageUrl));
    }

    public void showAllNotes(){
        view.displayNotes(notebook.getAllNotes());
    }
}
