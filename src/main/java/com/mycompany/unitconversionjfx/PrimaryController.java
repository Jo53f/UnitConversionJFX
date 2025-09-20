package com.mycompany.unitconversionjfx;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {
    
    @FXML
    private Label result;
    
    // Inputs
    @FXML
    private TextField userInput; // User input field, should be float
    @FXML
    private ComboBox<Unit> initialUnit; // Users selected initial Unit of measurement
    @FXML
    private ComboBox<Unit> targetUnit; // Users selected target Unit of measurement
    
    @FXML
    private void initialize(){
        for(Unit unit:App.units) {
            initialUnit.getItems().add(unit);
            targetUnit.getItems().add(unit);
        }
    }
    
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
