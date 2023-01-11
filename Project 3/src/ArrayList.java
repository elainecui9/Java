//Written by Elaine Cui and Adam Liu
//CUI00122 and LIU02390
public class ArrayList<T extends Comparable<T>> implements List<T> {
    private T[] a;
    private boolean isSorted;
    private int tail;
    //create attributes for class that are needed to keep track of where in the array the list is at
    public ArrayList(){
        //constructor
        isSorted = true;
        a = (T[]) new Comparable[2];
        tail = 0;
    }
    public boolean add(T element){
        //adds element to the list at the end of the array
        if (element == null){
            //returns false if the element is null, doesn't work
            return false;
        }
        if (tail < a.length -1){
            //will grow the array if there is not enough space
            a[tail] = element;
        }else{
            a = growCopy();
            a[tail] = element;
        }
        if (tail != 0 && isSorted && a[tail-1] != null){
            if (element.compareTo(a[tail-1]) < 0){
                //checks if the array is not sorted or not, updates isSorted
                isSorted = false;
            }
        }
        tail++;
        return true;
    }

    public boolean add(int index, T element){
        //adds an element to the array at a specific index, pushing the remaining back an index
        if (element == null || index < 0 || index >= size()){
            //automatically returns false when not in bounds
            return false;
        }
        if (tail == a.length-1){
            //resizes array if not large enough to add another element
            a = growCopy();
        }
        T temp = a[index];
        a[index] = element;
        //set the element to the index provided
        T save;
        for (int current = index + 1; current < size() + 1; current = current + 2){
            //shift all elements in remaining indices to the next index
            save = a[current];
            a[current] = temp;
            temp = a[current + 1];
            a[current + 1] = save;
        }
        if (tail != 0 && isSorted ){
            if (index == 0 && a[index + 1] != null){
                if (element.compareTo(a[index + 1]) > 0){
                    //determines whether the list is sorted now after the addition of the element
                    isSorted = false;
                }
            }
            if (index - 1 >= 0) {
                if (element.compareTo(a[index - 1]) < 0 && element.compareTo(a[index + 1]) > 0 && a[index + 1] != null) {
                    //checks whether the previous compared to the next are in order
                    isSorted = false;
                }
            }
        }

        tail++;
        return true;
    }
    private T[] growCopy(){
        //method that will increase the size of the array to make a bigger array with the same elements within it
        T[] biggerA = (T[]) new Comparable[a.length * 2 + 1];
        System.arraycopy(a,0,biggerA,0, a.length);
        return biggerA;
    }

    public void clear(){
        //clears the array with all elements, resets isSorted, tail, and array to 2
        T[] tempArr = (T[]) new Comparable[2];
        a = tempArr;
        isSorted = true;
        tail = 0;
    }

    public T get(int index){
        //returns the element at the index
        if (index < 0 || index >= a.length){
            //checks if the index is within bounds
            return null;
        }
        return a[index];
    }

