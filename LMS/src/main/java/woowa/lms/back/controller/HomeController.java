package woowa.lms.back.controller;

import javafx.stage.Stage;
import org.springframework.stereotype.Controller;
import woowa.lms.front.page.AboutPage;
import woowa.lms.front.page.MainPage;

import static javafx.stage.Modality.WINDOW_MODAL;

@Controller
public class HomeController {

    private static Stage homeStage;

    private static final MainPage MAIN_PAGE = MainPage.INSTANCE;
    private static final AboutPage ABOUT_PAGE = AboutPage.INSTANCE;

    public static void showMainPage() {
        homeStage = new Stage();
        homeStage.setScene(MAIN_PAGE.getScene());
        homeStage.setTitle("Woowa Library Management System");
        homeStage.show();
    }

    public static void showAboutPage() {
        Stage aboutStage = new Stage();
        aboutStage.setScene(ABOUT_PAGE.getScene());
        aboutStage.setTitle("About Page");
        aboutStage.initModality(WINDOW_MODAL);
        aboutStage.initOwner(homeStage);
        aboutStage.show();
    }

}
