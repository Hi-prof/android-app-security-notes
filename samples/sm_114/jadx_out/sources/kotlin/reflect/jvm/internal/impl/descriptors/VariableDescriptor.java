package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: loaded from: classes2.dex */
public interface VariableDescriptor extends kotlin.reflect.jvm.internal.impl.descriptors.ValueDescriptor {
    /* JADX INFO: renamed from: getCompileTimeInitializer */
    kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> mo1827getCompileTimeInitializer();

    boolean isConst();

    boolean isLateInit();

    boolean isVar();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor substitute(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutor);
}
