package woowa.lms.front.behavior.book;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.service.item.BookService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.TableController;
import woowa.lms.front.model.BookModel;
import woowa.lms.front.ui.table.BookTable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DeleteBook implements Behavior {

    private BookService bookService = SpringContext.getBean(BookService.class);

    private static final DeleteBook INSTANCE = new DeleteBook();

    public static DeleteBook getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        BookModel selected = BookTable.getInstance().getTable().getSelectionModel().getSelectedItem();
        bookService.delete(selected.getId());
        TableController.getController().updateBookTable();
    }
}
