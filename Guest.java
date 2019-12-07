//Trey Rustand making Guest Class
package groupProjectPhase1;


public class Guest {
 private int guestID;
// need to call super in sub
 private String username;
 private String password;
 private String guestName;
 
 public static int nextID = 100;
 

 public Guest(String username, String password, String guestName)
 {
    //initialize all vars
    this.username =  username;
    this.password =  password;
    this.guestName = guestName;
    this.guestID = nextID++;
    
 }
 
 public boolean checkCredentials(String username, String password)
 {
    if (username.equals(this.username) && password.equals(this.password))
        {
            return true;
        }
    else
        {
            return false;
        }
  
 }
 
 
 public String getGuestName()
 {
     
return this.guestName;
 }
 
 public String getUsername()
 {
     return this.username;
 }
 
 public void setGuestName(String guestName)
 {
     this.guestName = guestName;
 }
 public void setPassword(String newP)
 {
   this.password = newP;
 }
 
 public int passwordCriteria(String oldPassword, String newPassword)
    {
        
        // Check if old password is correct
        if (oldPassword.equals(this.password) == false)
        {
            return 0;
        }
        
        // Check if new password is not old password
        if (oldPassword.equals(newPassword))
        {
            return 1;
        }
        
        // Check if new password doesn't start with a number
        char c = newPassword.charAt(0);
        if (c >= '0' && c <= '9')
        {
            return 2;
        }
        
        // Check if new password has at least one number and capital letter
        char ch;
        boolean capitalFlag = false;
        boolean numberFlag = false;
        for(int i=0;i < newPassword.length();i++) {
            ch = newPassword.charAt(i);
            if(Character.isDigit(ch)) {
                numberFlag = true;
            }
            else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } 
            if(numberFlag == false && capitalFlag == false)
                return 3;
        }
        return 4;
    }
 
 
 
 
 
}


