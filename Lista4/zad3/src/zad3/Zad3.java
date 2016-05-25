/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

/**
 *
 * @author kamil
 */
public class Zad3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack st = new Stack();
        
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);        
        st.push(5);
        st.push(6);
        st.push(7);
        st.push(8);
        st.push(9);
        st.push(10);
        st.push(11);
        
        System.out.println("Size: " + st.size());
        System.out.println("Capacity: " + st.capacity());
        
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        
        System.out.println("Size: " + st.size());
        System.out.println("Capacity: " + st.capacity());
        
        st.push(20);
        st.push(21);
        st.push(21);
        
        System.out.println("Size: " + st.size());
        System.out.println("Capacity: " + st.capacity());
        
    }
    
}
