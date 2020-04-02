package woowa.lms.front.controller;

import woowa.lms.front.ui.dialog.error.SignInErrorDialog;
import woowa.lms.front.ui.dialog.error.SignUpErrorDialog;
import woowa.lms.front.ui.dialog.prompt.ExitDialog;
import woowa.lms.front.ui.dialog.prompt.SignOutDialog;
import woowa.lms.front.ui.dialog.success.SignUpSuccessfulDialog;

public class DialogController {

    private static final DialogController CONTROLLER = new DialogController();

    private DialogController() {

    }

    public static DialogController getController() {
        return CONTROLLER;
    }

    public void showSignUpSuccessfulDialog() {
        SignUpSuccessfulDialog.getDialog().show();
    }

    public void showSignUpErrorDialog() {
        SignUpErrorDialog.getDialog().show();
    }

    public void showSignInErrorDialog(String errorMessage) {
        SignInErrorDialog.getDialog().setErrorMessage(errorMessage);
        SignInErrorDialog.getDialog().show();
    }

    public void showSignOutDialog() {
        SignOutDialog.getDialog().show();
    }

    public void showExitDialog() {
        ExitDialog.getDialog().show();
    }
}
