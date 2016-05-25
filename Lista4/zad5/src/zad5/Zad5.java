/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad5;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author kamil
 */
public class Zad5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack st = new Stack();
        double wynik = 0;
                
        String line = in.nextLine();
        while (!line.isEmpty()) {
            String [] lines = line.split("\\s+");
            for (int i = 0; i < lines.length; ++i) {
                try {
                    double d = Double.parseDouble(lines[i]);
                    st.push(d);
                } catch (NumberFormatException nfe) {
                    switch (lines[i].charAt(0)) {
                        case '+':
                            wynik = (double) st.pop() + (double) st.pop();
                            st.push(wynik);
                            break;
                        case '*':
                            wynik = (double) st.pop() * (double) st.pop();
                            st.push(wynik);
                            break;
                        case '-':
                            wynik = (double) st.pop();
                            wynik = (double) st.pop() - wynik;
                            st.push(wynik);
                            break;
                        case '/':
                            wynik = (double) st.pop();
                            wynik = (double) st.pop() / wynik;
                            st.push(wynik);
                            break;
                        default:
                            break;
                    }
                }                
            }
            System.out.println("Wynik: " + (double) st.pop());
            line = in.nextLine();
        }
        
    }
    
}
