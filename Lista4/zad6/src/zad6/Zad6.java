/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad6;

/**
 *
 * @author kamil
 */
public class Zad6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DrowningStack ds = new DrowningStack(5);
        ds.push(1);
        ds.push(2);
        ds.push(3);
        ds.push(4);
        ds.push(5);
        ds.push(6);
        ds.push(7);
        ds.push(8);
        ds.push(9);
        ds.push(10);
        ds.push(11);
        System.out.println(ds.size());
        System.out.println(ds.pop());
        System.out.println(ds.pop());
        System.out.println(ds.pop());
        System.out.println(ds.pop());
        System.out.println(ds.pop());
        System.out.println(ds.isEmpty());
    }
    
}
