package woowa.lms.front.ui.page;

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
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.label.LabelBuilder;

import static woowa.lms.front.behavior.BehaviorType.*;
import static woowa.lms.front.component.image.ImageType.*;

@Component
public class MainPage implements CustomPage {

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

    private double imageWidth;

    public static final MainPage INSTANCE = new MainPage();

    private MainPage() {
        mainPane = new VBox();
        scene = new Scene(mainPane, 960, 540);
        mainPane.setSpacing(scene.getHeight() * 0.15);
        buttonBox = new HBox(scene.getWidth() * 0.01);

        imageWidth = scene.getWidth() * 0.16;

        setUpComponents();
        setUpPage();
    }

    @Override
    public void setUpComponents() {
        background = BackgroundBuilder.DEFAULT_BACKGROUND.toBackground();

        headerLabel = LabelBuilder.getMainHeader("Woowa Library");

        logoImageView = ImageBuilder.getLogo(imageWidth);


        Label customLabel = LabelBuilder.getButtonLabel("About");
        ImageView customImage = ImageBuilder.getImageView(ABOUT, imageWidth);
        GeneralButton customButton = GeneralButton.builder().label(customLabel)
            .image(customImage).behavior(SHOW_ABOUT).build();
        aboutButton = customButton.toButton();

        customLabel = LabelBuilder.getButtonLabel("Sign Up");
        customImage = ImageBuilder.getImageView(SIGNUP, imageWidth);
        customButton.setLabel(customLabel);
        customButton.setImage(customImage);
        customButton.setBehavior(SHOW_SIGN_UP);
        signUpButton = customButton.toButton();

        customLabel = LabelBuilder.getButtonLabel("Sign In");
        customImage = ImageBuilder.getImageView(SIGNIN, imageWidth);
        customButton.setLabel(customLabel);
        customButton.setImage(customImage);
        customButton.setBehavior(SHOW_SIGN_IN);
        signInButton = customButton.toButton();

        customLabel = LabelBuilder.getButtonLabel("Exit");
        customImage = ImageBuilder.getImageView(EXIT, imageWidth);
        customButton.setLabel(customLabel);
        customButton.setImage(customImage);
        customButton.setBehavior(EXIT_PROGRAM);
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
    public Stage getStage() {
        Stage homeStage = new Stage();
        homeStage.setScene(scene);
        homeStage.setTitle("Woowa Library Management System");
        return homeStage;
    }

}
