package com.epam.lab.collections2.treemap;

import java.util.*;

public class MyTreeMap<K extends Comparable, V> extends AbstractMap<K,V> implements Map.Entry {
   private List<MyEntry> map;
   private Comparator<? super K> comparator;

   public MyTreeMap(){
       map = new ArrayList<>();
   }

    public MyTreeMap(Comparator comparator){
        map = new ArrayList<>();
        this.comparator = comparator;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public V put(K key, V value) {
        MyEntry<K, V> myEntry = new MyEntry<>(key, value);
        map.add(myEntry);
        return value;
    }

    @Override
    public V remove(Object key) {
        return super.remove(key);
    }

    @Override
    public void putAll(Map m) {
        super.putAll(m);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public Set keySet() {
        return super.keySet();
    }

    @Override
    public Collection values() {
        return super.values();
    }

    @Override
    public Set<Entry<K,V>> entrySet() {
        return null;
    }

    @Override
    public Object getKey() {
        return null;
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public Object setValue(Object o) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
       String mapString = "";
       for(MyEntry entry: map){
           mapString += entry.toString() + " ";
       }
       return mapString;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
