package woowa.lms.front.components.background;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.CornerRadii;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class CustomBackground {

    protected List<BackgroundFill> fills = new ArrayList<>();

    protected static final CornerRadii EMPTY_RADII = CornerRadii.EMPTY;
    protected static final Insets EMPTY_INSETS = Insets.EMPTY;

    public abstract Background create();
}
