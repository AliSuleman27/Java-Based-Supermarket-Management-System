
import java.awt.Window;
import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


class Result{
    int index;
    boolean status;

    public Result(int index, boolean status) {
        this.index = index;
        this.status = status;
    }
    
}
       
public class AdjustStockLevels extends javax.swing.JFrame {
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Inventory> inventory = new ArrayList<>();
    ArrayList<InventoryHistory> history = new ArrayList<>();
    int itemSelected;
    int quantityEntered;
    //int inventoryValue;
    
    
    void mantainHistory(int sign,Inventory i, Date d)
    {
        int actionID=AdminMenu.getNextID("src\\data\\history.txt");
        String actionString = null;
     
        if(sign==1)
        {
            actionString="Increased";
        }
        else if(sign==-1)
        {
            actionString="Decreased";
        }
        
        history.add(new InventoryHistory(i/*Inventory Type Object*/,d,actionString,actionID));
        
        try{
          
        File file = new File("src\\data\\history.txt");
        FileWriter fw = new FileWriter(file,true);
        String str = history.get(history.size()-1).toString();
        fw.write(str+"\n");
        fw.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    void writeInFile(){
        try{
        File file = new File("src\\data\\productInventory.txt");
        FileWriter fw = new FileWriter(file);
        for(int i=0;i<inventory.size();i++)
        {
            fw.write(inventory.get(i).toString()+"\n");
        }
        fw.close();
        
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    Result verifyIfExisting(){
        for(int i=0;i<inventory.size();i++)
        {
            if(inventory.get(i).getProductID()==products.get(itemSelected).getProductID())
            {
                return new Result(i,true);
            }
        }
        return new Result(0,false);
    }
    
    
    void makeInvetory()
    {
        try{
            
        if(quantity.getText().equals("") || prodName.getSelectedItem().equals("") || dated.getDate().equals(""))
        {
            showMessage("Please Input All Fields....");
        }
        
        else if(buttonGroup1.getSelection()==null){
        showMessage("Please Select An Option..... i.e. Increase or Decrease");
        }
        
        
        else{
             
            int vID = (products.get(itemSelected).getProductID());
            String vname = (products.get(itemSelected).getProductName());
            String vcat  = (products.get(itemSelected).getCategorey());
            String vdescription = products.get(itemSelected).getProductDescription();
            int CP = (products.get(itemSelected).getCostPrice());
            int SP = (products.get(itemSelected).getSellingPrice());
            int sign = 0;
            boolean progressStatus = true;
            if(inc.isSelected())sign = 1;
            if(dec.isSelected()) sign = -1;
                
            Result r = verifyIfExisting();
            
            
            if(r.status)
            {
                if(inventory.get(r.index).getQuantity()<=quantityEntered && sign==-1){
                    showMessage("Operation Denied! No Sufficeint Stock Found to decrease...");
                    progressStatus = false;
                }
                
                else{
                inventory.get(r.index).updateQuantity((sign*quantityEntered));
                inventory.get(r.index).setTotalValue();
                }
               
            }
            
            
            else{
                if(dec.isSelected()){
                showMessage("Message: Operation Denied! No Sufficeint Stock Found to decrease..."); 
                progressStatus = false;
                }
                
                
                else{
                inventory.add(new Inventory(quantityEntered,CP*quantityEntered,vID,vname,vcat,CP,SP,vdescription,true));
                }
            }
            
            
            //after the process of making inventory if the process was not denied
            //progress status must not be false. so it will update the quantity.
            
            if(progressStatus!=false)
            {
            writeInFile();
                if(sign==1){
                    showMessage("Sucessfully Increased Stock Level By: "+quantityEntered+""
                            + " Of Product: "+vname);
                }
                else if(sign==-1)
                {
                    showMessage("Sucessfully Decreased Stock Level By: "+quantityEntered+""
                            + " Of Product: "+vname);
                }
                Inventory i = new Inventory(quantityEntered,CP*quantityEntered,vID,vname,vcat,CP,SP,vdescription,true);
    
               mantainHistory(sign,i,dated.getDate());  
            }
        }
        }catch(Exception e)
        {
          
        }
    
    }
    void readAllInventories()
    {
        try{
        File file = new File("src\\data\\productInventory.txt");
        File file2 = new File("src\\data\\history.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            //1;Mix Pulses;1KG;grocery;350;450;true;6;2100
            String data = sc.nextLine();
            String[] field = data.split(";");
            int vid = Integer.parseInt(field[0]);
            String vname = field[1];
            String vdescription = field[2];
            String vcat = field[3];
            int vcp = Integer.parseInt(field[4]);
            int vsp = Integer.parseInt(field[5]);
            int vqty = Integer.parseInt(field[7]);
            int vTotalValue = Integer.parseInt(field[8]);
           inventory.add(new Inventory(vqty,vTotalValue,vid,vname,vcat,vcp,vsp,vdescription,true));
           
         }
        sc.close();
        sc = new Scanner(file2);
        while(sc.hasNextLine())
        {
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH);
            String data = sc.nextLine();
            
            String[] field = data.split(";");
            
            int inventoryID = Integer.parseInt(field[0]);
            String actionPerformedString = field[1];
            int vid = Integer.parseInt(field[2]);
            String vname = field[3];
            String vdescription = field[4];
            String vcat = field[5];
            int vcp = Integer.parseInt(field[6]);
            int vsp = Integer.parseInt(field[7]);
            int vqty = Integer.parseInt(field[9]);
            int vTotalValue = Integer.parseInt(field[10]);
            Date date = sdf.parse(field[11]);
          
            String statusString = field[8];
            boolean status = Boolean.parseBoolean(statusString);
  
            history.add(new InventoryHistory(new Inventory(vqty,vTotalValue,vid,vname,vcat,vcp,vsp,vdescription,status),date,actionPerformedString,inventoryID));
           
        }
        
        
        }
        catch(Exception e)
        {
              
        }
        
        
       
       
    }
    
    void showMessage(String str)
    {
        JOptionPane.showMessageDialog(null, str);
    }
    
   public AdjustStockLevels() {
       ProductCorner pc = new ProductCorner();
        if(pc.products.size()==0)
        {
            pc.showMessage("Sorry.. No Products are Registered...\n"
                    + "Inventories are not possible.....");
            this.dispose();
        }
        else{
        initComponents();
                buttonGroup1.add(inc);
        buttonGroup1.add(dec);
        readAllInventories();
        products = pc.products;
        readFields();
        prodName.setSelectedIndex(-1);
        Date date = new Date();
        dated.setDate(date);        
        value.setText("0");
  
        }
        pc.dispose();
        
    }
    
    void verifySelectedItem(){
        try{
        if(products.get(itemSelected).getProductStatus()==false)
        {
            showMessage("Message: The Item"+"("+prodName.getSelectedItem()+")"+"You have choosed is no longer Available.....");
            prodName.setSelectedItem(null);
        }else{
                        showCorrespondingDetails();
        }}catch(Exception e){
            
        }
    }
   
    void readFields()
    {
        //AutoCompleteDecorator.decorate(prodName);
        try{
        for(int i=0;i<products.size();i++)
        {
            //if(products.get(i).getProductStatus())
            prodName.addItem(products.get(i).getProductName());
        }
        prodName.setSelectedIndex(-1);
        
        
        
        
        
        
        }catch(Exception e)
        {
            System.out.println("exception");
        }
        
    }
    
    void showCorrespondingDetails()
    {
           DefaultTableModel tbl = (DefaultTableModel) myTable.getModel();
        
           tbl.setRowCount(0);
        
           
           try{
        String[] data = {products.get(itemSelected).getProductID()+"",
            products.get(itemSelected).getProductName(),
            products.get(itemSelected).getCostPrice()+"",products.get(itemSelected).getSellingPrice()+""};
        tbl.addRow(data);
        int y = products.get(itemSelected).getCostPrice();
        
        quantityEntered = Integer.parseInt(quantity.getText());
        
        value.setText((quantityEntered*y)+"");
        
           }
        catch(Exception e)
        {
           
        }
        
       // value.setText(x+".00");
    }

   
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        prodName = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        myTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        value = new javax.swing.JTextPane();
        quantity = new javax.swing.JTextField();
        dated = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        inc = new javax.swing.JRadioButton();
        dec = new javax.swing.JRadioButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setText("jLabel1");

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        prodName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                prodNameItemStateChanged(evt);
            }
        });

