package woowa.lms.front.controller;

import javafx.stage.Stage;
import woowa.lms.front.ui.dialog.home.ExitDialog;
import woowa.lms.front.ui.dialog.home.SignInErrorDialog;
import woowa.lms.front.ui.dialog.home.SignUpErrorDialog;
import woowa.lms.front.ui.dialog.home.SignUpSuccessfulDialog;
import woowa.lms.front.ui.form.SignInForm;
import woowa.lms.front.ui.form.SignUpForm;
import woowa.lms.front.ui.page.AboutPage;
import woowa.lms.front.ui.page.MainPage;

import static javafx.stage.Modality.WINDOW_MODAL;

//@Controller
public class HomeController {

    private Stage homeStage;
    private Stage aboutStage;
    private Stage signUpStage;
    private Stage signInStage;

    private static final MainPage MAIN_PAGE = MainPage.INSTANCE;
    private static final AboutPage ABOUT_PAGE = AboutPage.INSTANCE;
    private static final SignUpForm SIGN_UP_FORM = SignUpForm.INSTANCE;
    private static final SignInForm SIGN_IN_FORM = SignInForm.INSTANCE;

    private static final HomeController CONTROLLER = new HomeController();

    private HomeController() {
        homeStage = MAIN_PAGE.getStage();
        aboutStage = ABOUT_PAGE.getStage();
        signUpStage = SIGN_UP_FORM.getStage();
        signInStage = SIGN_IN_FORM.getStage();

        setModality();
    }

    public static HomeController getController() {
        return CONTROLLER;
    }

    private void setModality() {
        aboutStage.initModality(WINDOW_MODAL);
        aboutStage.initOwner(homeStage);
        signUpStage.initModality(WINDOW_MODAL);
        signUpStage.initOwner(homeStage);
        signInStage.initModality(WINDOW_MODAL);
        signInStage.initOwner(homeStage);
    }

    public void showMainPage() {
        homeStage.show();
    }

    public void showAboutPage() {
        aboutStage.show();
    }

    public void showSignUpForm() {
        signUpStage.show();
    }

    public void showSignUpSuccessfulDialog() {
        SignUpSuccessfulDialog.getDialog().show();
    }

    public void showSignUpErrorDialog() {
        SignUpErrorDialog.getDialog().show();
    }

    public void closeSignUpForm() {
        SIGN_UP_FORM.clear();
        SIGN_UP_FORM.getStage().close();
    }

    public void showSignInForm() {
        signInStage.show();
    }

    public void showSignInErrorDialog(String errorMessage) {
        SignInErrorDialog.getDialog().setErrorMessage(errorMessage);
        SignInErrorDialog.getDialog().show();
    }

    public void closeSignInForm() {
        SIGN_IN_FORM.clear();
        SIGN_IN_FORM.getStage().close();
    }

    public void showExitDialog() {
        ExitDialog.getDialog().show();
    }

}
