package woowa.lms.front.components.label;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import woowa.lms.front.components.font.CustomFont;
import woowa.lms.front.components.font.EuljiroFont;

public class MainLabel extends CustomLabel {

    private static final CustomFont FONT = EuljiroFont.of();

    private MainLabel(String text, Color color, double size) {
        super(text, color, FONT, size);
    }

    public static MainLabel of(String text, Color color, double size) {
        return new MainLabel(text, color, size);
    }

    @Override
    public Label create() {
        Label label = new Label(text);
        label.setFont(font.create());
        label.setTextFill(Paint.valueOf(color.toString()));
        return label;
    }
}
