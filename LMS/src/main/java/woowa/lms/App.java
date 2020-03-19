package woowa.lms;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import woowa.lms.back.controller.HomeController;

import java.util.Locale;

public class App extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(Boot.class).run();
    }

    @Override
    public void start(Stage primaryStage) {
        Locale.setDefault(Locale.US);
        HomeController.showMainPage();
    }

    @Override
    public void stop() {
        applicationContext.close();
    }
}
