package woowa.lms.front.behavior.crud.customer;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ViewCustomerBehavior implements Behavior {

    private static final ViewCustomerBehavior INSTANCE = new ViewCustomerBehavior();

    public static ViewCustomerBehavior getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