        jLabel2.setText("ProductName");

        jLabel3.setText("Date");

        myTable.setBackground(new java.awt.Color(204, 255, 204));
        myTable.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        myTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ID", "ProductName", "CostPrice", "SellingPrice"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        myTable.setColumnSelectionAllowed(true);
        myTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        myTable.setGridColor(new java.awt.Color(153, 255, 153));
        myTable.setSelectionBackground(new java.awt.Color(51, 153, 0));
        jScrollPane3.setViewportView(myTable);
        if (myTable.getColumnModel().getColumnCount() > 0) {
            myTable.getColumnModel().getColumn(0).setResizable(false);
            myTable.getColumnModel().getColumn(1).setResizable(false);
            myTable.getColumnModel().getColumn(2).setResizable(false);
            myTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel4.setText("Total Value");

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Save");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Close");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jScrollPane5.setViewportView(value);

        quantity.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                quantityCaretUpdate(evt);
            }
        });
        quantity.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                quantityInputMethodTextChanged(evt);
            }
        });
        quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantityKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantityKeyTyped(evt);
            }
        });

        jLabel6.setText("Enter Quantity");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/inventory icons/icons8-inventory-64.png"))); // NOI18N

        jLabel7.setBackground(new java.awt.Color(51, 153, 0));
        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 0));
        jLabel7.setText("Adjust Stock Levels");

        inc.setText("Increase Level");

        dec.setText("Decrease Level");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(prodName, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(dated, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inc))
                        .addGap(24, 24, 24)
                        .addComponent(dec)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel7)))
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(prodName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inc)
                    .addComponent(dec))
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(dated, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void prodNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_prodNameItemStateChanged
            
        
            itemSelected = prodName.getSelectedIndex();
            verifySelectedItem();

            
    }//GEN-LAST:event_prodNameItemStateChanged

    private void quantityInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_quantityInputMethodTextChanged
     //   showCorrespondingDetails();
    }//GEN-LAST:event_quantityInputMethodTextChanged

    private void quantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyTyped
         //   showCorrespondingDetails();        // TODO add your handling code here:
    }//GEN-LAST:event_quantityKeyTyped

    private void quantityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyPressed
          //  showCorrespondingDetails();
    }//GEN-LAST:event_quantityKeyPressed

    private void quantityCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_quantityCaretUpdate
        showCorrespondingDetails();
    }//GEN-LAST:event_quantityCaretUpdate

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        makeInvetory();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
      this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dated;
    private javax.swing.JRadioButton dec;
    private javax.swing.JRadioButton inc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable myTable;
    private javax.swing.JComboBox<String> prodName;
    private javax.swing.JTextField quantity;
    private javax.swing.JTextPane value;
    // End of variables declaration//GEN-END:variables
}
