package arithgram.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Kruskal {
    public static void main(String[] args) {
        Set<GraphNode> nodes = GraphNode.getGraphNodes();
        int[][] nodeDis = GraphNode.getNodeDis();


    }

    public static void kruskal(Set<GraphNode> nodes, int[][] nodeDis) {
        List<List<GraphNode>> linkedGraphNode = new ArrayList<>();// 部落的集合

        while (!(linkedGraphNode.size() == 1 && linkedGraphNode.get(0).size() == nodes.size())) {

        }
    }

    public static void getMinDis(
            Set<GraphNode> nodes,
            int[][] nodeDis,
            List<List<GraphNode>> linkedGraphNode) {
        // 找到最短的边   看看能否连接
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nodeDis.length; i++) {
            for (int j = 0; j < nodeDis[i].length; j++) {
                if (nodeDis[i][j] < min) {
                    GraphNode nodeA = getNodeByInx(nodes, i);
                    GraphNode nodeB = getNodeByInx(nodes, j);
                    List<GraphNode> aList = getNodeList(linkedGraphNode, nodeA);
                    List<GraphNode> bList = getNodeList(linkedGraphNode, nodeB);
                    if (!(aList != null && bList != null && aList == bList)) {

                    }
                }
            }
        }
    }

    public static GraphNode getNodeByInx(Set<GraphNode> nodes, int idx) {
        for (GraphNode node : nodes) {
            if (node.getIndex() == idx) return node;
        }
        return null;
    }

    public static List<GraphNode> getNodeList(
            List<List<GraphNode>> linkedGraphNode,
            GraphNode graphNode) {
        for (List<GraphNode> graphNodes : linkedGraphNode) {
            if (graphNodes.contains(graphNode)) return graphNodes;
        }
        return null;
    }
}
