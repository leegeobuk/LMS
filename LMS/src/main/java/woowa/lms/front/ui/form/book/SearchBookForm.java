package woowa.lms.front.ui.form.book;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.component.textfield.InputField;
import woowa.lms.front.foolproof.form.SearchFoolProof;
import woowa.lms.front.ui.form.AbstractForm;

import java.util.List;

import static woowa.lms.front.behavior.BehaviorType.CLOSE_FORM;
import static woowa.lms.front.behavior.BehaviorType.SEARCH_BOOK;
import static woowa.lms.front.component.image.ImageBuilder.FORM_BUTTON_CANCEL;
import static woowa.lms.front.component.image.ImageBuilder.FORM_BUTTON_OK;
import static woowa.lms.front.component.textfield.InputType.TEXT;
import static woowa.lms.front.foolproof.FoolProofType.NOT_EMPTY;

public class SearchBookForm extends AbstractForm {

    private Label titleLabel;
    private Label authorLabel;
    private InputField titleInputField = InputField.of(TEXT, NOT_EMPTY, "Title");
    private InputField authorInputField = InputField.of(TEXT, NOT_EMPTY, "Author");

    private static final double WIDTH = 450;
    private static final double HEIGHT = 300;
    private static final String TITLE = "Search Book Form";
    private static final String HEADER = "Search Book";
    public static final SearchBookForm FORM = new SearchBookForm();

    private SearchBookForm() {
        super(WIDTH, HEIGHT, TITLE, HEADER);
        inputFields = List.of(titleInputField, authorInputField);
        setUpComponents();
        setUpPage();
        setFoolProof();
        setUpStage();
    }

    @Override
    public void setUpComponents() {
        titleLabel = LabelBuilder.getFormLabel("Title");
        authorLabel = LabelBuilder.getFormLabel("Author");

        okButton = GeneralButton.getFormButton(FORM_BUTTON_OK, SEARCH_BOOK);
        cancelButton = GeneralButton.getFormButton(FORM_BUTTON_CANCEL, CLOSE_FORM);
        super.setUpComponents();
    }

    @Override
    public void setUpPage() {
        form.addRow(0, titleLabel, titleInputField.toTextField());
        form.addRow(1, authorLabel, authorInputField.toTextField());
        form.add(errorLabel, 0, 2, 2, 2);
        form.setHgap(WIDTH * 0.08);
        form.setVgap(HEIGHT * 0.02);
        form.setAlignment(Pos.CENTER);
        getFields().forEach(textField -> textField.setPrefWidth(WIDTH * 0.5));
        super.setUpPage();
    }

    @Override
    public void setFoolProof() {
        formFoolProof = SearchFoolProof.builder().button(okButton)
            .errorLabel(errorLabel).inputFields(inputFields).build();
        inputFields.forEach(inputField -> inputField.setOnKeyReleased(formFoolProof));
    }
}
