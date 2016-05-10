/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameconsole;

import java.util.Scanner;

/**
 *
 * @author Quint
 */


public class Actions {
	
	
    static Scanner scanner = new Scanner(System.in);
    
    public static String askFor(String text){
        System.out.print( text + ":\t");
		return scanner.nextLine();
    	
    	
    }
}
