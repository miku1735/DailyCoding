Given a weighted, undirected and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.

 

Example 1:

Input:

Output:
4
Explanation:

The Spanning Tree resulting in a weight
of 4 is shown above.
Example 2:

Input:

Output:
5
Explanation:
Only one Spanning Tree is possible
which has a weight of 5.
 

Your task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function  spanningTree() which takes number of vertices V and an adjacency matrix adj as input parameters and returns an integer denoting the sum of weights of the edges of the Minimum Spanning Tree. Here adj[i] contains a list of lists containing two integers where the first integer a[i][0] denotes that there is an edge between i and a[i][0] and second integer a[i][1] denotes that the distance between edge i and a[i][0] is a[i][1].

Expected Time Complexity: O(ElogV).
Expected Auxiliary Space: O(V2).
 

Constraints:
2 ≤ V ≤ 1000
V-1 ≤ E ≤ (V*(V-1))/2
1 ≤ w ≤ 1000
Graph is connected and doesn't contain self loops & multiple edges.






class Node{
    int from;
    int to;
    int weight;
    Node(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
    public String toString(){
        return " " + this.from + " " + this.to + " " + this.weight +" ";
    }
}
class NodeCompare implements Comparator<Node>{
    public int compare(Node a, Node b){
        return a.weight-b.weight;
    }
}

class UnionFind{
    public static int find(int node, int[] parent){
        while(node != parent[node]) node = parent[node];
        return node;
    }
    public static void union(int node1, int node2, int[] parent, int[] rank){
        int parent1 = find(node1, parent);
        int parent2 = find(node2, parent);
        
        if(parent1 == parent2) return;
        
        if(rank[parent1] > rank[parent2]){
            parent[parent2] = parent1;
        }
        else if(rank[parent1] < rank[parent2]){
            parent[parent1] = parent2;
        }
        else{
            parent[parent1] = parent2;
            rank[parent2]++;
        }
    }
}

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        PriorityQueue<Node> q = new PriorityQueue<>(new NodeCompare());
        
        int[] parent = new int[V];
        int[] rank = new int[V];
        for(int i=0; i<V; i++){
            parent[i] = i;
        }
        
        
        for(int i=0; i<V;i++){
             for(int j=0;j<adj.get(i).size();j++){
                 q.add(new Node(i, adj.get(i).get(j).get(0),adj.get(i).get(j).get(1)));
             }
        }
        
        int result = 0;
        while(!q.isEmpty()){
            Node curr = q.poll();
            int parent1 = UnionFind.find(curr.from, parent);
            int parent2 = UnionFind.find(curr.to, parent);
            if(parent1 == parent2) continue;
            UnionFind.union(curr.from, curr.to, parent, rank);
            result += curr.weight;
        }
        return result;
    }
}