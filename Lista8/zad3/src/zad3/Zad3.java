/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author kamil
 */
public class Zad3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ArrayList <Vertex> vertexes = new ArrayList <> ();
        ArrayList <Edge> edges = new ArrayList <> ();
        
        Vertex v1 = new Vertex(0);
        Vertex v2 = new Vertex(1);
        Vertex v3 = new Vertex(2);
        Vertex v4 = new Vertex(3);
        Vertex v5 = new Vertex(4);

        Edge e1 = new Edge(v1, v2, 1);
        Edge e2 = new Edge(v1, v3, 5);
        Edge e3 = new Edge(v2, v4, 9);
        Edge e4 = new Edge(v4, v5, 7);
        Edge e5 = new Edge(v3, v5, 2);
        Edge e6 = new Edge(v5, v1, 3);
        
        vertexes.addAll(Arrays.asList(v1, v2, v3, v4, v5));
        edges.addAll(Arrays.asList(e1, e2, e3, e4, e5, e6));
                
        Graph g = new Graph(vertexes, edges);
        System.out.println(g.dfs(v1));
        System.out.println(g.bfs(v1));
    }
    
}
