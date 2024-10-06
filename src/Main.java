import model.Note;
import model.Notebook;
import presenter.NotebookPresenter;
import view.ConsoleNotebookView;

import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        ConsoleNotebookView view = new ConsoleNotebookView();
        NotebookPresenter notebookPresenter = new NotebookPresenter(notebook, view);

        notebookPresenter.addTextNote("Моя первая запись", LocalDateTime.now());
        notebookPresenter.addImageNote("Какая-то запись вместе с изображением", LocalDateTime.now(), "image.jpg");
        notebookPresenter.showAllNotes();


    }
}