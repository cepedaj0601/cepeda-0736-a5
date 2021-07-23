package ucf.assignments.exercise56;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    //storage variables
    public String serialNumber;
    public String itemName;
    public Double itemValue;

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

    @FXML
    public TextField searchItemNameTextField;

    @FXML
    public TextField searchSerialNumberTextField;

    //Labels to display error messages
    @FXML
    public Label serialNumberLabel;

    @FXML
    public Label duplicateSerialNumberLabel;

    @FXML
    public Label itemNameLabel;

    @FXML
    public Label itemValueLabel;

    //function to add a new item
    @FXML
    void addNewItemButtonClicked(ActionEvent event) {
        //add new item to inventory with acquired information
        //call sub function
        addNewItemButtonClickedSubFunction();


    }

    //function to create an item with given serial number, name, and value
    public void addNewItemButtonClickedSubFunction(){
        //create a new item
        Item newItem = new Item(itemSerialNumberTextField.getText(), itemNameTextField.getText(),
                Double.parseDouble(itemValueTextField.getText()));

        //call validators
        if(serialNumberValidator()/* && duplicateSerialNumberChecker() TODO*/&& itemNameValidator()){
            //get all list items
            //add new item to list
            itemsTableView.getItems().add(newItem);
        }

    }

    //function to detect errors with serial number input
    public boolean serialNumberValidator(){
        //take in the current input
        serialNumber = itemSerialNumberTextField.getText();

        //compare input with allowed values
        for (int i = 0; i < serialNumber.length(); i++) {


            //if it is not within the constraints, display the appropriate error message
            if (!serialNumber.matches(".*[a-zA-Z0-9]+.*")) {
                serialNumberLabel.setText("Enter only letters & numbers");

                //resize font
                serialNumberLabel.setFont(Font.font("System", 10));

                //return false to indicate an error
                return false;
            }

            //ensure length is valid
            else if(serialNumber.length() != 10){
                //display error message
                serialNumberLabel.setText("Must be 10 characters long");

                //resize font
                serialNumberLabel.setFont(Font.font("System", 10));

                //return false to indicate an error
                return false;
            }
        }

        //else display nothing
        serialNumberLabel.setText("");

        //return true to indicate no error
        return true;
    }

    //function to check if serial number already exists
    public boolean duplicateSerialNumberChecker(){//TODO
        //take in current input
        serialNumber = itemSerialNumberTextField.getText();

        //take in list of all items
        ObservableList<Item> allItems;
        allItems = itemsTableView.getItems();

        //check if the list is empty
        if(itemsTableView.getItems().isEmpty()){

            //return as false to indicate that the input does not appear in the current list
            return false;
        }

        //cross reference list with input
        for (Item item: allItems) {

            //if input appears in list, display error message
            if (item.getItemSerialNumber().equals(serialNumber)) {
                duplicateSerialNumberLabel.setText("Serial Number already exists");

                //resize text
                duplicateSerialNumberLabel.setFont((Font.font("System", 10)));

                //return true to indicate that a duplicate was found
                return true;
            }
        }

        //else, display nothing and set as false to indicate that the input does not appear in the current list
        duplicateSerialNumberLabel.setText("");
        return false;
    }

    //function to detect errors with item name input
    public boolean itemNameValidator(){
        //take in the current input
        itemName = itemNameTextField.getText();

        //compare input with allowed lengths

        //if it is not within the constraints, display the appropriate error message
        if (itemName.length() <2) {
             itemNameLabel.setText("Name is too short");

             //resize font
            itemNameLabel.setFont(Font.font("System", 10));
            //return false to indicate an error
            return false;
        }

        if (itemName.length() >256) {
            itemNameLabel.setText("Name is too long");

            //resize font
            itemNameLabel.setFont(Font.font("System", 10));
            //return false to indicate an error
            return false;
        }


        //else display nothing
        itemNameLabel.setText("");

        //return true to indicate no error
        return true;
    }

    //function to detect errors with item value input
    public boolean itemValueValidator(){
        //take in the current input
        itemValue = Double.parseDouble(itemValueTextField.getText());

        //compare input with allowed values
        //if it is within the constraints, display nothing
        //if it is not within the constraints, display the appropriate error message
        return false;
    }

