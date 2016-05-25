package zad12;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.util.Random;
import java.util.Date;

/**
 *
 * @author kamil
 */
public abstract class Macierz {
    protected int kolumny, wiersze;
    protected float dane[][];
    
    public Macierz() {
        kolumny = wiersze = 1;
        dane = new float[1][1];
        dane[0][0] = 0;
    }
    
    public void utworzMacierz() {
        Random rand = new Random((new Date()).getTime());
        Scanner in = new Scanner(System.in);
        System.out.print("Podaj liczbe wierszy: ");
        wiersze = in.nextInt();
        System.out.print("Podaj liczbe kolumn: ");
        kolumny = in.nextInt();
        dane = new float[wiersze][kolumny];
        
        for (int i = 0; i < wiersze; ++i)
            for (int j = 0; j < kolumny; ++j)
                dane[i][j] = rand.nextFloat() * 100;
        zapisz();
    }
    
    public void max() {
        float max = dane[0][0];
        int maxw = 0, maxk = 0;
        for (int i = 0; i < wiersze; ++i)
            for (int j = 0; j < kolumny; ++j)
                if (dane[i][j] > max) {
                    max = dane[i][j];
                    maxw = i;
                    maxk = j;
                }
        System.out.println("Liczba maksymalna " + max + ", ma indeks [" + maxw + ";" + maxk + "]");
    }
    
    public void wypisz() {
        for (int i = 0; i < wiersze; ++i) {
            for (int j = 0; j < kolumny; ++j)
                System.out.printf("%6.3f ", dane[i][j]);
            System.out.println("");
        }
    }
    
    public abstract void zapisz();
    public abstract void czytaj();
    
}
