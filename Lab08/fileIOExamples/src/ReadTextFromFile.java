import java.io.*;
import java.util.Scanner;

public class ReadTextFromFile {

    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new File("AboutJUC.txt"));

            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }

            reader.close();
        } catch (IOException ex) {
            System.out.println("File Error");
        }
    }
}
