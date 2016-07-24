/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad5;

/**
 *
 * @author kamil
 */
public class Node implements Comparable<Node> {
    char ch;
    int freq;
    final Node left, right;
    
    public Node (char ch, int freq, Node left, Node right) {
        this.ch = ch;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
    
    public boolean isLeaf () {
        return left == null && right == null;
    }
    
    @Override
    public int compareTo(Node o) {
        return freq - o.freq;
    }
}
