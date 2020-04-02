package woowa.lms.front.behavior.main.close;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.FormController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CloseSignUp implements Behavior {

    private static final CloseSignUp INSTANCE = new CloseSignUp();

    public static CloseSignUp getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        FormController.getController().closeSignUpForm();
    }
}