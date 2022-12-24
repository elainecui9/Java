public class HackStack <T extends Comparable<T>> {
    private Node<T> head = new Node<T> (null, null);
    private Node<T> ptr = head.getNext();

    public void push(T element){
        ptr = new Node<T> (element, null);
    }
    public T pop(){
        if (head.getNext() == null){
            return null;
        }
        head = head.setNext();
    }
    public T pop(int n){

    }
    public T peek(){

    }
}
