package woowa.lms.front.behavior.book;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.item.ItemTableController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DeleteBook implements Behavior {

    private static final DeleteBook INSTANCE = new DeleteBook();

    public static DeleteBook getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        ItemTableController.getController().deleteBook();
    }
}
