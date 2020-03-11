package woowa.lms.front.components.button.behavior;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClickAbout implements ClickBehavior {

    private static final ClickAbout CLICK_ABOUT = new ClickAbout();

    public static ClickAbout getInstance() {
        return CLICK_ABOUT;
    }

    @Override
    public EventHandler<ActionEvent> click() {
        return event -> {
            System.out.println("About clicked");
        };
    }
}
