package woowa.lms.front.controller.item;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.domain.item.Book;
import woowa.lms.back.search.BookSearchCriteria;
import woowa.lms.back.service.RentalService;
import woowa.lms.back.service.item.BookService;
import woowa.lms.back.util.ListConverter;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.controller.MainController;
import woowa.lms.front.model.AccountModel;
import woowa.lms.front.model.BookModel;
import woowa.lms.front.ui.form.book.AddBookForm;
import woowa.lms.front.ui.form.book.EditBookForm;
import woowa.lms.front.ui.form.book.LendBookForm;
import woowa.lms.front.ui.form.book.SearchBookForm;
import woowa.lms.front.ui.table.BookTable;
import woowa.lms.front.ui.table.UserTable;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookFormController {

    private BookService bookService = SpringContext.getBean(BookService.class);
    private RentalService rentalService = SpringContext.getBean(RentalService.class);

    private static final BookTable BOOK_TABLE = BookTable.getTable();
    private static final UserTable USER_TABLE = UserTable.getTable();

    private static final AddBookForm ADD_BOOK_FORM = AddBookForm.getForm();
    private static final EditBookForm EDIT_BOOK_FORM = EditBookForm.getForm();
    private static final LendBookForm LEND_BOOK_FORM = LendBookForm.getForm();
    private static final SearchBookForm SEARCH_BOOK_FORM = SearchBookForm.getForm();

    private static final BookFormController CONTROLLER = new BookFormController();
    private static final BookTableController TABLE_CONTROLLER = BookTableController.getController();
    private static final MainController MAIN_CONTROLLER = MainController.getController();

    public static BookFormController getController() {
        return CONTROLLER;
    }

    public void showAddBookForm() {
        ADD_BOOK_FORM.show();
    }

    public void showEditBookForm() {
        BookModel selected = BOOK_TABLE.getSelected();
        List<TextField> fields = EDIT_BOOK_FORM.getFields();
        fields.get(0).setText(selected.getTitle());
        fields.get(1).setText(selected.getAuthor());
        fields.get(2).setText(Integer.toString(selected.getStock()));
        EDIT_BOOK_FORM.show();
    }

    public void showLendBookForm() {
        LEND_BOOK_FORM.show();
    }

    public void showSearchBookForm() {
        SEARCH_BOOK_FORM.show();
    }

    public void addBookAndClose(ActionEvent event) {
        List<TextField> fields = ADD_BOOK_FORM.getFields();
        String title = fields.get(0).getText();
        String author = fields.get(1).getText();
        int stock = Integer.parseInt(fields.get(2).getText());
        Book book = Book.of(title, author, stock);
        bookService.save(book);
        TABLE_CONTROLLER.viewAllBooks();
        MAIN_CONTROLLER.close(event);
    }

    public void editBookAndClose(ActionEvent event) {
        BookModel selected = BOOK_TABLE.getSelected();
        List<TextField> fields = EDIT_BOOK_FORM.getFields();
        String title = fields.get(0).getText();
        String author = fields.get(1).getText();
        int stock = Integer.parseInt(fields.get(2).getText());
        bookService.edit(selected.getId(), title, author, stock);
        TABLE_CONTROLLER.viewAllBooks();
        MAIN_CONTROLLER.close(event);
    }

    public void lendBookAndClose() {
        ObservableList<BookModel> selections = BOOK_TABLE.getSelections();
        List<Long> itemIds = new ArrayList<>();
        for (BookModel selection : selections) {
            itemIds.add(selection.getId());
        }
        String userId = LEND_BOOK_FORM.getFields().get(0).getText();
        rentalService.lendBooks(userId, itemIds);
        TABLE_CONTROLLER.viewAllBooks();
        LEND_BOOK_FORM.close();
    }

    public void returnBookAndClose() {
        AccountModel selectedUser = USER_TABLE.getSelected();
        BookModel selectedItem = BOOK_TABLE.getSelected();
        rentalService.returnBooks(selectedUser.getId(), selectedItem.getId());
        TABLE_CONTROLLER.viewAllBooks();
        USER_TABLE.close();
    }

    public void searchBookAndClose(ActionEvent event) {
        List<TextField> fields = SEARCH_BOOK_FORM.getFields();
        String title = fields.get(0).getText();
        String author = fields.get(1).getText();
        BookSearchCriteria criteria = new BookSearchCriteria(title, author);
        List<Book> books = bookService.search(criteria);
        List<BookModel> bookModels = ListConverter.toBookModels(books);
        BOOK_TABLE.update(bookModels);
        MAIN_CONTROLLER.close(event);
    }
}
