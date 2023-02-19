import java.io.*;
import java.util.Scanner;

public class ReadAndWrite {

    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new File("Result.txt")); //open input file
            PrintWriter writer = new PrintWriter("Result2.txt");  //open output file

            while (reader.hasNextInt()) {
                int n = reader.nextInt();
                writer.println(n * n);
            }
            reader.close();
            writer.close();
        } catch (IOException ex) {
            System.out.println("File Error");
        }
    }
}
