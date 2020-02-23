package arithgram;

public class Recurse {
    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        node1.link(node2).link(node3).link(node4).link(node5);
        System.out.println(node1);
        System.out.println(sum(node1));
    }

    /**
     * @auther shiZehao
     * @date 00:21 01/18/2020
     * @description get link's sum for by recursing
     */
    public static Integer sum(Node<Integer> node) {
        if (node == null) {
            return 0;
        }
        int result = node.getObj();
        result += sum(node.getNext());
        return result;
    }
}
