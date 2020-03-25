package woowa.lms.front.foolproof;

import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactFoolProof implements FieldFoolProof {

    private Pattern pattern;
    private Matcher matcher;

    private static final String MESSAGE = "Contact should be 10 to 11 digits long";
    private static final String PATTERN = "^\\d{10,11}$";
    private static final ContactFoolProof INSTANCE = new ContactFoolProof();

    public static ContactFoolProof getInstance() {
        return INSTANCE;
    }

    public ContactFoolProof() {
        pattern = Pattern.compile(PATTERN);
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
