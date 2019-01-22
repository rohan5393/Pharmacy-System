/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

/**
 *
 * @author harlit
 */
public class phaStock

{
    private int medicineID;
    private String name;
    private int quantity;
    private int price;
    
    
    
    public phaStock (int xmedicineID, String xmName, int xquantity,int xprice)
{
    this.medicineID = xmedicineID;
    this.name = xmName;
    this.quantity = xquantity;
    this.price = xprice;
    
    
}

public int getMId()
        {
            return medicineID;
        }

public String getMName()
        {
            return name;
        }

public int getQuantity()
        {
            return quantity;
        }

public int getPrice()
        {
            return price;
        }  
    
    
    
}
