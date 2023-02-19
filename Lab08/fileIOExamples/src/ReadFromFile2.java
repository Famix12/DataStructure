import java.io.*;
import java.util.Scanner;

public class ReadFromFile2 {

    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new File("AboutJUC.txt"));

            reader.useDelimiter("[\\p{Punct}\\s]+");

            while (reader.hasNext()) {
                System.out.println(reader.next());
            }

            reader.close();
        } catch (IOException ex) {
            System.out.println("File Error");
        }
    }
}
