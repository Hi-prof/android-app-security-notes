package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: PackageFragmentProviderImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PackageFragmentProviderImpl implements kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized {
    private final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor> packageFragments;

    /* JADX WARN: Multi-variable type inference failed */
    public PackageFragmentProviderImpl(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor> packageFragments) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFragments, "packageFragments");
        this.packageFragments = packageFragments;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public void collectPackageFragments(kotlin.reflect.jvm.internal.impl.name.FqName fqName, java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor> packageFragments) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFragments, "packageFragments");
        for (java.lang.Object obj : this.packageFragments) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) obj).getFqName(), fqName)) {
                packageFragments.add(obj);
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized
    public boolean isEmpty(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor> collection = this.packageFragments;
        if ((collection instanceof java.util.Collection) && collection.isEmpty()) {
            return true;
        }
        java.util.Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) it.next()).getFqName(), fqName)) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    @kotlin.Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor> getPackageFragments(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor> collection = this.packageFragments;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : collection) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) obj).getFqName(), fqName)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.name.FqName> getSubPackagesOf(final kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, java.lang.Boolean> nameFilter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        return kotlin.sequences.SequencesKt.toList(kotlin.sequences.SequencesKt.filter(kotlin.sequences.SequencesKt.map(kotlin.collections.CollectionsKt.asSequence(this.packageFragments), new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl.getSubPackagesOf$lambda$3((kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) obj);
            }
        }), new kotlin.jvm.functions.Function1(fqName) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.name.FqName arg$0;

            {
                this.arg$0 = fqName;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl.getSubPackagesOf$lambda$4(this.arg$0, (kotlin.reflect.jvm.internal.impl.name.FqName) obj));
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.FqName getSubPackagesOf$lambda$3(kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return it.getFqName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getSubPackagesOf$lambda$4(kotlin.reflect.jvm.internal.impl.name.FqName fqName, kotlin.reflect.jvm.internal.impl.name.FqName it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return !it.isRoot() && kotlin.jvm.internal.Intrinsics.areEqual(it.parent(), fqName);
    }
}
