/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

/**
 *
 * @author kamil
 */
public class Stack  implements IStack {
    private Object [] _stack;
    private int _size;
    
    public Stack(int size) {
        _stack = new Object[size];
        _size = 0;
    }
    
    @Override
    public void push(Object element) throws FullStackException {
        if (_size == _stack.length) throw new FullStackException();
        _stack[_size++] = element; 
    }

    @Override
    public Object pop() throws EmptyStackException {
        if (_size == 0) throw new EmptyStackException();
        return _stack[--_size];
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public Object peek() throws EmptyStackException {
        if (_size == 0) throw new EmptyStackException();
        return _stack[_size-1];
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
