package woowa.lms.front.component.button.behavior.home;

import javafx.scene.input.MouseEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.controller.HomeController;
import woowa.lms.front.component.button.behavior.Behavior;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowAbout implements Behavior {

    private static final ShowAbout CLICK_ABOUT = new ShowAbout();

    public static ShowAbout getInstance() {
        return CLICK_ABOUT;
    }

    @Override
    public void handle(MouseEvent event) {
        HomeController.showAboutPage();
    }
}