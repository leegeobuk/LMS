package woowa.lms.front.components.background;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import org.jboss.jandex.Main;

import static javafx.geometry.Side.LEFT;
import static javafx.geometry.Side.TOP;
import static javafx.scene.layout.BackgroundRepeat.NO_REPEAT;

public class MainBackground extends CustomBackground {

    private static final String COLOR = "#2ac1bc";

    public MainBackground(String color) {
        Paint paint = Paint.valueOf(color);
        BackgroundFill fill = new BackgroundFill(paint, EMPTY_RADII, EMPTY_INSETS);
        fills.add(fill);

//        Image image = new Image(imageUrl);
//        BackgroundPosition position = new BackgroundPosition(LEFT, 0.01, true, TOP, 0.05, true);
//        BackgroundSize size = new BackgroundSize(0.16, 0.3, true, true, false, false);
//        BackgroundImage backgroundImage = new BackgroundImage(image, NO_REPEAT, NO_REPEAT, position, size);
//        images.add(backgroundImage);
    }

    public static MainBackground of() {
        return new MainBackground(COLOR);
    }

    public static MainBackground of(String color) {
        return new MainBackground(color);
    }

    @Override
    public Background create() {
        return new Background(fills.toArray(new BackgroundFill[0]));
    }
}
