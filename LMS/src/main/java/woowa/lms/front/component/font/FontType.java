package woowa.lms.front.component.font;

import lombok.Getter;

public enum FontType {

    EULJIRO("BMEULJIROTTF.ttf"),
    HANNA_11("BMHANNA_11yrs_ttf.ttf");

    @Getter
    private final String fontUrl;

    FontType(String fontUrl) {
        this.fontUrl = "file:src/main/resources/font/" + fontUrl;
    }
}
