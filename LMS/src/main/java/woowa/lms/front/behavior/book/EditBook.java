package woowa.lms.front.behavior.book;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.service.item.BookService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.MainController;
import woowa.lms.front.controller.item.ItemTableController;
import woowa.lms.front.model.BookModel;
import woowa.lms.front.ui.form.book.EditBookForm;
import woowa.lms.front.ui.table.BookTable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EditBook implements Behavior {

    private BookService bookService = SpringContext.getBean(BookService.class);

    private static final EditBook INSTANCE = new EditBook();

    public static EditBook getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        BookModel selected = BookTable.getTable().getSelected();
        EditBookForm editBookForm = EditBookForm.getForm();
        String title = editBookForm.getFields().get(0).getText();
        String author = editBookForm.getFields().get(1).getText();
        int stock = Integer.parseInt(editBookForm.getFields().get(2).getText());
        bookService.edit(selected.getId(), title, author, stock);
        ItemTableController.getController().updateBookTable();
        MainController.getController().close(event);
    }
}
