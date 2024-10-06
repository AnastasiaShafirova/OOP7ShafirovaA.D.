package model;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Notebook extends Note{


    private List<Note> notes = new ArrayList<>();
    private DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public Notebook(LocalDateTime dateTime, String notesText) {
        super(notesText, dateTime);
    }

    public void add(Note note) {

        notes.add(note);
    }

    public List<Note> getAllNotes() {

        return notes.stream()
                .sorted(Comparator.comparing(Note::getDateTime)) // отсортировали все записи
                .collect(Collectors.toList());
    }

    public List<Note> getNotesForDay(LocalDateTime day) { // для фильтрации заметок по дате
        return notes.stream()
                .filter(note -> note.getDateTime().toLocalDate().isEqual(getDateTime().toLocalDate()))
                .sorted(Comparator.comparing(Note::getDateTime))
                .collect(Collectors.toList());
    }

    public List<Note> getNotesForWeek(LocalDate weekStart) {

    LocalDate weekEnd = weekStart.plusDays(6);
        return notes.stream()
            .filter(note -> {
        LocalDate noteDate = note.getDateTime().toLocalDate();
        return (noteDate.isEqual(weekStart) || noteDate.isEqual(weekEnd));
    })
            .sorted(Comparator.comparing(Note::getDateTime))
            .collect(Collectors.toList());
    }


    public void loadFromFile(String filename) { //загрузка заметок из файла
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    LocalDateTime dateTime = LocalDateTime.parse(parts[0], formatter);
                    String noteText = parts[1];

                    Note note = new Note(noteText, dateTime);
                            add(note);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Обработка исключений
        }
    }
    public void saveToFile (String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            for (Note note : notes) {
                writer.write(note.getDateTime().format(formatter) + "|" + note.getNotes());
                writer.newLine();
            }
        }
    }
    
}
