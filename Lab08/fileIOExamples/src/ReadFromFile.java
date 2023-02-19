import java.io.*;
import java.util.Scanner;

public class ReadFromFile {

    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new File("Result.txt"));

            while (reader.hasNextInt()) {
                System.out.println(reader.nextInt());
            }

            reader.close();
        } catch (IOException ex) {
            System.out.println("File Error");
        }
    }
}
