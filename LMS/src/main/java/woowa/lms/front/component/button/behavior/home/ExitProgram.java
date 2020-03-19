package woowa.lms.front.component.button.behavior.home;

import javafx.scene.input.MouseEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.controller.HomeController;
import woowa.lms.front.component.button.behavior.Behavior;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExitProgram implements Behavior {

    private static final ExitProgram CLICK_EXIT = new ExitProgram();

    public static ExitProgram getInstance() {
        return CLICK_EXIT;
    }

    @Override
    public void handle(MouseEvent event) {
        HomeController.showExitDialog();
    }
}
