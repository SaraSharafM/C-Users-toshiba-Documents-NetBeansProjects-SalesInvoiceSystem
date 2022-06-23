/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author toshiba
 */
public class InvoiceHeads {
    private int invNum;
    private String customerName;
    private String invDate;
    private ArrayList<InvoiceLines>lines;
    private double InvoiceTotal;    

    public InvoiceHeads(int Num,String Date,String Name){
    this.invNum =Num;
     this.customerName= Name;
    this.invDate=Date;
    
    }
    
public double getInvoiceTotal(){
    double InvoiceTotal=0.0;
    for(InvoiceLines lines : getLines()){
    InvoiceTotal += lines.getLinesTotal();
    }
return InvoiceTotal;    
}

    public int getInvNum(){
        return invNum;
    }

    public void setInvNum(int invNum) {
        this.invNum = invNum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getInvDate() {
        return invDate;
    }

    public void setInvDate(String invDate) {
        this.invDate = invDate;
    }

    public ArrayList<InvoiceLines> getLines() {
        if(lines==null){
        lines =new ArrayList<>();
        }
        return lines;
    }

    public void setLines(ArrayList<InvoiceLines> lines) {
        this.lines = lines;
    }


    @Override
    public String toString() {
        return "InvoiceHeads{" + "Num=" + invNum + ", Name=" + customerName + ", Date=" + invDate + ", lines=" + lines + '}';
   
}

public String saveFile1(){
return invNum +","+invDate+","+customerName;
}

}