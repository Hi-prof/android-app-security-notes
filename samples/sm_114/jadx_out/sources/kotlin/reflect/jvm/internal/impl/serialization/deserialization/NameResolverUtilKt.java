package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: compiled from: NameResolverUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NameResolverUtilKt {
    public static final kotlin.reflect.jvm.internal.impl.name.ClassId getClassId(kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "<this>");
        return kotlin.reflect.jvm.internal.impl.name.ClassId.Companion.fromString(nameResolver.getQualifiedClassName(i), nameResolver.isLocalClassName(i));
    }

    public static final kotlin.reflect.jvm.internal.impl.name.Name getName(kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "<this>");
        kotlin.reflect.jvm.internal.impl.name.Name nameGuessByFirstCharacter = kotlin.reflect.jvm.internal.impl.name.Name.guessByFirstCharacter(nameResolver.getString(i));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameGuessByFirstCharacter, "guessByFirstCharacter(...)");
        return nameGuessByFirstCharacter;
    }
}
