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
        head = new SLLNode<>(el, head);
        if (tail == null) {
            tail = head;
        }
    }

    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<>(el);
            tail = tail.next;
        } else {
            head = tail = new SLLNode<>(el);
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

    private class SLLNode<T> {

        public T info;
        public SLLNode next = null;

        public SLLNode(T el) {
            info = el;
            next = null;
        }

        public SLLNode(T el, SLLNode ref) {
            info = el;
            next = ref;
        }
    }
}
