package kotlin.reflect.jvm.internal.impl.resolve.scopes;

/* JADX INFO: compiled from: SubstitutingScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SubstitutingScope implements kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope {
    private final kotlin.Lazy _allDescriptors$delegate;
    private final kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor capturingSubstitutor;
    private java.util.Map<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> substitutedDescriptors;
    private final kotlin.Lazy substitutor$delegate;
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope workerScope;

    public SubstitutingScope(kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope workerScope, final kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor givenSubstitutor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(workerScope, "workerScope");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(givenSubstitutor, "givenSubstitutor");
        this.workerScope = workerScope;
        this.substitutor$delegate = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0(givenSubstitutor) { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor arg$0;

            {
                this.arg$0 = givenSubstitutor;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope.substitutor_delegate$lambda$0(this.arg$0);
            }
        });
        kotlin.reflect.jvm.internal.impl.types.TypeSubstitution substitution = givenSubstitutor.getSubstitution();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substitution, "getSubstitution(...)");
        this.capturingSubstitutor = kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(substitution, false, 1, null).buildSubstitutor();
        this._allDescriptors$delegate = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope._allDescriptors_delegate$lambda$1(this.arg$0);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: recordLookup */
    public void mo1841recordLookup(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation lookupLocation) {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.DefaultImpls.recordLookup(this, name, lookupLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor substitutor_delegate$lambda$0(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutor) {
        return typeSubstitutor.getSubstitution().buildSubstitutor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Collection _allDescriptors_delegate$lambda$1(kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope substitutingScope) {
        return substitutingScope.substitute(kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.DefaultImpls.getContributedDescriptors$default(substitutingScope.workerScope, null, null, 3, null));
    }

    private final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> get_allDescriptors() {
        return (java.util.Collection) this._allDescriptors$delegate.getValue();
    }

    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> D substitute(D d) {
        if (this.capturingSubstitutor.isEmpty()) {
            return d;
        }
        if (this.substitutedDescriptors == null) {
            this.substitutedDescriptors = new java.util.HashMap();
        }
        java.util.Map<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> map = this.substitutedDescriptors;
        kotlin.jvm.internal.Intrinsics.checkNotNull(map);
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot declarationDescriptorNonRoot = map.get(d);
        if (declarationDescriptorNonRoot == null) {
            if (!(d instanceof kotlin.reflect.jvm.internal.impl.descriptors.Substitutable)) {
                throw new java.lang.IllegalStateException(("Unknown descriptor in scope: " + d).toString());
            }
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot declarationDescriptorNonRootSubstitute = ((kotlin.reflect.jvm.internal.impl.descriptors.Substitutable) d).substitute(this.capturingSubstitutor);
            if (declarationDescriptorNonRootSubstitute == null) {
                throw new java.lang.AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d + " substitution fails");
            }
            declarationDescriptorNonRoot = declarationDescriptorNonRootSubstitute;
            map.put(d, declarationDescriptorNonRoot);
        }
        D d2 = (D) declarationDescriptorNonRoot;
        kotlin.jvm.internal.Intrinsics.checkNotNull(d2, "null cannot be cast to non-null type D of org.jetbrains.kotlin.resolve.scopes.SubstitutingScope.substitute");
        return d2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> java.util.Collection<D> substitute(java.util.Collection<? extends D> collection) {
        if (this.capturingSubstitutor.isEmpty() || collection.isEmpty()) {
            return collection;
        }
        java.util.LinkedHashSet linkedHashSetNewLinkedHashSetWithExpectedSize = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.newLinkedHashSetWithExpectedSize(collection.size());
        java.util.Iterator it = collection.iterator();
        while (it.hasNext()) {
            linkedHashSetNewLinkedHashSetWithExpectedSize.add(substitute((kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) it.next()));
        }
        return linkedHashSetNewLinkedHashSetWithExpectedSize;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getContributedVariables(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        return substitute(this.workerScope.getContributedVariables(name, location));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier */
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor mo1837getContributedClassifier(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor contributedClassifier = this.workerScope.mo1837getContributedClassifier(name, location);
        if (contributedClassifier != null) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) substitute(contributedClassifier);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getContributedFunctions(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        return substitute(this.workerScope.getContributedFunctions(name, location));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return get_allDescriptors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getFunctionNames() {
        return this.workerScope.getFunctionNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getVariableNames() {
        return this.workerScope.getVariableNames();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getClassifierNames() {
        return this.workerScope.getClassifierNames();
    }
}
