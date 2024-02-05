package Homework2;

import java.util.ArrayList;

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
        int fromIndex = vertices.indexOf(fromCity);
        int toIndex = vertices.indexOf(toCity);

        if (fromIndex >= 0 && toIndex >= 0 ) {
            edges[fromIndex][toIndex] = distance;
            edges[toIndex][fromIndex] = distance;
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
        int fromIndex = vertices.indexOf(fromCity);
        int toIndex = vertices.indexOf(toCity);

        if (fromIndex != -1 && toIndex != -1) {
            edges[fromIndex][toIndex] = 0;
            edges[toIndex][fromIndex] = 0;
        }
    }
}

//   public void BFS() {
    //        /* This method performs Depth-First Traversal with the help of a helper method
    //         * to print all of the vertices in the graph. If the graph is empty,
    //         * the method simply returns with nothing printed.*/
    //        if (isEmpty()) return;
    //        ArrayList<String> visited = new ArrayList<String>();
    //        System.out.print("Breadth-First Traversal: ");
    //        System.out.print(this.cities.get(0) + ", ");
    //        BFSHelper(visited, this.cities.get(0));
    //        System.out.println();
    //    } // end BFS
    //    void BFSHelper(ArrayList<String> visited, String city) {
    //        /* Recursive helper method for BFS. It uses a PriorityQueue data structure
    //         * and for loops to print out all of the neighbors of the current vertex.
    //         * For parameters, it takes in an ArrayList of visited cities, and the current vertex.*/
    //        
    //        PriorityQueue<String> q = new PriorityQueue<String>();
    //        
    //        int cityPos = this.cities.indexOf(city);
    //        for (int row = 0; row < this.am.length; row++) {
    //            
    //            if ((this.am[row][cityPos] > 0) && (visited.indexOf(this.cities.get(row)) == -1)) {
    //                
    //                if (visited.indexOf(this.cities.get(row)) == -1) {
    //                    System.out.print(this.cities.get(row) + ", ");
    //                    visited.add(city);
    //                    q.add(this.cities.get(row));
    //                }
    //            }
    //        }
    //        for (String str: q) {
    //            BFSHelper(visited, str);
    //        }
    //    } // end BFSHelper