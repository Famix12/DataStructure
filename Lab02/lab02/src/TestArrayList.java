
import java.util.*;

class TestArrayList {

    public static void main(String[] ar) {
        ArrayList<Integer> lst = new ArrayList<Integer>();
        lst.add(4);
        lst.add(5);
        lst.add(2, 6); //Add 6 at position 2  
        lst.add(0, 9); // Add 9 at position 0  
        System.out.println(lst);  //[9 4 7 5 6]

        lst.add(2, 7);   //add 7 at index 2
        System.out.println(lst);

        if (lst.contains(6)) //to check if element exists
        {
            System.out.println("item 6 found");
        } else {
            System.out.println("item 6 NOT found");
        }
        if (lst.contains(10)) {
            System.out.println("item 10 found");
        } else {
            System.out.println("item 10 NOT found");
        }
        System.out.println(lst);

        System.out.println("The 3rd elelemnt is: " + lst.get(2));

        lst.remove(4); //remove element at index 4
        System.out.println(lst);

        lst.remove(lst.size() - 1); //remove the last element           
        System.out.println(lst);

        lst.clear();               //empty the list
        System.out.println(lst); 
    }
}
