package woowa.lms.front.ui.page;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import woowa.lms.back.util.Token;
import woowa.lms.front.behavior.BehaviorType;
import woowa.lms.front.component.background.BackgroundBuilder;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.image.ImageBuilder;
import woowa.lms.front.component.image.ImageType;
import woowa.lms.front.component.label.LabelBuilder;

import static woowa.lms.front.behavior.BehaviorType.*;
import static woowa.lms.front.behavior.BehaviorType.SIGN_OUT;
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
    private Button bookButton;
    private Button customerButton;
    private Button signInButton;
    private Button exitButton;

    private double imageWidth;
    private boolean signedIn;

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
        aboutButton = GeneralButton.getMainButton(customLabel, customImage, SHOW_ABOUT);

        customLabel = LabelBuilder.getButtonLabel("Sign Up");
        customImage = ImageBuilder.getImageView(ImageType.SIGN_UP, imageWidth);
        signUpButton = GeneralButton.getMainButton(customLabel, customImage, SHOW_SIGN_UP);

        customLabel = LabelBuilder.getButtonLabel("Sign In");
        customImage = ImageBuilder.getImageView(ImageType.SIGN_IN, imageWidth);
        signInButton = GeneralButton.getMainButton(customLabel, customImage, SHOW_SIGN_IN);

        customLabel = LabelBuilder.getButtonLabel("Exit");
        customImage = ImageBuilder.getImageView(EXIT, imageWidth);
        exitButton = GeneralButton.getMainButton(customLabel, customImage, EXIT_PROGRAM);
    }

    public void redraw() {
        signedIn = Token.getToken().isSignedIn();
        imageWidth = scene.getWidth() * (signedIn ? 0.14 : 0.16);
        aboutButton = redrawButton("About", ABOUT, SHOW_ABOUT);
        exitButton = redrawButton("Exit", EXIT, EXIT_PROGRAM);
        bookButton = redrawButton("Books", BOOK, SHOW_SIGN_IN);
        customerButton = redrawButton("Customers", CUSTOMER, SHOW_SIGN_IN);
        signInButton = signedIn
            ? redrawButton("Sign Out", ImageType.SIGN_OUT, SIGN_OUT)
            : redrawButton("Sign In", ImageType.SIGN_IN, SHOW_SIGN_IN);
        ObservableList<Node> buttonList = buttonBox.getChildren();
        buttonList.clear();
        if (signedIn) {
            buttonList.addAll(aboutButton, bookButton, customerButton,
                signInButton, exitButton);
        } else {
            buttonList.addAll(aboutButton, signUpButton, signInButton, exitButton);
        }
    }

    private Button redrawButton(String text, ImageType image, BehaviorType behavior) {
        Label label = LabelBuilder.getButtonLabel(text);
        ImageView imageView = ImageBuilder.getImageView(image, imageWidth);
        return GeneralButton.getMainButton(label, imageView, behavior);
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
