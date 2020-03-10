package woowa.lms.front.components.font;

import javafx.scene.text.Font;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
public abstract class CustomFont {

    @Setter(value = AccessLevel.NONE)
    protected String url;
    protected double size;

    public abstract Font create();

}
