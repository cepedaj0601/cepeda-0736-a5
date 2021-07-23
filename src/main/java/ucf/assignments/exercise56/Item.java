package ucf.assignments.exercise56;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Item  {
    //class for each item of the tableview

    //create data types to hold the names, numbers, and values
    private final SimpleStringProperty itemSerialNumber;
    private final SimpleStringProperty itemName;
    private final SimpleDoubleProperty itemValue;

    //create constructor
    public Item(String itemSerialNumber, String itemName, Double itemValue) {
        this.itemSerialNumber = new SimpleStringProperty(itemSerialNumber);
        this.itemName = new SimpleStringProperty(itemName);
        this.itemValue = new SimpleDoubleProperty(itemValue);
    }

    //create getters and setters
    public String getItemSerialNumber() {
        return itemSerialNumber.get();
    }

    public SimpleStringProperty itemSerialNumberProperty() {
        return itemSerialNumber;
    }

    public void setItemSerialNumber(String itemSerialNumber) {
        this.itemSerialNumber.set(itemSerialNumber);
    }

    public String getItemName() {
        return itemName.get();
    }

    public SimpleStringProperty itemNameProperty() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName.set(itemName);
    }

    public Double getItemValue() {
        return itemValue.get();
    }

    public void setItemValue(Double itemValue) {
        this.itemValue.set(itemValue);
    }
}
