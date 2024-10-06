package view;

import model.Note;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ConsoleNotebookView  implements NotebookView{


    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayNotes(List<? extends Note> notes) {
        for (Note note : notes) {
            System.out.println(note);
        }
    }

    @Override
    public String getInput() {
        System.out.print("Введите запись: ");
        return scanner.nextLine();
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public LocalDateTime getDateTimeInput() {
        return null;
    }


}
