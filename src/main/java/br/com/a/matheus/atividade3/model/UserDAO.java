/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.a.matheus.atividade3.model;

import br.com.a.matheus.atividade3.model.entitys.User;
import jakarta.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author ma_fe
 */
public class UserDao extends Dao<User>{

    public UserDao() {
        this("login-unit");
    }
    
    public UserDao(String unit){
        super(User.class, unit);
    }
    
    public User getUserByLogin(String login){
        try {
            TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.login = :login", User.class);
            q.setParameter("login", login);
            return (User) q.getSingleResult();
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Usuario invalido, verifique os dados e tente novamente");
                System.out.println("Erro: " + e.getMessage());                       
        }
        return null;
    } 
}
