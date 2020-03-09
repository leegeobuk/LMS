package woowa.lms.front.page.main.button.signup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.components.button.click.ClickBehavior;

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
