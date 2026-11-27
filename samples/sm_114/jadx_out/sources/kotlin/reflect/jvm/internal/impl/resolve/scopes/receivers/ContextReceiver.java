package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

/* JADX INFO: compiled from: ContextReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContextReceiver extends kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.AbstractReceiverValue implements kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver {
    private final kotlin.reflect.jvm.internal.impl.name.Name customLabelName;
    private final kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor declarationDescriptor;

    public kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor getDeclarationDescriptor() {
        return this.declarationDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver
    public kotlin.reflect.jvm.internal.impl.name.Name getCustomLabelName() {
        return this.customLabelName;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextReceiver(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor declarationDescriptor, kotlin.reflect.jvm.internal.impl.types.KotlinType receiverType, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue receiverValue) {
        super(receiverType, receiverValue);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(declarationDescriptor, "declarationDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiverType, "receiverType");
        this.declarationDescriptor = declarationDescriptor;
        this.customLabelName = name;
    }

    public java.lang.String toString() {
        return "Cxt { " + getDeclarationDescriptor() + " }";
    }
}
