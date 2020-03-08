package arithgram.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * 普利姆算法代码实现
 */
public class Prim {
    public static void main(String[] args) {
        Set<GraphNode> nodes = GraphNode.getGraphNodes();
        int[][] nodeDis = GraphNode.getNodeDis();

        for (GraphNode temp : nodes) {
            // 把每个节点都当做开头试试，结果是一样的。
            prim(nodes, nodeDis, temp);
        }
    }

    public static void prim(Set<GraphNode> nodes, int[][] nodeDis, GraphNode start) {
        // 已连接的点的集合
        Set<GraphNode> linkedNodes = new HashSet<>();
        // 添加起始点
        linkedNodes.add(start);
        System.out.println("连接方式如下：");
        while (linkedNodes.size() < nodes.size()) {// 只要没有全部连接起来就执行
            getMinDis(nodes, nodeDis, linkedNodes);
        }
    }

    public static void getMinDis(Set<GraphNode> nodes, int[][] nodeDis, Set<GraphNode> linkedNodes) {
        GraphNode nodeA = null;
        GraphNode nodeB = null;
        int minDis = Integer.MAX_VALUE;
        // 找到   距离已有点最近的点
        // 这里不能传nodes，因为nodes是所有节点的集合，而我们是要在已连接的点再找下个最短距离连接点
        // for (GraphNode tmpNode : nodes) {
        // 所有要传入linkedNodes，为已连接的点集合
        for (GraphNode tmpNode : linkedNodes) {
            // 注意这是二维数组
            for (int i = 0; i < nodeDis[tmpNode.getIndex()].length; i++) {
                // 二维数组中已经存了点与点之间的距离，直接取用即可
                int distance = nodeDis[tmpNode.getIndex()][i];
                GraphNode current = getNodeByInx(nodes, i);
                if (distance < minDis// 如果存在比最短路径还短的方案
                        // 并且这个点不是自己
                        && tmpNode.getIndex() != i
                        // 并且不能是已连接的点
                        && !linkedNodes.contains(current)) {
                    // 三者同时满足的话，则取出这两点
                    // 这里的赋值是为了把复合条件的两点传递出去，进行连接并放入Set集合
                    nodeA = tmpNode;
                    nodeB = current;
                    // 更新最短距离
                    minDis = distance;
                }
            }
        }
        System.out.println("点1：" + nodeA.getVal() + "--->点2：" + nodeB.getVal());
        nodeA.getNeighbor().add(nodeB);
        nodeB.getNeighbor().add(nodeA);
        linkedNodes.add(nodeB);
    }

    public static GraphNode getNodeByInx(Set<GraphNode> nodes, int idx) {
        for (GraphNode node : nodes) {
            if (node.getIndex() == idx) return node;
        }
        return null;
    }
}
