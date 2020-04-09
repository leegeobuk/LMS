package woowa.lms.front.behavior.book;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.domain.item.Book;
import woowa.lms.back.service.item.BookService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.MainController;
import woowa.lms.front.ui.form.book.AddBookForm;
import woowa.lms.front.ui.table.BookTable;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddBook implements Behavior {

    private BookService bookService = SpringContext.getBean(BookService.class);

    private static final AddBook INSTANCE = new AddBook();

    public static AddBook getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        List<TextField> fields = AddBookForm.getForm().getFields();
        String title = fields.get(0).getText();
        String author = fields.get(1).getText();
        int stock = Integer.parseInt(fields.get(2).getText());
        Book book = Book.of(title, author, stock);
        bookService.save(book);
        BookTable.getTable().update();
        MainController.getController().close(event);
    }
}
