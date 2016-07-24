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
public class Vertex implements Comparable <Vertex>{
    int number;
    Object data;
    
    public Vertex (int number) {
        this.number = number;
    }
    
    public Vertex (int number, Object data) {
        this(number);
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "" + number;
    }

    @Override
    public int compareTo(Vertex o) {
        return number - o.number;
    }
}
