package woowa.lms.front.behavior.show;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.HomeController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowSignUp implements Behavior {

    private static final ShowSignUp CLICK_SIGN_UP = new ShowSignUp();

    public static ShowSignUp getInstance() {
        return CLICK_SIGN_UP;
    }

    @Override
    public void handle(ActionEvent event) {
        HomeController.getController().showSignUpForm();
    }
}
