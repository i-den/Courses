package com.denchevgod.ds.maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {

    private ArrayList<MapEntry<K, V>> table = new ArrayList<>();

    public UnsortedTableMap() {
    }

    private int findIndex(K key) {
        for (int i = 0; i < table.size(); i++) {
            if (table.get(i).getKey().equals(key))
                return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return table.size();
    }

    @Override
    public V get(K key) {
        int i = findIndex(key);
        if (i == -1)
            return null;
        return table.get(i).getValue();
    }

    @Override
    public void put(K key, V value) {
        int i = findIndex(key);
        if (i == -1) {
            table.add(new MapEntry<>(key, value));
        } else {
            table.get(i).setValue(value);
        }
    }

    @Override
    public V remove(K key) {
        int i = findIndex(key);
        if (i == -1) {
            return null;
        }
        int n = size();
        V tmp = table.get(i).getValue();
        if (i != n - 1) {
            table.set(i, table.get(n - 1));
        }
        table.remove(n - 1);
        return tmp;
    }

    @Override
    public Iterable<K> keySet() {
        return KeyIterator::new;
    }

    @Override
    public Iterable<V> values() {
        return ValueIterator::new;
    }

    private class EntryIterator implements Iterator<Entry<K, V>> {
        private int currIndex = 0;

        @Override
        public boolean hasNext() {
            return currIndex < table.size();
        }

        public Entry<K, V> next() {
            if (currIndex == table.size())
                throw new NoSuchElementException();
            return table.get(currIndex++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return EntryIterator::new;
    }
}
