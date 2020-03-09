package woowa.lms.front.page.main.button.signup;

import woowa.lms.front.components.button.CustomButton;

public class SignUpButton extends CustomButton {

    private SignUpButton() {
        clickBehavior = ClickSignUp.getInstance();
    }

    public static SignUpButton of(String text) {
        SignUpButton signUpButton = new SignUpButton();
        signUpButton.setText(text);
        signUpButton.clicked();
        return signUpButton;
    }

    @Override
    public void clicked() {
        this.setOnAction(clickBehavior.click());
    }

}
