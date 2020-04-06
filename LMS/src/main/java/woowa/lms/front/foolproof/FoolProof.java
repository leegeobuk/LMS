package woowa.lms.front.foolproof;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public interface FoolProof extends EventHandler<KeyEvent> {
    @Override
    void handle(KeyEvent event);
}
