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
public class MacierzBinarna extends Macierz {
        
    @Override
    public void czytaj() {
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("macierz.dat"));
            wiersze = dis.readInt();
            kolumny = dis.readInt();
            
            dane = new float[wiersze][kolumny];
            
            for (int i = 0; i < wiersze; ++i)
                for (int j = 0; j < kolumny; ++j)
                    dane[i][j] = dis.readFloat();
            
            dis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void zapisz() {
        try {
            
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("macierz.dat"));
            
            dos.writeInt(wiersze);
            dos.writeInt(kolumny);
            
            for (int i = 0; i < wiersze; ++i)
                for (int j = 0; j < kolumny; ++j)
                    dos.writeFloat(dane[i][j]);
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
