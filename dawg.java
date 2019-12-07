    
package groupProjectPhase1;
import java.io.*;
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  
import javafx.stage.Stage;  
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.lang.Object;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import groupProjectPhase1.Booking;
import groupProjectPhase1.Employee;
import groupProjectPhase1.Guest;
import groupProjectPhase1.Room;
import groupProjectPhase1.ValueGuest;
import java.util.*;

public class dawg {
    
    // ArrayLists for class objects
    public static ArrayList<Guest> guests = new ArrayList<Guest>();
    public static ArrayList<Room> rooms = new ArrayList<Room>();
    public static ArrayList<ValueGuest> valueGuests = new ArrayList<ValueGuest>();
    public static ArrayList<Employee> employees = new ArrayList<Employee>();
    public static ArrayList<Booking> bookings = new ArrayList<Booking>();
    
    public static Guest loggedInGuest = new Guest("0","0","0");
    public static Employee loggedInEmployee = new Employee("0", "0", "0");
    
 
// MAIN APPLICATION
public static void main(String[] args) {

   
    // Example instance objects
    employees.add(new Employee("Emp1", "password", "GuestName"));
    employees.add(new Employee("2", "2", "2"));
    employees.add(new Employee("3", "3", "3"));

    guests.add(new Guest("Guest1", "password", "GuestName"));
    guests.add(new Guest("2", "2", "2"));
    guests.add(new Guest("3", "3", "3"));

    rooms.add(new Room(1,1,1,1,101));
    rooms.add(new Room(2,2,2,2,102));
    rooms.add(new Room(3,3,3,3,103));

    initialMenu();

}

public static void initialMenu() // DONE - SYSTEM
{
    Scanner input = new Scanner(System.in);

    //Initial menu
    System.out.println("Welcome to Hotel Madison! Are you a Guest or Employee?");
    System.out.println("1. Guest");
    System.out.println("2. Employee");
    System.out.print("Enter Choice: ");
    int choice = input.nextInt();

    // Switching on choice
    switch(choice)
    {
        case 1: checkGuests(); 
                break;
        case 2: checkEmployees();
                break;
        default: System.out.println("Invalid choice. Please try again.");
                 initialMenu();
                 break;
    }
}

public static boolean checkGuestUserNameAvailability(String incominguserName) // DONE - SYSTEM
{
    // Checking if usernames are available
    return guests.stream().noneMatch((g) -> (g.getUsername().equals(incominguserName)));
    
}

public static boolean checkValueGuestUserNameAvailability(String incominguserName) // DONE - SYSTEM
{
    // Checking if usernames are available
    return valueGuests.stream().noneMatch((g) -> (g.getUsername().equals(incominguserName)));
    
}

public static boolean checkEmployeeUserNameAvailability(String incominguserName) // DONE - SYSTEM
{
    // Checking if usernames are available
    return employees.stream().noneMatch((g) -> (g.getUserName().equals(incominguserName)));
    
}
   
public static void addGuestAccount() // DONE - EMPLOYEE
{
        // Ask if adding ValueGuest
        Scanner in = new Scanner(System.in);
        
        
        // Getting data for new guest account
        System.out.print("Please enter guest's full name: "); 
        String incomingName = in.nextLine();        
        
        System.out.print("Please enter new guest username: "); 
        String incominguserName = in.nextLine();
        
        // Check if username is available
        boolean check = checkGuestUserNameAvailability(incominguserName);
        
        if (check == false)
        {
            System.out.println("Username is alread taken. Please try again.");
            addGuestAccount();  
        }
        else
        {
            System.out.print("Please enter password for the guest: "); 
            String incomingPassword = in.nextLine(); 

            guests.add(new Guest(incominguserName, incomingPassword, incomingName));
            System.out.print("Guest account successfully added!");
        }
}


public static void addValueGuestAcct() // DONE - EMPLOYEE
{
        Scanner in = new Scanner(System.in); 
        
        // Getting data for new guest account
        System.out.print("Please enter guest's full name: "); 
        String incomingName = in.nextLine();        
        
        System.out.print("Please enter new guest username: "); 
        String incominguserName = in.nextLine();

        // Check if username is available
        boolean check = checkGuestUserNameAvailability(incominguserName);
        boolean check2 = checkValueGuestUserNameAvailability(incominguserName);
        
        if (check == false || check2 == false)
        {
            System.out.println("Username is alread taken. Please try again.");
            addValueGuestAcct();  
        }
        else
        {
            System.out.print("Please enter password for the guest: "); 
            String incomingPassword = in.nextLine(); 

            valueGuests.add(new ValueGuest(incominguserName, incomingPassword, incomingName));
            System.out.print("Guest account successfully added!");
        }
         
}


public static void addEmployeeAccount() // DONE - EMPLOYEE
{
  
        Scanner in = new Scanner(System.in);

        // Getting data for new employee account
        System.out.print("Please enter employees's full name: "); 
        String incomingName = in.nextLine();        
        
        System.out.print("Please enter new employee username: "); 
        String incominguserName = in.nextLine();
        
        // Check if username is available
        boolean check = checkEmployeeUserNameAvailability(incominguserName);
        
        if (check == false)
        {
            System.out.println("Username is alread taken. Please try again.");
            addEmployeeAccount();  
        }
        else
        {
            System.out.print("Please enter password for the employee: "); 
            String incomingPassword = in.nextLine(); 

            employees.add(new Employee(incominguserName, incomingPassword, incomingName));
            System.out.print("Employee account successfully added!");
        }
}
             
public static void roomReportAsk() // DONE - EMPLOYEE
{
    Scanner input = new Scanner(System.in);
    System.out.println("Options: ");
    System.out.println("1.) Display All Rooms");
    System.out.println("2.) Display One Room");
    int choice = input.nextInt();
    
    switch(choice)
    {
        // Display all rooms
        case 1: for (int i = 0; i < rooms.size(); i++)
                {
                    System.out.println(rooms.get(i).roomDescription());
                }
                break;
        
        // Display one room based on user choice       
        case 2: System.out.print("Choose a room to display (room number): ");
                int displayChoice = input.nextInt();
                Room roomToDisplay = new Room();
                
                // Search if room exists
                for (int i = 0; i < rooms.size(); i++)
                {
                    if (rooms.get(i).getRoomNumber() == displayChoice)
                    {
                        roomToDisplay = rooms.get(i);
                        System.out.println();
                        break;
                    } 
                    System.out.println("Room does not exist. Please try again.");
                    roomReportAsk();
                }
                
                System.out.print(roomToDisplay.roomDescription());
           
    }
 
}
   

public static void checkOutGuest() // DONE - EMPLOYEE
{ 
    Scanner input = new Scanner(System.in);

    // Getting which customer and room to check out
    System.out.print("Please enter guest to check out (username): ");
    String checkOut = input.nextLine();
    
    System.out.print("Please enter room number of booking: ");
    int checkOutRoom = input.nextInt();
    
    
    // Searching for booking and freeing up room
    for (int i = 0; i < bookings.size(); i++)
    {
        if (bookings.get(i).bookingGuest.getUsername().equals(checkOut) && 
                bookings.get(i).bookedRoom.roomNumber == checkOutRoom)
        {
            bookings.get(i).endBooking();
            bookings.remove(i);
            System.out.print("Guest Checked Out Successfully!");
            break;
        }
        System.out.println("Guest or room not found. Please try again.");
        checkOutGuest();
    }
    

}

public static void createRoom() //DONE - EMPLOYEE
{
    Scanner input = new Scanner(System.in);
    
    
    System.out.println("1: 1 Queen Bed " + "\n"
            + "2: 2 Queen Beds" + "\n" +
            "3: 1 King Bed");
    System.out.print("Please enter bed option: ");
    int bedOpt = input.nextInt();
        
        
    switch(bedOpt){
       case 1:  System.out.println("1 Queen Bed");
       break;
       case 2: System.out.println("2 Queen Beds"); 
       break;
       case 3: System.out.println("1 King bed");
       break;
    }
    
    //gather kitchen info to create a new room
    
    System.out.println("1: Microwave " + "\n"
                + "2: Fridge + Microwave");
    System.out.print("Please enter kitchen option:  ");
    int kitchenOpt = input.nextInt();

    switch(kitchenOpt){
       case 1: System.out.println("Microwave");
                break;
       case 2: System.out.println("Fridge + Microwave"); 
                break;
    }


    //coffee option info 

    System.out.println("1: 1-Cup Std, Coffee Machine"  + "\n"+
            "2: Keurig Hot K200 Machine");
    System.out.print("Please enter coffee option: ");
    int coffeeOpt = input.nextInt();

    switch(coffeeOpt){
            case 1: System.out.println("1-Cup Std. Coffee Machine");
                    break;
           case 2: System.out.println("Keurig Hot K200 Machine");
                    break;
    }



    //accessible option info 

        System.out.println("1: Standard Room"+ "\n" +
            "2: Enhanced Accessibility Room "
            );
        System.out.print("Please enter accessibility option: ");
        int accessibleOpt = input.nextInt();


        switch(accessibleOpt){
            case 1: System.out.println("Standard Room");
                break;
            case 2: System.out.println("Enhanced Accessibility Room");
                break;
    }

    System.out.println("Enter room number: ");
    int roomNumber = input.nextInt();
    
    // Error checking to see if room number already exists
    for (int i = 0; i < rooms.size(); i++)
    {
        if (rooms.get(i).getRoomNumber() == roomNumber)
        {
            System.out.println("Room number already exists. Please try again.");
            createRoom();
        }
            
    }

    //Create new room and add to ArrayList
    rooms.add(new Room(bedOpt,kitchenOpt,coffeeOpt,accessibleOpt, roomNumber));
  
}

public static void editRoom() //DONE - EMPLOYEE
{
    Scanner input =  new Scanner(System.in);
    
    Room roomToBeEdited = new Room();
    
    // Getting room to be edited
    System.out.print("Please enter a room to be edited (room number): ");
    int editRoom = input.nextInt();
    
    // Search if room exists
    for (int i = 0; i < rooms.size(); i++)
    {
        if (rooms.get(i).getRoomNumber() == editRoom)
        {
            roomToBeEdited = rooms.get(i);
            System.out.println();
            break;
        } 
        System.out.println("Room does not exist. Please try again.");
        editRoom();
    }
    
    // Displaying options for editing
    System.out.println( "1: Bed Options\n"
            + "2: Kitchen Options\n"
            + "3: Coffee Options\n"
            + "4: Accessibility Options\n"
            + "Please enter which option you would like to edit: ");
    int choice = input.nextInt();
    
    // Switching on edit choice
    switch (choice)
    {
        case 1: System.out.println("Bed Options: ");
                System.out.println("1.) 1 Queen Bed");
                System.out.println("2.) 2 Queen Beds");
                System.out.println("3.) King Bed");
                System.out.println("Enter choice: ");
                int newBed = input.nextInt();
                roomToBeEdited.bedOption = newBed;
                break;
        
        case 2: System.out.println("Kitchen Options: ");
                System.out.println("1.) Microwave");
                System.out.println("2.) Fridge + Microwave");
                System.out.println("Enter choice: ");
                int newKitchen = input.nextInt();
                roomToBeEdited.kitchenOption = newKitchen;
                break;
        
        case 3: System.out.println("Coffee Options: ");
                System.out.println("1.) 1-Cup Std. Coffee Machine");
                System.out.println("2.) Keurig Hot K200 Machine");
                System.out.println("Enter choice: ");
                int newCoffee = input.nextInt();
                roomToBeEdited.coffeeOption = newCoffee;
                break;
        
        case 4: System.out.println("Accessiblity Options: ");
                System.out.println("1.) Standard Room");
                System.out.println("2.) Enhanced Accessibility Room");
                System.out.println("Enter choice: ");
                int newAccess = input.nextInt();
                roomToBeEdited.accessibleOption = newAccess;
                break;
        
        default: System.out.println("Invalid Option. Please try again.");
                 editRoom();
                 break;
                
    }

}

public static void makeRoomInactive() // DONE - EMPLOYEE
{
    //Getting room number to make inactive
    Scanner input =  new Scanner(System.in);
    Room roomToBeDeactivated = new Room();
    
    // Getting room to be edited
    System.out.print("Please enter a room to be deactivated (room number): ");
    int deactivateRoom = input.nextInt();
    
    // Search if room exists
    for (int i = 0; i < rooms.size(); i++)
    {
        if (rooms.get(i).getRoomNumber() == deactivateRoom)
        {
            roomToBeDeactivated = rooms.get(i);
            System.out.println();
            break;
        } 
        System.out.println("Room does not exist. Please try again.");
        makeRoomInactive();
    }
    
    //Deactivating room if found
    roomToBeDeactivated.roomActive = false;
    System.out.println("Room Deactivated.");

}    

public static void bookRoom() // DONE - GUEST
    {
        Scanner input = new Scanner (System.in);
        
        ArrayList<Room> available = new ArrayList<Room>();
        Room roomToBook = new Room();

        // Printing out available rooms
        System.out.println("Available Rooms:");

        for (int i = 0; i < rooms.size(); i++)
        {
            if (rooms.get(i).roomActive == true && rooms.get(i).bookedRoom() == false)
            {
                System.out.println(rooms.get(i).roomDescription());
                available.add(rooms.get(i));
            }  
        }
        
        //Customer chooses room 
        System.out.print("Which room would you like (enter room number): ");
        int roomChoice = input.nextInt();
        
        // Checking if their choice is available
        for (int i = 0; i < available.size(); i++)
        {
            if (available.get(i).roomNumber == roomChoice)
            {
                roomToBook = available.get(i);
                break;
            }
            
            System.out.print("Room not available. Please try again.");
            bookRoom();
        }
        
        // Create booking based on user data
        bookings.add(new Booking(loggedInGuest, roomToBook, 1,1,1));
        roomToBook.roomBooked = true;
        System.out.println("Room successfully booked! Thank you!");
   
    }

public static void guestReport() // DONE - GUEST       
    {
        //Printing report of bookings
        
        System.out.println("-------------Your Bookings----------\n");
        
        for (int i = 0; i < bookings.size(); i++)
        {
            if (bookings.get(i).bookingGuest.getUsername().equals(loggedInGuest.getUsername()))
            {
                // This will be different with UI utilization
                System.out.println(bookings.get(i).bookedRoom.roomDescription());
            }
        }
    }

public static void editGuestName(String currentName, String newName) // DONE - GUEST & EMPLOYEE
   {
        //Scanner input =  new Scanner(System.in);
    
        // Getting guest to be edited
//        System.out.print("Please re-enter username: ");
//       String editName = input.nextLine();

        //System.out.print("Please enter new name: ");
         //String guestNewName = input.nextLine();

        for (int i = 0; i < guests.size(); i++)
        {
            if (guests.get(i).getUsername().equals(currentName))
            {
                guests.get(i).setGuestName(newName);
                System.out.print("Name changed successfully!");
                break;
            }
            // Part below will be an alert in UI code
//            System.out.println("Username not found. Please try again.");
//            editGuestName(currentName,newName);

        }
        
   }

public static void setNewGuestPassword() // DONE - GUEST
    {
        Scanner input =  new Scanner(System.in);
       
        // Getting old and new passwords
        System.out.print("Please enter old password: ");
        String guestOldPW = input.nextLine();

        System.out.print("Please enter new password: ");
        String guestNewPW = input.nextLine();
        
        int check = loggedInGuest.passwordCriteria(guestOldPW, guestNewPW);
        
        switch (check)
        {
            case 0: System.out.println("Old password is incorrect. Please try again.");
                    setNewGuestPassword();
            case 1: System.out.println("Old password and new password are the same. Please try again.");
                    setNewGuestPassword();
            case 2: System.out.println("New password can not start with a number. Please try again.");
                    setNewGuestPassword();
            case 3: System.out.println("New password requires at least one number and "
                    + "one upper case letter. Please try again.");
                    setNewGuestPassword();
            case 4: loggedInGuest.setPassword(guestNewPW);
                    System.out.println("Password changed successfully!");
        }

    }
               
public static void setNewEmployeePassword() // DONE - EMPLOYEE
    {
        Scanner input =  new Scanner(System.in);
       
        // Getting old and new passwords
        System.out.print("Please enter old password: ");
        String employeeOldPW = input.nextLine();

        System.out.print("Please enter new password: ");
        String employeeNewPW = input.nextLine();
        
        int check = loggedInEmployee.passwordCriteria(employeeOldPW, employeeNewPW);
        
        switch (check)
        {
            case 0: System.out.println("Old password is incorrect. Please try again.");
                    setNewEmployeePassword();
            case 1: System.out.println("Old password and new password are the same. Please try again.");
                    setNewEmployeePassword();
            case 2: System.out.println("New password can not start with a number. Please try again.");
                    setNewEmployeePassword();
            case 3: System.out.println("New password requires at least one number and "
                    + "one upper case letter. Please try again.");
                    setNewEmployeePassword();
            case 4: loggedInEmployee.setPassword(employeeNewPW);
                    System.out.println("Password changed successfully!");
        }

    }      

public static void orderRoomService()
{
    // 1. Get user and associated booking
    // 2. Ask which room service they want
    // 3. Add that too ArrayList of rs in booking class
    // 4. 
    
    
    
    
}

// ========================== SYSTEM METHODS ==============================

public static void checkEmployees() //DONE - SYSTEM
    {
        // Employee login
        Scanner keyboardIn = new Scanner(System.in);
        System.out.print("Username: ");
        String usernameCheck = keyboardIn.nextLine();
        System.out.println();
        System.out.print("Password: ");
        String passwordCheck = keyboardIn.nextLine();
        
        for (int i = 0; i < employees.size(); i++ )
        {
            if (employees.get(i).getUserName().equals(usernameCheck))
            {
                loggedInEmployee = employees.get(i);
                employeeLogin(employees.get(i), usernameCheck, passwordCheck);
            }
      
        }

    }
      
public static void checkGuests() //DONE - SYSTEM
    {
        // Guest login
        Scanner keyboardIn = new Scanner(System.in);
        System.out.print("Username: ");
        String usernameCheck = keyboardIn.nextLine();
        System.out.println();
        System.out.print("Password: ");
        String passwordCheck = keyboardIn.nextLine();

        for (int i = 0; i < guests.size(); i++ )
        {
            if (guests.get(i).getUsername().equals(usernameCheck))
            {
                loggedInGuest = guests.get(i);
                guestLogin(guests.get(i), usernameCheck, passwordCheck);
            }
      
        } 
    }

public static void employeeLogin(Employee x, String usernameCheck, String passwordCheck) //DONE - SYSTEM
    {

        Scanner keyboardIn = new Scanner(System.in);
        
        //Passing to Employee member method
        boolean check = x.checkCredentials(usernameCheck, passwordCheck);
        
        if (check == true)
        {
            System.out.println();
            System.out.println("Logging in...");
            employeeMenu();
        }
        else
        {
            System.out.println("Invalid Username or Password. Please try again.");
            checkEmployees();
        }
  
    } 
     
public static void guestLogin(Guest y, String usernameCheck, String passwordCheck) //DONE - SYSTEM
    {
        Scanner keyboardIn = new Scanner(System.in);

        //Passing to Guest member method
        boolean check = y.checkCredentials(usernameCheck, passwordCheck);
        
        if (check == true)
        {
            System.out.println();
            System.out.println("Logging in...");
            guestMenu();
        }
        else
        {
            System.out.println("Invalid Username or Password. Please try again.");
            checkGuests();
            
        }
    }
         
public static void employeeMenu() //DONE - SYSTEM
    {
        Scanner in = new Scanner(System.in);
        
        int menuChoice = 0;
        
        System.out.println("Welcome to Hotel Madison");
        do
        {
            System.out.println("\n----------------------");
            System.out.println("1. Run Booking Report");
            System.out.println("2. Check Out Guest");
            System.out.println("3. Create Guest Account");
            System.out.println("4. Edit Guest Account");
            System.out.println("5. Create Employee Account");
            System.out.println("6. Edit Employee Account");
            System.out.println("7. Create, Edit, or Make Room Inactive");
            System.out.println("8. Exit Program");
            System.out.print("Enter Choice: ");
            menuChoice = in.nextInt();
            
            handleEmployeeMenuChoice(menuChoice);
            
        } while (menuChoice != 8);
        
        
    }

public static void handleEmployeeMenuChoice(int menuChoice) // DONE - SYSTEM 
    {
        Scanner in = new Scanner(System.in); 
        // Presenting employee with options for what they want the program to do
        switch (menuChoice)
        {
            case 1: roomReportAsk();
                       break;
            case 2: checkOutGuest();
                       break;
            case 3: System.out.println("Would you like to add a Value Guest?");
                    System.out.println("1.) Yes");
                    System.out.println("2.) No");
                    System.out.print("Enter Choice: ");
                    int valueChoice = in.nextInt();

                    switch (valueChoice)
                    {
                        case 1: addValueGuestAcct();
                                break;
                        case 2: addGuestAccount();
                                break;
                        default: System.out.println("Invalid Choice. Please try again.");
                                 employeeMenu();
                                 
                    }
                       break;
            case 4: editGuestName();
                       break;
            case 5: addEmployeeAccount();
                       break;
            case 6: setNewEmployeePassword();
                       break;
            case 7: options();
                       break;
            case 8: System.out.println("Program exiting. . . ");
                    main(null);
                    break;
            default: System.out.println("Invalid menu choice. Please try again.");
                     employeeMenu();
                        
        }      
    }
      
public static void guestMenu() //DONE - SYSTEM
    {
        Scanner in = new Scanner(System.in);
        
        int menuChoice = 0;
        
        System.out.println("Welcome to Hotel Madison");
        do
        {
            System.out.println("\n----------------------");
            System.out.println("1. Book a Room");
            System.out.println("2. See Your Bookings");
            System.out.println("3. Edit Your Name");
            System.out.println("4. Change Your Password");
            System.out.println("5. Log out");
            System.out.print("Enter Choice: ");
            System.out.println();
            menuChoice = in.nextInt();
            
            handleGuestMenuChoice(menuChoice);
            
        } while (menuChoice != 4);

    }
   
public static void handleGuestMenuChoice(int menuChoice) // DONE - SYSTEM
    {
        // Presenting user with options for what they want the program to do
        switch (menuChoice)
        {
            case 1: bookRoom();
                    break;
            case 2: guestReport();
                    break;
            case 3: editGuestName();
                    break;
            case 4: setNewGuestPassword();
                    break;
            case 5: System.out.println("Program exiting . . . ");
                    main(null);
                    break;
            default: System.out.println("Invalid menu choice. Please try again.");
                     // Bringing guest back to menu
                     guestMenu();
                        
        }      
    }
    
public static void options() //DONE - SYSTEM 
         {
             Scanner input = new Scanner (System.in);
             System.out.println("1. Create Room" +
"                    2.Edit Room" + 
"                    3. Make Room Inactive" ); 
             int choice = input.nextInt(); 
             switch (choice)
             {
                 case 1: createRoom(); break;
                 case 2: editRoom(); break; 
                 case 3: makeRoomInactive(); break; //1 parameter String
             }
            
         }

}
