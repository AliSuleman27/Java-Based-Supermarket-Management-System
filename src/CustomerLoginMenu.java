
//import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterContrastIJTheme;
import javax.swing.UIManager;

public class CustomerLoginMenu extends javax.swing.JFrame {

    public CustomerLoginMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        WelcomeLabel = new javax.swing.JLabel();
        ProfileChoosePrompt = new javax.swing.JLabel();
        RegisteredCustomerButton = new javax.swing.JButton();
        WalkingSaleButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        WantToRegisterLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));

        WelcomeLabel.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        WelcomeLabel.setForeground(new java.awt.Color(0, 204, 51));
        WelcomeLabel.setText("Welcome To Thrifty Store:");

        ProfileChoosePrompt.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        ProfileChoosePrompt.setForeground(new java.awt.Color(0, 0, 0));
        ProfileChoosePrompt.setText("Please Choose your Profile: ");

        RegisteredCustomerButton.setBackground(new java.awt.Color(0, 153, 0));
        RegisteredCustomerButton.setForeground(new java.awt.Color(255, 255, 255));
        RegisteredCustomerButton.setText("Registered Customer");
        RegisteredCustomerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegisteredCustomerButtonMouseClicked(evt);
            }
        });

        WalkingSaleButton.setBackground(new java.awt.Color(0, 153, 0));
        WalkingSaleButton.setForeground(new java.awt.Color(255, 255, 255));
        WalkingSaleButton.setText("Walking Sale Customer");
        WalkingSaleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WalkingSaleButtonMouseClicked(evt);
            }
        });

        ExitButton.setBackground(new java.awt.Color(255, 255, 255));
        ExitButton.setForeground(new java.awt.Color(255, 51, 51));
        ExitButton.setText("Exit");
        ExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitButtonMouseClicked(evt);
            }
        });

        WantToRegisterLabel.setBackground(new java.awt.Color(255, 51, 51));
        WantToRegisterLabel.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        WantToRegisterLabel.setForeground(new java.awt.Color(51, 102, 255));
        WantToRegisterLabel.setText("Want to Get Registered");
        WantToRegisterLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WantToRegisterLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(WantToRegisterLabel)
                                .addGap(17, 17, 17))
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addComponent(WelcomeLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                                                .addComponent(ExitButton))
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                                .addComponent(WalkingSaleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(28, 28, 28)
                                                                .addComponent(RegisteredCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(ProfileChoosePrompt))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(ExitButton))
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(WelcomeLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ProfileChoosePrompt)
                                .addGap(64, 64, 64)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(WalkingSaleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(RegisteredCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                                .addComponent(WantToRegisterLabel)
                                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void WalkingSaleButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WalkingSaleButtonMouseClicked
        GeneralCustomer gc = new GeneralCustomer(null);
        gc.setVisible(true);
        gc.setLocationRelativeTo(null);
        //gc.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        gc.setExtendedState(MAXIMIZED_BOTH);
    }//GEN-LAST:event_WalkingSaleButtonMouseClicked

    private void WantToRegisterLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WantToRegisterLabelMouseClicked
        CustomerSignUpForm csupform = new CustomerSignUpForm();
        csupform.setVisible(true);
        csupform.setLocationRelativeTo(null);
        csupform.setResizable(false);
        csupform.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_WantToRegisterLabelMouseClicked

    private void RegisteredCustomerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisteredCustomerButtonMouseClicked
        LoginForRegisteredCustomer lfrc = new LoginForRegisteredCustomer();
        lfrc.setVisible(true);
        lfrc.setLocationRelativeTo(null);
        lfrc.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        lfrc.setResizable(false);
    }//GEN-LAST:event_RegisteredCustomerButtonMouseClicked

    private void ExitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMouseClicked
        dispose();
        System.exit(0);
    }//GEN-LAST:event_ExitButtonMouseClicked

    public static void main(String[] args) {
        CustomerLoginMenu clm = new CustomerLoginMenu();
        clm.setVisible(true);
        clm.setResizable(false);
        clm.setLocationRelativeTo(null);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitButton;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel ProfileChoosePrompt;
    private javax.swing.JButton RegisteredCustomerButton;
    private javax.swing.JButton WalkingSaleButton;
    private javax.swing.JLabel WantToRegisterLabel;
    private javax.swing.JLabel WelcomeLabel;
    // End of variables declaration//GEN-END:variables
}
