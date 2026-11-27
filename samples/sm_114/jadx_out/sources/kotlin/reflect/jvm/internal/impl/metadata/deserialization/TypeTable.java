package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

/* JADX INFO: compiled from: TypeTable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeTable {
    private final java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type> types;

    public TypeTable(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable typeTable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        java.util.ArrayList typeList = typeTable.getTypeList();
        if (typeTable.hasFirstNullable()) {
            int firstNullable = typeTable.getFirstNullable();
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type> typeList2 = typeTable.getTypeList();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeList2, "getTypeList(...)");
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type> list = typeList2;
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
            int i = 0;
            for (java.lang.Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    kotlin.collections.CollectionsKt.throwIndexOverflow();
                }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type typeBuild = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) obj;
                if (i >= firstNullable) {
                    typeBuild = typeBuild.toBuilder().setNullable(true).build();
                }
                arrayList.add(typeBuild);
                i = i2;
            }
            typeList = arrayList;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeList, "run(...)");
        this.types = typeList;
    }

    public final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type get(int i) {
        return this.types.get(i);
    }
}
