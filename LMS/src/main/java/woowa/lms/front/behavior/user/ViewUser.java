package woowa.lms.front.behavior.user;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.account.UserTableController;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ViewUser implements Behavior {

    private static final ViewUser INSTANCE = new ViewUser();

    public static ViewUser getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        UserTableController.getController().viewAllUsers();
    }
}
