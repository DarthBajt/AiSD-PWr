/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

/**
 *
 * @author kamil
 * @param <T>
 */
public interface IStack <T> {
    void push (T element) throws FullStackException;
    T pop () throws EmptyStackException;
    int size();
    T peek() throws EmptyStackException;
    boolean isEmpty();
    void clear();
}
