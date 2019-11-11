package lms.app;

import javafx.application.Application;
import javafx.stage.Stage;
import lms.ui.TitlePage;

public class LMS extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        TitlePage titlePage = new TitlePage();
        titlePage.showDialog();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
