package io.dcloud.nineoldandroids.util;

/* JADX INFO: loaded from: classes2.dex */
public abstract class IntProperty<T> extends io.dcloud.nineoldandroids.util.Property<T, java.lang.Integer> {
    public abstract void setValue(T t, int i);

    public IntProperty(java.lang.String str) {
        super(java.lang.Integer.class, str);
    }

    @Override // io.dcloud.nineoldandroids.util.Property
    public final void set(T t, java.lang.Integer num) {
        num.intValue();
        set((java.lang.Object) t, num);
    }
}
