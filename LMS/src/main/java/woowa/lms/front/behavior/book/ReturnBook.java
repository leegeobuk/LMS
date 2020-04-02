package woowa.lms.front.behavior.book;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReturnBook implements Behavior {

    private static final ReturnBook INSTANCE = new ReturnBook();

    public static ReturnBook getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
