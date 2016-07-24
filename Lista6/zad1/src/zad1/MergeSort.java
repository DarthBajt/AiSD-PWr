/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kamil
 */
public class MergeSort extends Sort {

    public MergeSort(Comparator comparator) {
        super(comparator);
    }

    @Override
    public List sort(List list) {
        _swaps = _compares = 0;
        return mergesort(list, 0, list.size() - 1);
    }
    
    private List mergesort(List list, int start, int end) {
        if (start == end) {
            _swaps++;
            List ret = new ArrayList();
            ret.add(list.get(start));
            return ret;
        }
        int split = (start + end) / 2;
        return merge(mergesort(list, start, split), mergesort(list, split + 1, end));
    }
    
    private List merge (List list1, List list2) {
        int i = 0, j = 0;
        List ret = new ArrayList();
        while (i < list1.size() && j < list2.size()) {
           _compares++;
           if (_comparator.compare(list1.get(i), list2.get(j)) < 0)
               ret.add(list1.get(i++));
           else
               ret.add(list2.get(j++));              
        }
        
        while (i < list1.size())
            ret.add(list1.get(i++));
        
        while (j < list2.size())
            ret.add(list2.get(j++));
        
        return ret;
    }
    
}
