
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.io.File;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class GeneralCustomer extends JFrame {
    JPanel rightPanel = new JPanel();
    private JPanel contentPane;
    private JPanel productPanel;
    private JScrollPane scrollPane;
    private int nextID;
    Customer customer;
    private ArrayList<Product> products;
    ImageAdder allPhotos;
    ProductCorner pc;
    Sale sale = new Sale();
   // ArrayList<Discounts> AvailedDiscounts = new ArrayList<>();
    
    void FinalizeSale(){
        
        AdjustStockLevels stockLevels = new AdjustStockLevels();
        
     for(Cart c : sale.myCart){   
        for(int i=0; i<stockLevels.inventory.size() ; i++)
        {
            if(stockLevels.inventory.get(i).getProductID()==c.getProductID())
            {
                stockLevels.inventory.get(i).Quantity -= c.getQty();
            }
        }
     }
        stockLevels.writeInFile();
        stockLevels.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        stockLevels.dispose();
        
       

        Invoice invoice = new Invoice(sale,true);
        invoice.setVisible(true);
        invoice.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        invoice.setLocationRelativeTo(null);
        invoice.setResizable(false);
    }
    
    
    void getNextSaleID()
    {
        File file = new File("src\\data\\sales.txt");
        String str=null;
        
        
        try{
             Scanner sc = new Scanner(file);
             while(sc.hasNextLine())
             {
               str = sc.nextLine();
                 
             }
             sc.close();
        }
        catch(Exception e)
        {
            
        }
        
        if(str==null)
        {
            nextID = 1;
        }
        else{
        String[] lastSale = str.split(";");
        nextID = Integer.parseInt(lastSale[0])+1;
      }
    }
    
   
    
    void removeFromCart(int ID)
    {
        for(int i=0;i<sale.myCart.size();i++)
        {
            if(sale.myCart.get(i).getProductID()==ID)
            {
                sale.myCart.remove(i);
            }
        }
    }
    
    
    
    boolean addToCart(int ID, int Quantity)
    {
        boolean canAdd=false;
        AdjustStockLevels adj = new AdjustStockLevels();
        for(Inventory i : adj.inventory)
        {
            if(i.getProductID()==ID)
            {
                if(Quantity>i.Quantity)
                {
                    canAdd = false;
                    JOptionPane.showMessageDialog(null, "We are Sorry... Insufficeint Stock...");
                }
                else{
                    canAdd = true;
                }
            }
        }
        
        
        
        if(canAdd){
        getNextSaleID();
        sale.saleID = nextID;
        sale.myCart.add(getCartItem(ID,Quantity));
        }
        
        adj.dispose();
        return canAdd;
    }
    
    
    Cart getCartItem(int ID,int Quantity)
    {
        for(Product p : pc.products)
        {
            if(p.getProductID()==ID)
            {
                return new Cart(p.getProductID(),p.getProductName(),p.getCostPrice(),p.getSellingPrice(),Quantity);
            }
        }
        
        return null;
    }
    
    
    boolean check(int ID)
    {
        for(Product p : pc.products)
        {
            if(ID == p.getProductID())
            {
                if(p.getProductStatus())
                {
                    AdjustStockLevels adj = new AdjustStockLevels();
                    for(Inventory i : adj.inventory)
                    {
                        if(p.getProductID()==i.getProductID())
                        {
                            if(i.Quantity>0)
                                return true;
                        }
                    }
                    adj.dispose();
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }
    
    int getPrice(int ID)
    {
       for(Product p : pc.products)
        {
            if(ID == p.getProductID())
            {
                return p.getSellingPrice();
            }
        }
       return 0;
    }
    
    
    ArrayList<Discounts> parseMyFile(String filepath)
    {
        ArrayList<Discounts> allDiscounts = new ArrayList<>();
        File file = new File(filepath);
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine())
            {
                String str = sc.nextLine();
                String[] fields = str.split(";");
                allDiscounts.add(new Discounts(fields[0],Double.parseDouble(fields[2]),fields[3],Boolean.parseBoolean(fields[1])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allDiscounts;
    }
    
    
    boolean verify(String code)
    {
        for(Discounts dd : sale.AvailedDiscounts)
        {
            if(dd.getDiscountCode().equals(code))
            {
                return false;
            }
        }
        return true;
    }
    
    
    void addToRightPanel(Discounts selectedOne)
    {
         JPanel panel = new JPanel();
         panel.setLayout(new FlowLayout());
                                        
         JLabel label = new JLabel(selectedOne.getDiscountCode()+"--"+selectedOne.getPercentage());
         JButton removeButton = new JButton("Remove");
         removeButton.setBackground(Color.RED);
         removeButton.setForeground(Color.WHITE);
         removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sale.AvailedDiscounts.remove(selectedOne);
                rightPanel.remove(panel);
                rightPanel.revalidate();
                rightPanel.repaint();
            }
        });
         panel.add(label);
         panel.add(removeButton);
         rightPanel.add(panel);
         rightPanel.revalidate();
         rightPanel.repaint();
                                        
    }
    
    
    public GeneralCustomer(Customer customer) {
        
        
        this.customer = customer;
        sale.customer = this.customer;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        productPanel = new JPanel();
        productPanel.setLayout(new GridLayout(0, 4, 15, 10));
        scrollPane = new JScrollPane(productPanel);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        allPhotos = new ImageAdder();
        pc = new ProductCorner();

        
         JButton checkOut = new JButton("Check Out");
         checkOut.setForeground(Color.WHITE);
         checkOut.setBackground(Color.RED);
        // checkOut.setPreferredSize(new Dimension(100, 40));
         
         
         JButton AvailDiscounts = new JButton("Available Discounts");
         AvailDiscounts.setForeground(Color.WHITE);
         AvailDiscounts.setBackground(Color.BLUE);
         
         AvailDiscounts.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   
                    class CheckBoxListener implements ActionListener{
                    Discounts discount;
                    CheckBoxListener(Discounts discount)
                    {
                        this.discount = discount;
                    }
                    @Override
                public void actionPerformed(ActionEvent e) {
                    JCheckBox checkBox = (JCheckBox) e.getSource();
                    
                    if (checkBox.isSelected()) {
                        sale.AvailedDiscounts.add(discount);
                        System.out.println("Discount availed: " + discount.getDiscountCode());
                    } else if(!checkBox.isSelected()) {
                        
                        for(int i=0; sale.AvailedDiscounts.size()>i ; i++)
                        {
                            if(this.discount.getDiscountCode().equals(sale.AvailedDiscounts.get(i).getDiscountCode()))
                            {
                                sale.AvailedDiscounts.remove(i);
                            }
                        }
                        
                        
                        System.out.println("Discount removed: " + discount.getDiscountCode());
                    }
                }
                    
                 }
                    
                    
                    ArrayList<Discounts> allDiscounts = new ArrayList<>();
                    
                  
                   allDiscounts.addAll(parseMyFile("src\\data\\discounts.txt"));
                   
                   boolean stat = false;
                   for(Discounts d : allDiscounts)
                   {
                       if(d.getCategorey().equals("Both"))
                       {
                           stat = true;
                       }
                   }
                   
                   if(stat){
                        JFrame discountFrame = new JFrame();
                   discountFrame.setTitle("Aviable Discounts: ");
                   discountFrame.setLayout(new FlowLayout());
                   discountFrame.setSize(500, 400);
                   discountFrame.setLocationRelativeTo(contentPane);
                   
                   
                   for (Discounts discount : allDiscounts) {
                    if(discount.getStatus() && (discount.getCategorey().equals("Both") || discount.categorey.equals("Both"))){   
                    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    JCheckBox checkBox = new JCheckBox();
                    checkBox.addActionListener(new CheckBoxListener(discount));
                    panel.add(checkBox);
                    panel.add(new JLabel("Code: " + discount.getDiscountCode()));
                    panel.add(new JLabel("\tDiscount: " + discount.getPercentage() + "%"));
                    discountFrame.add(panel);
                
                        for(Discounts dd :sale.AvailedDiscounts)
                        {
                            if(dd.toString().equals(discount.toString()))
                            {
                                checkBox.setSelected(true);
                            }
                        }
                    }
                   }
                
                   
                
                   
                   
                   JPanel panel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
                   JButton button = new JButton("Avail Selected Discounts");
                   button.setForeground(Color.GREEN);
                   button.setBackground(Color.white);
                   panel.add(button);
                   discountFrame.add(panel);

                   discountFrame.setVisible(true);
                   button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                        JOptionPane.showMessageDialog(null, "Added Succefully");
                        discountFrame.dispose();
                    }
                        
                   });
                  
                   
                
                
                }else{
                       JOptionPane.showMessageDialog(null, "No Discounts Avaiable");
                   }
                }
                 
                
            });
         
         
         
         JPanel buttonPanel = new JPanel();
         buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
         buttonPanel.add(checkOut);
