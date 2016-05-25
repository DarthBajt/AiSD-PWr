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
public interface IList extends Iterable {
    public Object get(int index) throws IndexOutOfBoundsException;
    public Object delete(int index) throws IndexOutOfBoundsException;
    public boolean deleteValue(Object value);
    public Object set(int index, Object value) throws IndexOutOfBoundsException;
    public int size();
    public void insert(int index, Object value) throws IndexOutOfBoundsException;
    public boolean isEmpty();
    public boolean contains (Object value);
    public int indexOf(Object value);
    public void add(Object value);
    public void clear();
    
    
}