    //did not implement isSorted to make it more efficient
    public int indexOf(T element){
        //finds the index of the element
        if (element == null){
            return tail-1;
        }
        if (isSorted){
            //when the list is sorted, it will be more efficient since doesn't need to go through entire list
            for(int current = 0; current < size(); current++){
                if (a[current] != null) {
                    if (a[current].equals(element)) {
                        //will return the index when element is an actual element
                        return current;
                    }
                }
            }
        }
        for(int looper = 0; looper < size(); looper++){
            if (a[looper] != null) {
                if (a[looper].equals(element)) {
                    //will return the index when element is an actual element
                    return looper;
                }
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        //checks if the array is all nulls
        for (int looper = 0; looper < a.length; looper++){
            if (a[looper] != null){
                return false;
            }
        }
        return true;
    }

    public int size(){
        //returns the size of the array
        return tail;
    }

    public void sort(){
        //sorts the array using bubble sort
        boolean swapped = true;
        if (!isSorted) {
            //will only sort the list if the list is not already sorted
            for(int looper = 0; looper < size() && swapped == true ; looper++){
                swapped = false;
                for (int indx = 1; indx < size() - looper; indx++){
                    if (a[indx].compareTo(a[indx-1]) < 0){
                        swapped = true;
                        T temp = a[indx];
                        a[indx] = a[indx-1];
                        a[indx-1] = temp;
                    }
                }
            }
        }
        isSorted = true;
    }

    public T remove(int index){
        //removes the element at index, shifting remaining indices and updating isSorted
        if (index < 0 || index >= a.length){
            //checks if index needed is within bounds
            return null;
        }
        T element = a[index];
        a[index] = null;
        for (int current = index; current < a.length - 1; current++){
            //shifts remaining indices up
            a[current] = a[current+1];
        }
        tail = tail -1;
        if (tail == 1){
            //array is sorted when only one element in array
            isSorted = true;
        }
        if (!isSorted) {
            //only need to check when the original array was already not sorted
            for (int looper = 0; looper < size() && a[looper + 1] != null; looper++) {
                if (a[looper].compareTo(a[looper + 1]) <= 0){
                    //array is sorted when all elements are in order
                    isSorted = true;
                }else{
                    //breaks array because array is not sorted
                    isSorted = false;
                    break;
                }
            }
        }
        return element;
    }

    public void equalTo(T element){
        //removes all elements that are not the same as the parameter element
        if (isSorted){
            //removes all elements when the list is already sorted since only needs the specific element and onwards, more efficient
            int counter = 0;
            for(int current = 0; current < size(); current++){
                if (a[current] != null) {
                    if (a[current].equals(element)) {
                        //will return the index when element is an actual element
                        counter++;
                    }
                }
            }
            int count = 0;
            while (a[counter].equals(element)){
                counter++;
                count++;
            }
            //iterates through to find how many elements are equal
            clear();
            for (int looper = 0; looper < count; looper++){
                a[looper] = element;
                //create array with amount of elements
            }
        }else {
            for (int current = 0; current < size(); current++) {
                //when list is not sorted, needs to loop through entire list to remove all not equal elements, less efficient
                if (!a[current].equals(element)) {
                    T temp = a[current];
                    a[current] = null;
                    for (int looper = current; looper < a.length - 1; looper++){
                        //shifts remaining indices up
                        a[looper] = a[looper+1];
                    }
                    tail = tail -1;
                    isSorted = true;
                    current--;
                    //updates attributes
                }
            }
        }
    }

    public void reverse(){
        //reverses the entire array, updates whether it is sorted or not
        for (int current = 0; current < size() / 2; current++){
            //reverses the array by splitting array into 2 and switching the elements at corresponding indices
            T tempElement = a[current];
            a[current]= a[size()-current -1 ];
            a[size()- current - 1] = tempElement;
        }
        for (int looper = 0; looper < size() && a[looper + 1] != null; looper++) {
            //checks whether the array is sorted or not after the reversal
            if (a[looper].compareTo(a[looper + 1]) <= 0){
                isSorted = true;
            }else{
                isSorted = false;
                break;
            }
        }
    }

    public void merge(List<T> otherList){
        //merges two lists together, the new list will be sorted
        if (otherList != null && size() != 0){
            //checks if the otherList is a valid list to merge
            ArrayList<T> other = (ArrayList<T>) otherList;
            sort();
            otherList.sort();
            int x = size() + otherList.size();
            T[] tempArr = (T[]) new Comparable[x];
            //create a temp array with size big enough for both lists to fit
            int counter = 0;
            int myCount = 0;
            int otherCount = 0;
            while (tempArr[x-1] == null) {
                //continue looping until all indices in the new array are filled
                if (a[myCount] != null && other.a[otherCount] != null && a[myCount].compareTo(other.a[otherCount]) < 0) {
                    //adds all elements in the original list to be sorted
                    tempArr[counter] = a[myCount];
                    counter++;
                    myCount++;
                }
                if (a[myCount] != null && other.a[otherCount] != null && a[myCount].compareTo(other.a[otherCount]) >= 0) {
                    //adds all elements in the new list to be sorted
                    tempArr[counter] = other.a[otherCount];
                    counter++;
                    otherCount++;
                }
                if (counter < tempArr.length && a[myCount] == null){
                    //add the rest of the other list when the original list is already all added to the new list
                        tempArr[counter] = other.a[otherCount];
                        otherCount++;
                        counter++;
                    }
                if (counter < tempArr.length && other.a[otherCount] == null){
                    //add the rest of the original list when the other list is already all added to the new list
                    tempArr[counter] = other.a[myCount];
                    otherCount++;
                    counter++;
                }
            }
            a = tempArr;
            tail = tail + otherList.size();
            isSorted = true;
            //update attributes
        }
    }

    public void pairSwap(){
        //swaps two elements down the array
        for(int current = 0; current < size() - 1; current = current + 2){
            //use temp variables to save positions and set new elements while going through the whole list
            T temp = a[current];
            a[current] = a[current + 1];
            a[current + 1] = temp;
        }
    }

    public String toString(){
        //creates a string that will add all the elements in the array
        String temp = "";
        for(int current = 0; current < a.length; current++){
            temp = temp + a[current] + "\n";
        }
        return temp;
    }

    public boolean isSorted(){
        //returns whether the array is sorted or not
        return isSorted;
    }
}
