package woowa.lms.front.ui.table;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.image.ImageType;
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.model.BookModel;

import static woowa.lms.front.behavior.BehaviorType.*;

public class BookTable extends AbstractTable<BookModel> {

    private Button viewBookButton;
    private Button addBookButton;
    private Button editBookButton;
    private Button deleteBookButton;
    private Button lendBookButton;
    private Button returnBookButton;
    private Button closeButton;

    private static final double WIDTH = 500;
    private static final double HEIGHT = 600;
    private static final BookTable TABLE = new BookTable(WIDTH, HEIGHT);

    private BookTable(double width, double height) {
        super(width, height);

        setUpComponents();
        setUpPage();
        setUpStage();
    }

    public static BookTable getInstance() {
        return TABLE;
    }

    public void clear() {
        table.getItems().clear();
    }



    @Override
    public void setUpComponents() {
        super.setUpComponents();
        headerLabel = LabelBuilder.getPageHeader("Books List");

        viewBookButton = GeneralButton.getTableButton(ImageType.VIEW_BOOK, VIEW_BOOK);
        addBookButton = GeneralButton.getTableButton(ImageType.ADD_BOOK, ADD_BOOK);
        editBookButton = GeneralButton.getTableButton(ImageType.EDIT_BOOK, EDIT_BOOK);
        deleteBookButton = GeneralButton.getTableButton(ImageType.DELETE_BOOK, DELETE_BOOK);
        lendBookButton = GeneralButton.getTableButton(ImageType.LEND_BOOK, LEND_BOOK);
        returnBookButton = GeneralButton.getTableButton(ImageType.RETURN_BOOK, RETURN_BOOK);
    }

    @Override
    public void setUpPage() {
        super.setUpPage();

        iconBar.getChildren().addAll(viewBookButton, addBookButton,
            editBookButton, deleteBookButton, lendBookButton, returnBookButton);

        TableColumn<BookModel, Long> idColumn = new TableColumn<>("Book Id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
        TableColumn<BookModel, String > titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        titleColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.35));
        TableColumn<BookModel, String > authorColumn = new TableColumn<>("Author");
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        authorColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
        TableColumn<BookModel, String > statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        statusColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
        TableColumn<BookModel, Integer> stockColumn = new TableColumn<>("Stock");
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        stockColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
        table.getColumns().setAll(idColumn, titleColumn, authorColumn, statusColumn, stockColumn);
    }

    @Override
    public void setFoolProof() {

    }

    @Override
    public void setUpStage() {
        super.setUpStage();
        this.setTitle("Books List");
    }
}
