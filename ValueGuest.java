//Trey Rustand ValueGuest
package groupProjectPhase1;

import java.util.ArrayList;

public class ValueGuest extends Guest {
 //data fields
 private String valueClubID;
 public static int numberOfBookings;
 private double amountSpentWithHotel;
 public static int nextID = 100;
 public static int valueGuestID;
 
 
 // ValueGuest Constructor
 public ValueGuest(String username, String password, String guestName)
 {
    // call super class
    super(username,password,guestName);
    this.valueClubID = " "; //?
    this.numberOfBookings = 0;
    this.amountSpentWithHotel = 0.0;
    this.valueGuestID = nextID++;
        
 }
 
 public double getAmountSpentWithHotel()
 {
  
     return this.amountSpentWithHotel;
 }
 public int getNumberOfBookings()
 {
  
     return this.numberOfBookings;
 }
 public String getvaleuClubID()
 {
     return this.valueClubID;
 }
 
}
