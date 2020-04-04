package woowa.lms.front.component.textfield;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import lombok.Getter;
import lombok.Setter;
import woowa.lms.front.foolproof.FieldFoolProof;
import woowa.lms.front.foolproof.FoolProofType;

import static woowa.lms.front.foolproof.FoolProofType.CONFIRM_PW;

public class InputField implements CustomInputField {

    @Getter
    private TextField textField;

    @Setter
    private InputField passwordField;

    private FoolProofType foolProofType;
    private FieldFoolProof foolProof;

    private InputField(InputType type, FoolProofType foolProofType, String text) {
        this.textField = type.getField();
        this.textField.setPromptText(text);
        this.foolProofType = foolProofType;
        this.foolProof = foolProofType.getFoolProof();
    }

    public static InputField of(InputType type, FoolProofType foolProofType, String text) {
        return new InputField(type, foolProofType, text);
    }

    public void clear() {
        textField.clear();
    }

    public boolean isFoolProved() {
        return foolProofType != CONFIRM_PW ? foolProof.validate(textField)
            : foolProof.confirm(passwordField.toTextField(), textField);
    }

    public String getValidationMessage() {
        return foolProof.sendValidationMessage();
    }

    public void setOnKeyReleased(EventHandler<KeyEvent> eventHandler) {
        textField.setOnKeyReleased(eventHandler);
    }

    @Override
    public TextField toTextField() {
        return getTextField();
    }
}
