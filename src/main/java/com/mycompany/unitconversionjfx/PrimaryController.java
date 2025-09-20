package com.mycompany.unitconversionjfx;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {
    
    @FXML
    private Label result; // Label, to show the result of conversion
    
    // Inputs
    @FXML
    private TextField userInput; // User input field, should be float
    @FXML
    private ComboBox<Unit> initialUnit; // Users selected initial Unit of measurement
    @FXML
    private ComboBox<Unit> targetUnit; // Users selected target Unit of measurement
    
    /**
     * Runs when the FXML elements are initialised, adding all unit elements
     * from App.units to the two ComboBoxes, initalUnit and targetUnit.
     */
    @FXML
    private void initialize(){
        for(Unit unit:App.units) {
            initialUnit.getItems().add(unit);
            targetUnit.getItems().add(unit);
        }
    }
    
    /**
     * Method reads value from userInput and checks that it can be converted to
     * a float, then calls Converter.convertTo() to convert the value. The result
     * will be passed to the result label.
     */
    @FXML
    private void convert() {
        float value = 0;
        try{
            value = Float.parseFloat(userInput.getText());
            
        } catch(NumberFormatException e){
            System.err.print(e);
        }
        
        value = Converter.convertTo(initialUnit.getValue(), targetUnit.getValue(), value);
        
        result.setText(Float.toString(value));
    }
}
