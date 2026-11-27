package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

/* JADX INFO: compiled from: ReflectKotlinClassFinder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectKotlinClassFinderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String toRuntimeFqName(kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
        java.lang.String strReplace$default = kotlin.text.StringsKt.replace$default(classId.getRelativeClassName().asString(), com.taobao.weex.el.parse.Operators.DOT, '$', false, 4, (java.lang.Object) null);
        if (classId.getPackageFqName().isRoot()) {
            return strReplace$default;
        }
        return classId.getPackageFqName() + com.taobao.weex.el.parse.Operators.DOT + strReplace$default;
    }
}
