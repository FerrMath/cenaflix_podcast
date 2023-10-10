/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.a.matheus.atividade3.control;

import br.com.a.matheus.atividade3.model.UserDAO;
import br.com.a.matheus.atividade3.model.entitys.User;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author ma_fe
 */
public class LoginControl {
    // TODO mudar os atributos e metodos de staticos para instancia 
    // TODO criar metodo de encerramento
    private static final UserDAO DAO;
    
    static {
        DAO = new UserDAO();
    }
    
    // TODO dividir o codigo com uma nova classe (Login)
    public static boolean verifyLogin(String login, char[] pswd){
        boolean result = false;
        User u;
        
        try {
            u = DAO.getUserByLogin(login);
            
            if (u != null){
                return BCrypt.checkpw(String.copyValueOf(pswd), u.getPswd());
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao fazer login: " + e.getMessage());
        }
        return result;
    }
}
