/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.a.matheus.atividade3.control;

import br.com.a.matheus.atividade3.model.PodcastDao;
import br.com.a.matheus.atividade3.model.entitys.Podcast;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ma_fe
 */
public class TableControl {
    private final JTable TABLE;
    private final PodcastDao DAO;

    public TableControl(JTable table) {
        this.TABLE = table;
        this.DAO = new PodcastDao();
    }
    
    public void startTable(){
        DefaultTableModel model = (DefaultTableModel) TABLE.getModel();
        ArrayList<Podcast> podcasts = DAO.getAllPodcasts();
        
        for (Podcast p: podcasts){
            model.addRow(p.getData());
        }
    }
}
