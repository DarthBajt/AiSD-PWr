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
class OptimalSeq implements SortStrategy {

    public OptimalSeq() {
    }

    @Override
    public ArrayList sequence(int size) {
        int [] arr = {1, 4, 10, 23, 57, 132, 301, 701};
        ArrayList ret =  new ArrayList();
        for (int i = 0; i < arr.length && arr[i] * 2 < size; ++i)
            ret.add(arr[i]);
        return ret;
    }
    
}
