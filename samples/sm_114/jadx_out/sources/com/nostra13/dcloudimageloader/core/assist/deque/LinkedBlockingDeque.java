package com.nostra13.dcloudimageloader.core.assist.deque;

/* JADX INFO: loaded from: classes.dex */
public class LinkedBlockingDeque<E> extends java.util.AbstractQueue<E> implements com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque<E>, java.io.Serializable {
    private static final long serialVersionUID = -387911632671998426L;
    private final int capacity;
    private transient int count;
    transient com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> first;
    transient com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> last;
    final java.util.concurrent.locks.ReentrantLock lock;
    private final java.util.concurrent.locks.Condition notEmpty;
    private final java.util.concurrent.locks.Condition notFull;

    static final class Node<E> {
        E item;
        com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> next;
        com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> prev;

        Node(E e) {
            this.item = e;
        }
    }

    public LinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
    }

    public LinkedBlockingDeque(int i) {
        java.util.concurrent.locks.ReentrantLock reentrantLock = new java.util.concurrent.locks.ReentrantLock();
        this.lock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        this.notFull = reentrantLock.newCondition();
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        this.capacity = i;
    }

    public LinkedBlockingDeque(java.util.Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (E e : collection) {
                if (e == null) {
                    throw new java.lang.NullPointerException();
                }
                if (!linkLast(new com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<>(e))) {
                    throw new java.lang.IllegalStateException("Deque full");
                }
            }
            reentrantLock.unlock();
        } catch (java.lang.Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    private boolean linkFirst(com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node) {
        if (this.count >= this.capacity) {
            return false;
        }
        com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node2 = this.first;
        node.next = node2;
        this.first = node;
        if (this.last == null) {
            this.last = node;
        } else {
            node2.prev = node;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private boolean linkLast(com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node) {
        if (this.count >= this.capacity) {
            return false;
        }
        com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node2 = this.last;
        node.prev = node2;
        this.last = node;
        if (this.first == null) {
            this.first = node;
        } else {
            node2.next = node;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private E unlinkFirst() {
        com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node = this.first;
        if (node == null) {
            return null;
        }
        com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node2 = node.next;
        E e = node.item;
        node.item = null;
        node.next = node;
        this.first = node2;
        if (node2 == null) {
            this.last = null;
        } else {
            node2.prev = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    private E unlinkLast() {
        com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node = this.last;
        if (node == null) {
            return null;
        }
        com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node2 = node.prev;
        E e = node.item;
        node.item = null;
        node.prev = node;
        this.last = node2;
        if (node2 == null) {
            this.first = null;
        } else {
            node2.next = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    void unlink(com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node) {
        com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node2 = node.prev;
        com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node3 = node.next;
        if (node2 == null) {
            unlinkFirst();
            return;
        }
        if (node3 == null) {
            unlinkLast();
            return;
        }
        node2.next = node3;
        node3.prev = node2;
        node.item = null;
        this.count--;
        this.notFull.signal();
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public void addFirst(E e) {
        if (!offerFirst(e)) {
            throw new java.lang.IllegalStateException("Deque full");
        }
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public void addLast(E e) {
        if (!offerLast(e)) {
            throw new java.lang.IllegalStateException("Deque full");
        }
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public boolean offerFirst(E e) {
        e.getClass();
        com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node = new com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<>(e);
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return linkFirst(node);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public boolean offerLast(E e) {
        e.getClass();
        com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node = new com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<>(e);
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return linkLast(node);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque
    public void putFirst(E e) throws java.lang.InterruptedException {
        e.getClass();
        com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node = new com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<>(e);
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!linkFirst(node)) {
            try {
                this.notFull.await();
            } catch (java.lang.Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque
    public void putLast(E e) throws java.lang.InterruptedException {
        e.getClass();
        com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node = new com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<>(e);
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!linkLast(node)) {
            try {
                this.notFull.await();
            } catch (java.lang.Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque
    public boolean offerFirst(E e, long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
        e.getClass();
        com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node = new com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<>(e);
        long nanos = timeUnit.toNanos(j);
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (!linkFirst(node)) {
            try {
                if (nanos > 0) {
                    nanos = this.notFull.awaitNanos(nanos);
                } else {
                    reentrantLock.unlock();
                    return false;
                }
            } catch (java.lang.Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        return true;
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque
    public boolean offerLast(E e, long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
        e.getClass();
        com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node = new com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<>(e);
        long nanos = timeUnit.toNanos(j);
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (!linkLast(node)) {
            try {
                if (nanos > 0) {
                    nanos = this.notFull.awaitNanos(nanos);
                } else {
                    reentrantLock.unlock();
                    return false;
                }
            } catch (java.lang.Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        return true;
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public E removeFirst() {
        E ePollFirst = pollFirst();
        if (ePollFirst != null) {
            return ePollFirst;
        }
        throw new java.util.NoSuchElementException();
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public E removeLast() {
        E ePollLast = pollLast();
        if (ePollLast != null) {
            return ePollLast;
        }
        throw new java.util.NoSuchElementException();
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public E pollFirst() {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkFirst();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public E pollLast() {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkLast();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque
    public E takeFirst() throws java.lang.InterruptedException {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E eUnlinkFirst = unlinkFirst();
                if (eUnlinkFirst == null) {
                    this.notEmpty.await();
                } else {
                    reentrantLock.unlock();
                    return eUnlinkFirst;
                }
            } catch (java.lang.Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque
    public E takeLast() throws java.lang.InterruptedException {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E eUnlinkLast = unlinkLast();
                if (eUnlinkLast == null) {
                    this.notEmpty.await();
                } else {
                    reentrantLock.unlock();
                    return eUnlinkLast;
                }
            } catch (java.lang.Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque
    public E pollFirst(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
        long nanos = timeUnit.toNanos(j);
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E eUnlinkFirst = unlinkFirst();
                if (eUnlinkFirst != null) {
                    reentrantLock.unlock();
                    return eUnlinkFirst;
                }
                if (nanos > 0) {
                    nanos = this.notEmpty.awaitNanos(nanos);
                } else {
                    reentrantLock.unlock();
                    return null;
                }
            } catch (java.lang.Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque
    public E pollLast(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
        long nanos = timeUnit.toNanos(j);
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E eUnlinkLast = unlinkLast();
                if (eUnlinkLast != null) {
                    reentrantLock.unlock();
                    return eUnlinkLast;
                }
                if (nanos > 0) {
                    nanos = this.notEmpty.awaitNanos(nanos);
                } else {
                    reentrantLock.unlock();
                    return null;
                }
            } catch (java.lang.Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public E getFirst() {
        E ePeekFirst = peekFirst();
        if (ePeekFirst != null) {
            return ePeekFirst;
        }
        throw new java.util.NoSuchElementException();
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public E getLast() {
        E ePeekLast = peekLast();
        if (ePeekLast != null) {
            return ePeekLast;
        }
        throw new java.util.NoSuchElementException();
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public E peekFirst() {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node = this.first;
            return node == null ? null : node.item;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public E peekLast() {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node = this.last;
            return node == null ? null : node.item;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public boolean removeFirstOccurrence(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node = this.first; node != null; node = node.next) {
                if (obj.equals(node.item)) {
                    unlink(node);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public boolean removeLastOccurrence(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node = this.last; node != null; node = node.prev) {
                if (obj.equals(node.item)) {
                    unlink(node);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public boolean offer(E e) {
        return offerLast(e);
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue
    public void put(E e) throws java.lang.InterruptedException {
        putLast(e);
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
        return offerLast(e, j, timeUnit);
    }

    @Override // java.util.AbstractQueue, java.util.Queue, com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public E remove() {
        return removeFirst();
    }

    @Override // java.util.Queue, com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public E poll() {
        return pollFirst();
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue
    public E take() throws java.lang.InterruptedException {
        return takeFirst();
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue
    public E poll(long j, java.util.concurrent.TimeUnit timeUnit) throws java.lang.InterruptedException {
        return pollFirst(j, timeUnit);
    }

    @Override // java.util.AbstractQueue, java.util.Queue, com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public E element() {
        return getFirst();
    }

    @Override // java.util.Queue, com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public E peek() {
        return peekFirst();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.capacity - this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(java.util.Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(java.util.Collection<? super E> collection, int i) {
        collection.getClass();
        if (collection == this) {
            throw new java.lang.IllegalArgumentException();
        }
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int iMin = java.lang.Math.min(i, this.count);
            for (int i2 = 0; i2 < iMin; i2++) {
                collection.add(this.first.item);
                unlinkFirst();
            }
            reentrantLock.unlock();
            return iMin;
        } catch (java.lang.Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public void push(E e) {
        addFirst(e);
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public E pop() {
        return removeFirst();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public boolean remove(java.lang.Object obj) {
        return removeFirstOccurrence(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public int size() {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public boolean contains(java.lang.Object obj) {
        if (obj == null) {
            return false;
        }
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node = this.first; node != null; node = node.next) {
                if (obj.equals(node.item)) {
                    reentrantLock.unlock();
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } catch (java.lang.Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public java.lang.Object[] toArray() {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            java.lang.Object[] objArr = new java.lang.Object[this.count];
            com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node = this.first;
            int i = 0;
            while (node != null) {
                int i2 = i + 1;
                objArr[i] = node.item;
                node = node.next;
                i = i2;
            }
            reentrantLock.unlock();
            return objArr;
        } catch (java.lang.Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (tArr.length < this.count) {
                tArr = (T[]) ((java.lang.Object[]) java.lang.reflect.Array.newInstance(tArr.getClass().getComponentType(), this.count));
            }
            com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node = this.first;
            int i = 0;
            while (node != null) {
                tArr[i] = node.item;
                node = node.next;
                i++;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection
    public java.lang.String toString() {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node = this.first;
            if (node == null) {
                return "[]";
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.taobao.weex.el.parse.Operators.ARRAY_START);
            while (true) {
                java.lang.Object obj = node.item;
                if (obj == this) {
                    obj = "(this Collection)";
                }
                sb.append(obj);
                node = node.next;
                if (node == null) {
                    sb.append(com.taobao.weex.el.parse.Operators.ARRAY_END);
                    return sb.toString();
                }
                sb.append(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR);
                sb.append(' ');
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node = this.first;
            while (node != null) {
                node.item = null;
                com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node2 = node.next;
                node.prev = null;
                node.next = null;
                node = node2;
            }
            this.last = null;
            this.first = null;
            this.count = 0;
            this.notFull.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.nostra13.dcloudimageloader.core.assist.deque.BlockingDeque, com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public java.util.Iterator<E> iterator() {
        return new com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Itr();
    }

    @Override // com.nostra13.dcloudimageloader.core.assist.deque.Deque
    public java.util.Iterator<E> descendingIterator() {
        return new com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.DescendingItr();
    }

    private abstract class AbstractItr implements java.util.Iterator<E> {
        private com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> lastRet;
        com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> next;
        E nextItem;

        abstract com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> firstNode();

        abstract com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> nextNode(com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node);

        AbstractItr() {
            java.util.concurrent.locks.ReentrantLock reentrantLock = com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> nodeFirstNode = firstNode();
                this.next = nodeFirstNode;
                this.nextItem = nodeFirstNode == null ? null : nodeFirstNode.item;
            } finally {
                reentrantLock.unlock();
            }
        }

        private com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> succ(com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node) {
            while (true) {
                com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> nodeNextNode = nextNode(node);
                if (nodeNextNode == null) {
                    return null;
                }
                if (nodeNextNode.item != null) {
                    return nodeNextNode;
                }
                if (nodeNextNode == node) {
                    return firstNode();
                }
                node = nodeNextNode;
            }
        }

        void advance() {
            java.util.concurrent.locks.ReentrantLock reentrantLock = com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> nodeSucc = succ(this.next);
                this.next = nodeSucc;
                this.nextItem = nodeSucc == null ? null : nodeSucc.item;
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public E next() {
            com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node = this.next;
            if (node == null) {
                throw new java.util.NoSuchElementException();
            }
            this.lastRet = node;
            E e = this.nextItem;
            advance();
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node = this.lastRet;
            if (node == null) {
                throw new java.lang.IllegalStateException();
            }
            this.lastRet = null;
            java.util.concurrent.locks.ReentrantLock reentrantLock = com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                if (node.item != null) {
                    com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.this.unlink(node);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private class Itr extends com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque<E>.AbstractItr {
        private Itr() {
            super();
        }

        @Override // com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
        com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> firstNode() {
            return com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.this.first;
        }

        @Override // com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
        com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> nextNode(com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node) {
            return node.next;
        }
    }

    private class DescendingItr extends com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque<E>.AbstractItr {
        private DescendingItr() {
            super();
        }

        @Override // com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
        com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> firstNode() {
            return com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.this.last;
        }

        @Override // com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.AbstractItr
        com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> nextNode(com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node) {
            return node.prev;
        }
    }

    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        java.util.concurrent.locks.ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (com.nostra13.dcloudimageloader.core.assist.deque.LinkedBlockingDeque.Node<E> node = this.first; node != null; node = node.next) {
                objectOutputStream.writeObject(node.item);
            }
            objectOutputStream.writeObject(null);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.lang.ClassNotFoundException, java.io.IOException {
        objectInputStream.defaultReadObject();
        this.count = 0;
        this.first = null;
        this.last = null;
        while (true) {
            java.lang.Object object = objectInputStream.readObject();
            if (object == null) {
                return;
            } else {
                add(object);
            }
        }
    }
}
