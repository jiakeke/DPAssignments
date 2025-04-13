package memento.guistate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;
    private LocalDateTime creationDate;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.creationDate = LocalDateTime.now();
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS dd-MM-yyyy");
        String formattedDate = creationDate.format(formatter);
        return formattedDate;
    }
}
