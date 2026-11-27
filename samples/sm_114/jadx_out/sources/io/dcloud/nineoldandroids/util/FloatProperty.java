package io.dcloud.nineoldandroids.util;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FloatProperty<T> extends io.dcloud.nineoldandroids.util.Property<T, java.lang.Float> {
    public abstract void setValue(T t, float f);

    public FloatProperty(java.lang.String str) {
        super(java.lang.Float.class, str);
    }

    @Override // io.dcloud.nineoldandroids.util.Property
    public final void set(T t, java.lang.Float f) {
        setValue(t, f.floatValue());
    }
}
