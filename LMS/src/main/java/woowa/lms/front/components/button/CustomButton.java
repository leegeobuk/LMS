package woowa.lms.front.components.button;

import javafx.scene.control.Button;
import lombok.Setter;
import woowa.lms.front.components.button.behavior.ClickBehavior;

@Setter
public abstract class CustomButton extends Button {

    protected ClickBehavior clickBehavior;

    public abstract void clicked();
}
