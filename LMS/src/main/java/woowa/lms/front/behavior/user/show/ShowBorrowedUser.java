package woowa.lms.front.behavior.user.show;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.account.UserTableController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowBorrowedUser implements Behavior {

    private static final ShowBorrowedUser INSTANCE = new ShowBorrowedUser();

    public static ShowBorrowedUser getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        UserTableController.getController().showBorrowedUserTable();
    }
}
