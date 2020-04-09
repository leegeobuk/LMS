package woowa.lms.front.controller.item;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.model.BookModel;
import woowa.lms.front.ui.form.book.AddBookForm;
import woowa.lms.front.ui.form.book.EditBookForm;
import woowa.lms.front.ui.form.book.LendBookForm;
import woowa.lms.front.ui.form.book.SearchBookForm;
import woowa.lms.front.ui.table.BookTable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemFormController {

    private static final BookTable BOOK_TABLE = BookTable.getTable();

    private static final AddBookForm ADD_BOOK_FORM = AddBookForm.getForm();
    private static final EditBookForm EDIT_BOOK_FORM = EditBookForm.getForm();
    private static final LendBookForm LEND_BOOK_FORM = LendBookForm.getForm();
    private static final SearchBookForm SEARCH_BOOK_FORM = SearchBookForm.getForm();

    private static final ItemFormController CONTROLLER = new ItemFormController();

    public static ItemFormController getController() {
        return CONTROLLER;
    }

    public void showAddBookForm() {
        ADD_BOOK_FORM.show();
    }

    public void showEditBookForm() {
        BookModel selected = BOOK_TABLE.getSelected();
        EDIT_BOOK_FORM.getFields().get(0).setText(selected.getTitle());
        EDIT_BOOK_FORM.getFields().get(1).setText(selected.getAuthor());
        EDIT_BOOK_FORM.getFields().get(2).setText(Integer.toString(selected.getStock()));
        EDIT_BOOK_FORM.show();
    }

    public void showLendBookForm() {
        LEND_BOOK_FORM.show();
    }

    public void showSearchBookForm() {
        SEARCH_BOOK_FORM.show();
    }
}
