/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author kamil
 */
public class BST {
    private Node _root;

    private class DuplicateItemException extends RuntimeException {

        public DuplicateItemException() {
        }
    }
   
    private class Node {
        int value;
        Node left, right, parent;
    
        public Node (int value) {
            this.value = value;
        }
    }
    
    public BST () {
        _root = null;
    }
    
    public void insert (int ... inner) {
        for (int i = 0; i < inner.length; ++i)
            _root = insert(inner[i], _root);
    }
    
    private Node insert (int value, Node node) {
        if (node == null)
            node = new Node(value);
        else {
            int cmp = (value - node.value);
            if (cmp < 0) {
                node.left = insert(value, node.left);
                node.left.parent = node;
            }               
            else if (cmp > 0) {
                node.right = insert(value, node.right);
                node.right.parent = node;
            }              
            else
                throw new DuplicateItemException();
        }
        return node;
    }
    
    private int maxLevel(Node node) {
        if (node == null)
            return 0;
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }
          
    public void print() {
        Stack <Node> outer = new Stack();
        outer.push(_root);
        int spaces = (int) Math.pow(2, maxLevel(_root));
        boolean isRowEmpty = false;
        while(!isRowEmpty) {
            Stack <Node> inner = new Stack();
            isRowEmpty = true;
            for(int i = 0; i < spaces; i++)
                System.out.print(' ');
            while (!outer.isEmpty()) {
                Node temp = outer.pop();
                if (temp != null) {
                    System.out.printf("%d", temp.value);
                    inner.push(temp.left);
                    inner.push(temp.right);
                    if (temp.left != null ||temp.right != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("  ");
                    inner.push(null);
                    inner.push(null);
                }
                for (int i = 0; i < spaces*2 - 2; i++)
                    System.out.print(' ');
            }
            System.out.println();
            spaces /= 2;
            while(!inner.isEmpty())
                outer.push(inner.pop());
        }
    }  
}
