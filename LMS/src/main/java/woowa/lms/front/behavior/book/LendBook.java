package woowa.lms.front.behavior.book;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.item.BookFormController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LendBook implements Behavior {

    private static final LendBook INSTANCE = new LendBook();

    public static LendBook getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        BookFormController.getController().lendBookAndClose();
    }
}
