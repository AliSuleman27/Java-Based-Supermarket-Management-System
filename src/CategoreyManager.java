
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CategoreyManager extends javax.swing.JFrame {

    ArrayList<Categorey> categories = new ArrayList<Categorey>();
    ProductCorner pc = new ProductCorner();
    int count;
    
    
    void showProductsOfSearchedQuantity()
    {
        String str = categoreyField.getText();
        DefaultTableModel prodTab = (DefaultTableModel) productsTable.getModel();
        prodTab.setRowCount(0);
        for(int i=0;i<pc.products.size();i++)
        {
        
            if(pc.products.get(i).getCategorey().equalsIgnoreCase(str))
            {
                prodTab.addRow(pc.products.get(i).myString());
            }
        
        }
           
        
    }
    
    
    boolean existent(String str)
    {
        for(int i=0;i<categories.size();i++)
        {
            if(categories.get(i).getCategorey().equalsIgnoreCase(str))
            {
                return true;
            }
        }
        
        return false;
    }
    
    void addNewCategory(){
        
        String str = categoreyField.getText();
        if(!existent(str))
        {
            int ID = ++count;
            categories.add(new Categorey(ID,str));
            
            
            try {
                File f = new File("src\\data\\categories.txt");
                FileWriter fw = new FileWriter(f,true);
                fw.write((ID+"")+";"+(str)+"\n");
                fw.close();
                
            } catch (Exception e) {
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, str+" already exist");
        }
        
        writeAllCategoriesFromArray();
        
    }
    
    
    
    void writeAllCategoriesFromArray()
    {
        DefaultTableModel categroriesTable = (DefaultTableModel) allCategoriesTable.getModel();
        categroriesTable.setRowCount(0);
        
        for(int i=0;i<categories.size();i++)
        {
            String[] data = {categories.get(i).getID()+"",categories.get(i).getCategorey()};
            categroriesTable.addRow(data);
        }
            
    }
    
    void readAllCategoriesFromFile() {

        try {
            count=0;
            File file = new File("src\\data\\categories.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                count++;
                String data = sc.nextLine();
                String[] fields = data.split(";");
                categories.add(new Categorey((Integer.parseInt(fields[0])),(fields[1])));
            }
        } catch (Exception e) {
        }
    }

    public CategoreyManager() {
        initComponents();
        readAllCategoriesFromFile();
        writeAllCategoriesFromArray();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        categoreyField = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        addNew = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        allCategoriesTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel1.setText("Categorey Manager");

        jLabel2.setText("Categorey Name:");

        categoreyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoreyFieldActionPerformed(evt);
            }
        });

        searchBtn.setText("Search Products");
        searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBtnMouseClicked(evt);
            }
        });

        addNew.setText("Add New");
        addNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addNewMouseClicked(evt);
            }
        });

        allCategoriesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID#", "CategoreyName"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(allCategoriesTable);

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ProductID", "ProductName", "Categorey"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        productsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(productsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(127, 127, 127)
                                        .addComponent(addNew))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(searchBtn)
                                                .addGap(76, 76, 76))
                                            .addComponent(categoreyField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(categoreyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchBtn)
                            .addComponent(addNew))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categoreyFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoreyFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoreyFieldActionPerformed

    private void addNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewMouseClicked
      addNewCategory();
    }//GEN-LAST:event_addNewMouseClicked

    private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseClicked
        showProductsOfSearchedQuantity();
    }//GEN-LAST:event_searchBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNew;
    private javax.swing.JTable allCategoriesTable;
    private javax.swing.JTextField categoreyField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable productsTable;
    private javax.swing.JButton searchBtn;
    // End of variables declaration//GEN-END:variables
}
