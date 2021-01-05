package woowa.lms.front.foolproof.form;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import lombok.Builder;
import woowa.lms.front.component.textfield.InputField;

import java.util.List;

public class SearchFormFoolProof extends AbstractFormFoolProof<KeyEvent> {

    private static final String MESSAGE = "At least one field must be filled";

    @Builder
    public SearchFormFoolProof(Button button, Label errorLabel, List<InputField> inputFields) {
        super(button, errorLabel, inputFields);
    }

    @Override
    protected boolean isFoolProven(List<InputField> inputFields) {
        boolean allFilled = false;
        for (InputField inputField : inputFields) {
            allFilled = allFilled || inputField.isFoolProved();
        }
        return allFilled;
    }

    @Override
    protected void setErrorMessage(List<InputField> inputFields) {
        errorLabel.setText(MESSAGE);
    }
}
