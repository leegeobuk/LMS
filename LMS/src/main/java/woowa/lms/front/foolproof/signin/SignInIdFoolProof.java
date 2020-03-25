package woowa.lms.front.foolproof.signin;

import javafx.scene.control.TextField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.foolproof.FieldFoolProof;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignInIdFoolProof implements FieldFoolProof {

    private static final String MESSAGE = "Id is not entered!";
    private static final SignInIdFoolProof INSTANCE = new SignInIdFoolProof();

    public static SignInIdFoolProof getInstance() {
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
