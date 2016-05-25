/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

import java.util.Iterator;

/**
 *
 * @author kamil
 */
public class List implements IList {
    private int _size;
    private Element _head;
    
    public List() {
        _size = 0;
    }

    @Override
    public Object set(int index, Object value) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        Element el =  getElement(index);
        Object ret = el.getValue();
        el.setValue(value);
        return ret;
    }

    @Override
    public boolean contains(Object value) {
        
        Element el = _head;
        while(el != null) {
            if (el.getValue().equals(value))
                return true;
            el = el.getNext();
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        Element el = _head;
        int index = 0;
        while(el != null) {
            if (el.getValue().equals(value))
                return index;
            el = el.getNext();
            index++;
        }
        return -1;
    }
    
    private class Element {
        private Element _next;
        private Object _value;

        public Element(Object value) {
            setValue(value);
        }

        Object getValue() {
            return _value;
        }

        public void setValue(Object value) {
            _value = value;
        }

        public Element getNext() {
            return _next;
        }

        public void setNext(Element next) {
            _next = next;
        }
    }

    @Override
    public String toString() {
        String ret = "[";
        Element el = _head;
        for (int i = 0; i < _size - 1; ++i) {
            ret += el.getValue() + ", ";
            el = el.getNext();           
        }
        if (el != null) {
            ret += el.getValue();
        }
        return ret + "]";
    }
    
    @Override
    public boolean isEmpty() {
        return _size == 0;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        return getElement(index).getValue();
    }

    @Override
    public Object delete(int index) throws IndexOutOfBoundsException {
        checkOutOfBounds(index);
        Object ret;
        if (index == 0) {
            ret = _head.getValue();
            _head = _head.getNext();
        } else {
            Element el = getElement(index-1);
            ret = el.getNext().getValue();
            el.setNext(el.getNext().getNext());
        }   
        _size--;
        return ret;
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public void insert(int index, Object value) throws IndexOutOfBoundsException {
        if (index < 0 || index > _size) throw new IndexOutOfBoundsException();
        if (_size == 0)
            _head = new Element(value);
        else if (index == 0) {
            Element temp = new Element(value);
            temp.setNext(_head);
            _head = temp;
        }
        else {
            Element el = getElement(index-1);
            Element temp = new Element(value);
            temp.setNext(el.getNext());
            el.setNext(temp);
            
        }
        _size++;
    }

    @Override
    public void add(Object value) {
        insert(_size, value);
    }

    @Override
    public void clear() {
        _head = null;
        _size = 0;
    }
    

    @Override
    public Iterator iterator() {
        Iterator it = new Iterator() {
            private Element el = _head;
            @Override
            public boolean hasNext() {
                return el != null;
            }

            @Override
            public Object next() {
                Object ret = el.getValue();
                el = el.getNext();
                return ret;
            }
        };      
        return it;
    }

    @Override
    public boolean deleteValue(Object value) {
        int deleted = 0, index;
        while ((index = indexOf(value)) != -1) {
            delete(index);
            deleted++;
        }
            
        return deleted > 0;
    }
    
    private void checkOutOfBounds(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= _size) throw new IndexOutOfBoundsException();
    }
    
    private Element getElement(int index) {
        Element el = _head;
        for (int i = 0; i < index; ++i)
            el = el.getNext();
        return el;
    }
}
