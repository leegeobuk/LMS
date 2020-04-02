package woowa.lms.front.behavior.user;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EditUser implements Behavior {

    private static final EditUser INSTANCE = new EditUser();

    public static EditUser getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
