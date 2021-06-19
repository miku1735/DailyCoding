

// Topological sort
class GraphNode {
    int V;
    int W;
    GraphNode(int V, int W){
        this.V = V;
        this.W = W;
    }
}
class Sort implements Comparator<GraphNode>{
    public int compare(GraphNode a, GraphNode b){
        return a.W - b.W;
    }
}

class TestClass {

    public void minDistanceDijkstra(int N, List<GraphNode>[] Graph){
        int[] weight = new int[N+1];
        Arrays.fill(weight,Integer.MAX_VALUE);
        Queue<GraphNode> q = new PriorityQueue(new Sort());
        weight[1] = 0;
        q.add(new GraphNode(1,0));
        boolean[] visited = new boolean[N+1];
        while(!q.isEmpty()){
            GraphNode node  = q.poll();
            if( visited[node.V] ) continue;                  
            visited[node.V] = true;
            for(GraphNode adj : Graph[node.V]){
                if((node.W + adj.W) < weight[adj.V]){
                    weight[adj.V] = (node.W + adj.W);
                    q.add(new GraphNode(adj.V,node.W + adj.W));
                }
            }
        }
        for(int p = 2; p < weight.length;p++){
           System.out.print(weight[p]+" ");     
        }
    }

    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        List<GraphNode>[] Graph = new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            Graph[i] = new ArrayList();
        }
        while(M-->0){
            int a = s.nextInt();
            int b = s.nextInt();
            int w = s.nextInt();
            Graph[a].add(new GraphNode(b, w));
            Graph[b].add(new GraphNode(a, w));
        }
        new TestClass().minDistanceDijkstra(N,Graph);
    }
}