package com.denchevgod.ds.maps;

interface Entry<K, V> {

    void setKey(K key);

    void setValue(V value);

    K getKey();

    V getValue();
}
