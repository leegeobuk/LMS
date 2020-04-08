package woowa.lms.front.behavior.book;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import woowa.lms.back.service.RentalService;
import woowa.lms.back.util.SpringContext;
import woowa.lms.front.behavior.Behavior;
import woowa.lms.front.model.BookModel;
import woowa.lms.front.ui.form.book.LendBookForm;
import woowa.lms.front.ui.table.BookTable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LendBook implements Behavior {

    private RentalService rentalService = SpringContext.getBean(RentalService.class);

    private static final LendBook INSTANCE = new LendBook();

    public static LendBook getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(ActionEvent event) {
        ObservableList<BookModel> selections = BookTable.getInstance().getSelections();
        String userId = LendBookForm.FORM.getFields().get(0).getText();
        Long[] itemIds = new Long[selections.size()];
        for (int i = 0; i < selections.size(); i++) {
            itemIds[i] = selections.get(i).getId();
        }
        rentalService.lendBooks(userId, itemIds);
        BookTable.getInstance().update();
        LendBookForm.FORM.close();
    }
}
