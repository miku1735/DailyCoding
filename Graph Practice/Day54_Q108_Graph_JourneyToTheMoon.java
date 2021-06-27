



// Journey To the monitor

/**
 * The member states of the UN are planning to send  people to the moon. They want them to be from different countries. You will be given a list of pairs of astronaut ID's. Each pair is made of astronauts from the same country. Determine how many pairs of astronauts from different countries they can choose from.

Example



There are  astronauts numbered  through . Astronauts grouped by country are  and . There are  pairs to choose from:  and .

Function Description

Complete the journeyToMoon function in the editor below.

journeyToMoon has the following parameter(s):

int n: the number of astronauts
int astronaut[p][2]: each element  is a  element array that represents the ID's of two astronauts from the same country
Returns
- int: the number of valid pairs

Input Format

The first line contains two integers  and , the number of astronauts and the number of pairs.
Each of the next  lines contains  space-separated integers denoting astronaut ID's of two who share the same nationality.

Constraints

Sample Input 0

5 3
0 1
2 3
0 4
Sample Output 0

6
Explanation 0

Persons numbered  belong to one country, and those numbered  belong to another. The UN has  ways of choosing a pair:


Sample Input 1

4 1
0 2
Sample Output 1

5
Explanation 1

Persons numbered  belong to the same country, but persons  and  don't share countries with anyone else. The UN has  ways of choosing a pair:



 */

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    public static int DFS(int N, boolean[] visited,List<List<Integer>> adj){
        visited[N] = true;
        int res = 0;
        for(Integer a : adj.get(N)){
            if(!visited[a]){
               res += DFS(a, visited, adj);
            }
        }
        return res+1;
    }
    public static long journeyToMoon(int V, List<List<Integer>> astronout) {
        int count = 0;
        Stack<Integer> stack  = new Stack();
        boolean[] visited = new boolean[V];
        List<List<Integer>> adj = new ArrayList();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList());
        }
        for(List<Integer> l : astronout)
        {
            adj.get(l.get(0)).add(l.get(1));
            adj.get(l.get(1)).add(l.get(0));
        }
        // for(int i=0;i<V;i++)
        // {
        //     System.out.println(adj.get(i));
        // }
        List<Integer> countrySizes = new ArrayList(); 
        for(int i=0;i<V;i++)
        {
            if(!visited[i]){
                countrySizes.add(DFS(i, visited, adj));
            }
        }
        // System.out.print(countrySizes);
        int sum = 0;
        long result = 0;
        for(int size : countrySizes)
        {
            result += sum*size;
            sum += size;    
        } 
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
