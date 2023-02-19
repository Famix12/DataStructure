//Students only need to know how to use this class not its implementation
import java.util.*;

public class HeapPrinter {

    ArrayList<Integer> heap;
    int count;
    int lastParent;

    public static final int MAX_HEIGHT = 5;  // cannot print trees > MAX_HEIGHT
    private static final int POWERS_OF_2[] = {1, 2, 4, 8, 16, 32, 64, 128};

    public HeapPrinter(MinHeap<Integer> t) {
        heap = t.heap;
        count = heap.size();
        lastParent = count/2-1;
    }

    public void print() {

        int height = getHeight();
        int offset = POWERS_OF_2[height] - 1;

        for (int level = 0; level < height; level++) {
            if (level > MAX_HEIGHT) {
                System.out.println("*** Too many levels to print. ***\n");
                break;
            }

            // Print node data.
            printData(level, offset);

            if (level != height - 1) { //if not last level
                // Print outgoing links /\ from each parent node->
                printOutgoingLinks(level, offset);

                offset = POWERS_OF_2[height - level - 1] - 1;

                // Print connecting dashes ----
                if (level < height - 2) {
                    printConnectingDashes(level, offset);
                }

                // Print incoming links / and \ to each child node->
                printIncomingLinks(level, offset);
            }
        }
    }

    private void printData(int level, int offset) {
        printSpaces(offset);

        int first = POWERS_OF_2[level] - 1;
        int last = POWERS_OF_2[level + 1] - 2;

        for (int index = first; index <= last && index < count; index++) {
            System.out.print(padSpaces(heap.get(index) + "", 3) + " ");
            if (index < count) {
                printSpaces(2 * offset - 2);
            }
        }
        System.out.println();
    }

    private void printOutgoingLinks(int level, int offset) {
        printSpaces(offset);

        int first = POWERS_OF_2[level] - 1;
        int last = POWERS_OF_2[level + 1] - 2;

        for (int index = first; index <= last && index <= lastParent; index++) {
            System.out.print(" /");
            if (2*index + 2 < count) {  //right child exist
                System.out.print("\\ ");
                printSpaces(2 * offset - 2);
            }
        }
        System.out.println();
    }

    public void printConnectingDashes(int level, int offset) {
        if (offset > 1) {
            printSpaces(offset);
        }

        int first = POWERS_OF_2[level] - 1;
        int last = POWERS_OF_2[level + 1] - 2;

        for (int index = first; index <= last && index <= lastParent; index++) {
            printSpaces(3);
            printDashes(offset - 1);
            if (2*index + 2 < count) { //right child exist
                printSpaces(2);
                printDashes(offset - 1);
                printSpaces(2 * offset + 1);
            }
        }
        System.out.println();
    }

    private void printIncomingLinks(int level, int offset) {
        printSpaces(offset);

        int first = POWERS_OF_2[level] - 1;
        int last = POWERS_OF_2[level + 1] - 2;

        for (int index = first; index <= last && index <= lastParent; index++) {
            System.out.print("  /");
            if (2*index + 2 < count) {  //right child exist
                printSpaces(2 * offset);
                System.out.print("\\");
                printSpaces(2 * offset);
            }
        }
        System.out.println();
    }

    private void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private void printDashes(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
    }

    private String padSpaces(String s, int w) {
        int length = s.length();
        while (length < w) {
            s = " " + s;
            length++;
        }
        return s;
    }

    private int getHeight() {
        int count = heap.size();
        return (int) Math.ceil(Math.log(count + 1) / Math.log(2));
    }

}
