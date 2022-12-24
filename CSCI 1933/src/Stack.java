public class Stack <T extends Comparable<T>>{
    private int size;
    private T[] arr;
    private int pointer;

    Stack(){
        size = 5;
        arr = (T[]) new Comparable[5];
        pointer = 0;
    }
    Stack(int size){
        this.size = size;
        arr = (T[]) new Comparable[this.size];
        pointer = 0;
    }
    T pop() throws StackException{
        if (pointer == 0) {
            throw new StackException(size);
        }else{
                T data = arr[pointer];
                pointer = pointer - 1;
                return data;
        }
    }

    void push(T item) throws StackException{
        T[] biggerArray;
        if ( pointer >= arr.length-1) {
            throw new StackException(size);
        }
        arr[pointer] = item;
        pointer = pointer + 1;
        }
  
        
    
    public T[] getArray(){
        return arr;
    }
}
