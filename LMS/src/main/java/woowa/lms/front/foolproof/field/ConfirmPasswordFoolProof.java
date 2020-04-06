package woowa.lms.front.foolproof.field;

import javafx.scene.control.TextField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConfirmPasswordFoolProof implements FieldFoolProof {

    private static final String MESSAGE = "Password does not match!";
    private static final ConfirmPasswordFoolProof INSTANCE = new ConfirmPasswordFoolProof();

    public static ConfirmPasswordFoolProof getInstance() {
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
