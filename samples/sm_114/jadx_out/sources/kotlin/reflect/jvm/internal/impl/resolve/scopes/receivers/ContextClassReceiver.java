package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

/* JADX INFO: compiled from: ContextClassReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContextClassReceiver extends kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.AbstractReceiverValue implements kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver {
    private final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor;
    private final kotlin.reflect.jvm.internal.impl.name.Name customLabelName;

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitContextReceiver
    public kotlin.reflect.jvm.internal.impl.name.Name getCustomLabelName() {
        return this.customLabelName;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextClassReceiver(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.types.KotlinType receiverType, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue receiverValue) {
        super(receiverType, receiverValue);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(receiverType, "receiverType");
        this.classDescriptor = classDescriptor;
        this.customLabelName = name;
    }

    public java.lang.String toString() {
        return getType() + ": Ctx { " + this.classDescriptor + " }";
    }
}
