package woowa.lms.front.ui.table;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.image.ImageType;
import woowa.lms.front.model.BookModel;
import woowa.lms.front.model.CustomerModel;

import static woowa.lms.front.behavior.BehaviorType.*;

public class CustomerTable extends AbstractTable<CustomerModel> {

    private Button viewCustomerButton;
    private Button addCustomerButton;
    private Button editCustomerButton;
    private Button deleteCustomerButton;
    private Button searchButton;
    private Button closeButton;

    private static final double WIDTH = 500;
    private static final double HEIGHT = 600;
    private static final CustomerTable TABLE = new CustomerTable(WIDTH, HEIGHT);

    public CustomerTable(double width, double height) {
        super(width, height);

        String headerText = "Customers List";
        setUpComponents(headerText);
        setUpPage();
        setFoolProof();
        setUpStage(headerText);
    }

    public static CustomerTable getInstance() {
        return TABLE;
    }

    @Override
    public void setUpComponents(String pageTitle) {
        super.setUpComponents(pageTitle);

        viewCustomerButton = GeneralButton.getTableButton(ImageType.VIEW_CUSTOMER, VIEW_CUSTOMER);
        addCustomerButton = GeneralButton.getTableButton(ImageType.ADD_CUSTOMER, ADD_CUSTOMER);
        editCustomerButton = GeneralButton.getTableButton(ImageType.EDIT_CUSTOMER, EDIT_CUSTOMER);
        deleteCustomerButton = GeneralButton.getTableButton(ImageType.DELETE_CUSTOMER, DELETE_CUSTOMER);
        searchButton = GeneralButton.getTableButton(ImageType.SEARCH_CUSTOMER, SEARCH_CUSTOMER);
    }

    @Override
    public void setUpPage() {
        super.setUpPage();

        iconBar.getChildren().addAll(viewCustomerButton, addCustomerButton, editCustomerButton,
            deleteCustomerButton, searchButton);

        TableColumn<CustomerModel, String > idColumn = new TableColumn<>("Customer Id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.35));
        TableColumn<CustomerModel, String > nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.35));
        TableColumn<CustomerModel, String > contactColumn = new TableColumn<>("Contact");
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        contactColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.3));
        table.getColumns().setAll(idColumn, nameColumn, contactColumn);
    }

    @Override
    public void setFoolProof() {

    }
}
