// Author: Trey Rustand
package groupProjectPhase1;

import static groupProjectPhase1.dawg.guests;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
public class guestMenuTestWithCode extends Application {
 
 //cols then rows
 public static ArrayList<Guest> guests = new ArrayList<Guest>();
 public static String nameChangedTo;
 Guest ricky  = new Guest("Guest12","password","guestName");
  @Override 
 public void start(Stage primaryStage){

  // three radio buttons
 // Edit information / See Bookings / Book Rooms
 RadioButton rb1 = new RadioButton("Edit Information");
 RadioButton rb2 = new RadioButton("See Bookings");
 RadioButton rb3 = new RadioButton("Book a Room");
 RadioButton rb4 = new RadioButton("Current Booking");
 
 
 //button for logout
 
 Button logout = new Button("Logout");
 
 //set Grid Pane  and Tab Pane
 
     GridPane primaryPane = new GridPane();
     primaryPane.setAlignment(Pos.TOP_LEFT);
     TabPane tabs = new TabPane();
     //grid panes to hold my specific tab content for each one 
     GridPane tabHome1 = new GridPane();
     GridPane tabEditInfo1 = new GridPane();
     GridPane seeBookings1 = new GridPane();
     GridPane currentBooking1 = new GridPane();
     GridPane bookRooms1 = new GridPane();
     
         //Tabs - 4
 //Home / edit info / See Bookings / Book Rooms 
 //TabPane tabs = new TabPane();
    Tab tabHome = new Tab("Home");
    Tab tabEditInfo = new Tab("Edit Information");
    Tab seeBookings = new Tab("Booking History");
    Tab currentBookings = new Tab("Current Booking");
    Tab bookRooms = new Tab("Book Rooms");
 
        
        
        tabs.getTabs().add(tabHome);
        tabHome.setClosable(false);
        tabs.getTabs().add(tabEditInfo);
        tabEditInfo.setClosable(false);
        tabs.getTabs().add(seeBookings);
        seeBookings.setClosable(false);
        tabs.getTabs().add(currentBookings);
        currentBookings.setClosable(false);
        tabs.getTabs().add(bookRooms);
        bookRooms.setClosable(false);
        //tabs.getTabs().add(tabName);
        
        //label for home page
        Label homeLabel = new Label("GUEST MENU HOME PAGE");
        Button goBtn = new Button("GO");
        
     SingleSelectionModel<Tab> selectionModel = tabs.getSelectionModel();
        goBtn.setOnAction(e ->  {
     if(rb1.isSelected())
         //take me to that tab
        selectionModel.select(tabEditInfo);
     if(rb2.isSelected())
         //take me to that tab
         selectionModel.select(seeBookings);
     if(rb3.isSelected())
         //take me to that tab
         selectionModel.select(bookRooms);
     if(rb4.isSelected())
         selectionModel.select(currentBookings);
         
            
        });
        
        //set content for home tab
        tabHome.setContent(tabHome1);
        //SET ALIGNMENT
        tabHome1.setAlignment(Pos.CENTER);
        //now add to it
        //initially have rb  unselected so user has to make choice
       
        tabHome1.add(homeLabel,0,0);
         //add homepage label
        tabHome1.add(rb1,0,1);
        //rb1.setSelected(false);
        tabHome1.add(rb2,0,2);
        //rb2.setSelected(false);
        tabHome1.add(rb4,0,3);
        
        tabHome1.add(rb3,0,4);
        //rb3.setSelected(false);
        tabHome1.add(goBtn,0,5);
        //go button to proceed
        tabHome1.add(logout, 0, 7);
        //logout button
       
        tabHome1.setVgap(50);
        //VERTICAL GAP
        tabHome1.setHgap(50);
        //HORIZONTAL GAP
        
        
       
  //Inform user they can only do one at a time (place a note on the page for this toggle group)
   ToggleGroup group = new ToggleGroup();
    rb1.setToggleGroup(group);
    rb1.setSelected(true);
    rb2.setToggleGroup(group);
    rb3.setToggleGroup(group);
    rb4.setToggleGroup(group);
    
    
        
        //HOME TAB RB
        //tabEditInfo - the TabPane holding the gridpane of editInfo1
        tabEditInfo.setContent(tabEditInfo1);
        tabEditInfo1.setAlignment(Pos.CENTER);
        
       //Label for enter  your current name box
       //txt for it
       //Label for enter new name
       //txt for it
       //Button for Chaning info - on action - "Your info is updated!"
       Label currentName = new Label("Enter your current name:");
       TextField curName = new TextField();
       Label newName = new Label("Enter New Name: ");
       TextField newName1 = new TextField();
       Button changeInfo = new Button("Change Information");
       Label editInfoLable = new Label("Please Edit Your Guest Information");
       Button backToHome = new Button("Home");
       //add label
       tabEditInfo1.add(editInfoLable,0,0);
       tabEditInfo1.add(currentName, 0, 6);
       tabEditInfo1.add(curName,1,6);
       tabEditInfo1.add(newName,0,10);
       tabEditInfo1.add(newName1,1,10);
       tabEditInfo1.add(changeInfo, 0 , 20);
       tabEditInfo1.add(backToHome,1,20);
       
       tabEditInfo1.setVgap(5);
       tabEditInfo1.setHgap(10);
       
       //vars to gather info from textfield
       
       String nameToChange = curName.getText();
       String nameChangedTo = newName1.getText();
       
       changeInfo.setOnAction(e-> {
     // change button to say information has been changed 
    // Guest.setGuestName(nameChangedTo);
    
     ricky.setGuestName(nameChangedTo);
    
     changeInfo.setText("Information Has Been Changed");
     System.out.println("Print out");
     System.out.print(ricky.getGuestName());
             
     });
     // home button takes  you to home screen
     
     backToHome.setOnAction(e -> {
         selectionModel.select(tabHome);
     });
       
       //AREA LEFT FOR DISPLAYING THE BOOKINGS WINDOW HAVEN'T THOUGHT THAT THROUGH YET 
       seeBookings.setContent(seeBookings1);
       seeBookings1.setAlignment(Pos.CENTER);
       
       //NEED ROOM #
       //GUEST


       Label bookingHistory = new Label("Please View Your Booking History Below: ");
       TextArea bookingHistorySpace = new TextArea("Place all the information from the book room here . .");
       //("Place all the information from the book room here -"
              // + "going to need room number, room ammentities from the selection, date checking in and out as well");
       Button backToHome2 = new Button("Home");
       
       seeBookings1.add(bookingHistory,0,5);
       seeBookings1.add(bookingHistorySpace,0,10);
       seeBookings1.add(backToHome2,0,12);//change location
       //If calendar doesn't serve a purpose keep it for looks
       
       seeBookings1.setVgap(5);
       seeBookings1.setHgap(5);
       backToHome2.setOnAction(e -> {
         selectionModel.select(tabHome);
     });
       
       currentBookings.setContent(currentBooking1);
       currentBooking1.setAlignment(Pos.CENTER_LEFT);
       
       Button backToHome3 = new Button("Home");
       Label activeBooking = new Label("This is your Current Booking");
       TextArea activeBookingSpace = new TextArea();
       activeBookingSpace.setPrefHeight(900);
       activeBookingSpace.setPrefWidth(300);
       //Prompt text
         activeBookingSpace.setPromptText("You have no current booking events. . ."+"\n"+
               "You can add room service items to your bill by selecting them then hitting \"add");
      
       Label roomService = new Label("Room Service Menu");
       final ComboBox roomServiceCombo = new ComboBox();
       roomServiceCombo.getItems().addAll("Candy Bar $5.67","Water Bottle $3.50",
               "Champagne $150.32","Steak Dinner $37.43","Champagne, Steak and Roses $250.55","option","option","option"
       ,"option","option","option","option");
       Button add = new Button("Add");
       Button remove = new Button("Remove");
       //don't want typing in the area
       activeBookingSpace.setEditable(false);

       
       //very bottom 
       currentBooking1.add(backToHome3,1,5);
       //very top
       currentBooking1.add(activeBooking,0,0);
       //right below label
       currentBooking1.add(activeBookingSpace,2,2);
       //right of main label and right above combo box
       currentBooking1.add(roomService,1,0);
       //right below the menu label
       currentBooking1.add(roomServiceCombo,0,1);
       //below menu itself
       currentBooking1.add(add,0,3);
       //next to add
       currentBooking1.add(remove,1,3);
       
      currentBooking1.setVgap(20);
       currentBooking1.setHgap(20);
       
       add.setOnAction(e -> {
          //send combo box item to the textarea 
          String s = (String) roomServiceCombo.getValue();
          activeBookingSpace.appendText(s);
          
          
       });
               
        remove.setOnAction(e -> {
            //select an item on the list to remove and ask are you sure
            activeBookingSpace.clear();
        });      
       
       
       
       //all labels, buttons, etc, need a home button
       //room service menu for adding prices
       //etc
       backToHome3.setOnAction(e -> {
         selectionModel.select(tabHome);
     });
       
       
       bookRooms.setContent(bookRooms1);
        bookRooms1.setAlignment(Pos.CENTER);
        
        //place hbox here with two date pickers
        DatePicker date = new DatePicker();
        DatePicker date1 = new DatePicker();
        HBox checkInCal = new HBox(date);
        HBox checkOutCal = new HBox(date1);
        Label availableRoom = new Label("Please select an available room to book below:");
        TextArea freeRoom = new TextArea();
       Label checkInDate = new Label("Check In Date:");
       Label checkOutDate = new Label("Check Out Date:");
       TextField dateCheckedIn = new TextField();
       TextField dateCheckedOut = new TextField();
       Button bookRoomBtn = new Button("Book Room");
       Label roomSelected = new Label("You have selected this room: ");
       TextField roomShoppingCart = new TextField("Place room selection here");
       Button backToHome1 = new Button("Home");
     //MAKE THIS PRETTIER  
     freeRoom.setEditable(false);
       
        
       //Label "title"
       bookRooms1.add(availableRoom,0,0);
       //text area of rooms that can be selected
       bookRooms1.add(freeRoom,0,1);
       //label for room that has been selected
       bookRooms1.add(roomSelected,0,2);
       //textfield for selected room to be placed
       bookRooms1.add(roomShoppingCart,0,3);
       //Label for check in date
       bookRooms1.add(checkInDate,0,4);
       //area for check in date to be placed
        bookRooms1.add(checkInCal,0,5);
       //bookRooms1.add(dateCheckedIn,1,2);
       //check out date label
       bookRooms1.add(checkOutDate,0,6);
       //area for check out date to be placed
       bookRooms1.add(checkOutCal,0,7);
       //calendar to check out with (two or one what is better?)
       //bookroom button
       bookRooms1.add(bookRoomBtn,0,8);
       //home button
       bookRooms1.add(backToHome1,1,8);  //change location
       //vertical gap
       bookRooms1.setVgap(10);
       //horizontal gap 
       bookRooms1.setHgap(10);
        //please let them know to make a selections, words or something a title of some sort to prompt them
        backToHome1.setOnAction(e -> {
         selectionModel.select(tabHome);
     });
        
//set scene with  primaryPane in it

Scene primaryScene = new Scene(tabs,800,600);
primaryStage.setScene(primaryScene);
primaryStage.show();


     
 }


    public static void main(String[] args) {
Application.launch(args);
  guests.add(new Guest("Guest1", "password", "GuestName"));
  
    }
 //public void start2(Stage secondary){
 
    
}


