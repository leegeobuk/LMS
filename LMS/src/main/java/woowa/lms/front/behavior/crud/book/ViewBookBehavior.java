package woowa.lms.front.behavior.crud.book;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.domain.item.Book;
import woowa.lms.back.service.item.BookService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.model.BookModel;
import woowa.lms.front.ui.table.BookTable;

import java.util.List;

import static java.util.stream.Collectors.toList;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ViewBookBehavior implements Behavior {

    private BookService bookService = SpringContext.getBean(BookService.class);

    private static final ViewBookBehavior INSTANCE = new ViewBookBehavior();

    public static ViewBookBehavior getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        BookTable table = BookTable.getInstance();
        table.clear();
        List<Book> books = bookService.findAll();
        List<BookModel> bookModels = books.stream().map(BookModel::new).collect(toList());
        table.getTable().getItems().addAll(bookModels);
    }
}
