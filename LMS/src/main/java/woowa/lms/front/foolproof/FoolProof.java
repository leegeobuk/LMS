package woowa.lms.front.foolproof;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public interface FoolProof<T extends Event> extends EventHandler<T> {
    @Override
    void handle(T event);
}
