package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

/* JADX INFO: compiled from: JvmNameResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmNameResolver extends kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolverBase {
    private final kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes types;

    /* JADX WARN: Illegal instructions before constructor call */
    public JvmNameResolver(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes types, java.lang.String[] strings) {
        java.util.Set set;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(types, "types");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(strings, "strings");
        java.util.List<java.lang.Integer> localNameList = types.getLocalNameList();
        if (localNameList.isEmpty()) {
            set = kotlin.collections.SetsKt.emptySet();
        } else {
            kotlin.jvm.internal.Intrinsics.checkNotNull(localNameList);
            set = kotlin.collections.CollectionsKt.toSet(localNameList);
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record> recordList = types.getRecordList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(recordList, "getRecordList(...)");
        super(strings, set, kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolverKt.toExpandedRecordsList(recordList));
        this.types = types;
    }
}
