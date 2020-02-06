package com.epam.lab.collections2.treemap;

import java.util.Map;

public class MyEntry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V v) {
        return this.value =value;
    }

    @Override
    public String toString() {
        return "Key:" + key.toString() + " Value:" + value.toString();
    }

}
