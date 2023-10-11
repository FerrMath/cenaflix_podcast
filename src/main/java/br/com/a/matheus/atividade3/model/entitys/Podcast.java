/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.a.matheus.atividade3.model.entitys;

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
    
    public String[] getData(){
        return new String[]{
          ""+this.id,
          this.productor,
          this.title,
          ""+this.numEp,
          ""+this.duration,
          this.repUrl
        };
    }
}
