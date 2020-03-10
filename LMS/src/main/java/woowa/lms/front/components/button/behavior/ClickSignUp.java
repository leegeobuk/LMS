package woowa.lms.front.components.button.behavior;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClickSignUp implements ClickBehavior {

    private static final ClickSignUp CLICK_SIGN_UP = new ClickSignUp();

    public static ClickSignUp getInstance() {
        return CLICK_SIGN_UP;
    }

    @Override
    public EventHandler<ActionEvent> click() {
        return event -> {
            System.out.println("Show sign up page");
        };
    }
}
