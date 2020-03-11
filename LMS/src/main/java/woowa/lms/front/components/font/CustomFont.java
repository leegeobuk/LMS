package woowa.lms.front.components.font;

import javafx.scene.text.Font;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public abstract class CustomFont {

    @Setter(value = AccessLevel.NONE)
    String url;
    double size;

    public abstract Font toFont();

}
