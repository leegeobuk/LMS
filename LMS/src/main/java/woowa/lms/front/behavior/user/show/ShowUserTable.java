package woowa.lms.front.behavior.user.show;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.TableController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowUserTable implements Behavior {

    private static final ShowUserTable INSTANCE = new ShowUserTable();

    public static ShowUserTable getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        TableController.getController().showUserTable();
    }
}
