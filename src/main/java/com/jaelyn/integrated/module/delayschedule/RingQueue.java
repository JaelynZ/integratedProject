package com.jaelyn.integrated.module.delayschedule;

import lombok.Data;

import java.util.Iterator;

/**
 * ring queue,a queue based a array
 * 18.11.10
 *
 * @author quantangkun
 */
public class RingQueue<E> implements Iterable<E> {

    private final int capacity; //环形容器大小，new的时候就固定了

    private Object[] queue;     //队列数组

    private int head = 0;       //队列头

    private int tail = 0;       //队列尾

    private int length = 0;     //数组长度

    /**
     * judge the queue is empty
     */
    public boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }

    /**
     * usually construction,just set capacity
     *
     * @param capacity capacity
     */
    public RingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new Object[capacity];
    }

    /**
     * default construction
     * set capacity :32
     */
    public RingQueue() {
        this.capacity = 2 << 4;
        this.queue = new Object[capacity];
    }

    /**
     * construction with a array,the second para is queue capacity
     * if capacity smaller than the array, set default capacity
     * 4 times array's length
     *
     * @param arr      array
     * @param capacity capacity
     */
    public RingQueue(Object[] arr, int capacity) {

        if (capacity > arr.length) {
            this.capacity = capacity;
        } else {
            this.capacity = arr.length << 2;
        }
        queue = new Object[capacity];
        System.arraycopy(arr, 0, queue, 0, arr.length);
        length = arr.length;
        tail = arr.length;
        head = 0;

    }

    /**
     * construction with a array,set default capacity
     * 4 times array's length
     *
     * @param arr array
     */
    public RingQueue(Object[] arr) {
        capacity = arr.length << 2;

        queue = new Object[capacity];
        System.arraycopy(arr, 0, queue, 0, arr.length);
        length = arr.length;
        tail = arr.length;
        head = 0;
    }

    /**
     * judge the queue is fill
     */
    private boolean isFill() {
        return length >= capacity;
    }


    /**
     * this method allow you add the object after the queue
     * it will doesn't work if the queue is already fill
     */

    public boolean push(E o) {

        if (isFill()) {
            System.err.println("over Load");
            return false;
        }
        queue[tail % capacity] = o;
        tail++;
        length++;
        return true;
    }


    /**
     * this method allow you add the object after the queue
     * it will always success because if the queue was filled
     * it will remove the first element,and then new element
     * could join,after the last one
     */
    public void shift(E e) {
        if (isFill()) {
            pop();
        }
        push(e);
    }

    /**
     * this method will remove the first element
     * and return itself
     */

    @SuppressWarnings("unchecked")
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E e = (E) queue[head % capacity];
        head++;
        length--;
        return e;
    }


    /**
     * you can find the element in this queue with
     * a index
     *
     * @param index queue index,the first is 0
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < length && index > 0) {
            return (E) queue[(head + index) % capacity];
        }
        return null;
    }


    /**
     * it will judge if the queue contain the element you input
     */
    @SuppressWarnings("unchecked")
    public boolean contain(E o) {
        for (int i = head; i < head + length; i++) {
            E curr = (E) (queue[i % 4]);
            if (curr.equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * show the queue member
     */
    public void showQueue() {

        for (int i = head; i < head + length; i++) {
            System.err.println(queue[i % capacity]);
        }
    }

    /**
     * return the capacity of this queue
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * implements iterator
     */
    private class iterator implements Iterator<E> {

        int cursor = head; //当前队列下标

        @Override
        public boolean hasNext() {
            return cursor != head + length;
        }

        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            int i = cursor;
            cursor = i + 1;
            return (E) queue[i % capacity];
        }
    }

    @Override
    public Iterator<E> iterator() {

        return new iterator();
    }

}
