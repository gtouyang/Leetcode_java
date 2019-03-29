/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<int,UndirectedGraphNode> map = new HashMap<int,UndirectedGraphNode>();

        if(node == null){
            return null;
        }

        //复制第一个节点
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);

        map.add()

    }
}