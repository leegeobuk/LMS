package woowa.lms.front;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainPage {

    private Stage primaryStage;
    private Scene scene;
    private VBox vb;
    private HBox hb;
    private Image image;
    private Button createLMS;
    private Button createAccount;
    private Button load;
    private Button delete;
    private Button quit;
    private static final String PATH = "./src/main/resources/image/Logo.jpg";

    public MainPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        vb = new VBox();
        hb = new HBox(50);
        createLMS = new Button("Create LMS");
        load = new Button("Load LMS");
        delete = new Button("Delete LMS");
        createAccount = new Button("Create Account");
        quit = new Button("Quit LMS");
//        image = new Image(PATH, 700, 450, false, false);

    }

    public void initDialog() {
//        ImageView iv = new ImageView(image);
//        vb.getChildren().addAll(iv, hb);
        vb.getChildren().addAll(hb);
        hb.getChildren().addAll(createLMS, load, delete, createAccount, quit);
        hb.setFillHeight(true);
        createLMS.setMinSize(100, 50);
        load.setMinSize(100, 50);
        delete.setMinSize(100, 50);
        createAccount.setMinSize(100, 50);
        quit.setMinSize(100, 50);
    }

    public void initButtons() {
//        createLMS
//        createAccount
//        load
//        delete
//        quit
    }

    public void show() throws IOException {
        initDialog();
        initButtons();
        scene = new Scene(vb, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Welcome!");
        primaryStage.show();
        System.out.println(PATH);
//        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(PATH)));
//        bw.flush();
//        bw.close();
    }

}
