import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class OfferDiscountPanel extends javax.swing.JFrame {

    ArrayList<Discounts> allDiscounts = new ArrayList<>();
    
    
    boolean verifyCode(String str)
    {
        for(Discounts discount : allDiscounts)
        {
            if(discount.getDiscountCode().equalsIgnoreCase(str))
            {
                JOptionPane.showMessageDialog(null, str + " Code Already Exist");
                return false;
            }
        }
        return true;
    }
    
    void WriteInFile()
    {
        File file = new File("src\\data\\discounts.txt");
        try {
            FileWriter fw = new FileWriter(file);
            for(Discounts discount : allDiscounts)
            {
                fw.write(discount.toString()+"\n");
            }
            fw.close();
        } catch (Exception e) {
        }
    }
    
    
    void getAllDiscounts()
    {
        File file  = new File("src\\data\\discounts.txt");
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine())
            {
                String str = sc.nextLine();
                String[] fields = str.split(";");
                allDiscounts.add(new Discounts(fields[0],Double.parseDouble(fields[2]),fields[3],Boolean.parseBoolean(fields[1])));
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
           
            System.err.println(e.getMessage());
        }
        
        for(Discounts d : allDiscounts)
        {
            System.out.println(d.toString()+"\n");
        }
        
    }
    
    
    void addDiscounts()
    {
        
        
        if(disCode.getText().equals("") || (TypeVar.getSelectedIndex()+"").equals("") || this.percentage.getValue()==null || Double.parseDouble(this.percentage.getValue()+"")<0)
        {
            JOptionPane.showMessageDialog(null,"Please Input Compelete and Correct.... percetage must be > 0");
        }
        else{
            String code = disCode.getText();
            if(verifyCode(code)){
            String type = TypeVar.getSelectedItem()+"";
            double percentage = Double.parseDouble(this.percentage.getValue()+"");
            System.out.println(code+";"+type+";"+percentage);
            allDiscounts.add(new Discounts(code,percentage,type,true));
            JOptionPane.showMessageDialog(null, disCode.getText()+" Added Sucessfully");
            WriteInFile();}
            else{
                JOptionPane.showMessageDialog(null, code+" Already Exist");
            }
        }
        
    }
    
    
    public OfferDiscountPanel() {
        initComponents();
        getAllDiscounts();
    }
    
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TypeVar = new javax.swing.JComboBox<>();
        percentage = new javax.swing.JSpinner();
        disCode = new javax.swing.JTextField();
        OfferButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 204, 0));
        jLabel1.setText("Offer Discount");

        jLabel2.setText("Discount Code");

        jLabel3.setText("Percentage");

        jLabel4.setText("Type");

        TypeVar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Special Only", "General Only", "Both", "Promo Code" }));

        OfferButton.setBackground(new java.awt.Color(0, 102, 255));
        OfferButton.setForeground(new java.awt.Color(255, 255, 255));
        OfferButton.setText("Offer");
        OfferButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OfferButtonMouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setForeground(new java.awt.Color(255, 51, 51));
        jButton2.setText("Exit");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(OfferButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1))
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TypeVar, 0, 137, Short.MAX_VALUE)
                                .addComponent(percentage)
                                .addComponent(disCode))
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(173, 173, 173))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(disCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(percentage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TypeVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(OfferButton)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OfferButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OfferButtonMouseClicked
       addDiscounts();
    }//GEN-LAST:event_OfferButtonMouseClicked

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OfferButton;
    private javax.swing.JComboBox<String> TypeVar;
    private javax.swing.JTextField disCode;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner percentage;
    // End of variables declaration//GEN-END:variables
}
