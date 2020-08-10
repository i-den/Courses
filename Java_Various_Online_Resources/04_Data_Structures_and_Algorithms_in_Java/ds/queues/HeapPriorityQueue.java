package com.denchevgod.ds.queues;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

    protected ArrayList<PQEntry<K, V>> heap = new ArrayList<>();

    public HeapPriorityQueue() {
        super();
    }

    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    protected int parent(int index) {
        return (index - 1) / 2;
    }

    protected int left(int index) {
        return (2 * index) + 1;
    }

    protected int right(int index) {
        return (2 * index) + 2;
    }

    protected boolean hasLeft(int index) {
        return left(index) < heap.size();
    }

    protected boolean hasRight(int index) {
        return right(index) < heap.size();
    }

    protected void swap(int firstIndex, int secIndex) {
        PQEntry<K, V> tmp = heap.get(firstIndex);
        heap.set(firstIndex, heap.get(secIndex));
        heap.set(secIndex, tmp);
    }

    protected void upheap(int childIndex) {
        while (childIndex > 0) {
            int parentIndex = parent(childIndex);
            if (comp.compare(heap.get(childIndex).key, heap.get(parentIndex).key) >= 0) {
                break;
            }
            swap(childIndex, parentIndex);
            childIndex = parentIndex;
        }
    }

    protected void downheap(int parentIndex) {
        while (hasLeft(parentIndex)) {
            int leftChildIndex = left(parentIndex);
            int smallChildIndex = leftChildIndex;
            if (hasRight(parentIndex)) { // find smaller child
                int rightChildIndex = right(parentIndex);
                if (comp.compare(heap.get(leftChildIndex).key, heap.get(rightChildIndex).key) > 0) {
                    smallChildIndex = rightChildIndex;
                }
            }
            if (comp.compare(heap.get(smallChildIndex).key, heap.get(parentIndex).key) >= 0) {
                break; // parent is bigger or equal
            }
            swap(parentIndex, smallChildIndex);
            parentIndex = smallChildIndex;
        }
    }

    public int size() {
        return heap.size();
    }

    public PQEntry<K, V> min() {
        if (heap.isEmpty())
            return null;
        return heap.get(0);
    }

    public PQEntry<K, V> insert(K key, V value) {
        PQEntry<K, V> entry = new PQEntry<>(key, value);
        heap.add(entry);
        upheap(heap.size() - 1);
        return entry;
    }

    public PQEntry<K, V> removeMin() {
        if (heap.isEmpty()) {
            return null;
        }
        PQEntry<K, V> min = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downheap(0);
        return min;
    }
}
