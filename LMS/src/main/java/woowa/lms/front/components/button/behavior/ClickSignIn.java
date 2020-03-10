package woowa.lms.front.components.button.behavior;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClickSignIn implements ClickBehavior {

    private static final ClickSignIn CLICK_SIGN_IN = new ClickSignIn();

    public static ClickSignIn getInstance() {
        return CLICK_SIGN_IN;
    }

    @Override
    public EventHandler<ActionEvent> click() {
        return event -> {
            System.out.println("Show sign in page");
        };
    }
}
