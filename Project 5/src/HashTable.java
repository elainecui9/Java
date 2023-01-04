//Written by Elaine Cui and Adam Liu
//CUI00122 and LIU02390
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashTable<T>{
    NGen<T>[] hashTable;
    public String type = "general";
    //initialize attributes

    public HashTable(int length, String type) {
        //constructor to initialize the length of the hashTable and the type of hash function eventually used
        hashTable = new NGen[length];
        this.type = type;
    }

    public int hash1(T item) {
        /*This hash function is the most basic one we used. We took the first character of the item
        * and converted that into an integer then mod it to the hashTable size to find its index. This
        * hash function caused the longest chain to be 12 when the size of the hashTable was 150 for general cases.
        * Changing the hashTable size to 100 still resulted in the longest chain to be 12. This was the worst
        * performing hash function because it was only limited to the character's integer so it is not able
        * to reach very high numbers.*/
        String myString = item.toString();
        char c = myString.charAt(0);
        int i = (int) c;
        i = i % hashTable.length;
        return i;
    }

    public int hash2(T item) {
        /*This was the second hash function we implemented. The hash function takes the integer value of the
        * first and last characters of the item string. It then adds the two integers together to increase the
        * size potential for the index. We then mod it with the size of the hashTable. In the general case, the
        * length of the longest chain is 8 which is smaller than the first hash function. When the length
        * was set to 100, the longest chain was still 8.*/
        String myString = item.toString();
        char c1 = myString.charAt(0);
        char c2 = myString.charAt(myString.length() - 1);
        int i = (int) c1 + (int) c2;
        i = i % hashTable.length;
        return i;
    }

    public int hash3(T item){
        /*This was the final hash function we implemented. In this hash function, we took all the characters
        * and converted them into integers. We then added them together for the total sum of all the characters
        * in the item. We then mod that sum with the length of the hashTable. Through this hash function, we
        * were able to reduce the length of the longest chain to 6 for hashTable size of 150 and 7 for hashTable
        * size of 100. Comparing to the other two hash functions, this hash function is a lot better at removing
        * collisions because it is able to increase the size of the index before we mod it to the hashTable length.
        * This function is also the hash function that we found worked best for the specific and general case. We
        * found that even numbers and odd numbers functioned relatively the same amount for collision rate. For example
        * 133 and 134 both had the collision rate of 4. Prime numbers did increase the collision a little, for example
        * 139 had a collision rate of 6 while 140 had a collision rate of 5. */
        String myString = item.toString();
        int sum = 0;
        int i = 0;
        for (int index = 0 ; index < myString.length(); index++){
            char c = myString.charAt(index);
            int number = (int) c;
            sum = sum + number;
        }
        i = sum % hashTable.length;
        return i;
    }

    public void add(T item) {
        int i = 0;
        if (type.equals("general")){
            //this calls the hash function that is the best for the general case
            i = hash3(item);
        }
        if (type.equals("specific")){
            //this calls the hash function that is the best for the specific case
            i = hash3(item);
        }
        NGen<T> ptr = hashTable[i];
        while (ptr != null) {
            if (ptr.getData().equals(item)) {
                //if the specific index has duplicates within the linked node, it won't be added
                return;
            }
            ptr = ptr.getNext();
        }
        if (hashTable[i] != null){
            //when there is already a node in the index, we will add the new item into the hashTable using chaining
            NGen<T> newNode = new NGen<T>();
            newNode.setData(item);
            newNode.setNext(hashTable[i]);
            hashTable[i] = newNode;
        }
        if (hashTable[i] == null) {
            //when the hashTable has no node at the index yet, it will create a new node to start the chain
            hashTable[i] = new NGen<T>();
            hashTable[i].setData(item);
        }

    }

    // ** Already implemented -- no need to change **
    // Adds all words from a given file to the hash table using the add(T item) method above
    @SuppressWarnings("unchecked")
    public void addWordsFromFile(String fileName) {
        Scanner fileScanner = null;
        String word;
        try {
            fileScanner = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("File: " + fileName + " not found.");
            System.exit(1);
        }
        while (fileScanner.hasNext()) {
            word = fileScanner.next();
            word = word.replaceAll("\\p{Punct}", ""); // removes punctuation
            this.add((T) word);
        }
    }

    public void display() {
        /*Prints out the indices of the hashTable and the number of words that have been hashed at each specified index.
        * Prints out the total number of unique words, number of empty indices, number of nonempty indices, average
        * collision length, and length of the longest chain.*/
        int unique = 0; //counts the number of unique words
        int empty = 0; //counts the number of empty indices
        int longest = 0; //counts the length of the longest chain
        for (int index = 0 ; index < hashTable.length; index++){
            System.out.print(index + ": ");
            int length = 0;
            if (hashTable[index] == null){
                //checks whether the index is empty or not, updates empty
                empty++;
            }
            while (hashTable[index] != null){
                length++;
                unique++;
                //updates how many nodes there are, no duplicates so all are unique
                hashTable[index] = hashTable[index].getNext();
            }
            if (length > longest){
                //finds the longest chain based on the length at each index
                longest  = length;
            }
            System.out.println(length);
        }
        System.out.println("Number of unique words: " + unique);
        System.out.println("Number of empty indices: " + empty);
        System.out.println("Number of nonempty indices: " + (hashTable.length - empty));
        System.out.println("Average collision length: " + ((double)unique/(double)(hashTable.length - empty)));
        System.out.println("Length of longest chain: " + longest);
    }

    public static void main(String args[]) {
        //create a hash table that stores the words from "gettysburg.txt" (general) and displays it
        HashTable myHashTable1 = new HashTable<>(150, "general");
        myHashTable1.addWordsFromFile("gettysburg.txt");
        myHashTable1.display();
        //create a 2nd hash table that stores the words from "keywords.txt" (specific) and displays it
        HashTable myHashTable2 = new HashTable<>(500, "specific");
        myHashTable2.addWordsFromFile("keywords.txt");
        myHashTable2.display();
    }
}