package woowa.lms.front.ui.page;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.label.LabelBuilder;

public abstract class AbstractPage extends Stage implements Page {

    protected VBox mainPane;
    protected Background background;

    protected Label headerLabel;
    protected ImageView logoImageView;

    protected Pane mainBox;

    protected double imageWidth;
    protected boolean signedIn;

    protected AbstractPage(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        mainPane = new VBox();
        mainPane.setSpacing(height * 0.15);
        mainBox = new HBox(width * 0.01);

        imageWidth = width * 0.16;
    }

    @Override
    public void setUpComponents(String pageTitle) {
        background = BackgroundBuilder.DEFAULT_BACKGROUND.toBackground();
        headerLabel = LabelBuilder.getPageHeader(pageTitle);
        logoImageView = ImageBuilder.getLogo(imageWidth);
    }

    @Override
    public void setUpPage() {
        headerLabel.setGraphic(logoImageView);
        headerLabel.setGraphicTextGap(this.getWidth() * 0.05);

        mainPane.setBackground(background);
        mainPane.getChildren().addAll(headerLabel, mainBox);
        mainPane.setPadding(new Insets(20));
        mainPane.setAlignment(Pos.TOP_CENTER);
    }

    @Override
    public void setUpStage(String title) {
        Scene scene = new Scene(mainPane);
        this.setScene(scene);
        this.setTitle(title);
    }
}
