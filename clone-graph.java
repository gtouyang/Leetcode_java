/*
Question:

Clone an undirected graph. Each node in the graph contains alabeland a list of itsneighbors.
OJ's undirected graph serialization:
Nodes are labeled uniquely.

*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

import java.util.*;

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<Integer,UndirectedGraphNode> map = new HashMap<Integer,UndirectedGraphNode>();

        if(node == null){
            return null;
        }

        //复制第一个节点
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);

        //将其映射放入map中
        map.put(clone.label, clone);

        //建立一个队列，该队列中的结点已被部分克隆，即只克隆了label而没克隆neighbors
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);

        while(!queue.isEmpty()){
            UndirectedGraphNode originalnode = queue.remove();
            UndirectedGraphNode cloneNode = map.get(originalnode.label);

            for (int i = 0; i < originalnode.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = originalnode.neighbors.get(i);

                //如果邻居结点克隆过了
                if(map.get(neighbor.label) != null){
                    cloneNode.neighbors.add(map.get(neighbor.label));
                    continue;
                }

                //如果还没克隆，则把该邻居节点放入队列，并克隆一个新节点
                queue.add(neighbor);

                UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);

                map.put(newNode.label,newNode);

                cloneNode.neighbors.add(newNode);
            }
            
        }

        return clone;

    }
}