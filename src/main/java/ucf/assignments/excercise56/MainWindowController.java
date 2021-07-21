package ucf.assignments.excercise56;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class MainWindowController {
    @FXML
    private TableView<?> itemsTableView;

    @FXML
    private TableColumn<?, ?> itemSerialNumberColumn;

    @FXML
    private TableColumn<?, ?> itemNameColumn;

    @FXML
    private TableColumn<?, ?> itemsValueColumn;

    @FXML
    private TextField itemSerialNumberField;

    @FXML
    void addNewItemButtonClicked(ActionEvent event){
        String sn = itemSerialNumberField.getText();
        String name = itemNameTextField.getText();
        double value = itemPriceTextField.getText();

        Item item = addNewItem(sn, name, value);

        ItemModel.add(Item);
    }

    public void addNewItem(String sn, String name, double value){
        return new Item(sn, name, value);
    }

    void saveAsButtonClicked(ActionEvent event){
        filename = FileChooser.getname();
        filetype = FileChooser.getType();

        if(filetype == 'CSV'){
            saveAsCSV(filename + filetype);
        }
    }

    public void saveAsCSV(String filename){
        /*
        open up filename
        for each item in the item model:
            write the item to file as sn, name, price
        close file
         */
    }

}
