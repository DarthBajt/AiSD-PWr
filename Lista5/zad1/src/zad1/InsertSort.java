/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author kamil
 */
public class InsertSort extends Sort {

    public InsertSort(Comparator comparator) {
        super(comparator);
    }

    @Override
    public List sort(List list) {
        _swaps = 0;
        _compares = 0;
        List result = new LinkedList();
        for (Object o : list) {
            int slot = result.size();
            while (slot > 0) {
                _compares++;
                if (_comparator.compare(o, result.get(slot - 1)) >= 0)
                    break;
                slot--;
            }
            _swaps++;
            result.add(slot, o);
        }
        return result;
    }
    
}
