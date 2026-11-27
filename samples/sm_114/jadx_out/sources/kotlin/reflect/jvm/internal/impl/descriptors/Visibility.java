package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: Visibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Visibility {
    private final boolean isPublicAPI;
    private final java.lang.String name;

    public kotlin.reflect.jvm.internal.impl.descriptors.Visibility normalize() {
        return this;
    }

    protected Visibility(java.lang.String name, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.isPublicAPI = z;
    }

    public final boolean isPublicAPI() {
        return this.isPublicAPI;
    }

    public java.lang.String getInternalDisplayName() {
        return this.name;
    }

    public java.lang.Integer compareTo(kotlin.reflect.jvm.internal.impl.descriptors.Visibility visibility) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visibility, "visibility");
        return kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.INSTANCE.compareLocal$compiler_common(this, visibility);
    }

    public final java.lang.String toString() {
        return getInternalDisplayName();
    }
}
