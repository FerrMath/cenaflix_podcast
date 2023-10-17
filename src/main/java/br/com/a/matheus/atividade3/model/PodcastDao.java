/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.a.matheus.atividade3.model;

import br.com.a.matheus.atividade3.model.entitys.Podcast;
import br.com.a.matheus.atividade3.model.enums.DeletionCode;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;

/**
 * Class responsible to handle the Podcast requests to the database
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
    
    public ArrayList<Podcast> getFilteredPodcasts(String filter){
        CriteriaBuilder cBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Podcast> cQuery = cBuilder.createQuery(Podcast.class);
        Root<Podcast> from = cQuery.from(Podcast.class);
        cQuery.select(from);
        cQuery.where(cBuilder.like(from.get("productor"), "%" + filter.toLowerCase() + "%"));
        
        ArrayList podcasts = (ArrayList) em.createQuery(cQuery).getResultList();
        
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

    public DeletionCode removePodcast(Podcast p) {
        Podcast result = em.find(Podcast.class, p.getId());
        if (result != null) {
            removeAtomic(p);
            return DeletionCode.SUCCESS;
        }

        return DeletionCode.ERROR;
    }

}
