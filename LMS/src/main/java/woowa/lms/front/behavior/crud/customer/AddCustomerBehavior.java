package woowa.lms.front.behavior.crud.customer;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddCustomerBehavior implements Behavior {

    private static final AddCustomerBehavior INSTANCE = new AddCustomerBehavior();

    public static AddCustomerBehavior getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
