/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.a.matheus.atividade3.model;

import br.com.a.matheus.atividade3.model.entitys.Podcast;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;

/**
 *
 * @author ma_fe
 */
public class PodcastDao extends Dao<Podcast> {

    public PodcastDao() {
        this("table-unit");
    }

    public PodcastDao(String unit) {
        super(Podcast.class, unit);
    }

    public ArrayList<Podcast> getAllPodcasts() {
        ArrayList<Podcast> podcasts;
        String jpql = "SELECT p FROM Podcast p";
        TypedQuery<Podcast> query = em.createQuery(jpql, Podcast.class);
        podcasts = (ArrayList<Podcast>) query.getResultList();
        return podcasts;
    }
    
    public boolean addPodcast(PodcastForm f){
        Podcast p = new Podcast(f);
        try {
            insertAtomic(p);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao inserir Podcast no banco de dados");
            return false;
        }
    }

    public boolean removePodcast(Podcast p) {
        Podcast result = em.find(Podcast.class, p.getId());
        if (result != null) {
            removeAtomic(p);
            return true;
        }

        return false;
    }

}
