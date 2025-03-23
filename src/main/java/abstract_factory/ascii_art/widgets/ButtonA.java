package abstract_factory.ascii_art.widgets;

public class ButtonA extends Button {
    public ButtonA(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("[=" + text + "=]");
    }
}