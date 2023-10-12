/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.a.matheus.atividade3.control;

import br.com.a.matheus.atividade3.model.PodcastDao;
import br.com.a.matheus.atividade3.model.PodcastForm;
import br.com.a.matheus.atividade3.model.handlers.errors.FormErrorHandler;

/**
 *
 * @author ma_fe
 */
public class FormControl {
    private final PodcastDao DAO;

    public FormControl() {
        this.DAO = new PodcastDao();
    }
    
    public boolean addNewPodcast(String prod,String name,String numEp,String duration,String url){
        if(FormErrorHandler.hasEmptyFields(prod,name,numEp,duration,url)) return false;
        if(FormErrorHandler.hasInvalidFields(duration, numEp)) return false;
        
        PodcastForm form = new PodcastForm(prod,name,url,numEp,duration);
        
        return DAO.addPodcast(form);
    }
    
    public void close(){
        DAO.close();
    }
}
