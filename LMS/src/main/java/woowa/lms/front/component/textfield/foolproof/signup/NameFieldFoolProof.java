package woowa.lms.front.component.textfield.foolproof.signup;

import javafx.scene.control.TextField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.component.textfield.foolproof.FieldFoolProof;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NameFieldFoolProof implements FieldFoolProof {

    private static final NameFieldFoolProof INSTANCE = new NameFieldFoolProof();

    public static NameFieldFoolProof getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean validate(TextField textField) {
        return true;
    }
}
