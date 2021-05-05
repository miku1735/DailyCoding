import java.util.LinkedList;
import java.util.Scanner;

public class Day6_Q8_GraphImplementation {
    private LinkedList<Integer> adj[];
    public Day6_Q8_GraphImplementation(int v){
        adj = new LinkedList[v];
        for(int i = 0; i <v ;i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adj[source].add(destination);
        adj[destination].add(source);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices and edges");
        
        int v = sc.nextInt();
        int e = sc.nextInt();

        Day6_Q8_GraphImplementation graph = new Day6_Q8_GraphImplementation(v);

        for(int i=0;i<e;i++){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            graph.addEdge(source, destination);
        }
    }
}
