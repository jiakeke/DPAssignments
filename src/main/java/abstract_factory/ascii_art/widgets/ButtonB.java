package abstract_factory.ascii_art.widgets;

public class ButtonB extends Widget {
    public ButtonB(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("{=" + text + "=}");
    }
}