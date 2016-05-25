/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad12;

import java.io.*;

/**
 *
 * @author kamil
 */
public class MacierzTekstowa extends Macierz {
    
    @Override
    public void czytaj() {
        BufferedReader reader = null;
        try {
            File plik = new File("macierz.txt");
            reader = new BufferedReader(new FileReader("macierz.txt"));
            reader.readLine();
            
            int w = Integer.parseInt(reader.readLine());
            int k = Integer.parseInt(reader.readLine());
            String s[];
            
            dane = new float[w][k];
            wiersze = w;
            kolumny = k;
            
            for (int i = 0; i < w; ++i) {
                s = reader.readLine().split("\\s+");
                for (int j = 0; j < s.length; ++j)
                    dane[i][j] = Float.parseFloat(s[j]);
            }
            
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
            
    
    @Override
    public void zapisz() {
        BufferedWriter writer = null;
        try {
            File plik = new File("macierz.txt");
            writer = new BufferedWriter(new FileWriter("macierz.txt"));
            
            writer.write("Macierz\n");
            writer.write(Integer.toString(wiersze) + "\n");
            writer.write(Integer.toString(kolumny) + "\n");
            
            for (int i = 0; i < wiersze; ++i) {
                for (int j = 0; j < kolumny; ++j)
                    writer.write(String.format("%6.3f ", dane[i][j]));
                writer.newLine();
            }
                
            
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
