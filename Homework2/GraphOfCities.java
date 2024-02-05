package Homework2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class GraphOfCities {

    private ArrayList<String> vertices;
    private int[][] edges;

    public GraphOfCities() {
        this.vertices = new ArrayList<>();
        this.edges = new int[16][16];
    }

    public GraphOfCities(String[] verts, int[][] edges) {
        this.vertices = new ArrayList<>();
        for (String city : verts) {
            this.vertices.add(city);
        }
        this.edges = edges;
    }

    // returns the size of the graph in number of vertices and edges
    public void getSize() {
        int count = 0;
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                if (edges[i][j] > 0) {
                    ++count;
                }
            }
        }
        System.out.println("Number of Cities: " + this.vertices.size());
        System.out.println("Number of Edges: " + count);
    }

    // returns the neighbors of a specific vertex.
    public String[] getNeighbors(String city) {
        ArrayList<String> neighbors = new ArrayList<>();
        int i = vertices.indexOf(city); // this method returns the index of an element. its pretty cool.

        if (i >= 0) {
            for (int j = 0; j < vertices.size(); j++) {
                if (edges[i][j] > 0) {
                    neighbors.add(vertices.get(j));
                }
            }
        }
        return neighbors.toArray(new String[0]);
    }

    // returns the degree of a certain vertex
    public int getDegree(String city) {
        int i = vertices.indexOf(city);
        int degree = 0;

        if (i >= 0) {
            for (int j = 0; j < vertices.size(); j++) {
                if (edges[i][j] != 0) {
                    ++degree;
                }
            }
        }

        return degree;
    }

    // returns true if empty
    public boolean isEmpty() {
        return vertices.isEmpty();
    }

    // Connects an edge from one city to another
    public void addEdge(String fromCity, String toCity, int distance) {
        int from = vertices.indexOf(fromCity);
        int to = vertices.indexOf(toCity);

        if (from >= 0 && to >= 0 ) {
            edges[from][to] = distance;
            edges[to][from] = distance;
        }
    }

    // Adds a new city/vertex to the graph
    public void addVertex(String newCity) {
        vertices.add(newCity);
        int newSize = vertices.size();

        if (newSize > edges.length) {
            // Resize the edges array
            int[][] newEdges = new int[newSize][newSize];

            for (int i = 0; i < edges.length; i++) {
                // Another cool method I needed in my life.
                System.arraycopy(edges[i], 0, newEdges[i], 0, edges[i].length);
            }

            edges = newEdges;
        }
    }

    // prints all the edges
    public void printEdges() {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                if (edges[i][j] > 0) {
                    System.out.println(vertices.get(i) + " -> " + vertices.get(j) + " (Distance: " + edges[i][j] + ")");
                }
            }
        }
    }

    // prints all the vertices
    public void printVertices() {
        for (String city : vertices) {
            System.out.println(city);
        }
    }

    // deletes an edge
    public void deleteEdge(String fromCity, String toCity) {
        int from = vertices.indexOf(fromCity);
        int to = vertices.indexOf(toCity);

        if (from != -1 && to != -1) {
            edges[from][to] = 0;
            edges[to][from] = 0;
        }
    }

    // Depth First Search
    public void DFS(String startCity) {
        //for making sure the method doesn't keep visiting the same vertices
        boolean[] visited = new boolean[vertices.size()];
        int start = vertices.indexOf(startCity);
        Stack<Integer> stack = new Stack<>();

        if (start >= 0) {
            stack.push(start);
            visited[start] = true;

            while (!stack.isEmpty()) {
                int current = stack.pop();
                System.out.print(vertices.get(current) + " ");

                for (int i = 0; i < vertices.size(); i++) {
                    if (edges[current][i] > 0 && !visited[i]) {
                        stack.push(i);
                        visited[i] = true;
                    }
                }
            }
        }
        System.out.println();
    }

    // Breadth First Search
    public void BFS(String startCity) {
        boolean[] visited = new boolean[vertices.size()];
        int start = vertices.indexOf(startCity);
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        if (start >= 0) {
            queue.offer(start);
            visited[start] = true;

            while (!queue.isEmpty()) {
                int current = queue.poll();
                System.out.print(vertices.get(current) + " ");

                for (int i = 0; i < vertices.size(); i++) {
                    if (edges[current][i] > 0 && !visited[i]) {
                        queue.offer(i);
                        visited[i] = true;
                    }
                }
            }
        }
        System.out.println();
    }

}

