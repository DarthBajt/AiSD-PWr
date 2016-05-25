/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad4;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author kamil
 */
public class Zad4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack st = new Stack();
        String line = in.nextLine();
        while (!line.isEmpty()) {
            for (int i = 0; i < line.length(); ++i)
                st.push(line.charAt(i));
            while(!st.isEmpty())
                System.out.print(st.pop());
            System.out.println("");
            line = in.nextLine();
        }
    }
    
}
