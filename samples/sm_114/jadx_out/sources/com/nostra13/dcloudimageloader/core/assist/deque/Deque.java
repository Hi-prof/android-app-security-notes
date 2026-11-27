package com.nostra13.dcloudimageloader.core.assist.deque;

/* JADX INFO: loaded from: classes.dex */
public interface Deque<E> extends java.util.Queue<E> {
    boolean add(E e);

    void addFirst(E e);

    void addLast(E e);

    boolean contains(java.lang.Object obj);

    java.util.Iterator<E> descendingIterator();

    E element();

    E getFirst();

    E getLast();

    java.util.Iterator<E> iterator();

    boolean offer(E e);

    boolean offerFirst(E e);

    boolean offerLast(E e);

    E peek();

    E peekFirst();

    E peekLast();

    E poll();

    E pollFirst();

    E pollLast();

    E pop();

    void push(E e);

    E remove();

    boolean remove(java.lang.Object obj);

    E removeFirst();

    boolean removeFirstOccurrence(java.lang.Object obj);

    E removeLast();

    boolean removeLastOccurrence(java.lang.Object obj);

    int size();
}
