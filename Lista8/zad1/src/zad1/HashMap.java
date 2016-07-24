/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

import java.util.Iterator;
import java.util.LinkedList;
/**
 *
 * @author kamil
 */
public class HashMap {
    
    private LinkedList [] _array;
    private int _size;
    
    
    private class HashElement {
        public Object key, value;

        public HashElement (Object key, Object value) {
            this.key = key.toString();
            this.value = value;
        }
    }
    
    public HashMap () {
        _array = new LinkedList[100000];
        _size = 0;
    }
        
    // FNV-1 algorithm
    private long hash (Object value) {
        String s = value.toString();
        long hash = 2166136261L;
        for (int i = 0; i < s.length(); ++i) {
            hash ^= s.charAt(i);
            hash *= 16777619;
        } 
        return hash;
    }
    
    public int size() {
        return _size;
    }
    
    public void set (Object key, Object value) {
        boolean isExists = false;
        long index = hash(key) & _array.length;
        
        if (_array[(int) index] == null)
            _array[(int) index] = new LinkedList();
        
        for (Object element : _array[(int) index])
            if (((HashElement) element).key.equals(key)) {
                ((HashElement) element).value = value;
                isExists = true;
            }
                
        if (!isExists) {
            _size++;
            _array[(int) index].add(new HashElement(key, value));
        }
            
    }
    
    public Object get (Object key) {
        key = key.toString();
        long index = hash(key) & _array.length;
        LinkedList list = _array[(int) index];
        if (list == null)
            return null;
        for (Object element : list)
            if (((HashElement) element).key.equals(key))
                return ((HashElement) element).value;
        return null;
    }
    
    public boolean remove(Object key) {
        long index = hash(key) & _array.length;
        
        if (_array[(int) index] == null)
            return false;
        Iterator it = _array[(int) index].iterator();
        key = key.toString();
        while (it.hasNext()) {
            HashElement el = (HashElement) it.next();
            if (el.key.equals(key)) {
                it.remove();
                _size--;
                return true;
            }               
        }
        return false;
    }
}
