


  //  import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterContrastIJTheme;
import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import javax.swing.UIManager;


public class AdminMenu extends javax.swing.JFrame {
    public AdminMenu() {
        initComponents();
    }

   static int getNextID(String fileName){
      int nextID=1;
       try{
          
        RandomAccessFile file = new RandomAccessFile(fileName, "r");

        if(!(file.length()==0))
        {
            
        
        long pos = file.length() - 1;
        while (pos > 0 && file.readByte() != '\n') {
            pos--;
            file.seek(pos);
        }

       
        String lastLine = file.readLine();
        String[] fields = lastLine.split(";");
        nextID = Integer.parseInt(fields[0])+1;}
        
        file.close();}
      catch(Exception e){}
      
      return nextID;
      
      
      
      
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        AddSearchProduct = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DeleteProduct = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        GenerateCategorey = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TodayStats = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        OfferDiscounts = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        OfferDiscounts1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        AllCustomers = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        OverallSales = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        monthSales = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        todaySale = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        OfferDiscounts8 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        searchCustomer = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        OfferDiscounts9 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        TodaySales = new javax.swing.JLabel();
        ClientHistory = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        addStock = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        history = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        history1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        history2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 204, 0));

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ThriftyStore.com");

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Store Management System");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/shopping-icon (2).png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 255, 0));
        jButton1.setText("LogOut");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(102, 255, 102));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jTabbedPane1.setName(""); // NOI18N
        jTabbedPane1.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        AddSearchProduct.setBackground(new java.awt.Color(255, 255, 255));
        AddSearchProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddSearchProductMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddSearchProductMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddSearchProductMouseExited(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 153, 0));
        jLabel4.setText("Add/Search Product");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/product.png"))); // NOI18N

        javax.swing.GroupLayout AddSearchProductLayout = new javax.swing.GroupLayout(AddSearchProduct);
        AddSearchProduct.setLayout(AddSearchProductLayout);
        AddSearchProductLayout.setHorizontalGroup(
            AddSearchProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddSearchProductLayout.createSequentialGroup()
                .addGroup(AddSearchProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddSearchProductLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(AddSearchProductLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AddSearchProductLayout.setVerticalGroup(
            AddSearchProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddSearchProductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        DeleteProduct.setBackground(new java.awt.Color(255, 255, 255));
        DeleteProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeleteProductMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DeleteProductMouseExited(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(0, 153, 0));
        jLabel6.setText("    Deleted Products");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/Shopping-basket-remove-icon.png"))); // NOI18N

        javax.swing.GroupLayout DeleteProductLayout = new javax.swing.GroupLayout(DeleteProduct);
        DeleteProduct.setLayout(DeleteProductLayout);
        DeleteProductLayout.setHorizontalGroup(
            DeleteProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteProductLayout.createSequentialGroup()
                .addGroup(DeleteProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DeleteProductLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(DeleteProductLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel7)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        DeleteProductLayout.setVerticalGroup(
            DeleteProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeleteProductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        GenerateCategorey.setBackground(new java.awt.Color(255, 255, 255));
        GenerateCategorey.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GenerateCategoreyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GenerateCategoreyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GenerateCategoreyMouseExited(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(0, 153, 0));
        jLabel8.setText("  Generate Categorey   ");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/applications-office-icon.png"))); // NOI18N

        javax.swing.GroupLayout GenerateCategoreyLayout = new javax.swing.GroupLayout(GenerateCategorey);
        GenerateCategorey.setLayout(GenerateCategoreyLayout);
        GenerateCategoreyLayout.setHorizontalGroup(
            GenerateCategoreyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GenerateCategoreyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GenerateCategoreyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GenerateCategoreyLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        GenerateCategoreyLayout.setVerticalGroup(
            GenerateCategoreyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GenerateCategoreyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TodayStats.setBackground(new java.awt.Color(255, 255, 255));
        TodayStats.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TodayStatsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TodayStatsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TodayStatsMouseExited(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(0, 153, 0));
        jLabel10.setText("Add Product Image");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/growth-statistics-icon.png"))); // NOI18N

        javax.swing.GroupLayout TodayStatsLayout = new javax.swing.GroupLayout(TodayStats);
        TodayStats.setLayout(TodayStatsLayout);
        TodayStatsLayout.setHorizontalGroup(
            TodayStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TodayStatsLayout.createSequentialGroup()
                .addGroup(TodayStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TodayStatsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10))
                    .addGroup(TodayStatsLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel11)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        TodayStatsLayout.setVerticalGroup(
            TodayStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TodayStatsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        OfferDiscounts.setBackground(new java.awt.Color(255, 255, 255));
        OfferDiscounts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OfferDiscountsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OfferDiscountsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OfferDiscountsMouseExited(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(0, 153, 0));
        jLabel12.setText("    Offer Discounts");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/discount-tag-icon.png"))); // NOI18N

        javax.swing.GroupLayout OfferDiscountsLayout = new javax.swing.GroupLayout(OfferDiscounts);
        OfferDiscounts.setLayout(OfferDiscountsLayout);
        OfferDiscountsLayout.setHorizontalGroup(
            OfferDiscountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OfferDiscountsLayout.createSequentialGroup()
                .addGroup(OfferDiscountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OfferDiscountsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12))
                    .addGroup(OfferDiscountsLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel13)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        OfferDiscountsLayout.setVerticalGroup(
            OfferDiscountsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OfferDiscountsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        OfferDiscounts1.setBackground(new java.awt.Color(255, 255, 255));
        OfferDiscounts1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OfferDiscounts1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OfferDiscounts1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OfferDiscounts1MouseExited(evt);
            }
        });

        jLabel14.setForeground(new java.awt.Color(0, 153, 0));
        jLabel14.setText("Set Discount Status");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/New Tab/setDiscountStatus.png"))); // NOI18N

        javax.swing.GroupLayout OfferDiscounts1Layout = new javax.swing.GroupLayout(OfferDiscounts1);
        OfferDiscounts1.setLayout(OfferDiscounts1Layout);
        OfferDiscounts1Layout.setHorizontalGroup(
            OfferDiscounts1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OfferDiscounts1Layout.createSequentialGroup()
                .addGroup(OfferDiscounts1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OfferDiscounts1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14))
                    .addGroup(OfferDiscounts1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel23)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        OfferDiscounts1Layout.setVerticalGroup(
            OfferDiscounts1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OfferDiscounts1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(GenerateCategorey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(TodayStats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(OfferDiscounts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(OfferDiscounts1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(950, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TodayStats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GenerateCategorey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(DeleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(OfferDiscounts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(OfferDiscounts1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(416, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Products", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        AllCustomers.setBackground(new java.awt.Color(255, 255, 255));
        AllCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AllCustomersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AllCustomersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AllCustomersMouseExited(evt);
            }
        });

        jLabel24.setForeground(new java.awt.Color(0, 153, 0));
        jLabel24.setText("   All Customers");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/New Tab/Customers.png"))); // NOI18N

        javax.swing.GroupLayout AllCustomersLayout = new javax.swing.GroupLayout(AllCustomers);
        AllCustomers.setLayout(AllCustomersLayout);
        AllCustomersLayout.setHorizontalGroup(
            AllCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllCustomersLayout.createSequentialGroup()
                .addGroup(AllCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AllCustomersLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel24))
                    .addGroup(AllCustomersLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel25)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        AllCustomersLayout.setVerticalGroup(
            AllCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AllCustomersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        OverallSales.setBackground(new java.awt.Color(255, 255, 255));
        OverallSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OverallSalesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OverallSalesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OverallSalesMouseExited(evt);
            }
        });

        jLabel26.setForeground(new java.awt.Color(0, 153, 0));
        jLabel26.setText("Overall Sales");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/New Tab/Overall Sales.png"))); // NOI18N

        javax.swing.GroupLayout OverallSalesLayout = new javax.swing.GroupLayout(OverallSales);
        OverallSales.setLayout(OverallSalesLayout);
        OverallSalesLayout.setHorizontalGroup(
            OverallSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OverallSalesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(OverallSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        OverallSalesLayout.setVerticalGroup(
            OverallSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OverallSalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        monthSales.setBackground(new java.awt.Color(255, 255, 255));
        monthSales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                monthSalesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                monthSalesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                monthSalesMouseExited(evt);
            }
        });

        jLabel28.setForeground(new java.awt.Color(0, 153, 0));
        jLabel28.setText("Monthly Sales");

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/New Tab/Monthly Sales.png"))); // NOI18N

        javax.swing.GroupLayout monthSalesLayout = new javax.swing.GroupLayout(monthSales);
        monthSales.setLayout(monthSalesLayout);
        monthSalesLayout.setHorizontalGroup(
            monthSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(monthSalesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(monthSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        monthSalesLayout.setVerticalGroup(
            monthSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, monthSalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        todaySale.setBackground(new java.awt.Color(255, 255, 255));
        todaySale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                todaySaleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                todaySaleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                todaySaleMouseExited(evt);
            }
        });

        jLabel32.setForeground(new java.awt.Color(0, 153, 0));
        jLabel32.setText("Today's Sales");

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/New Tab/Todays Sale.png"))); // NOI18N

        javax.swing.GroupLayout todaySaleLayout = new javax.swing.GroupLayout(todaySale);
        todaySale.setLayout(todaySaleLayout);
        todaySaleLayout.setHorizontalGroup(
            todaySaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(todaySaleLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(todaySaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        todaySaleLayout.setVerticalGroup(
            todaySaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, todaySaleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        OfferDiscounts8.setBackground(new java.awt.Color(255, 255, 255));
        OfferDiscounts8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OfferDiscounts8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OfferDiscounts8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OfferDiscounts8MouseExited(evt);
            }
        });

        jLabel36.setForeground(new java.awt.Color(0, 153, 0));
        jLabel36.setText("Search Sale ID");

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/New Tab/SearchSale.png"))); // NOI18N

        javax.swing.GroupLayout OfferDiscounts8Layout = new javax.swing.GroupLayout(OfferDiscounts8);
        OfferDiscounts8.setLayout(OfferDiscounts8Layout);
        OfferDiscounts8Layout.setHorizontalGroup(
            OfferDiscounts8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OfferDiscounts8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(OfferDiscounts8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OfferDiscounts8Layout.createSequentialGroup()
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        OfferDiscounts8Layout.setVerticalGroup(
            OfferDiscounts8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OfferDiscounts8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel36)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        searchCustomer.setBackground(new java.awt.Color(255, 255, 255));
        searchCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchCustomerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchCustomerMouseExited(evt);
            }
        });

        jLabel34.setForeground(new java.awt.Color(0, 153, 0));
        jLabel34.setText("Search Customer");

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/New Tab/Serach Custoer.png"))); // NOI18N

        javax.swing.GroupLayout searchCustomerLayout = new javax.swing.GroupLayout(searchCustomer);
        searchCustomer.setLayout(searchCustomerLayout);
        searchCustomerLayout.setHorizontalGroup(
            searchCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(searchCustomerLayout.createSequentialGroup()
                .addComponent(jLabel34)
                .addGap(0, 54, Short.MAX_VALUE))
        );
        searchCustomerLayout.setVerticalGroup(
            searchCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchCustomerLayout.createSequentialGroup()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addGap(0, 30, Short.MAX_VALUE))
        );

        OfferDiscounts9.setBackground(new java.awt.Color(255, 255, 255));
        OfferDiscounts9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OfferDiscounts9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OfferDiscounts9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OfferDiscounts9MouseExited(evt);
            }
        });

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/New Tab/Balance Sheet.png"))); // NOI18N

        TodaySales.setForeground(new java.awt.Color(0, 153, 0));
        TodaySales.setText("Close This Month");

        javax.swing.GroupLayout OfferDiscounts9Layout = new javax.swing.GroupLayout(OfferDiscounts9);
        OfferDiscounts9.setLayout(OfferDiscounts9Layout);
        OfferDiscounts9Layout.setHorizontalGroup(
            OfferDiscounts9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OfferDiscounts9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OfferDiscounts9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TodaySales))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        OfferDiscounts9Layout.setVerticalGroup(
            OfferDiscounts9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OfferDiscounts9Layout.createSequentialGroup()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TodaySales)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        ClientHistory.setBackground(new java.awt.Color(255, 255, 255));
        ClientHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClientHistoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ClientHistoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ClientHistoryMouseExited(evt);
            }
        });

        jLabel38.setForeground(new java.awt.Color(0, 153, 0));
        jLabel38.setText("Customer History");

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/New Tab/Serach Custoer.png"))); // NOI18N

        javax.swing.GroupLayout ClientHistoryLayout = new javax.swing.GroupLayout(ClientHistory);
        ClientHistory.setLayout(ClientHistoryLayout);
        ClientHistoryLayout.setHorizontalGroup(
            ClientHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ClientHistoryLayout.createSequentialGroup()
                .addComponent(jLabel38)
                .addGap(0, 42, Short.MAX_VALUE))
        );
        ClientHistoryLayout.setVerticalGroup(
            ClientHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientHistoryLayout.createSequentialGroup()
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(AllCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(OverallSales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(monthSales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OfferDiscounts8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ClientHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(todaySale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(OfferDiscounts9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(933, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AllCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OverallSales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(todaySale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthSales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OfferDiscounts8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ClientHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(OfferDiscounts9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(321, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Customers", jPanel4);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        addStock.setBackground(new java.awt.Color(255, 255, 255));
        addStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addStockMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addStockMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addStockMouseExited(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(0, 153, 0));
        jLabel16.setText("  Adjust Stock Levels");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/inventory icons/add.png"))); // NOI18N

        javax.swing.GroupLayout addStockLayout = new javax.swing.GroupLayout(addStock);
        addStock.setLayout(addStockLayout);
        addStockLayout.setHorizontalGroup(
            addStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addStockLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(36, 36, 36))
            .addGroup(addStockLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addContainerGap())
        );
        addStockLayout.setVerticalGroup(
            addStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addStockLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.add(addStock);
        addStock.setBounds(49, 28, 130, 110);

        history.setBackground(new java.awt.Color(255, 255, 255));
        history.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                historyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                historyMouseExited(evt);
            }
        });

        jLabel17.setForeground(new java.awt.Color(0, 153, 0));
        jLabel17.setText("    Inventory History");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/inventory icons/history (1).png"))); // NOI18N

        javax.swing.GroupLayout historyLayout = new javax.swing.GroupLayout(history);
        history.setLayout(historyLayout);
        historyLayout.setHorizontalGroup(
            historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historyLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel20)
                .addContainerGap(21, Short.MAX_VALUE))
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        historyLayout.setVerticalGroup(
            historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(history);
        history.setBounds(220, 20, 120, 120);

        history1.setBackground(new java.awt.Color(255, 255, 255));
        history1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                history1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                history1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                history1MouseExited(evt);
            }
        });

        jLabel18.setForeground(new java.awt.Color(0, 153, 0));
        jLabel18.setText("  View In Stock Items");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/New Tab/In Stock.png"))); // NOI18N

        javax.swing.GroupLayout history1Layout = new javax.swing.GroupLayout(history1);
        history1.setLayout(history1Layout);
        history1Layout.setHorizontalGroup(
            history1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(history1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, history1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(26, 26, 26))
        );
        history1Layout.setVerticalGroup(
            history1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(history1Layout.createSequentialGroup()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(history1);
        history1.setBounds(420, 30, 130, 109);

        history2.setBackground(new java.awt.Color(255, 255, 255));
        history2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                history2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                history2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                history2MouseExited(evt);
            }
        });

        jLabel19.setForeground(new java.awt.Color(0, 153, 0));
        jLabel19.setText("View Out Of Stock");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectImages/inventory icons/out-of-stock (1).png"))); // NOI18N

        javax.swing.GroupLayout history2Layout = new javax.swing.GroupLayout(history2);
        history2.setLayout(history2Layout);
        history2Layout.setHorizontalGroup(
            history2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(history2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(history2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        history2Layout.setVerticalGroup(
            history2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(history2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(history2);
        history2.setBounds(50, 190, 130, 98);

        jTabbedPane1.addTab("Inventory", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addGap(67, 67, 67))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OfferDiscountsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OfferDiscountsMouseEntered
       OfferDiscounts.setBackground(Color.decode("#deedee"));
    }//GEN-LAST:event_OfferDiscountsMouseEntered

    private void AddSearchProductMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddSearchProductMouseEntered
        AddSearchProduct.setBackground(Color.decode("#deedee"));
    }//GEN-LAST:event_AddSearchProductMouseEntered

    private void AddSearchProductMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddSearchProductMouseExited
      AddSearchProduct.setBackground(Color.WHITE);
    }//GEN-LAST:event_AddSearchProductMouseExited

    private void GenerateCategoreyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenerateCategoreyMouseEntered
        GenerateCategorey.setBackground(Color.decode("#deedee"));
    }//GEN-LAST:event_GenerateCategoreyMouseEntered

    private void GenerateCategoreyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenerateCategoreyMouseExited
        GenerateCategorey.setBackground(Color.WHITE);
    }//GEN-LAST:event_GenerateCategoreyMouseExited

    private void TodayStatsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TodayStatsMouseEntered
        TodayStats.setBackground(Color.decode("#deedee"));
    }//GEN-LAST:event_TodayStatsMouseEntered

    private void TodayStatsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TodayStatsMouseExited
            TodayStats.setBackground(Color.WHITE);
    }//GEN-LAST:event_TodayStatsMouseExited

    private void DeleteProductMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteProductMouseEntered
        DeleteProduct.setBackground(Color.decode("#deedee"));
    }//GEN-LAST:event_DeleteProductMouseEntered

    private void DeleteProductMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteProductMouseExited
        DeleteProduct.setBackground(Color.WHITE);
    }//GEN-LAST:event_DeleteProductMouseExited

    private void OfferDiscountsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OfferDiscountsMouseExited
        OfferDiscounts.setBackground(Color.WHITE);
    }//GEN-LAST:event_OfferDiscountsMouseExited

    private void AddSearchProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddSearchProductMouseClicked
            ProductCorner productCorner = new ProductCorner();
            productCorner.setVisible(true);
            productCorner.setLocationRelativeTo(null);
            productCorner.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            productCorner.setResizable(false);
    }//GEN-LAST:event_AddSearchProductMouseClicked

    private void GenerateCategoreyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenerateCategoreyMouseClicked
       CategoreyManager cm = new CategoreyManager();
        cm.setVisible(true);
        cm.setResizable(false);
        cm.setLocationRelativeTo(null);
       cm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       cm.setResizable(false);
       
    }//GEN-LAST:event_GenerateCategoreyMouseClicked

    private void addStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStockMouseClicked
        AdjustStockLevels im = new AdjustStockLevels();    
                im.setVisible(true);
        im.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        im.setLocationRelativeTo(null);
        im.setResizable(false);
    }//GEN-LAST:event_addStockMouseClicked

    private void addStockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStockMouseEntered
       addStock.setBackground(Color.decode( "#90ee90"));
    }//GEN-LAST:event_addStockMouseEntered

    private void addStockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStockMouseExited
        addStock.setBackground(Color.WHITE);
    }//GEN-LAST:event_addStockMouseExited

    private void historyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyMouseClicked
        PrintInventoryHistory pih = new PrintInventoryHistory();
        pih.setVisible(true);
        pih.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pih.setLocationRelativeTo(null);
        pih.setResizable(false);
    }//GEN-LAST:event_historyMouseClicked

    private void historyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyMouseEntered
        history.setBackground(Color.decode("#90ee90"));
    }//GEN-LAST:event_historyMouseEntered

    private void historyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyMouseExited
        history.setBackground(Color.white);
    }//GEN-LAST:event_historyMouseExited

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_jButton1MouseClicked

    private void history1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_history1MouseClicked
       PrintAvailableStock past = new PrintAvailableStock();
       past.setVisible(true);
       past.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        past.setLocationRelativeTo(null);
      
       past.setResizable(false);
    }//GEN-LAST:event_history1MouseClicked

    private void history1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_history1MouseEntered
        history1.setBackground(Color.decode("#90ee90"));
    }//GEN-LAST:event_history1MouseEntered

    private void history1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_history1MouseExited
        history1.setBackground(Color.WHITE);
    }//GEN-LAST:event_history1MouseExited

    private void history2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_history2MouseClicked
        LowOnStock lons = new LowOnStock();
        lons.setLocationRelativeTo(null);
      
       lons.setResizable(false);
        
    }//GEN-LAST:event_history2MouseClicked

    private void history2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_history2MouseEntered
        history2.setBackground(Color.decode("#90ee90"));
    }//GEN-LAST:event_history2MouseEntered

    private void history2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_history2MouseExited
        history2.setBackground(Color.WHITE);
    }//GEN-LAST:event_history2MouseExited

    private void TodayStatsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TodayStatsMouseClicked
       ImageAdder imgAdder = new ImageAdder();
       imgAdder.setVisible(true);
       imgAdder.setLocationRelativeTo(null);
       imgAdder.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_TodayStatsMouseClicked

    private void OfferDiscountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OfferDiscountsMouseClicked
           OfferDiscountPanel odp = new OfferDiscountPanel();
           odp.setVisible(true);
           odp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
           odp.setLocationRelativeTo(null);
           odp.setResizable(false);
           
    }//GEN-LAST:event_OfferDiscountsMouseClicked

    private void OfferDiscounts1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OfferDiscounts1MouseClicked
        UpdateDiscounts update = new UpdateDiscounts();
        update.setVisible(true);
        update.setLocationRelativeTo(null);
        update.setResizable(false);
        update.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_OfferDiscounts1MouseClicked

    private void OfferDiscounts1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OfferDiscounts1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_OfferDiscounts1MouseEntered

    private void OfferDiscounts1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OfferDiscounts1MouseExited
       AllCustomers.setBackground(Color.WHITE);
    }//GEN-LAST:event_OfferDiscounts1MouseExited

    private void AllCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AllCustomersMouseClicked
        CustomerTabe ct = new CustomerTabe();
        CustomerTabe.ViewAllCustomers view = ct.new ViewAllCustomers();
        //view.create();
    }//GEN-LAST:event_AllCustomersMouseClicked

    private void AllCustomersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AllCustomersMouseEntered
        AllCustomers.setBackground(Color.decode("#90ee90"));
    }//GEN-LAST:event_AllCustomersMouseEntered

    private void AllCustomersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AllCustomersMouseExited
        AllCustomers.setBackground(Color.WHITE);
    }//GEN-LAST:event_AllCustomersMouseExited

    private void OverallSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OverallSalesMouseClicked
                  CustomerTabe ct = new CustomerTabe();
            CustomerTabe.OverallSales sales = ct.new OverallSales();
    }//GEN-LAST:event_OverallSalesMouseClicked

    private void OverallSalesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OverallSalesMouseEntered
        OverallSales.setBackground(Color.decode("#90ee90"));
    }//GEN-LAST:event_OverallSalesMouseEntered

    private void OverallSalesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OverallSalesMouseExited
        OverallSales.setBackground(Color.WHITE);
    }//GEN-LAST:event_OverallSalesMouseExited

    private void monthSalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthSalesMouseClicked
        CustomerTabe ct = new CustomerTabe();
         CustomerTabe.MonthlySales monthSales = ct.new MonthlySales();
    }//GEN-LAST:event_monthSalesMouseClicked

    private void monthSalesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthSalesMouseEntered
        monthSales.setBackground(Color.decode("#90ee90"));
    }//GEN-LAST:event_monthSalesMouseEntered

    private void monthSalesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monthSalesMouseExited
       monthSales.setBackground(Color.WHITE);
    }//GEN-LAST:event_monthSalesMouseExited

    private void todaySaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_todaySaleMouseClicked
        CustomerTabe ct = new CustomerTabe();
        CustomerTabe.DailySales dailySales = ct.new DailySales();
    }//GEN-LAST:event_todaySaleMouseClicked

    private void todaySaleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_todaySaleMouseEntered
        todaySale.setBackground(Color.decode("#90ee90"));
    }//GEN-LAST:event_todaySaleMouseEntered

    private void todaySaleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_todaySaleMouseExited
       todaySale.setBackground(Color.WHITE);
    }//GEN-LAST:event_todaySaleMouseExited

    private void searchCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchCustomerMouseClicked
        CustomerTabe ct = new CustomerTabe();
        CustomerTabe.CustomerDetails customerDetails = ct.new CustomerDetails();
        customerDetails.myDetails();
    }//GEN-LAST:event_searchCustomerMouseClicked

    private void searchCustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchCustomerMouseEntered
        searchCustomer.setBackground(Color.decode("#90ee90"));
    }//GEN-LAST:event_searchCustomerMouseEntered

    private void searchCustomerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchCustomerMouseExited
        searchCustomer.setBackground(Color.WHITE);
    }//GEN-LAST:event_searchCustomerMouseExited

    private void OfferDiscounts8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OfferDiscounts8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_OfferDiscounts8MouseClicked

    private void OfferDiscounts8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OfferDiscounts8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_OfferDiscounts8MouseEntered

    private void OfferDiscounts8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OfferDiscounts8MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_OfferDiscounts8MouseExited

    private void OfferDiscounts9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OfferDiscounts9MouseClicked
        String data = java.time.LocalDate.now()+"";
        String[] date = data.split("-");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        manageTAccount mta = new manageTAccount();
        mta.parse();
        mta.calculateCurrentStockState(month, year);

        
    }//GEN-LAST:event_OfferDiscounts9MouseClicked

    private void OfferDiscounts9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OfferDiscounts9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_OfferDiscounts9MouseEntered

    private void OfferDiscounts9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OfferDiscounts9MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_OfferDiscounts9MouseExited

    private void ClientHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientHistoryMouseClicked
                    CustomerTabe ct = new CustomerTabe();
        CustomerTabe.CustomerDetails customerDetails = ct.new CustomerDetails();
        customerDetails.customerHistory();
    }//GEN-LAST:event_ClientHistoryMouseClicked

    private void ClientHistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientHistoryMouseEntered
        ClientHistory.setBackground(Color.decode("#90ee90"));
    }//GEN-LAST:event_ClientHistoryMouseEntered

    private void ClientHistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientHistoryMouseExited
       ClientHistory.setBackground(Color.WHITE);
    }//GEN-LAST:event_ClientHistoryMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     
        
      AdminMenu am = new AdminMenu();
   
      am.setVisible(true);
      am.setLocationRelativeTo(null);
      am.setExtendedState(MAXIMIZED_BOTH);
//      am.setResizable(false);
      am.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddSearchProduct;
    private javax.swing.JPanel AllCustomers;
    private javax.swing.JPanel ClientHistory;
    private javax.swing.JPanel DeleteProduct;
    private javax.swing.JPanel GenerateCategorey;
    private javax.swing.JPanel OfferDiscounts;
    private javax.swing.JPanel OfferDiscounts1;
    private javax.swing.JPanel OfferDiscounts8;
    private javax.swing.JPanel OfferDiscounts9;
    private javax.swing.JPanel OverallSales;
    private javax.swing.JLabel TodaySales;
    private javax.swing.JPanel TodayStats;
    private javax.swing.JPanel addStock;
    private javax.swing.JPanel history;
    private javax.swing.JPanel history1;
    private javax.swing.JPanel history2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel monthSales;
    private javax.swing.JPanel searchCustomer;
    private javax.swing.JPanel todaySale;
    // End of variables declaration//GEN-END:variables
}
