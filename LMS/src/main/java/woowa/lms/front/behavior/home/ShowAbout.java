package woowa.lms.front.behavior.home;

import javafx.scene.input.MouseEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.controller.HomeController;
import woowa.lms.front.behavior.Behavior;

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