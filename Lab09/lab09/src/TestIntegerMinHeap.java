
import java.util.Arrays;
import java.util.Scanner;

public class TestIntegerMinHeap {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        MinHeap<Integer> heap = new MinHeap<Integer>();
        Integer[] array;
        int option, n, size;

        do {
            System.out.print("\n1. Create a Binary Min-Heap (Top down)."
                    + "\n2. Create a Binary Min-Heap (Bottom up)."
                    + "\n3. Insert a key."
                    + "\n4. Delete the minimum key."
                    + "\n5. Quit\n\n");
            System.out.print("Select an option [1..5]: ");
            option = reader.nextInt();
            switch (option) {
                case 1: //Create a Binary Min-Heap (Top down)
                    System.out.print("Enter the number of elements to insert in the BinaryHeap: ");
                    size = reader.nextInt();

                    for (int i = 1; i <= size; i++) {
                        System.out.print("Enter element#" + i + ": ");
                        heap.enqueue(reader.nextInt());
                        new HeapPrinter(heap).print(); //prints the tree
                    }

                    break;

                case 2: //Create a Binary Min-Heap (Bottom up)
                    System.out.print("Enter the number of elements in the array: ");
                    size = reader.nextInt();
                    array = new Integer[size];

                    for (int i = 0; i < size; i++) {
                        System.out.print("Enter element#" + (i + 1) + ": ");
                        array[i] = reader.nextInt();
                    }
                    heap = new MinHeap<Integer>(array);
                    new HeapPrinter(heap).print();

                    break;

                case 3: //Insert a key (Enqueue)
                    System.out.print("Enter the key to be inserted: ");
                    n = reader.nextInt();
                    heap.enqueue(n);
                    new HeapPrinter(heap).print();
                    break;

                case 4: //Delete the minimum key (dequeueMin)
                    if (heap.isEmpty()) {
                        System.out.println("Error: The heap is empty");
                    } else {
                        heap.dequeue();
                        new HeapPrinter(heap).print();
                    }
                    break;
                    
                    
            }
        } while (option != 5);
    }
}
