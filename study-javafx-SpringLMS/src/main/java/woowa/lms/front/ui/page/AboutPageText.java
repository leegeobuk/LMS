package woowa.lms.front.ui.page;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import woowa.lms.front.component.font.FontType;

public class AboutPageText {

    private static final String CONTENT =
        "Woowa Library Management System is a desktop application that helps to manage " +
            "the items of library. It supports basic CRUD operations for both library " +
            "items and customers. It is designed to be extensible and easy to maintain.\n" +
            "It was developed to show how much passion and love the developer has " +
            "toward Woowa Brothers. Should you have any inquiries or requests, " +
            "feel free to contact.\n\nE-mail: leegeobuk@gmail.com\nTel: 010-9699-0080";
    private static final FontType FONT = FontType.EULJIRO;
    private static final double SIZE = 15;

    private static final AboutPageText INSTANCE = new AboutPageText();

    public static AboutPageText getInstance() {
        return INSTANCE;
    }

    public Text toText() {
        Text text = new Text(CONTENT);
        text.setFont(Font.loadFont(FONT.getFontUrl(), SIZE));
        return text;
    }


}
