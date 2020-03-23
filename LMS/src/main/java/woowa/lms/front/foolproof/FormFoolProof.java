package woowa.lms.front.foolproof;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import lombok.Builder;
import lombok.Singular;
import woowa.lms.front.component.textfield.InputField;

import java.util.List;

@Builder
public class FormFoolProof implements EventHandler<KeyEvent> {

    @Builder.Default
    private Button button = null;

    @Builder.Default
    private Label errorLabel = null;

    @Singular
    private List<InputField> inputFields;

    @Override
    public void handle(KeyEvent event) {
        if (isFoolProven(inputFields)) {
            errorLabel.setText("");
            button.setDisable(false);
        }
        else {
            setErrorMessage(inputFields);
            button.setDisable(true);
        }
    }

    private boolean isFoolProven(List<InputField> inputFields) {
        for (InputField inputField : inputFields) {
            if (!inputField.isFoolProved()) {
                return false;
            }
        }
        return true;
    }

    private void setErrorMessage(List<InputField> inputFields) {
        for (InputField inputField : inputFields) {
            if (!inputField.isFoolProved()) {
                errorLabel.setText(inputField.getValidationMessage());
                break;
            }
        }
    }
}
