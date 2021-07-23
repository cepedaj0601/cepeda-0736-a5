package ucf.assignments.exercise56;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainWindowControllerTest {

    @Test
    void addNewItemTest() {
        //call function
        MainWindowController MainTest = new MainWindowController();

        //create dummy variables
      //  MainTest.itemSerialNumberTextField.setText("abcde12345");

        //set actual to return of function
        int actual = MainTest.addNewItemButtonClickedSubFunction();

        //set expected to 1
        int expected = 1;

        //assert equals
        assertEquals(expected, actual);
    }

    @Test
    void serialNumberValidatorTest() {
        //create class object
        MainWindowController MainTest = new MainWindowController();

        //create dummy value
        String serialNumber = "abcde12345";

        //set actual to return of function
        boolean actual = MainTest.serialNumberValidator();

        //set expected to false
        boolean expected = false;

        assertEquals(expected, actual);
    }
/*
    @Test
    void duplicateSerialNumberChecker() {
    }

    @Test
    void itemNameValidator() {
    }

    @Test
    void itemValueValidator() {
    }

    @Test
    void deleteSelectedItemButtonClickedSubFunction() {
    }

    @Test
    void searchItemNameButtonClickedSubFunction() {
    }

    @Test
    void searchSerialNumberClickedSubFunction() {
    }

    @Test
    void saveAsHtmlButtonClickedSubFunction() {
    }

    @Test
    void saveAsTsvButtonClickedSubFunction() {
    }

    @Test
    void loadButtonClickedSubFunction() {
    }

 */
}