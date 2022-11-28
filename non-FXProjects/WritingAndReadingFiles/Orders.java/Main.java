import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args)
    {
        Order firstOrder = new Order(GetOrder.getOrders());
        GetOrder.addOrder(firstOrder.getOrderList());
        System.out.println("Your order total is: " + firstOrder.getTotal());
        
    }
    
}