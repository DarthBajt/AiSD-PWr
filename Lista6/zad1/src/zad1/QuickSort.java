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
public class QuickSort extends Sort {

    public QuickSort(Comparator comparator) {
        super(comparator);
    }

    @Override
    public List sort (List list) {
        _swaps = _compares = 0;
        quicksort(list, 0, list.size() - 1);
        return list;
    }
    
    private void quicksort (List list, int start, int end) {
        if (end > start) {
            Object value = list.get(end);
            int partition = partition(list, value, start, end);
            _compares++;
            if (_comparator.compare(list.get(partition), value) < 0) ++partition;
            swap(list, partition, end);
            quicksort(list, start, partition - 1);
            quicksort(list, partition + 1, end);
        }
    }

    private int partition (List list, Object value, int start, int end) {
        while (start < end) {
            _compares += 2;
            if (_comparator.compare(list.get(start), value) < 0) {
                ++start;
                continue;
            }
            if (_comparator.compare(list.get(end), value) >= 0) {
                --end;
                continue;
            }
            swap(list, start, end);
            ++start;
        }
        return start;
    }
}
