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
public class ItemDialog extends JDialog{
    
        JTextField item;
        JTextField itemPrice;
        JTextField count;
        JLabel itemLabel;
        JLabel itemPriceLabel;
        JLabel countLabel;
        JButton okBtn;
        JButton cancelBtn;
    
    
    
     public ItemDialog ( Frame frame)
    {
        itemLabel = new JLabel("Item");
        itemPriceLabel = new JLabel("Item Price");
        countLabel = new JLabel("Count");
        item = new JTextField(20);
        itemPrice = new JTextField(20);
        count = new JTextField(20);
        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");
        
            okBtn.setActionCommand("createItemOK");
        cancelBtn.setActionCommand("createItemCancel");
        
        okBtn.addActionListener(frame.getHandler());
        cancelBtn.addActionListener(frame.getHandler());
        setLayout(new GridLayout(5, 2));
        
        add(itemLabel);
        add(item);
        add(count);
        add(itemPriceLabel);
        add(countLabel);
        add(itemPrice);
        add(okBtn);
        add(cancelBtn);
        
        pack();
        
    }

    public JTextField getItem() {
        return item;
    }

    public JTextField getItemPrice() {
        return itemPrice;
    }

    public JTextField getCount() {
        return count;
    }

   
    
        
        
        
        
        
        
        

}

