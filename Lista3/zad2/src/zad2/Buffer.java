/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;


public class Buffer implements IQueue {
    
    private int _reader, _writer, _size;
    private Object [] _buffer;
    
    public Buffer (int size) {
        _buffer = new Object[size];
        _size = _reader = _writer = 0;
    }
    
    @Override
    public void enqueue(Object value) {
        _buffer[_writer++ % _buffer.length] = value;
        if (_size < _buffer.length)
            _size++;
        else
            _reader++;
    }

    @Override
    public Object dequeue() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();
        _size--;
        return _buffer[_reader++ % _buffer.length];
    }

    @Override
    public void clear() {
        for (int i = 0; i < _buffer.length; ++i)
            _buffer[i] = null;
        _size = _reader = _writer = 0;
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public boolean isEmpty() {
        return _size == 0;
    }
    
    public int bufferSize() {
        return _buffer.length;
    }
    
    public boolean isFull() {
        return _size == _buffer.length;
    }
    
    @Override
    public String toString() {
        if (_size == 0)
            return "[]";
        String ret = "[";
        int size = _size, reader = _reader;
        for (int i = 0; i < size - 1; ++i)
            ret += _buffer[reader++ % _buffer.length] + ", ";
        ret += _buffer[reader++ % _buffer.length] + "]";
        return ret;
    }
    
}
