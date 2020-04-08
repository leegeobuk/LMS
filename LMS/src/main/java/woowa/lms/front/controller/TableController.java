package woowa.lms.front.controller;

import woowa.lms.back.domain.account.User;
import woowa.lms.back.service.RentalService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.model.BookModel;
import woowa.lms.front.ui.page.MainPage;
import woowa.lms.front.ui.table.BookTable;
import woowa.lms.front.ui.table.UserTable;

import java.util.List;

import static javafx.stage.Modality.WINDOW_MODAL;

public class TableController {

    private RentalService rentalService = SpringContext.getBean(RentalService.class);

    private static final MainPage MAIN_PAGE = MainPage.PAGE;
    private static final BookTable BOOK_TABLE = BookTable.getInstance();
    private static final UserTable USER_TABLE = UserTable.getInstance();

    private static final TableController CONTROLLER = new TableController();

    public TableController() {
        setModality();
    }

    public static TableController getController() {
        return CONTROLLER;
    }

    private void setModality() {
        BOOK_TABLE.initModality(WINDOW_MODAL);
        BOOK_TABLE.initOwner(MAIN_PAGE);
        USER_TABLE.initModality(WINDOW_MODAL);
        USER_TABLE.initOwner(MAIN_PAGE);
    }

    public void showBookTable() {
        BOOK_TABLE.update();
        BOOK_TABLE.show();
    }

    public void updateBookTable() {
        BOOK_TABLE.update();
    }

    public void showUserTable() {
        USER_TABLE.update();
        USER_TABLE.show();
    }

    public void showUserTableSelectionMode() {
        showUserTable();
        USER_TABLE.setToSelectionMode(true);
    }

    public void showUnreturnedUserTable() {
        BookModel selected = BOOK_TABLE.getSelected();
        List<User> users = rentalService.searchUnreturnedUser(selected.getId());
        USER_TABLE.showUsers(users);
        USER_TABLE.setToReturnMode();
        USER_TABLE.show();
    }
}
