package woowa.lms.front.components.button.behavior;

import javafx.scene.input.MouseEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.controller.HomeController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClickAbout implements ClickBehavior {

    private static final ClickAbout CLICK_ABOUT = new ClickAbout();

    public static ClickAbout getInstance() {
        return CLICK_ABOUT;
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println("About clicked");
        HomeController.showAboutPage();
    }
}