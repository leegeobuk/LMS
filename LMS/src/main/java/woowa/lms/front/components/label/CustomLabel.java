package woowa.lms.front.components.label;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import lombok.Getter;
import lombok.Setter;
import woowa.lms.front.components.font.CustomFont;

@Getter @Setter
public abstract class CustomLabel {

    protected String text;
    protected CustomFont font;
    protected Color color;

    CustomLabel(String text, Color color, CustomFont font, double size) {
        this.text = text;
        this.color = color;
        this.font = font;
        this.font.setSize(size);
    }

    public abstract Label create();
}
