package ucf.assignments.exercise56;

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
    private TableColumn<?, ?> itemValueColumn;

    @FXML
    private TextField itemSerialNumberTextField;

    @FXML
    private TextField itemNameTextField;

    @FXML
    private TextField itemValueTextField;

    @FXML
    void addNewItemButtonClicked(ActionEvent event){
        String sn = itemSerialNumberTextField.getText();
        String name = itemNameTextField.getText();
        double value = Double.parseDouble(itemValueTextField.getText());

        Item item = addNewItem(sn, name, value);

        ItemModel.add(Item);
    }

    public void addNewItem(String sn, String name, double value){
        return new Item(sn, name, value);
    }

    void saveAsButtonClicked(ActionEvent event){
        filename = FileChooser.getname();
        filetype = FileChooser.getType();

        if(filetype == 'TSV'){
            saveAsTSV(filename + filetype);
        }
    }

    public void deleteSelectedItemButtonClicked(ActionEvent actionEvent) {
        deleteSelectedItemButtonClickedSubFunction();
    }

    public void saveAsTSV(String filename){
        /*
        open up filename
        for each item in the item model:
            write the item to file as sn, name, price
        close file
         */
    }


    public void searchItemNameButtonClicked(ActionEvent actionEvent) {
        searchItemNameButtonClickedSubFunction();
    }

    public void searchSerialNumberClicked(ActionEvent actionEvent) {
        searchSerialNumberClickedSubFunction();
    }

    public void saveAsHtmlButtonClicked(ActionEvent actionEvent) {
        saveAsHtmlButtonClickedSubFunction();
    }

    public void saveAsTsvButtonClicked(ActionEvent actionEvent) {
        saveAsTsvButtonClickedSubFunction();
    }

    public void loadButtonClicked(ActionEvent actionEvent) {
        loadButtonClickedSubFunction();
    }

    public void deleteSelectedItemButtonClickedSubFunction() {
    }

    public void searchItemNameButtonClickedSubFunction() {
    }

    public void searchSerialNumberClickedSubFunction() {
    }

    public void saveAsHtmlButtonClickedSubFunction() {
    }

    public void saveAsTsvButtonClickedSubFunction() {
    }

    public void loadButtonClickedSubFunction() {
    }


}
