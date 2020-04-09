package woowa.lms.front.controller.account;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.account.Admin;
import woowa.lms.back.service.account.AccountService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.back.util.Token;
import woowa.lms.front.controller.MainController;
import woowa.lms.front.model.AccountModel;
import woowa.lms.front.ui.form.main.MainSignUpForm;
import woowa.lms.front.ui.form.main.SignInForm;
import woowa.lms.front.ui.form.user.AddUserForm;
import woowa.lms.front.ui.form.user.EditUserForm;
import woowa.lms.front.ui.form.user.SearchUserForm;
import woowa.lms.front.ui.page.MainPage;
import woowa.lms.front.ui.table.UserTable;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountFormController {

    private AccountService accountService = SpringContext.getBean(AccountService.class);

    private static final UserTable USER_TABLE = UserTable.getInstance();

    private static final MainSignUpForm SIGN_UP_FORM = MainSignUpForm.getForm();
    private static final SignInForm SIGN_IN_FORM = SignInForm.getForm();

    private static final AddUserForm ADD_USER_FORM = AddUserForm.getForm();
    private static final EditUserForm EDIT_USER_FORM = EditUserForm.getForm();
    private static final SearchUserForm SEARCH_USER_FORM = SearchUserForm.getForm();

    private static final AccountFormController CONTROLLER = new AccountFormController();
    private static final AccountDialogController DIALOG_CONTROLLER = AccountDialogController.getController();
    private static final MainController MAIN_CONTROLLER = MainController.getController();

    public static AccountFormController getController() {
        return CONTROLLER;
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
        AccountModel selected = USER_TABLE.getSelected();
        EDIT_USER_FORM.getFields().get(0).setText(selected.getName());
        EDIT_USER_FORM.getFields().get(1).setText(selected.getContact());
        EDIT_USER_FORM.show();
    }

    public void showSearchUserForm() {
        SEARCH_USER_FORM.show();
    }

    public void signUpAndClose(ActionEvent event) {
        List<TextField> fields = SIGN_UP_FORM.getFields();
        String id = fields.get(0).getText();
        String pw = fields.get(1).getText();
        String name = fields.get(3).getText();
        String contact = fields.get(4).getText();
        Admin admin = Admin.of(id, pw, name, contact);
        try {
            accountService.signUpAccount(admin);
            DIALOG_CONTROLLER.showSignUpSuccessfulDialog();
            MAIN_CONTROLLER.close(event);
        } catch (IllegalStateException e) {
            DIALOG_CONTROLLER.showSignUpErrorDialog();
        }
    }

    public void signInAndClose(ActionEvent event) {
        SignInForm form = SignInForm.getForm();
        List<TextField> fields = form.getFields();
        String id = fields.get(0).getText();
        String pw = fields.get(1).getText();
        Admin admin = Admin.of(id, pw);
        try {
            Account account = accountService.signInAccount(admin);
            Token.getToken().signIn(account);
        } catch (IllegalStateException e) {
            DIALOG_CONTROLLER.showSignInErrorDialog(e.getMessage());
        }
        MAIN_CONTROLLER.redrawMainPage();
        MAIN_CONTROLLER.close(event);
    }
}
