package woowa.lms.front.foolproof.table;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import lombok.Builder;
import woowa.lms.front.foolproof.FoolProof;

import java.util.List;

@Builder
public class TableFoolProof<S> implements FoolProof<MouseEvent> {

    private final TableView<S> tableView;

    private final List<Button> buttons;

    @Override
    public void handle(MouseEvent event) {
        boolean disabled = tableView.getSelectionModel().getSelectedItems().size() == 0;
        buttons.forEach(button -> button.setDisable(disabled));
    }
}
