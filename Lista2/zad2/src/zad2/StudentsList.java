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
public class StudentsList extends List {
    public StudentsList merge (StudentsList otherList) {
        int i = 0, j = 0;
        StudentsList ret = new StudentsList();
        while (i < size() && j < otherList.size()) {
           if (((Student) get(i)).compareTo((Student) otherList.get(j)) < 0)
               ret.add(get(i++));
           else
               ret.add(otherList.get(j++));              
        }
        
        while (i < size())
            ret.add(get(i++));
        
        while (j < otherList.size()) {
            ret.add(otherList.get(j++));
        }
        return ret;
    }
}
