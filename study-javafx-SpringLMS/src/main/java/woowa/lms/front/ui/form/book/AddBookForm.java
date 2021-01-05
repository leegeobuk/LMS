package woowa.lms.front.ui.form.book;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.component.textfield.InputField;
import woowa.lms.front.ui.form.AbstractForm;
import woowa.lms.front.ui.table.BookTable;

import java.util.List;

import static woowa.lms.front.behavior.BehaviorType.ADD_BOOK;
import static woowa.lms.front.behavior.BehaviorType.CLOSE;
import static woowa.lms.front.component.image.ImageBuilder.FORM_BUTTON_CANCEL;
import static woowa.lms.front.component.image.ImageBuilder.FORM_BUTTON_OK;
import static woowa.lms.front.component.textfield.InputType.TEXT;
import static woowa.lms.front.foolproof.FoolProofType.NOT_EMPTY;
import static woowa.lms.front.foolproof.FoolProofType.STOCK;

public class AddBookForm extends AbstractForm {

    private Label titleLabel;
    private Label authorLabel;
    private Label stockLabel;
    private InputField titleInputField = InputField.of(TEXT, NOT_EMPTY, "Title");
    private InputField authorInputField = InputField.of(TEXT, NOT_EMPTY, "Author");
    private InputField stockInputField = InputField.of(TEXT, STOCK, "Stock");

    private static final double WIDTH = 400;
    private static final double HEIGHT = 350;
    private static final String TITLE = "Add Book Form";
    private static final String HEADER = "Add Book";
    private static final AddBookForm FORM = new AddBookForm();

    private AddBookForm() {
        super(WIDTH, HEIGHT, TITLE, HEADER);
        inputFields = List.of(titleInputField, authorInputField, stockInputField);
        setUpComponents();
        setUpPage();
        setFoolProof();
        setUpStage();
    }

    public static AddBookForm getForm() {
        return FORM;
    }

    @Override
    public void setUpComponents() {
        titleLabel = LabelBuilder.getFormLabel("Title");
        authorLabel = LabelBuilder.getFormLabel("Author");
        stockLabel = LabelBuilder.getFormLabel("Stock");

        okButton = GeneralButton.getFormButton(FORM_BUTTON_OK, ADD_BOOK);
        cancelButton = GeneralButton.getFormButton(FORM_BUTTON_CANCEL, CLOSE);
        super.setUpComponents();
    }

    @Override
    public void setUpPage() {
        formPane.addRow(0, titleLabel, titleInputField.toTextField());
        formPane.addRow(1, authorLabel, authorInputField.toTextField());
        formPane.addRow(2, stockLabel, stockInputField.toTextField());
        formPane.add(errorLabel, 0, 3, 2, 2);
        formPane.setHgap(WIDTH * 0.08);
        formPane.setVgap(HEIGHT * 0.02);
        formPane.setAlignment(Pos.CENTER);
        super.setUpPage();
    }

    @Override
    public void setUpStage() {
        super.setUpStage();
        this.initOwner(BookTable.getTable());
    }
}
