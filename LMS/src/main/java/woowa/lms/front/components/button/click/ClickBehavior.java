package woowa.lms.front.components.button.click;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public interface ClickBehavior {

    EventHandler<ActionEvent> click();
}
