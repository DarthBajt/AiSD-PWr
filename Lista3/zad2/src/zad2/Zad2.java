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
        Buffer buffer = new Buffer(5);
        
        for (int i = 1; i <= 35; ++i) {
            // zapisujemy dane
            if (!buffer.isFull())
                buffer.enqueue(i);
            else
                // odczytujemy przeslane dane
                while(!buffer.isEmpty())
                    System.out.print(buffer.dequeue() + " ");
        }
        // koniec wysylania danych, odczyt pozostalych danych w buforze
        while(!buffer.isEmpty())
            System.out.print(buffer.dequeue() + " ");
        System.out.println();
    }
    
}
