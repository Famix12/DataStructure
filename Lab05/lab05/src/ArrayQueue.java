//                      queue implemented as an array

public class ArrayQueue {

    private int first, last, size;
    private Object[] storage;

    public ArrayQueue() {
        this(100);
    }

    public ArrayQueue(int n) {
        size = n;
        storage = new Object[size];
        first = last = -1;
    }

    public boolean isFull() {
        return first == 0 && last == size - 1 || first == last + 1;
    }

    public boolean isEmpty() {
        return first == -1;
    }

    public void enqueue(Object el) {
        if (last == size - 1 || last == -1) { //if last is at end of array or queue is empty
            storage[0] = el;
            last = 0;
            if (first == -1) {
                first = 0;
            }
        } else {
            storage[++last] = el;  //can be broken as:  last++;  storage[last] = el;
        }
    }

    public Object dequeue() {
        Object tmp = storage[first];
        if (first == last) //if there is only one element
        {
            last = first = -1;  //set the queue to empty
        } else if (first == size - 1) {
            first = 0;
        } else {
            first++;
        }
        return tmp;
    }

    public Object firstEl() {
        return storage[first];
    }

    public void clear() {
        first = last = -1;
    }

    public void printAll() {
        if (first <= last) {
            for (int i = first; i <= last; i++) {
                System.out.print(storage[i] + " ");
            }
        } else {
            for (int i = first; i < size; i++) {
                System.out.print(storage[i] + " ");
            }
            for (int i = 0; i <= last; i++) {
                System.out.print(storage[i] + " ");
            }
        }
    }
}
