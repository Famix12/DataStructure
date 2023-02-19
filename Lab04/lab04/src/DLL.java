//****************************  DLL.java  *******************************
//                  generic doubly linked list class

import java.util.*;

public class DLL<T> implements Iterable<T> {

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

    public String toString() {
        String s = "[";
        for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next) {
            s += tmp.info + " ";
        }
        return s + "]";
    }

    public Iterator<T> iterator() {
        return new DLLIterator();
    }

    private class DLLIterator implements Iterator<T> {

        DLLNode<T> tmp = head;

        public boolean hasNext() {
            return tmp != null;
        }

        public T next() {
            T info = tmp.info;
            tmp = tmp.next;
            return info;
        }

        public void remove() {
            // not implemented
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
