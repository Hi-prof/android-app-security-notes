package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: BuiltinSpecialProperties.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BuiltinSpecialPropertiesKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.FqName child(kotlin.reflect.jvm.internal.impl.name.FqName fqName, java.lang.String str) {
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        return fqName.child(nameIdentifier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.FqName childSafe(kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe, java.lang.String str) {
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        return fqNameUnsafe.child(nameIdentifier).toSafe();
    }
}
