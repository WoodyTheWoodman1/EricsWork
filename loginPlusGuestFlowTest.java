//Author Trey Rustand
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
//won't run with this defined
//import javafx.scene.control.Alert.*;
public class loginPlusGuestFlowTest extends Application {
    
    BackgroundFill myBF = new BackgroundFill(Color.WHITE, new CornerRadii(1),
         new Insets(0.0,0.0,0.0,0.0));
    Stage window;
    Scene scene1,scene2;
    Button logout = new Button("Logout");
    //home
    //go
    //logout
    
    
   // Button Home = new Button("Home"); --> can be a code clean up if need be to modularize
    
    //wont run with this defined
    //Alert a; 
    
    
        public static void main(String[] args) {
Application.launch(args);
    }
        
        
@Override
 public void start(Stage primaryStage) throws Exception {
     
     window = primaryStage;
  
    //LOGIN SCREEN
    //RADIO BUTTONS FOR GUEST/EMP
     RadioButton rb1 = new RadioButton();
     RadioButton rb2 = new RadioButton();
     rb1.setText("Employee");
     rb2.setText("Guest");
     //labels for text fields
     Label username = new Label("Username");
     Label password = new Label("Password");
     //username for text field
     TextField txt = new TextField();
     txt.setPromptText("enter username. . .");
     TextField txt1 = new TextField();
     txt1.setPromptText("Enter password. . . ");
     //password for textfield
     
     Button emp  = new Button("Employee");
     Button guest = new Button("Guest");
     Button login = new Button("Login ->");
     Button clear = new Button("Clear");
     window.setTitle("Guest and Employee Login Menu");
    //Toggle radio buttons
    ToggleGroup group = new ToggleGroup();
    rb1.setToggleGroup(group);
    rb1.setSelected(true);
    rb2.setToggleGroup(group);
    
     
          
         
    
    
    
    
    
  
    
        GridPane primaryPane = new GridPane();
        primaryPane.setAlignment(Pos.CENTER);
//        ImageView iv = new ImageView(new Image(getClass().getResourceAsStream("hotel_madison.jpg")));
//         primaryPane.add(iv,0,0);
        //primaryPane.setBackground(image3);
        
//        myBF = new BackgroundFill(Color.VIOLET, new CornerRadii(1),
//         new Insets(0.0,0.0,0.0,0.0));// or null for the padding
////then you set to your node or container or layout
//primaryPane.setBackground(new Background(myBF));


       
        primaryPane.add(username,0,1);
        primaryPane.add(password,0,2);
        primaryPane.add(txt,1,1);
        primaryPane.add(txt1,1,2);
        primaryPane.add(rb1,1,3);
        primaryPane.add(rb2,2,3);
        primaryPane.add(clear,1,4);
        primaryPane.add(login,2,4);
        primaryPane.setVgap(10);
        primaryPane.setHgap(10);
        //does it matter where v gap and h gap go
      scene1 = new Scene(primaryPane,650,200);
//      primaryPane.setHgap(20);
//      primaryPane.setVgap(20);
//actions specific to that winow that won't change that window
  clear.setOnAction(e -> {
          txt.clear(); 
          txt1.clear();
        });
  
  login.setOnAction(e -> {
      //change this so login takes you to guest if  you are checked on guest
      //employee if employee is checked 
    if(rb2.isSelected())
    {
       //dawg.checkGuests();
      window.setScene(scene2);
    }
    else
     System.out.println("need to add the code that verifies if it is a guest or employee so we can add not an employee as well.");
      
  });
  
  
//      







        window.setScene(scene1);
        window.setTitle("Hotel Madison");
        window.show();
        

        
        
        //need to set action to go into guest or employee menu after checking credentials
        //password check / username check
        //if incorrect send message, if correct "logging in "username . . . " 
        
        
    //set scene on click of login that'll take you the guest or employee user screen 
    
    //GUEST MENU LOGIN 
    

 RadioButton rb100 = new RadioButton("Edit Information");
 RadioButton rb200 = new RadioButton("See Bookings");
 RadioButton rb3 = new RadioButton("Book a Room");
 RadioButton rb4 = new RadioButton("Current Booking");
 
 
 //button for logout
 
 //Button logout = new Button("Logout");
 
 //set Grid Pane  and Tab Pane
 
     GridPane primaryPane2 = new GridPane();
     primaryPane2.setAlignment(Pos.TOP_LEFT);
     TabPane tabs = new TabPane();
     //grid panes to hold my specific tab content for each one 
     GridPane tabHome1 = new GridPane();
     GridPane tabEditInfo1 = new GridPane();
     GridPane seeBookings1 = new GridPane();
     GridPane currentBooking1 = new GridPane();
     GridPane bookRooms1 = new GridPane();
     tabs.setBackground(new Background(myBF));
     
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
        goBtn.setMinSize(250,10);
        logout.setMinSize(250,10);
        
    SingleSelectionModel<Tab> selectionModel = tabs.getSelectionModel();
        goBtn.setOnAction(e ->  {
     if(rb100.isSelected())
         //take me to that tab
        selectionModel.select(tabEditInfo);
     if(rb200.isSelected())
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
        tabHome1.add(rb100,0,1);
        //rb1.setSelected(false);
        tabHome1.add(rb200,0,2);
        //rb2.setSelected(false);
        tabHome1.add(rb4,0,3);
        
        tabHome1.add(rb3,0,4);
        //rb3.setSelected(false);
        
        //go button to proceed
      
        //logout button
        
        VBox goLogout = new VBox(goBtn,logout);
        
        tabHome1.add(goLogout, 0, 6);
       
        tabHome1.setVgap(50);
        //VERTICAL GAP
        tabHome1.setHgap(50);
        //HORIZONTAL GAP
        
      
        
        
       
  //Inform user they can only do one at a time (place a note on the page for this toggle group)
   ToggleGroup group2 = new ToggleGroup();
    rb100.setToggleGroup(group2);
    rb100.setSelected(true);
    rb200.setToggleGroup(group2);
    rb3.setToggleGroup(group2);
    rb4.setToggleGroup(group2);
    
    
        
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
       
       changeInfo.setOnAction(e-> {
     // change button to say information has been changed 
     String currentGuestName = curName.getText();
     String newGuestName = newName1.getText();
     dawg.editGuestName(currentGuestName,newGuestName);
     changeInfo.setText("Information Has Been Changed");
             
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
       TextArea bookingHistorySpace = new TextArea();
       bookingHistorySpace.setEditable(false);
       bookingHistorySpace.setPromptText("You have no booking history. . .");
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
       Label activeBooking = new Label("Current Booking on File");
       TextArea activeBookingSpace = new TextArea();
      // activeBookingSpace.setPadding(new Insets(10,10,10,10);
       activeBookingSpace.setPrefHeight(400);
       activeBookingSpace.setPrefWidth(300);
       MenuBar menu = new MenuBar();
       //Prompt text
         activeBookingSpace.setPromptText("You have no current booking events. . ."+"\n"+
               "You can add room service items to your bill by selecting them then hitting \"add");
      
       Label roomService = new Label("Room Service Menu");
      final ComboBox roomServiceCombo = new ComboBox();
      roomServiceCombo.setPromptText("Please Select an Item");
      //this will be populated with data from the database from an observable array list
       roomServiceCombo.getItems().addAll("Candy Bar $5.67","Water Bottle $3.50",
               "Champagne $150.32","Steak Dinner $37.43","Champagne, Steak and Roses $250.55","option","option","option"
       ,"option","option","option","option");
       
       
       Button add = new Button("Add");
       Button remove = new Button("Remove");
       // add an are you sure you'd like to cancel your booking message?
       Button cancelBooking = new Button("Cancel Booking");
       
       //don't want typing in the area
       activeBookingSpace.setEditable(false);
       HBox addRemoveBox = new HBox(add,remove);
       HBox homeCancelBox = new HBox(backToHome3,cancelBooking);
       
       //very bottom 
     currentBooking1.add(homeCancelBox,4,4);
       //very top
       currentBooking1.add(roomService,0,0);
       //right below label
       currentBooking1.add(activeBookingSpace,2,2);
       //right of main label and right above combo box
       currentBooking1.add(activeBooking,2,0);
       //right below the menu label
       currentBooking1.add(roomServiceCombo,0,1);
       //below menu itself
       currentBooking1.add(addRemoveBox,0,4);
       //next to add
      
       //next to remove item
       
       
      currentBooking1.setVgap(10);
       currentBooking1.setHgap(10);
       
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
       
        HBox bookRoom = new HBox(bookRoomBtn,backToHome);
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
       bookRooms1.add(bookRoom,0,8);
     
        //change location
       //vertical gap
       bookRooms1.setVgap(10);
       //horizontal gap 
       bookRooms1.setHgap(10);
        //please let them know to make a selections, words or something a title of some sort to prompt them
        backToHome1.setOnAction(e -> {
         selectionModel.select(tabHome);
     });
        
        
        //universal logout button
        logout.setOnAction(e -> {
         window.setScene(scene1);
         //need to actually plug in code to end users session
        });
        
        
//set scene with  primaryPane in it

scene2 = new Scene(tabs,800,600);
//window.setScene(scene2);
//window.show();


     
 }
 }
 