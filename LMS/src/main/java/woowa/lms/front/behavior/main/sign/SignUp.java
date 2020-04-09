package woowa.lms.front.behavior.main.sign;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.account.AccountFormController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignUp implements Behavior {



    private static final SignUp INSTANCE = new SignUp();

    public static SignUp getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        AccountFormController.getController().signUpAndClose(event);
    }
}
