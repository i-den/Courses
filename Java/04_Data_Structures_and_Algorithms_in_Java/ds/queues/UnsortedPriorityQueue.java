package com.denchevgod.ds.queues;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

    private List<PQEntry<K, V>> list = new LinkedList<>();

    public UnsortedPriorityQueue() {
        super();
    }

    public UnsortedPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    private PQEntry<K, V> findMin() {
        return list.stream()
                .min((e1, e2) -> comp.compare(e1.key, e2.key))
                .orElse(null);
    }

    public void insert(K key, V value) {
        list.add(new PQEntry<>(key, value));
    }

    public PQEntry<K, V> min() {
        return findMin();
    }

    public PQEntry<K, V> removeMin() {
        PQEntry<K, V> toRemove = findMin();
        list.remove(toRemove);
        return toRemove;
    }
}
