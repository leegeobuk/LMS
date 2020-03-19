package woowa.lms.front.component.font;

import javafx.scene.text.Font;
import lombok.Builder;
import lombok.Setter;

@Builder
@Setter
public class FontBuilder implements CustomFont {

    private static final FontType DEFAULT_FONT_TYPE = FontType.EULJIRO;
    private static final int DEFAULT_SIZE = FontType.DEFAULT_SIZE;

    public static final FontBuilder DEFAULT_FONT = FontBuilder.builder().build();

    @Builder.Default
    private FontType font = DEFAULT_FONT_TYPE;

    @Builder.Default
    private double size = DEFAULT_SIZE;

    @Override
    public Font toFont() {
        font.setSize(size);
        return font.getFont();
    }
}
