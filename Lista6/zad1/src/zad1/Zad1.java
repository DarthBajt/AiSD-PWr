/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kamil
 */
public class Zad1 {

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
        
        System.out.println("\nMerge sort");
        Sort merge = new MergeSort(new IntComparator());
        System.out.println(merge.sort(new ArrayList(list)));
        System.out.printf("Compares: %d, swaps: %d\n\n", merge.numberOfCompares(), merge.numberOfSwaps());
     
        System.out.println("\nQuick sort");
        Sort quick = new QuickSort(new IntComparator());
        System.out.println(quick.sort(new ArrayList(list)));
        System.out.printf("Compares: %d, swaps: %d\n\n", quick.numberOfCompares(), quick.numberOfSwaps());
        
        System.out.println("\nShell sort");
        Sort shell = new ShellSort(new IntComparator());
        System.out.println(shell.sort(new ArrayList(list)));
        System.out.printf("Compares: %d, swaps: %d\n\n", shell.numberOfCompares(), shell.numberOfSwaps());
    }
    
}
