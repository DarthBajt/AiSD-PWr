/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad4;

import java.util.ArrayList;

/**
 *
 * @author kamil
 */
public class PriorityQueue implements IQueue {
    private final ArrayList _list;
    private final Comparator _comparator;
    private int _compares, _swaps;
    
    public PriorityQueue (Comparator comparator) {
        _list = new ArrayList();
        _comparator = comparator;
        _compares = _swaps = 0;
    }

    @Override
    public void enqueue (Object value) {
        _list.add(value);
        swim(_list.size() - 1);
    }

    @Override
    public Object dequeue() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        Object ret = _list.get(0);
        if (_list.size() > 1) {
            _list.set(0, _list.get(_list.size() - 1));
            sink(0);
        }
        _list.remove(_list.size() - 1);
        return ret;
    }

    @Override
    public void clear() {
        _swaps = _compares = 0;
        _list.clear();
    }

    @Override
    public int size() {
        return _list.size();
    }

    @Override
    public boolean isEmpty() {
        return _list.isEmpty();
    }
    
    private void swap (int index1, int index2) {
        _swaps++;
        Object temp = _list.get(index1);
        _list.set(index1, _list.get(index2));
        _list.set(index2, temp);
    }
    
    private void swim (int index) {
        int parent;
        _compares++;
        while (index != 0 && _comparator.compare(_list.get(index), _list.get(parent = (index - 1) / 2)) > 0) {
            _compares++;
            swap(index, parent);
            index = parent;
        }
    }
    
    private void sink (int index) {
        boolean isDone = false;
        int child;
        while (!isDone && (child = 2*index + 1) < _list.size()) {
            _compares += 2;
            if (child < _list.size() - 1 && _comparator.compare(_list.get(child), _list.get(child+1)) < 0)
                child++;
            if (_comparator.compare(_list.get(index), _list.get(child)) < 0)
                swap(index, child);
            else
                isDone = true;
            index = child;
        }
    }
    
    
    public int swaps () {
        return _swaps;
    }
    
    public int compares () {
        return _compares;
    }
}
