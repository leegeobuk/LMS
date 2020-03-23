package woowa.lms.front.ui.form;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class AbstractForm implements CustomForm {

    protected Scene scene;
    protected VBox mainPane;
    protected Background background;

    protected Label headerLabel;
    protected ImageView logoImageView;

    protected GridPane form;

    protected HBox buttonBox;
    protected Button okButton;
    protected Button cancelButton;

    private double imageWidth;

    protected AbstractForm(double width, double height) {
        mainPane = new VBox();
        scene = new Scene(mainPane, width, height);
        mainPane.setSpacing(scene.getHeight() * 0.1);

        form = new GridPane();

        buttonBox = new HBox(10);

        imageWidth = scene.getWidth() * 0.16;

        setUpComponents();
        setUpPage();
        setFoolProof();
    }

    @Override
    public abstract void setUpComponents();

    @Override
    public abstract void setUpPage();

    @Override
    public abstract void setFoolProof();

    @Override
    public abstract Stage getStage();
}
