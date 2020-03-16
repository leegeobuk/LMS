package woowa.lms.back.controller;

import javafx.stage.Stage;
import org.springframework.stereotype.Controller;
import woowa.lms.front.page.dialog.ExitDialog;
import woowa.lms.front.page.home.AboutPage;
import woowa.lms.front.page.home.MainPage;

import static javafx.stage.Modality.WINDOW_MODAL;

@Controller
public class HomeController {

    private static Stage homeStage;

    private static final MainPage MAIN_PAGE = MainPage.INSTANCE;
    private static final AboutPage ABOUT_PAGE = AboutPage.INSTANCE;

    public static void showMainPage() {
        homeStage = MAIN_PAGE.getStage();
        homeStage.show();
    }

    public static void showAboutPage() {
        Stage aboutStage = ABOUT_PAGE.getStage();
        aboutStage.initModality(WINDOW_MODAL);
        aboutStage.initOwner(homeStage);
        aboutStage.show();
    }

    public static void showExitDialog() {
        ExitDialog.ALERT.show();
    }

}
