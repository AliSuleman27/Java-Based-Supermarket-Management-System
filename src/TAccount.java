
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

class manageTAccount{
boolean isThisMonthClosed = false;
boolean isPrevMonthClosed = false;
ArrayList<TAccount> myAccounts = new ArrayList<>();


void writeInFile()
{
    try {
        FileWriter fw  = new FileWriter("src\\data\\accounts.txt");
           for(TAccount t : myAccounts)
    {
            fw.write(t.toString()+"\n");
    }
           fw.close();
    } catch (Exception e) {
    }
 
}
int toInt(String str)
{
    return Integer.parseInt(str);
}

boolean toBool(String str){
    return Boolean.parseBoolean(str);
}
void parse()
{
    File file = new File("src\\data\\accounts.txt");
    try {
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine())
        {
            String text = sc.nextLine();
            String[] fields = text.split(";");
                    String Month = fields[0]+"";
                   
                    int CurrentStockValue = toInt(fields[1]);
                    
                    int EndingInventory = toInt(fields[2]);
                    int TotalInventoryValue = toInt(fields[3]);
                    int Soldout = toInt(fields[4]);
                    int thisMonthEndingInventory = toInt(fields[5]);
                    boolean Status = toBool(fields[6]); //profitLoss
                    int totalExpenditure = toInt(fields[7]);
                    int resultantOutcome = toInt(fields[8]);
                    int SoldoutSP = toInt(fields[9]);
                    int SoldoutSPdis = toInt(fields[10]);
                    
            myAccounts.add(new TAccount(Month, CurrentStockValue, EndingInventory, TotalInventoryValue, Soldout, thisMonthEndingInventory, Status, totalExpenditure, resultantOutcome, SoldoutSP, SoldoutSPdis));
        }
        sc.close();
    } catch (Exception e) {
        System.out.println("asjhcsjjh");
    }
}


void calculateTotalSoldStock(String month , String year)
{
   
}

int[] getMonthYear(String month, String year)
{
    int[] arr = new int[2];
    arr[0] = Integer.parseInt(month);
    arr[1] = Integer.parseInt(year);
    return arr;
}


int[] getSoldStock(int month,int year)
{
    int sum1=0, sum2=0, sum3=0;
    try{
    Scanner sc = new Scanner(new File("src\\data\\sales.txt"));
    while(sc.hasNextLine())
    {
        String[] data = sc.nextLine().split(";");
        int dmonth = toInt(data[2].split("-")[1]);
        int dyear = toInt(data[2].split("-")[0]);
        if(month==dmonth && dyear==year)
        {
            sum1 = sum1 + toInt(data[3]);
            sum2 = sum2 + toInt(data[5]);
            sum3 = sum3 + toInt(data[9]);
        }
    }
    }catch(Exception e)
    {
        
    }
    int[] arr = {sum1,sum2,sum3};
    return arr;
}

int getLast(int year, int month)
{
         YearMonth yearMonth = YearMonth.of(year, month);
        int lastDay = yearMonth.lengthOfMonth();
    return lastDay;
}

 public static boolean isDateAfterMonth(LocalDate date, YearMonth month) {
        YearMonth dateYearMonth = YearMonth.from(date);

        return dateYearMonth.isAfter(month);
    }
int getPreviousClosingInventory(int month, int year) throws Exception
{
            int[] previousMonth = new int[2];
        previousMonth[0] = Integer.parseInt(myAccounts.get(myAccounts.size()-1).Month.split("-")[0]);
        previousMonth[1] = Integer.parseInt(myAccounts.get(myAccounts.size()-1).Month.split("-")[1]);
        System.out.println("MMMM - "+previousMonth[0]+" YYYY- "+previousMonth[1]+"");
        
        
        System.out.println(month+" "+year);
        String date = java.time.LocalDate.now()+"";
        String[] datesplit = date.split("-");
        int currentDay = toInt(datesplit[2]);
        System.out.println(currentDay);
        int lastDay = getLast(year, month);
        System.out.println(lastDay);
       
        YearMonth ym = YearMonth.of(year,month);
        
        boolean isAfter = isDateAfterMonth(LocalDate.now(), ym);
        System.out.println(isAfter);
        
        if((previousMonth[1]==month && previousMonth[0]==year))
        {
            throw new Exception("The Month Is Already Closed: ");
        }
        
        
        else if((previousMonth[1]==month-1 && previousMonth[0]==year))
        {
            
            if(currentDay==lastDay || isAfter)
            {
                isPrevMonthClosed = true;
            return myAccounts.get(myAccounts.size()-1).thisMonthEndingInventory;
               
            }
            else{
                 throw new Exception("Dear Admin, You can not do perform closing becuase, Becuase the date for closing muste be the last date of the month or any date of last month");
            }
            
            
            
        }
        else{
            int yn = JOptionPane.showConfirmDialog(null, "Previous Month "+(month-1)+"-"+year+" is Not Closed Do You want to close it");
            if(yn==0)
            {
                calculateCurrentStockState(month-1, year);
            }
            else if(yn==1){
                throw new Exception("Dear Admin Previous Month(s) not closed \n Therefore, Closing Impossible");
            }
            else
            {
                 throw new Exception("Dear Admin Previous Month(s) not closed \n Therefore, Closing Impossible");
            }
            
        } 
  return 0;           
}

