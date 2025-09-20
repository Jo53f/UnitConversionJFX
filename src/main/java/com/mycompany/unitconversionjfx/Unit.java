/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unitconversionjfx;

import java.util.HashMap;
import java.util.function.Function;

/**
 * A class to represent a single unit, which should have a name and a HashMap
 * for all connections that a value can be converted to.
 * 
 * @author josef
 */
public class Unit {

    /** 
     * The name of the unit, such as 'cm' or 'centimetre'.
     */
    public String name;
    
    /**
     * Maps target units to functions for conversion from this unit.
     */
    public HashMap<Unit, Function<Float, Float>> conversions;
    
    /**
     * Class constructor takes a String for the name.
     * 
     * @param name The name of the unit, such as cm or centimetre.
     */
    public Unit(String name){
        this.name = name;
        this.conversions = new HashMap<>();
    }
    
    /**
     * Adds a path for conversion to the passed Unit, by applying the passed
     * Function. The Unit and function will be added to the Objects conversions
     * HashMap.
     * 
     * @param unitObject The Unit object to be converted to.
     * @param conversionFuncion The Function by which should be applied to
     * convert to the passed unit.
     */
    public void addConversion(Unit unitObject, Function<Float, Float> conversionFuncion){
        conversions.put(unitObject, conversionFuncion);
    }
    
    public String toString(){
        return this.name;
    }
}
