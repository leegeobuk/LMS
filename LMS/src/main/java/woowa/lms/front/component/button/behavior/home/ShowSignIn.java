package woowa.lms.front.component.button.behavior.home;

import javafx.scene.input.MouseEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.component.button.behavior.Behavior;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowSignIn implements Behavior {

    private static final ShowSignIn CLICK_SIGN_IN = new ShowSignIn();

    public static ShowSignIn getInstance() {
        return CLICK_SIGN_IN;
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println("Show sign in page");
    }
}
