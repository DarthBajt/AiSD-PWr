/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;


/**
 *
 * @author kamil
 */
public class Pomiar {
    Czas czas;
    double temperatura;
    
    public Pomiar (int rok, int miesiac, int dzien, int godzina, int minuta, double temp) {
        czas = new Czas(rok, miesiac, dzien, godzina, minuta);
        temperatura = temp;
    }
    
    public int compareTo () {
        return 1;
    }
    
    @Override
    public String toString () {
        return String.format("%d-%d-%d %d:%d Temperatura: %5.2f",
                czas.dzien, czas.miesiac, czas.rok, czas.godzina, czas.minuta, temperatura);
    }
}
