package woowa.lms.front.page.main;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import woowa.lms.front.components.button.CustomButton;
import woowa.lms.front.page.main.button.signup.SignUpButton;

import java.io.IOException;

public class MainPage {

    private Stage primaryStage;
    private Scene scene;
    private VBox vb;
    private HBox hb;
    private Image image;
    private CustomButton signUpButton;
    private static final String PATH = "file:src/main/resources/image/Logo.jpg";

    public MainPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        vb = new VBox();
        hb = new HBox(50);
        signUpButton = SignUpButton.of("Sign Up");
        image = new Image(PATH, 700, 450, false, false);
        scene = new Scene(vb, 700, 500);
    }

    public void initDialog() {
        ImageView iv = new ImageView(image);
        vb.getChildren().addAll(iv, hb);
        hb.getChildren().add(signUpButton);
//        hb.getChildren().addAll(createLMS, load, delete, createAccount, quit);
        hb.setFillHeight(true);
        signUpButton.setMinSize(100, 50);
//        load.setMinSize(100, 50);
//        delete.setMinSize(100, 50);
//        createAccount.setMinSize(100, 50);
//        quit.setMinSize(100, 50);
    }

    public void initButtons() {
//        createLMS.
//        createAccount
//        load
//        delete
//        quit
    }

    public void show() throws IOException {
        initDialog();
        initButtons();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Welcome!");
        primaryStage.show();
    }

}
