package abstract_factory.ascii_art.widgets;

public class TextFieldA extends TextField {
    public TextFieldA(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("[__" + text + "__]");
    }
}