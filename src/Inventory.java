/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 3tee
 */
public class Inventory extends Product implements Comparable<Inventory>{
    int Quantity;
    int TotalValue;


    public Inventory(int Quantity, int TotalValue, int ProductID, String productName, String Categorey, int costPrice, int sellingPrice, String description, boolean status)
    {
        super(ProductID, productName, Categorey, costPrice, sellingPrice, description, status);
        this.Quantity = Quantity;
        this.TotalValue = TotalValue;
    }
    
    
    public void updateQuantity(int Quantity) {
        this.Quantity = this.Quantity + Quantity;
    }

    public Inventory(Inventory i) {
        super(i.getProductID(),i.getProductName(),i.getCategorey(),i.getCostPrice(),i.getSellingPrice(),i.getProductDescription(),i.getProductStatus());
        this.Quantity  = i.Quantity;
        this.TotalValue = i.TotalValue;
        
    }
   

    
    
    
    public void setTotalValue() {
        this.TotalValue = Quantity * this.getCostPrice();
    }

    public int getTotalValue() {
        return TotalValue;
    }

    public int getQuantity() {
        return Quantity;
    }

    @Override
    public String toString() {
        return (super.toString()+";"+Quantity+";"+TotalValue);
    }

    @Override
    public int compareTo(Inventory o) {
        return this.Quantity - o.Quantity; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
  
}
