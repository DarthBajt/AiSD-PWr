/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

import java.util.List;


public class BubbleSort extends Sort {   
    public BubbleSort (Comparator comparator) {
        super(comparator);
    }

    @Override
    public List sort(List list) {
        _compares = 0;
        _swaps = 0;
        int size = list.size();
        for (int i = 1; i < size; ++i)
            for (int j = 0; j < size - i; ++j) {
                _compares++;
                if (_comparator.compare(list.get(j), list.get(j+1)) > 0)
                    swap(list, j, j+1);
            }
        return list;
    }  
}
