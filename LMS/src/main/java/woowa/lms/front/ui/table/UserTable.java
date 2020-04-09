package woowa.lms.front.ui.table;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import woowa.lms.back.service.RentalService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.image.ImageType;
import woowa.lms.front.model.AccountModel;
import woowa.lms.front.model.BookModel;
import woowa.lms.front.ui.form.book.LendBookForm;
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

    private RentalService rentalService = SpringContext.getBean(RentalService.class);

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

    public static UserTable getInstance() {
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

        super.setUpComponents();
    }

    @Override
    public void setUpPage() {
        iconBar.getChildren().addAll(viewUserButton, addUserButton,
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
    public void update(List<AccountModel> userModels) {
        tableView.getItems().setAll(userModels);
    }

    @Override
    public void setFoolProof() {
        // TODO: 2020-04-02 Implement after buttons implementation
    }

    public void setToSelectionMode(boolean isSelectionMode) {
        if (isSelectionMode) {
            tableView.setOnMouseClicked(e -> {
                AccountModel selected = getSelected();
                if (e.getClickCount() == 2) {
                    List<TextField> fields = LendBookForm.getForm().getFields();
                    fields.get(0).setText(selected.getId());
                    fields.get(1).setText(selected.getName());
                    fields.get(2).setText(selected.getContact());
                    LendBookForm.getForm().getOkButton().setDisable(false);
                    this.close();
                }
            });
        }
        else {
            tableView.setOnMouseClicked(null);
        }
    }

    public void setToReturnMode() {
        tableView.setOnMouseClicked(e -> {
            AccountModel selectedUser = getSelected();
            if (e.getClickCount() == 2) {
                BookModel selectedItem = BookTable.getTable().getSelected();
                rentalService.returnBooks(selectedUser.getId(), selectedItem.getId());
                BookTable.getTable().update();
                this.close();
            }
        });
    }

    @Override
    public void setUpStage() {
        super.setUpStage();
        this.initOwner(MainPage.getPage());
    }

    @Override
    public void close() {
        setToSelectionMode(false);
        super.close();
    }
}
