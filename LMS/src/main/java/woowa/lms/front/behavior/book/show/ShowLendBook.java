package woowa.lms.front.behavior.book.show;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.FormController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowLendBook implements Behavior {

    private static final ShowLendBook INSTANCE = new ShowLendBook();

    public static ShowLendBook getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        FormController.getController().showLendBookForm();
    }
}
