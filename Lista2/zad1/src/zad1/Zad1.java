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
public class Zad1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List ls = new List();
        ls.add(3);
        ls.add(4);
        ls.add(5);
        ls.add(5);
        ls.add(5);
        ls.add(4);
        ls.add(6);
        ls.add(7);
        System.out.println(ls + " size: " + ls.size());
        System.out.println(ls.deleteValue(5));
        System.out.println(ls + " size: " + ls.size());
        for (Object el : ls)
            System.out.println(el);
    }
    
}
