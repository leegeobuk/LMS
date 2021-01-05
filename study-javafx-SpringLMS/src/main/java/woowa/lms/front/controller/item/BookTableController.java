package woowa.lms.front.controller.item;

import woowa.lms.back.domain.item.Book;
import woowa.lms.back.service.item.BookService;
import woowa.lms.back.util.ListConverter;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.model.BookModel;
import woowa.lms.front.ui.table.BookTable;

import java.util.List;

public class BookTableController {

    private BookService bookService = SpringContext.getBean(BookService.class);

    private static final BookTable BOOK_TABLE = BookTable.getTable();

    private static final BookTableController CONTROLLER = new BookTableController();

    public static BookTableController getController() {
        return CONTROLLER;
    }

    public void showBookTable() {
        List<Book> books = bookService.findAll();
        List<BookModel> bookModels = ListConverter.toBookModels(books);
        BOOK_TABLE.update(bookModels);
        BOOK_TABLE.show();
    }

    public void viewAllBooks() {
        List<Book> books = bookService.findAll();
        List<BookModel> bookModels = ListConverter.toBookModels(books);
        BOOK_TABLE.update(bookModels);
    }

    public void deleteBook() {
        BookModel selected = BOOK_TABLE.getSelected();
        bookService.delete(selected.getId());
        viewAllBooks();
    }
}
