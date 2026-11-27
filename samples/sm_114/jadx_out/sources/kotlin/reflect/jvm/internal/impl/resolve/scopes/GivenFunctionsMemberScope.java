package kotlin.reflect.jvm.internal.impl.resolve.scopes;

/* JADX INFO: compiled from: GivenFunctionsMemberScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GivenFunctionsMemberScope extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope.class, "allDescriptors", "getAllDescriptors()Ljava/util/List;", 0))};
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue allDescriptors$delegate;
    private final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor containingClass;

    protected abstract java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> computeDeclaredFunctions();

    protected final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getContainingClass() {
        return this.containingClass;
    }

    public GivenFunctionsMemberScope(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor containingClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(containingClass, "containingClass");
        this.containingClass = containingClass;
        this.allDescriptors$delegate = storageManager.createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope.allDescriptors_delegate$lambda$0(this.arg$0);
            }
        });
    }

    private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getAllDescriptors() {
        return (java.util.List) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.allDescriptors$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List allDescriptors_delegate$lambda$0(kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope givenFunctionsMemberScope) {
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> listComputeDeclaredFunctions = givenFunctionsMemberScope.computeDeclaredFunctions();
        return kotlin.collections.CollectionsKt.plus((java.util.Collection) listComputeDeclaredFunctions, (java.lang.Iterable) givenFunctionsMemberScope.createFakeOverrides(listComputeDeclaredFunctions));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return !kindFilter.acceptsKinds(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.CALLABLES.getKindMask()) ? kotlin.collections.CollectionsKt.emptyList() : getAllDescriptors();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getContributedFunctions(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.reflect.jvm.internal.impl.utils.SmartList smartListEmptyList;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> allDescriptors = getAllDescriptors();
        if (allDescriptors.isEmpty()) {
            smartListEmptyList = kotlin.collections.CollectionsKt.emptyList();
        } else {
            kotlin.reflect.jvm.internal.impl.utils.SmartList smartList = new kotlin.reflect.jvm.internal.impl.utils.SmartList();
            for (java.lang.Object obj : allDescriptors) {
                if ((obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) && kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) obj).getName(), name)) {
                    smartList.add(obj);
                }
            }
            smartListEmptyList = smartList;
        }
        return smartListEmptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getContributedVariables(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.reflect.jvm.internal.impl.utils.SmartList smartListEmptyList;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> allDescriptors = getAllDescriptors();
        if (allDescriptors.isEmpty()) {
            smartListEmptyList = kotlin.collections.CollectionsKt.emptyList();
        } else {
            kotlin.reflect.jvm.internal.impl.utils.SmartList smartList = new kotlin.reflect.jvm.internal.impl.utils.SmartList();
            for (java.lang.Object obj : allDescriptors) {
                if ((obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) && kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) obj).getName(), name)) {
                    smartList.add(obj);
                }
            }
            smartListEmptyList = smartList;
        }
        return smartListEmptyList;
    }

    private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> createFakeOverrides(java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> list) {
        java.util.ArrayList arrayListEmptyList;
        final java.util.ArrayList arrayList = new java.util.ArrayList(3);
        java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collectionMo1836getSupertypes = this.containingClass.getTypeConstructor().mo1836getSupertypes();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionMo1836getSupertypes, "getSupertypes(...)");
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.Iterator<T> it = collectionMo1836getSupertypes.iterator();
        while (it.hasNext()) {
            kotlin.collections.CollectionsKt.addAll(arrayList2, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.DefaultImpls.getContributedDescriptors$default(((kotlin.reflect.jvm.internal.impl.types.KotlinType) it.next()).getMemberScope(), null, null, 3, null));
        }
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        for (java.lang.Object obj : arrayList2) {
            if (obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) {
                arrayList3.add(obj);
            }
        }
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (java.lang.Object obj2 : arrayList3) {
            kotlin.reflect.jvm.internal.impl.name.Name name = ((kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) obj2).getName();
            java.lang.Object obj3 = linkedHashMap.get(name);
            if (obj3 == null) {
                obj3 = (java.util.List) new java.util.ArrayList();
                linkedHashMap.put(name, obj3);
            }
            ((java.util.List) obj3).add(obj2);
        }
        for (java.util.Map.Entry entry : linkedHashMap.entrySet()) {
            java.lang.Object key = entry.getKey();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(key, "component1(...)");
            kotlin.reflect.jvm.internal.impl.name.Name name2 = (kotlin.reflect.jvm.internal.impl.name.Name) key;
            java.util.List list2 = (java.util.List) entry.getValue();
            java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap();
            for (java.lang.Object obj4 : list2) {
                java.lang.Boolean boolValueOf = java.lang.Boolean.valueOf(((kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) obj4) instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor);
                java.lang.Object obj5 = linkedHashMap2.get(boolValueOf);
                if (obj5 == null) {
                    obj5 = (java.util.List) new java.util.ArrayList();
                    linkedHashMap2.put(boolValueOf, obj5);
                }
                ((java.util.List) obj5).add(obj4);
            }
            for (java.util.Map.Entry entry2 : linkedHashMap2.entrySet()) {
                boolean zBooleanValue = ((java.lang.Boolean) entry2.getKey()).booleanValue();
                java.util.List list3 = (java.util.List) entry2.getValue();
                kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil overridingUtil = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.DEFAULT;
                java.util.List list4 = list3;
                if (!zBooleanValue) {
                    arrayListEmptyList = kotlin.collections.CollectionsKt.emptyList();
                } else {
                    java.util.ArrayList arrayList4 = new java.util.ArrayList();
                    for (java.lang.Object obj6 : list) {
                        if (kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) obj6).getName(), name2)) {
                            arrayList4.add(obj6);
                        }
                    }
                    arrayListEmptyList = arrayList4;
                }
                overridingUtil.generateOverridesInFunctionGroup(name2, list4, arrayListEmptyList, this.containingClass, new kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope.createFakeOverrides.4
                    @Override // kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy
                    public void addFakeOverride(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor fakeOverride) {
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fakeOverride, "fakeOverride");
                        kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.resolveUnknownVisibilityForMember(fakeOverride, null);
                        arrayList.add(fakeOverride);
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy
                    protected void conflict(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor fromSuper, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor fromCurrent) {
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fromSuper, "fromSuper");
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fromCurrent, "fromCurrent");
                        throw new java.lang.IllegalStateException(("Conflict in scope of " + this.getContainingClass() + ": " + fromSuper + " vs " + fromCurrent).toString());
                    }
                });
            }
        }
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(arrayList);
    }
}
