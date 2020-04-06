package woowa.lms.front.foolproof.form;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.Builder;
import woowa.lms.front.component.textfield.InputField;
import woowa.lms.front.foolproof.AbstractFoolProof;

import java.util.List;

public class FormFoolProof extends AbstractFoolProof {

    @Builder
    public FormFoolProof(Button button, Label errorLabel, List<InputField> inputFields) {
        super(button, errorLabel, inputFields);
    }

    @Override
    protected boolean isFoolProven(List<InputField> inputFields) {
        for (InputField inputField : inputFields) {
            if (!inputField.isFoolProved()) {
                return false;
            }
        }
        return true;
    }
}
