/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad4;

import java.util.ArrayList;

/**
 *
 * @author kamil
 */
public class Zad4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList <Point> points = new ArrayList <> ();
       
        points.add(new Point(2, 4));
        points.add(new Point(3, 5));
        points.add(new Point(3, 3));
        points.add(new Point(4, 6));
        points.add(new Point(4, 4));
        points.add(new Point(4, 2));
        points.add(new Point(5, 5));
        points.add(new Point(5, 3));
        points.add(new Point(6, 4));
        
        System.out.println((new Graham(points)).getConvexHull());
    }
    
}
