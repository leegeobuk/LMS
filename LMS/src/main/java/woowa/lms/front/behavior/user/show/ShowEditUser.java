package woowa.lms.front.behavior.user.show;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.account.AccountFormController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowEditUser implements Behavior {

    private static final ShowEditUser INSTANCE = new ShowEditUser();

    public static ShowEditUser getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        AccountFormController.getController().showEditUserForm();
    }
}
