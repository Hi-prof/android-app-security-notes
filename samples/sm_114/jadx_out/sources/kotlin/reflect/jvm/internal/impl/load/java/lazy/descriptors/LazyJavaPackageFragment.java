package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

/* JADX INFO: compiled from: LazyJavaPackageFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LazyJavaPackageFragment extends kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment.class, "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment.class, "partToFacade", "getPartToFacade()Ljava/util/HashMap;", 0))};
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue binaryClasses$delegate;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext c;
    private final kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage jPackage;
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion metadataVersion;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue partToFacade$delegate;
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JvmPackageScope scope;
    private final kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue<java.util.List<kotlin.reflect.jvm.internal.impl.name.FqName>> subPackages;

    /* JADX INFO: compiled from: LazyJavaPackageFragment.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragment(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext outerContext, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage jPackage) {
        super(outerContext.getModule(), jPackage.getFqName());
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(outerContext, "outerContext");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jPackage, "jPackage");
        this.jPackage = jPackage;
        kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext lazyJavaResolverContextChildForClassOrPackage$default = kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt.childForClassOrPackage$default(outerContext, this, null, 0, 6, null);
        this.c = lazyJavaResolverContextChildForClassOrPackage$default;
        this.metadataVersion = outerContext.getComponents().getDeserializedDescriptorResolver().getComponents().getConfiguration().getMetadataVersion();
        this.binaryClasses$delegate = lazyJavaResolverContextChildForClassOrPackage$default.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment.binaryClasses_delegate$lambda$2(this.arg$0);
            }
        });
        this.scope = new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JvmPackageScope(lazyJavaResolverContextChildForClassOrPackage$default, jPackage, this);
        this.subPackages = lazyJavaResolverContextChildForClassOrPackage$default.getStorageManager().createRecursionTolerantLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment.subPackages$lambda$3(this.arg$0);
            }
        }, kotlin.collections.CollectionsKt.emptyList());
        this.annotations = lazyJavaResolverContextChildForClassOrPackage$default.getComponents().getJavaTypeEnhancementState().getDisabledDefaultAnnotations() ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY() : kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt.resolveAnnotations(lazyJavaResolverContextChildForClassOrPackage$default, jPackage);
        this.partToFacade$delegate = lazyJavaResolverContextChildForClassOrPackage$default.getStorageManager().createLazyValue(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$$Lambda$2
            private final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment.partToFacade_delegate$lambda$4(this.arg$0);
            }
        });
    }

    public final java.util.Map<java.lang.String, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass> getBinaryClasses$descriptors_jvm() {
        return (java.util.Map) kotlin.reflect.jvm.internal.impl.storage.StorageKt.getValue(this.binaryClasses$delegate, this, (kotlin.reflect.KProperty<?>) $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.Map binaryClasses_delegate$lambda$2(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment lazyJavaPackageFragment) {
        java.util.List<java.lang.String> listFindPackageParts = lazyJavaPackageFragment.c.getComponents().getPackagePartProvider().findPackageParts(lazyJavaPackageFragment.getFqName().asString());
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str : listFindPackageParts) {
            kotlin.reflect.jvm.internal.impl.name.ClassId.Companion companion = kotlin.reflect.jvm.internal.impl.name.ClassId.Companion;
            kotlin.reflect.jvm.internal.impl.name.FqName fqNameForTopLevelClassMaybeWithDollars = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName.byInternalName(str).getFqNameForTopLevelClassMaybeWithDollars();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(fqNameForTopLevelClassMaybeWithDollars, "getFqNameForTopLevelClassMaybeWithDollars(...)");
            kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass kotlinJvmBinaryClassFindKotlinClass = kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt.findKotlinClass(lazyJavaPackageFragment.c.getComponents().getKotlinClassFinder(), companion.topLevel(fqNameForTopLevelClassMaybeWithDollars), lazyJavaPackageFragment.metadataVersion);
            kotlin.Pair pair = kotlinJvmBinaryClassFindKotlinClass != null ? kotlin.TuplesKt.to(str, kotlinJvmBinaryClassFindKotlinClass) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return kotlin.collections.MapsKt.toMap(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List subPackages$lambda$3(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment lazyJavaPackageFragment) {
        java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage> subPackages = lazyJavaPackageFragment.jPackage.getSubPackages();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(subPackages, 10));
        java.util.Iterator<T> it = subPackages.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage) it.next()).getFqName());
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations getAnnotations() {
        return this.annotations;
    }

    public final java.util.List<kotlin.reflect.jvm.internal.impl.name.FqName> getSubPackageFqNames$descriptors_jvm() {
        return this.subPackages.invoke();
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor findClassifierByJavaClass$descriptors_jvm(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass jClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jClass, "jClass");
        return this.scope.getJavaScope$descriptors_jvm().findClassifierByJavaClass$descriptors_jvm(jClass);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.HashMap partToFacade_delegate$lambda$4(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment lazyJavaPackageFragment) {
        java.util.HashMap map = new java.util.HashMap();
        for (java.util.Map.Entry<java.lang.String, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass> entry : lazyJavaPackageFragment.getBinaryClasses$descriptors_jvm().entrySet()) {
            java.lang.String key = entry.getKey();
            kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass value = entry.getValue();
            kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName jvmClassNameByInternalName = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName.byInternalName(key);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(jvmClassNameByInternalName, "byInternalName(...)");
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader classHeader = value.getClassHeader();
            int i = kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment.WhenMappings.$EnumSwitchMapping$0[classHeader.getKind().ordinal()];
            if (i == 1) {
                java.util.HashMap map2 = map;
                java.lang.String multifileClassName = classHeader.getMultifileClassName();
                if (multifileClassName != null) {
                    map2.put(jvmClassNameByInternalName, kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName.byInternalName(multifileClassName));
                }
            } else if (i == 2) {
                map.put(jvmClassNameByInternalName, jvmClassNameByInternalName);
            }
        }
        return map;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JvmPackageScope getMemberScope() {
        return this.scope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public java.lang.String toString() {
        return "Lazy Java package fragment: " + getFqName() + " of module " + this.c.getComponents().getModule();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public kotlin.reflect.jvm.internal.impl.descriptors.SourceElement getSource() {
        return new kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryPackageSourceElement(this);
    }
}
