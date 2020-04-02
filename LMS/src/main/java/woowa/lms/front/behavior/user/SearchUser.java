package woowa.lms.front.behavior.user;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchUser implements Behavior {

    private static final SearchUser INSTANCE = new SearchUser();

    public static SearchUser getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
