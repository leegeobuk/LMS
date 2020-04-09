package woowa.lms.front.behavior;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import woowa.lms.front.ui.form.AbstractForm;

public interface Behavior extends EventHandler<ActionEvent> {
    @Override
    void handle(ActionEvent event);
}
