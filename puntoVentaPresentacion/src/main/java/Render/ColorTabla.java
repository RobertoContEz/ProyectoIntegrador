/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Render;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class ColorTabla extends DefaultTableCellRenderer{
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel labelResultado = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(value instanceof String){
            String dato = (String)value;
            labelResultado.setHorizontalAlignment(CENTER);
            if(dato.equals("Desconectado")){
                labelResultado.setBackground(Color.LIGHT_GRAY);
            } else {
                if(dato.equals("Conectado")){
                    labelResultado.setBackground(Color.GREEN);
                } else {
                    if(dato.equals("Alarmado")){
                        labelResultado.setBackground(Color.RED);
                        labelResultado.setForeground(Color.WHITE);
                    }
                }
            }
        }
        return labelResultado;
    }
}
