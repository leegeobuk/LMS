package woowa.lms.front.behavior.home;

import javafx.scene.input.MouseEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.HomeController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CloseSignIn implements Behavior {

    private static final CloseSignIn INSTANCE = new CloseSignIn();

    public static CloseSignIn getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(MouseEvent event) {
        HomeController.getController().closeSignInForm();
    }
}
