package woowa.lms.front.foolproof.field;

import javafx.scene.control.TextField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NotEmptyFoolProof implements FieldFoolProof {

    private static final String MESSAGE = "Blank is not allowed!";
    private static final NotEmptyFoolProof INSTANCE = new NotEmptyFoolProof();

    public static NotEmptyFoolProof getInstance() {
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
