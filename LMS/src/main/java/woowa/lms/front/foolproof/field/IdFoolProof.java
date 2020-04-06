package woowa.lms.front.foolproof.field;

import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdFoolProof implements FieldFoolProof {

    private Pattern pattern;
    private Matcher matcher;

    private static final String MESSAGE = "Id is a combination of characters and numbers starting with a character with length of 5 to 15";
    private static final String PATTERN = "^[A-Za-z][A-Za-z\\d]{4,14}$";
    private static final IdFoolProof INSTANCE = new IdFoolProof();

    public IdFoolProof() {
        pattern = Pattern.compile(PATTERN);
    }

    public static IdFoolProof getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean validate(TextField textField) {
        matcher = pattern.matcher(textField.getText());
        return matcher.matches();
    }

    @Override
    public String sendValidationMessage() {
        return MESSAGE;
    }
}
