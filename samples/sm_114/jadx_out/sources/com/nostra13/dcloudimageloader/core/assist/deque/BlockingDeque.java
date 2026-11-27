package com.nostra13.dcloudimageloader.core.assist.deque;

/* JADX INFO: loaded from: classes.dex */
public interface BlockingDeque<E> extends java.util.concurrent.BlockingQueue<E>, com.nostra13.dcloudimageloader.core.assist.deque.Deque<E> {
    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Collection, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    boolean add(E e);

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.Deque
    void addFirst(E e);

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.Deque
    void addLast(E e);

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    boolean contains(java.lang.Object obj);

    @Override // java.util.Queue, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    E element();

    @Override // java.util.Collection, java.lang.Iterable, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    java.util.Iterator<E> iterator();

    @Override // java.util.concurrent.BlockingQueue, java.util.Queue, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    boolean offer(E e);

    @Override // java.util.concurrent.BlockingQueue
    boolean offer(E e, long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException;

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.Deque
    boolean offerFirst(E e);

    boolean offerFirst(E e, long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException;

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.Deque
    boolean offerLast(E e);

    boolean offerLast(E e, long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException;

    @Override // java.util.Queue, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    E peek();

    @Override // java.util.Queue, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    E poll();

    @Override // java.util.concurrent.BlockingQueue
    E poll(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException;

    E pollFirst(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException;

    E pollLast(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException;

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.Deque
    void push(E e);

    @Override // java.util.concurrent.BlockingQueue
    void put(E e) throws java.lang.InterruptedException;

    void putFirst(E e) throws java.lang.InterruptedException;

    void putLast(E e) throws java.lang.InterruptedException;

    @Override // java.util.Queue, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    E remove();

    @Override // java.util.concurrent.BlockingQueue, java.util.Collection, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    boolean remove(java.lang.Object obj);

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.Deque
    boolean removeFirstOccurrence(java.lang.Object obj);

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.Deque
    boolean removeLastOccurrence(java.lang.Object obj);

    @Override // java.util.Collection, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    int size();

    @Override // java.util.concurrent.BlockingQueue
    E take() throws java.lang.InterruptedException;

    E takeFirst() throws java.lang.InterruptedException;

    E takeLast() throws java.lang.InterruptedException;
}
