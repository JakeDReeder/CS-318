package Homework2;

public class HW2_testcode2 
{ 
  
    public static void main(String args[]) 
    { 

        String[] cities = {"Florence", "Columbia", "Charlotte", "Charleston", "Myrtle Beach"};
        int[][] distances = 
        {
            {0, 92,106, 136, 67},
            {92, 0, 80, 120, 152},
            {106, 80, 0, 209, 175},
            {136, 120, 209, 0, 95},
            {67, 152, 175, 95, 0}
        };
        GraphOfCities graph = new GraphOfCities(cities, distances); 

        graph.DFS("Charlotte");
        graph.BFS("Charlotte");

    } 
} 
