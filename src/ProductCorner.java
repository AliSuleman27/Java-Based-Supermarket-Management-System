
import java.awt.Color;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProductCorner extends javax.swing.JFrame {
    int count;
    ArrayList<Product> products = new ArrayList<>();
   
    public ProductCorner() {
        initComponents();
        readAllData();
        writeAllData();
        jTextField1.setForeground(Color.GRAY);
        
       
        try{
            File file = new File("src\\data\\categories.txt");
            Scanner sc = new Scanner(file);
           
            while(sc.hasNextLine())
            {
                String data = sc.nextLine();
                String[] fields = data.split(";");
                cat.addItem(fields[1]);
            }
            
        }catch(Exception e)
        {
            
        }
        
    }

    void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    void searchProduct() {
        boolean found = false;
        //  dataSheet.setText("");
        
        if(jTextField1.getText().equals(""))
        {
            showMessage("Please Enter ID to Search......");
        }
        
        else{
        for (int i = 0; i < products.size(); i++) {
            if ((jTextField1.getText().equals(products.get(i).getProductID() + "")) && (products.get(i).getProductStatus())) {
                found = true;
                SearchFound sf = new SearchFound(products.get(i),i,this);
                sf.setVisible(true);
                sf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                sf.setResizable(false);
                sf.setLocationRelativeTo(null);
                break;
            }
        }
        if (!found) {
            showMessage("Product Doesnot Exist....");
        }
        }
    }

    void Backup() {
        try {
            File file = new File("src\\data\\productData.txt");
            FileWriter fw = new FileWriter(file);
            for (int i = 0; i < products.size(); i++) {
                String product = products.get(i).toString() + "\n";
                fw.write(product);
            }
            fw.close();
         //   showMessage(" Added Successfully");

        } catch (Exception e) {
            showMessage("Backup File Error....");
        }
    }

    void readAllData() {
        try {
            
            File file = new File("src\\data\\productData.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                
                String data = sc.nextLine();
                String[] field = data.split(";");
                int vid = Integer.parseInt(field[0]);
                String vname = field[1];
                String vcat = field[3];
                String vdescription = field[2];
                int vcp = Integer.parseInt(field[4]);
                int vsp = Integer.parseInt(field[5]);
                boolean vstatus = Boolean.parseBoolean(field[6]);
                Product p = new Product();
                p.setProductID(vid);p.setProductName(vname);p.setCategorey(vcat);
                p.setProductDescription(vdescription);p.setCostPrice(vcp);
                p.setSellingPrice(vsp);p.setProductStatus(vstatus);
                products.add(p);

            }
            
            ID.setText(AdminMenu.getNextID("src\\data\\productData.txt")+"");
            ID.setEditable(false);

        } catch (Exception e) {
            showMessage(e.getMessage());
        }
    }

    void writeAllData() {
        DefaultTableModel tbl = (DefaultTableModel) jTable1.getModel();
        tbl.setRowCount(0);
        for (int i = 0; i < products.size(); i++) {
            
            if(products.get(i).getProductStatus()){
            Product p = products.get(i);
            String[] data = {p.getProductID() + "", p.getProductName(),p.getProductDescription(), p.getCategorey(), p.getCostPrice() + "", p.getSellingPrice() + ""};
            
            tbl.addRow(data);}
        }

    }

    void BlankAllFields() {
        name.setText("");
        cat.setSelectedItem(null);
        cp.setText("");
        sp.setText("");
        description.setText("");
    }

    void addProducts() {

        if (sp.getText().equals("") || cat.getSelectedItem()==null
                || name.getText().equals("") || cp.getText().equals("")
                || ID.getText().equals("") || description.getText().equals("")) {
            showMessage("Please Input All Fields");
        } else if (verifyID(Integer.parseInt(ID.getText()))) {
            showMessage(ID.getText() + " Already Exist");
        } else {

            int thisID = Integer.parseInt(ID.getText());
            int thisCP = Integer.parseInt(cp.getText());
            int thisSP = Integer.parseInt(sp.getText());
            products.add(new Product(thisID, name.getText(), cat.getSelectedItem()+"", thisCP, thisSP,description.getText(),true));
            writeAllData();
            Backup();
        }

        BlankAllFields();
        ID.setText(AdminMenu.getNextID("src\\data\\productData.txt")+"");
    }

    boolean verifyID(int ID) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == ID) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        sp = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cat = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        description = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel3.setText("Categorey");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel4.setText("SP");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });
        getContentPane().add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 90, 219, -1));
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 130, 219, -1));
        getContentPane().add(sp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 219, -1));

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, -1));

        jLabel5.setText("CP");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));
        getContentPane().add(cp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 219, -1));

        jLabel6.setText("Product Search & Registration");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 56, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel7.setText("ThriftyMartCom");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 15, 279, -1));

        jButton2.setBackground(new java.awt.Color(0, 153, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, -1, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Description", "Categorey", "CP", "SP"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 530, 320));

        getContentPane().add(cat, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 219, -1));

        jTextField1.setText("Search ID Here");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTextField1MouseReleased(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 10, 280, 30));
        getContentPane().add(description, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 219, -1));

        jLabel8.setText("Description");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addProducts();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        searchProduct();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        
       
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseReleased
     
    }//GEN-LAST:event_jTextField1MouseReleased

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        if(jTextField1.getText().equals("Search ID Here")){
        jTextField1.setText("");
        jTextField1.setForeground(Color.BLACK);}
        
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        if(jTextField1.getText().equals("")){
        jTextField1.setText("Search ID Here");
      jTextField1.setForeground(Color.GRAY);}
    }//GEN-LAST:event_jTextField1FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JComboBox<String> cat;
    private javax.swing.JTextField cp;
    private javax.swing.JTextField description;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField name;
    private javax.swing.JTextField sp;
    // End of variables declaration//GEN-END:variables
}
