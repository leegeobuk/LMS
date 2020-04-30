package woowa.lms;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import woowa.lms.front.controller.MainController;

import java.util.Locale;

@SpringBootApplication
@EnableJpaAuditing
public class App extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(App.class).run();
    }

    @Override
    public void start(Stage primaryStage) {
        Locale.setDefault(Locale.US);
        MainController.getController().showMainPage();
    }

    @Override
    public void stop() {
        applicationContext.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
