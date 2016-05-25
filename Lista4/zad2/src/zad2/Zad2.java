/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

/**
 *
 * @author kamil
 */
public class Zad2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Stack liczby = new Stack();
        liczby.push(12);
        liczby.push(13);
        liczby.push(14);
        liczby.push(15);
        liczby.push(16);
        liczby.push(17);
        
        System.out.println(liczby.size());
        System.out.println((int) liczby.peek());
        System.out.println((int) liczby.pop());
        System.out.println((int) liczby.pop());
        System.out.println((int) liczby.peek());
        System.out.println((int) liczby.pop());
        System.out.println((int) liczby.pop());
        System.out.println((int) liczby.pop());
        System.out.println(liczby.size());
        System.out.println((int) liczby.pop());
        liczby.push(20);
        System.out.println(liczby.isEmpty());
        System.out.println((int) liczby.pop());
    }
    
}
