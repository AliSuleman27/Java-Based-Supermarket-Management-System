
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class SearchFound extends javax.swing.JFrame {

    Product searchedOne;
    int index;
    ProductCorner p;

    void MakeChangesInSearchedProduct() {
        int confirm = JOptionPane.showConfirmDialog(null, "Do you want really want to "
                + "Change {" + (searchedOne.myString_three()) + "}", "Alert!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            try {

                int ID = Integer.parseInt(idS.getText());
                int CP = Integer.parseInt(cpS.getText());
                int SP = Integer.parseInt(spS.getText());

                p.products.set(index, new Product(ID, pnameS.getText(), catS.getSelectedItem() + "", CP, SP,cpS1.getText(),true));
                makeChangesInInventory(ID, pnameS.getText(), catS.getSelectedItem() + "", CP, SP,cpS1.getText());
            } catch (Exception e) {
            }
            p.writeAllData();
            p.Backup();
        }

    }

    void makeChangesInInventory(int id, String name, String cat, int CP, int SP, String description) {
        AdjustStockLevels im = new AdjustStockLevels();
        boolean status = false;
        for (int i = 0; i < im.inventory.size(); i++) {
            if (searchedOne.getProductID() == im.inventory.get(i).getProductID()) {
                status = true;
                p.showMessage("Inventory Found. " + "\nDeleting Following Inventory......."
                        + "\n" + im.inventory.get(i).toString());
                int qty = im.inventory.get(i).Quantity;
                im.inventory.set(i, new Inventory(qty, (qty*CP), id, name, cat, CP, SP,description,true));
                
            }
        }

        if (status) {
            im.writeInFile();
        } else {
            p.showMessage("No Inventories Found With This Product! \n Product Updated Successfully");
        }
        im.dispose();

    }

    void freezeProductInHistory()
    {
        AdjustStockLevels adj = new AdjustStockLevels();
       
        
        for(int i=0;i<adj.history.size();i++)
        {
            if(adj.history.get(i).getProductID()==searchedOne.getProductID())
            {
              
                adj.history.get(i).setProductStatus(false);
                try {
                    FileWriter fw = new FileWriter(new File("src\\data\\history.txt"));
                    for(int j=0;j<adj.history.size();j++)
                    {
                        fw.write(adj.history.get(j).toString()+"\n");
                    }
                    fw.close();
                } catch (Exception e) {
                }
            }
        }
        
        
        
        adj.dispose();
        
        
    }
    
    
    void deleteInventory() {
        AdjustStockLevels im = new AdjustStockLevels();
        boolean status = false;
        for (int i = 0; i < im.inventory.size(); i++) {
            if (searchedOne.getProductID() == im.inventory.get(i).getProductID()) {
                status = true;
                p.showMessage("Inventory Found. " + "\nDeleting Following Inventory......."
                        + "\n" + im.inventory.get(i).toString());
                im.inventory.remove(i);
            }
        }

        if (status) {
            im.writeInFile();
           freezeProductInHistory();
            
        } else {
            p.showMessage("No Inventories Found With This Product....");
        }
        im.dispose();
    }

    void DeleteSearchedProduct() {

        int confirm = JOptionPane.showConfirmDialog(null, "Do you really want to "
                + "delete {" + (searchedOne.myString_three()) + "}", "Alert!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            p.products.get(index).setProductStatus(false);
            deleteInventory();
        }

        p.writeAllData();
        p.Backup();
    }

    public SearchFound(Product p, int index, ProductCorner frame1) {
        initComponents();
        this.p = frame1;
        this.index = index;
        searchedOne = p;
        
        try {
            File file = new File("src\\data\\categories.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                String[] fields = data.split(";");
                catS.addItem(fields[1]);
            }

        } catch (Exception e) {

        }

        idS.setText(p.getProductID() + "");
        idS.setEditable(false);
        pnameS.setText(p.getProductName());
        catS.setSelectedItem(searchedOne.getCategorey());
        cpS.setText(p.getCostPrice() + "");
        spS.setText(p.getSellingPrice() + "");
        cpS1.setText(p.getProductDescription());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        spS = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        idS = new javax.swing.JTextField();
        pnameS = new javax.swing.JTextField();
        cpS = new javax.swing.JTextField();
        makeChangesProduct = new javax.swing.JButton();
        DeleteProductButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        catS = new javax.swing.JComboBox<>();
        cpS1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("ID # ");

        jLabel2.setText("ProductName");

        jLabel7.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel7.setText("Product Details");

        jLabel3.setText("Categorey");

        jLabel4.setText("CostPrice");

        jLabel5.setText("Selling Price");

        makeChangesProduct.setBackground(new java.awt.Color(0, 255, 0));
        makeChangesProduct.setForeground(new java.awt.Color(0, 0, 0));
        makeChangesProduct.setText("Make Changes");
        makeChangesProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                makeChangesProductMouseClicked(evt);
            }
        });

        DeleteProductButton.setBackground(new java.awt.Color(255, 51, 51));
        DeleteProductButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteProductButton.setText("Delete Product");
        DeleteProductButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteProductButtonMouseClicked(evt);
            }
        });

        closeButton.setBackground(new java.awt.Color(255, 51, 51));
        closeButton.setForeground(new java.awt.Color(255, 255, 255));
        closeButton.setText("(X) Close");
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButtonMouseClicked(evt);
            }
        });
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Descrtiption");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DeleteProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(makeChangesProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(spS)
                            .addComponent(idS, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpS, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnameS)
                            .addComponent(catS, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cpS1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pnameS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(catS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cpS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cpS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spS, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteProductButton)
                    .addComponent(makeChangesProduct))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void makeChangesProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_makeChangesProductMouseClicked
        MakeChangesInSearchedProduct();
    }//GEN-LAST:event_makeChangesProductMouseClicked

    private void DeleteProductButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteProductButtonMouseClicked
        DeleteSearchedProduct();
    }//GEN-LAST:event_DeleteProductButtonMouseClicked

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_closeButtonMouseClicked

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_closeButtonActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteProductButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> catS;
    private javax.swing.JButton closeButton;
    private javax.swing.JTextField cpS;
    private javax.swing.JTextField cpS1;
    private javax.swing.JTextField idS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton makeChangesProduct;
    private javax.swing.JTextField pnameS;
    private javax.swing.JTextField spS;
    // End of variables declaration//GEN-END:variables

}
