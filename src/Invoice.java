
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author 3tee
 */
public class Invoice extends javax.swing.JFrame {

    String invoiceString;
    boolean purpose;
    ArrayList<Discounts> discounts = new ArrayList<>();
    Customer customer;
    boolean promoAvailed=false;
    
    
    boolean ispromoAviled()
    {
        for(Discounts d : discounts)
        {
            if(d.getCategorey().equals("Promo Code"))
            {
                promoAvailed = true;
            }
        }
        return promoAvailed;
    }
    
    void UpdateHistory(String filepath,String PurchasingDetails)
    {
        File file = new File(filepath);
        try {
            FileWriter fw = new FileWriter(file,true);
            fw.write(PurchasingDetails+"\n");
            fw.close();
        } catch (Exception e) {
        }
    }
    
    
    void writeIntoFile(String str){
        
        File file = new File("src\\data\\sales.txt");
        
        try {
            FileWriter fw = new FileWriter(file,true);
            fw.write(str+"\n");
            fw.close();
        } catch (Exception e) {
        }
    }
    
    void displayCartedItems(ArrayList<Cart> myCart)
    {
        String str = "ID"+"\t"+"ITEM"+"\t"+"PER"+"\t"+"QTY"+"\t"+"TOTAL"+"\n";
        CartedItems.append(str);
        for(Cart c: myCart)
        {
            str = c.getProductID()+"\t"+c.getProductName()+"\t"+c.getSP()+"\t"+c.getQty()+"\t"+c.getTotal()+"\n";
            CartedItems.append(str);
        }
    }
    
    void displayDiscounts(ArrayList<Discounts> discounts, int GrandTotal)
    {
        PromoCodes.append("Discounts Availed : ");
        PromoCodes.append("Code\t|\tAmount"+"\n");
        if(customer!=null && promoAvailed)
        {
            
            for(Discounts d: discounts)
            {
                if(d.getCategorey().equals("Promo Code"))
                {
                    PromoCodes.append(d.getDiscountCode()+"\t|\tRs. "+(int)((GrandTotal*(d.getPercentage()/100)))+"\n");
                }
            }
        }

            
            for(Discounts d: discounts)
            {
                if(!d.getCategorey().equals("Promo Codes"))
                {
                    PromoCodes.append(d.getDiscountCode()+"\t|\tRs. "+(int)((GrandTotal*(d.getPercentage()/100)))+"\n");
                }
            }
        
    }
    void DisplayInvoiceDetails(Sale sale)
    {
        
        if(purpose){
        sale.calculateTotal();
        sale.getDiscountAmount();
        sale.getNetTotal();
        sale.date = java.time.LocalDate.now()+"";
        writeIntoFile(sale.toString()+";"+(sale.calculateCurrentSaleSoldStockValue()));
        }
        else{
            jLabel3.setText("Order History"+"\n"+sale.customer.getName());
        }

        displayCartedItems(sale.myCart);
        displayDiscounts(sale.AvailedDiscounts,sale.GrandTotal);
        
        Totals.append("Total Items Purchased : "+sale.productsPurchased);
        Totals.append("\nGrossTotal  : "+sale.GrandTotal);
        Totals.append("\nYou Saved   : "+sale.DiscountedAmount);
        Totals.append("\nNetBill     : "+sale.NetTotal);
        InvoiceID.setEditable(false);
        InvoiceID.resize(WIDTH, HEIGHT);
        Totals.setEditable(false);        InvoiceID.setText(sale.saleID+"");

        CartedItems.setEditable(false);
        PromoCodes.setEditable(false);
        
        if(customer!=null)
        {
            if(purpose)
           UpdateHistory("src\\data\\customers\\"+customer.getID()+".txt",sale.toString());
        }
       
    }
    
    
    
    
    public Invoice(Sale sale, boolean purpose) {
        initComponents();
        this.purpose = purpose;
        this.discounts.addAll(sale.AvailedDiscounts);
        this.customer = sale.customer;
        
        for(Discounts d: discounts)
        {
            System.err.println(d.toString());
        }
        //System.err.println(customer.toString());
        DisplayInvoiceDetails(sale);
    }

 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ThriftyStore = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Totals = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        CartedItems = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        InvoiceID = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        PromoCodes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ThriftyStore.setBackground(new java.awt.Color(0, 0, 0));
        ThriftyStore.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        ThriftyStore.setForeground(new java.awt.Color(0, 204, 51));
        ThriftyStore.setText("The Thrifty Store");

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Shah Lateef Branch");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Powered By : Code Doctors");

        Totals.setColumns(20);
        Totals.setRows(5);
        jScrollPane2.setViewportView(Totals);

        CartedItems.setColumns(20);
        CartedItems.setRows(5);
        jScrollPane1.setViewportView(CartedItems);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Invoice");

        InvoiceID.setText("jTextField1");

        PromoCodes.setColumns(20);
        PromoCodes.setRows(5);
        jScrollPane3.setViewportView(PromoCodes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(InvoiceID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
                                        .addComponent(ThriftyStore, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(169, 169, 169)
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(ThriftyStore, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(InvoiceID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea CartedItems;
    private javax.swing.JTextField InvoiceID;
    private javax.swing.JTextArea PromoCodes;
    private javax.swing.JLabel ThriftyStore;
    private javax.swing.JTextArea Totals;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
