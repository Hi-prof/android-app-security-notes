package kotlin.reflect.jvm.internal.impl.descriptors.impl;

/* JADX INFO: compiled from: ModuleAwareClassDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModuleAwareClassDescriptorKt {
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getRefinedUnsubstitutedMemberScopeIfPossible(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor.Companion.getRefinedUnsubstitutedMemberScopeIfPossible$descriptors(classDescriptor, kotlinTypeRefiner);
    }

    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getRefinedMemberScopeIfPossible(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.types.TypeSubstitution typeSubstitution, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeSubstitution, "typeSubstitution");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor.Companion.getRefinedMemberScopeIfPossible$descriptors(classDescriptor, typeSubstitution, kotlinTypeRefiner);
    }
}
