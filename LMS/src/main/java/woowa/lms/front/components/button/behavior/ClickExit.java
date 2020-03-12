package woowa.lms.front.components.button.behavior;

import javafx.application.Platform;
import javafx.scene.input.MouseEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClickExit implements ClickBehavior {

    private static final ClickExit CLICK_EXIT = new ClickExit();

    public static ClickExit getInstance() {
        return CLICK_EXIT;
    }

    @Override
    public void handle(MouseEvent event) {
        Platform.exit();
    }
}
