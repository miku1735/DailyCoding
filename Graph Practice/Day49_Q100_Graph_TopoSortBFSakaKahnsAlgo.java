



// Topological Sort BFS as known as known as Kahn's algorithm



class Solution
{
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> list) 
    {
        int[] inDegree = new int[V];
        for(int i=0;i<V;i++){
            ArrayList<Integer> adj = list.get(i);
            for(int j = 0;j<adj.size();j++){
                inDegree[adj.get(j)]+=1;
            }
        }
        Queue<Integer> q = new LinkedList();
        for(int i=0;i<V;i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        List<Integer> res = new ArrayList();
        while(!q.isEmpty()){
            int node = q.poll();
            ArrayList<Integer> adj = list.get(node);
            res.add(node);
            for(int i = 0;i<adj.size();i++){
                inDegree[adj.get(i)]--;
                if(inDegree[adj.get(i)] == 0){
                    q.add(adj.get(i));
                }
            }
        }
        int[] result = new int[V];
        for(int i=0;i<res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }
}