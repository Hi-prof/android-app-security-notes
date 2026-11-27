package kotlin.reflect.jvm.internal.impl.metadata.serialization;

/* JADX INFO: compiled from: MutableTable.kt */
/* JADX INFO: loaded from: classes2.dex */
final class TableElementWrapper<Element extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<?, Element>> {
    private final Element builder;
    private final byte[] bytes;
    private final int hashCode;

    public TableElementWrapper(Element builder) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        byte[] byteArray = builder.build().toByteArray();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        this.bytes = byteArray;
        this.hashCode = java.util.Arrays.hashCode(byteArray);
    }

    public int hashCode() {
        return this.hashCode;
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof kotlin.reflect.jvm.internal.impl.metadata.serialization.TableElementWrapper) && java.util.Arrays.equals(this.bytes, ((kotlin.reflect.jvm.internal.impl.metadata.serialization.TableElementWrapper) obj).bytes);
    }
}
