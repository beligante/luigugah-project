/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.utils;

/**
 *
 * @author Gustavo
 */
public class StringUtils {
    
    public static boolean isBlank(String string){
        return (string == null || string.isEmpty());
    }
    
    public static boolean isNotBlank(String string){
        return !(string == null || string.isEmpty());
    }
}
