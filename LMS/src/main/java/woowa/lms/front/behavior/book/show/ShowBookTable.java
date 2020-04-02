package woowa.lms.front.behavior.book.show;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.TableController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowBookTable implements Behavior {

    private static final ShowBookTable INSTANCE = new ShowBookTable();

    public static ShowBookTable getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        TableController.getController().showBookTable();
    }
}
