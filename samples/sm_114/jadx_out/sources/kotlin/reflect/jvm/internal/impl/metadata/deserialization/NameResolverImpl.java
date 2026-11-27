package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

/* JADX INFO: compiled from: NameResolverImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NameResolverImpl implements kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver {
    private final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable qualifiedNames;
    private final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable strings;

    /* JADX INFO: compiled from: NameResolverImpl.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.Kind.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.Kind.CLASS.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.Kind.PACKAGE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.Kind.LOCAL.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NameResolverImpl(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable strings, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable qualifiedNames) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(strings, "strings");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(qualifiedNames, "qualifiedNames");
        this.strings = strings;
        this.qualifiedNames = qualifiedNames;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public java.lang.String getString(int i) {
        java.lang.String string = this.strings.getString(i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public java.lang.String getQualifiedClassName(int i) {
        kotlin.Triple<java.util.List<java.lang.String>, java.util.List<java.lang.String>, java.lang.Boolean> tripleTraverseIds = traverseIds(i);
        java.util.List<java.lang.String> listComponent1 = tripleTraverseIds.component1();
        java.lang.String strJoinToString$default = kotlin.collections.CollectionsKt.joinToString$default(tripleTraverseIds.component2(), com.taobao.weex.el.parse.Operators.DOT_STR, null, null, 0, null, null, 62, null);
        if (listComponent1.isEmpty()) {
            return strJoinToString$default;
        }
        return kotlin.collections.CollectionsKt.joinToString$default(listComponent1, "/", null, null, 0, null, null, 62, null) + '/' + strJoinToString$default;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int i) {
        return traverseIds(i).getThird().booleanValue();
    }

    private final kotlin.Triple<java.util.List<java.lang.String>, java.util.List<java.lang.String>, java.lang.Boolean> traverseIds(int i) {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        java.util.LinkedList linkedList2 = new java.util.LinkedList();
        boolean z = false;
        while (i != -1) {
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName qualifiedName = this.qualifiedNames.getQualifiedName(i);
            java.lang.String string = this.strings.getString(qualifiedName.getShortName());
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.Kind kind = qualifiedName.getKind();
            kotlin.jvm.internal.Intrinsics.checkNotNull(kind);
            int i2 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolverImpl.WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
            if (i2 == 1) {
                linkedList2.addFirst(string);
            } else if (i2 == 2) {
                linkedList.addFirst(string);
            } else {
                if (i2 != 3) {
                    throw new kotlin.NoWhenBranchMatchedException();
                }
                linkedList2.addFirst(string);
                z = true;
            }
            i = qualifiedName.getParentQualifiedName();
        }
        return new kotlin.Triple<>(linkedList, linkedList2, java.lang.Boolean.valueOf(z));
    }
}
