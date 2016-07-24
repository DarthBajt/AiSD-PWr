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
public class ShellSort extends Sort {
    
    private final int[] _increments = {121, 40, 13, 4, 1};
    
    public ShellSort(Comparator comparator) {
        super(comparator);
    }

    @Override
    public List sort(List list) {
        _swaps = _compares = 0;
        for (int i = 0; i < _increments.length; ++i) {
            hSort(list, _increments[i]);
        }
        return list;
    }

    private void hSort(List list, int h) {
        if (list.size() < h*2)
            return;
        for (int i = 0; i < h; ++i)
            sortSublist(list, i, h);
    }

    private void sortSublist(List list, int start, int h) {
        for (int i = start + h; i < list.size(); i += h) {
            Object value = list.get(i);
            int j;
            for (j = i; j > start; j -= h) {
                Object prevValue = list.get(j - h);
                _compares++;
                if (_comparator.compare(value, prevValue) >= 0)
                    break;
                _swaps++;
                list.set(j, prevValue);
            }
            _swaps++;
            list.set(j, value);
        }
    }
    
}
