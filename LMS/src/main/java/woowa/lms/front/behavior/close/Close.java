package woowa.lms.front.behavior.close;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.MainController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Close implements Behavior {

    private static final Close INSTANCE = new Close();

    public static Close getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        MainController.getController().close(event);
    }
}
