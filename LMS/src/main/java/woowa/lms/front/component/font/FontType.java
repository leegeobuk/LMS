package woowa.lms.front.component.font;

import javafx.scene.text.Font;
import lombok.Getter;
import lombok.Setter;

public enum FontType {

    EULJIRO("BMEULJIROTTF.ttf"),
    HANNA_AIR("BMHANNAAir_ttf.ttf"),
    HANNA_11("BMHANNA_11yrs_ttf.ttf");


    public static final int DEFAULT_SIZE = 10;

    private final String fontUrl;

    @Getter
    @Setter
    private double size = DEFAULT_SIZE;

    FontType(String fontUrl) {
        this.fontUrl = "file:src/main/resources/font/" + fontUrl;
    }

    public Font getFont() {
        return Font.loadFont(fontUrl, size);
    }
}
