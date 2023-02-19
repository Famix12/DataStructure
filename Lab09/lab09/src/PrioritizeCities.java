
import java.io.*;
import java.util.Scanner;

public class PrioritizeCities {

    public static void main(String[] args) {

        MinHeap<Association<Integer, String>> heap = new MinHeap<Association<Integer, String>>();

        int priority;
        String city;

        try {
            Scanner fs = new Scanner(new File("KSA_Cities.txt"));
            while (fs.hasNextLine()) {
                priority = fs.nextInt();
                city = fs.nextLine();
                heap.enqueue(new Association<Integer, String>(priority, city));
            }
            fs.close();
        } catch (IOException ex) {
            System.out.println("File Error");
        }

        while (!heap.isEmpty()) {
            System.out.println(heap.dequeue());
        }

    }
}
