import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class BookshelfReader {
    public static Bookshelf readBooksFromFile(String fileName) {
        Scanner s = null;
        try {
            s = new Scanner(new File(fileName));
        } catch (Exception e) {
            System.out.println("Exception found");
            return null;
        }
        File f = new File(fileName);
        int numLines = 0;
        while(s.hasNextLine()){
            numLines++;
            String string = s.nextLine();
        }
        Bookshelf B = new Bookshelf(numLines);
        File f2 = new File(fileName);
        try {
            s = new Scanner(new File(fileName));
        } catch (Exception e) {
            System.out.println("Exception found");
            return null;
        }
        for (int x = 0 ; x < numLines; x++){
            String y = s.nextLine();
            String[] tempa = y.split(",");
            B.add(new Book(tempa[0], tempa[1], Double.parseDouble(tempa[2])));
        }
        s.close();
        return B;
    }
    public static void writeShelfToFile(Bookshelf b, String fileName){
        PrintWriter p = null;
        try {
            p = new PrintWriter(new File(fileName));
            p.println(b);
            p.close();
        } catch (Exception e) {
            System.out.println("Exception found");
        }

    }
}
