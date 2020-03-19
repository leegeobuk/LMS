package woowa.lms.front.component.textfield.foolproof.signup;

import javafx.scene.control.TextField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.component.textfield.foolproof.FieldFoolProof;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IdFieldFoolProof implements FieldFoolProof {

    private static final IdFieldFoolProof INSTANCE = new IdFieldFoolProof();

    public static IdFieldFoolProof getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean validate(TextField textField) {
        return textField.getLength() > 1;
    }
}
