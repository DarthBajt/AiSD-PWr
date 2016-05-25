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
public class ShakerSort extends Sort {

    public ShakerSort(Comparator comparator) {
        super(comparator);
    }

    @Override
    public List sort(List list) {
        _compares = 0;
        _swaps = 0;
        int begin = 0, end = list.size();
        int lastSwap = end - 1;
        while (begin < end) {            
            for (int i = begin; i < end - 1; ++i) {
                _compares++;
                if (_comparator.compare(list.get(i), list.get(i + 1)) > 0) {
                    swap(list, i, i + 1);
                    lastSwap = i + 1;
                }                   
            }
            end = lastSwap;
            
            for (int i = end; i > begin; --i) {
                _compares++;
                if (_comparator.compare(list.get(i), list.get(i - 1)) < 0) {
                    swap(list, i, i - 1);
                    lastSwap = i;
                }
            }
            begin = lastSwap;
        }
        return list;
    }
    
}
