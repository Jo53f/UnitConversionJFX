/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unitconversionjfx;

/**
 * Stores a pair of unit and the float value in this unit.
 * 
 * @author josef
 */
public class ConversionPair {
    public Unit unit;
    public Float value;
    
    /**
     * Construct a pair of unit and its respective float value.
     * 
     * @param unit the unit object which has been converted to.
     * @param currentValue the float value of this pairs unit.
     */
    public ConversionPair(Unit unit, Float currentValue){
        this.unit = unit;
        this.value = currentValue;
    }
}
