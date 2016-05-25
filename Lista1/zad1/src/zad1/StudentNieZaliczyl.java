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
public class StudentNieZaliczyl implements Predicate {

    @Override
    public boolean isPositive (Object s) {
        return ((Student) s).ocena == 2;
    }
}
