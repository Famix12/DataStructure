import java.io.*;
import java.util.Scanner;

public class WriteToFile {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 10};

        try {
            PrintWriter writer = new PrintWriter("Result.txt");
            for (int i = 0; i < a.length; i++) {
                writer.println(a[i]);
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println("File Error");
        }
    }
}
