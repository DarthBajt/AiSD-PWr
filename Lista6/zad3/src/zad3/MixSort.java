/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kamil
 */
class MixSort extends Sort {
    
    private int _k;
    
    public MixSort (Comparator comparator, int k) {
        super(comparator);
        _k = k;
    }

    @Override
    public List sort(List list) {
        _compares = _swaps = 0;
       quickSort(list, 0, list.size() - 1, _k);
        return list;
    }
    
    private void quickSort (List list, int start, int end, int k) {
        if (end > start) {
            if (end - start < k)
                insertSort(list, start, end + 1);
            else {
                Object value = list.get(end);
                int partition = partition(list, value, start, end);
                _compares++;
                if (_comparator.compare(list.get(partition), value) < 0) ++partition;
                swap(list, partition, end);
                quickSort(list, start, partition - 1, k);
                quickSort(list, partition + 1, end, k);
            }
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
    
    private void insertSort(List list, int start, int end) {
        List result = new ArrayList();
        for (int i = start + 1; i < end; ++i) {
            Object o = list.get(i);
            int j = i - 1;
            while (j >= 0 && _comparator.compare(o, list.get(j)) < 0) {
                _compares++;
                list.set(j + 1, list.get(j));
                j--;
            }
            _swaps++;
            list.set(j + 1, o);
        }
    }
    
}
