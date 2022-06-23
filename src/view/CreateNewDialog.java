/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author toshiba
 */
public class CreateNewDialog extends JDialog{
    JTextField customerName;
        JTextField date;
        JLabel customerNameLabel;
        JLabel dateLabel;
        JButton okBtn;
        JButton cancelBtn;
        
       public CreateNewDialog (Frame frame) 
                {
        customerNameLabel = new JLabel("Customer Name:");
        customerName = new JTextField(20);
        dateLabel = new JLabel("Invoice Date:");
        date = new JTextField(20);
        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");
        
            okBtn.setActionCommand("createInvoiceOK");
        cancelBtn.setActionCommand("createInvoiceCancel");
        
        okBtn.addActionListener(frame.getHandler());
        cancelBtn.addActionListener(frame.getHandler());
        setLayout(new GridLayout(5, 2));
        
        add(dateLabel);
        add(date);
        add(customerNameLabel);
        add(customerName);
        add(okBtn);
        add(cancelBtn);
        
        pack();
        
    }

    public JTextField getCustomerName() {
        return customerName;
    }

    public JTextField getInvDateField() {
        return date;
    }
    
        
        
        
        
        
        
        

}
