package woowa.lms.front.behavior.user.show;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.account.UserTableController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowUserToLend implements Behavior {

    private static final ShowUserToLend INSTANCE = new ShowUserToLend();

    public static ShowUserToLend getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        UserTableController.getController().showUserToLendTable();
    }
}
