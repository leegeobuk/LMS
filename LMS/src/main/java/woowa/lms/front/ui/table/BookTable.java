package woowa.lms.front.ui.table;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import woowa.lms.back.domain.item.Book;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.label.LabelBuilder;

public class BookTable extends AbstractTable<Book> {

    private static final double WIDTH = 450;
    private static final double HEIGHT = 600;
    private static final BookTable TABLE = new BookTable(WIDTH, HEIGHT);

    private BookTable(double width, double height) {
        super(width, height);

        setUpComponents();
        setUpPage();
        setUpStage();
    }

    public static BookTable getTable() {
        return TABLE;
    }

    @Override
    public void setUpComponents() {
        background = BackgroundBuilder.DEFAULT_BACKGROUND.toBackground();

        headerLabel = LabelBuilder.getPageHeader("Books List");

        logoImageView = ImageBuilder.getLogo(imageWidth);

        //icons
    }

    @Override
    public void setUpPage() {
        headerLabel.setGraphic(logoImageView);
        headerLabel.setGraphicTextGap(this.getWidth() * 0.05);

        //icon bar

        tableView.setEditable(true);

        mainPane.setBackground(background);
        mainPane.getChildren().addAll(headerLabel, iconBar, tableView);
        mainPane.setPadding(new Insets(20));
        mainPane.setAlignment(Pos.TOP_CENTER);
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
