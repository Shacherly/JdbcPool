package arithgram;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Node<T> {
    private Node<T> previous;
    private T obj;
    private Node<T> next;

    // link to the last node and return an header
    public Node<T> link(Node<T> node) {
        if (node == null) {
            return this;
        }
        Node<T> tmp = this;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
        }
        tmp.setNext(node);
        return this;
    }

    // get a link's head without next node
    public Node<T> getCurrentOnly() {
        return new Node<>(this.getObj());
    }

    public Node(T obj) {
        this.obj = obj;
    }




    /**
     * @auther shiZehao
     * @date 00:25 01/18/2020
     * @description the regular for recurse
     *      1、provide a break point to avoid recursing infinitely;
     *      2、do the recursive body;
     *      3、return the result.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getObj().toString());
        if (getNext() == null) {
            return sb.toString();
        }
        sb.append(" >>> ").append(getNext().toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(1);
        n1.link(new Node<>(3)).link(new Node<>(5)).link(new Node<>(7));
        n1.link(new Node<>(9));
        System.out.println(n1);
    }
}
