package abstract_factory.ascii_art.widgets;

public class CheckboxB extends Widget{
    public CheckboxB(String text) {
        super(text);
    }
    @Override
    public void display() {
        System.out.println("{X} " + text);
    }
}
