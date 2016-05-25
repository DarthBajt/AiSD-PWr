/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad6;

/**
 *
 * @author kamil
 */
public class DrowningStack implements IStack {
    private Object [] _stack;
    private int _size;
    private int _index;
    
    public DrowningStack(int size) {
        _stack = new Object[size];
        _size = 0;
        _index = 0;
    }
    
    @Override
    public void push(Object element) {
        _stack[_index++ % _stack.length] = element;
        if (_size < _stack.length)
            _size++;
    }

    @Override
    public Object pop() throws EmptyStackException {
        if (_size == 0) throw new EmptyStackException();
        _size--;
        return _stack[--_index % _stack.length];
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public Object peek() throws EmptyStackException {
        if (_size == 0) throw new EmptyStackException();
        return _stack[(_index -1) % _stack.length];
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
