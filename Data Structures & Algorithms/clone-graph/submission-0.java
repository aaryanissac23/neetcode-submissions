/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Node dfs(Node node , HashMap<Node , Node> Map){
        if(node == null) return node;
        if(Map.containsKey(node)){
            return Map.get(node);
        }
        Node copy = new Node(node.val);
        Map.put(node,copy);
        for(Node neigh : node.neighbors){
            copy.neighbors.add(dfs(neigh , Map));
        }
        return copy;
    }
    public Node cloneGraph(Node node) {
        HashMap<Node , Node> Map = new HashMap<>();
        return dfs(node , Map);
    }
}