

import java.awt.Dimension;
import java.awt.Image;
import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.lang.management.PlatformManagedObject;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class Images{
    int ID;
    String pname;
    String path; 

    public Images(int ID, String pname, String path) {
        this.ID = ID;
        this.pname = pname;
        this.path = path;
    }
    
}

public class ImageAdder extends javax.swing.JFrame {
    ProductCorner pc = new ProductCorner();
    ArrayList<Images> images = new ArrayList<>();
    int ID=-1;
    String path = null;
    String newPath = null;
    
    
    public ImageAdder() {
        initComponents();
        getAllData();
     
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        CloseButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        label = new javax.swing.JLabel();
        prodName = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        fileLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        productID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(51, 204, 0));
        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 0));
        jLabel1.setText("Add Image");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Product ID: ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 94, 27));

        CloseButton.setBackground(new java.awt.Color(255, 51, 51));
        CloseButton.setForeground(new java.awt.Color(255, 255, 255));
        CloseButton.setText("Close");
        CloseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseButtonMouseClicked(evt);
            }
        });
        jPanel2.add(CloseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 133, -1, -1));

        addButton.setBackground(new java.awt.Color(51, 255, 0));
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add");
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButtonMouseClicked(evt);
            }
        });
        jPanel2.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(335, 133, -1, -1));

        panel.setBackground(new java.awt.Color(204, 255, 204));
        panel.setMaximumSize(new java.awt.Dimension(212, 218));
        panel.add(label);

        jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 6, 111, 99));

        prodName.setBackground(new java.awt.Color(204, 204, 255));
        prodName.setForeground(new java.awt.Color(0, 0, 0));
        prodName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                prodNameItemStateChanged(evt);
            }
        });
        jPanel2.add(prodName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 220, 20));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Upload");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        fileLabel.setText(" ");
        jPanel2.add(fileLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 54, 128, -1));

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Product Name");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 94, 27));

        productID.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.add(productID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 220, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    
    
    void getAllData()
    {
        //AutoCompleteDecorator.decorate(prodName);
        try{
        for(Product p : pc.products)
        {
            prodName.addItem(p.getProductName());
        }
        prodName.setSelectedIndex(-1);
        
        }catch(Exception e)
        {
            System.out.println("exception");
        }
        
        productID.setText("");
        productID.setEditable(false);
        
        try {
        
            File file = new File("src\\data\\productImages.txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine())
            {
                String str = sc.nextLine();
                String[] fields = str.split(";");
                int ID = Integer.parseInt(fields[0]);
                String pname = fields[1];
                String path = fields[2];
                
                images.add(new Images(ID,pname,path));
            }
        
        } catch (Exception e) {
        }
        
        
        
        
        
    }
    
    
    void showImage()
    {
        validator();
        if(path!=null){
         addButton.setText("Change");
         
        ImageIcon imageIcon = new ImageIcon(path);


              Image image = imageIcon.getImage();
             int width = panel.getWidth();
             int height = panel.getHeight();
             Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    

             label.setIcon(new ImageIcon(scaledImage));
             label.setHorizontalAlignment(JLabel.CENTER);
             label.setVerticalAlignment(JLabel.CENTER);
   
 
            
            panel.revalidate();
//            panel.repaint();
            pack();
        }
    }
    
    void showID()
    {
               
        for(Product p:pc.products)
        {
            if((prodName.getSelectedItem()+"").equals(p.getProductName()))
            {
                productID.setText(p.getProductID()+"");
                ID = p.getProductID();
            }
        }
    }
    
    void validator()
    {
            for(Images i: images){
                
            if(ID == i.ID)
            {
                this.path = i.path;
            }
            
            }
       
    }
     
    void uploadImage()
   {
       try{
        JFileChooser chooser = new JFileChooser();
    chooser.showOpenDialog(null);
    File file = chooser.getSelectedFile();
    
       System.out.println(file.getAbsolutePath());
    ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());


    Image image = imageIcon.getImage();
    int width = panel.getWidth();
    int height = panel.getHeight();
    Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    

    label.setIcon(new ImageIcon(scaledImage));
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setVerticalAlignment(JLabel.CENTER);
   
 
   newPath = file.getAbsolutePath();
    panel.revalidate();
    panel.repaint();
    pack();}catch(Exception e)
    {
        System.err.println("Exception Occured");
    }
   }

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        uploadImage();
    }//GEN-LAST:event_jButton3MouseClicked
         
    private void prodNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_prodNameItemStateChanged
       label.setIcon(null);
       path = null;
       addButton.setText("Add");
        showID();
        showImage();
    }//GEN-LAST:event_prodNameItemStateChanged

    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked
         if(productID.getText().equals("") || newPath == null)
         {
             JOptionPane.showMessageDialog(null, "Please Fill In All Fields");
         }
         else
         {
             if(path==null)
             {
                 try{
                    File file = new File("src\\data\\productImages.txt");
                    FileWriter fw = new FileWriter(file,true);
                    String record = (ID+";"+prodName.getSelectedItem()+";"+newPath+"\n");
                    fw.write(record);
                    fw.close();
                    images.add(new Images(ID,prodName.getSelectedItem()+"",newPath));
                    JOptionPane.showMessageDialog(null, "Image Added Succesfully");
                 }catch(Exception e)
                 {
                     System.err.println(e.getStackTrace());
                 }    
                   
             }
             else{

                 for(int i=0;i<images.size();i++)
                 {
                     if(images.get(i).ID == this.ID)
                     {
                         images.get(i).path = this.newPath;
                     }
                 }
                 
                  try{
                    File file = new File("src\\data\\productImages.txt");
                    FileWriter fw = new FileWriter(file);
                    for(Images i : images)
                    {
                        fw.write(i.ID+";"+i.pname+";"+i.path+"\n");
                                            }
                    fw.close();
                    JOptionPane.showMessageDialog(null, "Image Changed Succesfully");
                 }catch(Exception e)
                 {
                     System.err.println(e.getStackTrace());
                 }
          
             }
         }
    }//GEN-LAST:event_addButtonMouseClicked

    private void CloseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseButtonMouseClicked
       pc.dispose();
        this.dispose();
       
    }//GEN-LAST:event_CloseButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseButton;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel fileLabel;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label;
    private javax.swing.JPanel panel;
    private javax.swing.JComboBox<String> prodName;
    private javax.swing.JTextField productID;
    // End of variables declaration//GEN-END:variables
}
