package woowa.lms.front.behavior.crud.book;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReturnBookBehavior implements Behavior {

    private static final ReturnBookBehavior INSTANCE = new ReturnBookBehavior();

    public static ReturnBookBehavior getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
