package woowa.lms.front.foolproof.form;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import lombok.Builder;
import lombok.Singular;
import woowa.lms.front.component.textfield.InputField;

import java.util.List;

@Builder
public class SearchFoolProof implements EventHandler<KeyEvent> {

    @Builder.Default
    protected Button button = null;

    @Builder.Default
    protected Label errorLabel = null;

    @Singular
    protected List<InputField> inputFields;

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

    protected boolean isFoolProven(List<InputField> inputFields) {
        boolean allFilled = false;
        for (InputField inputField : inputFields) {
            allFilled = allFilled || inputField.isFoolProved();
        }
        return allFilled;
    }

    protected void setErrorMessage(List<InputField> inputFields) {
        for (InputField inputField : inputFields) {
            if (!inputField.isFoolProved()) {
                errorLabel.setText(inputField.getValidationMessage());
                break;
            }
        }
    }
}
