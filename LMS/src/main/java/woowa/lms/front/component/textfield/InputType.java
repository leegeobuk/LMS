package woowa.lms.front.component.textfield;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public enum InputType {

    TEXT("text"), PASSWORD("pw");

    private String type;

    InputType(String type) {
        this.type = type;
    }

    public TextField getField() {
        return type.equals("text") ? new TextField() : new PasswordField();
    }
}
