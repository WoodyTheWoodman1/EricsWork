
package groupProjectPhase1;

import java.util.*; 

public class Room {
    
public int bedOption;
public int kitchenOption;
public int coffeeOption;
public int accessibleOption;
public int roomNumber;
private static int roomID;
private int roomBookQuantity;
public boolean roomBooked; //private in instructions
public double roomCostPerNight;
public static int nextID = 0;
public static String description;
public boolean roomActive;



public Room() 
{

    this.bedOption = 0;
    this.kitchenOption = 0;
    this.coffeeOption = 0;
    this.accessibleOption = 0;
    this.roomNumber = 0;
    this.roomID = nextID++;
    this.roomBookQuantity++; // double check this
    this.roomBooked = false;
    this.roomCostPerNight = 0;

}

// Full Constructor
public Room(int bed, int kitch, int coffee, int accessibility, int roomNum)
{
    this.bedOption = bed;
    this.kitchenOption = kitch;
    this.coffeeOption = coffee;
    this.accessibleOption = accessibility;
    this.roomNumber = roomNum;
    this.roomID = nextID++;
    this.roomBookQuantity++; //?
    this.roomBooked = false;
    this.roomCostPerNight = 100; //Way to implement different pricing 
    this.roomActive = true;
    
}

public boolean bookedRoom()
{
    if (this.roomBooked == false)
    {
        return false;
    }
    else if (this.roomBooked == true)
    {
        return true;
    }
        
    return false;  
}

public void freeThisRoom()
{
    this.roomBooked = false; 
    this.roomBookQuantity++;
}

public int getRoomBookedQuantity()
{
    return this.roomBookQuantity;
}

public int getRoomID()
{
    return this.roomID; 
}

public int getRoomNumber()
{
    return this.roomNumber;
}
  
public String roomAnalytics()
{
   String answer = "";
   
   answer += ("Room Number: " + this.roomNumber + " \n Number of Bookings: " +
           this.roomBookQuantity + "\n Room Booked?: " + this.roomBooked);
   
   return answer;
}

public String roomDescription()
{
   String description = "";
   String bedOpt = "";
   String kitchenOpt = "";
   String coffeeOpt = "";
   String accessibility = "";
   
   switch (this.bedOption)
   {
       case 1: bedOpt = "1 Queen Bed";
       break;
       case 2: bedOpt = "2 Queen Bed";
       break;
       case 3: bedOpt = "31 King Bed";
               
   }
   
   switch (this.kitchenOption)
   {
       case 1: kitchenOpt = "Microwave";
       break;
       case 2: kitchenOpt = "Fridge + Microwave";
       break;
               
   }
   
   switch (this.coffeeOption)
   {
       case 1: coffeeOpt = "1-Cup Std. Coffee Machine";
       break;
       case 2: coffeeOpt = "Keurig Hot K200 Machine";
       break;
}
switch (this.accessibleOption)
   {
       case 1: accessibility = "Standard Room";
       break;
       case 2: accessibility  = "Enhanced Accessibility Room";
       break;
}

description += "Room Number" + this.roomNumber + "\n Bed Type" + this.bedOption + "\n Kitchen Type:" + this.kitchenOption + 
        "\n Coffee Machine: " + this.coffeeOption + "Accessibility Options: " + this.accessibleOption + 
        "Room booked?:" + this.roomBooked;

 return description;
}


public void setRoomNumber(int roomNumber)
{
    this.roomNumber = roomNumber;

}



}

