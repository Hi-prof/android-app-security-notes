package kotlin.reflect.jvm.internal.impl.types.checker;

/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NewCapturedTypeConstructor implements kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor {
    private final kotlin.Lazy _supertypes$delegate;
    private final kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor original;
    private final kotlin.reflect.jvm.internal.impl.types.TypeProjection projection;
    private kotlin.jvm.functions.Function0<? extends java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.UnwrappedType>> supertypesComputation;
    private final kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameter;

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List _init_$lambda$0(java.util.List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List initializeSupertypes$lambda$3(java.util.List list) {
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getDeclarationDescriptor */
    public kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor mo1835getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    public NewCapturedTypeConstructor(kotlin.reflect.jvm.internal.impl.types.TypeProjection projection, kotlin.jvm.functions.Function0<? extends java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.UnwrappedType>> function0, kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor newCapturedTypeConstructor, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(projection, "projection");
        this.projection = projection;
        this.supertypesComputation = function0;
        this.original = newCapturedTypeConstructor;
        this.typeParameter = typeParameterDescriptor;
        this._supertypes$delegate = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor._supertypes_delegate$lambda$1(this.arg$0);
            }
        });
    }

    public /* synthetic */ NewCapturedTypeConstructor(kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection, kotlin.jvm.functions.Function0 function0, kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor newCapturedTypeConstructor, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(typeProjection, (i & 2) != 0 ? null : function0, (i & 4) != 0 ? null : newCapturedTypeConstructor, (i & 8) != 0 ? null : typeParameterDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor
    public kotlin.reflect.jvm.internal.impl.types.TypeProjection getProjection() {
        return this.projection;
    }

    public /* synthetic */ NewCapturedTypeConstructor(kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection, java.util.List list, kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor newCapturedTypeConstructor, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(typeProjection, list, (i & 4) != 0 ? null : newCapturedTypeConstructor);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewCapturedTypeConstructor(kotlin.reflect.jvm.internal.impl.types.TypeProjection projection, final java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.UnwrappedType> supertypes, kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor newCapturedTypeConstructor) {
        this(projection, new kotlin.jvm.functions.Function0(supertypes) { // from class: kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor$$Lambda$1
            private final java.util.List arg$0;

            {
                this.arg$0 = supertypes;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor._init_$lambda$0(this.arg$0);
            }
        }, newCapturedTypeConstructor, null, 8, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(projection, "projection");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(supertypes, "supertypes");
    }

    private final java.util.List<kotlin.reflect.jvm.internal.impl.types.UnwrappedType> get_supertypes() {
        return (java.util.List) this._supertypes$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List _supertypes_delegate$lambda$1(kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor newCapturedTypeConstructor) {
        kotlin.jvm.functions.Function0<? extends java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.UnwrappedType>> function0 = newCapturedTypeConstructor.supertypesComputation;
        if (function0 != null) {
            return function0.invoke();
        }
        return null;
    }

    public final void initializeSupertypes(final java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.UnwrappedType> supertypes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(supertypes, "supertypes");
        this.supertypesComputation = new kotlin.jvm.functions.Function0(supertypes) { // from class: kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor$$Lambda$2
            private final java.util.List arg$0;

            {
                this.arg$0 = supertypes;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor.initializeSupertypes$lambda$3(this.arg$0);
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* JADX INFO: renamed from: getSupertypes */
    public java.util.List<kotlin.reflect.jvm.internal.impl.types.UnwrappedType> mo1836getSupertypes() {
        java.util.List<kotlin.reflect.jvm.internal.impl.types.UnwrappedType> list = get_supertypes();
        return list == null ? kotlin.collections.CollectionsKt.emptyList() : list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> getParameters() {
        return kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns getBuiltIns() {
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = getProjection().getType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getBuiltIns(type);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor refine(final kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjectionRefine = getProjection().refine(kotlinTypeRefiner);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeProjectionRefine, "refine(...)");
        kotlin.jvm.functions.Function0 function0 = this.supertypesComputation != null ? new kotlin.jvm.functions.Function0(this, kotlinTypeRefiner) { // from class: kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor$$Lambda$3
            private final kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor arg$0;
            private final kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner arg$1;

            {
                this.arg$0 = this;
                this.arg$1 = kotlinTypeRefiner;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor.refine$lambda$6$lambda$5(this.arg$0, this.arg$1);
            }
        } : null;
        kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor newCapturedTypeConstructor = this.original;
        if (newCapturedTypeConstructor == null) {
            newCapturedTypeConstructor = this;
        }
        return new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor(typeProjectionRefine, function0, newCapturedTypeConstructor, this.typeParameter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List refine$lambda$6$lambda$5(kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor newCapturedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        java.util.List<kotlin.reflect.jvm.internal.impl.types.UnwrappedType> listMo1836getSupertypes = newCapturedTypeConstructor.mo1836getSupertypes();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(listMo1836getSupertypes, 10));
        java.util.Iterator<T> it = listMo1836getSupertypes.iterator();
        while (it.hasNext()) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.types.UnwrappedType) it.next()).refine(kotlinTypeRefiner));
        }
        return arrayList;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!kotlin.jvm.internal.Intrinsics.areEqual(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor newCapturedTypeConstructor = (kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor) obj;
        kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor newCapturedTypeConstructor2 = this.original;
        if (newCapturedTypeConstructor2 == null) {
            newCapturedTypeConstructor2 = this;
        }
        kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor newCapturedTypeConstructor3 = newCapturedTypeConstructor.original;
        if (newCapturedTypeConstructor3 != null) {
            obj = newCapturedTypeConstructor3;
        }
        return newCapturedTypeConstructor2 == obj;
    }

    public int hashCode() {
        kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor newCapturedTypeConstructor = this.original;
        return newCapturedTypeConstructor != null ? newCapturedTypeConstructor.hashCode() : super.hashCode();
    }

    public java.lang.String toString() {
        return "CapturedType(" + getProjection() + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }
}
