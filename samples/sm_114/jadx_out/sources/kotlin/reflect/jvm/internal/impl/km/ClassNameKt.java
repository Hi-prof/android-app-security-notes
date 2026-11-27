package kotlin.reflect.jvm.internal.impl.km;

/* JADX INFO: compiled from: ClassName.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ClassNameKt {
    public static final boolean isLocalClassName(java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        return kotlin.text.StringsKt.startsWith$default(str, com.taobao.weex.el.parse.Operators.DOT_STR, false, 2, (java.lang.Object) null);
    }
}
