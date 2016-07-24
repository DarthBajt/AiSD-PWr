/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kamil
 */
public class Zad2 {

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
        
        System.out.println("\nShell sort ze strategia ciagu Fibonacciego");
        Sort shellFib = new ShellSort(new IntComparator(), new FibonacciSeq());
        System.out.println(shellFib.sort(new ArrayList(list)));
        System.out.printf("Compares: %d, swaps: %d\n\n", shellFib.numberOfCompares(), shellFib.numberOfSwaps());
        
        System.out.println("\nShell sort z optymalna strategia");
        Sort shellOpt = new ShellSort(new IntComparator(), new OptimalSeq());
        System.out.println(shellOpt.sort(new ArrayList(list)));
        System.out.printf("Compares: %d, swaps: %d\n\n", shellOpt.numberOfCompares(), shellOpt.numberOfSwaps());
    }
    
}
