
//TRAN
package groupProjectPhase1;


import java.util.*;


public class Booking  {
    Room bookedRoom;
    Guest bookingGuest; 
    private int bookingYear; 
    private int checkInDay;
    private int checkOutDay; 
    public int nextID;  
    public int IndexPosition;
    
    public ArrayList<RoomService> roomServices = new ArrayList<RoomService>();
    

    //argument constructor 
    public Booking() {
        
        this.bookingYear = 0; 
        this.checkInDay = 0; 
        this.checkOutDay = 0; 
        this.nextID = 0;  
        this.IndexPosition = 0; 
    }
    
    //full constructor 
    public Booking (Guest bookingGuest, Room bookedRoom, int year, int checkIn, int checkOut)
    {
       this.bookingGuest = bookingGuest;
       this.bookedRoom = bookedRoom; 
       this.bookingYear = year;
       this.checkInDay = checkIn;
       this.checkOutDay = checkOut; 
    
    }
    
    //Close out the booking
    public void endBooking() 
    {
        this.bookedRoom.roomBooked = false;
    }
   
  
    
    
}
