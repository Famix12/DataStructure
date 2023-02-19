//**************************  SLL.java  *********************************
//           a generic singly linked list class 

public class SLL<T> {

    protected SLLNode<T> head, tail;

    public SLL() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addToHead(T el) {
        if (!isEmpty()) {
            head = new SLLNode<T>(el, head);
        } else {
            head = tail = new SLLNode<T>(el);
        }
    }

    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<T>(el);
            tail = tail.next;
        } else {
            head = tail = new SLLNode<T>(el);
        }
    }

    public T deleteFromHead() { // delete the head and return its info; 
        if (isEmpty()) {
            return null;
        }
        T el = head.info;
        if (head == tail) // if only one node on the list;
        {
            head = tail = null;
        } else {
            head = head.next;
        }
        return el;
    }

    public T deleteFromTail() { // delete the tail and return its info;
        if (isEmpty()) {
            return null;
        }
        T el = tail.info;
        if (head == tail) // if only one node in the list;
        {
            head = tail = null;
        } else {                  // if more than one node in the list,
            SLLNode<T> tmp;    // find the predecessor of tail;
            for (tmp = head; tmp.next != tail; tmp = tmp.next);
            tail = tmp;        // the predecessor of tail becomes tail;
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
            SLLNode<T> pred, tmp;// and el is in a nonhead node;
            for (pred = head, tmp = head.next;
                    tmp != null && !tmp.info.equals(el);
                    pred = pred.next, tmp = tmp.next);
            if (tmp != null) {
                pred.next = tmp.next;
                return tmp.info;
            } else {
                return null;
            }
        }
    }

    public void printAll() {
        for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next) {
            System.out.print(tmp.info + " ");
        }
    }

    public T find(T el) {
        SLLNode<T> tmp;
        for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
        if (tmp != null) // if found
        {
            return tmp.info;
        } else {
            return null;
        }
    }

    Integer delete(int target) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void clear() {
        head = tail = null;
    }

    public T getFirst() {

        return head.info;
    }

    public T getLast() {
        return tail.info;
    }

    public int length() {
        int counter = 0;
        for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next) {
            counter++;
        }
        return counter;
    }

    public String toString() {
        String Context = "";
        for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next) {
            Context += tmp.info + "\t";
        }
        return Context;
    }

    //This is an inner class impleming the SLLNode
    public class SLLNode<T> {

        public T info;
        public SLLNode<T> next;

        public SLLNode() {
            this(null, null);
        }

        public SLLNode(T el) {
            this(el, null);
        }

        public SLLNode(T el, SLLNode<T> ptr) {
            info = el;
            next = ptr;
        }

    }

}
