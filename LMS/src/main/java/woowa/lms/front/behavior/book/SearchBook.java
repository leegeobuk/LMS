package woowa.lms.front.behavior.book;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.domain.item.Book;
import woowa.lms.back.search.BookSearchCriteria;
import woowa.lms.back.service.item.BookService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.MainController;
import woowa.lms.front.model.BookModel;
import woowa.lms.front.ui.form.book.SearchBookForm;
import woowa.lms.front.ui.table.BookTable;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchBook implements Behavior {

    private BookService bookService = SpringContext.getBean(BookService.class);

    private static final SearchBook INSTANCE = new SearchBook();

    public static SearchBook getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        List<TextField> fields = SearchBookForm.getForm().getFields();
        String title = fields.get(0).getText();
        String author = fields.get(1).getText();
        BookSearchCriteria criteria = new BookSearchCriteria(title, author);
        List<Book> books = bookService.search(criteria);
        List<BookModel> bookModels = books
            .stream().map(BookModel::new).collect(toUnmodifiableList());
        BookTable.getTable().getTableView().getItems().setAll(bookModels);
        MainController.getController().close(event);
    }
}
