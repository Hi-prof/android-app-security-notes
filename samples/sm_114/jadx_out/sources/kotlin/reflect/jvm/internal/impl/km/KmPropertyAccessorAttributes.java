package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: Nodes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class KmPropertyAccessorAttributes {
    private final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations;
    private int flags;

    public KmPropertyAccessorAttributes(int i) {
        this.flags = i;
        this.annotations = new java.util.ArrayList(0);
    }

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final void setFlags$kotlin_metadata(int i) {
        this.flags = i;
    }

    public KmPropertyAccessorAttributes() {
        this(0);
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> getAnnotations() {
        return this.annotations;
    }
}
