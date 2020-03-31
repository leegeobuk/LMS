package woowa.lms.front.behavior.crud.book;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DeleteBookBehavior implements Behavior {

    private static final DeleteBookBehavior INSTANCE = new DeleteBookBehavior();

    public static DeleteBookBehavior getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
