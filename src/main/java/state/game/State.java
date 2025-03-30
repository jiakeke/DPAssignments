package state.game;

public abstract class State {
    private Character character;
    private int nextLimit = 0;

    public State(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    abstract void action();

    public void setNextLimit(int nextLimit) {
        this.nextLimit = nextLimit;
    }

    public int getNextLimit() {
        return nextLimit;
    }
}


