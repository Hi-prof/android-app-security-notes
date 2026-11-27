package kotlin.reflect.jvm.internal.impl.builtins;

/* JADX INFO: compiled from: ReflectionTypes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectionTypes {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.class, "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.class, "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.class, "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.class, "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.class, "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.class, "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.class, "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0)), kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.class, "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", 0))};
    public static final kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.Companion Companion = new kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.Companion(null);
    private final kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.ClassLookup kClass$delegate;
    private final kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.ClassLookup kMutableProperty0$delegate;
    private final kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.ClassLookup kMutableProperty1$delegate;
    private final kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.ClassLookup kMutableProperty2$delegate;
    private final kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.ClassLookup kProperty$delegate;
    private final kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.ClassLookup kProperty0$delegate;
    private final kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.ClassLookup kProperty1$delegate;
    private final kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.ClassLookup kProperty2$delegate;
    private final kotlin.Lazy kotlinReflectScope$delegate;
    private final kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses notFoundClasses;

    public ReflectionTypes(final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module, kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses notFoundClasses) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        this.notFoundClasses = notFoundClasses;
        this.kotlinReflectScope$delegate = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(module) { // from class: kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor arg$0;

            {
                this.arg$0 = module;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.kotlinReflectScope_delegate$lambda$0(this.arg$0);
            }
        });
        this.kClass$delegate = new kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.ClassLookup(1);
        this.kProperty$delegate = new kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.ClassLookup(1);
        this.kProperty0$delegate = new kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.ClassLookup(1);
        this.kProperty1$delegate = new kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.ClassLookup(2);
        this.kProperty2$delegate = new kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.ClassLookup(3);
        this.kMutableProperty0$delegate = new kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.ClassLookup(1);
        this.kMutableProperty1$delegate = new kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.ClassLookup(2);
        this.kMutableProperty2$delegate = new kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.ClassLookup(3);
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getKotlinReflectScope() {
        return (kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope) this.kotlinReflectScope$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope kotlinReflectScope_delegate$lambda$0(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor) {
        return moduleDescriptor.getPackage(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.KOTLIN_REFLECT_FQ_NAME).getMemberScope();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor find(java.lang.String str, int i) {
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(str);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor contributedClassifier = getKotlinReflectScope().mo1837getContributedClassifier(nameIdentifier, kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_REFLECTION);
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = contributedClassifier instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) contributedClassifier : null;
        return classDescriptor == null ? this.notFoundClasses.getClass(new kotlin.reflect.jvm.internal.impl.name.ClassId(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.KOTLIN_REFLECT_FQ_NAME, nameIdentifier), kotlin.collections.CollectionsKt.listOf(java.lang.Integer.valueOf(i))) : classDescriptor;
    }

    /* JADX INFO: compiled from: ReflectionTypes.kt */
    private static final class ClassLookup {
        private final int numberOfTypeParameters;

        public ClassLookup(int i) {
            this.numberOfTypeParameters = i;
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getValue(kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes types, kotlin.reflect.KProperty<?> property) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(types, "types");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
            return types.find(kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt.capitalizeAsciiOnly(property.getName()), this.numberOfTypeParameters);
        }
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor getKClass() {
        return this.kClass$delegate.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: compiled from: ReflectionTypes.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.types.KotlinType createKPropertyStarType(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorFindClassAcrossModuleDependencies = kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt.findClassAcrossModuleDependencies(module, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.kProperty);
            if (classDescriptorFindClassAcrossModuleDependencies == null) {
                return null;
            }
            kotlin.reflect.jvm.internal.impl.types.TypeAttributes empty = kotlin.reflect.jvm.internal.impl.types.TypeAttributes.Companion.getEmpty();
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters = classDescriptorFindClassAcrossModuleDependencies.getTypeConstructor().getParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            java.lang.Object objSingle = kotlin.collections.CollectionsKt.single((java.util.List<? extends java.lang.Object>) parameters);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(objSingle, "single(...)");
            return kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleNotNullType(empty, classDescriptorFindClassAcrossModuleDependencies, kotlin.collections.CollectionsKt.listOf(new kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) objSingle)));
        }
    }
}
