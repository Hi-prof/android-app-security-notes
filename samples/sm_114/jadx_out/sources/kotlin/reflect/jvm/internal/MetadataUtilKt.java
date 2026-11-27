package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: MetadataUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u0002*\u00060\u0002j\u0002`\u0003H\u0000\u001a\u001e\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006*\u00020\u00072\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003H\u0000¨\u0006\t"}, d2 = {"toClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "", "Lkotlin/reflect/jvm/internal/impl/km/ClassName;", "toNonLocalSimpleName", "loadKClass", "Lkotlin/reflect/KClass;", "Ljava/lang/ClassLoader;", "name", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MetadataUtilKt {
    public static final kotlin.reflect.jvm.internal.impl.name.ClassId toClassId(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        boolean zStartsWith$default = kotlin.text.StringsKt.startsWith$default(str, com.taobao.weex.el.parse.Operators.DOT_STR, false, 2, (java.lang.Object) null);
        if (zStartsWith$default) {
            str = str.substring(1);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
        }
        return new kotlin.reflect.jvm.internal.impl.name.ClassId(new kotlin.reflect.jvm.internal.impl.name.FqName(kotlin.text.StringsKt.replace$default(kotlin.text.StringsKt.substringBeforeLast(str, '/', ""), '/', com.taobao.weex.el.parse.Operators.DOT, false, 4, (java.lang.Object) null)), new kotlin.reflect.jvm.internal.impl.name.FqName(kotlin.text.StringsKt.substringAfterLast$default(str, '/', (java.lang.String) null, 2, (java.lang.Object) null)), zStartsWith$default);
    }

    public static final java.lang.String toNonLocalSimpleName(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        if (kotlin.text.StringsKt.startsWith$default(str, com.taobao.weex.el.parse.Operators.DOT_STR, false, 2, (java.lang.Object) null)) {
            throw new java.lang.IllegalArgumentException(("Local class is not supported: " + str).toString());
        }
        return kotlin.text.StringsKt.substringAfterLast$default(kotlin.text.StringsKt.substringAfterLast$default(str, '/', (java.lang.String) null, 2, (java.lang.Object) null), com.taobao.weex.el.parse.Operators.DOT, (java.lang.String) null, 2, (java.lang.Object) null);
    }

    public static final kotlin.reflect.KClass<?> loadKClass(java.lang.ClassLoader classLoader, java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classLoader, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        java.lang.Class clsLoadClass$default = kotlin.reflect.jvm.internal.UtilKt.loadClass$default(classLoader, toClassId(name), 0, 2, null);
        if (clsLoadClass$default != null) {
            return kotlin.jvm.JvmClassMappingKt.getKotlinClass(clsLoadClass$default);
        }
        return null;
    }
}
