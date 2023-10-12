/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.a.matheus.atividade3.model.entitys;

import br.com.a.matheus.atividade3.model.PodcastForm;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author ma_fe
 */
@Entity
@Table(name = "cnf_podcasts")
public class Podcast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "produtor")
    private String productor;

    @Column(name = "nome_ep")
    private String title;

    @Column(name = "num_ep")
    private int numEp;

    @Column(name = "duracao")
    private int duration;

    @Column(name = "rep_url")
    private String repUrl;

    public Podcast() {
    }
    
    public Podcast(PodcastForm f){
        this.productor = f.getProductor();
        this.title = f.getName();
        this.numEp = f.getNumEp();
        this.duration = f.getDuration();
        this.repUrl = f.getUrl();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumEp() {
        return numEp;
    }

    public void setNumEp(int numEp) {
        this.numEp = numEp;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getRepUrl() {
        return repUrl;
    }

    public void setRepUrl(String repUrl) {
        this.repUrl = repUrl;
    }

    private String getFormatedDuration() {
        String duration = " min";
        double time = this.duration / 60;
        if (this.duration > 3600) {
            time /= 60;
            duration = "Hrs";
        }

        return String.format("%.2f %s", time, duration).replace(",", ".");
    }

    public String[] getData() {
        return new String[]{
            "" + this.id,
            this.productor,
            this.title,
            "" + this.numEp,
            getFormatedDuration(),
            this.repUrl
        };
    }
}
