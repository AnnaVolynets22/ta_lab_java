package com.epam.lab.arrayscollections1.deque;

import org.apache.logging.log4j.core.util.ArrayUtils;

import java.util.*;

public class MyDeque {
    private Object[] deque = new Object[1];
    private int elemCount = 0;

    public void addFirst(Object o) {
        Object[] newArray = new Object[deque.length +1];
        System.arraycopy(deque, 0, newArray, 1, deque.length);
        deque = newArray;
        deque[0] = o;
        elemCount++;
    };

    public void addLast(Object o) {
        if(elemCount!=0){
        Object[] newArray = new Object[deque.length +1 ];
        System.arraycopy(deque, 0, newArray, 0, deque.length);
        deque = newArray;
        deque[deque.length-1] = o;
        } else {
            deque[0] = o;
        }
        elemCount++;
    }

    public boolean offerFirst(Object o) {
        try{
            addFirst(o);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean offerLast(Object o) {
        try{
            addLast(o);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public Object removeFirst() {
        if(elemCount==0){
            throw new NoSuchElementException();
        } else {
            Object[] newArray = new Object[deque.length - 1];
            Object firstElem = deque[0];
            System.arraycopy(deque, 1, newArray, 0, deque.length - 1);
            deque = newArray;
            elemCount--;
            return firstElem;
        }
    }

    public Object removeLast() {
        if(elemCount==0){
            throw new NoSuchElementException();
        } else {
            Object[] newArray = new Object[deque.length - 1];
            Object lastElem = deque[deque.length - 1];
            System.arraycopy(deque, 0, newArray, 0, deque.length - 1);
            deque = newArray;
            elemCount--;
            return lastElem;
        }
    }

    public Object pollFirst() {
        if(elemCount==0){
            return null;
        } else {
            Object[] newArray = new Object[deque.length - 1];
            Object firstElem = deque[0];
            System.arraycopy(deque, 1, newArray, 0, deque.length - 1);
            deque = newArray;
            elemCount--;
            return firstElem;
        }
    }

    public Object pollLast() {
        if(elemCount==0){
            return null;
        } else {
            Object[] newArray = new Object[deque.length - 1];
            Object lastElem = deque[deque.length - 1];
            System.arraycopy(deque, 0, newArray, 0, deque.length - 1);
            deque = newArray;
            elemCount--;
            return lastElem;
        }
    }

    public Object getFirst() {
        if(elemCount == 0){
            throw new NoSuchElementException();
        }
        return deque[0];
    }

    public Object getLast() {
        if(elemCount == 0){
            throw new NoSuchElementException();
        }
        return deque[deque.length-1];
    }

    public Object peekFirst() {
        if(elemCount == 0){
            return null;
        }
        return deque[0];
    }

    public Object peekLast() {
        if(elemCount == 0){
            return null;
        }
        return deque[deque.length-1];
    }

    public boolean removeFirstOccurrence(Object o) {
        for(int i =0; i< deque.length; i++){
            if (o.equals(deque[i])){
                deque = ArrayUtils.remove(deque, i);
                elemCount--;
                return true;
            }
        }
        return false;
    }

    public boolean removeLastOccurrence(Object o) {
        for(int i =deque.length -1; i >= 0; i--){
            if (o.equals(deque[i])){
                deque = ArrayUtils.remove(deque, i);
                elemCount--;
                return true;
            }
        }
        return false;
    }

    public boolean add(Object o) {
        addLast(o);
        return true;
    }

    public boolean offer(Object o) {
        try{
            addLast(o);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public Object remove() {
        return removeFirst();
    }

    public Object poll() {
        return pollFirst();
    }

    public Object element() {
        return getFirst();
    }

    public Object peek() {
        return peekFirst();
    }

    public void push(Object o) {
       addFirst(o);
    }

    public Object pop() {
        return removeFirst();
    }

    public boolean remove(Object o) {
        return removeFirstOccurrence(o);
    }

    public int size() {
        return deque.length;
    }

    public boolean isEmpty() {
        if(elemCount == 0){
            return true;
        } else {
            return false;
        }
    }

    public Object[] toArray() {
        return deque;
    }

    public String toString() {
        return Arrays.toString(deque);
    }
}
