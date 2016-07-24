/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;


public class Queue implements IQueue {
    
    private Element _queue = new Element(null);
    private int _size;
    
    private class Element {
        Element _next;
        Object _value;
        
        public Element(Object val) {
            _value = val;
        }
        
        public void setNext(Element next) {
            _next = next;
        }
        
        public Element getNext() {
            return _next;
        }
        
        public Object getValue() {
            return _value;
        }
    }
    
    @Override
    public void enqueue(Object value) {
        Element temp = _queue;
        for (int i = 0; i < _size; ++i)
            temp = temp.getNext();
        temp.setNext(new Element(value));
        _size++;
    }

    @Override
    public Object dequeue() throws EmptyQueueException {
        if (_size == 0) throw new EmptyQueueException();
        Object ret = _queue.getNext().getValue();
        _queue.setNext(_queue.getNext().getNext());
        _size--;
        return ret;
    }

    @Override
    public void clear() {
        _queue.setNext(null);
        _size = 0;
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public boolean isEmpty() {
        return _size == 0;
    }
    
    @Override
    public String toString() {
        if (_size == 0)
            return "[]";
        else {
            Element temp = _queue.getNext();
            String ret = "[";
            for (int i = 0; i < _size - 1; ++i) {
                ret += temp.getValue() + ", ";
                temp = temp.getNext();
            }
            return ret + temp.getValue() + "]";
        }
    }
    
}
