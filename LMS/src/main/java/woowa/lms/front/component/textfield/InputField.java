package woowa.lms.front.component.textfield;

import javafx.scene.control.TextField;
import lombok.Getter;
import woowa.lms.front.component.textfield.foolproof.FieldFoolProof;
import woowa.lms.front.component.textfield.foolproof.FoolProofType;

public class InputField implements CustomInputField {

    private InputType type;

    @Getter
    private TextField textField;
    private FoolProofType foolProofType;
    private FieldFoolProof foolProof;

    private InputField(InputType type, FoolProofType foolProofType) {
        this.type = type;
        this.foolProofType = foolProofType;
        this.textField = type.getField();
        this.foolProof = foolProofType.getFoolProof();
    }

    public static InputField of(InputType type, FoolProofType foolProofType) {
        return new InputField(type, foolProofType);
    }

    public boolean isFoolProved() {
        return foolProof.validate(textField);
    }

    @Override
    public TextField toTextField() {
        return getTextField();
    }
}
