/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author kamil
 */
public class Graph {
    
    ArrayList <Vertex> vertices;
    ArrayList <Edge> edges;
  
    public Graph (ArrayList <Vertex> vertices, ArrayList <Edge> edges) {
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
            matrix[e.v2.number][e.v1.number] = 1;
        }
            
        return matrix;
    }
    
    public int[][] incidenceMatrix() {
        int [][] matrix = new int[vertices.size()][edges.size()];
        
        for (int i = 0; i < edges.size(); ++i) {
            Edge e = edges.get(i);
            matrix[e.v1.number][i] = 1;
            matrix[e.v2.number][i] = 1;
        }
        
        return matrix;
    }
    
    public ArrayList <Vertex>[] adjacencyList () {
        ArrayList <Vertex> [] ret = new ArrayList [vertices.size()];

        for (Edge e : edges) {
            if (ret[e.v1.number] == null)
                ret[e.v1.number] = new ArrayList();
            if (ret[e.v2.number] == null)
                ret[e.v2.number] = new ArrayList();
            ret[e.v1.number].add(e.v2);
            ret[e.v2.number].add(e.v1);
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
        ArrayList <Vertex> [] arr = adjacencyList();
        System.out.println("Adjency List");
        
        for (int i = 0; i < arr.length; ++i)
            System.out.println(i + ": " + arr[i]);
        System.out.println();
    }
    
    public ArrayList <Vertex> dfs (Vertex source) {
        boolean [] marked = new boolean[vertices.size()];
        ArrayList <Vertex> path = new ArrayList <>(vertices.size());
        
        dfs(source, marked, path);
        
        return path;
    }
    
    private void dfs (Vertex vertex, boolean [] marked, ArrayList <Vertex> path) {
        marked[vertex.number] = true;       
        for (Vertex v : adjacencyList()[vertex.number])
            if (!marked[v.number]) {
                path.add(vertex);
                dfs(v, marked, path);
            }
    }
    
    public ArrayList <Vertex> bfs (Vertex source) {
        boolean [] marked = new boolean[vertices.size()];
        ArrayList <Vertex> path = new ArrayList <>(vertices.size());
        PriorityQueue <Vertex> pq = new PriorityQueue <> (vertices.size());
        
        pq.add(source);      
        marked[source.number] = true;
        
        while (!pq.isEmpty()) {
            Vertex v = pq.poll();
            for (Vertex w : adjacencyList()[v.number]) {
                if (!marked[w.number]) {
                    marked[w.number] = true;
                    pq.add(w);
                    path.add(w);
                }
            }
        }
        return path;
    }
    
    public ArrayList <Edge> kruskalMST () {
        
        ArrayList <Edge> mst = new ArrayList <> ();
        HashMap <Vertex, Set <Vertex>> forest = new HashMap <> ();
        
        for (Vertex v : vertices) {
            Set <Vertex> vs = new HashSet <> ();
            vs.add(v);
            forest.put(v, vs);
        }
        
        PriorityQueue <Edge> edges = new PriorityQueue(this.edges);
        
        while (true) {
            Edge edge = edges.poll();           
            Set <Vertex> visited1 = forest.get(edge.v1);
            Set <Vertex> visited2 = forest.get(edge.v2);
            
            if (visited1.equals(visited2))
                continue;
            
            mst.add(edge);
            visited1.addAll(visited2);
            
            for (Vertex v : visited1) {
                forest.put(v, visited1);
            }
            
            if (visited1.size() == vertices.size())
                break;
        }
               
        return mst;
    }
}
