package woowa.lms.front.component.button.behavior;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public interface Behavior extends EventHandler<MouseEvent> {

    @Override
    void handle(MouseEvent event);
}
