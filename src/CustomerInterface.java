import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
public class CustomerInterface extends javax.swing.JFrame {

    ArrayList<Sale> mySales = new ArrayList<>();
    Customer customer = new Customer();
    
    
    void allSalesInFrame()
    {
        JFrame salesFrame = new JFrame();
        salesFrame.setLayout(new FlowLayout(FlowLayout.LEADING));
   
        salesFrame.setSize(600,600);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        
        JPanel mPanel = new JPanel();
        mPanel.setLayout(new GridLayout(0,1,0,0));
        
        for(Sale sale : mySales){
            
        JPanel panel = new JPanel() ;
        panel.setLayout(new BorderLayout());
            
        JPanel Labelpanel = new JPanel();
        JLabel dated = new JLabel("Dated: "+sale.date);
        Labelpanel.setLayout(new BoxLayout(Labelpanel,BoxLayout.PAGE_AXIS));
        JLabel saleIdLabel = new JLabel("\tSale ID: \t"+sale.saleID);
        JLabel noOfprodcutsLabel = new JLabel("\tItems Purchased : \t"+sale.productsPurchased);
        JLabel totalBillLabel = new JLabel("\tTotal Bill :\t"+sale.NetTotal);
        
            Labelpanel.add(dated);
            Labelpanel.add(Box.createVerticalStrut(10));
        
            Labelpanel.add(saleIdLabel);
            Labelpanel.add(Box.createVerticalStrut(10));
         
            Labelpanel.add(noOfprodcutsLabel);
            Labelpanel.add(Box.createVerticalStrut(10));
            
            Labelpanel.add(totalBillLabel);
            Labelpanel.add(Box.createVerticalStrut(10));
            
            
            
            panel.setBackground(Color.GRAY);
            panel.setForeground(Color.BLACK);
            
            
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            JButton button = new JButton("View Details");    
            buttonPanel.add(button);
            button.setForeground(Color.WHITE);
            button.setBackground(Color.BLUE);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   
                    Invoice invoice = new Invoice(sale,false);
                    invoice.setVisible(true);
                    invoice.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    invoice.setLocationRelativeTo(null);
                    invoice.setResizable(false);
                   
                }
            });
            
            
            panel.add(Labelpanel);
           
            mPanel.add(panel);
            mPanel.add(buttonPanel);
        }
        
        contentPanel.add(mPanel);
        salesFrame.add(contentPanel);
             salesFrame.setVisible(true);
    }
    
    int getint(String str)
    {
        return Integer.parseInt(str);
    }
    
    
    void showMyHistory(boolean status)
    {
        String customerFile = "src\\data\\customers\\"+customer.getID()+".txt";
        File file = new File(customerFile);
        
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine())
            {
                String myData = sc.nextLine();
                String[] data = myData.split(";");
                Sale sale = new Sale();
                sale.saleID = Integer.parseInt(data[0]);
                sale.productsPurchased = Integer.parseInt(data[1]);
                sale.date = data[2];
                sale.GrandTotal = Integer.parseInt(data[3]);
                sale.DiscountedAmount = Integer.parseInt(data[4]);
                sale.NetTotal = Integer.parseInt(data[5]);
                
                if(data[6].equals("Walking Sale"))
                {
                    sale.customer = null;
                }
                else{
                    String[] customerCredentials = data[6].split("\\|");
                    sale.customer = new Customer();
                    sale.customer.setName(customerCredentials[1]);
                    sale.customer.setPassword(customerCredentials[2]);
                    sale.customer.setEmail(customerCredentials[3]);
                    sale.customer.setID(Integer.parseInt(customerCredentials[0]));
                    System.err.println(customer.toString());
                }
                
                if(data[7]!=""){
                String[] discountsDetails = data[7].split("---");
                System.err.println(discountsDetails.length);
                for(int i=0; i<discountsDetails.length; i++)
                {
                   String[] discount = discountsDetails[i].split("\\|");
                   sale.AvailedDiscounts.add(new Discounts(discount[0].trim(),Double.parseDouble(discount[2]),discount[3].trim(),Boolean.parseBoolean(discount[1])));
                   String str = sale.AvailedDiscounts.get(i).toString();
                    System.err.println(str);
                }}
                
                String[] productDetails = data[8].split("---");
                System.err.println(productDetails.length);
                for(int i=0; i<productDetails.length; i++)
                {
                    String[] prodcut = productDetails[i].split("\\|");
                    sale.myCart.add(new Cart(getint(prodcut[0]+""),prodcut[1].trim(),getint(prodcut[2]),getint(prodcut[3]),getint(prodcut[4])));
                    String str = sale.myCart.get(i).toString();
                    System.err.println(str);
                }
                
                System.err.println("-----------------------------");
                System.out.println(sale.toString());
             
                mySales.add(sale);
            }
        } catch (Exception e) {
            e.printStackTrace();
//            e.notify();
        }
        
            if(status && mySales.size()>0 )
            allSalesInFrame();
        
            else if(status)
        {
             JOptionPane.showMessageDialog(null, "Dear "+customer.getName()+"You have not performed any sales...");
                
        }
            
        
        
       
        
    }

    public CustomerInterface(Customer customer, boolean b) {
        this.customer = customer;
    }
    
    
    
    
    public CustomerInterface(Customer customer) {
        initComponents();
        jLabel1.setText("Welcome "+customer.getName());
        this.customer = customer;
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 204, 0));
        jLabel1.setText("Welcome");

        jButton1.setBackground(new java.awt.Color(51, 255, 51));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("View My Details");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 255, 51));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Order History");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 255, 51));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Buy Prodcuts");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setForeground(new java.awt.Color(255, 51, 51));
        jButton4.setText("Log Out");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 134, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        dispose();
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
         new SpecialCustomerPurchase(customer).setVisible(true);
         
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        showMyHistory(true);
    }//GEN-LAST:event_jButton2MouseClicked

    
    void Func(boolean isAdmin){
         
        if(mySales.size()<1)
        {
            showMyHistory(false);
        }

        CustomerDetails cd = new CustomerDetails(customer,mySales.size());
        cd.setVisible(true);
        cd.setLocationRelativeTo(null);
        cd.setResizable(false);
        cd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }    

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        Func(false);
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
