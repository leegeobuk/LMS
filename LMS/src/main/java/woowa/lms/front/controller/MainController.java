package woowa.lms.front.controller;

import woowa.lms.front.ui.page.AboutPage;
import woowa.lms.front.ui.page.MainPage;

import static javafx.stage.Modality.WINDOW_MODAL;

public class MainController {

    private static final MainPage MAIN_PAGE = MainPage.PAGE;
    private static final AboutPage ABOUT_PAGE = AboutPage.PAGE;

    private static final MainController CONTROLLER = new MainController();

    private MainController() {
        setModality();
    }

    public static MainController getController() {
        return CONTROLLER;
    }

    private void setModality() {
        ABOUT_PAGE.initModality(WINDOW_MODAL);
        ABOUT_PAGE.initOwner(MAIN_PAGE);
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

    public void closeAboutPage() {
        ABOUT_PAGE.close();
    }
}
