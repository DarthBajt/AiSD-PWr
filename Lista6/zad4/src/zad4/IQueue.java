/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad4;

/**
 *
 * @author kamil
 */
public interface IQueue {
    public void enqueue(Object value);
    public Object dequeue() throws EmptyQueueException;
    public void clear();
    public int size();
    public boolean isEmpty();
}
