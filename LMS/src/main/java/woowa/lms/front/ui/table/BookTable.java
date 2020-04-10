package woowa.lms.front.ui.table;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.image.ImageType;
import woowa.lms.front.model.BookModel;
import woowa.lms.front.ui.page.MainPage;

import java.util.List;

import static woowa.lms.front.behavior.BehaviorType.CLOSE;
import static woowa.lms.front.behavior.BehaviorType.DELETE_BOOK;
import static woowa.lms.front.behavior.BehaviorType.VIEW_BOOK;
import static woowa.lms.front.behavior.BehaviorType.*;
import static woowa.lms.front.component.image.ImageType.ADD_BOOK;
import static woowa.lms.front.component.image.ImageType.EDIT_BOOK;
import static woowa.lms.front.component.image.ImageType.LEND_BOOK;
import static woowa.lms.front.component.image.ImageType.SEARCH_BOOK;
import static woowa.lms.front.component.image.ImageType.*;

public class BookTable extends AbstractTable<BookModel> {

    private Button viewBookButton;
    private Button addBookButton;
    private Button editBookButton;
    private Button deleteBookButton;
    private Button lendBookButton;
    private Button returnBookButton;
    private Button searchButton;

    private static final double WIDTH = 500;
    private static final double HEIGHT = 600;
    private static final String TITLE = "Books Table";
    private static final String HEADER = "Books List";
    private static final BookTable TABLE = new BookTable();

    private BookTable() {
        super(WIDTH, HEIGHT, TITLE, HEADER);
        setUpComponents();
        setUpPage();
        setFoolProof();
        setUpStage();
    }

    public static BookTable getTable() {
        return TABLE;
    }

    @Override
    public void setUpComponents() {
        viewBookButton = GeneralButton.getTableButton(ImageType.VIEW_BOOK, VIEW_BOOK);
        addBookButton = GeneralButton.getTableButton(ADD_BOOK, SHOW_ADD_BOOK);
        editBookButton = GeneralButton.getTableButton(EDIT_BOOK, SHOW_EDIT_BOOK);
        deleteBookButton = GeneralButton.getTableButton(ImageType.DELETE_BOOK, DELETE_BOOK);
        lendBookButton = GeneralButton.getTableButton(LEND_BOOK, SHOW_LEND_BOOK);
        returnBookButton = GeneralButton.getTableButton(RETURN_BOOK, SHOW_BORROWED_USER);
        searchButton = GeneralButton.getTableButton(SEARCH_BOOK, SHOW_SEARCH_BOOK);
        closeButton = GeneralButton.getTableButton(ImageType.CLOSE, CLOSE);
        foolProvedButtons = List.of(editBookButton, deleteBookButton, lendBookButton,
            returnBookButton);
        super.setUpComponents();
    }

    @Override
    public void setUpPage() {
        buttonBar.getChildren().addAll(viewBookButton, addBookButton, editBookButton,
            deleteBookButton, lendBookButton, returnBookButton, searchButton, closeButton);

        TableColumn<BookModel, Long> idColumn = new TableColumn<>("Book Id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        TableColumn<BookModel, String > titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        titleColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.35));
        TableColumn<BookModel, String > authorColumn = new TableColumn<>("Author");
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        authorColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));
        TableColumn<BookModel, String > statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        statusColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        TableColumn<BookModel, Integer> stockColumn = new TableColumn<>("Stock");
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        stockColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
        tableView.getColumns().setAll(idColumn, titleColumn, authorColumn, statusColumn, stockColumn);
        super.setUpPage();
    }

    @Override
    public void setUpStage() {
        super.setUpStage();
        this.initOwner(MainPage.getPage());
    }
}
