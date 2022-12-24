//Written by Elaine Cui and Adam Liu
//CUI00122 and LIU02390
public class LinkedList<T extends Comparable<T>> implements List<T> {
    private boolean isSorted;
    private Node<T> head;
    private int length;
    //create attributes for the class to keep track of the node
    public LinkedList() {
        //constructor
        head = new Node<T>(null, null);
        isSorted = true;
        length = 0;
    }
    //add an element to the end of a list
    public boolean add(T element) {
        Node<T> newElement = new Node<T>(element, null);
        Node<T> ptr = head;
        //return false if element is null
        if (element == null) {
            return false;
        } else {
            while (ptr.getNext() != null) {
                ptr = ptr.getNext();
            }
            //add element to the end of the list
            ptr.setNext(newElement);
            //check if the list is sorted
            if (ptr.getData() != null && newElement.getData().compareTo(ptr.getData()) < 0){
                isSorted = false;
            }
            length += 1;
            return true;
        }
    }
    //add an element at a specific index within the list and shift the element and subsequent elements to the right
    public boolean add(int index, T element) {
        Node<T> newElement = new Node<T>(element, null);
        Node<T> ptr = head.getNext();
        Node<T> trailer = head;
        //return false if element is null or index is out-of-bounds
        if (element == null || index < 0 || index > length - 1) {
            return false;
        } else {
            //iterate through the linked list until the desired index is reached
            int count = 0;
            while (ptr != null && count < index) {
                ptr = ptr.getNext();
                trailer = trailer.getNext();
                count += 1;
            }
            //add element to the proper position and shift the element originally in that position to the right
            newElement.setNext(ptr);
            trailer.setNext(newElement);
            //check if the list is sorted
            if (trailer.getData() != null && newElement.getData().compareTo(trailer.getData()) < 0){
                isSorted = false;
            }
            if (ptr.getData() != null && newElement.getData().compareTo(ptr.getData()) > 0) {
                isSorted = false;
            }
        }
        length += 1;
        return true;
    }
    //remove all elements from the list
    public void clear() {
        for (int i = 0; i < length; i++) {
            head.setNext(null);
        }
        //update isSorted
        isSorted = true;
        length = 0;
    }
    //If isSorted is true, uses the ordering of the list to increase the efficiency of the search.
    //return the element at a given index
    public T get(int index) {
        //more efficient because program does not need to go through entire list if it is sorted
        if (isSorted) {
            //return null if index is out-of-bounds
            if (index < 0 || index > length - 1) {
                return null;
            } else {
                Node<T> ptr = head.getNext();
                int count = 0;
                //iterate through the list until the desired index is reached
                while (count < index) {
                    //get the value of the element at the index
                    ptr = ptr.getNext();
                    count++;
                }
                return ptr.getData();
            }
        }
        //return null if index is out-of-bounds
        if (index < 0 || index > length - 1) {
            return null;
        } else {
            Node<T> ptr = head.getNext();
            int count = 0;
            //iterate through the list until the desired index is reached
            while (count < index) {
                //get the value of the element at the index
                ptr = ptr.getNext();
                count++;
            }
            return ptr.getData();
        }
    }
    //return the first index of element
    public int indexOf(T element) {
        int index = 0;
        Node<T> ptr = head.getNext();
        //if list is sorted, compiler will use this to be more efficient
        if(isSorted()){
            while (ptr != null) {
                if (ptr.getData().equals(element)) {
                    //return the index of the desired element
                    return index;
                }
                index++;
                ptr = ptr.getNext();
            }
        }
        //iterate through the list until the desired element is reached
        while (ptr != null) {
            if (ptr.getData().equals(element)) {
                //return the index of the desired element
                return index;
            }
            index++;
            ptr = ptr.getNext();
        }
        //returns 01 if the element is null or not in the list
        return -1;
    }
    //returns true if the list is empty (length is 0)
    public boolean isEmpty() {
        if (length == 0) {
            return true;
        } else {
            return false;
        }
    }
    //return the size of the list
    public int size() {
        return length;
    }
    //sort the linked list using bubble sort
    public void sort() {
        if (!isSorted) {
            Node<T> ptr = head.getNext();
            Node<T> index = ptr.getNext();
            T temp;
            boolean swapped = true;
            for (int looper = 0; looper < size() && swapped == true; looper++){
                swapped = false;
                while (ptr.getNext() != null && index.getData() != null){
                    if (ptr.getData().compareTo(index.getData()) >= 0){
                        swapped = true;
                        temp = ptr.getData();
                        ptr.setData(index.getData());
                        index.setData(temp);
                    }
                    ptr = ptr.getNext();
                    index = index.getNext();
                }
                ptr = head.getNext();
                index = ptr.getNext();
            }
            //update isSorted
            isSorted = true;
        }
    }
    //remove whatever is at a given index and return the value
    public T remove(int index) {
        Node<T> ptr = head.getNext();
        Node<T> trailer = head;
        //return null if index is out-of-bounds
        if (index < 0 || index > length - 1) {
            return null;
        } else {
            //iterate through the list until the desired index is reached
            int count = 0;
            while (ptr != null && count < index) {
                ptr = ptr.getNext();
                trailer = trailer.getNext();
                count++;
            }
            T temp = ptr.getData();
            //remove the element at the index
            ptr.setData(null);
            trailer.setNext(ptr.getNext());
            length--;
            //update isSorted accordingly
            if (length == 1) {
                isSorted = true;
            }
            if (!isSorted) {
                //updates whether the list is sorted based on the removing
                Node<T> ptr2 = head.getNext();
                Node<T> trailer2 = head;
                for (int i = 0; i < length - 1; i++) {
                    //iterates through entire list
                    ptr2 = ptr2.getNext();
                    trailer2 = trailer2.getNext();
                    if (ptr2.getData() != null && trailer2.getData().compareTo(ptr2.getData()) <= 0) {
                        //the list is sorted because all in order
                        isSorted = true;
                    } else {
                        isSorted = false;
                        break;
                    }
                }
            }
            //return the value at the given index
            return temp;
        }
    }
    //remove all elements not equal to a given element
    public void equalTo(T element) {
        //remove all elements when list is sorted
        //only needs to find the desired element at the first index it appears and onward
        //do not need to iterate through the whole linked list
        if (isSorted) {
            Node<T> ptr = head.getNext();
            int counter = indexOf(element);
            int count = 0;
            while (get(counter).equals(element)) {
                counter++;
                count++;
            }
            clear();
            for (int i = 0; i < count; i++) {
                ptr.setData(element);
            }
        } else {
            if (element != null) {
                Node<T> ptr = head.getNext();
                Node<T> trailer = head;
                //iterate through the list
                while (ptr.getNext() != null) {
                    //remove the element if not equal
                    if (ptr.getData().compareTo(element) != 0) {
                        ptr = ptr.getNext();
                        trailer.setNext(ptr);
                        length--;
                    } else{
                        ptr = ptr.getNext();
                        trailer = trailer.getNext();
                    }
                }
                if (ptr.getData() != null) {
                    if (ptr.getData().compareTo(element) != 0) {
                        trailer.setNext(null);
                        length--;
                    }
                }
                //update isSorted
                isSorted = true;
            }
        }
    }
    //reverse the list
    public void reverse() {
        Node<T> trailer = head.getNext();
        Node<T> ptr = head.getNext().getNext();
        //iterate through the list
        while (ptr != null) {
            //reverse the elments
            trailer.setNext(ptr.getNext());
            ptr.setNext(head.getNext());
            head.setNext(ptr);
            ptr = trailer.getNext();
        }
        //update isSorted
        if (length == 1) {
            isSorted = true;
        }
        if (!isSorted) {
            //check whether reversing the linked link made the list sorted or not
            Node<T> new1 = head.getNext();
            Node<T> new2 = head;
            for (int i = 0; i < length - 1; i++) {
                //iterates through the entire list
                new1 = new1.getNext();
                new2 = new2.getNext();
                if (new1.getData() != null && new2.getData().compareTo(new1.getData()) <= 0) {
                    isSorted = true;
                } else {
                    isSorted = false;
                    break;
                }
            }
        }
    }

