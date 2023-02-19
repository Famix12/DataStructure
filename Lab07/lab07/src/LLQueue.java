
import java.util.LinkedList;

public class LLQueue<T> {

    private LinkedList<T> list = new LinkedList<T>();

    public LLQueue() {
    }

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public T firstEl() {
        return list.getFirst();
    }

    public T dequeue() {
        return list.removeFirst();
    }

    public void enqueue(T el) {
        list.add(el);
    }

    public String toString() {
        return list.toString();
    }
}
