package kotlin.reflect.jvm.internal.impl.types.checker;

/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NewCapturedType extends kotlin.reflect.jvm.internal.impl.types.SimpleType implements kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker {
    private final kotlin.reflect.jvm.internal.impl.types.TypeAttributes attributes;
    private final kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus captureStatus;
    private final kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor constructor;
    private final boolean isMarkedNullable;
    private final boolean isProjectionNotNull;
    private final kotlin.reflect.jvm.internal.impl.types.UnwrappedType lowerType;

    public final kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus getCaptureStatus() {
        return this.captureStatus;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor getConstructor() {
        return this.constructor;
    }

    public final kotlin.reflect.jvm.internal.impl.types.UnwrappedType getLowerType() {
        return this.lowerType;
    }

    public /* synthetic */ NewCapturedType(kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus captureStatus, kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor newCapturedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType, kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributes, boolean z, boolean z2, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(captureStatus, newCapturedTypeConstructor, unwrappedType, (i & 8) != 0 ? kotlin.reflect.jvm.internal.impl.types.TypeAttributes.Companion.getEmpty() : typeAttributes, (i & 16) != 0 ? false : z, (i & 32) != 0 ? false : z2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.types.TypeAttributes getAttributes() {
        return this.attributes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    public final boolean isProjectionNotNull() {
        return this.isProjectionNotNull;
    }

    public NewCapturedType(kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus captureStatus, kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor constructor, kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType, kotlin.reflect.jvm.internal.impl.types.TypeAttributes attributes, boolean z, boolean z2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(captureStatus, "captureStatus");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(constructor, "constructor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.captureStatus = captureStatus;
        this.constructor = constructor;
        this.lowerType = unwrappedType;
        this.attributes = attributes;
        this.isMarkedNullable = z;
        this.isProjectionNotNull = z2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NewCapturedType(kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus captureStatus, kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType, kotlin.reflect.jvm.internal.impl.types.TypeProjection projection, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameter) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(captureStatus, "captureStatus");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(projection, "projection");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        kotlin.reflect.jvm.internal.impl.types.TypeAttributes typeAttributes = null;
        boolean z = false;
        boolean z2 = false;
        this(captureStatus, new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor(projection, null, null, typeParameter, 6, null), unwrappedType, typeAttributes, z, z2, 56, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> getArguments() {
        return kotlin.collections.CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getMemberScope() {
        return kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorScope(kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind.CAPTURED_TYPE_SCOPE, true, new java.lang.String[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.SimpleType replaceAttributes(kotlin.reflect.jvm.internal.impl.types.TypeAttributes newAttributes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType(this.captureStatus, getConstructor(), this.lowerType, newAttributes, isMarkedNullable(), this.isProjectionNotNull);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType makeNullableAsSpecified(boolean z) {
        return new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType(this.captureStatus, getConstructor(), this.lowerType, getAttributes(), z, false, 32, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus captureStatus = this.captureStatus;
        kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor newCapturedTypeConstructorRefine = getConstructor().refine(kotlinTypeRefiner);
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedType = this.lowerType;
        return new kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType(captureStatus, newCapturedTypeConstructorRefine, unwrappedType != null ? kotlinTypeRefiner.refineType((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) unwrappedType).unwrap() : null, getAttributes(), isMarkedNullable(), false, 32, null);
    }
}
