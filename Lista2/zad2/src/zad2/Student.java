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
public class Student  implements Comparable {
    String _firstName, _lastName;
    int _id;
    
    public Student (int id, String firstName, String lastName) {
        _id = id;
        _firstName = firstName;
        _lastName = lastName;
    }
    
    @Override
    public String toString() {
        return String.format("%2d %10s %s", _id, _firstName, _lastName);
    }

    @Override
    public int compareTo(Object o) {
        return _id - ((Student) o)._id;
    }
}
