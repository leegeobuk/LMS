package woowa.lms.front.controller;

import javafx.stage.Modality;
import woowa.lms.front.ui.page.MainPage;
import woowa.lms.front.ui.table.BookTable;
import woowa.lms.front.ui.table.CustomerTable;

import static javafx.stage.Modality.WINDOW_MODAL;

public class TableController {

    private static final MainPage MAIN_PAGE = MainPage.PAGE;
    private static final BookTable BOOK_TABLE = BookTable.getInstance();
    private static final CustomerTable CUSTOMER_TABLE = CustomerTable.getInstance();

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
        CUSTOMER_TABLE.initModality(WINDOW_MODAL);
        CUSTOMER_TABLE.initOwner(MAIN_PAGE);
    }

    public void showBookTable() {
        BOOK_TABLE.show();
    }

    public void showCustomerTable() {
        CUSTOMER_TABLE.show();
    }
}
