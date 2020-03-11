package woowa.lms.front.components.button;

import javafx.scene.control.Label;
import woowa.lms.front.components.button.behavior.ClickAbout;
import woowa.lms.front.components.button.behavior.ClickBehavior;

public class AboutButton extends CustomButton {

    private static final String TEXT = "About";
    private static final ClickBehavior BEHAVIOR = ClickAbout.getInstance();

    private AboutButton(Label label) {
        super(label);
        clickBehavior = BEHAVIOR;
    }

    public static AboutButton of(Label label) {
        AboutButton aboutButton = new AboutButton(label);
        aboutButton.setText(TEXT);
        aboutButton.setFont(label.getFont());
        aboutButton.setTextFill(label.getTextFill());
        return aboutButton;
    }

    @Override
    public void clicked() {
        this.setOnAction(clickBehavior.click());
    }
}
