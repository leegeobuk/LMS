package woowa.lms.front.components.button.behavior;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.app.App;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClickExit implements ClickBehavior {

    private static final ClickExit CLICK_EXIT = new ClickExit();

    public static ClickExit getInstance() {
        return CLICK_EXIT;
    }

    @Override
    public EventHandler<ActionEvent> click() {
        return event -> Platform.exit();
    }
}
