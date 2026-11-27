package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: util.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\fJ!\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\t\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/CreateKCallableVisitor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorVisitorEmptyBodies;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", com.taobao.weex.ui.component.WXBasicComponentType.CONTAINER, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "visitPropertyDescriptor", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "data", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "visitFunctionDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class CreateKCallableVisitor extends kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies<kotlin.reflect.jvm.internal.KCallableImpl<?>, kotlin.Unit> {
    private final kotlin.reflect.jvm.internal.KDeclarationContainerImpl container;

    public CreateKCallableVisitor(kotlin.reflect.jvm.internal.KDeclarationContainerImpl container) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        this.container = container;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public kotlin.reflect.jvm.internal.KCallableImpl<?> visitPropertyDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor descriptor, kotlin.Unit data) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        int i = (descriptor.getDispatchReceiverParameter() != null ? 1 : 0) + (descriptor.getExtensionReceiverParameter() != null ? 1 : 0);
        if (descriptor.isVar()) {
            if (i == 0) {
                return new kotlin.reflect.jvm.internal.KMutableProperty0Impl(this.container, descriptor);
            }
            if (i == 1) {
                return new kotlin.reflect.jvm.internal.KMutableProperty1Impl(this.container, descriptor);
            }
            if (i == 2) {
                return new kotlin.reflect.jvm.internal.KMutableProperty2Impl(this.container, descriptor);
            }
        } else {
            if (i == 0) {
                return new kotlin.reflect.jvm.internal.KProperty0Impl(this.container, descriptor);
            }
            if (i == 1) {
                return new kotlin.reflect.jvm.internal.KProperty1Impl(this.container, descriptor);
            }
            if (i == 2) {
                return new kotlin.reflect.jvm.internal.KProperty2Impl(this.container, descriptor);
            }
        }
        throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Unsupported property: " + descriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
    public kotlin.reflect.jvm.internal.KCallableImpl<?> visitFunctionDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor descriptor, kotlin.Unit data) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        return new kotlin.reflect.jvm.internal.KFunctionImpl(this.container, descriptor);
    }
}
