package woowa.lms.front.components.font;

import javafx.scene.text.Font;
import lombok.Getter;
import lombok.Setter;

public enum FontType {

    EULJIRO("file:src/main/resources/font/BMEULJIROTTF.ttf");

    public static final int DEFAULT_SIZE = 10;

    private final String fontUrl;

    @Getter @Setter
    private double size = DEFAULT_SIZE;

    FontType(String fontUrl) {
        this.fontUrl = fontUrl;
    }

    public Font getFont() {
        return Font.loadFont(fontUrl, size);
    }
}
