package com.taobao.weex.el.parse;

/* JADX INFO: loaded from: classes.dex */
public class ArrayStack<T> {
    private java.util.ArrayList<T> stack = new java.util.ArrayList<>(4);

    public int size() {
        return this.stack.size();
    }

    public T pop() {
        java.util.ArrayList<T> arrayList = this.stack;
        return arrayList.remove(arrayList.size() - 1);
    }

    public void push(T t) {
        this.stack.add(t);
    }

    public T peek() {
        java.util.ArrayList<T> arrayList = this.stack;
        return arrayList.get(arrayList.size() - 1);
    }

    public T get(int i) {
        return this.stack.get(i);
    }

    public T remove(int i) {
        return this.stack.remove(i);
    }

    public void add(int i, T t) {
        this.stack.add(i, t);
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public java.util.List<T> getList() {
        return this.stack;
    }
}
