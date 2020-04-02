package woowa.lms.front.behavior.book.close;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.TableController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CloseBookTable implements Behavior {

    private static final CloseBookTable INSTANCE = new CloseBookTable();

    public static CloseBookTable getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        TableController.getController().closeBookTable();
    }
}
