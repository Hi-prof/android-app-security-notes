package kotlin.reflect.jvm.internal.impl.metadata.serialization;

/* JADX INFO: compiled from: Interner.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Interner<T> {
    private final int firstIndex;
    private final java.util.HashMap<T, java.lang.Integer> interned;
    private final kotlin.reflect.jvm.internal.impl.metadata.serialization.Interner<T> parent;

    private final java.lang.Integer find(T t) {
        java.lang.Integer numFind;
        kotlin.reflect.jvm.internal.impl.metadata.serialization.Interner<T> interner = this.parent;
        if (interner != null) {
            int size = interner.interned.size() + this.parent.firstIndex;
            int i = this.firstIndex;
        }
        kotlin.reflect.jvm.internal.impl.metadata.serialization.Interner<T> interner2 = this.parent;
        return (interner2 == null || (numFind = interner2.find(t)) == null) ? this.interned.get(t) : numFind;
    }

    public final int intern(T t) {
        java.lang.Integer numFind = find(t);
        if (numFind != null) {
            return numFind.intValue();
        }
        int size = this.firstIndex + this.interned.size();
        this.interned.put(t, java.lang.Integer.valueOf(size));
        return size;
    }
}
