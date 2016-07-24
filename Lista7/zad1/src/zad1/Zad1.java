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
        BST bst = new BST(new IntComparator());
        bst.insert(10, 5, 11, 2, 6, 1, 3, 4, 7, 9, 8, 12, 13, 14, 17, 15, 16, 18, 19, 20);
        System.out.printf("Min: %d, max: %d\n", bst.min(), bst.max());
        System.out.println("In order: " + bst.inOrder());
        System.out.println("Pre order: " + bst.preOrder());
        System.out.println("Post order: " + bst.postOrder());
        System.out.println("Level roder: " + bst.levelOrder());
        System.out.println(bst.remove(21));
        System.out.printf("Sucessor(16): %d, Predecessor(15): %d\n", bst.sucessor(16), bst.predecessor(15));
        System.out.println(bst.parents(16));
    }
}
