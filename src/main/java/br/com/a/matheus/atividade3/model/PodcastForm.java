/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.a.matheus.atividade3.model;

/**
 * Class responsible to format the data received from the front end login form
 * 
 * @author ma_fe
 */
public class PodcastForm {

    private String productor, name, url;
    private int numEp;
    private int duration;

    public PodcastForm(String productor, String name, String url, String numEp, String duration) {
        this.productor = productor;
        this.name = name;
        this.url = url;
        this.setDurationFromStr(duration);
        this.setNumEpFromStr(numEp);
    }

    public PodcastForm(String productor, String name, String url, int numEp, int duration) {
        this.productor = productor;
        this.name = name;
        this.url = url;
        this.numEp = numEp;
        this.duration = duration;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumEp() {
        return numEp;
    }

    public void setNumEp(int numEp) {
        this.numEp = numEp;
    }

    private void setNumEpFromStr(String numEp) {
        this.numEp = Integer.parseInt(numEp);
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    private void setDurationFromStr(String duration) {
        int minutes = Integer.parseInt(duration);
        this.duration = minutes * 60;
    }
}
