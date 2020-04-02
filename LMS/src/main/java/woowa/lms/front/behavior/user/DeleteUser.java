package woowa.lms.front.behavior.user;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DeleteUser implements Behavior {

    private static final DeleteUser INSTANCE = new DeleteUser();

    public static DeleteUser getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
