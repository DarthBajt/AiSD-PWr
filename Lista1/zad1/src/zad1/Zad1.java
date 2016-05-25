/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

import java.util.Iterator;
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
        Scanner in = new Scanner(System.in);
        
        ListaStudentow ls = new ListaStudentow();
        
       
        int wybor;
        
        do {
            System.out.println("\nMenu:\n"
                    + "  1: Wyswietl studentow\n"
                    + "  2: Wpisz ocene\n"
                    + "  3: Srednia arytmetyczna pozytywnych ocen\n"
                    + "  4: Studenci, ktorzy nie zaliczyli\n"
                    + "  5: Wyjdz");
            wybor = in.nextInt();
            switch (wybor) {
                case 1:
                    for (Student s : ls)
                        System.out.println(s);
                    break;
                case 2: {
                        System.out.print("Podaj id studenta <" + (ls.pierwszy+1) +";" + (ls.ostatni+1) + ">: ");
                        int id = in.nextInt();
                        System.out.print("Podaj ocene <2;5>: ");
                        int ocena = in.nextInt();
                        ls.ustawOcene(id, ocena);
                    }
                    break;
                case 3: {
                        int liczba = 0;
                        int sumaOcen = 0;
                        Iterator ft = ls.filterIterator(new StudentZaliczyl());
                        while (ft.hasNext()) {
                            Student s = (Student) ft.next();
                            System.out.println(s);
                            liczba++;
                            sumaOcen += s.ocena;
                        }
                        System.out.printf("Srednia: %.3f\n", (double) sumaOcen / liczba);
                    }
                    break;
                case 4: {
                        Iterator ft = ls.filterIterator(new StudentNieZaliczyl());
                        while (ft.hasNext())
                            System.out.println(ft.next());
                    }
                    break;
                default:
                    break;
            }
            
        } while (wybor != 5);
    }
    
    
    
}
