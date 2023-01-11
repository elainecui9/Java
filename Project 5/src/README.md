<b>Project 5</b> focuses on hash tables. I implemented hash table solutions to two common situations (general - unknown data, and specific - known data) with the goal of minimizing the number of key collisions.

<b>Classes Modified By Me:</b>
<ul><li>HashTable.java</li></ul>

<b>Classes Given By Class: </b>
<ul><li>NGen.java</li>
<li>gettysburg.txt</li>
<li>keywords.txt</li></ul>


<b>HashTable.java:</b>

A HashTable was created with three different hash functions to determine what was the best for general or specific cases. General cases are unkown data while specific cases are known data (I knew how many different words there were). In this class, I analyzed which hash functions performed better, eventually choosing the one that would cause the least collisions for both cases. The class also displays information about the hash table like number of unique words, empty indices, nonempty indices, average collision length, and length of longest chain. 

<b>NGen.java:</b>

This class is a supporting class for linked lists.

<b>gettysburg.txt & keywords.txt</b>

These files contain the words that are used in the HashTable.java class to be hashed based on the hash functions. 