package woowa.lms.front.behavior.main.close;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.MainController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CloseAbout implements Behavior {

    private static final CloseAbout INSTANCE = new CloseAbout();

    public static CloseAbout getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        MainController.getController().closeAboutPage();
    }
}
