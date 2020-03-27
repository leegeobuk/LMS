package woowa.lms.front.ui.table;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import woowa.lms.front.ui.FoolProofable;
import woowa.lms.front.ui.page.Page;

public abstract class AbstractTable<E> extends Stage implements Page, FoolProofable {

    protected VBox mainPane;
    protected Background background;

    protected Label headerLabel;
    protected ImageView logoImageView;

    protected HBox iconBar;

    protected TableView<E> tableView;

    protected double imageWidth;

    protected AbstractTable(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        mainPane = new VBox();
        mainPane.setSpacing(height * 0.1);
        iconBar = new HBox();

        tableView = new TableView<>();

        imageWidth = width * 0.16;
    }

    @Override
    public abstract void setUpComponents();

    @Override
    public abstract void setUpPage();

    @Override
    public abstract void setFoolProof();

    @Override
    public void setUpStage() {
        Scene scene = new Scene(mainPane);
        this.setScene(scene);
    }
}
