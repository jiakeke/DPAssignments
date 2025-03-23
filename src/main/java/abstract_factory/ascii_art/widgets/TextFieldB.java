package abstract_factory.ascii_art.widgets;

public class TextFieldB extends TextField {
    public TextFieldB(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("{__" + text + "__}");
    }
}