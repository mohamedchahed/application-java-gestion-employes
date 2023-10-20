package view;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.awt.*;


class MonModel extends AbstractTableModel {
    private Object[][] data;
    private String[] title;

    // Constructeur
    public MonModel(Object[][] data, String[] title) {
        this.data = data;
        this.title = title;
    }

    // Retourne le titre de la colonne à l'indice spécifié
    public String getColumnName(int col) {
        return this.title[col];
    }

    // Retourne le nombre de colonnes
    public int getColumnCount() {
        return this.title.length;
    }

    // Retourne le nombre de lignes
    public int getRowCount() {
        return this.data.length;
    }

    // Retourne la valeur à l'emplacement spécifié
    public Object getValueAt(int row, int col) {
        return this.data[row][col];
    }

    // Définit la valeur à l'emplacement spécifié
    public void setValueAt(Object value, int row, int col) {
        // On interdit la modification sur certaines colonnes !
        if (!this.getColumnName(col).equals("Age"))
            this.data[row][col] = value;
    }

    public boolean isCellEditable(int row, int col) {
        return true;
    }
}