public class Node {
    public Node() {}
    public Node(int n, Node ptr) {
        data = n;
        next = ptr;
    }
    private int data;
    private Node next;
    public int getData() {
        return data;
    }
    public void setData(int n) {
        data = n;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node ptr) {
        next = ptr;
    }
}