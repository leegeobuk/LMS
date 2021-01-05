package woowa.lms.front.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.ui.dialog.prompt.ExitDialog;
import woowa.lms.front.ui.page.AboutPage;
import woowa.lms.front.ui.page.MainPage;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MainController {

    private static final MainPage MAIN_PAGE = MainPage.getPage();
    private static final AboutPage ABOUT_PAGE = AboutPage.getPage();

    private static final MainController CONTROLLER = new MainController();

    public static MainController getController() {
        return CONTROLLER;
    }

    public void showMainPage() {
        MAIN_PAGE.show();
    }

    public void redrawMainPage() {
        MAIN_PAGE.redraw();
        MAIN_PAGE.show();
    }

    public void showAboutPage() {
        ABOUT_PAGE.show();
    }

    public void showExitDialog() {
        ExitDialog.getDialog().show();
    }

    public void close(ActionEvent event) {
        Button button = (Button) event.getSource();
        ((Stage) button.getScene().getWindow()).close();
    }
}
