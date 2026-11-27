package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: StarProjectionImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StarProjectionImpl extends kotlin.reflect.jvm.internal.impl.types.TypeProjectionBase {
    private final kotlin.Lazy _type$delegate;
    private final kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameter;

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public boolean isStarProjection() {
        return true;
    }

    public StarProjectionImpl(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        this.typeParameter = typeParameter;
        this._type$delegate = kotlin.LazyKt.lazy(kotlin.LazyThreadSafetyMode.PUBLICATION, new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl._type_delegate$lambda$0(this.arg$0);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public kotlin.reflect.jvm.internal.impl.types.Variance getProjectionKind() {
        return kotlin.reflect.jvm.internal.impl.types.Variance.OUT_VARIANCE;
    }

    private final kotlin.reflect.jvm.internal.impl.types.KotlinType get_type() {
        return (kotlin.reflect.jvm.internal.impl.types.KotlinType) this._type$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType _type_delegate$lambda$0(kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl starProjectionImpl) {
        return kotlin.reflect.jvm.internal.impl.types.StarProjectionImplKt.starProjectionType(starProjectionImpl.typeParameter);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public kotlin.reflect.jvm.internal.impl.types.KotlinType getType() {
        return get_type();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public kotlin.reflect.jvm.internal.impl.types.TypeProjection refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}
