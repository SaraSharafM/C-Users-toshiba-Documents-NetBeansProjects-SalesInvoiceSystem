
package control;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.InvoiceHeads;
import model.InvoiceLines;
import model.LeftTable;
import model.RightTable;
import view.CreateNewDialog;
import view.Frame;
import view.ItemDialog;


    


public class ActiveHandler implements ActionListener, ListSelectionListener  {

    private Frame frame;
    private CreateNewDialog createNewDialog;
    private ItemDialog itemDialog;
   

public ActiveHandler(Frame frame){
this.frame=frame;
}

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String actionCommand=e.getActionCommand();
            
            System.out.println("Successfully : "+ actionCommand);
            switch(actionCommand){
                case "New Invoice":
                    newInvoice();
                    break;
                case "Delete Invoice":
                    deleteInvoice();
                    break;
                case "Create Item":
                    createItem();
                    break;
                case "Delete Item":
                    deleteItem();
                    break;
                case "Load File":
                    loadFile();
                    break;
                case "Save File":
                    saveFile();
                    break;
                case ("createInvoiceOK"):
                        createInvoiceOK();
                        break;
                case ("createInvoiceCancel"):
                    createInvoiceCancel();
                        break;
                case ("createItemOK"):
                        createItemOK();
                        break;
                case ("createItemCancel"):
                    createItemCancel();
                        break;
                        
                    
            }
        } catch (IOException ex) {
            Logger.getLogger(ActiveHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       private void newInvoice(){
       
           createNewDialog = new CreateNewDialog(frame);
           createNewDialog.setVisible(true);
           
       }
 
       
       private void deleteInvoice(){
        int selectedRow = frame.getjTable1().getSelectedRow();
    if
            (selectedRow!= -1){
    
        frame.getInvoices().remove(selectedRow);
   frame.getLeftTable().fireTableDataChanged();
   
    }
    }

       
       
       private void createItem(){
         itemDialog = new ItemDialog(frame);
           itemDialog.setVisible(true);
}



       
       private void deleteItem(){

            int selectedInv = frame.getjTable1().getSelectedRow();
             int selectedRow= frame.getjTable2().getSelectedRow();
    if (selectedInv!=-1 && selectedRow!= -1){
        InvoiceHeads invoice= frame.getInvoices().get(selectedInv);
     invoice.getLines().remove(selectedRow);
RightTable rightTable= new RightTable(invoice.getLines());
frame.getjTable2().setModel(rightTable);
rightTable.fireTableDataChanged();
frame.getLeftTable().fireTableDataChanged();



    }


}

       
       private void saveFile(){
ArrayList <InvoiceHeads> heads = frame.getInvoices();
String  file1="";
String file2="";
for(InvoiceHeads invoice :heads){
String invFile1 = invoice.saveFile1();
file1 +=invFile1;
file1 +="\n";


for(InvoiceLines line:invoice.getLines()){
    String invFile2 = line.saveFile2();
file2 +=invFile2;
file2 +="\n";
}
  }
try{ 
JFileChooser fc=new JFileChooser();
 int result = fc.showSaveDialog(frame);
 if(result==JFileChooser.APPROVE_OPTION){
     File headerfile= fc.getSelectedFile();
     FileWriter fw1= new FileWriter(headerfile);
             fw1.write(file1);
             fw1.flush();
             fw1.close();
     
      result = fc.showSaveDialog(frame);
      if(result==JFileChooser.APPROVE_OPTION){
     File linefile= fc.getSelectedFile();
  FileWriter fw2= new FileWriter(linefile);
             fw2.write(file2);
             fw2.flush();
             fw2.close();    
     
 }}
       } catch (IOException ex) {
            Logger.getLogger(ActiveHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

       }

       
       @Override
    public void valueChanged(ListSelectionEvent e){
            int selectedIndex =frame.getjTable1().getSelectedRow();
    if (selectedIndex!= -1){
    System.out.println("Woooow" +frame.getjTable1().getSelectedRow());
    
    InvoiceHeads currentInvoice = frame.getInvoices().get(selectedIndex);
    frame.getjTextField1().setText(""+currentInvoice.getInvNum());
    frame.getjTextField2().setText(currentInvoice.getCustomerName());
    frame.getjTextField3().setText(""+ currentInvoice.getInvDate());
    frame.getjTextField4().setText(""+ currentInvoice.getInvoiceTotal());
    RightTable rightTable = new RightTable(currentInvoice.getLines());
    frame.getjTable2().setModel(rightTable);
    rightTable.fireTableDataChanged();
    
   }

    
    
    }



    
    private void loadFile() throws IOException{

   
    JFileChooser fc=new JFileChooser();
try{
int result = fc.showOpenDialog(frame);
if(result==JFileChooser.APPROVE_OPTION){
File headsFile = fc.getSelectedFile();
Path headPath = Paths.get(headsFile.getAbsolutePath());
 List<String> headLine = Files.readAllLines(headPath);
    System.out.println("Readed!!!");
ArrayList <InvoiceHeads> invHeads = new ArrayList<>();
for (String  headLines: headLine){
 String[] headerItem = headLines.split(",");
 
 int Num =Integer.parseInt(headerItem[0]);
 String Date= headerItem[1];
 String Name= headerItem[2];
 InvoiceHeads invoice=new InvoiceHeads(Num,Date,Name);
 invHeads.add(invoice);}
    //System.out.println("Done!");
                      ////invHeads==InvoicesArray
    result=fc.showOpenDialog(frame);
    if(result==JFileChooser.APPROVE_OPTION){
    File linesFile= fc.getSelectedFile();
       Path linePath = Paths.get(linesFile.getAbsolutePath());
       List<String> Lines = Files.readAllLines(linePath);   

    //System.out.println("Readed WOOW!!!");

for (String  Line: Lines){
 String invoiceItem[] = Line.split(",");
 
 
  int Num = Integer.parseInt(invoiceItem[0]);
  String Item= invoiceItem[1];
 double ItemPrice= Double.valueOf(invoiceItem[2]);
 int Count =Integer.parseInt(invoiceItem[3]);

 
 
 InvoiceHeads  inv=null;
for(InvoiceHeads Invoice:invHeads)
if (Invoice.getInvNum()== Num)
{inv=Invoice;
break;

}
InvoiceLines lines= new InvoiceLines(Item,ItemPrice,Count,inv);
inv.getLines().add(lines);
    }


}

  frame.setInvoices(invHeads);

LeftTable leftTable=new LeftTable(invHeads);
frame.setLeftTable(leftTable);
frame.getjTable1().setModel(leftTable);
frame.getLeftTable().fireTableDataChanged();

   }

  
 
 }
 catch (IOException ex){JOptionPane.showMessageDialog(frame, "File Error", "Error!", JOptionPane.ERROR_MESSAGE);}



}

    
    
    
    private void createInvoiceOK() {
        
        String date=createNewDialog.getInvDateField().getText();
        String customerName =createNewDialog.getCustomerName().getText();
        int num = frame.getNextInvoiceNum();
        try{
        String[] dateConfirm = date.split("-");
        int day=Integer.parseInt(dateConfirm[0]) ;
        int month=Integer.parseInt(dateConfirm[1]) ;
        int year=Integer.parseInt(dateConfirm[2]) ;
        
        if(dateConfirm.length< 3 || day >31 ||month>12 ||year<1900){
            JOptionPane.showMessageDialog(frame, "Wrong date", "Error!", JOptionPane.ERROR_MESSAGE);}

        InvoiceHeads  invoice= new InvoiceHeads(num,date,customerName);
        frame.getInvoices().add(invoice);
        frame.getLeftTable().fireTableDataChanged();
        createNewDialog.setVisible(false);
                createNewDialog.dispose();
                createNewDialog=null;
    }
catch(Exception ex){
    JOptionPane.showMessageDialog(frame, "Wrong date", "Error!", JOptionPane.ERROR_MESSAGE);}
    }
    
    
    
    private void createInvoiceCancel() {
        createNewDialog.setVisible(false);
        createNewDialog.dispose();
        createNewDialog=null;
        }

    
    
    
    private void createItemOK() {
        String item =itemDialog.getItem().getText();
        String itemPrice =itemDialog.getItemPrice().getText();
        String count = itemDialog.getCount().getText();
        int itemCount=Integer.parseInt(count);
        double price= Double.parseDouble(itemPrice);
        int selectedInvoice = frame.getjTable1().getSelectedRow();
        if (selectedInvoice != -1){
            InvoiceHeads heads =frame.getInvoices().get(selectedInvoice);
            InvoiceLines line = new InvoiceLines (item,price,itemCount,heads);
        heads.getLines().add(line);
        RightTable rightTable = (RightTable) frame.getjTable2().getModel();
         rightTable.fireTableDataChanged();
         frame.getLeftTable().fireTableDataChanged();
        
        }
        itemDialog.setVisible(false);
                itemDialog.dispose();
                itemDialog=null;    }

    
    
    
    
    private void createItemCancel() {
itemDialog.setVisible(false);
        itemDialog.dispose();
        itemDialog=null;    }
 
}


     
         