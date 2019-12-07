//Author Trey Rustand
package groupProjectPhase1;

import static groupProjectPhase1.dawg.employeeLogin;
import static groupProjectPhase1.dawg.employees;
import static groupProjectPhase1.dawg.guestLogin;
import static groupProjectPhase1.dawg.guests;
import static groupProjectPhase1.dawg.loggedInEmployee;
import static groupProjectPhase1.dawg.loggedInGuest;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
public class loginMenuTestWithCode extends Application {

    public static ArrayList<Guest> guests = new ArrayList<Guest>();
    public static ArrayList<Room> rooms = new ArrayList<Room>();
    public static ArrayList<ValueGuest> valueGuests = new ArrayList<ValueGuest>();
    public static ArrayList<Employee> employees = new ArrayList<Employee>();
    public static ArrayList<Booking> bookings = new ArrayList<Booking>();
    
    public static Guest loggedInGuest = new Guest("0","0","0");
    public static Employee loggedInEmployee = new Employee("0", "0", "0");
@Override
 public void start(Stage primaryStage) {
     RadioButton rb1 = new RadioButton();
     RadioButton rb2 = new RadioButton();
     rb1.setText("Employee");
     rb2.setText("Guest");
     Label username = new Label("Username");
     Label password = new Label("Password");
     TextField txt = new TextField();
     TextField txt1 = new TextField();
     Button emp  = new Button("Employee");
     Button guest = new Button("Guest");
     Button login = new Button("Login ->");
     Button clear = new Button("Clear");
     primaryStage.setTitle("Guest and Employee Login Menu");
    //Toggle radio buttons
    ToggleGroup group = new ToggleGroup();
    rb1.setToggleGroup(group);
    rb1.setSelected(true);
    rb2.setToggleGroup(group);
     
     
        GridPane primaryPane = new GridPane();
        primaryPane.setAlignment(Pos.CENTER);
        
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
      Scene primaryScene = new Scene(primaryPane,650,200);
//      primaryPane.setHgap(20);
//      primaryPane.setVgap(20);
//      
        primaryStage.setScene(primaryScene);
        
        primaryStage.show();
        
        clear.setOnAction(e -> {
          txt.clear(); 
          txt1.clear();
        });
        
        
        //We then retrieve the value using the object name followed by a dot and the getText()
        String usernameCheck = txt.getText();
        String passwordCheck = txt1.getText();
        login.setOnAction(e -> {
            //verify incorrect username/password
            
            //code isn't running correctly in the main app
            if(rb1.isSelected())
            {
               for (int i = 0; i < employees.size(); i++ )
        {
            if (employees.get(i).getUserName().equals(usernameCheck))
            {
                loggedInEmployee = employees.get(i);
                employeeLogin(employees.get(i), usernameCheck, passwordCheck);
            }
      System.out.print("Employee Exists!");
        }
       
        
            }
            else
                System.out.println("Employee doesn't exist!");
            
            if(rb2.isSelected())
            {
             for (int i = 0; i < guests.size(); i++ )
        {
            if (guests.get(i).getUsername().equals(usernameCheck))
            {
                loggedInGuest = guests.get(i);
                guestLogin(guests.get(i), usernameCheck, passwordCheck);
            }
       System.out.println("Guest Exists!");
        } 
          
          
            }
           
        });
        
        //need to set action to go into guest or employee menu after checking credentials
        //password check / username check
        //if incorrect send message, if correct "logging in "username . . . " 
 }
 
 
    public static void main(String[] args) {
Application.launch(args);
    }
    
}
