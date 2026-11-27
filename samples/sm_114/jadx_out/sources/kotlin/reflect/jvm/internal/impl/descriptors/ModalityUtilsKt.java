package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: ModalityUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModalityUtilsKt {
    public static final boolean isFinalClass(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        return classDescriptor.getModality() == kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL && classDescriptor.getKind() != kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_CLASS;
    }
}
