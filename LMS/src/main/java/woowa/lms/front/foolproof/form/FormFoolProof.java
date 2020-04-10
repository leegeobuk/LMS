package woowa.lms.front.foolproof.form;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import lombok.Builder;
import woowa.lms.front.component.textfield.InputField;

import java.util.List;

public class FormFoolProof extends AbstractFormFoolProof<KeyEvent> {

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
