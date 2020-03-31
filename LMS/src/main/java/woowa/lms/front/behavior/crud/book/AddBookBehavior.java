package woowa.lms.front.behavior.crud.book;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddBookBehavior implements Behavior {

    private static final AddBookBehavior INSTANCE = new AddBookBehavior();

    public static AddBookBehavior getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
