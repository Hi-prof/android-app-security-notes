package kotlin.reflect.jvm.internal.impl.resolve.scopes;

/* JADX INFO: compiled from: StaticScopeForKotlinEnum.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StaticScopeForKotlinEnum extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum.class, "functions", "getFunctions()Ljava/util/List;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum.class, "properties", "getProperties()Ljava/util/List;", 0))};
    private final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor containingClass;
    private final boolean enumEntriesCanBeUsed;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue functions$delegate;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue properties$delegate;

    public java.lang.Void getContributedClassifier(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* JADX INFO: renamed from: getContributedClassifier, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor mo1837getContributedClassifier(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation lookupLocation) {
        return (kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor) getContributedClassifier(name, lookupLocation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public /* bridge */ /* synthetic */ java.util.Collection getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter descriptorKindFilter, kotlin.jvm.functions.Function1 function1) {
        return getContributedDescriptors(descriptorKindFilter, (kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean>) function1);
    }

    public StaticScopeForKotlinEnum(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor containingClass, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(containingClass, "containingClass");
        this.containingClass = containingClass;
        this.enumEntriesCanBeUsed = z;
        containingClass.getKind();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassKind classKind = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_CLASS;
        this.functions$delegate = storageManager.createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum.functions_delegate$lambda$1(this.arg$0);
            }
        });
        this.properties$delegate = storageManager.createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum.properties_delegate$lambda$2(this.arg$0);
            }
        });
    }

    private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getFunctions() {
        return (java.util.List) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.functions$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List functions_delegate$lambda$1(kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum staticScopeForKotlinEnum) {
        return kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor[]{kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createEnumValueOfMethod(staticScopeForKotlinEnum.containingClass), kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createEnumValuesMethod(staticScopeForKotlinEnum.containingClass)});
    }

    private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getProperties() {
        return (java.util.List) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.properties$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List properties_delegate$lambda$2(kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum staticScopeForKotlinEnum) {
        if (staticScopeForKotlinEnum.enumEntriesCanBeUsed) {
            return kotlin.collections.CollectionsKt.listOfNotNull(kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory.createEnumEntriesProperty(staticScopeForKotlinEnum.containingClass));
        }
        return kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> getContributedDescriptors(kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter kindFilter, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return kotlin.collections.CollectionsKt.plus((java.util.Collection) getFunctions(), (java.lang.Iterable) getProperties());
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public kotlin.reflect.jvm.internal.impl.utils.SmartList<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getContributedFunctions(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> functions = getFunctions();
        kotlin.reflect.jvm.internal.impl.utils.SmartList smartList = new kotlin.reflect.jvm.internal.impl.utils.SmartList();
        for (java.lang.Object obj : functions) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) obj).getName(), name)) {
                smartList.add(obj);
            }
        }
        return smartList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getContributedVariables(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation location) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(location, "location");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> properties = getProperties();
        kotlin.reflect.jvm.internal.impl.utils.SmartList smartList = new kotlin.reflect.jvm.internal.impl.utils.SmartList();
        for (java.lang.Object obj : properties) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) obj).getName(), name)) {
                smartList.add(obj);
            }
        }
        return smartList;
    }
}
