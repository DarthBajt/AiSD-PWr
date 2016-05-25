/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

import java.util.Locale;
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
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);
        int wybor;
        int mies;
        
        Pomiary pom = new Pomiary();
        
        do {
            System.out.println("\nMenu:\n"
                    + "  1: dodaj nowy pomiar\n"
                    + "  2: wypisz pomiary z danego miesiaca\n"
                    + "  3: wypisz dni miesiaca, w ktorych nastapilo ocieplenie\n"
                    + "     (wartosc wieksza niz srednia temperatura miesiaca)\n"
                    + "  4: Wyjdz");
            wybor = in.nextInt();
            switch (wybor) {
                case 1:
                    pom.dodajPomiar();
                    break;
                case 2:
                    System.out.print("Podaj numer miesiaca (styczen - 1, grudzien - 12): ");
                    mies = in.nextInt();
                    pom.wypiszZMiesiaca(mies);
                    break;
                case 3:
                    System.out.println("Podaj numer miesiaca (styczen - 1, grudzien - 12): ");
                    mies = in.nextInt();
                    pom.wypiszOciepleniaZMiesiaca(mies);
                    break;
                default:
                    break;
            }
        } while (wybor != 4);
        
        pom.zapisz();
    }
    
}
