package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: ModuleCapability.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModuleCapability<T> {
    private final java.lang.String name;

    public ModuleCapability(java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
    }

    public java.lang.String toString() {
        return this.name;
    }
}
