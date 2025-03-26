package abstract_factory.ascii_art;

import abstract_factory.ascii_art.widgets.*;

public class AFactory extends UIFactory {
    @Override
    public Widget createButton(String text) {
        return new ButtonA(text);
    }

    @Override
    public Widget createTextField(String text) {
        return new TextFieldA(text);
    }

    @Override
    public Widget createCheckbox(String text) {
        return new CheckboxA(text);
    }
}
