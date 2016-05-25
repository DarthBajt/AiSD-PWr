/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

/**
 *
 * @author kamil
 */
public class Stack implements IStack {
    
    private Element _stack;
    private int _size;
    
    private class Element {
        Element previous;
        Object value;
        
        public Element(Element element, Object val) {
            previous = element;
            value = val;
        }
    }
    
    public Stack() {
        
    }
    
    @Override
    public void push(Object element) {
        _stack = new Element(_stack, element); 
        _size++;
    }

    @Override
    public Object pop() throws EmptyStackException {
        if (_size == 0) throw new EmptyStackException();
        Object temp = _stack.value;
        _stack = _stack.previous;
        _size--;
        return temp;
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public Object peek() throws EmptyStackException {
        if (_size == 0) throw new EmptyStackException();
        return _stack.value;
    }

    @Override
    public boolean isEmpty() {
       return size() == 0;
    }

    @Override
    public void clear() {
        _stack = null;
        _size = 0;
    }
    
}
