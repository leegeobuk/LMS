package woowa.lms.front.component.textfield.foolproof.signup;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import lombok.Builder;
import lombok.Singular;
import woowa.lms.front.component.textfield.InputField;

import java.util.List;

@Builder
public class SignUpFoolProof implements EventHandler<KeyEvent> {

    @Builder.Default
    private Button button = null;

    @Singular
    private List<InputField> inputFields;

    @Override
    public void handle(KeyEvent event) {
        if (isFoolProven(inputFields)) {
            button.setDisable(false);
        }
        else {
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
}
