package woowa.lms.front.behavior.main.sign;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.account.AccountDialogController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignOut implements Behavior {

    private static final SignOut INSTANCE = new SignOut();

    public static SignOut getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        AccountDialogController.getController().showSignOutDialog();
    }
}
