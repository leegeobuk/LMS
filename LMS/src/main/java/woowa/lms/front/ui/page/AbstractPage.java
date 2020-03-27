package woowa.lms.front.ui.page;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class AbstractPage extends Stage implements Page {

    protected VBox mainPane;
    protected Background background;

    protected Label headerLabel;
    protected ImageView logoImageView;

    protected HBox mainBox;

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
    public abstract void setUpComponents();

    @Override
    public abstract void setUpPage();

    @Override
    public void setUpStage() {
        Scene scene = new Scene(mainPane);
        this.setScene(scene);
    }
}
