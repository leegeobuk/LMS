package woowa.lms.front.behavior.crud.customer;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DeleteCustomerBehavior implements Behavior {

    private static final DeleteCustomerBehavior INSTANCE = new DeleteCustomerBehavior();

    public static DeleteCustomerBehavior getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
