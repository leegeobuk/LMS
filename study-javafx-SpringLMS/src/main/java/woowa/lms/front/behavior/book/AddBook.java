package woowa.lms.front.behavior.book;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.item.BookFormController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddBook implements Behavior {

    private static final AddBook INSTANCE = new AddBook();

    public static AddBook getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        BookFormController.getController().addBookAndClose(event);
    }
}
