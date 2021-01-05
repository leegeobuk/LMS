package woowa.lms.front.ui.table;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Getter;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.foolproof.FoolProof;
import woowa.lms.front.foolproof.table.TableFoolProof;
import woowa.lms.front.ui.FoolProofable;
import woowa.lms.front.ui.page.Page;

import java.util.List;

public abstract class AbstractTable<S> extends Stage implements Page, FoolProofable {

    protected VBox mainPane;
    protected Background background;

    protected Label headerLabel;
    protected ImageView logoImageView;

    protected VBox tableBox;
    protected HBox buttonBar;
    protected List<Button> foolProvedButtons;
    protected Button closeButton;
    protected FoolProof<MouseEvent> tableFoolProof;
    @Getter
    protected TableView<S> tableView;

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
        buttonBar = new HBox();
        tableView = new TableView<>();

        imageWidth = width * 0.1;
    }

    public S getSelected() {
        return tableView.getSelectionModel().getSelectedItem();
    }

    public ObservableList<S> getSelections() {
        return tableView.getSelectionModel().getSelectedItems();
    }

    @Override
    public void setUpComponents() {
        background = BackgroundBuilder.DEFAULT_BACKGROUND.toBackground();
        headerLabel = LabelBuilder.getPageHeader(header);
        logoImageView = ImageBuilder.getLogo(imageWidth);

        foolProvedButtons.forEach(button -> button.setDisable(true));
        closeButton.setCancelButton(true);
    }

    @Override
    public void setUpPage() {
        headerLabel.setGraphic(logoImageView);
        headerLabel.setGraphicTextGap(this.getWidth() * 0.05);

        buttonBar.setAlignment(Pos.CENTER_LEFT);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableBox.getChildren().addAll(buttonBar, tableView);

        mainPane.setBackground(background);
        mainPane.getChildren().addAll(headerLabel, tableBox);
        mainPane.setPadding(new Insets(20));
        mainPane.setAlignment(Pos.TOP_CENTER);
    }

    public void update(List<S> tableItems) {
        tableView.getItems().setAll(tableItems);
        foolProvedButtons.forEach(button -> button.setDisable(true));
    }

    @Override
    public void setFoolProof() {
        tableFoolProof = TableFoolProof.<S>builder().tableView(tableView)
            .buttons(foolProvedButtons).build();
        tableView.setOnMouseReleased(tableFoolProof);
    }

    @Override
    public void setUpStage() {
        Scene scene = new Scene(mainPane);
        this.setScene(scene);
        this.setTitle(title);
        this.initModality(Modality.WINDOW_MODAL);
    }
}
