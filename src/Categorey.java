
public class Categorey {
    int ID;
    String categorey;

    public Categorey(int ID, String categorey) {
        this.ID = ID;
        this.categorey = categorey;
    }
    
    @Override
    public String toString() {
        return ID+";"+categorey;
    }

    public int getID() {
        return ID;
    }

    public String getCategorey() {
        return categorey;
    }
        
    
    
}
