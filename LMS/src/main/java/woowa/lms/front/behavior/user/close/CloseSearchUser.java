package woowa.lms.front.behavior.user.close;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.FormController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CloseSearchUser implements Behavior {

    private static final CloseSearchUser INSTANCE = new CloseSearchUser();

    public static CloseSearchUser getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        FormController.getController().closeSearchUserForm();
    }
}
