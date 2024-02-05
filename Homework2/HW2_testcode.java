package Homework2;

import java.util.Arrays;

public class HW2_testcode 
{ 
  
    public static void main(String args[]) 
    { 
  
        
        GraphOfCities graph1 = new GraphOfCities(); 

        String[] cities = {"Florence", "Columbia", "Charlotte", "Charleston", "Myrtle Beach"};
        int[][] distances = 
        {
            {0, 92,106, 136, 67},
            {92, 0, 80, 120, 152},
            {106, 80, 0, 209, 175},
            {136, 120, 209, 0, 95},
            {67, 152, 175, 95, 0}
        };
        GraphOfCities graph2 = new GraphOfCities(cities, distances); 
         
        //Graph 1 tests
        System.out.println("Graph 1");
        graph1.getSize();

        System.out.print("Columbia Neighbors: ");
        System.out.println(Arrays.toString(graph1.getNeighbors("Columbia")));
        
        System.out.print("Columbia Degree: ");
        System.out.println(graph1.getDegree("Columbia"));

        System.out.println("Graph Empty: " + graph1.isEmpty());
        
        System.out.println('\n');

        //Graph 2 tests
        System.out.println("Graph 2");
        graph2.getSize();

        System.out.print("Columbia Neighbors: ");
        System.out.println(Arrays.toString(graph2.getNeighbors("Columbia")));

        System.out.print("Columbia Degree: ");
        System.out.println(graph2.getDegree("Columbia"));

        System.out.println("Graph Empty: " + graph2.isEmpty());

        System.out.println('\n');

        // Update Graph 1

        graph1.addVertex("Florence");
        graph1.addVertex("Columbia");
        graph1.addVertex("Charlotte");
        graph1.addEdge("Florence", "Columbia", 92);
        graph1.addEdge("Florence", "Charlotte", 106);
        graph1.addEdge("Columbia", "Charlotte", 80);

        System.out.println("Updated Graph 1");
        graph1.printEdges();
        System.out.println();
        graph1.printVertices();
        System.out.println('\n');

        System.out.println("Updated Graph 2");
        graph2.printEdges();
        System.out.println();
        graph2.printVertices();

        graph1.deleteEdge("Columbia", "Charlotte");
        graph2.deleteEdge("Columbia", "Charlotte");

    } 
} 
