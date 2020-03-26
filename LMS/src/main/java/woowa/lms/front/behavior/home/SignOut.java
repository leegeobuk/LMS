package woowa.lms.front.behavior.home;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.util.Token;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.HomeController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignOut implements Behavior {

    private static final SignOut INSTANCE = new SignOut();

    public static SignOut getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        HomeController.getController().showSignOutDialog();
    }
}
