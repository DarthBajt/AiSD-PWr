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
        HashMap hs = new HashMap();
        hs.set("Kamil", 22);
        hs.set("Paweł", 20);
        hs.set("Dawid", 30);
        hs.set(10, 40);
        hs.set("Kamil", 24);
        
        System.out.println(hs.get("Kamil")); // 24
        System.out.println(hs.get("Paweł")); // 20
        System.out.println(hs.get("Dawid")); // 30
        System.out.println(hs.get(10)); // 40
        System.out.println(hs.size()); // 4
        System.out.println(hs.remove("Dawid")); // true
        System.out.println(hs.remove(13)); // false
        System.out.println(hs.get("Dawid")); // null
        System.out.println(hs.size()); // 3
    }
    
}
