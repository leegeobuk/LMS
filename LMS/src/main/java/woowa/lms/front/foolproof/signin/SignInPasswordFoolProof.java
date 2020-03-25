package woowa.lms.front.foolproof.signin;

import javafx.scene.control.TextField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.foolproof.FieldFoolProof;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignInPasswordFoolProof implements FieldFoolProof {

    private static final String MESSAGE = "Password is not entered!";
    private static final SignInPasswordFoolProof INSTANCE = new SignInPasswordFoolProof();

    public static SignInPasswordFoolProof getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean validate(TextField textField) {
        return textField.getLength() > 0;
    }

    @Override
    public String sendValidationMessage() {
        return MESSAGE;
    }
}
