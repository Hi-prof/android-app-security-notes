package kotlin.reflect.jvm.internal.impl.name;

/* JADX INFO: compiled from: FqName.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FqName {
    public static final kotlin.reflect.jvm.internal.impl.name.FqName.Companion Companion = new kotlin.reflect.jvm.internal.impl.name.FqName.Companion(null);
    public static final kotlin.reflect.jvm.internal.impl.name.FqName ROOT = new kotlin.reflect.jvm.internal.impl.name.FqName("");
    private final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqName;
    private transient kotlin.reflect.jvm.internal.impl.name.FqName parent;

    public FqName(java.lang.String fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        this.fqName = new kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe(fqName, this);
    }

    public FqName(kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        this.fqName = fqName;
    }

    private FqName(kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe, kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        this.fqName = fqNameUnsafe;
        this.parent = fqName;
    }

    public final java.lang.String asString() {
        return this.fqName.asString();
    }

    public final kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe toUnsafe() {
        return this.fqName;
    }

    public final boolean isRoot() {
        return this.fqName.isRoot();
    }

    public final kotlin.reflect.jvm.internal.impl.name.FqName parent() {
        kotlin.reflect.jvm.internal.impl.name.FqName fqName = this.parent;
        if (fqName != null) {
            return fqName;
        }
        if (isRoot()) {
            throw new java.lang.IllegalStateException("root".toString());
        }
        kotlin.reflect.jvm.internal.impl.name.FqName fqName2 = new kotlin.reflect.jvm.internal.impl.name.FqName(this.fqName.parent());
        this.parent = fqName2;
        return fqName2;
    }

    public final kotlin.reflect.jvm.internal.impl.name.FqName child(kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        return new kotlin.reflect.jvm.internal.impl.name.FqName(this.fqName.child(name), this);
    }

    public final kotlin.reflect.jvm.internal.impl.name.Name shortName() {
        return this.fqName.shortName();
    }

    public final kotlin.reflect.jvm.internal.impl.name.Name shortNameOrSpecial() {
        return this.fqName.shortNameOrSpecial();
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> pathSegments() {
        return this.fqName.pathSegments();
    }

    public final boolean startsWith(kotlin.reflect.jvm.internal.impl.name.Name segment) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(segment, "segment");
        return this.fqName.startsWith(segment);
    }

    public java.lang.String toString() {
        return this.fqName.toString();
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof kotlin.reflect.jvm.internal.impl.name.FqName) && kotlin.jvm.internal.Intrinsics.areEqual(this.fqName, ((kotlin.reflect.jvm.internal.impl.name.FqName) obj).fqName);
    }

    public int hashCode() {
        return this.fqName.hashCode();
    }

    /* JADX INFO: compiled from: FqName.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @kotlin.jvm.JvmStatic
        public final kotlin.reflect.jvm.internal.impl.name.FqName topLevel(kotlin.reflect.jvm.internal.impl.name.Name shortName) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(shortName, "shortName");
            return new kotlin.reflect.jvm.internal.impl.name.FqName(kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe.Companion.topLevel(shortName));
        }
    }
}
