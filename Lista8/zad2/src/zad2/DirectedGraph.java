/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad2;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author kamil
 */
public class DirectedGraph {
    
    ArrayList <Vertex> vertices;
    ArrayList <Edge> edges;
  
    public DirectedGraph (ArrayList <Vertex> vertices, ArrayList <Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }
    
    public void addEdge (Edge e) {
        edges.add(e);
    }
    
    public void addVertex (Vertex v) {
        vertices.add(v);
    }
    
    public int [][] adjacencyMatrix () {
        int size = vertices.size();
        int [][] matrix = new int[size][size];
        for (Edge e : edges) {
            matrix[e.v1.number][e.v2.number] = 1;
            matrix[e.v2.number][e.v1.number] = -1;
        }
            
        return matrix;
    }
       
    public int[][] incidenceMatrix() {
        int [][] matrix = new int[vertices.size()][edges.size()];
        
        for (int i = 0; i < edges.size(); ++i) {
            Edge e = edges.get(i);
            matrix[e.v1.number][i] = 1;
            matrix[e.v2.number][i] = -1;
        }
        
        return matrix;
    }
     
    public LinkedList <Vertex>[] adjacencyList () {
        LinkedList <Vertex> [] ret = new LinkedList [vertices.size()];

        for (Edge e : edges) {
            if (ret[e.v1.number] == null)
                ret[e.v1.number] = new LinkedList();
            ret[e.v1.number].add(e.v2);
        }
        
        return ret;
    }
    
    public void printAdjacencyMatrix() {
        int [][] matrix = adjacencyMatrix();
        int size = matrix.length;
        
        System.out.println("Adjency Matrix");
        
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                System.out.printf("%2d ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void printIncidenceMatrix() {
        int [][] matrix = incidenceMatrix();
        
        System.out.println("Incidence Matrix");
        
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                System.out.printf("%2d ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void printAdjacencyList() {
        LinkedList <Vertex> [] arr = adjacencyList();
        System.out.println("Adjency List");
        
        for (int i = 0; i < arr.length; ++i)
            System.out.println(i + ": " + arr[i]);
        System.out.println();
    }

}
