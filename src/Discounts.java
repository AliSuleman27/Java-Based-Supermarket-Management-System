/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 3tee
 */
public class Discounts {
    
    String discountCode;
    double percentage;
    String categorey;
    boolean status;

    public Discounts() {
    }

    public Discounts(String discountCode, double percentage, String categorey, boolean status) {
        this.discountCode = discountCode;
        this.percentage = percentage;
        this.categorey = categorey;
        this.status = status;
    }

    public String getCategorey() {
        return categorey;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public double getPercentage() {
        return percentage;
    }

    boolean getStatus()
    {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
    @Override
    public String toString() {
       return discountCode+";"+status+";"+percentage+";"+categorey;
    }
    
    String myString()
    {
        return discountCode+"|"+status+"|"+percentage+"|"+categorey;
    }
    
    
}
