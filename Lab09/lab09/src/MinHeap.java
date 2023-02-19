
import java.util.*;

public class MinHeap<T extends Comparable<T>> implements PriorityQueue<T> {

    protected ArrayList<T> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public MinHeap(ArrayList<T> list) {
        heap = list;
        buildHeapBottomUp();
    }

    public MinHeap(T[] a) {
        heap = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            heap.add(a[i]);
        }
        buildHeapBottomUp();
    }

    private void buildHeapBottomUp() {
        for (int i = lastParent(); i >= 0; i--) {
            percolateDown(i);
        }
    }

    private void percolateDown(int hole) {
        int min;
        T temp = heap.get(hole);

        while (left(hole) <= heap.size() - 1) {
            min = left(hole); //let left child be min

            //if right child exists and is smaller than left child, then let it be the min
            if (right(hole) <= heap.size() - 1 && heap.get(right(hole)).compareTo(heap.get(min)) < 0) {
                min = right(hole);
            }

            //if min child is less than parent then swap, else stop the loop	
            if (heap.get(min).compareTo(temp) < 0) {
                heap.set(hole, heap.get(min));
            } else {
                break;
            }

            hole = min;
        }
        heap.set(hole, temp);
    }

    private void percolateUp(int hole) {
        T key = heap.get(hole);
        while (hole > 0 && heap.get(parent(hole)).compareTo(key) > 0) {
            heap.set(hole, heap.get(parent(hole)));
            hole = parent(hole);
        }
        heap.set(hole, key);
    }

    public void enqueue(T key) {
        heap.add(key);
        int hole = heap.size() - 1;
        percolateUp(hole);
    }

    public T findFront() {
        if (isEmpty()) {
            return null;
        } else {
            return heap.get(0);
        }
    }

    public T dequeue() {
        if (heap.size() == 0) {
            return null;
        } else if (heap.size() == 1) {
            return heap.remove(0);
        } else {
            T root = heap.get(0);
            T lastItem = heap.remove(heap.size() - 1);
            heap.set(0, lastItem);
            percolateDown(0);
            return root;
        }
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public String toString() {
        return heap.toString();
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int lastParent() {
        return heap.size() / 2 - 1;
    }
}
