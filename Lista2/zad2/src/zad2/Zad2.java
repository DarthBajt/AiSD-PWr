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
public class Zad2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentsList ls1 = new StudentsList();
        StudentsList ls2 = new StudentsList();
        
        ls1.add(new Student(1, "Kamil", "Kowalski"));
        ls1.add(new Student(4, "Damian", "Nowak"));
        ls1.add(new Student(5, "Michał", "Krakowski"));
        ls1.add(new Student(8, "Karol", "Lisiak"));
        
        ls2.add(new Student(2, "Tomasz", "Sikora"));
        ls2.add(new Student(3, "Adam", "Wróbel"));
        ls2.add(new Student(6, "Paweł", "Kolski"));
        ls2.add(new Student(7, "Piotr", "Wilk"));
        
        StudentsList ls = ls1.merge(ls2);
        for (Object s : ls)
            System.out.println(s);
    }
    
}
