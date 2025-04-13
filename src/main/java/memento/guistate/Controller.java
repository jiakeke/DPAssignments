package memento.guistate;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private List<IMemento> redoHistory; // Redo history

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        redoHistory.clear(); // Clear redo history when a new action is performed
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        redoHistory.clear(); // Clear redo history when a new action is performed
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");
            IMemento previousState = history.remove(history.size() - 1);
            saveToRedoHistory();
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            System.out.println("Memento found in redo history");
            IMemento nextState = redoHistory.remove(redoHistory.size() - 1);
            saveToHistory();
            model.restoreState(nextState);
            gui.updateGui();
        }
    }

    public void restoreState(IMemento memento) {
        model.restoreState(memento);
        gui.updateGui();
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
        gui.updateHistoryListView();
    }

    public List<IMemento> getHistory() {
        return history;
    }

    private void saveToRedoHistory() {
        IMemento currentState = model.createMemento();
        redoHistory.add(currentState);
        gui.updateHistoryListView();
    }
}
