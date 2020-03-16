package woowa.lms.front.page.home;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;
import woowa.lms.front.components.background.BackgroundBuilder;
import woowa.lms.front.components.button.ButtonBuilder;
import woowa.lms.front.components.button.behavior.ClickAbout;
import woowa.lms.front.components.button.behavior.ClickExit;
import woowa.lms.front.components.button.behavior.ClickSignIn;
import woowa.lms.front.components.button.behavior.ClickSignUp;
import woowa.lms.front.components.font.FontBuilder;
import woowa.lms.front.components.image.ImageBuilder;
import woowa.lms.front.components.label.LabelBuilder;
import woowa.lms.front.page.Page;

import static woowa.lms.front.components.font.FontType.EULJIRO;
import static woowa.lms.front.components.image.ImageType.*;

@Component
public class MainPage implements Page {

    private Scene scene;
    private VBox mainPane;
    private Background background;

    private Label headerLabel;
    private ImageView logoImageView;

    private HBox buttonBox;
    private Button aboutButton;
    private Button signUpButton;
    private Button signInButton;
    private Button exitButton;

    double imageWidth;
    double sceneHeight;

    public static final MainPage INSTANCE = new MainPage();

    public MainPage() {
        mainPane = new VBox();
        scene = new Scene(mainPane, 960, 540);
        mainPane.setSpacing(scene.getHeight() * 0.15);
        buttonBox = new HBox(scene.getWidth() * 0.01);

        imageWidth = scene.getWidth() * 0.16;
        sceneHeight = scene.getHeight();
    }

    @Override
    public void setUpComponents() {

        BackgroundBuilder customBackground = BackgroundBuilder.MAIN_BACKGROUND;
        background = customBackground.toBackground();

        FontBuilder customFont = FontBuilder.builder().font(EULJIRO).size(100).build();
        LabelBuilder customLabel = LabelBuilder.builder().text("Woowa Library").font(customFont)
            .textFill("white").build();
        headerLabel = customLabel.toLabel();

        ImageBuilder customImage = ImageBuilder.builder().imageType(LOGO)
            .width(imageWidth).height(sceneHeight * 0.3).build();
        logoImageView = customImage.toImageView();


        customFont.setSize(30);
        customLabel = LabelBuilder.builder().text("About").textFill("#2ac1bc")
            .font(customFont).build();
        customImage.setImageType(ABOUT);
        ButtonBuilder customButton = ButtonBuilder.builder().label(customLabel).image(customImage)
            .graphicGap(10).clickBehavior(ClickAbout.getInstance()).build();
        aboutButton = customButton.toButton();

        customLabel.setText("Sign Up");
        customImage.setImageType(SIGNUP);
        customButton.setLabel(customLabel);
        customButton.setImage(customImage);
        customButton.setClickBehavior(ClickSignUp.getInstance());
        signUpButton = customButton.toButton();

        customLabel.setText("Sign In");
        customImage.setImageType(SIGNIN);
        customButton.setLabel(customLabel);
        customButton.setImage(customImage);
        customButton.setClickBehavior(ClickSignIn.getInstance());
        signInButton = customButton.toButton();

        customLabel.setText("Exit");
        customImage.setImageType(EXIT);
        customButton.setLabel(customLabel);
        customButton.setImage(customImage);
        customButton.setClickBehavior(ClickExit.getInstance());
        exitButton = customButton.toButton();
    }

    @Override
    public void setUpPage() {
        headerLabel.setGraphic(logoImageView);
        headerLabel.setGraphicTextGap(scene.getWidth() * 0.01);

        buttonBox.getChildren().addAll(aboutButton, signUpButton, signInButton, exitButton);
        buttonBox.setAlignment(Pos.CENTER);

        mainPane.setBackground(background);
        mainPane.getChildren().addAll(headerLabel, buttonBox);
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
