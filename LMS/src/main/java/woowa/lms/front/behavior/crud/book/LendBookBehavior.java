package woowa.lms.front.behavior.crud.book;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LendBookBehavior implements Behavior {

    private static final LendBookBehavior INSTANCE = new LendBookBehavior();

    public static LendBookBehavior getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
