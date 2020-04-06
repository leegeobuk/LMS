package woowa.lms.front.foolproof;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import lombok.AllArgsConstructor;
import woowa.lms.front.component.textfield.InputField;

import java.util.List;

@AllArgsConstructor
public abstract class AbstractFoolProof implements FoolProof {

    protected Button button;

    protected Label errorLabel;

    protected List<InputField> inputFields;

    @Override
    public final void handle(KeyEvent event) {
        if (isFoolProven(inputFields)) {
            errorLabel.setText("");
            button.setDisable(false);
        }
        else {
            setErrorMessage(inputFields);
            button.setDisable(true);
        }
    }

    protected abstract boolean isFoolProven(List<InputField> inputFields);

    protected void setErrorMessage(List<InputField> inputFields) {
        for (InputField inputField : inputFields) {
            if (!inputField.isFoolProved()) {
                errorLabel.setText(inputField.getValidationMessage());
                break;
            }
        }
    }
}
