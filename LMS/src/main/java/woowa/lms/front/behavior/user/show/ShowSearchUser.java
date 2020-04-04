package woowa.lms.front.behavior.user.show;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.FormController;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowSearchUser implements Behavior {

    private static final ShowSearchUser INSTANCE = new ShowSearchUser();

    public static ShowSearchUser getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        FormController.getController().showSearchUserForm();
    }
}
