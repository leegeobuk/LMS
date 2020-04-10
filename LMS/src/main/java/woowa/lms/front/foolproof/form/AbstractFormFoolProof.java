package woowa.lms.front.foolproof.form;

import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import lombok.AllArgsConstructor;
import woowa.lms.front.component.textfield.InputField;
import woowa.lms.front.foolproof.FoolProof;

import java.util.List;

@AllArgsConstructor
public abstract class AbstractFormFoolProof<T extends Event> implements FoolProof<T> {

    protected Button button;

    protected Label errorLabel;

    protected List<InputField> inputFields;

    @Override
    public void handle(T event) {
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
