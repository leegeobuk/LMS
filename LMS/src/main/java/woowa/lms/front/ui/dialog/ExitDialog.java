package woowa.lms.front.ui.dialog;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.font.FontBuilder;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.label.LabelBuilder;

import java.util.Optional;

import static woowa.lms.front.component.font.FontType.HANNA_11;
import static woowa.lms.front.component.image.ImageType.EXIT_DIALOG;

public class ExitDialog implements Showable {

    private Alert alert;
    private DialogPane dialogPane;
    private Background background;
    private Label headerLabel;
    private ImageView headerImage;
    private Label contentLabel;
    private String title;
    private String headerText;
    private String contentText;

    public static final ExitDialog ALERT = new ExitDialog();

    private ExitDialog() {
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        dialogPane = new DialogPane();
        setUpComponents();
        setUpPage();
    }

    @Override
    public void setUpComponents() {
        title = "Exit Dialog";
        headerText = "Program terminates when pressed OK!";
        contentText = "Think twice!!";

        background = BackgroundBuilder.MAIN_BACKGROUND.toBackground();

        FontBuilder fontBuilder = FontBuilder.builder().font(HANNA_11).size(20).build();
        LabelBuilder labelBuilder = LabelBuilder.builder().text(headerText).textFill("white")
            .font(fontBuilder).build();
        headerLabel = labelBuilder.toLabel();

        ImageBuilder imageBuilder = ImageBuilder.builder().imageType(EXIT_DIALOG).build();
        headerImage = imageBuilder.toImageView();

        fontBuilder.setSize(15);
        labelBuilder.setText(contentText);
        contentLabel = labelBuilder.toLabel();
    }

    @Override
    public void setUpPage() {
        headerLabel.setPadding(new Insets(10));
        headerLabel.setGraphic(headerImage);
        headerLabel.setContentDisplay(ContentDisplay.RIGHT);
        headerLabel.setGraphicTextGap(15);

        dialogPane.setBackground(background);
        dialogPane.setHeader(headerLabel);
        dialogPane.setContent(contentLabel);
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        alert.setDialogPane(dialogPane);
        alert.setTitle(title);
    }

    @Override
    public void show() {
        Optional<ButtonType> response = alert.showAndWait();
        if (response.isPresent() && response.get() == ButtonType.OK) {
            Platform.exit();
        }
    }
}
