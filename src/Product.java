
public class Product{
private int ProductID;
private String productName, Categorey;
private int costPrice, sellingPrice;
boolean status;
String productDescription;


    Product(Product p)
    {
        this.ProductID = ProductID;
        this.productName = productName;
        this.Categorey = Categorey;
        this.sellingPrice = sellingPrice;
        this.costPrice = costPrice;
        this.productDescription = productDescription;
    }
    public String getCategorey() {
        return Categorey;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public int getProductID() {
        return ProductID;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setCategorey(String Categorey) {
        this.Categorey = Categorey;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }



    
    
    public Product(int ProductID, String productName, String Categorey, int costPrice, int sellingPrice, String description, boolean status) {
        this.ProductID = ProductID;
        this.productName = productName;
        this.Categorey = Categorey;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.productDescription = description;
        this.status = status;
    }
    
    
    public Product() {
    }

    @Override
    public String toString() {
        return ProductID+";"+ productName + ";"+ productDescription + ";" + 
               Categorey+ ";" + costPrice + ";" + sellingPrice +";"+Boolean.toString(status);
    }
    
    
    public String myString_three()
    {
        String str = (getProductID()+";")+(getProductName()+";")+(getCategorey());
        return str;
    }
    
    public String[] myString()
    {
        String [] str = {getProductID()+"",getProductName(),getCategorey()};
        return str;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    
    boolean getProductStatus(){
        return this.status;
    }
    
    void setProductStatus(boolean status){
        this.status = status;
    }
            

}
