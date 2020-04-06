package woowa.lms.front.behavior;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import woowa.lms.front.ui.form.AbstractForm;

public interface Behavior extends EventHandler<ActionEvent> {

    default void closeForm(ActionEvent event) {
        Button button = (Button) event.getSource();
        ((AbstractForm) button.getScene().getWindow()).close();
    }

    @Override
    void handle(ActionEvent event);
}
