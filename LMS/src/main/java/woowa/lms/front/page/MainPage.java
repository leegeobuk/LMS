package woowa.lms.front.page;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import woowa.lms.front.components.background.BackgroundBuilder;
import woowa.lms.front.components.background.CustomBackground;
import woowa.lms.front.components.button.ButtonBuilder;
import woowa.lms.front.components.button.CustomButton;
import woowa.lms.front.components.button.behavior.*;
import woowa.lms.front.components.font.FontBuilder;
import woowa.lms.front.components.image.CustomImage;
import woowa.lms.front.components.image.ImageBuilder;
import woowa.lms.front.components.image.ImageType;
import woowa.lms.front.components.label.CustomLabel;
import woowa.lms.front.components.label.LabelBuilder;

import static woowa.lms.front.components.button.behavior.ClickBehaviorType.ABOUT;
import static woowa.lms.front.components.button.behavior.ClickBehaviorType.EXIT;
import static woowa.lms.front.components.button.behavior.ClickBehaviorType.SIGNIN;
import static woowa.lms.front.components.button.behavior.ClickBehaviorType.SIGNUP;
import static woowa.lms.front.components.font.FontType.EULJIRO;
import static woowa.lms.front.components.image.ImageType.*;

@Component
public class MainPage implements Page {

    private Stage primaryStage;
    private VBox mainPane;
    private Scene scene;
    private Background background;

    private Label headerLabel;
    private ImageView logoImageView;

    private HBox buttonBox;
    private Button aboutButton;
    private Button signUpButton;
    private Button signInButton;
    private Button exitButton;

    public MainPage(Stage primaryStage, double width, double height) {
        this.primaryStage = primaryStage;
        mainPane = new VBox();
        scene = new Scene(mainPane, width, height);
        mainPane.setSpacing(scene.getHeight() * 0.15);
        buttonBox = new HBox(scene.getWidth() * 0.01);
    }

    @Override
    public void setUpComponents() {
        double imageWidth = scene.getWidth() * 0.16;
        double sceneHeight = scene.getHeight();

        background = BackgroundBuilder.MAIN_BACKGROUND.toBackground();


        FontBuilder font = FontBuilder.builder().font(EULJIRO).size(100).build();
        LabelBuilder label = LabelBuilder.builder().text("Woowa Library").font(font)
            .textFill("white").build();
        headerLabel = label.toLabel();

        ImageBuilder image = ImageBuilder.builder().imageType(LOGO)
            .width(imageWidth).height(sceneHeight * 0.3).build();
        logoImageView = image.toImageView();


        font.setSize(30);
        label = LabelBuilder.builder().text("About").textFill("#2ac1bc")
            .font(font).build();
        image.setImageType(ImageType.ABOUT);
        ButtonBuilder buttonBuilder = ButtonBuilder.builder().label(label).image(image)
            .graphicGap(10).clickBehavior(ABOUT).build();
        aboutButton = buttonBuilder.toButton();

        label.setText("Sign Up");
        image.setImageType(ImageType.SIGNUP);
        buttonBuilder.setLabel(label);
        buttonBuilder.setImage(image);
        buttonBuilder.setClickBehavior(SIGNUP);
        signUpButton = buttonBuilder.toButton();

        label.setText("Sign In");
        image.setImageType(ImageType.SIGNIN);
        buttonBuilder.setLabel(label);
        buttonBuilder.setImage(image);
        buttonBuilder.setClickBehavior(SIGNIN);
        signInButton = buttonBuilder.toButton();

        label.setText("Exit");
        image.setImageType(ImageType.EXIT);
        buttonBuilder.setLabel(label);
        buttonBuilder.setImage(image);
        buttonBuilder.setClickBehavior(EXIT);
        exitButton = buttonBuilder.toButton();
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
    public void show() {
        setUpComponents();
        setUpPage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Woowa Library Management System");
        primaryStage.show();
    }

}
