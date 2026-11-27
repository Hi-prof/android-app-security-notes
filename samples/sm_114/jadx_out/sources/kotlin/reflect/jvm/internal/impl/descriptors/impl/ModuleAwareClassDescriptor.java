package kotlin.reflect.jvm.internal.impl.descriptors.impl;

/* JADX INFO: compiled from: ModuleAwareClassDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ModuleAwareClassDescriptor implements kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor.Companion Companion = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor.Companion(null);

    protected abstract kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getMemberScope(kotlin.reflect.jvm.internal.impl.types.TypeSubstitution typeSubstitution, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner);

    protected abstract kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getUnsubstitutedMemberScope(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner);

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor getOriginal() {
        return getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor getOriginal() {
        return getOriginal();
    }

    /* JADX INFO: compiled from: ModuleAwareClassDescriptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getRefinedUnsubstitutedMemberScopeIfPossible$descriptors(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope unsubstitutedMemberScope;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor moduleAwareClassDescriptor = classDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor) classDescriptor : null;
            if (moduleAwareClassDescriptor != null && (unsubstitutedMemberScope = moduleAwareClassDescriptor.getUnsubstitutedMemberScope(kotlinTypeRefiner)) != null) {
                return unsubstitutedMemberScope;
            }
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope unsubstitutedMemberScope2 = classDescriptor.getUnsubstitutedMemberScope();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(unsubstitutedMemberScope2, "getUnsubstitutedMemberScope(...)");
            return unsubstitutedMemberScope2;
        }

        public final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getRefinedMemberScopeIfPossible$descriptors(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, kotlin.reflect.jvm.internal.impl.types.TypeSubstitution typeSubstitution, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeSubstitution, "typeSubstitution");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor moduleAwareClassDescriptor = classDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor) classDescriptor : null;
            if (moduleAwareClassDescriptor != null && (memberScope = moduleAwareClassDescriptor.getMemberScope(typeSubstitution, kotlinTypeRefiner)) != null) {
                return memberScope;
            }
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope2 = classDescriptor.getMemberScope(typeSubstitution);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(memberScope2, "getMemberScope(...)");
            return memberScope2;
        }
    }
}
