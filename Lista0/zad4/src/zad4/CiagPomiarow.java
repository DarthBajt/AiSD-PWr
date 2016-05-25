/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author kamil
 */
public class CiagPomiarow implements Serializable {
    ArrayList <Pomiar> pomiary;
    
    public CiagPomiarow () {
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
            
            FileOutputStream fos = new FileOutputStream("pomiary.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(pomiary);
            
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void czytaj () {
        try {
            FileInputStream fis = new FileInputStream("pomiary.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            pomiary = (ArrayList <Pomiar>) ois.readObject();
            
            ois.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException c) {
            c.printStackTrace();
        }
    }
}
