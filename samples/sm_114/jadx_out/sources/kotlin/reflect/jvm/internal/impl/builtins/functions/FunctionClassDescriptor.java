package kotlin.reflect.jvm.internal.impl.builtins.functions;

/* JADX INFO: compiled from: FunctionClassDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FunctionClassDescriptor extends kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor {
    public static final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.Companion Companion = new kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.Companion(null);
    private static final kotlin.reflect.jvm.internal.impl.name.ClassId functionClassId;
    private static final kotlin.reflect.jvm.internal.impl.name.ClassId kFunctionClassId;
    private final int arity;
    private final kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor containingDeclaration;
    private final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind functionKind;
    private final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind functionTypeKind;
    private final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassScope memberScope;
    private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters;
    private final kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager;
    private final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.FunctionTypeConstructor typeConstructor;

    public java.lang.Void getCompanionObjectDescriptor() {
        return null;
    }

    public java.lang.Void getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation<kotlin.reflect.jvm.internal.impl.types.SimpleType> getValueClassRepresentation() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getCompanionObjectDescriptor, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor mo1824getCompanionObjectDescriptor() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) getCompanionObjectDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* JADX INFO: renamed from: getUnsubstitutedPrimaryConstructor, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor mo1825getUnsubstitutedPrimaryConstructor() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor) getUnsubstitutedPrimaryConstructor();
    }

    public final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind getFunctionTypeKind() {
        return this.functionTypeKind;
    }

    public final int getArity() {
        return this.arity;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunctionClassDescriptor(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor containingDeclaration, kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind functionTypeKind, int i) {
        super(storageManager, functionTypeKind.numberedClassName(i));
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(functionTypeKind, "functionTypeKind");
        this.storageManager = storageManager;
        this.containingDeclaration = containingDeclaration;
        this.functionTypeKind = functionTypeKind;
        this.arity = i;
        this.typeConstructor = new kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.FunctionTypeConstructor();
        this.memberScope = new kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassScope(storageManager, this);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        kotlin.ranges.IntRange intRange = new kotlin.ranges.IntRange(1, i);
        java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(intRange, 10));
        java.util.Iterator<java.lang.Integer> it = intRange.iterator();
        while (it.hasNext()) {
            int iNextInt = ((kotlin.collections.IntIterator) it).nextInt();
            _init_$typeParameter(arrayList, this, kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE, "P" + iNextInt);
            arrayList2.add(kotlin.Unit.INSTANCE);
        }
        _init_$typeParameter(arrayList, this, kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE, "R");
        this.parameters = kotlin.collections.CollectionsKt.toList(arrayList);
        this.functionKind = kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind.Companion.getFunctionClassKind(this.functionTypeKind);
    }

    private static final void _init_$typeParameter(java.util.ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> arrayList, kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor functionClassDescriptor, kotlin.reflect.jvm.internal.impl.types.Variance variance, java.lang.String str) {
        arrayList.add(kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl.createWithDefaultBound(functionClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY(), false, variance, kotlin.reflect.jvm.internal.impl.name.Name.identifier(str), arrayList.size(), functionClassDescriptor.storageManager));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty getStaticScope() {
        return kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public kotlin.reflect.jvm.internal.impl.types.TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassScope getUnsubstitutedMemberScope(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor> getConstructors() {
        return kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassKind getKind() {
        return kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.Modality getModality() {
        return kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    public kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility PUBLIC = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PUBLIC;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(PUBLIC, "PUBLIC");
        return PUBLIC;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations getAnnotations() {
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.getEMPTY();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public kotlin.reflect.jvm.internal.impl.descriptors.SourceElement getSource() {
        kotlin.reflect.jvm.internal.impl.descriptors.SourceElement NO_SOURCE = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.parameters;
    }

    /* JADX INFO: compiled from: FunctionClassDescriptor.kt */
    private final class FunctionTypeConstructor extends kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor {
        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return true;
        }

        public FunctionTypeConstructor() {
            super(kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.this.storageManager);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> computeSupertypes() {
            java.util.List listListOf;
            kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind functionTypeKind = kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.this.getFunctionTypeKind();
            if (kotlin.jvm.internal.Intrinsics.areEqual(functionTypeKind, kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.Function.INSTANCE)) {
                listListOf = kotlin.collections.CollectionsKt.listOf(kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.functionClassId);
            } else if (kotlin.jvm.internal.Intrinsics.areEqual(functionTypeKind, kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.KFunction.INSTANCE)) {
                listListOf = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.name.ClassId[]{kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.kFunctionClassId, new kotlin.reflect.jvm.internal.impl.name.ClassId(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_FQ_NAME, kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.Function.INSTANCE.numberedClassName(kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.this.getArity()))});
            } else if (kotlin.jvm.internal.Intrinsics.areEqual(functionTypeKind, kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.SuspendFunction.INSTANCE)) {
                listListOf = kotlin.collections.CollectionsKt.listOf(kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.functionClassId);
            } else if (kotlin.jvm.internal.Intrinsics.areEqual(functionTypeKind, kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.KSuspendFunction.INSTANCE)) {
                listListOf = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.name.ClassId[]{kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.kFunctionClassId, new kotlin.reflect.jvm.internal.impl.name.ClassId(kotlin.reflect.jvm.internal.impl.builtins.StandardNames.COROUTINES_PACKAGE_FQ_NAME, kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionTypeKind.SuspendFunction.INSTANCE.numberedClassName(kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.this.getArity()))});
            } else {
                kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt.shouldNotBeCalled$default(null, 1, null);
                throw new kotlin.KotlinNothingValueException();
            }
            kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor containingDeclaration = kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.this.containingDeclaration.getContainingDeclaration();
            java.util.List<kotlin.reflect.jvm.internal.impl.name.ClassId> list = listListOf;
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
            for (kotlin.reflect.jvm.internal.impl.name.ClassId classId : list) {
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorFindClassAcrossModuleDependencies = kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt.findClassAcrossModuleDependencies(containingDeclaration, classId);
                if (classDescriptorFindClassAcrossModuleDependencies == null) {
                    throw new java.lang.IllegalStateException(("Built-in class " + classId + " not found").toString());
                }
                java.util.List listTakeLast = kotlin.collections.CollectionsKt.takeLast(getParameters(), classDescriptorFindClassAcrossModuleDependencies.getTypeConstructor().getParameters().size());
                java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(listTakeLast, 10));
                java.util.Iterator it = listTakeLast.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl(((kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) it.next()).getDefaultType()));
                }
                arrayList.add(kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.simpleNotNullType(kotlin.reflect.jvm.internal.impl.types.TypeAttributes.Companion.getEmpty(), classDescriptorFindClassAcrossModuleDependencies, arrayList2));
            }
            return kotlin.collections.CollectionsKt.toList(arrayList);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getParameters() {
            return kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.this.parameters;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor, kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* JADX INFO: renamed from: getDeclarationDescriptor */
        public kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor mo1835getDeclarationDescriptor() {
            return kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.this;
        }

        public java.lang.String toString() {
            return mo1835getDeclarationDescriptor().toString();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        protected kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker getSupertypeLoopChecker() {
            return kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY.INSTANCE;
        }
    }

    public java.lang.String toString() {
        java.lang.String strAsString = getName().asString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        return strAsString;
    }

    /* JADX INFO: compiled from: FunctionClassDescriptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.FqName fqName = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.BUILT_INS_PACKAGE_FQ_NAME;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier("Function");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        functionClassId = new kotlin.reflect.jvm.internal.impl.name.ClassId(fqName, nameIdentifier);
        kotlin.reflect.jvm.internal.impl.name.FqName fqName2 = kotlin.reflect.jvm.internal.impl.builtins.StandardNames.KOTLIN_REFLECT_FQ_NAME;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier2 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("KFunction");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier2, "identifier(...)");
        kFunctionClassId = new kotlin.reflect.jvm.internal.impl.name.ClassId(fqName2, nameIdentifier2);
    }
}
