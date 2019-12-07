
package groupProjectPhase1;


public class Employee {
    
    private int employeeID;
    private String username;
    private String password;
    private String employeeName;
    
    public static int nextID = 10;
    

    // Employee Constructor
    public Employee(String username, String password, String employeeName)
    {
        this.username = username;
        this.password = password;
        this.employeeName = employeeName;
        this.employeeID = nextID++;
        
    }
            
    // Checking employee credentials
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
    
    //Employee name getter
    public String getEmployeeName()
    {
        return this.employeeName;
    }
    
    // Username getter
    public String getUserName()
    {
        return this.username;
    }
    
    // Employee name setter
    public void setEmployeeName(String employeeName)
    {
        employeeName = this.employeeName;
    }
    
    // Password setter
    public void setPassword(String newPassword)
    {
        this.password = newPassword;
    }
    
    
    // Password criteria checker
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