boolean getProfitLossStatus(int CP, int SP)
{
    if(SP>CP)
    {
        return true;
    }
    return false;
}
String calculateCurrentStockState(int month,int year)
{
    String retStr;
    try{
        
     int closingInventory=0;   
    closingInventory = getPreviousClosingInventory(month, year);
    System.out.println("Ending Inventory previous Month : "+closingInventory);
    retStr = "Ending Inventory previous Month : "+(month-1)+"-"+year+closingInventory+"\n";
        int sum=0;
    String thisMonthYear = year+"-"+month;
    try {
        Scanner sc = new Scanner(new File("src\\data\\history.txt"));
        while(sc.hasNextLine())
        {
            
            String str = sc.nextLine();
            String[] data = str.split(";");
            String da = data[11];
            String[] dat = da.split("-");
            int[] date = {Integer.parseInt(dat[0]), Integer.parseInt(dat[1])};
            if(date[0]==year && date[1]==month && (data[1].equals("Increased")))
            {
                sum = sum + toInt(data[10]);
            }
        }


     
        
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    
    
    int thisStock = sum;
    
    System.out.println("Total Inventory of this Month "+month+" is: "+sum);
    retStr = retStr + "Total Inventory of this Month ("+month+"-"+year+") is: "+sum+"\n";
    
        int totalStockValue = thisStock + closingInventory;
    System.out.println("Total Stock Value: "+totalStockValue);
    retStr = retStr + "Total Stock Value: "+totalStockValue+"\n";
    int[] soldStock = getSoldStock(month, year);
    System.out.println("Total Sold Stock (Cost Price): "+soldStock[2]);
    retStr = retStr +"Total Sold Stock (Cost Price): "+soldStock[2]+"\n";
    System.out.println("Total Sold Stock(Selling Price)"+soldStock[0]);
    System.out.println("Total Sold Stock(Selling Price Discount Applied: ): "+soldStock[1]);
    retStr = retStr + "Total Sold Stock(Selling Price)"+soldStock[0] + "\n";
    retStr = retStr + "Total Sold Stock(Selling Price Discount Applied: ): "+soldStock[1] + "\n";
    
    
    
    boolean status = getProfitLossStatus(soldStock[2], soldStock[1]);
    
    if(status)
    {
        System.out.println("You Sales are in profit");
        retStr = retStr + "SALES STATUS: Profit" +"\n";
    }
    else{
        System.out.println("You Sales are in Loss");
        retStr = retStr + "SALES STATUS: Loss"+"\n";
    }
    
    int thisMonthClosingInventory = totalStockValue+ soldStock[0];
    System.out.println("This Month Closing Inventory     \n" +
": "+thisMonthClosingInventory);

    int salesDiff = soldStock[1] - soldStock[2];
    retStr = retStr + "ProfitLoss Amount: "+salesDiff +"\n";
        
        int expense=0;
        try {
            Scanner sc1 = new Scanner(new File("src\\data\\expenditure.txt"));
            while(sc1.hasNextLine())
            {
                String[] fields = sc1.nextLine().split(";");
                if(fields[0].contains(thisMonthYear))
                {
                    expense = expense + toInt(fields[1]);
                }
            }
        } catch (Exception e) {
        }
    
        retStr = retStr + "Expense: "+expense + "\n";
        
    int resultantOutcome = salesDiff - expense;
        retStr = retStr + "Outcome: "+resultantOutcome + "\n";
    
 
    myAccounts.add(new TAccount(thisMonthYear, sum, closingInventory, totalStockValue, soldStock[1], thisMonthClosingInventory, status, expense, resultantOutcome, soldStock[0], soldStock[1]));
    writeInFile();
    
        TAccountForm tacf = new TAccountForm(retStr,month,year);
        return retStr;
    
    }catch(Exception e)
    {
        JOptionPane.showMessageDialog(null, e.getMessage());
        System.out.println(e.getMessage());
    }
    
    return null;
    

}



    
}



public class TAccount {
    String Month;
    int CurrentStockValue;
    int EndingInventory;
    int TotalInventoryValue;
    int Soldout; //refers to cp
    int SoldoutSP; //refers to sp
    int SoldoutSPdis; //refers to discounted Selling Price;
    int thisMonthEndingInventory;
    boolean Status; //profitLoss
    int totalExpenditure;
    int resultantOutcome;

    
    
    
    public TAccount(String Month, int CurrentStockValue, int EndingInventory, int TotalInventoryValue, int Soldout, int thisMonthEndingInventory, boolean Status, int totalExpenditure, int resultantOutcome, int SoldoutSP, int SoldoutSPdis) {
        this.Month = Month;
        this.CurrentStockValue = CurrentStockValue;
        this.EndingInventory = EndingInventory;
        this.TotalInventoryValue = TotalInventoryValue;
        this.Soldout = Soldout;
        this.thisMonthEndingInventory = thisMonthEndingInventory;
        this.Status = Status;
        this.totalExpenditure = totalExpenditure;
        this.resultantOutcome = resultantOutcome;
        this.SoldoutSP = SoldoutSP;
        this.SoldoutSPdis = SoldoutSPdis;
    }

    @Override
    public String toString() {
        return (Month+";"+CurrentStockValue+";"+EndingInventory+";"+TotalInventoryValue+";"+Soldout+";"+thisMonthEndingInventory+";"+Status+";"+totalExpenditure+";"+resultantOutcome+";"+SoldoutSP+";"+SoldoutSPdis);
    }
    
    
    
    
    
    
}
