package kotlin.reflect.jvm.internal.impl.descriptors.impl;

/* JADX INFO: compiled from: ValueParameterDescriptorImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public class ValueParameterDescriptorImpl extends kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl implements kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl.Companion Companion = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl.Companion(null);
    private final boolean declaresDefaultValue;
    private final int index;
    private final boolean isCrossinline;
    private final boolean isNoinline;
    private final kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor original;
    private final kotlin.reflect.jvm.internal.impl.types.KotlinType varargElementType;

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl createWithDestructuringDeclarations(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor, int i, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, boolean z, boolean z2, boolean z3, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType2, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement sourceElement, kotlin.jvm.functions.Function0<? extends java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor>> function0) {
        return Companion.createWithDestructuringDeclarations(callableDescriptor, valueParameterDescriptor, i, annotations, name, kotlinType, z, z2, z3, kotlinType2, sourceElement, function0);
    }

    public java.lang.Void getCompileTimeInitializer() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isVar() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    /* JADX INFO: renamed from: getCompileTimeInitializer, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue mo1827getCompileTimeInitializer() {
        return (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) getCompileTimeInitializer();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isLateInit() {
        return kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor.DefaultImpls.isLateInit(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public int getIndex() {
        return this.index;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public boolean isCrossinline() {
        return this.isCrossinline;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public boolean isNoinline() {
        return this.isNoinline;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public kotlin.reflect.jvm.internal.impl.types.KotlinType getVarargElementType() {
        return this.varargElementType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ValueParameterDescriptorImpl(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor containingDeclaration, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor, int i, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.types.KotlinType outType, boolean z, boolean z2, boolean z3, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source) {
        super(containingDeclaration, annotations, name, outType, source);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "annotations");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(outType, "outType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
        this.index = i;
        this.declaresDefaultValue = z;
        this.isCrossinline = z2;
        this.isNoinline = z3;
        this.varargElementType = kotlinType;
        this.original = valueParameterDescriptor == null ? this : valueParameterDescriptor;
    }

    /* JADX INFO: compiled from: ValueParameterDescriptorImpl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @kotlin.jvm.JvmStatic
        public final kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl createWithDestructuringDeclarations(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor containingDeclaration, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor, int i, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.types.KotlinType outType, boolean z, boolean z2, boolean z3, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source, kotlin.jvm.functions.Function0<? extends java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor>> function0) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "annotations");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(outType, "outType");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
            if (function0 == null) {
                return new kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl(containingDeclaration, valueParameterDescriptor, i, annotations, name, outType, z, z2, z3, kotlinType, source);
            }
            return new kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl.WithDestructuringDeclaration(containingDeclaration, valueParameterDescriptor, i, annotations, name, outType, z, z2, z3, kotlinType, source, function0);
        }
    }

    /* JADX INFO: compiled from: ValueParameterDescriptorImpl.kt */
    public static final class WithDestructuringDeclaration extends kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl {
        private final kotlin.Lazy destructuringVariables$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WithDestructuringDeclaration(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor containingDeclaration, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor, int i, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.types.KotlinType outType, boolean z, boolean z2, boolean z3, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source, kotlin.jvm.functions.Function0<? extends java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor>> destructuringVariables) {
            super(containingDeclaration, valueParameterDescriptor, i, annotations, name, outType, z, z2, z3, kotlinType, source);
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotations, "annotations");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(outType, "outType");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destructuringVariables, "destructuringVariables");
            this.destructuringVariables$delegate = kotlin.LazyKt.lazy(destructuringVariables);
        }

        public final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor> getDestructuringVariables() {
            return (java.util.List) this.destructuringVariables$delegate.getValue();
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
        public kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor copy(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor newOwner, kotlin.reflect.jvm.internal.impl.name.Name newName, int i) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newOwner, "newOwner");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newName, "newName");
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations = getAnnotations();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(annotations, "<get-annotations>(...)");
            kotlin.reflect.jvm.internal.impl.types.KotlinType type = getType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            boolean zDeclaresDefaultValue = declaresDefaultValue();
            boolean zIsCrossinline = isCrossinline();
            boolean zIsNoinline = isNoinline();
            kotlin.reflect.jvm.internal.impl.types.KotlinType varargElementType = getVarargElementType();
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement NO_SOURCE = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
            return new kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl.WithDestructuringDeclaration(newOwner, null, i, annotations, newName, type, zDeclaresDefaultValue, zIsCrossinline, zIsNoinline, varargElementType, NO_SOURCE, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl$WithDestructuringDeclaration$$Lambda$0
                private final kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl.WithDestructuringDeclaration arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return this.arg$0.getDestructuringVariables();
                }
            });
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor getContainingDeclaration() {
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = super.getContainingDeclaration();
        kotlin.jvm.internal.Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        return (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) containingDeclaration;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public boolean declaresDefaultValue() {
        if (!this.declaresDefaultValue) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor containingDeclaration = getContainingDeclaration();
        kotlin.jvm.internal.Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
        return ((kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) containingDeclaration).getKind().isReal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor getOriginal() {
        kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor = this.original;
        return valueParameterDescriptor == this ? this : valueParameterDescriptor.getOriginal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor substitute(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor substitutor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(substitutor, "substitutor");
        if (substitutor.isEmpty()) {
            return this;
        }
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor<R, D> visitor, D d) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visitor, "visitor");
        return visitor.visitValueParameterDescriptor(this, d);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor copy(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor newOwner, kotlin.reflect.jvm.internal.impl.name.Name newName, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newName, "newName");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations annotations = getAnnotations();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(annotations, "<get-annotations>(...)");
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = getType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        boolean zDeclaresDefaultValue = declaresDefaultValue();
        boolean zIsCrossinline = isCrossinline();
        boolean zIsNoinline = isNoinline();
        kotlin.reflect.jvm.internal.impl.types.KotlinType varargElementType = getVarargElementType();
        kotlin.reflect.jvm.internal.impl.descriptors.SourceElement NO_SOURCE = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
        return new kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl(newOwner, null, i, annotations, newName, type, zDeclaresDefaultValue, zIsCrossinline, zIsNoinline, varargElementType, NO_SOURCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    public kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility LOCAL = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.LOCAL;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(LOCAL, "LOCAL");
        return LOCAL;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.VariableDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> getOverriddenDescriptors() {
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor> overriddenDescriptors = getContainingDeclaration().getOverriddenDescriptors();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor> collection = overriddenDescriptors;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(collection, 10));
        java.util.Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) it.next()).getValueParameters().get(getIndex()));
        }
        return arrayList;
    }
}
