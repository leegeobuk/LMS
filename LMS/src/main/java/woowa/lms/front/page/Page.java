package woowa.lms.front.page;

import javafx.scene.Scene;

public interface Page {

    void setUpComponents();

    void setUpPage();

    Scene show();
}
