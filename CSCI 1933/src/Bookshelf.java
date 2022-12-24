public class Bookshelf {
    private Book[] Books;
    private int number;
    private int nextEmpty;

    public Bookshelf(){
        Books = new Book[20];
        number = 20;
        nextEmpty = 0;
    }
    public Bookshelf(int number){
        this.number = number;
        Books = new Book[this.number];
        nextEmpty = 0;
    }
    public boolean add(Book newBook){
        if (nextEmpty < number) {
            if (Books[nextEmpty] == null) {
                Books[nextEmpty] = newBook;
                nextEmpty++;
                return true;
            }
        }
        return false;
    }
    public Bookshelf getBooksByAuthor(String author){
        int number = 0;
        for (int x = 0; x < this.number; x++){
            if (Books[x].getAuthor().equals(author)){
                number++;
            }
        }
        Bookshelf tempBookshelf = new Bookshelf(number) ;
        for (int x = 0; x < this.number; x++){
            if (Books[x].getAuthor().equals(author)){
                tempBookshelf.Books[x] = this.Books[x];
            }
        }
        return tempBookshelf;
    }
    public String toString(){
        String temp = "";
        for (int x = 0; x < number; x++){
            temp = temp + Books[x].getTitle() + ", " + Books[x].getAuthor() + ", " + Books[x].getRating() + "\n";
        }
        return temp;
    }
    public void sort(char sortBy){
        for (int y = 0; y < number; y++) {
            for (int x = 0; x < number; x++) {
                if (x != number - 1) {
                    if (Books[x].compareTo(Books[x + 1], sortBy) > 0) {
                        Book temp = new Book(Books[x + 1].getTitle(), Books[x + 1].getAuthor(), Books[x + 1].getRating());
                        Books[x + 1] = new Book(Books[x].getTitle(), Books[x].getAuthor(), Books[x].getRating());
                        Books[x] = new Book(temp.getTitle(), temp.getAuthor(), temp.getRating());
                    }
                }
            }
        }

    }
    public static void main(String[] args){
       /* Bookshelf bs = new Bookshelf(5);
        bs.add(new Book("Eragon", "Christopher Paolini", 10.0));
        bs.add(new Book("Eldest", "Christopher Paolini", 10.0));
        bs.add(new Book("Brisingr", "Christopher Paolini", 10.0));
        bs.add(new Book("Inheritance", "Christopher Paolini", 10.0));
        bs.add(new Book("Dracula", "Bram Stoker", 7.5));
        Bookshelf goodbooks = bs.getBooksByAuthor("Christopher Paolini");
        System.out.println(goodbooks);
        Bookshelf bs2 = new Bookshelf(5);
        bs2.add(new Book("Eragon", "Christopher Paolini", 10.0));
        bs2.add(new Book("The Fellowship of the Ring", "J.R.R. Tolkein", 10.0));
        bs2.add(new Book("Twilight", "Stephenie Meyer", 0.0));
        bs2.add(new Book("The Diary of a Wimpy Kid", "Jeff Kinney", 0.0));
        bs2.add(new Book("Dracula", "Bram Stoker", 7.5));
        bs2.sort('a');
        System.out.println(bs2);*/
        Bookshelf B = BookshelfReader.readBooksFromFile("bookinput.csv");
        B.sort('r');
        BookshelfReader.writeShelfToFile(B, "bookoutput.txt");
    }
}
