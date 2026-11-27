package kotlin.reflect.jvm.internal.impl.builtins.functions;

/* JADX INFO: compiled from: BuiltInFictitiousFunctionClassFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BuiltInFictitiousFunctionClassFactory implements kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory {
    private final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module;
    private final kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager;

    public BuiltInFictitiousFunctionClassFactory(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        this.storageManager = storageManager;
        this.module = module;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public boolean shouldCreateClass(kotlin.reflect.jvm.internal.impl.name.FqName packageFqName, kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        java.lang.String strAsString = name.asString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        return (kotlin.text.StringsKt.startsWith$default(strAsString, "Function", false, 2, (java.lang.Object) null) || kotlin.text.StringsKt.startsWith$default(strAsString, "KFunction", false, 2, (java.lang.Object) null) || kotlin.text.StringsKt.startsWith$default(strAsString, "SuspendFunction", false, 2, (java.lang.Object) null) || kotlin.text.StringsKt.startsWith$default(strAsString, "KSuspendFunction", false, 2, (java.lang.Object) null)) && kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor.Companion.getDefault().getFunctionalClassKindWithArity(packageFqName, strAsString) != null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor createClass(kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
        kotlin.reflect.jvm.internal.impl.name.FqName packageFqName;
        kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor.KindWithArity functionalClassKindWithArity;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
        if (classId.isLocal() || classId.isNestedClass()) {
            return null;
        }
        java.lang.String strAsString = classId.getRelativeClassName().asString();
        if (!kotlin.text.StringsKt.contains$default((java.lang.CharSequence) strAsString, (java.lang.CharSequence) "Function", false, 2, (java.lang.Object) null) || (functionalClassKindWithArity = kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKindExtractor.Companion.getDefault().getFunctionalClassKindWithArity((packageFqName = classId.getPackageFqName()), strAsString)) == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind functionTypeKindComponent1 = functionalClassKindWithArity.component1();
        int iComponent2 = functionalClassKindWithArity.component2();
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor> fragments = this.module.getPackage(packageFqName).getFragments();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : fragments) {
            if (obj instanceof kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment) {
                arrayList.add(obj);
            }
        }
        java.util.ArrayList arrayList2 = arrayList;
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        for (java.lang.Object obj2 : arrayList2) {
            if (obj2 instanceof kotlin.reflect.jvm.internal.impl.builtins.FunctionInterfacePackageFragment) {
                arrayList3.add(obj2);
            }
        }
        java.lang.Object objFirst = (kotlin.reflect.jvm.internal.impl.builtins.FunctionInterfacePackageFragment) kotlin.collections.CollectionsKt.firstOrNull((java.util.List) arrayList3);
        if (objFirst == null) {
            objFirst = kotlin.collections.CollectionsKt.first((java.util.List<? extends java.lang.Object>) arrayList2);
        }
        return new kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor(this.storageManager, (kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment) objFirst, functionTypeKindComponent1, iComponent2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> getAllContributedClassesIfPossible(kotlin.reflect.jvm.internal.impl.name.FqName packageFqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        return kotlin.collections.SetsKt.emptySet();
    }
}