    public void merge(List<T> otherList) {
        //adds two lists together so that the lists are also sorted
        LinkedList<T> other = (LinkedList<T>) otherList;
        sort();
        otherList.sort();
        Node<T> myP = head;
        Node<T> otherP = other.head;
        Node<T> myTemp;
        while (otherP != null && otherP.getNext() != null){
            //loop until through all of the original list
            if (myP.getNext() != null && myP.getNext().getData().compareTo(otherP.getNext().getData()) > 0){
                //occurs when valid and when the data in the other list should be alphabetically in front of the data in the original list
                Node<T> tempNode=new Node<T>(otherP.getNext().getData(),null);
                //create new node to carry data from other list
                myTemp = myP.getNext();
                tempNode.setNext(myTemp);
                myP.setNext(tempNode);
                otherP = otherP.getNext();
                //set the data from the other list into the original list
                length = length+1;
            } else {
                if( myP.getNext() != null )
                {
                    //otherwise will iterate until alphabetically bigger
                    myP = myP.getNext();
                }
                else {
                    //adds the rest of the list at the end
                    Node<T> tempNode=new Node<T>(otherP.getNext().getData(),null);
                    myP.setNext(tempNode);
                    otherP=otherP.getNext();
                    length = length+1;
                }
            }
        }
    }
    //go through the list and take the elements in groups of two and swap them
    public void pairSwap() {
        if (size() >= 2) {
            Node<T> ptr = head.getNext().getNext();
            Node<T> trailer = head.getNext();
            //iterate through the list and swap the elements at the two positions
            for (int counter = 0; counter < size() - 3; counter = counter + 2) {
                T temp1;
                temp1 = trailer.getData();
                trailer.setData(ptr.getData());
                ptr.setData(temp1);
                ptr = ptr.getNext().getNext();
                trailer = trailer.getNext().getNext();
            }
            T temp2;
            temp2 = trailer.getData();
            trailer.setData(ptr.getData());
            ptr.setData(temp2);
        }
        //update isSorted accordingly
        if (length == 1) {
            isSorted = true;
        }
        Node<T> new1 = head.getNext();
        Node<T> new2 = head;
        for (int i = 0; i < length - 1; i++) {
            //iterate through entire list
            new1 = new1.getNext();
            new2 = new2.getNext();
            if (new1.getData() != null && new2.getData().compareTo(new1.getData()) <= 0) {
                isSorted = true;
            } else {
                isSorted = false;
                break;
            }
        }
    }

    public String toString() {
        String temp = "";
        Node<T> ptr = head;
        for (int i = 0; i < length; i++) {
            temp = temp + ptr.getData() + "\n";
        }
        return temp;
    }
    //return isSorted
    public boolean isSorted() {
        return isSorted;
    }
}