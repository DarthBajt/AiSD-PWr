/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

import java.util.ArrayList;

/**
 *
 * @author kamil
 */
class FibonacciSeq implements SortStrategy {

    public FibonacciSeq() {
    }

    @Override
    public ArrayList sequence (int size) {
        ArrayList ret = new ArrayList();
        int x, y = 1, z = 1;
        while (y * 3 < 10) {       
            x = y;
            y = z;      
            z = x + y;
            ret.add(y);           
        }
        return ret;
    }
    
}
