package woowa.lms.front.controller;

import woowa.lms.front.behavior.user.EditUser;
import woowa.lms.front.ui.form.main.MainSignUpForm;
import woowa.lms.front.ui.form.main.SignInForm;
import woowa.lms.front.ui.form.user.AddUserForm;
import woowa.lms.front.ui.form.user.EditUserForm;
import woowa.lms.front.ui.page.MainPage;
import woowa.lms.front.ui.table.BookTable;
import woowa.lms.front.ui.table.UserTable;

import static javafx.stage.Modality.WINDOW_MODAL;

public class FormController {

    private static final MainPage MAIN_PAGE = MainPage.PAGE;
    private static final BookTable BOOK_TABLE = BookTable.getInstance();
    private static final UserTable USER_TABLE = UserTable.getInstance();

    private static final MainSignUpForm SIGN_UP_FORM = MainSignUpForm.FORM;
    private static final SignInForm SIGN_IN_FORM = SignInForm.FORM;
    private static final AddUserForm ADD_USER_FORM = AddUserForm.FORM;
    private static final EditUserForm EDIT_USER_FORM = EditUserForm.FORM;

    private static final FormController CONTROLLER = new FormController();

    public FormController() {
        setModality();
    }

    public static FormController getController() {
        return CONTROLLER;
    }

    private void setModality() {
        SIGN_UP_FORM.initModality(WINDOW_MODAL);
        SIGN_UP_FORM.initOwner(MAIN_PAGE);
        SIGN_IN_FORM.initModality(WINDOW_MODAL);
        SIGN_IN_FORM.initOwner(MAIN_PAGE);

        ADD_USER_FORM.initModality(WINDOW_MODAL);
        ADD_USER_FORM.initOwner(USER_TABLE);
        EDIT_USER_FORM.initModality(WINDOW_MODAL);
        EDIT_USER_FORM.initOwner(USER_TABLE);

    }

    public void showSignUpForm() {
        SIGN_UP_FORM.show();
    }

    public void showSignInForm() {
        SIGN_IN_FORM.show();
    }

    public void showAddUserForm() {
        ADD_USER_FORM.show();
    }

    public void showEditUserForm() {
        EDIT_USER_FORM.show();
    }

    public void closeSignUpForm() {
        SIGN_UP_FORM.clear();
        SIGN_UP_FORM.hide();
    }

    public void closeSignInForm() {
        SIGN_IN_FORM.clear();
        SIGN_IN_FORM.hide();
    }

    public void closeAddUserForm() {
        ADD_USER_FORM.clear();
        ADD_USER_FORM.hide();
    }

    public void closeEditUserForm() {
        EDIT_USER_FORM.clear();
        EDIT_USER_FORM.hide();
    }
}
