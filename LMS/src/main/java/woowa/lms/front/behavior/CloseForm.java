package woowa.lms.front.behavior;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.controller.HomeController;
import woowa.lms.front.component.button.GeneralButton;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CloseForm implements Behavior {

    private static final CloseForm INSTANCE = new CloseForm();

    public static CloseForm getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(MouseEvent event) {
        GeneralButton source = (GeneralButton) event.getSource();
        List<TextField> fields = source.getFields();
        fields.forEach(TextField::clear);
        Label errorLabel = source.getErrorLabel();
        errorLabel.setText("");
        HomeController.closeSignUpForm();
    }
}
