package woowa.lms.front.foolproof.signup;

import javafx.scene.control.TextField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.foolproof.FieldFoolProof;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConfirmPasswordFieldFoolProof implements FieldFoolProof {

    private static final String MESSAGE = "Password does not match!";
    private static final ConfirmPasswordFieldFoolProof INSTANCE = new ConfirmPasswordFieldFoolProof();

    public static ConfirmPasswordFieldFoolProof getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean validate(TextField textField) {
        return true;
    }

    @Override
    public String sendValidationMessage() {
        return MESSAGE;
    }
}
