package woowa.lms.front.controller;

import javafx.scene.control.TextField;
import woowa.lms.front.behavior.user.EditUser;
import woowa.lms.front.behavior.user.SearchUser;
import woowa.lms.front.model.AccountModel;
import woowa.lms.front.ui.form.main.MainSignUpForm;
import woowa.lms.front.ui.form.main.SignInForm;
import woowa.lms.front.ui.form.user.AddUserForm;
import woowa.lms.front.ui.form.user.EditUserForm;
import woowa.lms.front.ui.form.user.SearchUserForm;
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
    private static final SearchUserForm SEARCH_USER_FORM = SearchUserForm.FORM;

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
        SEARCH_USER_FORM.initModality(WINDOW_MODAL);
        SEARCH_USER_FORM.initOwner(USER_TABLE);

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
        AccountModel selected = USER_TABLE.getTable().getSelectionModel().getSelectedItem();
        EDIT_USER_FORM.setSelected(selected);
        EDIT_USER_FORM.getFields().get(0).setText(selected.getName());
        EDIT_USER_FORM.getFields().get(1).setText(selected.getContact());
        EDIT_USER_FORM.show();
    }

    public void showSearchUserForm() {
        SEARCH_USER_FORM.show();
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

    public void closeSearchUserForm() {
        SEARCH_USER_FORM.clear();
        SEARCH_USER_FORM.hide();
    }
}
