package woowa.lms.front.controller.account;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.account.Admin;
import woowa.lms.back.domain.account.User;
import woowa.lms.back.search.AccountSearchCriteria;
import woowa.lms.back.service.account.AccountService;
import woowa.lms.back.util.ListConverter;
import woowa.lms.back.util.SpringContext;
import woowa.lms.back.util.Token;
import woowa.lms.front.controller.MainController;
import woowa.lms.front.model.AccountModel;
import woowa.lms.front.ui.form.main.MainSignUpForm;
import woowa.lms.front.ui.form.main.SignInForm;
import woowa.lms.front.ui.form.user.AddUserForm;
import woowa.lms.front.ui.form.user.EditUserForm;
import woowa.lms.front.ui.form.user.SearchUserForm;
import woowa.lms.front.ui.table.UserTable;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountFormController {

    private AccountService accountService = SpringContext.getBean(AccountService.class);

    private static final UserTable USER_TABLE = UserTable.getTable();

    private static final MainSignUpForm SIGN_UP_FORM = MainSignUpForm.getForm();
    private static final SignInForm SIGN_IN_FORM = SignInForm.getForm();

    private static final AddUserForm ADD_USER_FORM = AddUserForm.getForm();
    private static final EditUserForm EDIT_USER_FORM = EditUserForm.getForm();
    private static final SearchUserForm SEARCH_USER_FORM = SearchUserForm.getForm();

    private static final AccountFormController CONTROLLER = new AccountFormController();
    private static final UserTableController TABLE_CONTROLLER = UserTableController.getController();
    private static final MainController MAIN_CONTROLLER = MainController.getController();
    private static final AccountDialogController DIALOG_CONTROLLER = AccountDialogController.getController();

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
        } catch (IllegalStateException e) {
            DIALOG_CONTROLLER.showSignUpErrorDialog();
        }
        DIALOG_CONTROLLER.showSignUpSuccessfulDialog();
        MAIN_CONTROLLER.close(event);
    }

    public void signInAndClose(ActionEvent event) {
        List<TextField> fields = SIGN_IN_FORM.getFields();
        String id = fields.get(0).getText();
        String pw = fields.get(1).getText();
        Admin admin = Admin.of(id, pw);
        try {
            Account account = accountService.signInAccount(admin);
            Token.getToken().signIn(account);
            MAIN_CONTROLLER.redrawMainPage();
            MAIN_CONTROLLER.close(event);
        } catch (IllegalStateException e) {
            DIALOG_CONTROLLER.showSignInErrorDialog(e.getMessage());
        }
    }

    public void addUserAndClose(ActionEvent event) {
        List<TextField> fields = ADD_USER_FORM.getFields();
        String id = fields.get(0).getText();
        String pw = fields.get(1).getText();
        String name = fields.get(3).getText();
        String contact = fields.get(4).getText();
        User user = User.of(id, pw, name, contact);
        try {
            accountService.signUpAccount(user);
            TABLE_CONTROLLER.viewAllUsers();
            MAIN_CONTROLLER.close(event);
        } catch (IllegalStateException e) {
            DIALOG_CONTROLLER.showSignUpErrorDialog();
        }
    }

    public void editUserAndClose(ActionEvent event) {
        AccountModel selected = USER_TABLE.getSelected();
        List<TextField> fields = EDIT_USER_FORM.getFields();
        String name = fields.get(0).getText();
        String contact = fields.get(1).getText();
        accountService.editAccount(selected.getId(), name, contact);
        TABLE_CONTROLLER.viewAllUsers();
        MAIN_CONTROLLER.close(event);
    }

    public void searchUserAndClose(ActionEvent event) {
        List<TextField> fields = SEARCH_USER_FORM.getFields();
        String id = fields.get(0).getText();
        String name = fields.get(1).getText();
        String contact = fields.get(2).getText();
        AccountSearchCriteria criteria = new AccountSearchCriteria(id, name, contact);
        List<Account> accounts = accountService.search(criteria);
        List<AccountModel> accountModels = ListConverter.toAccountModels(accounts);
        USER_TABLE.update(accountModels);
        MAIN_CONTROLLER.close(event);
    }
}
