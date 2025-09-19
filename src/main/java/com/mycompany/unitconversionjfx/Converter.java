/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unitconversionjfx;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

/**
 * Utility class for converting values from one Unit to another.
 * 
 * @author josef
 */
public final class Converter {
    
    /**
     * Traverses a units map of conversions to find the target Unit by
     * Breadth-First Search.
     * 
     * @param initialUnit The Unit to be converted from.
     * @param targetUnit The Unit to be converted to.
     * @param initialValue Float value to be converted.
     * @return 
    */
    public static Float convertTo(Unit initialUnit, Unit targetUnit, float initialValue) {
        HashSet<Unit> visited = new HashSet<>(); // Nodes already visited
        Queue<ConversionPair> queue = new ArrayDeque<>(); // Nodes still to be visited
        
        ConversionPair start = new ConversionPair(initialUnit, initialValue);
        queue.add(start);
        
        while(!queue.isEmpty()){
            ConversionPair currentPair = queue.poll();
            visited.add(currentPair.unit);
            
            if(currentPair.unit.conversions.containsKey(targetUnit)){
                return currentPair.unit.conversions.get(targetUnit).apply(currentPair.value);
            }
            
            currentPair.unit.conversions.forEach( (k, v) -> {
                if(!visited.contains(k)){
                    ConversionPair queueMember = new ConversionPair(k, v.apply(currentPair.value));
                    queue.add(queueMember);
                }
            }
            );
        }
        return Float.NaN;
    }
}