//         buttonPanel.add(promoCode);
         buttonPanel.add(AvailDiscounts);

         contentPane.add(buttonPanel, BorderLayout.NORTH);
        
         checkOut.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   
                    if(sale.myCart.isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Please Add Some Products To Checkout");
                    }
                    else{
                         dispose();
                    FinalizeSale();}
                   
                }
            });
            
        
        // create product boxes and add them to the panel
        for (Images i : allPhotos.images) {
            
            
            if(check(i.ID))
            {
             
            JPanel box = new JPanel();

            box.setLayout(new BorderLayout());
            ImageIcon img = new ImageIcon(i.path);
            Image image = img.getImage();
            
            Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            
            //Add Image to Box
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));  
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            box.add(imageLabel, BorderLayout.CENTER);
          
            //Add Name to Box && Price 
            String str = (i.pname + " | " + "Rs. " + getPrice(i.ID)).toUpperCase();
            JLabel nameLabel = new JLabel(str);
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
           // box.add(nameLabel, BorderLayout.SOUTH);
            
                JTextField quantity = new JTextField("1");
                quantity.setHorizontalAlignment(SwingConstants.CENTER);
               // box.add(quantity,BorderLayout.SOUTH);
            
            
            JPanel southPanel = new JPanel(new BorderLayout());    
               southPanel.add(nameLabel,BorderLayout.SOUTH);
               southPanel.add(quantity,BorderLayout.NORTH);
               
               
               
               
               
                box.add(southPanel,BorderLayout.SOUTH);
            //Add Button To Box
            JButton addButton = new JButton("Add");
            addButton.setBackground(Color.BLUE);
            addButton.setForeground(Color.WHITE);
            JButton removeButton = new JButton("Remove");
            removeButton.setBackground(Color.BLACK);
            removeButton.setForeground(Color.WHITE);
            
            JPanel NorthPanel = new JPanel(new BorderLayout());    
               NorthPanel.add(addButton,BorderLayout.WEST);
               NorthPanel.add(removeButton,BorderLayout.EAST);
            
            
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    
                        
                    if(addToCart(i.ID,Integer.parseInt(quantity.getText()))){
                    addButton.setBackground(Color.RED);
                    addButton.setText("Added");
                    
                    }
                   
                }
            });
            
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                  if(addButton.getText().equals("Added")){
                      removeFromCart(i.ID);
                      addButton.setText("Add");
                      addButton.setBackground(Color.BLUE);
                      addButton.setForeground(Color.WHITE);
                  }
                  else{
                      JOptionPane.showMessageDialog(null, "Product is Not Added .......");
                  }
                   
                }
            });
            
            box.add(NorthPanel, BorderLayout.NORTH);
            productPanel.add(box);
            box.revalidate();
            box.repaint();
        }

        pack();
        setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    }
 
}