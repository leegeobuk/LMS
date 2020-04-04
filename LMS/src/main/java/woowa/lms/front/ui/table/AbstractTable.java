package woowa.lms.front.ui.table;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.Getter;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.ui.FoolProofable;
import woowa.lms.front.ui.page.Page;

public abstract class AbstractTable<E> extends Stage implements Page, FoolProofable {

    protected VBox mainPane;
    protected Background background;

    protected Label headerLabel;
    protected ImageView logoImageView;

    protected VBox tableBox;
    protected HBox iconBar;
    protected Button closeButton;
    @Getter
    protected TableView<E> table;

    protected String title;
    protected String header;
    protected double imageWidth;

    protected AbstractTable(double width, double height, String title, String header) {
        this.setWidth(width);
        this.setHeight(height);
        this.title = title;
        this.header = header;
        mainPane = new VBox();
        mainPane.setSpacing(height * 0.05);

        tableBox = new VBox();
        iconBar = new HBox();
        table = new TableView<>();

        imageWidth = width * 0.1;
    }

    public void clear() {
        table.getItems().clear();
    }

    @Override
    public void setUpComponents() {
        background = BackgroundBuilder.DEFAULT_BACKGROUND.toBackground();
        headerLabel = LabelBuilder.getPageHeader(header);
        logoImageView = ImageBuilder.getLogo(imageWidth);

        closeButton.setCancelButton(true);
    }

    @Override
    public void setUpPage() {
        headerLabel.setGraphic(logoImageView);
        headerLabel.setGraphicTextGap(this.getWidth() * 0.05);

        iconBar.setAlignment(Pos.CENTER_LEFT);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableBox.getChildren().addAll(iconBar, table);

        mainPane.setBackground(background);
        mainPane.getChildren().addAll(headerLabel, tableBox);
        mainPane.setPadding(new Insets(20));
        mainPane.setAlignment(Pos.TOP_CENTER);
    }

    public abstract void update();

    @Override
    public abstract void setFoolProof();

    @Override
    public void setUpStage() {
        Scene scene = new Scene(mainPane);
        this.setScene(scene);
        this.setTitle(title);
    }
}
