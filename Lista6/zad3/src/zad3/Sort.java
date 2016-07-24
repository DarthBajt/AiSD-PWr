/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

import java.util.List;

/**
 *
 * @author kamil
 */
public abstract class Sort {
    
    protected int _compares;
    protected int _swaps;
    protected final Comparator _comparator;
    
    public Sort (Comparator comparator) {
        _comparator = comparator;
        _swaps = 0;
        _compares = 0;
    }
    
    public abstract List sort(List list);
    
    public int numberOfSwaps () {
        return _swaps;
    }
    
    public int numberOfCompares () {
        return _compares;
    }
    
    protected void swap (List list, int left, int right) {
        if (left != right) {
            _swaps++;
            Object temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
        }
    }
}
