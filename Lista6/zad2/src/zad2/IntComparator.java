/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;


public class IntComparator implements Comparator {

    @Override
    public int compare(Object left, Object right) throws ClassCastException {
        return (int) left - (int) right;
    }
    
}
