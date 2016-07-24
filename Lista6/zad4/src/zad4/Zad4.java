/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kamil
 */
public class Zad4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(new IntComparator());
        Random rand = new Random();
        ArrayList list = new ArrayList();
        Scanner in = new Scanner(System.in);
        
        System.out.print("Podaj dlugosc listy: ");
        int dlugosc = in.nextInt();
        for (int i = 0; i < dlugosc; ++i) {
            int r = rand.nextInt(100);
            list.add(r);
            pq.enqueue(r);
        }
            
        
        System.out.println("Lista: " + list);
        list.clear();
        while (!pq.isEmpty()) {
            list.add(pq.dequeue());
        }
        System.out.println("Kolejka: " + list);
        System.out.printf("Porownan: %d, zamian: %d\n\n", pq.compares(), pq.swaps());
    }
    
}
