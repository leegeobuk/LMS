package woowa.lms.front.foolproof.signup;

import javafx.scene.control.TextField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.foolproof.FieldFoolProof;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignUpConfirmPasswordFoolProof implements FieldFoolProof {

    private static final String MESSAGE = "Password does not match!";
    private static final SignUpConfirmPasswordFoolProof INSTANCE = new SignUpConfirmPasswordFoolProof();

    public static SignUpConfirmPasswordFoolProof getInstance() {
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
