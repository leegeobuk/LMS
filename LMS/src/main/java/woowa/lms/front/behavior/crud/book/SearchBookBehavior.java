package woowa.lms.front.behavior.crud.book;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchBookBehavior implements Behavior {

    private static final SearchBookBehavior INSTANCE = new SearchBookBehavior();

    public static SearchBookBehavior getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
