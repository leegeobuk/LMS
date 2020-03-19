package woowa.lms.front.ui.page;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.font.FontBuilder;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.label.LabelBuilder;

import static woowa.lms.front.component.font.FontType.HANNA_11;
import static woowa.lms.front.component.image.ImageType.LOGO;

@Component
public class AboutPage implements CustomPage {

    private Scene scene;
    private VBox mainPane;
    private Background background;

    private Label headerLabel;
    private ImageView logoImageView;

    private HBox textBox;
    private Text aboutText;

    private double imageWidth;

    public static final AboutPage INSTANCE = new AboutPage();

    private AboutPage() {
        mainPane = new VBox();
        scene = new Scene(mainPane, 480, 360);
        mainPane.setSpacing(scene.getHeight() * 0.1);

        imageWidth = scene.getWidth() * 0.16;

        textBox = new HBox();

        setUpComponents();
        setUpPage();
    }

    @Override
    public void setUpComponents() {
        BackgroundBuilder customBackground = BackgroundBuilder.MAIN_BACKGROUND;
        background = customBackground.toBackground();

        FontBuilder customFont = FontBuilder.builder().font(HANNA_11).size(50).build();
        LabelBuilder customLabel = LabelBuilder.builder().text("About Page").font(customFont)
            .textFill("white").build();
        headerLabel = customLabel.toLabel();

        ImageBuilder customImage = ImageBuilder.builder().imageType(LOGO)
            .width(imageWidth).height(imageWidth).build();
        logoImageView = customImage.toImageView();

        AboutPageText pageText = AboutPageText.builder().size(15).build();
        aboutText = pageText.toText();
        aboutText.setWrappingWidth(scene.getWidth() - 20);
        aboutText.setTextAlignment(TextAlignment.JUSTIFY);
    }

    @Override
    public void setUpPage() {
        mainPane.setBackground(background);
        mainPane.getChildren().addAll(headerLabel, textBox);
        mainPane.setPadding(new Insets(20));
        mainPane.setAlignment(Pos.TOP_CENTER);

        headerLabel.setGraphic(logoImageView);
        headerLabel.setGraphicTextGap(scene.getWidth() * 0.05);

        textBox.getChildren().addAll(aboutText);
    }

    @Override
    public Stage getStage() {
        Stage aboutStage = new Stage();
        aboutStage.setScene(scene);
        aboutStage.setTitle("About Page");
        aboutStage.setResizable(false);
        return aboutStage;
    }
}