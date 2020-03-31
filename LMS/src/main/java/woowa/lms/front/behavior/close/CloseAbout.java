package woowa.lms.front.behavior.close;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.HomeController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CloseAbout implements Behavior {

    private static final CloseAbout INSTANCE = new CloseAbout();

    public static CloseAbout getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        HomeController.getController().closeAboutPage();
    }
}