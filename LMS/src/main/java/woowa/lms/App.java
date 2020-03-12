package woowa.lms;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import woowa.lms.front.page.MainPage;

@SpringBootApplication
public class App extends Application {

    private ConfigurableApplicationContext applicationContext;
//    @Autowired
//    private MainPage mainPage;
    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(App.class).run();
    }

    @Override
    public void start(Stage primaryStage) {
        MainPage mainPage = (MainPage) applicationContext.getBean("mainPage");
        primaryStage.setScene(mainPage.show());
        primaryStage.setTitle("Woowa Library Management System");
        primaryStage.show();
    }

    @Override
    public void stop() {
        applicationContext.close();
    }
}
