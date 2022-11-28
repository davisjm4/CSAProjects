import java.util.*;
public class Item {
    //instances
    private String item; 
    
    //constructor    
    public Item(String item)
    {
        this.item = item;
    }
    
    //methods
    public String getName()
    {
      return item;
    }
    public int getPrice()
    {
        if(item.equalsIgnoreCase("Burger"))
        {
            return 5;
        }
        else if (item.equalsIgnoreCase("Fries"))
        {
            return 3;
        }
        else if (item.equalsIgnoreCase("Soda"))
        {
            return 2;
        }
        else
        {
            return 0;
        }
    }
    
}