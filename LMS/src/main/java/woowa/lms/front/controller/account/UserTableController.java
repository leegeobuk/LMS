package woowa.lms.front.controller.account;

import javafx.scene.control.TextField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.domain.account.Account;
import woowa.lms.back.domain.account.User;
import woowa.lms.back.service.RentalService;
import woowa.lms.back.service.account.AccountService;
import woowa.lms.back.util.ListConverter;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.controller.item.BookFormController;
import woowa.lms.front.model.AccountModel;
import woowa.lms.front.model.BookModel;
import woowa.lms.front.ui.form.book.LendBookForm;
import woowa.lms.front.ui.table.BookTable;
import woowa.lms.front.ui.table.UserTable;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserTableController {

    private AccountService accountService = SpringContext.getBean(AccountService.class);
    private RentalService rentalService = SpringContext.getBean(RentalService.class);

    private static final UserTable USER_TABLE = UserTable.getTable();
    private static final BookTable BOOK_TABLE = BookTable.getTable();

    private static final LendBookForm LEND_BOOK_FORM = LendBookForm.getForm();

    private static final UserTableController CONTROLLER = new UserTableController();

    public static UserTableController getController() {
        return CONTROLLER;
    }

    public void showUserTable() {
        viewAllUsers();
        USER_TABLE.show();
    }

    public void showUserToLendTable() {
        showUserTable();
        USER_TABLE.getTableView().setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                selectUserToLend();
            }
        });
    }

    private void selectUserToLend() {
        AccountModel selected = USER_TABLE.getSelected();
        List<TextField> fields = LEND_BOOK_FORM.getFields();
        fields.get(0).setText(selected.getId());
        fields.get(1).setText(selected.getName());
        fields.get(2).setText(selected.getContact());
        LEND_BOOK_FORM.getOkButton().setDisable(false);
        USER_TABLE.close();
    }

    public void showBorrowedUserTable() {
        BookModel selected = BOOK_TABLE.getSelected();
        List<User> users = rentalService.searchBorrowedUser(selected.getId());
        List<AccountModel> userModels = ListConverter.toAccountModels(users);
        USER_TABLE.update(userModels);
        USER_TABLE.getTableView().setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                BookFormController.getController().returnBookAndClose();
            }
        });
        USER_TABLE.show();
    }

    public void viewAllUsers() {
        List<User> users = accountService.findUsers();
        List<AccountModel> accountModels = ListConverter.toAccountModels(users);
        USER_TABLE.update(accountModels);
    }

    public void deleteUser() {
        AccountModel selected = USER_TABLE.getSelected();
        accountService.deleteAccount(selected.getId());
        viewAllUsers();
    }
}
