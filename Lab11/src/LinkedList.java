public class LinkedList<T extends Comparable<T>> implements
        Comparable<LinkedList<T>> {
    public Node<T> head;
    public int size;
    public LinkedList() {
        head = new Node<T>(null, null);
        size = 0;
    }
    // add()
    public boolean add(T element) {
        if (element == null) {
            return false;
        } else {
            Node<T> ptr = this.head;
            while (ptr.getNext() != null) {
                ptr = ptr.getNext();
            }
            ptr.setNext(new Node<T>(element, null));
            return true;
        }
    }
    // get()
    public T get(int index) {
        if (index < 0) {
            return null;
        }
        Node<T> ptr = this.head.getNext();
        int currentIndex = 0;
        while (ptr != null && currentIndex <= index) {
            if (currentIndex == index) {
                return ptr.getData();
            } else {
                ptr = ptr.getNext();
                currentIndex++;
            }
        }
        return null;
    }
    // isEmpty()
    public boolean isEmpty() {
        if (head.getNext() == null) return true;
        return false;
    }
    // size()
    public int size() {
        Node<T> ptr = this.head.getNext();
        int size=1;
        if (!this.isEmpty()){
            while(ptr.getNext() != null) {
                ptr = ptr.getNext();
                size++;
            }
            return size;
        }
        //return 0 if the list was empty
        return 0;
    }
    // clear()
    public void clear(){
        this.head = new Node<T>(null, null);
    }
    @Override
    public int compareTo(LinkedList<T> o) {
        return 0;
    }
    public String toString(){
        Node<T> cur = head;
        StringBuilder s = new StringBuilder();
        for (int i = 0; cur != null; cur = cur.getNext(), i++)
            s.append("Element ".concat(String.valueOf(i)).concat(": ").concat(String.valueOf(cur.getData())).concat("\n"));
        return s.toString();
    }
    // TODO: removeEvery()
    public void removeEvery(int n){
        int [][] arr = new int[4][5];
        int x = arr.length;
        int y = arr[0].length;
        System.out.println(x + y);
        if (n == 1) {
            head.setNext(null);
        } else if (n > 0) {
            int index = 0;
            Node<T> trailer = head;
            Node<T> ptr = head.getNext();
            while (ptr != null) {
                if (index == n - 1) {
                    trailer.setNext(ptr.getNext());
                } else {
                    trailer = ptr;
                }
                ptr = ptr.getNext();
                index = (index + 1) % n;
            }
        }
    }
    // TODO: extractGroupsOf()
    public LinkedList<LinkedList<T>> extractGroupsOf(int n) {
        return null;
    }
    // Main method for testing purposes.
    public static void main(String[] args) {}
}