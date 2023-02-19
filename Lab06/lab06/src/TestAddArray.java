
import java.util.Arrays;

public class TestAddArray {

    public static void main(String[] args) {
        int[] array = {2, 3, 5, 1, 7, 10, 8, 4, 6, 9};

        System.out.print("Content of the array is: " + Arrays.toString(array));
        /*  for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }*/
        System.out.println();  //move to next line.

        System.out.println("\nSum of the elements in the array is: " + add(array));
    }

    public static int add(int[] a, int last) {
        if (last == 0) {
            return a[0];
        } else {
            return add(a, last - 1) + a[last];
        }
    }

    public static int add(int[] a) {
        return add(a, a.length - 1);
    }

}
