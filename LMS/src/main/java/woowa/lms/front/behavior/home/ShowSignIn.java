package woowa.lms.front.behavior.home;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.HomeController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowSignIn implements Behavior {

    private static final ShowSignIn CLICK_SIGN_IN = new ShowSignIn();

    public static ShowSignIn getInstance() {
        return CLICK_SIGN_IN;
    }

    @Override
    public void handle(ActionEvent event) {
        HomeController.getController().showSignInForm();
    }
}
