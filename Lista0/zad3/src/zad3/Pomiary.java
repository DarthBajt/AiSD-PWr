/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author kamil
 */
public class Pomiary {
    ArrayList <Pomiar> pomiary;
    
    public Pomiary () {
        pomiary = new ArrayList <Pomiar> ();
        czytaj();
    }
    
    public void dodajPomiar () {
        Scanner in = new Scanner(System.in);
        System.out.print("Podaj rok: ");
        int rok = in.nextInt();
        System.out.print("Podaj miesiac: ");
        int miesiac = in.nextInt();
        System.out.print("Podaj dzien: ");
        int dzien = in.nextInt();
        System.out.print("Podaj godzine: ");
        int godzina = in.nextInt();
        System.out.print("Podaj minute: ");
        int minuta = in.nextInt();
        System.out.print("Podaj temperature: ");
        double temperatura = in.nextDouble();
        Pomiar p = new Pomiar(rok, miesiac, dzien, godzina, minuta, temperatura);
        pomiary.add(p);
        Collections.sort(pomiary, new PomiarComparator());
    }
    
    public void wypiszOciepleniaZMiesiaca (int mies) {
        ArrayList <Pomiar> dniMiesiaca = new ArrayList <Pomiar> ();
        double srednia = 0;
        int liczbaDni = 0;
        for (int i = 0; i < pomiary.size(); ++i) {
            Pomiar p = pomiary.get(i);
            if (p.czas.miesiac == mies)
                dniMiesiaca.add(p);
        }
        
        for (int i = 0; i < dniMiesiaca.size(); ++i) {
            Pomiar dzien = dniMiesiaca.get(i);
            srednia += dzien.temperatura;
            liczbaDni++;
        }
        
        srednia /= liczbaDni;
        
        for (int i = 0; i < dniMiesiaca.size(); ++i) {
            Pomiar dzien = dniMiesiaca.get(i);
            if (dzien.temperatura > srednia)
                System.out.println(dzien);
        }
        
    }
    
    public void wypiszZMiesiaca (int mies) {
        for (int i = 0; i < pomiary.size(); ++i) {
            Pomiar p = pomiary.get(i);
            if (p.czas.miesiac == mies)
                System.out.println(p);
        }
    }
    
    public void zapisz () {
        try {
            
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("pomiary.dat"));
            
            int size = pomiary.size();
            
            dos.writeInt(size);
            
            for (int i = 0; i < size; ++i) {
                Pomiar p = pomiary.get(i);
                dos.writeInt(p.czas.rok);
                dos.writeInt(p.czas.miesiac);
                dos.writeInt(p.czas.dzien);
                dos.writeInt(p.czas.godzina);
                dos.writeInt(p.czas.minuta);
                dos.writeDouble(p.temperatura);
            }

            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void czytaj () {
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("pomiary.dat"));
            
            int size = dis.readInt();
            pomiary = new ArrayList <Pomiar> (size);
            
            for (int i = 0; i < size; ++i) {
                int rok = dis.readInt();
                int miesiac = dis.readInt();
                int dzien = dis.readInt();
                int godzina = dis.readInt();
                int minuta = dis.readInt();
                double temperatura = dis.readDouble();
                Pomiar p = new Pomiar(rok, miesiac, dzien, godzina, minuta, temperatura);
                pomiary.add(p);
            }
            
            
            dis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
