package woowa.lms.front.components.button;

import javafx.scene.control.Label;
import woowa.lms.front.components.button.behavior.ClickBehavior;
import woowa.lms.front.components.button.behavior.ClickSignUp;

public class SignUpButton extends CustomButton {

    private static final String TEXT = "Sign Up";
    private static final ClickBehavior BEHAVIOR = ClickSignUp.getInstance();

    private SignUpButton(Label label) {
        super(label);
        clickBehavior = BEHAVIOR;
    }

    public static SignUpButton of(Label label) {
        SignUpButton signUpButton = new SignUpButton(label);
        signUpButton.setText(TEXT);
        signUpButton.setFont(label.getFont());
        signUpButton.setTextFill(label.getTextFill());
        return signUpButton;
    }

    @Override
    public void clicked() {
        this.setOnAction(clickBehavior.click());
    }

}
