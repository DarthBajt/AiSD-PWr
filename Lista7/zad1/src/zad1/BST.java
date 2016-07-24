/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author kamil
 */
public class BST {
    private Node _root;
    private final Comparator _comparator;
   
    private class Node {
        Object value;
        Node left, right, parent;
    
        public Node (Object value) {
            this.value = value;
        }
    }
    
    public BST (Comparator comparator) {
        _comparator = comparator;
        _root = null;
    }
    
    public void insert (Object ... values) {
        for (int i = 0; i < values.length; ++i)
            _root = insert(values[i], _root);
    }
    
    private Node insert (Object value, Node node) {
        if (node == null)
            node = new Node(value);
        else {
            int cmp = _comparator.compare(value, node.value);
            if (cmp < 0) {
                node.left = insert(value, node.left);
                node.left.parent = node;
            }               
            else if (cmp > 0) {
                node.right = insert(value, node.right);
                node.right.parent = node;
            }              
            else
                throw new DuplicateItemException(value.toString());
        }
        return node;
    }
    
    public Object max () {
       Node temp = _root;
       if (temp == null)
           return null;
       while (temp.right != null)
           temp = temp.right;
       return temp.value;
    }
    
    public Object min () {
       Node temp = _root;
       if (temp == null)
           return null;
       while (temp.left != null)
           temp = temp.left;
       return temp.value;
    }
    
    private Node search (Object value) {
        Node temp = _root;
        int cmp = 0;
        while (temp != null && (cmp = _comparator.compare(value, temp.value)) != 0)
            temp = cmp < 0 ? temp.left : temp.right;
       
        return temp;
    }
    
    private Node search (Object value, Node node) { // wersja rekurencyjna
        if (node == null)
            return null;
        int cmp = _comparator.compare(value, node.value);
        if (cmp < 0)
            node = search(value, node.left);
        else if (cmp > 0)
            node = search(value, node.right);
        return node;
    }

    public boolean find (Object value) {
        return search(value, _root) != null;
    }
    
    public boolean remove (Object value) {
        Node node = search(value);
        if (node == null)
            return false;
        remove(node);
        return true;
    }
    
    private Node remove (Node del) {
        Node node, temp;
        if (del.left == null || del.right == null)
            node = del;
        else
            node = sucessor(del);
        
        temp = node.left != null ? node.left : node.right;
        if (temp != null)
            temp.parent = node.parent;
        if (node.parent == null)
            _root = temp;
        else {
            if (node == node.parent.left)
                node.parent.left = temp;
            else
                node.parent.right = temp;
        }
        if (node != del)
                del.value = node.value;
        return node;
    }
       
    public List inOrder() {
        List list = new LinkedList();
        inOrder(_root, list);
        return list;
    }
    
    private void inOrder(Node node, List list) {
        if(node != null) {
            inOrder(node.left, list);
            list.add(node.value);
            inOrder(node.right, list);
        }
    }
    
    public List preOrder() {
        List list = new LinkedList();
        preOrder(_root, list);
        return list;
    }
    
    private void preOrder(Node node, List list) {
        if(node != null) {
            list.add(node.value);
            preOrder(node.left, list);
            preOrder(node.right, list);
        }
    }
    
    public List postOrder() {
        List list = new LinkedList();
        postOrder(_root, list);
        return list;
    }
    
    private void postOrder(Node node, List list) {
        if(node != null) {
            postOrder(node.left, list);
            postOrder(node.right, list);
            list.add(node.value);
        }
    }
    
    public List levelOrder() {
        Queue <Node> q = new LinkedList <>();
        q.add(_root);
        int i = 0;
        List list = new LinkedList();
        while (!q.isEmpty()) {
            Node node = q.poll();
            list.add(node.value);
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
        return list;
    }
    
    public List parents (Object value) {
        List list = new LinkedList();
        Node node = search(value);
        
        if (node == null)
            return null;
        while (node.parent != null) {
            list.add(node.parent.value);
            node = node.parent;
        }
        return list;
    }
    
    public Object sucessor (Object value) {
        Node node = sucessor(search(value));      
        return node != null ? node.value : null;
    }
    
    private Node sucessor (Node node) {
        if (node == null)
            return null;
        if (node.right != null) {
            node = node.right;
            while (node.left != null)
                node = node.left;
            return node;
        }
        else {
            Node parent = node.parent;
            Node temp = node;
            while (parent != null && temp == parent.right) {
                temp = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }
    
    public Object predecessor (Object value) {
        Node node = predecessor(search(value));      
        return node != null ? node.value : null;
    }
    
    private Node predecessor (Node node) {
        if (node == null)
            return null;
        if (node.left != null) {
            node = node.left;
            while (node.right != null)
                node = node.right;
            return node;
        }
        else {
            Node parent = node.parent;
            Node temp = node;
            while (parent != null && temp == parent.left) {
                temp = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }
}
