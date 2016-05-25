/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

/**
 *
 * @author kamil
 */
public class Zad1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack liczby = new Stack(3);
        liczby.push(12);
        liczby.push(13);
        liczby.push(14);
        
        System.out.println(liczby.size());
        System.out.println((int) liczby.peek());
        System.out.println((int) liczby.pop());
        System.out.println((int) liczby.pop());
        System.out.println((int) liczby.peek());
        System.out.println((int) liczby.pop());
        System.out.println(liczby.isEmpty());
        
    }
    
}
