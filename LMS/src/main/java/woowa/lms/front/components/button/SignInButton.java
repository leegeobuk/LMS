package woowa.lms.front.components.button;

import woowa.lms.front.components.button.behavior.ClickSignIn;

public class SignInButton extends CustomButton {

    private SignInButton() {
        clickBehavior = ClickSignIn.getInstance();
    }

    public static SignInButton of(String text) {
        SignInButton signInButton = new SignInButton();
        signInButton.setText(text);
        signInButton.clicked();
        return signInButton;
    }

    @Override
    public void clicked() {
        this.setOnAction(clickBehavior.click());
    }
}
