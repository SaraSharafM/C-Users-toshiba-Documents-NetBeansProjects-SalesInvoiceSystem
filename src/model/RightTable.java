/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author toshiba
 */
public class RightTable extends AbstractTableModel{
        private ArrayList<InvoiceLines> tableLines;
            private String[] column ={"NO.","Item Name","Item Price","Count","Item Total"};

    public RightTable(ArrayList<InvoiceLines> tableLines) {
        this.tableLines = tableLines;
    }



    @Override
    public int getRowCount() {
return tableLines.size();    }

    @Override
    public int getColumnCount() {
return column.length;
    }
    
     @Override
    public String getColumnName(int columns){
        return column[columns];
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLines line= tableLines.get(rowIndex);
    
switch(columnIndex){
case 0: return line.getHeads().getInvNum();
case 1: return line.getItemName();
case 2: return line.getItemsPrice();
case 3: return line.getItemCount();
case 4: return line.getLinesTotal();

default: return "Error";
         
    }
    
    }

}
