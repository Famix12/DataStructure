
import java.util.*;

class TestLinkedList {

    public static void main(String[] ar) {
        LinkedList<Integer> lst = new LinkedList<Integer>();

        lst.add(4);
        lst.add(5);
        lst.addFirst(6);
        lst.addLast(4);
        System.out.println(lst);

        int sum = 0;
        for (int el : lst) {
            sum += el;
        }
        System.out.println(sum);

        sum = 0;
        Iterator it = lst.iterator();
        while (it.hasNext()) {
            sum += (Integer) it.next();
        }
        System.out.println(sum);

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

        lst.remove(2);
        System.out.println(lst);

        lst.removeFirst();         //remove first element
        System.out.println(lst);

        lst.removeLast();          //remove first element
        System.out.println(lst);

        lst.clear();               //empty the list
        System.out.println(lst);
    }
}
