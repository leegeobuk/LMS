package woowa.lms.front.behavior.book.show;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.item.ItemFormController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowSearchBook implements Behavior {

    private static final ShowSearchBook INSTANCE = new ShowSearchBook();

    public static ShowSearchBook getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        ItemFormController.getController().showSearchBookForm();
    }
}
