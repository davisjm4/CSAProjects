import java.util.*;
import java.io.*;
import java.util.ArrayList;

public abstract class GetOrder
{
    public static ArrayList<Item> getOrders()
    {
        System.out.println("Menu: \nBurger: $5 \nFries: $3 \nSoda = $2\n'clear' to clear all orders");
        ArrayList<Item> wholeOrder = new ArrayList<Item>(); 
        boolean on = true;
        while(on)
        {
            System.out.println("What would you like to order? Type 'Finish' to end order");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            if(input.equals("Finish"))
            {
                on = false;
                return wholeOrder;
            }
            else if(input.equals("clear"))
            {
                GetOrder.clearOrders();
            }
            else
            {
                wholeOrder.add(new Item(input));
            }
        }
        return wholeOrder;
    }

    public static String getOrder()
    {
        try {
          File orders = new File("orders.txt");
          Scanner myReader = new Scanner(orders);
          String currOrders = "";
          while (myReader.hasNextLine()) {
            currOrders = myReader.nextLine();
            System.out.println(currOrders);
          }
          myReader.close();
          return currOrders;
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
        return "orders.txt does not exist";
    }
    
    public static boolean clearOrders()
    {
        try
        {
            System.out.print("Creating new file ... ");
            File fileOut = new File("C:\\Users\\josia\\OneDrive\\Desktop\\BlueJay Projects\\Orders\\Orders.java\\Orders.txt");
            // Write text just like we would to the console
            if(fileOut.createNewFile())
            {
                System.out.println("New blank file created: " + fileOut.getName());
                return true;
            }
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();  
            return false;            
        }
        return true;
    }
    
    
    public static boolean addOrder(ArrayList<Item> wholeOrder)
    {
        try
        {
            String prev = GetOrder.getOrder();
            System.out.print("Writing to file ... ");
            // Create the file to write to
            FileWriter writer = new FileWriter("Orders.txt");                
            for(int i = 0; i < wholeOrder.size(); i++)
            {
                writer.write(prev + wholeOrder.get(i).getName() + "," + wholeOrder.get(i).getPrice() + ", ");
            }
            Order order = new Order(wholeOrder);
            writer.write("\nOrder total: " + order.getTotal());
            // Clode out file
            writer.close(); 
            System.out.println("Done!");
            return true;
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();  
            return false;
        }     
    }
    
    public static boolean readOrder(File file)
    {
        try
        {
        // Read in file to verify it
            Scanner fileIn = new Scanner(new File("Orders.txt"));
           
            System.out.println("Reading from file ... ");
            while (fileIn.hasNext())
            {
                String lineIn = fileIn.nextLine();
                System.out.println(lineIn);
            }
            System.out.println("Done!");
            return true;
        }
        catch (IOException e) 
        {
            System.out.println("File not found");
            return false;
        }
    }
}  