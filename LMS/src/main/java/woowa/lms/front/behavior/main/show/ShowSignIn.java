package woowa.lms.front.behavior.main.show;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.FormController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowSignIn implements Behavior {

    private static final ShowSignIn CLICK_SIGN_IN = new ShowSignIn();

    public static ShowSignIn getInstance() {
        return CLICK_SIGN_IN;
    }

    @Override
    public void handle(ActionEvent event) {
        FormController.getController().showSignInForm();
    }
}
