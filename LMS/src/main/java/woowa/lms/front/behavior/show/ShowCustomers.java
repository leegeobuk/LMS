package woowa.lms.front.behavior.show;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShowCustomers implements Behavior {

    private static final ShowCustomers INSTANCE = new ShowCustomers();

    public static ShowCustomers getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
