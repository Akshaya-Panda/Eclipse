package com.comviva.main;

import com.comviva.Register.Register;
import com.comviva.invalidmail.InvalidEmailException;
import com.comviva.invalidpassword.InvalidPasswordException;
import com.comviva.passwordnotmatch.PasswordNotMatchException;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Register user = new Register();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your email: ");
        String email = sc.nextLine();

        System.out.println("Enter your password: ");
        String pass = sc.nextLine();

        System.out.println("Confirm your password: ");
        String cpass = sc.nextLine();

        try {
            System.out.println(user.checkCredentials(email, pass, cpass));
        } catch (InvalidEmailException e) {
            System.out.println(e.getMessage());
        } catch (PasswordNotMatchException e) {
            System.out.println(e.getMessage());
        } catch (InvalidPasswordException e) {
            System.out.println(e.getMessage());
        }
        finally {
        	sc.close();
        }
    }
}

