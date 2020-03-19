package woowa.lms.front.component.button.behavior.home;

import javafx.scene.input.MouseEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.controller.HomeController;
import woowa.lms.front.component.button.behavior.Behavior;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowSignUp implements Behavior {

    private static final ShowSignUp CLICK_SIGN_UP = new ShowSignUp();

    public static ShowSignUp getInstance() {
        return CLICK_SIGN_UP;
    }

    @Override
    public void handle(MouseEvent event) {
        HomeController.showSignUpForm();
    }
}
