package woowa.lms.front.components.button.behavior;

import javafx.scene.input.MouseEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClickSignIn implements ClickBehavior {

    private static final ClickSignIn CLICK_SIGN_IN = new ClickSignIn();

    public static ClickSignIn getInstance() {
        return CLICK_SIGN_IN;
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println("Show sign in page");
    }
}
