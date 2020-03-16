package woowa.lms.front.page.dialog;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import woowa.lms.front.components.background.BackgroundBuilder;
import woowa.lms.front.components.font.FontBuilder;
import woowa.lms.front.components.image.ImageBuilder;
import woowa.lms.front.components.image.ImageType;
import woowa.lms.front.components.label.LabelBuilder;

import java.util.Optional;

import static woowa.lms.front.components.font.FontType.EULJIRO;
import static woowa.lms.front.components.image.ImageType.EXIT_DIALOG;

public class ExitDialog implements CustomDialog {

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

        FontBuilder fontBuilder = FontBuilder.builder().font(EULJIRO).size(20).build();
        LabelBuilder labelBuilder = LabelBuilder.builder().text(headerText).textFill("white")
            .font(fontBuilder).build();
        headerLabel = labelBuilder.toLabel();

        ImageBuilder imageBuilder = ImageBuilder.builder().imageType(EXIT_DIALOG)
            .width(64).height(64).build();
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
        headerLabel.setGraphicTextGap(10);

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
