package woowa.lms.front.page;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import woowa.lms.front.components.background.BackgroundBuilder;
import woowa.lms.front.components.font.FontBuilder;
import woowa.lms.front.components.image.ImageBuilder;
import woowa.lms.front.components.label.LabelBuilder;

import static woowa.lms.front.components.font.FontType.EULJIRO;
import static woowa.lms.front.components.image.ImageType.LOGO;

@Component
public class AboutPage implements Page {

    private Scene scene;
    private VBox mainPane;
    private Background background;

    private Label headerLabel;
    private ImageView logoImageView;

    double imageWidth;
    double sceneHeight;

    public static final AboutPage INSTANCE = new AboutPage();

    private AboutPage() {
        mainPane = new VBox();
        scene = new Scene(mainPane, 480, 480);
        mainPane.setSpacing(scene.getHeight() * 0.15);

        imageWidth = scene.getWidth() * 0.16;
        sceneHeight = scene.getHeight();
    }

    @Override
    public void setUpComponents() {
        BackgroundBuilder customBackground = BackgroundBuilder.MAIN_BACKGROUND;
        background = customBackground.toBackground();

        FontBuilder customFont = FontBuilder.builder().font(EULJIRO).size(50).build();
        LabelBuilder customLabel = LabelBuilder.builder().text("About Page").font(customFont)
            .textFill("white").build();
        headerLabel = customLabel.toLabel();

        ImageBuilder customImage = ImageBuilder.builder().imageType(LOGO)
            .width(imageWidth).height(imageWidth).build();
        logoImageView = customImage.toImageView();
    }

    @Override
    public void setUpPage() {
        headerLabel.setGraphic(logoImageView);
        headerLabel.setGraphicTextGap(scene.getWidth() * 0.05);

        mainPane.setBackground(background);
        mainPane.getChildren().addAll(headerLabel);
        mainPane.setPadding(new Insets(20));
        mainPane.setAlignment(Pos.TOP_CENTER);
    }

    @Override
    public Scene getScene() {
        setUpComponents();
        setUpPage();
        return scene;
    }
}