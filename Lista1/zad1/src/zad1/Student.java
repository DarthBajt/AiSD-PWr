/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

/**
 *
 * @author kamil
 */
public class Student {
    int id, ocena;
    String imie, nazwisko;
    
    public Student(int id, String imie, String nazwisko, int o) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        ocena = o;
    }
    
    public void ustawOcene(int o) {
        ocena = o;
    }
    
    @Override
    public String toString() {
        return "id: " + id + ", imie: " + imie + ", nazwisko: " +  nazwisko + ", ocena: " + ocena;
    }
}
