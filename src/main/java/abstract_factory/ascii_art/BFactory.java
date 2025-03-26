package abstract_factory.ascii_art;

import abstract_factory.ascii_art.widgets.*;

public class BFactory extends UIFactory {
    @Override
    public Widget createButton(String text) {
        return new ButtonB(text);
    }

    @Override
    public Widget createTextField(String text) {
        return new TextFieldB(text);
    }

    @Override
    public Widget createCheckbox(String text) {
        return new CheckboxB(text);
    }
}
