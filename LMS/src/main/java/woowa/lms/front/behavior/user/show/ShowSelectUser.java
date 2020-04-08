package woowa.lms.front.behavior.user.show;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.TableController;
import woowa.lms.front.ui.table.UserTable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowSelectUser implements Behavior {

    private static final ShowSelectUser INSTANCE = new ShowSelectUser();

    public static ShowSelectUser getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        TableController.getController().showUserTableSelectionMode();
    }
}
