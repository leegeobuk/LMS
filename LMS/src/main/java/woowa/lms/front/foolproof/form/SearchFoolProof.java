package woowa.lms.front.foolproof.form;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.Builder;
import woowa.lms.front.component.textfield.InputField;
import woowa.lms.front.foolproof.AbstractFoolProof;

import java.util.List;

public class SearchFoolProof extends AbstractFoolProof {

    private static final String MESSAGE = "At least one field must be filled";

    @Builder
    public SearchFoolProof(Button button, Label errorLabel, List<InputField> inputFields) {
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
