package woowa.lms.front.behavior.book;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.service.item.BookService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.TableController;
import woowa.lms.front.model.BookModel;
import woowa.lms.front.ui.form.book.EditBookForm;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EditBook implements Behavior {

    private BookService bookService = SpringContext.getBean(BookService.class);

    private static final EditBook INSTANCE = new EditBook();

    public static EditBook getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        BookModel selected = EditBookForm.FORM.getSelected();
        String title = EditBookForm.FORM.getFields().get(0).getText();
        String author = EditBookForm.FORM.getFields().get(1).getText();
        int stock = Integer.parseInt(EditBookForm.FORM.getFields().get(2).getText());
        bookService.edit(selected.getId(), title, author, stock);
        TableController.getController().updateBookTable();
        Behavior.super.closeForm(event);
    }
}
