package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

/* JADX INFO: compiled from: RawType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RawTypeImpl extends kotlin.reflect.jvm.internal.impl.types.FlexibleType implements kotlin.reflect.jvm.internal.impl.types.RawType {
    private RawTypeImpl(kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType, kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType2, boolean z) {
        super(simpleType, simpleType2);
        if (z) {
            return;
        }
        kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.DEFAULT.isSubtypeOf(simpleType, simpleType2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RawTypeImpl(kotlin.reflect.jvm.internal.impl.types.SimpleType lowerBound, kotlin.reflect.jvm.internal.impl.types.SimpleType upperBound) {
        this(lowerBound, upperBound, false);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lowerBound, "lowerBound");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(upperBound, "upperBound");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public kotlin.reflect.jvm.internal.impl.types.SimpleType getDelegate() {
        return getLowerBound();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope getMemberScope() {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = getConstructor().mo1835getDeclarationDescriptor();
        kotlin.reflect.jvm.internal.impl.types.TypeParameterUpperBoundEraser typeParameterUpperBoundEraser = null;
        java.lang.Object[] objArr = 0;
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor : null;
        if (classDescriptor == null) {
            throw new java.lang.IllegalStateException(("Incorrect classifier: " + getConstructor().mo1835getDeclarationDescriptor()).toString());
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope memberScope = classDescriptor.getMemberScope(new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution(typeParameterUpperBoundEraser, 1, objArr == true ? 1 : 0));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(memberScope, "getMemberScope(...)");
        return memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl replaceAttributes(kotlin.reflect.jvm.internal.impl.types.TypeAttributes newAttributes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newAttributes, "newAttributes");
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl(getLowerBound().replaceAttributes(newAttributes), getUpperBound().replaceAttributes(newAttributes));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl makeNullableAsSpecified(boolean z) {
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl(getLowerBound().makeNullableAsSpecified(z), getUpperBound().makeNullableAsSpecified(z));
    }

    private static final boolean render$onlyOutDiffers(java.lang.String str, java.lang.String str2) {
        return kotlin.jvm.internal.Intrinsics.areEqual(str, kotlin.text.StringsKt.removePrefix(str2, (java.lang.CharSequence) "out ")) || kotlin.jvm.internal.Intrinsics.areEqual(str2, "*");
    }

    private static final java.util.List<java.lang.String> render$renderArguments(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer descriptorRenderer, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments = kotlinType.getArguments();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arguments, 10));
        java.util.Iterator<T> it = arguments.iterator();
        while (it.hasNext()) {
            arrayList.add(descriptorRenderer.renderTypeProjection((kotlin.reflect.jvm.internal.impl.types.TypeProjection) it.next()));
        }
        return arrayList;
    }

    private static final java.lang.String render$replaceArgs(java.lang.String str, java.lang.String str2) {
        if (!kotlin.text.StringsKt.contains$default((java.lang.CharSequence) str, kotlin.text.Typography.less, false, 2, (java.lang.Object) null)) {
            return str;
        }
        return kotlin.text.StringsKt.substringBefore$default(str, kotlin.text.Typography.less, (java.lang.String) null, 2, (java.lang.Object) null) + kotlin.text.Typography.less + str2 + kotlin.text.Typography.greater + kotlin.text.StringsKt.substringAfterLast$default(str, kotlin.text.Typography.greater, (java.lang.String) null, 2, (java.lang.Object) null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.FlexibleType
    public java.lang.String render(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer renderer, kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions options) {
        kotlin.Pair pair;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(renderer, "renderer");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        java.lang.String strRenderType = renderer.renderType(getLowerBound());
        java.lang.String strRenderType2 = renderer.renderType(getUpperBound());
        if (options.getDebugMode()) {
            return "raw (" + strRenderType + io.dcloud.common.util.PdrUtil.FILE_PATH_ENTRY_BACK + strRenderType2 + com.taobao.weex.el.parse.Operators.BRACKET_END;
        }
        if (getUpperBound().getArguments().isEmpty()) {
            return renderer.renderFlexibleType(strRenderType, strRenderType2, kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getBuiltIns(this));
        }
        java.util.List<java.lang.String> listRender$renderArguments = render$renderArguments(renderer, getLowerBound());
        java.util.List<java.lang.String> listRender$renderArguments2 = render$renderArguments(renderer, getUpperBound());
        java.util.List<java.lang.String> list = listRender$renderArguments;
        java.lang.String strJoinToString$default = kotlin.collections.CollectionsKt.joinToString$default(list, ", ", null, null, 0, null, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl.render$lambda$2((java.lang.String) obj);
            }
        }, 30, null);
        java.util.List listZip = kotlin.collections.CollectionsKt.zip(list, listRender$renderArguments2);
        if ((listZip instanceof java.util.Collection) && listZip.isEmpty()) {
            strRenderType2 = render$replaceArgs(strRenderType2, strJoinToString$default);
            break;
        }
        java.util.Iterator it = listZip.iterator();
        do {
            if (!it.hasNext()) {
                strRenderType2 = render$replaceArgs(strRenderType2, strJoinToString$default);
                break;
            }
            pair = (kotlin.Pair) it.next();
        } while (render$onlyOutDiffers((java.lang.String) pair.getFirst(), (java.lang.String) pair.getSecond()));
        java.lang.String strRender$replaceArgs = render$replaceArgs(strRenderType, strJoinToString$default);
        return kotlin.jvm.internal.Intrinsics.areEqual(strRender$replaceArgs, strRenderType2) ? strRender$replaceArgs : renderer.renderFlexibleType(strRender$replaceArgs, strRenderType2, kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getBuiltIns(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.CharSequence render$lambda$2(java.lang.String it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return "(raw) " + it;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public kotlin.reflect.jvm.internal.impl.types.FlexibleType refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner kotlinTypeRefiner) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeRefineType = kotlinTypeRefiner.refineType((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) getLowerBound());
        kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinTypeRefineType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeRefineType2 = kotlinTypeRefiner.refineType((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) getUpperBound());
        kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinTypeRefineType2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl((kotlin.reflect.jvm.internal.impl.types.SimpleType) kotlinTypeRefineType, (kotlin.reflect.jvm.internal.impl.types.SimpleType) kotlinTypeRefineType2, true);
    }
}
