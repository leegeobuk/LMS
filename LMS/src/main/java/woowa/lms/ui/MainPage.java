package woowa.lms.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainPage {

    private Stage primaryStage;
    private Scene scene;
    private Pane pane;
    private HBox hBox;
    private Label label;
    private Button button;

    public MainPage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        button = new Button("click");
        label = new Label("Hello world");
        hBox = new HBox();
        hBox.getChildren().addAll(label, button);
        pane = new Pane(hBox);
        scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello World!");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
    }

    public void show() {
        primaryStage.show();
    }

}
