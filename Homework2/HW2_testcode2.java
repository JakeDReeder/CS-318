package Homework2;

public class HW2_testcode2 
{ 
  
    public static void main(String args[]) 
    { 

        String[] cities = {"Florence", "Columbia", "Charlotte", "Charleston", "Myrtle Beach"};
        int[][] distances = 
        {
            {0, 92,106, 0, 0},
            {92, 0, 0, 120, 0},
            {106, 0, 0, 0, 0},
            {0, 120, 0, 0, 95},
            {0, 0, 0, 95, 0}
        };
        GraphOfCities graph = new GraphOfCities(cities, distances); 

        graph.DFS("Florence");
        graph.BFS("Florence");

    } 
} 
