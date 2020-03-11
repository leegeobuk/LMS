package woowa.lms.front.components.button;

import javafx.scene.control.Label;
import woowa.lms.front.components.button.behavior.ClickBehavior;
import woowa.lms.front.components.button.behavior.ClickExit;

public class ExitButton extends CustomButton {

    private static final String TEXT = "Exit";
    private static final ClickBehavior BEHAVIOR = ClickExit.getInstance();

    private ExitButton(Label label) {
        super(label);
        clickBehavior = BEHAVIOR;
    }

    public static ExitButton of(Label label) {
        ExitButton exitButton = new ExitButton(label);
        exitButton.setText(TEXT);
        exitButton.setFont(label.getFont());
        exitButton.setTextFill(label.getTextFill());
        return exitButton;
    }

    @Override
    public void clicked() {
        this.setOnAction(clickBehavior.click());
    }
}
