package woowa.lms.front.behavior.main.show;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.MainController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowAbout implements Behavior {

    private static final ShowAbout CLICK_ABOUT = new ShowAbout();

    public static ShowAbout getInstance() {
        return CLICK_ABOUT;
    }

    @Override
    public void handle(ActionEvent event) {
        MainController.getController().showAboutPage();
    }
}