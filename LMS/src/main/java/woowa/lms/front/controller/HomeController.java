package woowa.lms.front.controller;

import woowa.lms.front.ui.dialog.error.SignInErrorDialog;
import woowa.lms.front.ui.dialog.error.SignUpErrorDialog;
import woowa.lms.front.ui.dialog.prompt.ExitDialog;
import woowa.lms.front.ui.dialog.prompt.SignOutDialog;
import woowa.lms.front.ui.dialog.success.SignUpSuccessfulDialog;
import woowa.lms.front.ui.form.SignInForm;
import woowa.lms.front.ui.form.SignUpForm;
import woowa.lms.front.ui.page.AboutPage;
import woowa.lms.front.ui.page.MainPage;
import woowa.lms.front.ui.table.BookTable;

import static javafx.stage.Modality.WINDOW_MODAL;

//@Controller
public class HomeController {

    private static final MainPage MAIN_PAGE = MainPage.PAGE;
    private static final AboutPage ABOUT_PAGE = AboutPage.PAGE;
    private static final SignUpForm SIGN_UP_FORM = SignUpForm.FORM;
    private static final SignInForm SIGN_IN_FORM = SignInForm.FORM;
    private static final BookTable BOOK_TABLE = BookTable.getInstance();

    private static final HomeController CONTROLLER = new HomeController();

    private HomeController() {
        setModality();
    }

    public static HomeController getController() {
        return CONTROLLER;
    }

    private void setModality() {
        ABOUT_PAGE.initModality(WINDOW_MODAL);
        ABOUT_PAGE.initOwner(MAIN_PAGE);
        SIGN_UP_FORM.initModality(WINDOW_MODAL);
        SIGN_UP_FORM.initOwner(MAIN_PAGE);
        SIGN_IN_FORM.initModality(WINDOW_MODAL);
        SIGN_IN_FORM.initOwner(MAIN_PAGE);
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

    public void showSignUpForm() {
        SIGN_UP_FORM.show();
    }

    public void showSignUpSuccessfulDialog() {
        SignUpSuccessfulDialog.getDialog().show();
    }

    public void showSignUpErrorDialog() {
        SignUpErrorDialog.getDialog().show();
    }

    public void showSignInForm() {
        SIGN_IN_FORM.show();
    }

    public void showSignInErrorDialog(String errorMessage) {
        SignInErrorDialog.getDialog().setErrorMessage(errorMessage);
        SignInErrorDialog.getDialog().show();
    }

    public void showSignOutDialog() {
        SignOutDialog.getDialog().show();
    }

    public void showBookTable() {
        BOOK_TABLE.show();
    }

    public void closeAboutPage() {
        ABOUT_PAGE.close();
    }

    public void closeSignUpForm() {
        SIGN_UP_FORM.clear();
        SIGN_UP_FORM.close();
    }

    public void closeSignInForm() {
        SIGN_IN_FORM.clear();
        SIGN_IN_FORM.close();
    }

    public void showExitDialog() {
        ExitDialog.getDialog().show();
    }

}
