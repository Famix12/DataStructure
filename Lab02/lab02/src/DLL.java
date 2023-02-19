//****************************  DLL.java  *******************************
//                  generic doubly linked list class

import java.util.ArrayList;

public class DLL<T> {

    private DLLNode<T> head, tail;

    public DLL() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = tail = null;
    }

    public T getFirst() {
        if (head != null) {
            return head.info;
        } else {
            return null;
        }
    }

    public T getLast() {
        if (tail != null) {
            return tail.info;
        } else {
            return null;
        }
    }

    public int length() {
        int counter = 0;
        for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next) {
            counter++;
        }
        return counter;
    }

    public String toString() {
        String Context = "";
        for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next) {
            Context += tmp.info + "\t";
        }
        return Context;
    }

    public void printReverse() {
        for (DLLNode<T> tmp = tail; tmp != null; tmp = tmp.prev) {
            System.out.print(tmp.info + "    ");
        }
    }

    public T get(int index) {
        DLLNode<T> num = head.next;
        int i = 0;

        if (index >= 0 && index < length()) {
            do {
                if (index == 0) {
                    return head.info;
                }

                i++;
                if (i == index) {
                    return num.info;
                }
                num = num.next;
            } while (i != index);
        }
        return null;
    }

    public void insertAt(int index, T el) {
        DLLNode<T> tmp = head;
        int i = 0;
        try {
            if (index >= 0 && index < length()) {
                //Add To Head
                if (index == 0) {
                    addToHead(el);

                } //Add To Tail
                else if (index == length() - 1) {
                    addToTail(el);
                } //Add To Body
                else {
                    do {
                        i++;
                        tmp = tmp.next;
                        if (i == index) {
                            tmp.prev = tmp.prev.next = new DLLNode<T>(el, tmp, tmp.prev);
                        }

                    } while (i != index);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public ArrayList<T> toArray() {
        ArrayList<T> OpjList = new ArrayList<T>(0);

        for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next) {
            OpjList.add(tmp.info);
        }
        return OpjList;
    }

    public void addToHead(T el) {
        if (head != null) {
            head = new DLLNode<T>(el, head, null);
            head.next.prev = head;
        } else {
            head = tail = new DLLNode<T>(el);
        }
    }

    public void addToTail(T el) {
        if (tail != null) {
            tail = new DLLNode<T>(el, null, tail);
            tail.prev.next = tail;
        } else {
            head = tail = new DLLNode<T>(el);
        }
    }

    public T deleteFromHead() {
        if (isEmpty()) {
            return null;
        }
        T el = head.info;
        if (head == tail) // if only one node on the list;
        {
            head = tail = null;
        } else {              // if more than one node in the list;
            head = head.next;
            head.prev = null;
        }
        return el;
    }

    public T deleteFromTail() {
        if (isEmpty()) {
            return null;
        }
        T el = tail.info;
        if (head == tail) // if only one node on the list;
        {
            head = tail = null;
        } else {              // if more than one node in the list;
            tail = tail.prev;
            tail.next = null;
        }
        return el;
    }

    public T delete(T el) {
        if (isEmpty()) {
            return null;
        } else if (head.info.equals(el)) {
            return deleteFromHead();
        } else if (tail.info.equals(el)) {
            return deleteFromTail();
        } else {
            DLLNode<T> tmp;
            for (tmp = head.next; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
            if (tmp != null) {
                tmp.prev.next = tmp.next;
                tmp.next.prev = tmp.prev;
                return tmp.info;
            } else {
                return null;
            }
        }
    }

    public void printAll() {
        for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next) {
            System.out.print(tmp.info + " ");
        }
    }

    public T find(T el) {
        DLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
        if (tmp == null) {
            return null;
        } else {
            return tmp.info;
        }
    }

    // node of generic doubly linked list class	
    class DLLNode<T> {

        public T info;
        public DLLNode<T> next, prev;

        public DLLNode() {
            next = null;
            prev = null;
        }

        public DLLNode(T el) {
            info = el;
            next = null;
            prev = null;
        }

        public DLLNode(T el, DLLNode<T> n, DLLNode<T> p) {
            info = el;
            next = n;
            prev = p;
        }
    }
}
