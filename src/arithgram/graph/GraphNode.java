package arithgram.graph;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GraphNode {

    private String val;
    private int index;
    private List<GraphNode> neighbor;

    public GraphNode(String val, int index) {
        this.val = val;
        this.index = index;
        this.neighbor = new ArrayList<>();
    }


    public static Set<GraphNode> getGraphNodes() {
        GraphNode node1 = new GraphNode("A", 0);
        GraphNode node2 = new GraphNode("B", 1);
        GraphNode node3 = new GraphNode("C", 2);
        GraphNode node4 = new GraphNode("D", 3);
        GraphNode node5 = new GraphNode("E", 4);
        GraphNode node6 = new GraphNode("F", 5);
        GraphNode node7 = new GraphNode("G", 6);

        // 点的集合
        Set<GraphNode> nodes = new HashSet<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);
        nodes.add(node6);
        nodes.add(node7);
        return nodes;
    }

    public static int[][] getNodeDis() {
        // 点点之间的距离集合
        int max = Integer.MAX_VALUE;
        int[][] nodeDis = new int[][]{
                {0, 5, max, 13, max, max, 8},
                {5, 0, 6, max, max, max, 10},
                {max, 6, 0, max, max, 8, 4},
                {13, max, max, 0, 9, max, 11},
                {max, max, max, 9, 0, 9, 7},
                {max, max, 8, max, 9, 0, max},
                {8, 10, 4, 11, 7, max, 0}
        };
        return nodeDis;
    }
}
