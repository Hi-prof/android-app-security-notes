package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

/* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class DeserializedClassDescriptor$memberScopeHolder$1 extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope> {
    DeserializedClassDescriptor$memberScopeHolder$1(java.lang.Object obj) {
        super(1, obj, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope.class, "<init>", "<init>(Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lorg/jetbrains/kotlin/types/checker/KotlinTypeRefiner;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope invoke2(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner p0) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p0, "p0");
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor) this.receiver, p0);
    }
}
