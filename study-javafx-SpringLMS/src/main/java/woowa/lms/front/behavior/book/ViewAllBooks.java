package woowa.lms.front.behavior.book;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.item.BookTableController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ViewAllBooks implements Behavior {

    private static final ViewAllBooks INSTANCE = new ViewAllBooks();

    public static ViewAllBooks getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        BookTableController.getController().viewAllBooks();
    }
}
