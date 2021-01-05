package woowa.lms.front.foolproof.field;

import javafx.scene.control.TextField;

public interface FieldFoolProof {
    boolean validate(TextField textField);
    String sendValidationMessage();

    default boolean confirm(TextField passwordField, TextField confirmPasswordField) {
        return passwordField.getText().equals(confirmPasswordField.getText());
    }
}
