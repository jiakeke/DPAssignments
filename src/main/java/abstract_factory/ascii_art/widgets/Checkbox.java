package abstract_factory.ascii_art.widgets;

public abstract class Checkbox {
    protected String text;
    public Checkbox(String text) {
        this.text = text;
    }
    public abstract void display();
    public void setText(String text) {
        this.text = text;
    }
}