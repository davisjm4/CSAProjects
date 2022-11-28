import java.util.*;
public class Order {
    //instances
    private ArrayList<Item> order;
    
    //constructor
    public Order(ArrayList<Item> order)
    {
        this.order = order;
    }
    
    //methods
    public ArrayList<Item> getOrderList()
    {
        return order;    
    }
    
    public Item getItem(int i)
    {
       return order.get(i);
    }
    
    public int getTotal()
    {
        if(order.size()>0)
        {
            int sum = 0;
            for(int i = 0; i < order.size(); i++)
            {
                sum += order.get(i).getPrice();      
            }
            return sum;
        }
        return 0;
    }  
    
}