package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

/* JADX INFO: compiled from: JavaForKotlinOverridePropertyDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JavaForKotlinOverridePropertyDescriptor extends kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaPropertyDescriptor {
    private final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor getterMethod;
    private final kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor overriddenProperty;
    private final kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor setterMethod;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaForKotlinOverridePropertyDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ownerDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor getterMethod, kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor simpleFunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor overriddenProperty) {
        super(ownerDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY(), getterMethod.getModality(), getterMethod.getVisibility(), simpleFunctionDescriptor != null, overriddenProperty.getName(), getterMethod.getSource(), null, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION, false, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(ownerDescriptor, "ownerDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(getterMethod, "getterMethod");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(overriddenProperty, "overriddenProperty");
        this.getterMethod = getterMethod;
        this.setterMethod = simpleFunctionDescriptor;
        this.overriddenProperty = overriddenProperty;
    }
}
