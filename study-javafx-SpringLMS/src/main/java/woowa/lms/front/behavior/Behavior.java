package woowa.lms.front.behavior;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public interface Behavior extends EventHandler<ActionEvent> {
    @Override
    void handle(ActionEvent event);
}
