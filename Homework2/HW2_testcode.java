package Homework2;

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
  
        graph1.getSize();
        graph2.getSize();


        graph1.getNeighbors("Columbia");
        graph2.getNeighbors("Columbia");
  

        graph1.getDegree("Columbia");
        graph2.getDegree("Columbia");

        graph1.isEmpty();
        graph2.isEmpty();


        graph1.addVertex("Florence");
        graph1.addVertex("Columbia");
        graph1.addVertex("Charlotte");
        graph1.addEdge("Florence", "Columbia", 92);
        graph1.addEdge("Florence", "Charlotte", 106);
        graph1.addEdge("Columbia", "Charlotte", 80);


        graph1.printEdges();
        graph1.printVertices();

        graph2.printEdges();
        graph2.printVertices();

        graph1.deleteEdge("Columbia", "Charlotte");
        graph1.deleteEdge("Columbia", "Charlotte");


        graph2.deleteEdge("Columbia", "Charlotte");
        graph2.deleteEdge("Columbia", "Charlotte");

    } 
} 
