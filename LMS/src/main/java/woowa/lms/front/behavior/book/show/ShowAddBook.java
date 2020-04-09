package woowa.lms.front.behavior.book.show;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.item.ItemFormController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowAddBook implements Behavior {

    private static final ShowAddBook INSTANCE = new ShowAddBook();

    public static ShowAddBook getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        ItemFormController.getController().showAddBookForm();
    }
}
