
import java.util.ArrayList;
import java.util.Iterator;


class Cart{
    private int productID, CP, SP, Qty, Total;
    String productName;
    
    Cart()
    {
        
    }

    public Cart(int productID, String productName, int CP, int SP, int Qty) {
        this.productID = productID;
        this.productName = productName;
        this.CP = CP;
        this.SP = SP;
        this.Qty = Qty;
        this.Total = Qty*SP;
    }

    public int getCP() {
        return CP;
    }

    public int getSP() {
        return SP;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductID() {
        return productID;
    }

    public int getQty() {
        return Qty;
    }

    public int getTotal() {
        return Total;
    }

    
    public String myString() {
        return productID+"|"+productName+"|"+CP+"|"+SP+"|"+Qty+"|"+Total;
    }
    
    
    
    
}


public class Sale {
    int saleID;
    int productsPurchased;
    Customer customer;
    String date;
    ArrayList<Cart> myCart = new ArrayList<>();
    ArrayList<Discounts> AvailedDiscounts = new ArrayList<>();
    int GrandTotal;
    int DiscountedAmount;
    int NetTotal;

    public Sale() {
           productsPurchased=0;
    }
    
    
    
    void calculateTotal()
    {
        for(Cart c : myCart)
        {
            productsPurchased++;
            GrandTotal = GrandTotal + c.getTotal();
        }
    }
    
    int calculateCurrentSaleSoldStockValue()
    {
        int sum=0;
        for(Cart c : myCart)
        {
            sum = sum + (c.getCP()*c.getQty());
        }
       return  sum;
    }
    
    void getDiscountAmount()
    {
        double sum=0;
        for(Discounts d : AvailedDiscounts)
        {;
         sum = sum + d.getPercentage();
        }
        
        sum/=100;
        
        DiscountedAmount = (int) (sum*GrandTotal);
    }
    
    void getNetTotal()
    {
        NetTotal = GrandTotal - DiscountedAmount;
    }

    @Override
    public String toString() {
       String invoice=null;
       
       invoice = saleID+";"+productsPurchased+";"+date+";"+GrandTotal+";"+DiscountedAmount+";"+NetTotal+";";

       if(customer!=null)
       invoice = invoice + customer.myString()+";";
       else{
           invoice = invoice+"Walking Sale"+";";
       }
       

       for(Discounts dd : AvailedDiscounts)
       {
           invoice = invoice + dd.myString()+"---";
    
       }
       
       invoice = invoice + ";";

       
       for(Cart c : myCart)
       {
           invoice = invoice + c.myString()+"---";

       }
       
       
       
       return invoice;
    }
    
    
    
    
}
