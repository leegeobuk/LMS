package woowa.lms.front.components.button;

import javafx.scene.control.Label;
import woowa.lms.front.components.button.behavior.ClickBehavior;
import woowa.lms.front.components.button.behavior.ClickSignIn;

public class SignInButton extends CustomButton {

    private static final String TEXT = "Sign in";
    private static final ClickBehavior BEHAVIOR = ClickSignIn.getInstance();

    private SignInButton(Label label) {
        super(label);
        clickBehavior = BEHAVIOR;
    }

    public static SignInButton of(Label label) {
        SignInButton signInButton = new SignInButton(label);
        signInButton.setText(TEXT);
        signInButton.setFont(label.getFont());
        signInButton.setTextFill(label.getTextFill());
        return signInButton;
    }

    @Override
    public void clicked() {
        this.setOnAction(clickBehavior.click());
    }
}
