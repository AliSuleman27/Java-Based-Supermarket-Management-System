
public class CustomerDetails extends javax.swing.JFrame {

    
    void addDataInTextField(Customer customer, int totalSales)
    {
        myInfo.setEditable(false);
        myInfo.append("\nID-\t"+customer.getID()+"\n");
        myInfo.append("-------------------------------------------");
        myInfo.append("\nName-\t"+customer.getName()+"\n");
        myInfo.append("-------------------------------------------");
        myInfo.append("\nEmail-\t"+customer.getEmail()+"\n");
        myInfo.append("-------------------------------------------");
        myInfo.append("\nTotal Sales Performed-\t"+totalSales+"\n");
        myInfo.append("-------------------------------------------");
    }
    
    
    public CustomerDetails(Customer customer, int totalSales) {
        initComponents();
        addDataInTextField(customer, totalSales);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        myInfo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 18)); // NOI18N
        jLabel1.setText("My Details : ");

        myInfo.setColumns(20);
        myInfo.setRows(5);
        jScrollPane1.setViewportView(myInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea myInfo;
    // End of variables declaration//GEN-END:variables
}
