package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

/* JADX INFO: compiled from: BinaryVersion.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class BinaryVersion {
    public static final kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion.Companion Companion = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion.Companion(null);
    private final int major;
    private final int minor;
    private final int[] numbers;
    private final int patch;
    private final java.util.List<java.lang.Integer> rest;

    public BinaryVersion(int... numbers) {
        java.util.List<java.lang.Integer> listEmptyList;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(numbers, "numbers");
        this.numbers = numbers;
        java.lang.Integer orNull = kotlin.collections.ArraysKt.getOrNull(numbers, 0);
        this.major = orNull != null ? orNull.intValue() : -1;
        java.lang.Integer orNull2 = kotlin.collections.ArraysKt.getOrNull(numbers, 1);
        this.minor = orNull2 != null ? orNull2.intValue() : -1;
        java.lang.Integer orNull3 = kotlin.collections.ArraysKt.getOrNull(numbers, 2);
        this.patch = orNull3 != null ? orNull3.intValue() : -1;
        if (numbers.length > 3) {
            if (numbers.length > 1024) {
                throw new java.lang.IllegalArgumentException("BinaryVersion with length more than 1024 are not supported. Provided length " + numbers.length + com.taobao.weex.el.parse.Operators.DOT);
            }
            listEmptyList = kotlin.collections.CollectionsKt.toList(kotlin.collections.ArraysKt.asList(numbers).subList(3, numbers.length));
        } else {
            listEmptyList = kotlin.collections.CollectionsKt.emptyList();
        }
        this.rest = listEmptyList;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int[] toArray() {
        return this.numbers;
    }

    protected final boolean isCompatibleTo(kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion ourVersion) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(ourVersion, "ourVersion");
        int i = this.major;
        if (i == 0) {
            return ourVersion.major == 0 && this.minor == ourVersion.minor;
        }
        return i == ourVersion.major && this.minor <= ourVersion.minor;
    }

    public final boolean isAtLeast(kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion version) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(version, "version");
        return isAtLeast(version.major, version.minor, version.patch);
    }

    public final boolean isAtLeast(int i, int i2, int i3) {
        int i4 = this.major;
        if (i4 > i) {
            return true;
        }
        if (i4 < i) {
            return false;
        }
        int i5 = this.minor;
        if (i5 > i2) {
            return true;
        }
        return i5 >= i2 && this.patch >= i3;
    }

    public final boolean isAtMost(int i, int i2, int i3) {
        int i4 = this.major;
        if (i4 < i) {
            return true;
        }
        if (i4 > i) {
            return false;
        }
        int i5 = this.minor;
        if (i5 < i2) {
            return true;
        }
        return i5 <= i2 && this.patch <= i3;
    }

    public java.lang.String toString() {
        int[] array = toArray();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i : array) {
            if (i == -1) {
                break;
            }
            arrayList.add(java.lang.Integer.valueOf(i));
        }
        java.util.ArrayList arrayList2 = arrayList;
        return arrayList2.isEmpty() ? "unknown" : kotlin.collections.CollectionsKt.joinToString$default(arrayList2, com.taobao.weex.el.parse.Operators.DOT_STR, null, null, 0, null, null, 62, null);
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == null || !kotlin.jvm.internal.Intrinsics.areEqual(getClass(), obj.getClass())) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion binaryVersion = (kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion) obj;
        return this.major == binaryVersion.major && this.minor == binaryVersion.minor && this.patch == binaryVersion.patch && kotlin.jvm.internal.Intrinsics.areEqual(this.rest, binaryVersion.rest);
    }

    public int hashCode() {
        int i = this.major;
        int i2 = i + (i * 31) + this.minor;
        int i3 = i2 + (i2 * 31) + this.patch;
        return i3 + (i3 * 31) + this.rest.hashCode();
    }

    /* JADX INFO: compiled from: BinaryVersion.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
