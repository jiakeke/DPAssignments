package abstract_factory.ascii_art.widgets;

public class TextFieldA extends Widget {
    public TextFieldA(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("[__" + text + "__]");
    }
}