/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author toshiba
 */
public class InvoiceLines {
    private String itemName;
    private double itemsPrice;
    private int itemCount;
    private InvoiceHeads heads;
    
    
    public InvoiceLines(String Item,double ItemPrice,int Count,InvoiceHeads heads){
     this.itemName=Item;
     this.itemsPrice=ItemPrice;
     this.itemCount=Count;
     this.heads=heads;
    }

   
    
    public double getLinesTotal(){
             return itemsPrice*itemCount;
    }

     
    

    

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemsPrice() {
        return itemsPrice;
    }

    public void setItemsPrice(double itemsPrice) {
        this.itemsPrice = itemsPrice;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public InvoiceHeads getHeads() {
        return heads;
    }

    public void setHeads(InvoiceHeads heads) {
        this.heads = heads;
    }
    
    

    @Override
    public String toString() {
        return "InvoiceLines{" + "Num=" + heads.getInvNum() + ", Item=" + itemName + ", ItemPrice=" + itemsPrice + ", Count=" + itemCount + ", heads=" + heads + '}';
    }
    
    public String saveFile2(){
    
    return heads.getInvNum()+","+itemName+","+itemsPrice+","+itemCount ;
            }
    
    
    
}
