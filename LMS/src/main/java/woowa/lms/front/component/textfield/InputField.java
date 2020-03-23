package woowa.lms.front.component.textfield;

import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;
import woowa.lms.front.foolproof.FieldFoolProof;
import woowa.lms.front.foolproof.FoolProofType;

import static woowa.lms.front.foolproof.FoolProofType.CONFIRM_PW_FIELD;

public class InputField implements CustomInputField {

    @Getter
    private TextField textField;

    @Setter
    private TextField passwordField;

    private FoolProofType foolProofType;
    private FieldFoolProof foolProof;

    private InputField(InputType type, FoolProofType foolProofType) {
        this.textField = type.getField();
        this.foolProofType = foolProofType;
        this.foolProof = foolProofType.getFoolProof();
    }

    public static InputField of(InputType type, FoolProofType foolProofType) {
        return new InputField(type, foolProofType);
    }

    public boolean isFoolProved() {
        return foolProofType != CONFIRM_PW_FIELD ? foolProof.validate(textField)
            : foolProof.confirm(passwordField, textField);
    }

    public String getValidationMessage() {
        return foolProof.sendValidationMessage();
    }

    @Override
    public TextField toTextField() {
        return getTextField();
    }
}
