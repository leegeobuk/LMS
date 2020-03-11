package woowa.lms.front.components.font;

import javafx.scene.text.Font;

public class EuljiroFont extends CustomFont {

    private static final String URL = "file:src/main/resources/font/BMEULJIROTTF.ttf";

    private EuljiroFont(double size) {
        super(URL, size);
    }

    public static Font of(double size) {
        return new EuljiroFont(size).toFont();
    }

    @Override
    public Font toFont() {
        return Font.loadFont(URL, size);
    }
}
