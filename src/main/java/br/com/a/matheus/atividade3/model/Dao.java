/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.a.matheus.atividade3.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javax.swing.JOptionPane;


/**
 *
 * @author ma_fe
 */
public class Dao<E> {

    private EntityManagerFactory emf;
    protected EntityManager em;
    private Class<E> cls;

    public Dao(Class<E> cls, String unit) {
        try {
            this.cls = cls;
            emf = Persistence.createEntityManagerFactory(unit);
            em = emf.createEntityManager();
            System.out.println("Sucesso");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao iniciar EntityManager.\n" + e.getMessage());
        }
    }
    
    public void close(){
        em.close();
        emf.close();
    }

}
