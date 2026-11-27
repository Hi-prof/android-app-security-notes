package kotlin.reflect.jvm.internal.impl.metadata.serialization;

/* JADX INFO: compiled from: MutableTable.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MutableTable<Element extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<?, Element>, Table extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, TableBuilder extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder<Table, TableBuilder>> {
    private final kotlin.reflect.jvm.internal.impl.metadata.serialization.Interner<kotlin.reflect.jvm.internal.impl.metadata.serialization.TableElementWrapper<Element>> interner;

    public final int get(Element type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        return this.interner.intern(new kotlin.reflect.jvm.internal.impl.metadata.serialization.TableElementWrapper<>(type));
    }
}
