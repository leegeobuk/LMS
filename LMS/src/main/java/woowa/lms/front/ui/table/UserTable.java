package woowa.lms.front.ui.table;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import woowa.lms.back.domain.account.User;
import woowa.lms.back.service.account.AccountService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.model.AccountModel;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;
import static woowa.lms.front.behavior.BehaviorType.*;
import static woowa.lms.front.component.image.ImageType.CLOSE;
import static woowa.lms.front.component.image.ImageType.*;

public class UserTable extends AbstractTable<AccountModel> {

    private Button viewUserButton;
    private Button addUserButton;
    private Button editUserButton;
    private Button deleteUserButton;
    private Button searchButton;
    private AccountService accountService = SpringContext.getBean(AccountService.class);

    private static final double WIDTH = 500;
    private static final double HEIGHT = 600;
    private static final UserTable TABLE = new UserTable(WIDTH, HEIGHT);

    public UserTable(double width, double height) {
        super(width, height);
        String headerText = "Users List";
        setUpComponents(headerText);
        setUpPage();
        update();
        setFoolProof();
        setUpStage(headerText);
    }

    public static UserTable getInstance() {
        return TABLE;
    }

    @Override
    public void setUpComponents(String pageTitle) {
        viewUserButton = GeneralButton.getTableButton(VIEW_CUSTOMER, VIEW_USER);
        addUserButton = GeneralButton.getTableButton(ADD_CUSTOMER, SHOW_ADD_USER);
        editUserButton = GeneralButton.getTableButton(EDIT_CUSTOMER, SHOW_EDIT_USER);
        deleteUserButton = GeneralButton.getTableButton(DELETE_CUSTOMER, DELETE_USER);
        searchButton = GeneralButton.getTableButton(SEARCH_CUSTOMER, SHOW_SEARCH_USER);
        closeButton = GeneralButton.getTableButton(CLOSE, CLOSE_USER);

        super.setUpComponents(pageTitle);
    }

    @Override
    public void setUpPage() {
        iconBar.getChildren().addAll(viewUserButton, addUserButton,
            editUserButton, deleteUserButton, searchButton, closeButton);

        TableColumn<AccountModel, String > idColumn = new TableColumn<>("Customer Id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.3));
        TableColumn<AccountModel, String > nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.4));
        TableColumn<AccountModel, String > contactColumn = new TableColumn<>("Contact");
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        contactColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.3));
        table.getColumns().setAll(idColumn, nameColumn, contactColumn);

        super.setUpPage();
    }

    @Override
    public void update() {
        List<User> users = accountService.findUsers();
        List<AccountModel> userModels = users
            .stream().map(AccountModel::new).collect(toUnmodifiableList());
        table.getItems().setAll(userModels);
    }

    @Override
    public void setFoolProof() {
        // TODO: 2020-04-02 Implement after buttons implementation
    }
}
