package com.epam.lab.generics.task3priorityqueue;

import org.apache.logging.log4j.core.util.ArrayUtils;

import java.util.*;

public class MyPriorityQueue<T> extends AbstractQueue implements Queue {

    private T[] queue;
    private int size = 0;
    private int capacity = 11;
    private Comparator<? super T> comparator;

    public MyPriorityQueue(){
        queue = (T[]) new Object[capacity];
    }

    public MyPriorityQueue(int capacity, Comparator comparator){
        queue = (T[]) new Object[capacity];
        this.comparator = comparator;
    }


    @Override
    public int size() {
        return queue.length;
    }

    @Override
    public boolean add(Object o) {
        return offer(o);
    }

    @Override
    public boolean offer(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if(size >= capacity){
            capacity *=2;
            queue = Arrays.copyOf(queue, capacity);
        }
        if(comparator != null){
            sortWithComparator((T) o);
        } else {
            queue[size] = (T)o;
        }
        size++;
        return true;
    }

    @Override
    public Object poll() {
        if(size == 0){
            return null;
        } else {
            Object heap = queue[0];
            queue = ArrayUtils.remove(queue, 0);
            size--;
            return heap;
        }

    }

    @Override
    public Object peek() {
        if(size == 0){
            return null;
        } else {
            return queue[0];
        }

    }

    private void sortWithComparator(T o) {
        int i = 0;
        while (i < size) {
            if (comparator.compare(o, (T) queue[i]) >= 0) {
                ++i;
            } else {
                break;
            }
        }
        System.arraycopy(queue, i, queue, i + 1, size - i);
        queue[i] = o;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator<T> implements Iterator<T> {
        private int currentIndex = 0;

        public boolean hasNext() {
            return currentIndex < size || queue[currentIndex] != null;
        }

        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return (T) queue[currentIndex++];
        }
    }
}
