package woowa.lms.front.foolproof.signup;

import javafx.scene.control.TextField;
import woowa.lms.front.foolproof.FieldFoolProof;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactFieldFoolProof implements FieldFoolProof {

    private Pattern pattern;
    private Matcher matcher;

    private static final String MESSAGE = "Contact should be 10 to 11 digits long";
    private static final String PATTERN = "^\\d{10,11}$";
    private static final ContactFieldFoolProof INSTANCE = new ContactFieldFoolProof();

    public static ContactFieldFoolProof getInstance() {
        return INSTANCE;
    }

    public ContactFieldFoolProof() {
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
