package woowa.lms.front.components.button;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.Setter;
import woowa.lms.front.components.button.behavior.ClickBehavior;

@Setter
public abstract class CustomButton extends Button {

    Label label;
    ClickBehavior clickBehavior;

    CustomButton(Label label) {
        this.label = label;
    }

    public abstract void clicked();
}