/*
    public void changeItemSerialNumberCellEvent(TableColumn.CellEditEvent editedCell){TODO get rid of  this
        //edit the name of an item
        //get the current value
        Item itemSelected = itemsTableView.getSelectionModel().getSelectedItem();

        //update the value to entered text
        itemSelected.setItemSerialNumber(editedCell.getNewValue().toString());
    }

    public void changeItemNameCellEvent(TableColumn.CellEditEvent editedCell){
        //edit the name of an item
        //get the current value
        Item itemSelected = itemsTableView.getSelectionModel().getSelectedItem();

        //update the value to entered text
        itemSelected.setItemName(editedCell.getNewValue().toString());
    }

    public void changeItemValueCellEvent(TableColumn.CellEditEvent editedCell){
        //edit the name of an item
        //get the current value
        Item itemSelected = itemsTableView.getSelectionModel().getSelectedItem();

        //update the value to entered text
        itemSelected.setItemValue(Double.parseDouble(editedCell.getNewValue().toString()));
    }

 */

    public void deleteSelectedItemButtonClicked(ActionEvent actionEvent) {
        //call sub function
        deleteSelectedItemButtonClickedSubFunction();
    }

    public void deleteSelectedItemButtonClickedSubFunction() {
        //get list of all items
        ObservableList<Item> selectedRows, allItems;
        allItems = itemsTableView.getItems();

        //get list of all selected items
        selectedRows = itemsTableView.getSelectionModel().getSelectedItems();

        //in a for loop the size of the item list, remove the selected items from the item list
        for (Item item: selectedRows) {
            allItems.remove(item);
        }
    }

    //function to find an item by name
    public void searchItemNameButtonClicked(ActionEvent actionEvent) {
        //call sub function
        searchItemNameButtonClickedSubFunction();
    }

    public void searchItemNameButtonClickedSubFunction() {//TODO
        //take in the list
        //take in the input to be searched
        //cross reference the list and the input
        //if the input is found in the list
            //create a new observable list
            //populate the new list with the matching item name(s)
            //set the tableview to display that list
        //else, set label text to notify the user that nothing was found
    }

    //TODO need to make a back button to exit from the search


    public void searchSerialNumberClicked(ActionEvent actionEvent) {
        //call sub function
        searchSerialNumberClickedSubFunction();
    }

    public void searchSerialNumberClickedSubFunction() {//TODO
        //take in the list
        //take in the input to be searched
        //cross reference the list and the input
        //if the input is found in the list
            //create a new observable list
            //populate the new list with the matching serial number
            //set the tableview to display that list
        //else, set label text to notify the user that nothing was found
    }

    //TODO need to make a back button to exit from the search


    public void saveAsHtmlButtonClicked(ActionEvent actionEvent) {
        //call sub function
        saveAsHtmlButtonClickedSubFunction();
    }

    public void saveAsHtmlButtonClickedSubFunction() {//TODO
        /*
        open up filename
        for each item in the item model:
            write the item to file as sn, name, price
        close file
         */
    }

    public void saveAsTsvButtonClicked(ActionEvent actionEvent) {
        //call sub function
        saveAsTsvButtonClickedSubFunction();
    }

    public void saveAsTsvButtonClickedSubFunction() {//TODO
    /*
        open up filename
        for each item in the item model:
            write the item to file as sn, name, price
        close file
         */
    }

    public void loadButtonClicked(ActionEvent actionEvent) {
        //call sub function
        loadButtonClickedSubFunction();
    }

    public void loadButtonClickedSubFunction() {//TODO
    }

    //initialize controller class
    @Override
    public void initialize (URL url, ResourceBundle resources) {
        //initialize labels
        serialNumberLabel.setText("");
        itemNameLabel.setText("");
        itemValueLabel.setText("");

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
     //   itemValueColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public ObservableList<Item> getItems(){
        //set up list
        ObservableList<Item> items = FXCollections.observableArrayList();

        //return an ObservableList of Item Objects
        return items;
    }
}
