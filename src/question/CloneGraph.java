package question;

import beans.*;
import java.util.*;

/**
 * Created by siren0413 on 1/27/14.
 */
public class CloneGraph {
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        if(node == null) return null;
        UndirectedGraphNode root = null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode n = queue.poll();
            if(set.contains(n)) continue;
            set.add(n);
            UndirectedGraphNode cloned = null;
            if(map.containsKey(n)) cloned = map.get(n);
            else{
                cloned = new UndirectedGraphNode(n.label);
                map.put(n,cloned);
            }
            for(UndirectedGraphNode neighbor: n.neighbors){
                queue.add(neighbor);
                UndirectedGraphNode clonedNeighbor = null;
                if(map.containsKey(neighbor)) clonedNeighbor = map.get(neighbor);
                else{
                    clonedNeighbor = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor,clonedNeighbor);
                }
                cloned.neighbors.add(clonedNeighbor);
            }
            if(root == null) root = cloned;
        }
        return root;
    }
}
