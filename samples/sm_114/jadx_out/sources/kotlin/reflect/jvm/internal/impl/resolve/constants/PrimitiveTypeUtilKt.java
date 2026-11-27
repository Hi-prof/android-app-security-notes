package kotlin.reflect.jvm.internal.impl.resolve.constants;

/* JADX INFO: compiled from: PrimitiveTypeUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PrimitiveTypeUtilKt {
    public static final java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> getAllSignedLiteralTypes(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        return kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.types.SimpleType[]{moduleDescriptor.getBuiltIns().getIntType(), moduleDescriptor.getBuiltIns().getLongType(), moduleDescriptor.getBuiltIns().getByteType(), moduleDescriptor.getBuiltIns().getShortType()});
    }
}
