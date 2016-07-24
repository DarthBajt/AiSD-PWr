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
public class Huffman {
    
    private static final int SIZE = 256;
    
    private static int [] getCharsFrequency(String s) {
        int [] ret = new int[SIZE];
        char [] chars = s.toCharArray();
        
        for (int i = 0; i < chars.length; ++i)
            ret[chars[i]]++;
        
        return ret;
    }
    
    public static Node createTrie (String string) {
        int [] freq = getCharsFrequency(string);
        
        PriorityQueue <Node> pq = new PriorityQueue <> ();
        for (char i = 0; i < SIZE; i++)
            if (freq[i] > 0)
                pq.add(new Node(i, freq[i], null, null));
        
        if (pq.size() == 1) {
            if (freq['\0'] == 0)
                pq.add(new Node('\0', 0, null, null));
            else
                pq.add(new Node('\1', 0, null, null));
        }
        
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            pq.add(new Node('\0', left.freq + right.freq, left, right));
        }
        
        return pq.poll();
    }
    
    private static void makeCodes (String [] codes, Node node, String s) {
        if (!node.isLeaf()) {
            makeCodes(codes, node.left, s + '0');
            makeCodes(codes, node.right, s + '1');
        }
        else
            codes[node.ch] = s;
    }
    
    public static String compress (String plain, Node trie) {
        String ret = "";
        String [] codes = new String[SIZE];
        
        char [] s = plain.toCharArray();
        
        makeCodes(codes, trie, "");
        for (int i = 0; i < s.length; ++i)
            ret += codes[s[i]];
        
        return ret;
    }
    
    public static String decompress (String cipher, Node trie) {
        String ret = "";
        for (int i = 0; i < cipher.length();) {
            Node node = trie;
            while (!node.isLeaf())
                node = cipher.charAt(i++) == '0' ? node.left : node.right;
            ret += node.ch;
        }
            
        return ret;
    }
}
