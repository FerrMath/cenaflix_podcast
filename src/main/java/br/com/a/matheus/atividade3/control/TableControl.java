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
    private ArrayList<Podcast> podcasts;

    public TableControl(JTable table) {
        this.TABLE = table;
        this.DAO = new PodcastDao();
    }

    public void startTable() {
        DefaultTableModel model = (DefaultTableModel) TABLE.getModel();
        podcasts = DAO.getAllPodcasts();

        for (Podcast p : podcasts) {
            model.addRow(p.getData());
        }
    }

    public void updateTable() {
        DefaultTableModel model = (DefaultTableModel) TABLE.getModel();
        model.setRowCount(0);
        startTable();
    }

    public void displayAll() {
        DefaultTableModel model = (DefaultTableModel) TABLE.getModel();
        model.setRowCount(0);
        for (Podcast p : podcasts) {
            model.addRow(p.getData());
        }
    }

    public void filterResults(String filter) {
        DefaultTableModel model = (DefaultTableModel) TABLE.getModel();
        model.setRowCount(0);
        for (Podcast p : podcasts) {
            if (p.getProductor().toLowerCase().contains(filter.toLowerCase())) {
                model.addRow(p.getData());
            }
        }
    }

    public boolean deletEntry() {
        int row = TABLE.getSelectedRow();
        Podcast p;
        if (row > -1) {
            p = podcasts.get(row);
            return DAO.removePodcast(p);
        }
        return false;
    }
}
