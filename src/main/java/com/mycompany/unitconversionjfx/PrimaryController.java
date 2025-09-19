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
    private ComboBox initialUnit; // Users selected initial Unit of measurement
    @FXML
    private ComboBox targetUnit; // Users selected target Unit of measurement
    
    @FXML
    private void convert() {
        float value = 0;
        try{
            value = Float.parseFloat(userInput.getText());
            
        } catch(NumberFormatException e){
            System.err.print(e);
        }
        
        result.setText(Float.toString(value));
    }
}
