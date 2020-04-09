package woowa.lms.front.ui.form.book;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import woowa.lms.front.component.button.GeneralButton;
import woowa.lms.front.component.label.LabelBuilder;
import woowa.lms.front.component.textfield.InputField;
import woowa.lms.front.ui.form.AbstractForm;
import woowa.lms.front.ui.table.BookTable;

import java.time.LocalDate;
import java.util.List;

import static javafx.scene.control.ContentDisplay.GRAPHIC_ONLY;
import static woowa.lms.front.behavior.BehaviorType.*;
import static woowa.lms.front.component.image.ImageBuilder.*;
import static woowa.lms.front.component.image.ImageType.USER;
import static woowa.lms.front.component.textfield.InputType.TEXT;
import static woowa.lms.front.foolproof.FoolProofType.NOT_EMPTY;

public class LendBookForm extends AbstractForm {

    private Label idLabel;
    private Label nameLabel;
    private Label contactLabel;
    private Label lendLabel;
    private Label returnLabel;
    private InputField idInputField = InputField.of(TEXT, NOT_EMPTY, "User Id");
    private InputField nameInputField = InputField.of(TEXT, NOT_EMPTY, "Name");
    private InputField contactInputField = InputField.of(TEXT, NOT_EMPTY, "Contact");
    private InputField lendInputField = InputField.of(TEXT, NOT_EMPTY, "Lend Date");
    private InputField returnInputField = InputField.of(TEXT, NOT_EMPTY, "Return Date");
    private Button userButton;

    private static final double WIDTH = 400;
    private static final double HEIGHT = 450;
    private static final String TITLE = "Lend Book Form";
    private static final String HEADER = "Lend Book";
    private static final LendBookForm FORM = new LendBookForm();

    private LendBookForm() {
        super(WIDTH, HEIGHT, TITLE, HEADER);
        inputFields = List.of(idInputField, nameInputField, contactInputField,
            lendInputField, returnInputField);
        setUpComponents();
        setUpPage();
        setFoolProof();
        setUpStage();
    }

    public static LendBookForm getForm() {
        return FORM;
    }

    @Override
    public void setUpComponents() {
        idLabel = LabelBuilder.getFormLabel("User Id");
        nameLabel = LabelBuilder.getFormLabel("Name");
        contactLabel = LabelBuilder.getFormLabel("Contact");
        lendLabel = LabelBuilder.getFormLabel("Lend Date");
        returnLabel = LabelBuilder.getFormLabel("Return Date");

        setDate();
        getFields().forEach(textField -> {
            textField.setEditable(false);
            textField.setFocusTraversable(false);
        });

        userButton = GeneralButton.builder().image(getImageView(USER, 24)).graphicGap(0)
            .display(GRAPHIC_ONLY).behavior(SHOW_SELECT_USERS).build().toButton();
        okButton = GeneralButton.getFormButton(FORM_BUTTON_OK, LEND_BOOK);
        cancelButton = GeneralButton.getFormButton(FORM_BUTTON_CANCEL, CLOSE);
        super.setUpComponents();
    }

    private void setDate() {
        LocalDate lendDate = LocalDate.now();
        LocalDate returnDate = lendDate.plusDays(14);
        lendInputField.getTextField().setText(lendDate.toString());
        returnInputField.getTextField().setText(returnDate.toString());
    }

    @Override
    public void setUpPage() {
        formPane.addRow(0, idLabel, idInputField.toTextField());
        formPane.addRow(1, nameLabel, nameInputField.toTextField());
        formPane.addRow(2, contactLabel, contactInputField.toTextField());
        formPane.addRow(3, lendLabel, lendInputField.toTextField());
        formPane.addRow(4, returnLabel, returnInputField.toTextField());
        formPane.addRow(5, userButton);
        formPane.setHgap(WIDTH * 0.08);
        formPane.setVgap(HEIGHT * 0.02);
        formPane.setAlignment(Pos.CENTER);
        super.setUpPage();
    }

    @Override
    public void setFoolProof() {
        formFoolProof = null;
    }

    @Override
    public void setUpStage() {
        super.setUpStage();
        this.initOwner(BookTable.getTable());
    }

    @Override
    public void close() {
        inputFields.forEach(InputField::clear);
        setDate();
        okButton.setDisable(true);
        this.hide();
    }
}
