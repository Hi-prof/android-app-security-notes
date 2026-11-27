package kotlin.reflect.jvm.internal.impl.resolve.scopes;

/* JADX INFO: compiled from: TypeIntersectionScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypeIntersectionScope extends kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter {
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope.Companion Companion = new kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope.Companion(null);
    private final java.lang.String debugName;
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope workerScope;

    public /* synthetic */ TypeIntersectionScope(java.lang.String str, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(str, memberScope);
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope create(java.lang.String str, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> collection) {
        return Companion.create(str, collection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor getContributedDescriptors$lambda$3(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor selectMostSpecificInEachOverridableGroup) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return selectMostSpecificInEachOverridableGroup;
    }

    private TypeIntersectionScope(java.lang.String str, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope) {
        this.debugName = str;
        this.workerScope = memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter
    protected kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getWorkerScope() {
        return this.workerScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor getContributedFunctions$lambda$0(kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor selectMostSpecificInEachOverridableGroup) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return selectMostSpecificInEachOverridableGroup;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getContributedFunctions(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        return kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedFunctions(name, location), new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope.getContributedFunctions$lambda$0((kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor getContributedVariables$lambda$1(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor selectMostSpecificInEachOverridableGroup) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selectMostSpecificInEachOverridableGroup, "$this$selectMostSpecificInEachOverridableGroup");
        return selectMostSpecificInEachOverridableGroup;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getContributedVariables(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        return kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(super.getContributedVariables(name, location), new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope.getContributedVariables$lambda$1((kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) obj);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> contributedDescriptors = super.getContributedDescriptors(kindFilter, nameFilter);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (java.lang.Object obj : contributedDescriptors) {
            if (((kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) obj) instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        kotlin.Pair pair = new kotlin.Pair(arrayList, arrayList2);
        java.util.List list = (java.util.List) pair.component1();
        java.util.List list2 = (java.util.List) pair.component2();
        kotlin.jvm.internal.Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
        return kotlin.collections.CollectionsKt.plus(kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt.selectMostSpecificInEachOverridableGroup(list, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope$$Lambda$2
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj2) {
                return kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope.getContributedDescriptors$lambda$3((kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) obj2);
            }
        }), (java.lang.Iterable) list2);
    }

    /* JADX INFO: compiled from: TypeIntersectionScope.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @kotlin.jvm.JvmStatic
        public final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope create(java.lang.String message, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> types) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(types, "types");
            java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> collection = types;
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(collection, 10));
            java.util.Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(((kotlin.reflect.jvm.internal.impl.types.KotlinType) it.next()).getMemberScope());
            }
            kotlin.reflect.jvm.internal.impl.utils.SmartList<kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> smartListListOfNonEmptyScopes = kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt.listOfNonEmptyScopes(arrayList);
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScopeCreateOrSingle$descriptors = kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope.Companion.createOrSingle$descriptors(message, smartListListOfNonEmptyScopes);
            return smartListListOfNonEmptyScopes.size() <= 1 ? memberScopeCreateOrSingle$descriptors : new kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope(message, memberScopeCreateOrSingle$descriptors, null);
        }
    }
}
