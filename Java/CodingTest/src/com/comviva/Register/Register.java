package com.comviva.Register;
import com.comviva.invalidmail.InvalidEmailException;
import com.comviva.invalidpassword.InvalidPasswordException;
import com.comviva.passwordnotmatch.PasswordNotMatchException;


public class Register {
	
//declaring all the variables 
	
    public String email;
    public String pass;
    public String cpass;
    
  /*checkCredentials method which will take input all the credentails from the user and
    will validate it */
    
    public String checkCredentials(String email, String pass, String cpass) throws InvalidEmailException, InvalidPasswordException, PasswordNotMatchException {
        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
        	
        	// Email should contain @ and , in it while passing the email.
        	
            throw new InvalidEmailException("InvalidEmailException: Invalid Email.");
        }
        if ((pass.length() < 6) && (!pass.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"))) {
          
        	/* password length should be greater than 6 and password should contain one uppercase, 
        	   one lowercase , one digit and one special character */
        	
        	throw new InvalidPasswordException("InvalidPasswordException: Invalid Password.");
        }
        if (!pass.equals(cpass)) {
        	
        	//the confirm password should be equal to the valid password
        	
            throw new PasswordNotMatchException("PasswordNotMatchException: Password not match.");
        }
        return "Registered.";
    }
    
}
