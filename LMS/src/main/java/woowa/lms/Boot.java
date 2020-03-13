package woowa.lms;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot {
    public static void main(String[] args) {
        Application.launch(App.class, args);
    }
}
