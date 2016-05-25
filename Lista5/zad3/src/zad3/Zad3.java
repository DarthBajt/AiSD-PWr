/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kamil
 */
public class Zad3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList list = new ArrayList();
        Scanner in = new Scanner(System.in);
        
        System.out.print("Podaj dlugosc listy: ");
        int dlugosc = in.nextInt();
        for (int i = 0; i < dlugosc; ++i)
            list.add(rand.nextInt(100));
        
        System.out.println(list);
        
        System.out.println("\nBubble sort");
        Sort bubble = new BubbleSort(new IntComparator());
        System.out.println(bubble.sort(new ArrayList(list)));
        System.out.printf("Compares: %d, swaps: %d\n\n", bubble.numberOfCompares(), bubble.numberOfSwaps());
        
        System.out.println("\nShaker sort");
        Sort shaker = new ShakerSort(new IntComparator());
        System.out.println(shaker.sort(new ArrayList(list)));
        System.out.printf("Compares: %d, swaps: %d\n\n", shaker.numberOfCompares(), shaker.numberOfSwaps());
    }
    
}
