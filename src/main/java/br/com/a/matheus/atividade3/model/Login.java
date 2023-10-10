/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.a.matheus.atividade3.model;

import br.com.a.matheus.atividade3.model.entitys.User;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author ma_fe
 */
public class Login {
    
    public static boolean validate(User u, char[] pswd){
        try {
            
            if (u != null){
                return BCrypt.checkpw(String.copyValueOf(pswd), u.getPswd());
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao fazer login: " + e.getMessage());
        }
        return false;
    }
}
