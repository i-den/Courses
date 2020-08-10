package com.denchevgod.ds.queues;

import java.util.Comparator;

public class AbstractPriorityQueue<K, V> {

    protected Comparator<K> comp;

    protected int size = 0;

    protected AbstractPriorityQueue() {
        this(new DefaultComparator<K>());
    }

    protected AbstractPriorityQueue(Comparator<K> comp) {
        this.comp = comp;
    }

    protected static class PQEntry<K, V> {
        protected K key;
        protected V value;

        protected PQEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    protected static class DefaultComparator<K> implements Comparator<K> {

        @Override
        public int compare(K k1, K k2) throws ClassCastException {
            return ((Comparable<K>) k1).compareTo(k2);
        }
    }
}
