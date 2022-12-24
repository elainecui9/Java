public class List {
    public static void addToStart(Node ls, int item) {
        ls = new Node(item, ls);
    }
    public static void addToEnd(Node ls, int item) {
        if (ls == null) {
            return;
        }    else {
            while (ls.getNext() != null) {
                ls = ls.getNext();
            }
            ls.setNext(new Node(item, null));
        }
    }
    public static void printList(Node ls) {
        while (ls != null) {
            System.out.println(ls.getData());
            ls = ls.getNext();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node list1 = new Node(100, null);
        list1 = new Node(50, list1);
        System.out.println("List1 to start:");
        printList(list1);
        addToEnd(list1, 200);
        System.out.println("List1 after addToEnd:");
        printList(list1);
        addToStart(list1, 25);
        System.out.println("List1 after addToStart:");
        printList(list1);}}