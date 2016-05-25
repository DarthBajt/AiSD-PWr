/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

import java.util.List;

/**
 *
 * @author kamil
 */
public class SelectSort extends Sort {

    public SelectSort(Comparator comparator) {
        super(comparator);
    }
    
    @Override
    public List sort(List list) {
        _compares = 0;
        _swaps = 0;
        int size = list.size();
        for (int i = 0; i < size - 1; ++i) {
            int min = i;
            for (int j = i; j < size; ++j) {
                _compares++;
                if (_comparator.compare(list.get(j), list.get(min)) < 0)
                    min = j;
            }
                
            swap(list, min, i);
        }
        return list;
    }
    
}
