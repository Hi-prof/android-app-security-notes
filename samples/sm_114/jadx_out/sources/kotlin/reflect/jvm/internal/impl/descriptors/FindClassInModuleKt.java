package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: compiled from: findClassInModule.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FindClassInModuleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int findNonGenericClassAcrossDependencies$lambda$1(kotlin.reflect.jvm.internal.impl.name.ClassId it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return 0;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor findClassAcrossModuleDependencies(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor, kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorFindClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (classifierDescriptorFindClassifierAcrossModuleDependencies instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorFindClassifierAcrossModuleDependencies;
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor findNonGenericClassAcrossDependencies(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor, kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses notFoundClasses) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorFindClassAcrossModuleDependencies = findClassAcrossModuleDependencies(moduleDescriptor, classId);
        return classDescriptorFindClassAcrossModuleDependencies != null ? classDescriptorFindClassAcrossModuleDependencies : notFoundClasses.getClass(classId, kotlin.sequences.SequencesKt.toList(kotlin.sequences.SequencesKt.map(kotlin.sequences.SequencesKt.generateSequence(classId, new kotlin.jvm.internal.PropertyReference1Impl() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public java.lang.Object get(java.lang.Object obj) {
                return ((kotlin.reflect.jvm.internal.impl.name.ClassId) obj).getOuterClassId();
            }
        }), new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return java.lang.Integer.valueOf(kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt.findNonGenericClassAcrossDependencies$lambda$1((kotlin.reflect.jvm.internal.impl.name.ClassId) obj));
            }
        })));
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor findTypeAliasAcrossModuleDependencies(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor, kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorFindClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (classifierDescriptorFindClassifierAcrossModuleDependencies instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) classifierDescriptorFindClassifierAcrossModuleDependencies;
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor findClassifierAcrossModuleDependencies(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor, kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
        kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor resolutionAnchorIfAny = kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProviderKt.getResolutionAnchorIfAny(moduleDescriptor);
        if (resolutionAnchorIfAny == null) {
            kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor packageViewDescriptor = moduleDescriptor.getPackage(classId.getPackageFqName());
            java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> listPathSegments = classId.getRelativeClassName().pathSegments();
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor contributedClassifier = packageViewDescriptor.getMemberScope().mo1837getContributedClassifier((kotlin.reflect.jvm.internal.impl.name.Name) kotlin.collections.CollectionsKt.first((java.util.List) listPathSegments), kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION);
            if (contributedClassifier == null) {
                return null;
            }
            for (kotlin.reflect.jvm.internal.impl.name.Name name : listPathSegments.subList(1, listPathSegments.size())) {
                if (!(contributedClassifier instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor)) {
                    return null;
                }
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor contributedClassifier2 = ((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) contributedClassifier).getUnsubstitutedInnerClassesScope().mo1837getContributedClassifier(name, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION);
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = contributedClassifier2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) contributedClassifier2 : null;
                if (classDescriptor == null) {
                    return null;
                }
                contributedClassifier = classDescriptor;
            }
            return contributedClassifier;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor packageViewDescriptor2 = resolutionAnchorIfAny.getPackage(classId.getPackageFqName());
        java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> listPathSegments2 = classId.getRelativeClassName().pathSegments();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor contributedClassifier3 = packageViewDescriptor2.getMemberScope().mo1837getContributedClassifier((kotlin.reflect.jvm.internal.impl.name.Name) kotlin.collections.CollectionsKt.first((java.util.List) listPathSegments2), kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION);
        if (contributedClassifier3 == null) {
            contributedClassifier3 = null;
            break;
        }
        for (kotlin.reflect.jvm.internal.impl.name.Name name2 : listPathSegments2.subList(1, listPathSegments2.size())) {
            if (contributedClassifier3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor contributedClassifier4 = ((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) contributedClassifier3).getUnsubstitutedInnerClassesScope().mo1837getContributedClassifier(name2, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION);
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor2 = contributedClassifier4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) contributedClassifier4 : null;
                if (classDescriptor2 != null) {
                    contributedClassifier3 = classDescriptor2;
                }
            }
            contributedClassifier3 = null;
        }
        if (contributedClassifier3 != null) {
            return contributedClassifier3;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor packageViewDescriptor3 = moduleDescriptor.getPackage(classId.getPackageFqName());
        java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> listPathSegments3 = classId.getRelativeClassName().pathSegments();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor contributedClassifier5 = packageViewDescriptor3.getMemberScope().mo1837getContributedClassifier((kotlin.reflect.jvm.internal.impl.name.Name) kotlin.collections.CollectionsKt.first((java.util.List) listPathSegments3), kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION);
        if (contributedClassifier5 == null) {
            return null;
        }
        for (kotlin.reflect.jvm.internal.impl.name.Name name3 : listPathSegments3.subList(1, listPathSegments3.size())) {
            if (!(contributedClassifier5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor)) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor contributedClassifier6 = ((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) contributedClassifier5).getUnsubstitutedInnerClassesScope().mo1837getContributedClassifier(name3, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION);
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor3 = contributedClassifier6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) contributedClassifier6 : null;
            if (classDescriptor3 == null) {
                return null;
            }
            contributedClassifier5 = classDescriptor3;
        }
        return contributedClassifier5;
    }
}
