
import java.util.*;

class TestArrayList {

    public static void main(String[] ar) {
        ArrayList<Integer> lst = new ArrayList<Integer>();
        lst.add(4);
        lst.add(5);
        lst.add(2, 6); //Add 6 at position 2  
        lst.add(0, 9); // Add 9 at position 0 [9, 4, 5, 6] 
        System.out.println(lst);

        Iterator<Integer> it = lst.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        int sum = 0;
        it = lst.iterator();
        while (it.hasNext()) {
            sum = sum + it.next();
        }
        System.out.println("Sum of the elements is: " + sum); 
    }
}
