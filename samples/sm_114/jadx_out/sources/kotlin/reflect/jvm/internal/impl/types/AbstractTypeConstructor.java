package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: AbstractTypeConstructor.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractTypeConstructor extends kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor {
    private final boolean shouldReportCyclicScopeWithCompanionWarning;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.Supertypes> supertypes;

    protected abstract java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> computeSupertypes();

    protected kotlin.reflect.jvm.internal.impl.types.KotlinType defaultSupertypeIfEmpty() {
        return null;
    }

    protected abstract kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker getSupertypeLoopChecker();

    protected java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> processSupertypesWithoutCycles(java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> supertypes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(supertypes, "supertypes");
        return supertypes;
    }

    protected void reportScopesLoopError(kotlin.reflect.jvm.internal.impl.types.KotlinType type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
    }

    protected void reportSupertypeLoopError(kotlin.reflect.jvm.internal.impl.types.KotlinType type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
    }

    public AbstractTypeConstructor(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        this.supertypes = storageManager.createLazyValueWithPostCompute(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.supertypes$lambda$0(this.arg$0);
            }
        }, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.supertypes$lambda$1(((java.lang.Boolean) obj).booleanValue());
            }
        }, new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$2
            private final kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.supertypes$lambda$7(this.arg$0, (kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.Supertypes) obj);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes */
    public java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> mo1836getSupertypes() {
        return this.supertypes.invoke().getSupertypesWithoutCycles();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public kotlin.reflect.jvm.internal.impl.types.TypeConstructor refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.ModuleViewTypeConstructor(this, kotlinTypeRefiner);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
    final class ModuleViewTypeConstructor implements kotlin.reflect.jvm.internal.impl.types.TypeConstructor {
        private final kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner;
        private final kotlin.Lazy refinedSupertypes$delegate;
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor this$0;

        public ModuleViewTypeConstructor(final kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor abstractTypeConstructor, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            this.this$0 = abstractTypeConstructor;
            this.kotlinTypeRefiner = kotlinTypeRefiner;
            this.refinedSupertypes$delegate = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this, abstractTypeConstructor) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$ModuleViewTypeConstructor$$Lambda$0
                private final kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.ModuleViewTypeConstructor arg$0;
                private final kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = abstractTypeConstructor;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.ModuleViewTypeConstructor.refinedSupertypes_delegate$lambda$0(this.arg$0, this.arg$1);
                }
            });
        }

        private final java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> getRefinedSupertypes() {
            return (java.util.List) this.refinedSupertypes$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final java.util.List refinedSupertypes_delegate$lambda$0(kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.ModuleViewTypeConstructor moduleViewTypeConstructor, kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor abstractTypeConstructor) {
            return kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt.refineTypes(moduleViewTypeConstructor.kotlinTypeRefiner, abstractTypeConstructor.mo1836getSupertypes());
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getParameters() {
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters = this.this$0.getParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            return parameters;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getSupertypes */
        public java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> mo1836getSupertypes() {
            return getRefinedSupertypes();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return this.this$0.isDenotable();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor mo1835getDeclarationDescriptor() {
            return this.this$0.mo1835getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns getBuiltIns() {
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns builtIns = this.this$0.getBuiltIns();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(builtIns, "getBuiltIns(...)");
            return builtIns;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public kotlin.reflect.jvm.internal.impl.types.TypeConstructor refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this.this$0.refine(kotlinTypeRefiner);
        }

        public boolean equals(java.lang.Object obj) {
            return this.this$0.equals(obj);
        }

        public int hashCode() {
            return this.this$0.hashCode();
        }

        public java.lang.String toString() {
            return this.this$0.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AbstractTypeConstructor.kt */
    static final class Supertypes {
        private final java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> allSupertypes;
        private java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> supertypesWithoutCycles;

        /* JADX WARN: Multi-variable type inference failed */
        public Supertypes(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> allSupertypes) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(allSupertypes, "allSupertypes");
            this.allSupertypes = allSupertypes;
            this.supertypesWithoutCycles = kotlin.collections.CollectionsKt.listOf(kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.INSTANCE.getErrorTypeForLoopInSupertypes());
        }

        public final java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> getAllSupertypes() {
            return this.allSupertypes;
        }

        public final java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> getSupertypesWithoutCycles() {
            return this.supertypesWithoutCycles;
        }

        public final void setSupertypesWithoutCycles(java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> list) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.supertypesWithoutCycles = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.Supertypes supertypes$lambda$0(kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor abstractTypeConstructor) {
        return new kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.Supertypes(abstractTypeConstructor.computeSupertypes());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.Supertypes supertypes$lambda$1(boolean z) {
        return new kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.Supertypes(kotlin.collections.CollectionsKt.listOf(kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.INSTANCE.getErrorTypeForLoopInSupertypes()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit supertypes$lambda$7(final kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor abstractTypeConstructor, kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.Supertypes supertypes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(supertypes, "supertypes");
        kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor abstractTypeConstructor2 = abstractTypeConstructor;
        java.util.List listFindLoopsInSupertypesAndDisconnect = abstractTypeConstructor.getSupertypeLoopChecker().findLoopsInSupertypesAndDisconnect(abstractTypeConstructor2, supertypes.getAllSupertypes(), new kotlin.jvm.functions.Function1(abstractTypeConstructor) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$3
            private final kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor arg$0;

            {
                this.arg$0 = abstractTypeConstructor;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.supertypes$lambda$7$lambda$2(this.arg$0, (kotlin.reflect.jvm.internal.impl.types.TypeConstructor) obj);
            }
        }, new kotlin.jvm.functions.Function1(abstractTypeConstructor) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$4
            private final kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor arg$0;

            {
                this.arg$0 = abstractTypeConstructor;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.supertypes$lambda$7$lambda$3(this.arg$0, (kotlin.reflect.jvm.internal.impl.types.KotlinType) obj);
            }
        });
        if (listFindLoopsInSupertypesAndDisconnect.isEmpty()) {
            kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeDefaultSupertypeIfEmpty = abstractTypeConstructor.defaultSupertypeIfEmpty();
            java.util.List listListOf = kotlinTypeDefaultSupertypeIfEmpty != null ? kotlin.collections.CollectionsKt.listOf(kotlinTypeDefaultSupertypeIfEmpty) : null;
            if (listListOf == null) {
                listListOf = kotlin.collections.CollectionsKt.emptyList();
            }
            listFindLoopsInSupertypesAndDisconnect = listListOf;
        }
        if (abstractTypeConstructor.getShouldReportCyclicScopeWithCompanionWarning()) {
            abstractTypeConstructor.getSupertypeLoopChecker().findLoopsInSupertypesAndDisconnect(abstractTypeConstructor2, listFindLoopsInSupertypesAndDisconnect, new kotlin.jvm.functions.Function1(abstractTypeConstructor) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$5
                private final kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor arg$0;

                {
                    this.arg$0 = abstractTypeConstructor;
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public java.lang.Object invoke2(java.lang.Object obj) {
                    return kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.supertypes$lambda$7$lambda$5(this.arg$0, (kotlin.reflect.jvm.internal.impl.types.TypeConstructor) obj);
                }
            }, new kotlin.jvm.functions.Function1(abstractTypeConstructor) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$6
                private final kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor arg$0;

                {
                    this.arg$0 = abstractTypeConstructor;
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public java.lang.Object invoke2(java.lang.Object obj) {
                    return kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.supertypes$lambda$7$lambda$6(this.arg$0, (kotlin.reflect.jvm.internal.impl.types.KotlinType) obj);
                }
            });
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> list = listFindLoopsInSupertypesAndDisconnect instanceof java.util.List ? (java.util.List) listFindLoopsInSupertypesAndDisconnect : null;
        if (list == null) {
            list = kotlin.collections.CollectionsKt.toList(listFindLoopsInSupertypesAndDisconnect);
        }
        supertypes.setSupertypesWithoutCycles(abstractTypeConstructor.processSupertypesWithoutCycles(list));
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Iterable supertypes$lambda$7$lambda$2(kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor abstractTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return abstractTypeConstructor.computeNeighbours(it, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit supertypes$lambda$7$lambda$3(kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor abstractTypeConstructor, kotlin.reflect.jvm.internal.impl.types.KotlinType it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        abstractTypeConstructor.reportSupertypeLoopError(it);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Iterable supertypes$lambda$7$lambda$5(kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor abstractTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return abstractTypeConstructor.computeNeighbours(it, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit supertypes$lambda$7$lambda$6(kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor abstractTypeConstructor, kotlin.reflect.jvm.internal.impl.types.KotlinType it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        abstractTypeConstructor.reportScopesLoopError(it);
        return kotlin.Unit.INSTANCE;
    }

    private final java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> computeNeighbours(kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, boolean z) {
        java.util.List listPlus;
        kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor abstractTypeConstructor = typeConstructor instanceof kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor ? (kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor) typeConstructor : null;
        if (abstractTypeConstructor != null && (listPlus = kotlin.collections.CollectionsKt.plus((java.util.Collection) abstractTypeConstructor.supertypes.invoke().getAllSupertypes(), (java.lang.Iterable) abstractTypeConstructor.getAdditionalNeighboursInSupertypeGraph(z))) != null) {
            return listPlus;
        }
        java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collectionMo1836getSupertypes = typeConstructor.mo1836getSupertypes();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionMo1836getSupertypes, "getSupertypes(...)");
        return collectionMo1836getSupertypes;
    }

    protected boolean getShouldReportCyclicScopeWithCompanionWarning() {
        return this.shouldReportCyclicScopeWithCompanionWarning;
    }

    protected java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean z) {
        return kotlin.collections.CollectionsKt.emptyList();
    }
}
