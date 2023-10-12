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

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao iniciar EntityManager.\n" + e.getMessage());
        }
    }

    public Dao<E> removeAtomic(E entity) {
        openT().remove(entity).closeT();
        return this;
    }
    
    public Dao<E> insertAtomic(E entity){
        openT().insert(entity).closeT();
        return this;
    }

    public Dao<E> remove(E entity) {
        em.remove(entity);
        return this;
    }
    
    public Dao<E> insert(E entity) {
        em.persist(entity);
        return this;
    }

    public Dao<E> openT() {
        em.getTransaction().begin();
        return this;
    }

    public Dao<E> closeT() {
        em.getTransaction().commit();
        return this;
    }

    public void close() {
        if (em.isOpen()) {
            em.close();
        }
        if (emf.isOpen()){
            emf.close();
        }
    }

}
