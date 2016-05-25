/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad12;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author kamil
 */
public class Zad12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);
        int wybor = 10;
        Macierz mt = new MacierzTekstowa();
        Macierz mb = new MacierzBinarna();
        
        do {
            System.out.println("\nMenu:\n"
                    + "  1: Utworz macierz w pliku tekstowym\n"
                    + "  2: Utworz macierz w pliku binarnym\n"
                    + "  3: Odczytaj z tekstowego\n"
                    + "  4: Odczytaj z binarnego\n"
                    + "  5: Wyjdz");
            wybor = in.nextInt();
            switch (wybor) {
                case 1:
                    mt.utworzMacierz();
                    mt.zapisz();
                    break;
                case 2:
                    mb.utworzMacierz();
                    mb.zapisz();
                    break;
                case 3:
                    mt.czytaj();
                    mt.wypisz();
                    mt.max();
                    break;
                case 4:
                    mb.czytaj();
                    mb.wypisz();
                    mb.max();
                    break;
                default:
                    break;
            }
        } while (wybor != 5);
    }
    
}
