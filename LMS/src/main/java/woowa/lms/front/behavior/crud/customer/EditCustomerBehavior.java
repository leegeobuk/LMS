package woowa.lms.front.behavior.crud.customer;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EditCustomerBehavior implements Behavior {

    private static final EditCustomerBehavior INSTANCE = new EditCustomerBehavior();

    public static EditCustomerBehavior getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
