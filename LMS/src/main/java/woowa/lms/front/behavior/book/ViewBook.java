package woowa.lms.front.behavior.book;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.ui.table.BookTable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ViewBook implements Behavior {

    private static final ViewBook INSTANCE = new ViewBook();

    public static ViewBook getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        BookTable.getTable().update();
    }
}
