/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

/**
 *
 * @author kamil
 */
public class Stack  implements IStack {
    private Object [] _stack;
    private int _capacity;
    private int _index;
    
    public Stack() {
        _capacity = 2;
        _stack = new Object[_capacity];   
        _index = 0;
    }
    
    @Override
    public void push(Object element) {       
        _stack[_index++] = element;
        if (_index > (3*_capacity / 4.0)) {
            _capacity *= 2;
            Object [] temp = new Object[_capacity];
            for (int i = 0; i < _index; ++i)
                temp[i] = _stack[i];
            _stack = temp;
        }
    }

    @Override
    public Object pop() throws EmptyStackException {
        if (_index == 0) throw new EmptyStackException();
        Object ret = _stack[--_index];
        
        if (_index < (_capacity / 4.0)) {
            _capacity /= 2;
            Object [] temp = new Object[_capacity];
            for (int i = 0; i < _index; ++i)
                temp[i] = _stack[i];
            _stack = temp;
        }        
        return ret;
    }

    @Override
    public int size() {
        return _index;
    }

    @Override
    public Object peek() throws EmptyStackException {
        if (_index == 0) throw new EmptyStackException();
        return _stack[_index-1];
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        _stack = null;
        _capacity = 2;
        _index = 0;
    }
    
    public int capacity() {
        return _capacity;
    }
}
