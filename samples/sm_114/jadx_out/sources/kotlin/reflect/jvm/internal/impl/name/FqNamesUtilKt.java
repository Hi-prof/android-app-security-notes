package kotlin.reflect.jvm.internal.impl.name;

/* JADX INFO: compiled from: FqNamesUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FqNamesUtilKt {

    /* JADX INFO: compiled from: FqNamesUtil.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.name.State.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.name.State.BEGINNING.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.name.State.AFTER_DOT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.name.State.MIDDLE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isSubpackageOf(kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.reflect.jvm.internal.impl.name.FqName packageName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (kotlin.jvm.internal.Intrinsics.areEqual(fqName, packageName) || packageName.isRoot()) {
            return true;
        }
        return isSubpackageOf(fqName.asString(), packageName.asString());
    }

    public static final boolean isChildOf(kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.reflect.jvm.internal.impl.name.FqName packageName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageName, "packageName");
        return kotlin.jvm.internal.Intrinsics.areEqual(parentOrNull(fqName), packageName);
    }

    private static final boolean isSubpackageOf(java.lang.String str, java.lang.String str2) {
        return kotlin.text.StringsKt.startsWith$default(str, str2, false, 2, (java.lang.Object) null) && str.charAt(str2.length()) == '.';
    }

    public static final kotlin.reflect.jvm.internal.impl.name.FqName tail(kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.reflect.jvm.internal.impl.name.FqName prefix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!isSubpackageOf(fqName, prefix) || prefix.isRoot()) {
            return fqName;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(fqName, prefix)) {
            return kotlin.reflect.jvm.internal.impl.name.FqName.ROOT;
        }
        java.lang.String strSubstring = fqName.asString().substring(prefix.asString().length() + 1);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return new kotlin.reflect.jvm.internal.impl.name.FqName(strSubstring);
    }

    public static final kotlin.reflect.jvm.internal.impl.name.FqName parentOrNull(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "<this>");
        if (fqName.isRoot()) {
            return null;
        }
        return fqName.parent();
    }

    public static final boolean isValidJavaFqName(java.lang.String str) {
        if (str == null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.name.State state = kotlin.reflect.jvm.internal.impl.name.State.BEGINNING;
        int i = 0;
        while (true) {
            java.lang.String str2 = str;
            if (i >= str2.length()) {
                return state != kotlin.reflect.jvm.internal.impl.name.State.AFTER_DOT;
            }
            char cCharAt = str2.charAt(i);
            int i2 = kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt.WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i2 == 1 || i2 == 2) {
                if (!java.lang.Character.isJavaIdentifierStart(cCharAt)) {
                    return false;
                }
                state = kotlin.reflect.jvm.internal.impl.name.State.MIDDLE;
            } else {
                if (i2 != 3) {
                    throw new kotlin.NoWhenBranchMatchedException();
                }
                if (cCharAt == '.') {
                    state = kotlin.reflect.jvm.internal.impl.name.State.AFTER_DOT;
                } else if (!java.lang.Character.isJavaIdentifierPart(cCharAt)) {
                    return false;
                }
            }
            i++;
        }
    }

    public static final <V> V findValueForMostSpecificFqname(kotlin.reflect.jvm.internal.impl.name.FqName fqName, java.util.Map<kotlin.reflect.jvm.internal.impl.name.FqName, ? extends V> values) {
        java.lang.Object next;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(values, "values");
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (java.util.Map.Entry<kotlin.reflect.jvm.internal.impl.name.FqName, ? extends V> entry : values.entrySet()) {
            kotlin.reflect.jvm.internal.impl.name.FqName key = entry.getKey();
            if (kotlin.jvm.internal.Intrinsics.areEqual(fqName, key) || isChildOf(fqName, key)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (linkedHashMap.isEmpty()) {
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            return null;
        }
        java.util.Iterator it = linkedHashMap.entrySet().iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int length = tail((kotlin.reflect.jvm.internal.impl.name.FqName) ((java.util.Map.Entry) next).getKey(), fqName).asString().length();
                do {
                    java.lang.Object next2 = it.next();
                    int length2 = tail((kotlin.reflect.jvm.internal.impl.name.FqName) ((java.util.Map.Entry) next2).getKey(), fqName).asString().length();
                    if (length > length2) {
                        next = next2;
                        length = length2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        java.util.Map.Entry entry2 = (java.util.Map.Entry) next;
        if (entry2 != null) {
            return (V) entry2.getValue();
        }
        return null;
    }
}
