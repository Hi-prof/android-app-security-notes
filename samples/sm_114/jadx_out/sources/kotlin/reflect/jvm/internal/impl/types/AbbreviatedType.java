package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AbbreviatedType extends kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType {
    private final kotlin.reflect.jvm.internal.impl.types.SimpleType abbreviation;
    private final kotlin.reflect.jvm.internal.impl.types.SimpleType delegate;

    public AbbreviatedType(kotlin.reflect.jvm.internal.impl.types.SimpleType delegate, kotlin.reflect.jvm.internal.impl.types.SimpleType abbreviation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delegate, "delegate");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(abbreviation, "abbreviation");
        this.delegate = delegate;
        this.abbreviation = abbreviation;
    }

    public final kotlin.reflect.jvm.internal.impl.types.SimpleType getAbbreviation() {
        return this.abbreviation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    protected kotlin.reflect.jvm.internal.impl.types.SimpleType getDelegate() {
        return this.delegate;
    }

    public final kotlin.reflect.jvm.internal.impl.types.SimpleType getExpandedType() {
        return getDelegate();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.SimpleType replaceAttributes(kotlin.reflect.jvm.internal.impl.types.TypeAttributes newAttributes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return new kotlin.reflect.jvm.internal.impl.types.AbbreviatedType(getDelegate().replaceAttributes(newAttributes), this.abbreviation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.types.AbbreviatedType makeNullableAsSpecified(boolean z) {
        return new kotlin.reflect.jvm.internal.impl.types.AbbreviatedType(getDelegate().makeNullableAsSpecified(z), this.abbreviation.makeNullableAsSpecified(z));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public kotlin.reflect.jvm.internal.impl.types.AbbreviatedType replaceDelegate(kotlin.reflect.jvm.internal.impl.types.SimpleType delegate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(delegate, "delegate");
        return new kotlin.reflect.jvm.internal.impl.types.AbbreviatedType(delegate, this.abbreviation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.types.AbbreviatedType refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeRefineType = kotlinTypeRefiner.refineType((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) getDelegate());
        kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinTypeRefineType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeRefineType2 = kotlinTypeRefiner.refineType((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) this.abbreviation);
        kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinTypeRefineType2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new kotlin.reflect.jvm.internal.impl.types.AbbreviatedType((kotlin.reflect.jvm.internal.impl.types.SimpleType) kotlinTypeRefineType, (kotlin.reflect.jvm.internal.impl.types.SimpleType) kotlinTypeRefineType2);
    }
}
