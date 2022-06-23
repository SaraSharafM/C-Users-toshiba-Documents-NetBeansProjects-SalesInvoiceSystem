/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


public class LeftTable extends AbstractTableModel{
    
    private ArrayList<InvoiceHeads> invoice;
    
    private String[] column ={"NO.","Date","Customer","Total"};

    public LeftTable(ArrayList<InvoiceHeads> invoices) {
        this.invoice = invoices;
    }

    public ArrayList<InvoiceHeads> getInvoice() {
        return invoice;
    }
    

    @Override
    public int getRowCount() {
return invoice.size();
    }

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
InvoiceHeads invoice1= invoice.get(rowIndex);
    
switch(columnIndex){
case 0: return invoice1.getInvNum();
case 1: return invoice1.getInvDate();
case 2: return invoice1.getCustomerName();
case 3: return invoice1.getInvoiceTotal();
default: return "Error";
         

    }

  
        
    }
}
