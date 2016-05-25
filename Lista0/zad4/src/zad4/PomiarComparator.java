/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad4;

import java.util.Comparator;

/**
 *
 * @author kamil
 */
public class PomiarComparator implements Comparator <Pomiar> {

    @Override
    public int compare(Pomiar p1, Pomiar p2) {
        if (p1.czas.rok < p2.czas.rok)
            return -1;
        if (p1.czas.rok > p2.czas.rok)
            return 1;
        
        if (p1.czas.miesiac < p2.czas.miesiac)
            return -1;
        if (p1.czas.miesiac > p2.czas.miesiac)
            return 1;
        
        if (p1.czas.dzien < p2.czas.dzien)
            return -1;
        if (p1.czas.dzien > p2.czas.dzien)
            return 1;
        
        if (p1.czas.godzina < p2.czas.godzina)
            return -1;
        if (p1.czas.godzina > p2.czas.godzina)
            return 1;
        
        if (p1.czas.minuta < p2.czas.minuta)
            return -1;
        if (p1.czas.minuta > p2.czas.minuta)
            return 1;
        
        return 0;
    }
}
