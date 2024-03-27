
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 3tee
 */
public class InventoryHistory extends Inventory{
    
    int actionID;
    String actionPerformedString;
    Date d;

    public InventoryHistory(Inventory i, Date d, String actionPerformedString, int actionID){
        
        super(i);
       // this.statusString = statusString;
        this.d = d;
        this.actionID = actionID;
        this.actionPerformedString = actionPerformedString;
        
        
    }

    @Override
    public String toString() {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(d);
        return (actionID+";"+actionPerformedString+";"+super.toString()+";"+formattedDate);
        
    }

}
