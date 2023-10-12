/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.a.matheus.atividade3.model.handlers.errors;

/**
 *
 * @author ma_fe
 */
public class FormErrorHandler {
    public static boolean hasEmptyFields(String... fields){
        try {
            for(String f: fields){
                if (f.isBlank() || f.isEmpty()) return true;
            }
        } catch (NullPointerException e) {
            return true;
        }
        return false;
    }
    
    public static boolean hasInvalidFields(String... fields){
        try {
            for(String f: fields){
                Integer.valueOf(f);    
            }
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
