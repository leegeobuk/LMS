package woowa.lms.front.component.button.behavior;

import javafx.scene.input.MouseEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.controller.HomeController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Close implements Behavior {

    private static final Close INSTANCE = new Close();

    public static Close getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(MouseEvent event) {
        HomeController.closeSignUpForm();
    }
}
