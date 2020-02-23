package arithgram;

public class MergeLink {
    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(1);
        n1.link(new Node<>(3)).link(new Node<>(5)).link(new Node<>(7).link(new Node<>(200)));
        // System.out.println(n1);
        Node<Integer> n2 = new Node<>(2);
        n2.link(new Node<>(100));
        // System.out.println(n2);
        System.out.println(mergeLink(n1, n2));

    }

    public static Node<Integer> mergeLink(Node<Integer> a, Node<Integer> b) {
        if (a == null) return b;
        if (b == null) return a;
        Node<Integer> rs = null;
        if (a.getObj() <= b.getObj()) {
            rs = new Node<>(a.getObj());
            a = a.getNext();
        } else {
            rs = new Node<>(b.getObj());
            b = b.getNext();
        }
        while (a != null && b != null) {
            if (a.getObj() <= b.getObj()) {
                rs.link(a.getCurrentOnly());
                a = a.getNext();
            } else {
                rs.link(b.getCurrentOnly());
                b = b.getNext();
            }
        }
        if (a == null && b != null) {
            rs.link(b);
        }
        if (b == null && a != null) {
            rs.link(a);
        }
        return rs;
    }
}
