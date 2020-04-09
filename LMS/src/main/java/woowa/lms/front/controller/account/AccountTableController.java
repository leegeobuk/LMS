package woowa.lms.front.controller.account;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.domain.account.User;
import woowa.lms.back.service.RentalService;
import woowa.lms.back.service.account.AccountService;
import woowa.lms.back.util.ListConverter;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.model.AccountModel;
import woowa.lms.front.model.BookModel;
import woowa.lms.front.ui.table.BookTable;
import woowa.lms.front.ui.table.UserTable;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountTableController {

    private AccountService accountService = SpringContext.getBean(AccountService.class);
    private RentalService rentalService = SpringContext.getBean(RentalService.class);

    private static final BookTable BOOK_TABLE = BookTable.getTable();
    private static final UserTable USER_TABLE = UserTable.getInstance();

    private static final AccountTableController CONTROLLER = new AccountTableController();

    public static AccountTableController getController() {
        return CONTROLLER;
    }

    public void showUserTable() {
        List<User> users = accountService.findUsers();
        List<AccountModel> userModels = ListConverter.toAccountModels(users);
        USER_TABLE.update(userModels);
        USER_TABLE.show();
    }

    public void showUserTableSelectionMode() {
        showUserTable();
        USER_TABLE.setToSelectionMode(true);
    }

    public void showBorrowedUserTable() {
        BookModel selected = BOOK_TABLE.getSelected();
        List<User> users = rentalService.searchBorrowedUser(selected.getId());
        List<AccountModel> userModels = ListConverter.toAccountModels(users);
        USER_TABLE.update(userModels);
        USER_TABLE.setToReturnMode();
        USER_TABLE.show();
    }
}
