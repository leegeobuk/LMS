package woowa.lms.front.ui.table;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import woowa.lms.back.domain.item.Book;
import woowa.lms.back.service.item.BookService;
import woowa.lms.back.service.item.ItemService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.image.ImageType;
import woowa.lms.front.model.BookModel;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;
import static woowa.lms.front.behavior.BehaviorType.*;

public class BookTable extends AbstractTable<BookModel> {

    private Button viewBookButton;
    private Button addBookButton;
    private Button editBookButton;
    private Button deleteBookButton;
    private Button lendBookButton;
    private Button returnBookButton;
    private Button searchButton;
    private ItemService<Book> bookService = SpringContext.getBean(BookService.class);

    private static final double WIDTH = 550;
    private static final double HEIGHT = 600;
    private static final BookTable TABLE = new BookTable(WIDTH, HEIGHT);

    private BookTable(double width, double height) {
        super(width, height);

        String headerText = "Books List";
        setUpComponents(headerText);
        setUpPage();
        update();
        setFoolProof();
        setUpStage(headerText);
    }

    public static BookTable getInstance() {
        return TABLE;
    }

    @Override
    public void setUpComponents(String pageTitle) {
        viewBookButton = GeneralButton.getTableButton(ImageType.VIEW_BOOK, VIEW_BOOK);
        addBookButton = GeneralButton.getTableButton(ImageType.ADD_BOOK, SHOW_ADD_BOOK);
        editBookButton = GeneralButton.getTableButton(ImageType.EDIT_BOOK, SHOW_EDIT_BOOK);
        deleteBookButton = GeneralButton.getTableButton(ImageType.DELETE_BOOK, DELETE_BOOK);
        lendBookButton = GeneralButton.getTableButton(ImageType.LEND_BOOK, SHOW_LEND_BOOK);
        returnBookButton = GeneralButton.getTableButton(ImageType.RETURN_BOOK, RETURN_BOOK);
        searchButton = GeneralButton.getTableButton(ImageType.SEARCH_BOOK, SHOW_SEARCH_BOOK);
        closeButton = GeneralButton.getTableButton(ImageType.CLOSE, CLOSE_BOOK);

        super.setUpComponents(pageTitle);
    }

    @Override
    public void setUpPage() {
        iconBar.getChildren().addAll(viewBookButton, addBookButton, editBookButton,
            deleteBookButton, lendBookButton, returnBookButton, searchButton, closeButton);

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

        super.setUpPage();
    }

    @Override
    public void update() {
        List<Book> books = bookService.findAll();
        List<BookModel> bookModels = books
            .stream().map(BookModel::new).collect(toUnmodifiableList());
        table.getItems().setAll(bookModels);
    }

    @Override
    public void setFoolProof() {
        // TODO: 2020-04-02 Implement after buttons are implemented
    }
}
