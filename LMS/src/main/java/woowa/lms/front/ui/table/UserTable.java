package woowa.lms.front.ui.table;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.image.ImageType;
import woowa.lms.front.model.AccountModel;
import woowa.lms.front.ui.page.MainPage;

import java.util.List;

import static woowa.lms.front.behavior.BehaviorType.CLOSE;
import static woowa.lms.front.behavior.BehaviorType.DELETE_USER;
import static woowa.lms.front.behavior.BehaviorType.VIEW_USER;
import static woowa.lms.front.behavior.BehaviorType.*;
import static woowa.lms.front.component.image.ImageType.ADD_USER;
import static woowa.lms.front.component.image.ImageType.EDIT_USER;
import static woowa.lms.front.component.image.ImageType.SEARCH_USER;

public class UserTable extends AbstractTable<AccountModel> {

    private Button viewUserButton;
    private Button addUserButton;
    private Button editUserButton;
    private Button deleteUserButton;
    private Button searchButton;

    private static final double WIDTH = 500;
    private static final double HEIGHT = 600;
    private static final String TITLE = "Users Table";
    private static final String HEADER = "Users List";
    private static final UserTable TABLE = new UserTable();

    public UserTable() {
        super(WIDTH, HEIGHT, TITLE, HEADER);
        setUpComponents();
        setUpPage();
        setFoolProof();
        setUpStage();
    }

    public static UserTable getTable() {
        return TABLE;
    }

    @Override
    public void setUpComponents() {
        viewUserButton = GeneralButton.getTableButton(ImageType.VIEW_USER, VIEW_USER);
        addUserButton = GeneralButton.getTableButton(ADD_USER, SHOW_ADD_USER);
        editUserButton = GeneralButton.getTableButton(EDIT_USER, SHOW_EDIT_USER);
        deleteUserButton = GeneralButton.getTableButton(ImageType.DELETE_USER, DELETE_USER);
        searchButton = GeneralButton.getTableButton(SEARCH_USER, SHOW_SEARCH_USER);
        closeButton = GeneralButton.getTableButton(ImageType.CLOSE, CLOSE);
        foolProvedButtons = List.of(editUserButton, deleteUserButton);
        super.setUpComponents();
    }

    @Override
    public void setUpPage() {
        buttonBar.getChildren().addAll(viewUserButton, addUserButton,
            editUserButton, deleteUserButton, searchButton, closeButton);

        TableColumn<AccountModel, String > idColumn = new TableColumn<>("User Id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.3));
        TableColumn<AccountModel, String > nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.4));
        TableColumn<AccountModel, String > contactColumn = new TableColumn<>("Contact");
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        contactColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.3));
        tableView.getColumns().setAll(idColumn, nameColumn, contactColumn);
        super.setUpPage();
    }

    @Override
    public void setUpStage() {
        super.setUpStage();
        this.initOwner(MainPage.getPage());
    }

    @Override
    public void close() {
        tableView.setOnMouseClicked(null);
        super.close();
    }
}
