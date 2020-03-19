package woowa.lms.back.controller;

import javafx.stage.Stage;
import woowa.lms.front.ui.dialog.ExitDialog;
import woowa.lms.front.ui.form.SignUpForm;
import woowa.lms.front.ui.page.AboutPage;
import woowa.lms.front.ui.page.MainPage;

import static javafx.stage.Modality.WINDOW_MODAL;

//@Controller
public class HomeController {

    private static Stage homeStage;
    private static Stage aboutStage;
    private static Stage signUpStage;

    private static final MainPage MAIN_PAGE = MainPage.INSTANCE;
    private static final AboutPage ABOUT_PAGE = AboutPage.INSTANCE;
    private static final SignUpForm SIGN_UP_FORM = SignUpForm.INSTANCE;

    public static void showMainPage() {
        homeStage = MAIN_PAGE.getStage();
        homeStage.show();
    }

    public static void showAboutPage() {
        aboutStage = ABOUT_PAGE.getStage();
        aboutStage.initModality(WINDOW_MODAL);
        aboutStage.initOwner(homeStage);
        aboutStage.show();
    }

    public static void showSignUpForm() {
        signUpStage = SIGN_UP_FORM.getStage();
        signUpStage.initModality(WINDOW_MODAL);
        signUpStage.initOwner(homeStage);
        signUpStage.show();
    }

    public static void closeSignUpForm() {
        signUpStage.close();
    }

    public static void showSingInForm() {

    }

    public static void showExitDialog() {
        ExitDialog.ALERT.show();
    }

}
