package woowa.lms;

import javafx.application.Application;
import javafx.stage.Stage;
import woowa.lms.ui.MainPage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        MainPage mainPage = new MainPage(primaryStage);
        mainPage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
