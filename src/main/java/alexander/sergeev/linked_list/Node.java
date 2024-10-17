package alexander.sergeev.linked_list;

public class Node<T> {

    public T data;
    public org.w3c.dom.Node next;

    public Node(T data, org.w3c.dom.Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(T data) {
        this(data, null);
    }

    public String toString() {
        return "(" + data + ") => " + next;
    }
}