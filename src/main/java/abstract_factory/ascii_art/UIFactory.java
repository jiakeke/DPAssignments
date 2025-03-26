package abstract_factory.ascii_art;

import abstract_factory.ascii_art.widgets.*;

public abstract class UIFactory {
    public abstract Widget createButton(String text);
    public abstract Widget createTextField(String text);
    public abstract Widget createCheckbox(String text);
}
