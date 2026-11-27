package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

/* JADX INFO: compiled from: JvmNameResolverBase.kt */
/* JADX INFO: loaded from: classes2.dex */
public class JvmNameResolverBase implements kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver {
    public static final kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolverBase.Companion Companion = new kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolverBase.Companion(null);
    private static final java.util.List<java.lang.String> PREDEFINED_STRINGS;
    private static final java.util.Map<java.lang.String, java.lang.Integer> PREDEFINED_STRINGS_MAP;

    /* JADX INFO: renamed from: kotlin, reason: collision with root package name */
    private static final java.lang.String f9kotlin;
    private final java.util.Set<java.lang.Integer> localNameIndices;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record> records;
    private final java.lang.String[] strings;

    /* JADX INFO: compiled from: JvmNameResolverBase.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public JvmNameResolverBase(java.lang.String[] strings, java.util.Set<java.lang.Integer> localNameIndices, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record> records) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(strings, "strings");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(localNameIndices, "localNameIndices");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(records, "records");
        this.strings = strings;
        this.localNameIndices = localNameIndices;
        this.records = records;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0035  */
    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public java.lang.String getString(int i) {
        java.lang.String strSubstring;
        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record record = this.records.get(i);
        if (record.hasString()) {
            strSubstring = record.getString();
        } else if (record.hasPredefinedIndex()) {
            java.util.List<java.lang.String> list = PREDEFINED_STRINGS;
            int size = list.size();
            int predefinedIndex = record.getPredefinedIndex();
            if (predefinedIndex >= 0 && predefinedIndex < size) {
                strSubstring = list.get(record.getPredefinedIndex());
            } else {
                strSubstring = this.strings[i];
            }
        } else {
            strSubstring = this.strings[i];
        }
        if (record.getSubstringIndexCount() >= 2) {
            java.util.List<java.lang.Integer> substringIndexList = record.getSubstringIndexList();
            kotlin.jvm.internal.Intrinsics.checkNotNull(substringIndexList);
            java.lang.Integer num = substringIndexList.get(0);
            java.lang.Integer num2 = substringIndexList.get(1);
            if (num.intValue() >= 0 && num.intValue() <= num2.intValue() && num2.intValue() <= strSubstring.length()) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(strSubstring);
                kotlin.jvm.internal.Intrinsics.checkNotNull(num);
                int iIntValue = num.intValue();
                kotlin.jvm.internal.Intrinsics.checkNotNull(num2);
                strSubstring = strSubstring.substring(iIntValue, num2.intValue());
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            }
        }
        java.lang.String strReplace$default = strSubstring;
        if (record.getReplaceCharCount() >= 2) {
            java.util.List<java.lang.Integer> replaceCharList = record.getReplaceCharList();
            kotlin.jvm.internal.Intrinsics.checkNotNull(replaceCharList);
            java.lang.Integer num3 = replaceCharList.get(0);
            java.lang.Integer num4 = replaceCharList.get(1);
            kotlin.jvm.internal.Intrinsics.checkNotNull(strReplace$default);
            strReplace$default = kotlin.text.StringsKt.replace$default(strReplace$default, (char) num3.intValue(), (char) num4.intValue(), false, 4, (java.lang.Object) null);
        }
        java.lang.String strReplace$default2 = strReplace$default;
        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.Operation operation = record.getOperation();
        if (operation == null) {
            operation = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        int i2 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolverBase.WhenMappings.$EnumSwitchMapping$0[operation.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(strReplace$default2);
                strReplace$default2 = kotlin.text.StringsKt.replace$default(strReplace$default2, '$', com.taobao.weex.el.parse.Operators.DOT, false, 4, (java.lang.Object) null);
            } else {
                if (i2 != 3) {
                    throw new kotlin.NoWhenBranchMatchedException();
                }
                if (strReplace$default2.length() >= 2) {
                    kotlin.jvm.internal.Intrinsics.checkNotNull(strReplace$default2);
                    strReplace$default2 = strReplace$default2.substring(1, strReplace$default2.length() - 1);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strReplace$default2, "substring(...)");
                }
                java.lang.String str = strReplace$default2;
                kotlin.jvm.internal.Intrinsics.checkNotNull(str);
                strReplace$default2 = kotlin.text.StringsKt.replace$default(str, '$', com.taobao.weex.el.parse.Operators.DOT, false, 4, (java.lang.Object) null);
            }
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(strReplace$default2);
        return strReplace$default2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public java.lang.String getQualifiedClassName(int i) {
        return getString(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int i) {
        return this.localNameIndices.contains(java.lang.Integer.valueOf(i));
    }

    /* JADX INFO: compiled from: JvmNameResolverBase.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        java.lang.String strJoinToString$default = kotlin.collections.CollectionsKt.joinToString$default(kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new java.lang.Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
        f9kotlin = strJoinToString$default;
        java.util.List<java.lang.String> listListOf = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new java.lang.String[]{strJoinToString$default + "/Any", strJoinToString$default + "/Nothing", strJoinToString$default + "/Unit", strJoinToString$default + "/Throwable", strJoinToString$default + "/Number", strJoinToString$default + "/Byte", strJoinToString$default + "/Double", strJoinToString$default + "/Float", strJoinToString$default + "/Int", strJoinToString$default + "/Long", strJoinToString$default + "/Short", strJoinToString$default + "/Boolean", strJoinToString$default + "/Char", strJoinToString$default + "/CharSequence", strJoinToString$default + "/String", strJoinToString$default + "/Comparable", strJoinToString$default + "/Enum", strJoinToString$default + "/Array", strJoinToString$default + "/ByteArray", strJoinToString$default + "/DoubleArray", strJoinToString$default + "/FloatArray", strJoinToString$default + "/IntArray", strJoinToString$default + "/LongArray", strJoinToString$default + "/ShortArray", strJoinToString$default + "/BooleanArray", strJoinToString$default + "/CharArray", strJoinToString$default + "/Cloneable", strJoinToString$default + "/Annotation", strJoinToString$default + "/collections/Iterable", strJoinToString$default + "/collections/MutableIterable", strJoinToString$default + "/collections/Collection", strJoinToString$default + "/collections/MutableCollection", strJoinToString$default + "/collections/List", strJoinToString$default + "/collections/MutableList", strJoinToString$default + "/collections/Set", strJoinToString$default + "/collections/MutableSet", strJoinToString$default + "/collections/Map", strJoinToString$default + "/collections/MutableMap", strJoinToString$default + "/collections/Map.Entry", strJoinToString$default + "/collections/MutableMap.MutableEntry", strJoinToString$default + "/collections/Iterator", strJoinToString$default + "/collections/MutableIterator", strJoinToString$default + "/collections/ListIterator", strJoinToString$default + "/collections/MutableListIterator"});
        PREDEFINED_STRINGS = listListOf;
        java.lang.Iterable<kotlin.collections.IndexedValue> iterableWithIndex = kotlin.collections.CollectionsKt.withIndex(listListOf);
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(kotlin.ranges.RangesKt.coerceAtLeast(kotlin.collections.MapsKt.mapCapacity(kotlin.collections.CollectionsKt.collectionSizeOrDefault(iterableWithIndex, 10)), 16));
        for (kotlin.collections.IndexedValue indexedValue : iterableWithIndex) {
            linkedHashMap.put((java.lang.String) indexedValue.getValue(), java.lang.Integer.valueOf(indexedValue.getIndex()));
        }
        PREDEFINED_STRINGS_MAP = linkedHashMap;
    }
}
