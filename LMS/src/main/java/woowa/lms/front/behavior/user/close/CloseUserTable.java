package woowa.lms.front.behavior.user.close;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.TableController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CloseUserTable implements Behavior {

    private static final CloseUserTable INSTANCE = new CloseUserTable();

    public static CloseUserTable getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        TableController.getController().closeUserTable();
    }
}
