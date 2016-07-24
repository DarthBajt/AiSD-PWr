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
        Queue q = new Queue();
        
        for (int i = 1; i <= 5; ++i)
            q.enqueue(i);
        
        System.out.println("Kolejka: " + q);
        System.out.println("Rozmiar: " + q.size());
        
        System.out.println("Sciagam elementy:");
        while (!q.isEmpty()) {
            System.out.println(q.dequeue());
        }
        
        System.out.println("Kolejka: " + q);
        System.out.println("Rozmiar: " + q.size());
    }
    
}
