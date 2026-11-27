package kotlin.reflect.full;

/* JADX INFO: compiled from: KTypes.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0007¨\u0006\u0007"}, d2 = {"withNullability", "Lkotlin/reflect/KType;", "nullable", "", "isSubtypeOf", "other", "isSupertypeOf", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KTypes {
    public static final kotlin.reflect.KType withNullability(kotlin.reflect.KType kType, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kType, "<this>");
        return ((kotlin.reflect.jvm.internal.KTypeImpl) kType).makeNullableAsSpecified$kotlin_reflection(z);
    }

    public static final boolean isSubtypeOf(kotlin.reflect.KType kType, kotlin.reflect.KType other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kType, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        return kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isSubtypeOf(((kotlin.reflect.jvm.internal.KTypeImpl) kType).getType(), ((kotlin.reflect.jvm.internal.KTypeImpl) other).getType());
    }

    public static final boolean isSupertypeOf(kotlin.reflect.KType kType, kotlin.reflect.KType other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kType, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        return isSubtypeOf(other, kType);
    }
}
