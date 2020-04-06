package woowa.lms.front.behavior.user;

import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.service.account.AccountService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.controller.DialogController;
import woowa.lms.front.controller.TableController;
import woowa.lms.front.model.AccountModel;
import woowa.lms.front.ui.table.UserTable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DeleteUser implements Behavior {

    private AccountService accountService = SpringContext.getBean(AccountService.class);

    private static final DeleteUser INSTANCE = new DeleteUser();

    public static DeleteUser getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        AccountModel selected = UserTable.getInstance().getTable().getSelectionModel().getSelectedItem();
        accountService.deleteAccount(selected.getId());
        TableController.getController().updateUserTable();
    }
}
