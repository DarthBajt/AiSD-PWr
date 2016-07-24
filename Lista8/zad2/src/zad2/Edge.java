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
public class Edge implements Comparable <Edge> {
    Vertex v1, v2;
    int weight;
    
    public Edge (Vertex v1, Vertex v2) {
        this.v1 = v1;
        this.v2 = v2;
    }
    
    public Edge (Vertex v1, Vertex v2, int weight) {
        this(v1, v2);
        this.weight = weight;
    }

    @Override
    public int compareTo (Edge o) {
        return weight - o.weight;
    }
    
    public String toString() {
        return v1 + " --" + weight + "-- " + v2;
    }
}
