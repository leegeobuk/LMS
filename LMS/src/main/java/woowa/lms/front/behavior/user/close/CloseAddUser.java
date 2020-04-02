package woowa.lms.front.behavior.user.close;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.FormController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CloseAddUser implements Behavior {

    private static final CloseAddUser INSTANCE = new CloseAddUser();

    public static CloseAddUser getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        FormController.getController().closeAddUserForm();
    }
}
