package woowa.lms.front.behavior.user.show;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.TableController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowUnreturnedUser implements Behavior {

    private static final ShowUnreturnedUser INSTANCE = new ShowUnreturnedUser();

    public static ShowUnreturnedUser getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        TableController.getController().showUnreturnedUserTable();
    }
}
