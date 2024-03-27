
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 3tee
 */
public class CustomerTabe {
    
    
    
    
    class CustomerDetails{
        ArrayList<Customer> myCustomers = new ArrayList<>();
        void parse(String filepath)
        {
            try {
               Scanner sc  = new Scanner(new File(filepath));
                while(sc.hasNextLine())
                {
                    String str = sc.nextLine();
                    String[] fields = str.split(";");
                    myCustomers.add(new Customer(Integer.parseInt(fields[0]),fields[1], fields[3], fields[2]));
                    
                }
                sc.close();
            } catch (Exception e) {
            }
        }
        
        
        void myDetails()
        {
            JFrame frame = new JFrame();
            frame.setLayout(new FlowLayout());
            frame.setPreferredSize(new Dimension(200,200));
            frame.setLocationRelativeTo(null);
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.add(new JLabel("Customer Name: "),BorderLayout.NORTH);
            
            JPanel panel1 = new JPanel();
            panel.setLayout(new BorderLayout());
            JComboBox<String> Customers = new JComboBox<>();
            for(Customer c: myCustomers)
            {
                Customers.addItem(c.getName());
            }
            
            panel1.add(Customers,BorderLayout.SOUTH);
            
            JPanel panel2 = new JPanel();
            panel.setLayout(new BorderLayout());
            JButton button = new JButton("View Details");
            button.setBackground(Color.BLUE);
            button.setForeground(Color.WHITE);
            panel2.add(button,BorderLayout.CENTER);
            
                button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                  frame.dispose();
                  Customer c = null;
                  for(Customer cp: myCustomers)
                  {
                      if(cp.getName().equals(Customers.getSelectedItem()+""))
                      {
                          c = new Customer(cp.getID(),cp.getName(),cp.getEmail(),cp.getPassword());
                      }
                  }
                  CustomerInterface ci = new CustomerInterface(c,false);
                  ci.Func(false);
                  
                }
            });
            
            frame.add(panel);
            frame.add(panel1);
            frame.add(panel2);
            
            
            frame.pack();
            frame.setVisible(true);
        }
        
        void customerHistory()
        {
            JFrame frame = new JFrame();
            frame.setLayout(new FlowLayout());
            frame.setPreferredSize(new Dimension(200,200));
            frame.setLocationRelativeTo(frame);
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.add(new JLabel("Customer Name: "),BorderLayout.NORTH);
            
            JPanel panel1 = new JPanel();
            panel.setLayout(new BorderLayout());
            JComboBox<String> Customers = new JComboBox<>();
            for(Customer c: myCustomers)
            {
                Customers.addItem(c.getName());
            }
            
            panel1.add(Customers,BorderLayout.SOUTH);
            
            JPanel panel2 = new JPanel();
            panel.setLayout(new BorderLayout());
            JButton button = new JButton("View History");
            button.setBackground(Color.BLUE);
            button.setForeground(Color.WHITE);
            panel2.add(button,BorderLayout.CENTER);
            
                button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                  frame.dispose();
                  Customer c = null;
                  for(Customer cp: myCustomers)
                  {
                      if(cp.getName().equals(Customers.getSelectedItem()+""))
                      {
                          c = new Customer(cp.getID(),cp.getName(),cp.getEmail(),cp.getPassword());
                      }
                  }
                  CustomerInterface ci = new CustomerInterface(c,false);
                  ci.showMyHistory(true);
                  
                }
            });
            
            frame.add(panel);
            frame.add(panel1);
            frame.add(panel2);
            
            
            frame.pack();
            frame.setVisible(true);
        }
        
        
        public CustomerDetails() {
            parse("src\\data\\registeredCustomers.txt");
            
            
        }
        
    }
    
    
    
    class MonthlySales{
           JLabel headerLabel;
        JTextArea textArea;
        JTable table;
        JFrame frame = new JFrame();
        int total=0;
        int registeredSales=0;
        int walkingSales=0;
        String monthYear;
        ArrayList<Sale> mySales = new ArrayList<>();
        
    int getint(String str)
    {
        return Integer.parseInt(str);
    }
    
    
    
    void parse()    
    {
        File file = new File("src\\data\\sales.txt");
        
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine())
            {
                String myData = sc.nextLine();
                String[] data = myData.split(";");

                if(data[2].contains(monthYear)){
                Sale sale = new Sale();
                sale.saleID = Integer.parseInt(data[0]);
                sale.productsPurchased = Integer.parseInt(data[1]);
                sale.date = data[2];
                sale.GrandTotal = Integer.parseInt(data[3]);
                sale.DiscountedAmount = Integer.parseInt(data[4]);
                sale.NetTotal = Integer.parseInt(data[5]);
                
                if(data[6].equals("Walking Sale"))
                {
                    walkingSales++;
                    sale.customer = null;
                }
                else{
                    registeredSales++;
                    String[] customerCredentials = data[6].split("\\|");
                    sale.customer = new Customer();
                    sale.customer.setName(customerCredentials[1]);
                    sale.customer.setPassword(customerCredentials[2]);
                    sale.customer.setEmail(customerCredentials[3]);
                    sale.customer.setID(Integer.parseInt(customerCredentials[0]));
                }
                
                
                if(!data[7].equals("")){
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
                }
                
                System.out.println(sale.toString());
                mySales.add(sale);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
//            e.notify();
        }
        
    }
        
    void feedInTable()
    {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        
        for(Sale sale: mySales)
        {
            //"Sales ID", "Customer", "Grand Total", "Discount","Net Total";
            if(sale.customer!=null)
            {      
            String[] details = {(sale.saleID+""),(sale.customer.getName()),(sale.GrandTotal+""),(sale.DiscountedAmount+""),(sale.NetTotal+"")};
            tableModel.addRow(details);
            }
            else{
             String[] details = {(sale.saleID+""),("Walking Sale"),(sale.GrandTotal+""),(sale.DiscountedAmount+""),(sale.NetTotal+"")};
             tableModel.addRow(details);
            }
            
        }  

    }
     
    
    void proceed()
    {
          
        parse();
        
        if(mySales.size()>1){
        frame.setTitle("Thrifty Store");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setLayout(new FlowLayout());
      //  frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        // Create header components
        headerLabel = new JLabel("Dated : "+java.time.LocalDate.now(), JLabel.CENTER);
        headerLabel.setFont(headerLabel.getFont().deriveFont(Font.BOLD, 18f));
        // Create customer info components
        JPanel customerInfoPanel = new JPanel(new BorderLayout());

        JPanel eastPanel = new JPanel();
        eastPanel.add(new JLabel("Today's Total Sales: "));
        JTextField jtf = new JTextField();
        jtf.setPreferredSize(new Dimension(30,30));
        eastPanel.add(jtf);
        
        JTextField f2 = new JTextField();
        f2.setPreferredSize(new Dimension(30,30));
        eastPanel.add(new JLabel("Regsitered: "));
        eastPanel.add(f2);
        
        JTextField f3 = new JTextField();
        f3.setPreferredSize(new Dimension(30,30));
        eastPanel.add(new JLabel("Walking Sale: "));
        eastPanel.add(f3);
                
        customerInfoPanel.add(eastPanel,BorderLayout.EAST);
        // Create table
        table = new JTable(new DefaultTableModel(new Object[]{"Sales ID", "Sales Type", "Grand Total", "Discount","Net Total"}, 0));

        // Create main panel and add components
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(headerLabel, BorderLayout.NORTH);
        mainPanel.add(customerInfoPanel, BorderLayout.CENTER);
        mainPanel.add(new JScrollPane(table), BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel);
        frame.pack();

            jtf.setEditable(false);
            jtf.setText(mySales.size()+"");
                        f2.setEditable(false);
            f2.setText(registeredSales+"");
                        f3.setEditable(false);
            f3.setText(walkingSales+"");
            feedInTable();
            frame.setVisible(true);}else{
            JOptionPane.showMessageDialog(null, "Dear Admin, No Sales Found.....");
        }
    }
    
    
    String getMonthValue(String month) {
        String twoDigitMonth = "";

        switch (month.toLowerCase()) {
            case "january":
                twoDigitMonth = "01";
                break;
            case "february":
                twoDigitMonth = "02";
                break;
            case "march":
                twoDigitMonth = "03";
                break;
            case "april":
                twoDigitMonth = "04";
                break;
            case "may":
                twoDigitMonth = "05";
                break;
            case "june":
                twoDigitMonth = "06";
                break;
            case "july":
                twoDigitMonth = "07";
                break;
            case "august":
                twoDigitMonth = "08";
                break;
            case "september":
                twoDigitMonth = "09";
                break;
            case "october":
                twoDigitMonth = "10";
                break;
            case "november":
                twoDigitMonth = "11";
                break;
            case "december":
                twoDigitMonth = "12";
                break;
        }

        return twoDigitMonth;
    }
    
    MonthlySales()
    {
        JFrame selector = new JFrame();
        selector.setLayout(new FlowLayout());
        selector.setVisible(true);
        selector.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        selector.setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JComboBox<String> month = new JComboBox<>();

        String[] months = {"January", "February", "March", "April", "May", "June",
                           "July", "August", "September", "October", "November", "December"};

        for (String m : months) {
                month.addItem(m);
        }
        
        JComboBox<String> year = new JComboBox<>();

        String[] years = {"2023","2024","2025","2026"};

        for (String y : years) {
                year.addItem(y);
        }
        
        panel.add(month,BorderLayout.WEST);
        panel.add(year,BorderLayout.EAST);
        selector.add(panel);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        JButton view = new JButton("View");
        view.setForeground(Color.BLUE); view.setBackground(Color.WHITE);
        panel2.add(view,BorderLayout.EAST);
        selector.add(panel2);
        selector.setPreferredSize(new Dimension(200,100));
        selector.pack();
        
                 view.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   
                    if((month.getSelectedItem()+"").equals("") || (year.getSelectedItem()+"").equals(""))
                        JOptionPane.showMessageDialog(null, "Please Enter Month & Year");

                    else{
                        selector.dispose();
                    String str = getMonthValue(month.getSelectedItem()+"");
                    monthYear = year.getSelectedItem()+"-"+str;
                        proceed();
                    }
                   
                }
            });
        
      
            
            
    }
    }
    
    
    class DailySales{
        JLabel headerLabel;
        JTable table;
        JFrame frame = new JFrame();
        int total=0;
        int registeredSales=0;
        int walkingSales=0;
        String today;
        ArrayList<Sale> mySales = new ArrayList<>();
        
    int getint(String str)
    {
        return Integer.parseInt(str);
    }
    
    
    
    void parse()    
    {
        File file = new File("src\\data\\sales.txt");
        
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine())
            {
                String myData = sc.nextLine();
                String[] data = myData.split(";");
                
                
                if(data[2].equals(today)){
                    
                    
                Sale sale = new Sale();
                sale.saleID = Integer.parseInt(data[0]);
                sale.productsPurchased = Integer.parseInt(data[1]);
                sale.date = data[2];
                sale.GrandTotal = Integer.parseInt(data[3]);
                sale.DiscountedAmount = Integer.parseInt(data[4]);
                sale.NetTotal = Integer.parseInt(data[5]);
                
                if(data[6].equals("Walking Sale"))
                {
                    walkingSales++;
                    sale.customer = null;
                }
                else{
                    registeredSales++;
                    String[] customerCredentials = data[6].split("\\|");
                    sale.customer = new Customer();
                    sale.customer.setName(customerCredentials[1]);
                    sale.customer.setPassword(customerCredentials[2]);
                    sale.customer.setEmail(customerCredentials[3]);
                    sale.customer.setID(Integer.parseInt(customerCredentials[0]));
                }
                
                
                if(!data[7].equals("")){
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
                }
                
                System.out.println(sale.toString());
                mySales.add(sale);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
//            e.notify();
        }
    }
        
    void feedInTable()
    {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        
        for(Sale sale: mySales)
        {
            //"Sales ID", "Customer", "Grand Total", "Discount","Net Total";
            if(sale.customer!=null)
            {      
            String[] details = {(sale.saleID+""),(sale.customer.getName()),(sale.GrandTotal+""),(sale.DiscountedAmount+""),(sale.NetTotal+"")};
            tableModel.addRow(details);
            }
            else{
             String[] details = {(sale.saleID+""),("Walking Sale"),(sale.GrandTotal+""),(sale.DiscountedAmount+""),(sale.NetTotal+"")};
             tableModel.addRow(details);
            }
            
        }  

    }
        
    DailySales()
    {
        today = java.time.LocalDate.now()+"";
        parse();
        if(mySales.size()>0){
        frame.setTitle("Thrifty Store");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        // Create header components
        headerLabel = new JLabel("Dated : "+today, JLabel.CENTER);
        headerLabel.setFont(headerLabel.getFont().deriveFont(Font.BOLD, 18f));
        
        // Create customer info components
        JPanel customerInfoPanel = new JPanel(new BorderLayout());

        JPanel eastPanel = new JPanel();
        eastPanel.add(new JLabel("Today's Total Sales: "));
        JTextField jtf = new JTextField();
        jtf.setPreferredSize(new Dimension(30,30));
        eastPanel.add(jtf);
        
        JTextField f2 = new JTextField();
        f2.setPreferredSize(new Dimension(30,30));
        eastPanel.add(new JLabel("Regsitered: "));
        eastPanel.add(f2);
        
        JTextField f3 = new JTextField();
        f3.setPreferredSize(new Dimension(30,30));
        eastPanel.add(new JLabel("Walking Sale: "));
        eastPanel.add(f3);
                
        customerInfoPanel.add(eastPanel,BorderLayout.EAST);
        // Create table
        table = new JTable(new DefaultTableModel(new Object[]{"Sales ID", "Sales Type", "Grand Total", "Discount","Net Total"}, 0));

        // Create main panel and add components
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(headerLabel, BorderLayout.NORTH);
        mainPanel.add(customerInfoPanel, BorderLayout.CENTER);
        mainPanel.add(new JScrollPane(table), BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel);
        frame.pack();

            
            jtf.setEditable(false);
            jtf.setText(mySales.size()+"");
                        f2.setEditable(false);
            f2.setText(registeredSales+"");
                        f3.setEditable(false);
            f3.setText(walkingSales+"");
            feedInTable();
            
        }
        
        else
        {
            JOptionPane.showMessageDialog(null, "Dear Admin No Sales performed Today");
        }
            
            
    }
    }
    
    
    
    
    class OverallSales{
        JLabel headerLabel;
        JTextArea textArea;
        JTable table;
        JFrame frame = new JFrame();
        int total=0;
        int registeredSales=0;
        int walkingSales=0;
        ArrayList<Sale> mySales = new ArrayList<>();
        
    int getint(String str)
    {
        return Integer.parseInt(str);
    }
    
    
    
    void parse()    
    {
        File file = new File("src\\data\\sales.txt");
        
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
                    walkingSales++;
                    sale.customer = null;
                }
                else{
                    registeredSales++;
                    String[] customerCredentials = data[6].split("\\|");
                    sale.customer = new Customer();
                    sale.customer.setName(customerCredentials[1]);
                    sale.customer.setPassword(customerCredentials[2]);
                    sale.customer.setEmail(customerCredentials[3]);
                    sale.customer.setID(Integer.parseInt(customerCredentials[0]));
                }
                
                
                if(!data[7].equals("")){
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
                }
                
                System.out.println(sale.toString());
                mySales.add(sale);
            }
        } catch (Exception e) {
            e.printStackTrace();
//            e.notify();
        }
    }
        
    void feedInTable()
    {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        
        for(Sale sale: mySales)
        {
            //"Sales ID", "Customer", "Grand Total", "Discount","Net Total";
            if(sale.customer!=null)
            {      
            String[] details = {(sale.saleID+""),(sale.customer.getName()),(sale.GrandTotal+""),(sale.DiscountedAmount+""),(sale.NetTotal+"")};
            tableModel.addRow(details);
            }
            else{
             String[] details = {(sale.saleID+""),("Walking Sale"),(sale.GrandTotal+""),(sale.DiscountedAmount+""),(sale.NetTotal+"")};
             tableModel.addRow(details);
            }
            
        }  

    }
        
    OverallSales()
    {

        parse();
        
        if(mySales.size()>0){
        frame.setTitle("Thrifty Store");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        // Create header components
        headerLabel = new JLabel("The Thrifty Store || Sales Sheet", JLabel.CENTER);
        headerLabel.setFont(headerLabel.getFont().deriveFont(Font.BOLD, 18f));

        // Create customer info components
        JPanel customerInfoPanel = new JPanel(new BorderLayout());

        JPanel eastPanel = new JPanel();
        eastPanel.add(new JLabel("Total Sales: "));
        JTextField jtf = new JTextField();
        jtf.setPreferredSize(new Dimension(30,30));
        eastPanel.add(jtf);
        
        JTextField f2 = new JTextField();
        f2.setPreferredSize(new Dimension(30,30));
        eastPanel.add(new JLabel("Regsitered: "));
        eastPanel.add(f2);
        
        JTextField f3 = new JTextField();
        f3.setPreferredSize(new Dimension(30,30));
        eastPanel.add(new JLabel("Walking Sale: "));
        eastPanel.add(f3);
                
        customerInfoPanel.add(eastPanel,BorderLayout.EAST);
        // Create table
        table = new JTable(new DefaultTableModel(new Object[]{"Sales ID", "Sales Type", "Grand Total", "Discount","Net Total"}, 0));

        // Create main panel and add components
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(headerLabel, BorderLayout.NORTH);
        mainPanel.add(customerInfoPanel, BorderLayout.CENTER);
        mainPanel.add(new JScrollPane(table), BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel);
        frame.pack();
            jtf.setEditable(false);
            jtf.setText(mySales.size()+"");
                        f2.setEditable(false);
            f2.setText(registeredSales+"");
                        f3.setEditable(false);
            f3.setText(walkingSales+"");
            feedInTable();
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Dear Admin, No Sales are Perfomred Yet.....");
        }
            
            
    }
    }
    
    
    
    class ViewAllCustomers{
        
        JLabel headerLabel;
        JTextArea textArea;
        JTable table;
        JFrame frame = new JFrame();
        int total=0;
        
        
    void feedInTable()
    {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        
        
        File file = new File("src\\data\\registeredCustomers.txt");
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine())
            {
                total++;
                String str = sc.nextLine();
                String[] fields = str.split(";");
                tableModel.addRow(fields);
            }
            sc.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        
        if(total==0)
        {
            frame.dispose();
            JOptionPane.showMessageDialog(null, "Dear Admin, No Customers Have Regsitered Yet......");
        }
    }
        
    ViewAllCustomers()
    {

        frame.setTitle("Thrifty Store");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        // Create header components
        headerLabel = new JLabel("The Thrifty Store", JLabel.CENTER);
        headerLabel.setFont(headerLabel.getFont().deriveFont(Font.BOLD, 18f));

        // Create customer info components
        JPanel customerInfoPanel = new JPanel(new BorderLayout());
        customerInfoPanel.add(new JLabel("Customers Info"),BorderLayout.WEST);
        JPanel eastPanel = new JPanel();
        eastPanel.add(new JLabel("Total Customers: "));
        //customerInfoPanel.add(new JLabel("Total Customers: "),BorderLayout.EAST);
        JTextField jtf = new JTextField();
        jtf.setPreferredSize(new Dimension(30,30));
        eastPanel.add(jtf);
        customerInfoPanel.add(eastPanel,BorderLayout.EAST);
        // Create table
        table = new JTable(new DefaultTableModel(new Object[]{"ID", "Name", "Password", "Email"}, 0));

        // Create main panel and add components
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(headerLabel, BorderLayout.NORTH);
        mainPanel.add(customerInfoPanel, BorderLayout.CENTER);
        mainPanel.add(new JScrollPane(table), BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel);
        frame.pack();
        
        feedInTable();
        jtf.setEditable(false);
        jtf.setText(total+"");
    }}

}
