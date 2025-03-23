package abstract_factory.ascii_art;

import abstract_factory.ascii_art.widgets.*;

public abstract class UIFactory {
    public abstract Button createButton(String text);
    public abstract TextField createTextField(String text);
    public abstract Checkbox createCheckbox(String text);
}