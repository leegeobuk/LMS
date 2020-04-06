package woowa.lms.front.behavior.close;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CloseForm implements Behavior {

    private static final CloseForm INSTANCE = new CloseForm();

    public static CloseForm getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        Behavior.super.closeForm(event);
    }
}
