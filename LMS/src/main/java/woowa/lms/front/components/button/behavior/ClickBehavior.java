package woowa.lms.front.components.button.behavior;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public interface ClickBehavior extends EventHandler<MouseEvent> {

    @Override
    void handle(MouseEvent event);
}
