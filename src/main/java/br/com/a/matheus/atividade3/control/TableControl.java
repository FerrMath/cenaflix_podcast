/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.a.matheus.atividade3.control;

import br.com.a.matheus.atividade3.model.PodcastDao;
import br.com.a.matheus.atividade3.model.entitys.Podcast;
import br.com.a.matheus.atividade3.model.enums.DeletionCode;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ma_fe
 */
public class TableControl {

    private final JTable TABLE;
    private final PodcastDao DAO;
    private ArrayList<Podcast> podcasts;

    public TableControl(JTable table) {
        this.TABLE = table;
        this.DAO = new PodcastDao();
    }

    public void displayAll() {
        podcasts = DAO.getAllPodcasts();
        updateDisplay();
    }

    public void filterResults(String filter) {
        
        podcasts = DAO.getFilteredPodcasts(filter);
        updateDisplay();
    }

    public DeletionCode deletEntry() {
        int row = TABLE.getSelectedRow();
        Podcast p;
        if (row > -1) {
            int choice = JOptionPane.showConfirmDialog(null,"Excluir podcast permanentemente?","Confirmar exclusão.", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                p = podcasts.get(row);
                return DAO.removePodcast(p);
            } else if (choice == JOptionPane.NO_OPTION) {
                
                return DeletionCode.CANCELED;
            }
        }
        return null;
    }
    
    public void updateDisplay(){
        DefaultTableModel model = (DefaultTableModel) TABLE.getModel();
        model.setRowCount(0);
        if (podcasts != null){
            for (Podcast p : podcasts) {
                model.addRow(p.getData());     
            }
        }
    }
}
