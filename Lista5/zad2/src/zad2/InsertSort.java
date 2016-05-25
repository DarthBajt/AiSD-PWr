/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author kamil
 */
public class InsertSort {
    private Comparator _comparator;
    
    public InsertSort(Comparator comparator) {
        _comparator = comparator;
    }
    
    public void setCompatator(Comparator comparator) {
        _comparator = comparator;
    }

    public List sort(List list) {
        List result = new LinkedList();
        for (Object o : list) {
            int slot = result.size();
            while (slot > 0) {
                if (_comparator.compare(o, result.get(slot - 1)) >= 0)
                    break;
                slot--;
            }
            result.add(slot, o);
        }
        return result;
    }
    
}
