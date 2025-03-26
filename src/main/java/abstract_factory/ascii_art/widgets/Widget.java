package abstract_factory.ascii_art.widgets;

public abstract class Widget {
    protected String text;
    public Widget(String text) {
        this.text = text;
    }
    public abstract void display();
    public void setText(String text) {
        this.text = text;
    }
}

