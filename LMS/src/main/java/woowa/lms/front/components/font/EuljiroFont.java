package woowa.lms.front.components.font;

import javafx.scene.text.Font;

public class EuljiroFont extends CustomFont {

    private static final String URL = "file:src/main/resources/font/BMEULJIROTTF.ttf";

    private EuljiroFont() {
        this.url = URL;
    }

    private EuljiroFont(double size) {
        super(URL, size);
    }

    public static EuljiroFont of() {
        return new EuljiroFont();
    }

    public static EuljiroFont of(double size) {
        return new EuljiroFont(size);
    }

    @Override
    public Font create() {
        return Font.loadFont(URL, size);
    }
}
