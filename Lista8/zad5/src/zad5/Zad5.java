/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad5;

import java.util.PriorityQueue;

/**
 *
 * @author kamil
 */
public class Zad5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String plain = "Ala ma kota";
        
        // drzewo dziala jak w szyfrowaniu symetrycznym
        Node key = Huffman.createTrie(plain);
        
        String cipher = Huffman.compress(plain, key);
        
        System.out.println(Huffman.decompress(cipher, key));
        
    }
    
}
