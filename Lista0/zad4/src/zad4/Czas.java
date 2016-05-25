/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad4;

import java.io.Serializable;


/**
 *
 * @author kamil
 */
public class Czas implements Serializable {
    public int rok, miesiac, dzien, godzina, minuta;
    public Czas (int r, int mies, int dz, int g, int m) {
        rok = r;
        miesiac = mies;
        dzien = dz;
        godzina = g;
        minuta = m;
    }
}
