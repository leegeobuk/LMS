package woowa.lms.front.behavior.crud.customer;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.front.behavior.Behavior;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchCustomerBehavior implements Behavior {

    private static final SearchCustomerBehavior INSTANCE = new SearchCustomerBehavior();

    public static SearchCustomerBehavior getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
