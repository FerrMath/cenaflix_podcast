/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.a.matheus.atividade3.control;

import br.com.a.matheus.atividade3.model.Login;
import br.com.a.matheus.atividade3.model.UserDAO;
import br.com.a.matheus.atividade3.model.entitys.User;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author ma_fe
 */
public class LoginControl {
    // TODO criar metodo de encerramento
    private final UserDAO DAO;
    private User authenticatedUser;
    
    public LoginControl() {
        DAO = new UserDAO();
    }
    
    // TODO dividir o codigo com uma nova classe (Login)
    public boolean verifyLogin(String login, char[] pswd){
        User user = DAO.getUserByLogin(login);
        authenticatedUser = user;
        return Login.validate(user, pswd);
    }
    
    public User getConfirmedUser(){
        return authenticatedUser;
    }
}
