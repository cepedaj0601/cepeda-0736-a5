package ucf.assignments.exercise56;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    //create table view to serve as the personal inventory
    @FXML
    private TableView<Item> itemsTableView;

    //populate the columns
    @FXML
    private TableColumn<Item, String> itemSerialNumberColumn;

    @FXML
    private TableColumn<Item, String> itemNameColumn;

    @FXML
    private TableColumn<Item, Double> itemValueColumn;

    //Text fields used to take in user input
    @FXML
    private TextField itemSerialNumberTextField;

    @FXML
    private TextField itemNameTextField;

    @FXML
    private TextField itemValueTextField;

    //function to add a new item
    @FXML
    void addNewItemButtonClicked(ActionEvent event) {
        //get item serial number
        String sn = itemSerialNumberTextField.getText();

        //get item name
        String name = itemNameTextField.getText();

        //get item value
        double value = Double.parseDouble(itemValueTextField.getText());

        //add new item to inventory with acquired information
        //call sub function
        addNewItemButtonClickedSubFunction();
    }

    //function to create an item with given serial number, name, and value
    public void addNewItemButtonClickedSubFunction(){

    }

    public void deleteSelectedItemButtonClicked(ActionEvent actionEvent) {
        deleteSelectedItemButtonClickedSubFunction();
    }

    //function to find an item by name
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
        /*
        open up filename
        for each item in the item model:
            write the item to file as sn, name, price
        close file
         */

    }

    public void saveAsTsvButtonClickedSubFunction() {
    /*
        open up filename
        for each item in the item model:
            write the item to file as sn, name, price
        close file
         */

    }

    public void loadButtonClickedSubFunction() {
    }

    //initialize controller class
    @Override
    public void initialize (URL url, ResourceBundle resources) {

        //set up the columns of the table
        itemSerialNumberColumn.setCellValueFactory(new PropertyValueFactory<>("itemSerialNumber"));
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        itemValueColumn.setCellValueFactory(new PropertyValueFactory<>("itemValue"));

        //load in some information
        itemsTableView.setItems(getItems());

        //update the list to permit for changes of the item names and descriptions
        itemsTableView.setEditable(true);
        itemSerialNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        itemNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
      //  itemValueColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public ObservableList<Item> getItems(){
        //set up list
        ObservableList<Item> items = FXCollections.observableArrayList();

        //return an ObservableList of Item Objects
        return items;
    }
}
