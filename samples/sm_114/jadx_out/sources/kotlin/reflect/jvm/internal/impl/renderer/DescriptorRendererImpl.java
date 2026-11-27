package kotlin.reflect.jvm.internal.impl.renderer;

/* JADX INFO: compiled from: DescriptorRendererImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DescriptorRendererImpl extends kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer implements kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions {
    private final kotlin.Lazy functionTypeAnnotationsRenderer$delegate;
    private final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl options;

    /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.PLAIN.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.HTML.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy.values().length];
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy.ALL.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy.NONE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return this.options.getActualPropertiesInPrimaryConstructor();
    }

    public boolean getAlwaysRenderModifiers() {
        return this.options.getAlwaysRenderModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy() {
        return this.options.getAnnotationArgumentsRenderingPolicy();
    }

    public kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor, java.lang.Boolean> getAnnotationFilter() {
        return this.options.getAnnotationFilter();
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return this.options.getBoldOnlyForNamesInHtml();
    }

    public boolean getClassWithPrimaryConstructor() {
        return this.options.getClassWithPrimaryConstructor();
    }

    public kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy getClassifierNamePolicy() {
        return this.options.getClassifierNamePolicy();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getDebugMode() {
        return this.options.getDebugMode();
    }

    public kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor, java.lang.String> getDefaultParameterValueRenderer() {
        return this.options.getDefaultParameterValueRenderer();
    }

    public boolean getEachAnnotationOnNewLine() {
        return this.options.getEachAnnotationOnNewLine();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getEnhancedTypes() {
        return this.options.getEnhancedTypes();
    }

    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> getExcludedAnnotationClasses() {
        return this.options.getExcludedAnnotationClasses();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> getExcludedTypeAnnotationClasses() {
        return this.options.getExcludedTypeAnnotationClasses();
    }

    public boolean getIncludeAdditionalModifiers() {
        return this.options.getIncludeAdditionalModifiers();
    }

    public boolean getIncludeAnnotationArguments() {
        return this.options.getIncludeAnnotationArguments();
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return this.options.getIncludeEmptyAnnotationArguments();
    }

    public boolean getIncludePropertyConstant() {
        return this.options.getIncludePropertyConstant();
    }

    public boolean getInformativeErrorType() {
        return this.options.getInformativeErrorType();
    }

    public java.util.Set<kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier> getModifiers() {
        return this.options.getModifiers();
    }

    public boolean getNormalizedVisibilities() {
        return this.options.getNormalizedVisibilities();
    }

    public kotlin.reflect.jvm.internal.impl.renderer.OverrideRenderingPolicy getOverrideRenderingPolicy() {
        return this.options.getOverrideRenderingPolicy();
    }

    public kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy getParameterNameRenderingPolicy() {
        return this.options.getParameterNameRenderingPolicy();
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return this.options.getParameterNamesInFunctionalTypes();
    }

    public boolean getPresentableUnresolvedTypes() {
        return this.options.getPresentableUnresolvedTypes();
    }

    public kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy getPropertyAccessorRenderingPolicy() {
        return this.options.getPropertyAccessorRenderingPolicy();
    }

    public boolean getReceiverAfterName() {
        return this.options.getReceiverAfterName();
    }

    public boolean getRenderAbbreviatedTypeComments() {
        return this.options.getRenderAbbreviatedTypeComments();
    }

    public boolean getRenderCompanionObjectName() {
        return this.options.getRenderCompanionObjectName();
    }

    public boolean getRenderConstructorDelegation() {
        return this.options.getRenderConstructorDelegation();
    }

    public boolean getRenderConstructorKeyword() {
        return this.options.getRenderConstructorKeyword();
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return this.options.getRenderDefaultAnnotationArguments();
    }

    public boolean getRenderDefaultModality() {
        return this.options.getRenderDefaultModality();
    }

    public boolean getRenderDefaultVisibility() {
        return this.options.getRenderDefaultVisibility();
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return this.options.getRenderPrimaryConstructorParametersAsProperties();
    }

    public boolean getRenderTypeExpansions() {
        return this.options.getRenderTypeExpansions();
    }

    public boolean getRenderUnabbreviatedType() {
        return this.options.getRenderUnabbreviatedType();
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return this.options.getSecondaryConstructorsAsPrimary();
    }

    public boolean getStartFromDeclarationKeyword() {
        return this.options.getStartFromDeclarationKeyword();
    }

    public boolean getStartFromName() {
        return this.options.getStartFromName();
    }

    public kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat getTextFormat() {
        return this.options.getTextFormat();
    }

    public kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.types.KotlinType> getTypeNormalizer() {
        return this.options.getTypeNormalizer();
    }

    public boolean getUninferredTypeParameterAsName() {
        return this.options.getUninferredTypeParameterAsName();
    }

    public boolean getUnitReturnType() {
        return this.options.getUnitReturnType();
    }

    public kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler getValueParametersHandler() {
        return this.options.getValueParametersHandler();
    }

    public boolean getVerbose() {
        return this.options.getVerbose();
    }

    public boolean getWithDefinedIn() {
        return this.options.getWithDefinedIn();
    }

    public boolean getWithSourceFileForTopLevel() {
        return this.options.getWithSourceFileForTopLevel();
    }

    public boolean getWithoutReturnType() {
        return this.options.getWithoutReturnType();
    }

    public boolean getWithoutSuperTypes() {
        return this.options.getWithoutSuperTypes();
    }

    public boolean getWithoutTypeParameters() {
        return this.options.getWithoutTypeParameters();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setAnnotationArgumentsRenderingPolicy(kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotationArgumentsRenderingPolicy, "<set-?>");
        this.options.setAnnotationArgumentsRenderingPolicy(annotationArgumentsRenderingPolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setClassifierNamePolicy(kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy classifierNamePolicy) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classifierNamePolicy, "<set-?>");
        this.options.setClassifierNamePolicy(classifierNamePolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setDebugMode(boolean z) {
        this.options.setDebugMode(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setExcludedTypeAnnotationClasses(java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> set) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.options.setExcludedTypeAnnotationClasses(set);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setModifiers(java.util.Set<? extends kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier> set) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.options.setModifiers(set);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setParameterNameRenderingPolicy(kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parameterNameRenderingPolicy, "<set-?>");
        this.options.setParameterNameRenderingPolicy(parameterNameRenderingPolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setReceiverAfterName(boolean z) {
        this.options.setReceiverAfterName(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setRenderCompanionObjectName(boolean z) {
        this.options.setRenderCompanionObjectName(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setStartFromName(boolean z) {
        this.options.setStartFromName(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setTextFormat(kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat renderingFormat) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(renderingFormat, "<set-?>");
        this.options.setTextFormat(renderingFormat);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setVerbose(boolean z) {
        this.options.setVerbose(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithDefinedIn(boolean z) {
        this.options.setWithDefinedIn(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutSuperTypes(boolean z) {
        this.options.setWithoutSuperTypes(z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutTypeParameters(boolean z) {
        this.options.setWithoutTypeParameters(z);
    }

    public final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl getOptions() {
        return this.options;
    }

    public DescriptorRendererImpl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl options) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
        this.options = options;
        options.isLocked();
        this.functionTypeAnnotationsRenderer$delegate = kotlin.LazyKt.lazy(new kotlin.jvm.functions.Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.functionTypeAnnotationsRenderer_delegate$lambda$1(this.arg$0);
            }
        });
    }

    private final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl getFunctionTypeAnnotationsRenderer() {
        return (kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl) this.functionTypeAnnotationsRenderer$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl functionTypeAnnotationsRenderer_delegate$lambda$1(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl descriptorRendererImpl) {
        kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer descriptorRendererWithOptions = descriptorRendererImpl.withOptions(new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$$Lambda$5
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.functionTypeAnnotationsRenderer_delegate$lambda$1$lambda$0((kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions) obj);
            }
        });
        kotlin.jvm.internal.Intrinsics.checkNotNull(descriptorRendererWithOptions, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        return (kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl) descriptorRendererWithOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit functionTypeAnnotationsRenderer_delegate$lambda$1$lambda$0(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions withOptions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setExcludedTypeAnnotationClasses(kotlin.collections.SetsKt.plus((java.util.Set) withOptions.getExcludedTypeAnnotationClasses(), (java.lang.Iterable) kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.name.FqName[]{kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.extensionFunctionType, kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.contextFunctionTypeParams})));
        return kotlin.Unit.INSTANCE;
    }

    private final java.lang.String renderKeyword(java.lang.String str) {
        int i = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new kotlin.NoWhenBranchMatchedException();
            }
            if (!getBoldOnlyForNamesInHtml()) {
                return "<b>" + str + "</b>";
            }
        }
        return str;
    }

    private final java.lang.String renderError(java.lang.String str) {
        int i = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (i == 1) {
            return str;
        }
        if (i != 2) {
            throw new kotlin.NoWhenBranchMatchedException();
        }
        return "<font color=red><b>" + str + "</b></font>";
    }

    private final java.lang.String escape(java.lang.String str) {
        return getTextFormat().escape(str);
    }

    private final java.lang.String lt() {
        return escape(com.taobao.weex.el.parse.Operators.L);
    }

    private final java.lang.String gt() {
        return escape(com.taobao.weex.el.parse.Operators.G);
    }

    private final java.lang.String arrow() {
        int i = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (i == 1) {
            return escape("->");
        }
        if (i != 2) {
            throw new kotlin.NoWhenBranchMatchedException();
        }
        return "&rarr;";
    }

    public java.lang.String renderMessage(java.lang.String message) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(message, "message");
        int i = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.WhenMappings.$EnumSwitchMapping$0[getTextFormat().ordinal()];
        if (i == 1) {
            return message;
        }
        if (i != 2) {
            throw new kotlin.NoWhenBranchMatchedException();
        }
        return "<i>" + message + "</i>";
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public java.lang.String renderName(kotlin.reflect.jvm.internal.impl.name.Name name, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        java.lang.String strEscape = escape(kotlin.reflect.jvm.internal.impl.renderer.RenderingUtilsKt.render(name));
        if (!getBoldOnlyForNamesInHtml() || getTextFormat() != kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.HTML || !z) {
            return strEscape;
        }
        return "<b>" + strEscape + "</b>";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderName(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, java.lang.StringBuilder sb, boolean z) {
        kotlin.reflect.jvm.internal.impl.name.Name name = declarationDescriptor.getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        sb.append(renderName(name, z));
    }

    private final void renderCompanionObjectName(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor, java.lang.StringBuilder sb) {
        if (getRenderCompanionObjectName()) {
            if (getStartFromName()) {
                sb.append("companion object");
            }
            renderSpaceIfNeeded(sb);
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
            if (containingDeclaration != null) {
                sb.append("of ");
                kotlin.reflect.jvm.internal.impl.name.Name name = containingDeclaration.getName();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                sb.append(renderName(name, false));
            }
        }
        if (getVerbose() || !kotlin.jvm.internal.Intrinsics.areEqual(declarationDescriptor.getName(), kotlin.reflect.jvm.internal.impl.name.SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT)) {
            if (!getStartFromName()) {
                renderSpaceIfNeeded(sb);
            }
            kotlin.reflect.jvm.internal.impl.name.Name name2 = declarationDescriptor.getName();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            sb.append(renderName(name2, true));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public java.lang.String renderFqName(kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        return renderFqName(fqName.pathSegments());
    }

    private final java.lang.String renderFqName(java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> list) {
        return escape(kotlin.reflect.jvm.internal.impl.renderer.RenderingUtilsKt.renderFqName(list));
    }

    public java.lang.String renderClassifierName(kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor klass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(klass, "klass");
        if (kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.isError(klass)) {
            return klass.getTypeConstructor().toString();
        }
        return getClassifierNamePolicy().renderClassifier(klass, this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public java.lang.String renderType(kotlin.reflect.jvm.internal.impl.types.KotlinType type) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        renderNormalizedType(sb, getTypeNormalizer().invoke2(type));
        return sb.toString();
    }

    private final void renderNormalizedType(java.lang.StringBuilder sb, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = kotlinType.unwrap();
        kotlin.reflect.jvm.internal.impl.types.AbbreviatedType abbreviatedType = unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.AbbreviatedType ? (kotlin.reflect.jvm.internal.impl.types.AbbreviatedType) unwrappedTypeUnwrap : null;
        if (abbreviatedType != null) {
            if (getRenderTypeExpansions()) {
                renderNormalizedTypeAsIs(sb, abbreviatedType.getExpandedType());
                if (getRenderAbbreviatedTypeComments()) {
                    renderAbbreviatedTypeComment(sb, abbreviatedType);
                    return;
                }
                return;
            }
            renderNormalizedTypeAsIs(sb, abbreviatedType.getAbbreviation());
            if (getRenderUnabbreviatedType()) {
                renderExpandedTypeComment(sb, abbreviatedType);
                return;
            }
            return;
        }
        renderNormalizedTypeAsIs(sb, kotlinType);
    }

    private final void renderNormalizedTypeAsIs(java.lang.StringBuilder sb, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if ((kotlinType instanceof kotlin.reflect.jvm.internal.impl.types.WrappedType) && getDebugMode() && !((kotlin.reflect.jvm.internal.impl.types.WrappedType) kotlinType).isComputed()) {
            sb.append("<Not computed yet>");
            return;
        }
        kotlin.reflect.jvm.internal.impl.types.UnwrappedType unwrappedTypeUnwrap = kotlinType.unwrap();
        if (unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType) {
            sb.append(((kotlin.reflect.jvm.internal.impl.types.FlexibleType) unwrappedTypeUnwrap).render(this, this));
        } else {
            if (!(unwrappedTypeUnwrap instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType)) {
                throw new kotlin.NoWhenBranchMatchedException();
            }
            renderSimpleType(sb, (kotlin.reflect.jvm.internal.impl.types.SimpleType) unwrappedTypeUnwrap);
        }
    }

    private final void renderSimpleType(java.lang.StringBuilder sb, kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType) {
        if (!kotlin.jvm.internal.Intrinsics.areEqual(simpleType, kotlin.reflect.jvm.internal.impl.types.TypeUtils.CANNOT_INFER_FUNCTION_PARAM_TYPE)) {
            kotlin.reflect.jvm.internal.impl.types.SimpleType simpleType2 = simpleType;
            if (!kotlin.reflect.jvm.internal.impl.types.TypeUtils.isDontCarePlaceholder(simpleType2)) {
                if (kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.isUninferredTypeVariable(simpleType2)) {
                    if (getUninferredTypeParameterAsName()) {
                        kotlin.reflect.jvm.internal.impl.types.TypeConstructor constructor = simpleType.getConstructor();
                        kotlin.jvm.internal.Intrinsics.checkNotNull(constructor, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
                        sb.append(renderError(((kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeConstructor) constructor).getParam(0)));
                        return;
                    }
                    sb.append("???");
                    return;
                }
                if (kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(simpleType2)) {
                    renderDefaultType(sb, simpleType2);
                    return;
                } else if (shouldRenderAsPrettyFunctionType(simpleType2)) {
                    renderFunctionType(sb, simpleType2);
                    return;
                } else {
                    renderDefaultType(sb, simpleType2);
                    return;
                }
            }
        }
        sb.append("???");
    }

    private final boolean shouldRenderAsPrettyFunctionType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        if (!kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.isBuiltinFunctionalType(kotlinType)) {
            return false;
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> arguments = kotlinType.getArguments();
        if ((arguments instanceof java.util.Collection) && arguments.isEmpty()) {
            return true;
        }
        java.util.Iterator<T> it = arguments.iterator();
        while (it.hasNext()) {
            if (((kotlin.reflect.jvm.internal.impl.types.TypeProjection) it.next()).isStarProjection()) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public java.lang.String renderFlexibleType(java.lang.String lowerRendered, java.lang.String upperRendered, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns builtIns) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(lowerRendered, "lowerRendered");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(upperRendered, "upperRendered");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        if (kotlin.reflect.jvm.internal.impl.renderer.RenderingUtilsKt.typeStringsDifferOnlyInNullability(lowerRendered, upperRendered)) {
            if (kotlin.text.StringsKt.startsWith$default(upperRendered, com.taobao.weex.el.parse.Operators.BRACKET_START_STR, false, 2, (java.lang.Object) null)) {
                return com.taobao.weex.el.parse.Operators.BRACKET_START_STR + lowerRendered + ")!";
            }
            return lowerRendered + '!';
        }
        kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy classifierNamePolicy = getClassifierNamePolicy();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor collection = builtIns.getCollection();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collection, "getCollection(...)");
        kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl descriptorRendererImpl = this;
        java.lang.String strSubstringBefore$default = kotlin.text.StringsKt.substringBefore$default(classifierNamePolicy.renderClassifier(collection, descriptorRendererImpl), "Collection", (java.lang.String) null, 2, (java.lang.Object) null);
        java.lang.String strReplacePrefixesInTypeRepresentations = kotlin.reflect.jvm.internal.impl.renderer.RenderingUtilsKt.replacePrefixesInTypeRepresentations(lowerRendered, strSubstringBefore$default + "Mutable", upperRendered, strSubstringBefore$default, strSubstringBefore$default + "(Mutable)");
        if (strReplacePrefixesInTypeRepresentations != null) {
            return strReplacePrefixesInTypeRepresentations;
        }
        java.lang.String strReplacePrefixesInTypeRepresentations2 = kotlin.reflect.jvm.internal.impl.renderer.RenderingUtilsKt.replacePrefixesInTypeRepresentations(lowerRendered, strSubstringBefore$default + "MutableMap.MutableEntry", upperRendered, strSubstringBefore$default + "Map.Entry", strSubstringBefore$default + "(Mutable)Map.(Mutable)Entry");
        if (strReplacePrefixesInTypeRepresentations2 != null) {
            return strReplacePrefixesInTypeRepresentations2;
        }
        kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy classifierNamePolicy2 = getClassifierNamePolicy();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor array = builtIns.getArray();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(array, "getArray(...)");
        java.lang.String strSubstringBefore$default2 = kotlin.text.StringsKt.substringBefore$default(classifierNamePolicy2.renderClassifier(array, descriptorRendererImpl), "Array", (java.lang.String) null, 2, (java.lang.Object) null);
        java.lang.String strReplacePrefixesInTypeRepresentations3 = kotlin.reflect.jvm.internal.impl.renderer.RenderingUtilsKt.replacePrefixesInTypeRepresentations(lowerRendered, strSubstringBefore$default2 + escape("Array<"), upperRendered, strSubstringBefore$default2 + escape("Array<out "), strSubstringBefore$default2 + escape("Array<(out) "));
        if (strReplacePrefixesInTypeRepresentations3 != null) {
            return strReplacePrefixesInTypeRepresentations3;
        }
        return com.taobao.weex.el.parse.Operators.BRACKET_START_STR + lowerRendered + io.dcloud.common.util.PdrUtil.FILE_PATH_ENTRY_BACK + upperRendered + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }

    public java.lang.String renderTypeArguments(java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> typeArguments) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        if (typeArguments.isEmpty()) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(lt());
        appendTypeProjections(sb, typeArguments);
        sb.append(gt());
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x009e  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:37:? A[RETURN, SYNTHETIC] */
    private final void renderDefaultType(java.lang.StringBuilder sb, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType2;
        renderAnnotations$default(this, sb, kotlinType, null, 2, null);
        kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType definitelyNotNullType = kotlinType instanceof kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType ? (kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType) kotlinType : null;
        kotlin.reflect.jvm.internal.impl.types.SimpleType original = definitelyNotNullType != null ? definitelyNotNullType.getOriginal() : null;
        if (kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(kotlinType)) {
            if (kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.isUnresolvedType(kotlinType) && getPresentableUnresolvedTypes()) {
                sb.append(renderError(kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.INSTANCE.unresolvedTypeAsItIs(kotlinType)));
            } else {
                if ((kotlinType instanceof kotlin.reflect.jvm.internal.impl.types.error.ErrorType) && !getInformativeErrorType()) {
                    sb.append(((kotlin.reflect.jvm.internal.impl.types.error.ErrorType) kotlinType).getDebugMessage());
                } else {
                    sb.append(kotlinType.getConstructor().toString());
                }
                sb.append(renderTypeArguments(kotlinType.getArguments()));
            }
        } else if (kotlinType instanceof kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference) {
            sb.append(((kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference) kotlinType).getOriginalTypeVariable().toString());
        } else {
            if (original instanceof kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference) {
                sb.append(((kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference) original).getOriginalTypeVariable().toString());
            } else {
                kotlinType2 = kotlinType;
                renderTypeConstructorAndArguments$default(this, sb, kotlinType2, null, 2, null);
                kotlin.Unit unit = kotlin.Unit.INSTANCE;
            }
            if (kotlinType2.isMarkedNullable()) {
                sb.append(com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING);
            }
            if (kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt.isDefinitelyNotNullType(kotlinType2)) {
                sb.append(" & Any");
            }
        }
        kotlinType2 = kotlinType;
        if (kotlinType2.isMarkedNullable()) {
            sb.append(com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING);
        }
        if (kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt.isDefinitelyNotNullType(kotlinType2)) {
            sb.append(" & Any");
        }
    }

    static /* synthetic */ void renderTypeConstructorAndArguments$default(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl descriptorRendererImpl, java.lang.StringBuilder sb, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            typeConstructor = kotlinType.getConstructor();
        }
        descriptorRendererImpl.renderTypeConstructorAndArguments(sb, kotlinType, typeConstructor);
    }

    private final void renderTypeConstructorAndArguments(java.lang.StringBuilder sb, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor) {
        kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType possiblyInnerTypeBuildPossiblyInnerType = kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt.buildPossiblyInnerType(kotlinType);
        if (possiblyInnerTypeBuildPossiblyInnerType == null) {
            sb.append(renderTypeConstructor(typeConstructor));
            sb.append(renderTypeArguments(kotlinType.getArguments()));
        } else {
            renderPossiblyInnerType(sb, possiblyInnerTypeBuildPossiblyInnerType);
        }
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0025  */
    private final void renderPossiblyInnerType(java.lang.StringBuilder sb, kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType possiblyInnerType) {
        kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType outerType = possiblyInnerType.getOuterType();
        if (outerType != null) {
            renderPossiblyInnerType(sb, outerType);
            sb.append(com.taobao.weex.el.parse.Operators.DOT);
            kotlin.reflect.jvm.internal.impl.name.Name name = possiblyInnerType.getClassifierDescriptor().getName();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            sb.append(renderName(name, false));
            if (sb == null) {
                kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor = possiblyInnerType.getClassifierDescriptor().getTypeConstructor();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeConstructor, "getTypeConstructor(...)");
                sb.append(renderTypeConstructor(typeConstructor));
            }
        } else {
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor2 = possiblyInnerType.getClassifierDescriptor().getTypeConstructor();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeConstructor2, "getTypeConstructor(...)");
            sb.append(renderTypeConstructor(typeConstructor2));
        }
        sb.append(renderTypeArguments(possiblyInnerType.getArguments()));
    }

    public java.lang.String renderTypeConstructor(kotlin.reflect.jvm.internal.impl.types.TypeConstructor typeConstructor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeConstructor, "typeConstructor");
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = typeConstructor.mo1835getDeclarationDescriptor();
        if ((classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) || (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) || (classifierDescriptorMo1835getDeclarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor)) {
            return renderClassifierName(classifierDescriptorMo1835getDeclarationDescriptor);
        }
        if (classifierDescriptorMo1835getDeclarationDescriptor == null) {
            if (typeConstructor instanceof kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) {
                return ((kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor) typeConstructor).makeDebugNameForIntersectionType(new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$$Lambda$1
                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: invoke */
                    public java.lang.Object invoke2(java.lang.Object obj) {
                        return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.renderTypeConstructor$lambda$8((kotlin.reflect.jvm.internal.impl.types.KotlinType) obj);
                    }
                });
            }
            return typeConstructor.toString();
        }
        throw new java.lang.IllegalStateException(("Unexpected classifier: " + classifierDescriptorMo1835getDeclarationDescriptor.getClass()).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Object renderTypeConstructor$lambda$8(kotlin.reflect.jvm.internal.impl.types.KotlinType it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return it instanceof kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference ? ((kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference) it).getOriginalTypeVariable() : it;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public java.lang.String renderTypeProjection(kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeProjection, "typeProjection");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        appendTypeProjections(sb, kotlin.collections.CollectionsKt.listOf(typeProjection));
        return sb.toString();
    }

    private final void appendTypeProjections(java.lang.StringBuilder sb, java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> list) {
        kotlin.collections.CollectionsKt.joinTo(list, sb, (112 & 2) != 0 ? ", " : ", ", (112 & 4) != 0 ? "" : null, (112 & 8) != 0 ? "" : null, (112 & 16) != 0 ? -1 : 0, (112 & 32) != 0 ? "..." : null, (112 & 64) != 0 ? null : new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$$Lambda$2
            private final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.appendTypeProjections$lambda$10(this.arg$0, (kotlin.reflect.jvm.internal.impl.types.TypeProjection) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.CharSequence appendTypeProjections$lambda$10(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl descriptorRendererImpl, kotlin.reflect.jvm.internal.impl.types.TypeProjection it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        if (it.isStarProjection()) {
            return "*";
        }
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = it.getType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        java.lang.String strRenderType = descriptorRendererImpl.renderType(type);
        if (it.getProjectionKind() != kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT) {
            strRenderType = it.getProjectionKind() + ' ' + strRenderType;
        }
        return strRenderType;
    }

    private final void renderFunctionType(java.lang.StringBuilder sb, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.reflect.jvm.internal.impl.name.Name nameExtractParameterNameFromFunctionTypeArgument;
        int length = sb.length();
        renderAnnotations$default(getFunctionTypeAnnotationsRenderer(), sb, kotlinType, null, 2, null);
        boolean z = sb.length() != length;
        kotlin.reflect.jvm.internal.impl.types.KotlinType receiverTypeFromFunctionType = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.getReceiverTypeFromFunctionType(kotlinType);
        java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> contextReceiverTypesFromFunctionType = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.getContextReceiverTypesFromFunctionType(kotlinType);
        boolean zIsSuspendFunctionType = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.isSuspendFunctionType(kotlinType);
        boolean zIsMarkedNullable = kotlinType.isMarkedNullable();
        boolean z2 = zIsMarkedNullable || (z && receiverTypeFromFunctionType != null);
        if (z2) {
            if (zIsSuspendFunctionType) {
                sb.insert(length, com.taobao.weex.el.parse.Operators.BRACKET_START);
            } else {
                if (z) {
                    java.lang.StringBuilder sb2 = sb;
                    kotlin.text.CharsKt.isWhitespace(kotlin.text.StringsKt.last(sb2));
                    if (sb.charAt(kotlin.text.StringsKt.getLastIndex(sb2) - 1) != ')') {
                        sb.insert(kotlin.text.StringsKt.getLastIndex(sb2), "()");
                    }
                }
                sb.append(com.taobao.weex.el.parse.Operators.BRACKET_START_STR);
            }
        }
        renderModifier(sb, zIsSuspendFunctionType, "suspend");
        if (!contextReceiverTypesFromFunctionType.isEmpty()) {
            sb.append("context(");
            java.util.Iterator<kotlin.reflect.jvm.internal.impl.types.KotlinType> it = contextReceiverTypesFromFunctionType.subList(0, kotlin.collections.CollectionsKt.getLastIndex(contextReceiverTypesFromFunctionType)).iterator();
            while (it.hasNext()) {
                renderNormalizedType(sb, it.next());
                sb.append(", ");
            }
            renderNormalizedType(sb, (kotlin.reflect.jvm.internal.impl.types.KotlinType) kotlin.collections.CollectionsKt.last((java.util.List) contextReceiverTypesFromFunctionType));
            sb.append(") ");
        }
        if (receiverTypeFromFunctionType != null) {
            boolean z3 = (shouldRenderAsPrettyFunctionType(receiverTypeFromFunctionType) && !receiverTypeFromFunctionType.isMarkedNullable()) || hasModifiersOrAnnotations(receiverTypeFromFunctionType) || (receiverTypeFromFunctionType instanceof kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType);
            if (z3) {
                sb.append(com.taobao.weex.el.parse.Operators.BRACKET_START_STR);
            }
            renderNormalizedType(sb, receiverTypeFromFunctionType);
            if (z3) {
                sb.append(com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
            }
            sb.append(com.taobao.weex.el.parse.Operators.DOT_STR);
        }
        sb.append(com.taobao.weex.el.parse.Operators.BRACKET_START_STR);
        if (kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.isBuiltinExtensionFunctionalType(kotlinType) && kotlinType.getArguments().size() <= 1) {
            sb.append("???");
        } else {
            int i = 0;
            for (kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection : kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.getValueParameterTypesFromFunctionType(kotlinType)) {
                int i2 = i + 1;
                if (i > 0) {
                    sb.append(", ");
                }
                if (getParameterNamesInFunctionalTypes()) {
                    kotlin.reflect.jvm.internal.impl.types.KotlinType type = typeProjection.getType();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                    nameExtractParameterNameFromFunctionTypeArgument = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type);
                } else {
                    nameExtractParameterNameFromFunctionTypeArgument = null;
                }
                if (nameExtractParameterNameFromFunctionTypeArgument != null) {
                    sb.append(renderName(nameExtractParameterNameFromFunctionTypeArgument, false));
                    sb.append(": ");
                }
                sb.append(renderTypeProjection(typeProjection));
                i = i2;
            }
        }
        sb.append(") ");
        sb.append(arrow());
        sb.append(com.taobao.weex.el.parse.Operators.SPACE_STR);
        renderNormalizedType(sb, kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.getReturnTypeFromFunctionType(kotlinType));
        if (z2) {
            sb.append(com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
        }
        if (zIsMarkedNullable) {
            sb.append(com.taobao.weex.el.parse.Operators.CONDITION_IF_STRING);
        }
    }

    private final boolean hasModifiersOrAnnotations(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        return kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.isSuspendFunctionType(kotlinType) || !kotlinType.getAnnotations().isEmpty();
    }

    private final void appendDefinedIn(java.lang.StringBuilder sb, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration;
        java.lang.String name;
        if ((declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) || (declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor) || (containingDeclaration = declarationDescriptor.getContainingDeclaration()) == null || (containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor)) {
            return;
        }
        sb.append(com.taobao.weex.el.parse.Operators.SPACE_STR);
        sb.append(renderMessage("defined in"));
        sb.append(com.taobao.weex.el.parse.Operators.SPACE_STR);
        kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqName = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getFqName(containingDeclaration);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(fqName, "getFqName(...)");
        sb.append(fqName.isRoot() ? "root package" : renderFqName(fqName));
        if (getWithSourceFileForTopLevel() && (containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) && (declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource) && (name = ((kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource) declarationDescriptor).getSource().getContainingFile().getName()) != null) {
            sb.append(com.taobao.weex.el.parse.Operators.SPACE_STR);
            sb.append(renderMessage("in file"));
            sb.append(com.taobao.weex.el.parse.Operators.SPACE_STR);
            sb.append(name);
        }
    }

    static /* synthetic */ void renderAnnotations$default(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl descriptorRendererImpl, java.lang.StringBuilder sb, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated annotated, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget annotationUseSiteTarget, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        descriptorRendererImpl.renderAnnotations(sb, annotated, annotationUseSiteTarget);
    }

    private final void renderAnnotations(java.lang.StringBuilder sb, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated annotated, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget annotationUseSiteTarget) {
        if (getModifiers().contains(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier.ANNOTATIONS)) {
            java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> excludedTypeAnnotationClasses = annotated instanceof kotlin.reflect.jvm.internal.impl.types.KotlinType ? getExcludedTypeAnnotationClasses() : getExcludedAnnotationClasses();
            kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor, java.lang.Boolean> annotationFilter = getAnnotationFilter();
            for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotationDescriptor : annotated.getAnnotations()) {
                if (!kotlin.collections.CollectionsKt.contains(excludedTypeAnnotationClasses, annotationDescriptor.getFqName()) && !isParameterName(annotationDescriptor) && (annotationFilter == null || annotationFilter.invoke2(annotationDescriptor).booleanValue())) {
                    sb.append(renderAnnotation(annotationDescriptor, annotationUseSiteTarget));
                    if (getEachAnnotationOnNewLine()) {
                        sb.append('\n');
                    } else {
                        sb.append(com.taobao.weex.el.parse.Operators.SPACE_STR);
                    }
                }
            }
        }
    }

    private final boolean isParameterName(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotationDescriptor) {
        return kotlin.jvm.internal.Intrinsics.areEqual(annotationDescriptor.getFqName(), kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.parameterName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public java.lang.String renderAnnotation(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotation, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget annotationUseSiteTarget) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotation, "annotation");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.taobao.weex.ui.component.list.template.TemplateDom.SEPARATOR);
        if (annotationUseSiteTarget != null) {
            sb.append(annotationUseSiteTarget.getRenderName() + com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE);
        }
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = annotation.getType();
        sb.append(renderType(type));
        if (getIncludeAnnotationArguments()) {
            java.util.List<java.lang.String> listRenderAndSortAnnotationArguments = renderAndSortAnnotationArguments(annotation);
            if (getIncludeEmptyAnnotationArguments() || !listRenderAndSortAnnotationArguments.isEmpty()) {
                kotlin.collections.CollectionsKt.joinTo(listRenderAndSortAnnotationArguments, sb, (112 & 2) != 0 ? ", " : ", ", (112 & 4) != 0 ? "" : com.taobao.weex.el.parse.Operators.BRACKET_START_STR, (112 & 8) != 0 ? "" : com.taobao.weex.el.parse.Operators.BRACKET_END_STR, (112 & 16) != 0 ? -1 : 0, (112 & 32) != 0 ? "..." : null, (112 & 64) != 0 ? null : null);
            }
        }
        if (getVerbose() && (kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(type) || (type.getConstructor().mo1835getDeclarationDescriptor() instanceof kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor))) {
            sb.append(" /* annotation class not found */");
        }
        return sb.toString();
    }

    private final java.util.List<java.lang.String> renderAndSortAnnotationArguments(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotationDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor classConstructorDescriptorMo1825getUnsubstitutedPrimaryConstructor;
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters;
        java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> allValueArguments = annotationDescriptor.getAllValueArguments();
        java.util.ArrayList arrayListEmptyList = null;
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor annotationClass = getRenderDefaultAnnotationArguments() ? kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getAnnotationClass(annotationDescriptor) : null;
        if (annotationClass != null && (classConstructorDescriptorMo1825getUnsubstitutedPrimaryConstructor = annotationClass.mo1825getUnsubstitutedPrimaryConstructor()) != null && (valueParameters = classConstructorDescriptorMo1825getUnsubstitutedPrimaryConstructor.getValueParameters()) != null) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.Object obj : valueParameters) {
                if (((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) obj).declaresDefaultValue()) {
                    arrayList.add(obj);
                }
            }
            java.util.ArrayList arrayList2 = arrayList;
            java.util.ArrayList arrayList3 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            java.util.Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) it.next()).getName());
            }
            arrayListEmptyList = arrayList3;
        }
        if (arrayListEmptyList == null) {
            arrayListEmptyList = kotlin.collections.CollectionsKt.emptyList();
        }
        java.util.ArrayList arrayList4 = new java.util.ArrayList();
        for (java.lang.Object obj2 : arrayListEmptyList) {
            if (!allValueArguments.containsKey((kotlin.reflect.jvm.internal.impl.name.Name) obj2)) {
                arrayList4.add(obj2);
            }
        }
        java.util.ArrayList arrayList5 = arrayList4;
        java.util.ArrayList arrayList6 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        java.util.Iterator it2 = arrayList5.iterator();
        while (it2.hasNext()) {
            arrayList6.add(((kotlin.reflect.jvm.internal.impl.name.Name) it2.next()).asString() + " = ...");
        }
        java.util.ArrayList arrayList7 = arrayList6;
        java.util.Set<java.util.Map.Entry<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>>> setEntrySet = allValueArguments.entrySet();
        java.util.ArrayList arrayList8 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(setEntrySet, 10));
        java.util.Iterator<T> it3 = setEntrySet.iterator();
        while (it3.hasNext()) {
            java.util.Map.Entry entry = (java.util.Map.Entry) it3.next();
            kotlin.reflect.jvm.internal.impl.name.Name name = (kotlin.reflect.jvm.internal.impl.name.Name) entry.getKey();
            kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> constantValue = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) entry.getValue();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(name.asString());
            sb.append(" = ");
            sb.append(!arrayListEmptyList.contains(name) ? renderConstant(constantValue) : "...");
            arrayList8.add(sb.toString());
        }
        return kotlin.collections.CollectionsKt.sorted(kotlin.collections.CollectionsKt.plus((java.util.Collection) arrayList7, (java.lang.Iterable) arrayList8));
    }

    private final java.lang.String renderConstant(kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> constantValue) {
        kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>, java.lang.String> propertyConstantRenderer = this.options.getPropertyConstantRenderer();
        if (propertyConstantRenderer != null) {
            return propertyConstantRenderer.invoke2(constantValue);
        }
        if (!(constantValue instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue)) {
            if (constantValue instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue) {
                return kotlin.text.StringsKt.removePrefix(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.renderAnnotation$default(this, ((kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue) constantValue).getValue(), null, 2, null), (java.lang.CharSequence) "@");
            }
            if (constantValue instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue) {
                kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value value = ((kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue) constantValue).getValue();
                if (value instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.LocalClass) {
                    return ((kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.LocalClass) value).getType() + "::class";
                }
                if (!(value instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass)) {
                    throw new kotlin.NoWhenBranchMatchedException();
                }
                kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass normalClass = (kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass) value;
                java.lang.String strAsString = normalClass.getClassId().asSingleFqName().asString();
                int arrayDimensions = normalClass.getArrayDimensions();
                for (int i = 0; i < arrayDimensions; i++) {
                    strAsString = "kotlin.Array<" + strAsString + kotlin.text.Typography.greater;
                }
                return strAsString + "::class";
            }
            return constantValue.toString();
        }
        java.util.List<? extends kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> value2 = ((kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue) constantValue).getValue();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<T> it = value2.iterator();
        while (it.hasNext()) {
            java.lang.String strRenderConstant = renderConstant((kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) it.next());
            if (strRenderConstant != null) {
                arrayList.add(strRenderConstant);
            }
        }
        return kotlin.collections.CollectionsKt.joinToString$default(arrayList, ", ", com.taobao.weex.el.parse.Operators.BLOCK_START_STR, com.taobao.weex.el.parse.Operators.BLOCK_END_STR, 0, null, null, 56, null);
    }

    private final boolean renderVisibility(kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility, java.lang.StringBuilder sb) {
        if (!getModifiers().contains(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier.VISIBILITY)) {
            return false;
        }
        if (getNormalizedVisibilities()) {
            descriptorVisibility = descriptorVisibility.normalize();
        }
        if (!getRenderDefaultVisibility() && kotlin.jvm.internal.Intrinsics.areEqual(descriptorVisibility, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.DEFAULT_VISIBILITY)) {
            return false;
        }
        sb.append(renderKeyword(descriptorVisibility.getInternalDisplayName()));
        sb.append(com.taobao.weex.el.parse.Operators.SPACE_STR);
        return true;
    }

    private final void renderModality(kotlin.reflect.jvm.internal.impl.descriptors.Modality modality, java.lang.StringBuilder sb, kotlin.reflect.jvm.internal.impl.descriptors.Modality modality2) {
        if (getRenderDefaultModality() || modality != modality2) {
            renderModifier(sb, getModifiers().contains(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier.MODALITY), kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(modality.name()));
        }
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.Modality implicitModalityWithoutExtensions(kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor memberDescriptor) {
        if (memberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
            return ((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) memberDescriptor).getKind() == kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE ? kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT : kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = memberDescriptor.getContainingDeclaration();
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration : null;
        if (classDescriptor != null && (memberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor)) {
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) memberDescriptor;
            java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
            if (!overriddenDescriptors.isEmpty() && classDescriptor.getModality() != kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL) {
                return kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN;
            }
            if (classDescriptor.getKind() != kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE || kotlin.jvm.internal.Intrinsics.areEqual(callableMemberDescriptor.getVisibility(), kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PRIVATE)) {
                return kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL;
            }
            return callableMemberDescriptor.getModality() == kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT ? kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT : kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN;
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL;
    }

    private final void renderModalityForCallable(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor, java.lang.StringBuilder sb) {
        if (kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isTopLevelDeclaration(callableMemberDescriptor) && callableMemberDescriptor.getModality() == kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL) {
            return;
        }
        if (getOverrideRenderingPolicy() == kotlin.reflect.jvm.internal.impl.renderer.OverrideRenderingPolicy.RENDER_OVERRIDE && callableMemberDescriptor.getModality() == kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN && overridesSomething(callableMemberDescriptor)) {
            return;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.Modality modality = callableMemberDescriptor.getModality();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(modality, "getModality(...)");
        renderModality(modality, sb, implicitModalityWithoutExtensions(callableMemberDescriptor));
    }

    private final void renderOverride(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor, java.lang.StringBuilder sb) {
        if (getModifiers().contains(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier.OVERRIDE) && overridesSomething(callableMemberDescriptor) && getOverrideRenderingPolicy() != kotlin.reflect.jvm.internal.impl.renderer.OverrideRenderingPolicy.RENDER_OPEN) {
            renderModifier(sb, true, "override");
            if (getVerbose()) {
                sb.append("/*");
                sb.append(callableMemberDescriptor.getOverriddenDescriptors().size());
                sb.append("*/ ");
            }
        }
    }

    private final void renderMemberKind(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor, java.lang.StringBuilder sb) {
        if (getModifiers().contains(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier.MEMBER_KIND) && getVerbose() && callableMemberDescriptor.getKind() != kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION) {
            sb.append("/*");
            sb.append(kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(callableMemberDescriptor.getKind().name()));
            sb.append("*/ ");
        }
    }

    private final void renderModifier(java.lang.StringBuilder sb, boolean z, java.lang.String str) {
        if (z) {
            sb.append(renderKeyword(str));
            sb.append(com.taobao.weex.el.parse.Operators.SPACE_STR);
        }
    }

    private final void renderMemberModifiers(kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor memberDescriptor, java.lang.StringBuilder sb) {
        renderModifier(sb, memberDescriptor.isExternal(), "external");
        renderModifier(sb, getModifiers().contains(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier.EXPECT) && memberDescriptor.isExpect(), "expect");
        renderModifier(sb, getModifiers().contains(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier.ACTUAL) && memberDescriptor.isActual(), "actual");
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003b  */
    /* JADX WARN: Code duplicated, block: B:29:0x0072 A[EDGE_INSN: B:29:0x0072->B:30:0x0073 BREAK  A[LOOP:1: B:22:0x0059->B:37:?]] */
    private final void renderAdditionalModifiers(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor, java.lang.StringBuilder sb) {
        boolean z;
        boolean z2 = true;
        if (functionDescriptor.isOperator()) {
            java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> overriddenDescriptors = functionDescriptor.getOverriddenDescriptors();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
            java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> collection = overriddenDescriptors;
            if (!collection.isEmpty()) {
                java.util.Iterator<T> it = collection.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) it.next()).isOperator()) {
                            if (!getAlwaysRenderModifiers()) {
                                z = false;
                            }
                        }
                    }
                }
            }
            z = true;
        } else {
            z = false;
        }
        if (!functionDescriptor.isInfix()) {
            z2 = false;
            break;
        }
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> overriddenDescriptors2 = functionDescriptor.getOverriddenDescriptors();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(overriddenDescriptors2, "getOverriddenDescriptors(...)");
        java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> collection2 = overriddenDescriptors2;
        if (!collection2.isEmpty()) {
            java.util.Iterator<T> it2 = collection2.iterator();
            while (it2.hasNext()) {
                if (((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) it2.next()).isInfix()) {
                    if (!getAlwaysRenderModifiers()) {
                        z2 = false;
                        break;
                    }
                    break;
                }
            }
        }
        renderModifier(sb, functionDescriptor.isTailrec(), "tailrec");
        renderSuspendModifier(functionDescriptor, sb);
        renderModifier(sb, functionDescriptor.isInline(), io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_INLINE);
        renderModifier(sb, z2, "infix");
        renderModifier(sb, z, "operator");
    }

    private final void renderSuspendModifier(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor, java.lang.StringBuilder sb) {
        renderModifier(sb, functionDescriptor.isSuspend(), "suspend");
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    public java.lang.String render(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(declarationDescriptor, "declarationDescriptor");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        declarationDescriptor.accept(new kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.RenderDeclarationDescriptorVisitor(), sb);
        if (getWithDefinedIn()) {
            appendDefinedIn(sb, declarationDescriptor);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderTypeParameter(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor, java.lang.StringBuilder sb, boolean z) {
        if (z) {
            sb.append(lt());
        }
        if (getVerbose()) {
            sb.append("/*");
            sb.append(typeParameterDescriptor.getIndex());
            sb.append("*/ ");
        }
        renderModifier(sb, typeParameterDescriptor.isReified(), "reified");
        java.lang.String label = typeParameterDescriptor.getVariance().getLabel();
        boolean z2 = true;
        renderModifier(sb, label.length() > 0, label);
        renderAnnotations$default(this, sb, typeParameterDescriptor, null, 2, null);
        renderName(typeParameterDescriptor, sb, z);
        int size = typeParameterDescriptor.getUpperBounds().size();
        if ((size > 1 && !z) || size == 1) {
            kotlin.reflect.jvm.internal.impl.types.KotlinType next = typeParameterDescriptor.getUpperBounds().iterator().next();
            if (!kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isDefaultBound(next)) {
                sb.append(" : ");
                kotlin.jvm.internal.Intrinsics.checkNotNull(next);
                sb.append(renderType(next));
            }
        } else if (z) {
            for (kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType : typeParameterDescriptor.getUpperBounds()) {
                if (!kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isDefaultBound(kotlinType)) {
                    if (z2) {
                        sb.append(" : ");
                    } else {
                        sb.append(" & ");
                    }
                    kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinType);
                    sb.append(renderType(kotlinType));
                    z2 = false;
                }
            }
        }
        if (z) {
            sb.append(gt());
        }
    }

    private final void renderTypeParameters(java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list, java.lang.StringBuilder sb, boolean z) {
        if (getWithoutTypeParameters() || list.isEmpty()) {
            return;
        }
        sb.append(lt());
        renderTypeParameterList(sb, list);
        sb.append(gt());
        if (z) {
            sb.append(com.taobao.weex.el.parse.Operators.SPACE_STR);
        }
    }

    private final void renderTypeParameterList(java.lang.StringBuilder sb, java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list) {
        java.util.Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> it = list.iterator();
        while (it.hasNext()) {
            renderTypeParameter(it.next(), sb, false);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderFunction(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor, java.lang.StringBuilder sb) {
        java.lang.StringBuilder sb2;
        if (getStartFromName()) {
            sb2 = sb;
        } else {
            if (getStartFromDeclarationKeyword()) {
                sb2 = sb;
            } else {
                java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> contextReceiverParameters = functionDescriptor.getContextReceiverParameters();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "getContextReceiverParameters(...)");
                renderContextReceivers(contextReceiverParameters, sb);
                sb2 = sb;
                renderAnnotations$default(this, sb2, functionDescriptor, null, 2, null);
                kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibility = functionDescriptor.getVisibility();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
                renderVisibility(visibility, sb2);
                kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor2 = functionDescriptor;
                renderModalityForCallable(functionDescriptor2, sb2);
                if (getIncludeAdditionalModifiers()) {
                    renderMemberModifiers(functionDescriptor, sb2);
                }
                renderOverride(functionDescriptor2, sb2);
                if (getIncludeAdditionalModifiers()) {
                    renderAdditionalModifiers(functionDescriptor, sb2);
                } else {
                    renderSuspendModifier(functionDescriptor, sb2);
                }
                renderMemberKind(functionDescriptor2, sb2);
                if (getVerbose()) {
                    if (functionDescriptor.isHiddenToOvercomeSignatureClash()) {
                        sb2.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (functionDescriptor.isHiddenForResolutionEverywhereBesideSupercalls()) {
                        sb2.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            sb2.append(renderKeyword("fun"));
            sb2.append(com.taobao.weex.el.parse.Operators.SPACE_STR);
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters = functionDescriptor.getTypeParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
            renderTypeParameters(typeParameters, sb2, true);
            renderReceiver(functionDescriptor, sb2);
        }
        renderName(functionDescriptor, sb2, true);
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        renderValueParameters(valueParameters, functionDescriptor.hasSynthesizedParameterNames(), sb2);
        renderReceiverAfterName(functionDescriptor, sb2);
        kotlin.reflect.jvm.internal.impl.types.KotlinType returnType = functionDescriptor.getReturnType();
        if (!getWithoutReturnType() && (getUnitReturnType() || returnType == null || !kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isUnit(returnType))) {
            sb2.append(": ");
            sb2.append(returnType == null ? "[NULL]" : renderType(returnType));
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters2 = functionDescriptor.getTypeParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameters2, "getTypeParameters(...)");
        renderWhereSuffix(typeParameters2, sb2);
    }

    private final void renderReceiverAfterName(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor, java.lang.StringBuilder sb) {
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor extensionReceiverParameter;
        if (getReceiverAfterName() && (extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter()) != null) {
            sb.append(" on ");
            kotlin.reflect.jvm.internal.impl.types.KotlinType type = extensionReceiverParameter.getType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            sb.append(renderType(type));
        }
    }

    private final java.lang.String renderForReceiver(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        java.lang.String strRenderType = renderType(kotlinType);
        if ((!shouldRenderAsPrettyFunctionType(kotlinType) || kotlin.reflect.jvm.internal.impl.types.TypeUtils.isNullableType(kotlinType)) && !(kotlinType instanceof kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType)) {
            return strRenderType;
        }
        return com.taobao.weex.el.parse.Operators.BRACKET_START_STR + strRenderType + com.taobao.weex.el.parse.Operators.BRACKET_END;
    }

    private final void renderContextReceivers(java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> list, java.lang.StringBuilder sb) {
        if (list.isEmpty()) {
            return;
        }
        sb.append("context(");
        int i = 0;
        for (kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor : list) {
            int i2 = i + 1;
            renderAnnotations(sb, receiverParameterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget.RECEIVER);
            kotlin.reflect.jvm.internal.impl.types.KotlinType type = receiverParameterDescriptor.getType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            sb.append(renderForReceiver(type));
            if (i == kotlin.collections.CollectionsKt.getLastIndex(list)) {
                sb.append(") ");
            } else {
                sb.append(", ");
            }
            i = i2;
        }
    }

    private final void renderReceiver(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor callableDescriptor, java.lang.StringBuilder sb) {
        kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            renderAnnotations(sb, extensionReceiverParameter, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget.RECEIVER);
            kotlin.reflect.jvm.internal.impl.types.KotlinType type = extensionReceiverParameter.getType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            sb.append(renderForReceiver(type));
            sb.append(com.taobao.weex.el.parse.Operators.DOT_STR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:9:0x0035  */
    public final void renderConstructor(kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor constructorDescriptor, java.lang.StringBuilder sb) {
        boolean z;
        kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor classConstructorDescriptorMo1825getUnsubstitutedPrimaryConstructor;
        renderAnnotations$default(this, sb, constructorDescriptor, null, 2, null);
        if (this.options.getRenderDefaultVisibility() || constructorDescriptor.getConstructedClass().getModality() != kotlin.reflect.jvm.internal.impl.descriptors.Modality.SEALED) {
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibility = constructorDescriptor.getVisibility();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
            if (renderVisibility(visibility, sb)) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        renderMemberKind(constructorDescriptor, sb);
        boolean z2 = getRenderConstructorKeyword() || !constructorDescriptor.isPrimary() || z;
        if (z2) {
            sb.append(renderKeyword("constructor"));
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters containingDeclaration = constructorDescriptor.getContainingDeclaration();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
        if (getSecondaryConstructorsAsPrimary()) {
            if (z2) {
                sb.append(com.taobao.weex.el.parse.Operators.SPACE_STR);
            }
            renderName(containingDeclaration, sb, true);
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters = constructorDescriptor.getTypeParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
            renderTypeParameters(typeParameters, sb, false);
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = constructorDescriptor.getValueParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
        renderValueParameters(valueParameters, constructorDescriptor.hasSynthesizedParameterNames(), sb);
        if (getRenderConstructorDelegation() && !constructorDescriptor.isPrimary() && (containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) && (classConstructorDescriptorMo1825getUnsubstitutedPrimaryConstructor = ((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) containingDeclaration).mo1825getUnsubstitutedPrimaryConstructor()) != null) {
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters2 = classConstructorDescriptorMo1825getUnsubstitutedPrimaryConstructor.getValueParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters2, "getValueParameters(...)");
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (java.lang.Object obj : valueParameters2) {
                kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) obj;
                if (!valueParameterDescriptor.declaresDefaultValue() && valueParameterDescriptor.getVarargElementType() == null) {
                    arrayList.add(obj);
                }
            }
            java.util.ArrayList arrayList2 = arrayList;
            if (!arrayList2.isEmpty()) {
                sb.append(" : ");
                sb.append(renderKeyword("this"));
                sb.append(kotlin.collections.CollectionsKt.joinToString$default(arrayList2, ", ", com.taobao.weex.el.parse.Operators.BRACKET_START_STR, com.taobao.weex.el.parse.Operators.BRACKET_END_STR, 0, null, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$$Lambda$3
                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: invoke */
                    public java.lang.Object invoke2(java.lang.Object obj2) {
                        return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.renderConstructor$lambda$26((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) obj2);
                    }
                }, 24, null));
            }
        }
        if (getSecondaryConstructorsAsPrimary()) {
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters2 = constructorDescriptor.getTypeParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameters2, "getTypeParameters(...)");
            renderWhereSuffix(typeParameters2, sb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.CharSequence renderConstructor$lambda$26(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor) {
        return "";
    }

    private final void renderWhereSuffix(java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> list, java.lang.StringBuilder sb) {
        if (getWithoutTypeParameters()) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(0);
        for (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor : list) {
            java.util.List<kotlin.reflect.jvm.internal.impl.types.KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperBounds, "getUpperBounds(...)");
            for (kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType : kotlin.collections.CollectionsKt.drop(upperBounds, 1)) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                kotlin.reflect.jvm.internal.impl.name.Name name = typeParameterDescriptor.getName();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                sb2.append(renderName(name, false));
                sb2.append(" : ");
                kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinType);
                sb2.append(renderType(kotlinType));
                arrayList.add(sb2.toString());
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        sb.append(com.taobao.weex.el.parse.Operators.SPACE_STR);
        sb.append(renderKeyword("where"));
        sb.append(com.taobao.weex.el.parse.Operators.SPACE_STR);
        kotlin.collections.CollectionsKt.joinTo(arrayList, sb, (112 & 2) != 0 ? ", " : ", ", (112 & 4) != 0 ? "" : null, (112 & 8) != 0 ? "" : null, (112 & 16) != 0 ? -1 : 0, (112 & 32) != 0 ? "..." : null, (112 & 64) != 0 ? null : null);
    }

    private final void renderValueParameters(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> collection, boolean z, java.lang.StringBuilder sb) {
        boolean zShouldRenderParameterNames = shouldRenderParameterNames(z);
        int size = collection.size();
        getValueParametersHandler().appendBeforeValueParameters(size, sb);
        int i = 0;
        for (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor : collection) {
            getValueParametersHandler().appendBeforeValueParameter(valueParameterDescriptor, i, size, sb);
            renderValueParameter(valueParameterDescriptor, zShouldRenderParameterNames, sb, false);
            getValueParametersHandler().appendAfterValueParameter(valueParameterDescriptor, i, size, sb);
            i++;
        }
        getValueParametersHandler().appendAfterValueParameters(size, sb);
    }

    private final boolean shouldRenderParameterNames(boolean z) {
        int i = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.WhenMappings.$EnumSwitchMapping$1[getParameterNameRenderingPolicy().ordinal()];
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return !z;
        }
        if (i == 3) {
            return false;
        }
        throw new kotlin.NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0061  */
    public final void renderValueParameter(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor, boolean z, java.lang.StringBuilder sb, boolean z2) {
        boolean z3;
        if (z2) {
            sb.append(renderKeyword("value-parameter"));
            sb.append(com.taobao.weex.el.parse.Operators.SPACE_STR);
        }
        if (getVerbose()) {
            sb.append("/*");
            sb.append(valueParameterDescriptor.getIndex());
            sb.append("*/ ");
        }
        renderAnnotations$default(this, sb, valueParameterDescriptor, null, 2, null);
        renderModifier(sb, valueParameterDescriptor.isCrossinline(), "crossinline");
        renderModifier(sb, valueParameterDescriptor.isNoinline(), "noinline");
        if (getRenderPrimaryConstructorParametersAsProperties()) {
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor containingDeclaration = valueParameterDescriptor.getContainingDeclaration();
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor classConstructorDescriptor = containingDeclaration instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor) containingDeclaration : null;
            if (classConstructorDescriptor == null || !classConstructorDescriptor.isPrimary()) {
                z3 = false;
            } else {
                z3 = true;
            }
        } else {
            z3 = false;
        }
        if (z3) {
            renderModifier(sb, getActualPropertiesInPrimaryConstructor(), "actual");
        }
        renderVariable(valueParameterDescriptor, z, sb, z2, z3);
        if (getDefaultParameterValueRenderer() != null) {
            if (getDebugMode() ? valueParameterDescriptor.declaresDefaultValue() : kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor)) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder(" = ");
                kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor, java.lang.String> defaultParameterValueRenderer = getDefaultParameterValueRenderer();
                kotlin.jvm.internal.Intrinsics.checkNotNull(defaultParameterValueRenderer);
                sb2.append(defaultParameterValueRenderer.invoke2(valueParameterDescriptor));
                sb.append(sb2.toString());
            }
        }
    }

    static /* synthetic */ void renderValVarPrefix$default(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl descriptorRendererImpl, kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor variableDescriptor, java.lang.StringBuilder sb, boolean z, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        descriptorRendererImpl.renderValVarPrefix(variableDescriptor, sb, z);
    }

    private final void renderValVarPrefix(kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor variableDescriptor, java.lang.StringBuilder sb, boolean z) {
        if (z || !(variableDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor)) {
            sb.append(renderKeyword(variableDescriptor.isVar() ? "var" : "val"));
            sb.append(com.taobao.weex.el.parse.Operators.SPACE_STR);
        }
    }

    private final void renderVariable(kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor variableDescriptor, boolean z, java.lang.StringBuilder sb, boolean z2, boolean z3) {
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = variableDescriptor.getType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor = variableDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor ? (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) variableDescriptor : null;
        kotlin.reflect.jvm.internal.impl.types.KotlinType varargElementType = valueParameterDescriptor != null ? valueParameterDescriptor.getVarargElementType() : null;
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType = varargElementType == null ? type : varargElementType;
        renderModifier(sb, varargElementType != null, "vararg");
        if (z3 || (z2 && !getStartFromName())) {
            renderValVarPrefix(variableDescriptor, sb, z3);
        }
        if (z) {
            renderName(variableDescriptor, sb, z2);
            sb.append(": ");
        }
        sb.append(renderType(kotlinType));
        renderInitializer(variableDescriptor, sb);
        if (!getVerbose() || varargElementType == null) {
            return;
        }
        sb.append(" /*");
        sb.append(renderType(type));
        sb.append("*/");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderProperty(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor, java.lang.StringBuilder sb) {
        java.lang.StringBuilder sb2;
        if (getStartFromName()) {
            sb2 = sb;
        } else {
            if (!getStartFromDeclarationKeyword()) {
                java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> contextReceiverParameters = propertyDescriptor.getContextReceiverParameters();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "getContextReceiverParameters(...)");
                renderContextReceivers(contextReceiverParameters, sb);
                renderPropertyAnnotations(propertyDescriptor, sb);
                kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibility = propertyDescriptor.getVisibility();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
                renderVisibility(visibility, sb);
                boolean z = false;
                renderModifier(sb, getModifiers().contains(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier.CONST) && propertyDescriptor.isConst(), "const");
                renderMemberModifiers(propertyDescriptor, sb);
                kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor2 = propertyDescriptor;
                renderModalityForCallable(propertyDescriptor2, sb);
                renderOverride(propertyDescriptor2, sb);
                if (getModifiers().contains(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier.LATEINIT) && propertyDescriptor.isLateInit()) {
                    z = true;
                }
                renderModifier(sb, z, "lateinit");
                renderMemberKind(propertyDescriptor2, sb);
            }
            sb2 = sb;
            renderValVarPrefix$default(this, propertyDescriptor, sb2, false, 4, null);
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters = propertyDescriptor.getTypeParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
            renderTypeParameters(typeParameters, sb2, true);
            renderReceiver(propertyDescriptor, sb2);
        }
        renderName(propertyDescriptor, sb2, true);
        sb2.append(": ");
        kotlin.reflect.jvm.internal.impl.types.KotlinType type = propertyDescriptor.getType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        sb2.append(renderType(type));
        renderReceiverAfterName(propertyDescriptor, sb2);
        renderInitializer(propertyDescriptor, sb2);
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> typeParameters2 = propertyDescriptor.getTypeParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameters2, "getTypeParameters(...)");
        renderWhereSuffix(typeParameters2, sb2);
    }

    private final void renderPropertyAnnotations(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor, java.lang.StringBuilder sb) {
        if (getModifiers().contains(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier.ANNOTATIONS)) {
            renderAnnotations$default(this, sb, propertyDescriptor, null, 2, null);
            kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor backingField = propertyDescriptor.getBackingField();
            if (backingField != null) {
                renderAnnotations(sb, backingField, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget.FIELD);
            }
            kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor delegateField = propertyDescriptor.getDelegateField();
            if (delegateField != null) {
                renderAnnotations(sb, delegateField, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
            }
            if (getPropertyAccessorRenderingPolicy() == kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy.NONE) {
                kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
                if (getter != null) {
                    renderAnnotations(sb, getter, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget.PROPERTY_GETTER);
                }
                kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor setter = propertyDescriptor.getSetter();
                if (setter != null) {
                    renderAnnotations(sb, setter, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget.PROPERTY_SETTER);
                    java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = setter.getValueParameters();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                    kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) kotlin.collections.CollectionsKt.single((java.util.List) valueParameters);
                    kotlin.jvm.internal.Intrinsics.checkNotNull(valueParameterDescriptor);
                    renderAnnotations(sb, valueParameterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget.SETTER_PARAMETER);
                }
            }
        }
    }

    private final void renderInitializer(kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor variableDescriptor, java.lang.StringBuilder sb) {
        kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> constantValueMo1827getCompileTimeInitializer;
        java.lang.String strRenderConstant;
        if (!getIncludePropertyConstant() || (constantValueMo1827getCompileTimeInitializer = variableDescriptor.mo1827getCompileTimeInitializer()) == null || (strRenderConstant = renderConstant(constantValueMo1827getCompileTimeInitializer)) == null) {
            return;
        }
        sb.append(" = ");
        sb.append(escape(strRenderConstant));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderTypeAlias(kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor typeAliasDescriptor, java.lang.StringBuilder sb) {
        renderAnnotations$default(this, sb, typeAliasDescriptor, null, 2, null);
        kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibility = typeAliasDescriptor.getVisibility();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
        renderVisibility(visibility, sb);
        renderMemberModifiers(typeAliasDescriptor, sb);
        sb.append(renderKeyword("typealias"));
        sb.append(com.taobao.weex.el.parse.Operators.SPACE_STR);
        renderName(typeAliasDescriptor, sb, true);
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> declaredTypeParameters = typeAliasDescriptor.getDeclaredTypeParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "getDeclaredTypeParameters(...)");
        renderTypeParameters(declaredTypeParameters, sb, false);
        renderCapturedTypeParametersIfRequired(typeAliasDescriptor, sb);
        sb.append(" = ");
        sb.append(renderType(typeAliasDescriptor.getUnderlyingType()));
    }

    private final void renderCapturedTypeParametersIfRequired(kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, java.lang.StringBuilder sb) {
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "getDeclaredTypeParameters(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> parameters = classifierDescriptorWithTypeParameters.getTypeConstructor().getParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
        if (getVerbose() && classifierDescriptorWithTypeParameters.isInner() && parameters.size() > declaredTypeParameters.size()) {
            sb.append(" /*captured type parameters: ");
            renderTypeParameterList(sb, parameters.subList(declaredTypeParameters.size(), parameters.size()));
            sb.append("*/");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderClass(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, java.lang.StringBuilder sb) {
        kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor classConstructorDescriptorMo1825getUnsubstitutedPrimaryConstructor;
        boolean z = classDescriptor.getKind() == kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_ENTRY;
        if (!getStartFromName()) {
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor> contextReceivers = classDescriptor.getContextReceivers();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(contextReceivers, "getContextReceivers(...)");
            renderContextReceivers(contextReceivers, sb);
            renderAnnotations$default(this, sb, classDescriptor, null, 2, null);
            if (!z) {
                kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibility = classDescriptor.getVisibility();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(visibility, "getVisibility(...)");
                renderVisibility(visibility, sb);
            }
            if ((classDescriptor.getKind() != kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE || classDescriptor.getModality() != kotlin.reflect.jvm.internal.impl.descriptors.Modality.ABSTRACT) && (!classDescriptor.getKind().isSingleton() || classDescriptor.getModality() != kotlin.reflect.jvm.internal.impl.descriptors.Modality.FINAL)) {
                kotlin.reflect.jvm.internal.impl.descriptors.Modality modality = classDescriptor.getModality();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(modality, "getModality(...)");
                renderModality(modality, sb, implicitModalityWithoutExtensions(classDescriptor));
            }
            renderMemberModifiers(classDescriptor, sb);
            renderModifier(sb, getModifiers().contains(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier.INNER) && classDescriptor.isInner(), "inner");
            renderModifier(sb, getModifiers().contains(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier.DATA) && classDescriptor.isData(), "data");
            renderModifier(sb, getModifiers().contains(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier.INLINE) && classDescriptor.isInline(), io.dcloud.common.constant.AbsoluteConst.JSON_VALUE_INLINE);
            renderModifier(sb, getModifiers().contains(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier.VALUE) && classDescriptor.isValue(), "value");
            renderModifier(sb, getModifiers().contains(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier.FUN) && classDescriptor.isFun(), "fun");
            renderClassKindPrefix(classDescriptor, sb);
        }
        kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor2 = classDescriptor;
        if (!kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isCompanionObject(classDescriptor2)) {
            if (!getStartFromName()) {
                renderSpaceIfNeeded(sb);
            }
            renderName(classDescriptor2, sb, true);
        } else {
            renderCompanionObjectName(classDescriptor2, sb);
        }
        if (z) {
            return;
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "getDeclaredTypeParameters(...)");
        renderTypeParameters(declaredTypeParameters, sb, false);
        renderCapturedTypeParametersIfRequired(classDescriptor, sb);
        if (!classDescriptor.getKind().isSingleton() && getClassWithPrimaryConstructor() && (classConstructorDescriptorMo1825getUnsubstitutedPrimaryConstructor = classDescriptor.mo1825getUnsubstitutedPrimaryConstructor()) != null) {
            sb.append(com.taobao.weex.el.parse.Operators.SPACE_STR);
            renderAnnotations$default(this, sb, classConstructorDescriptorMo1825getUnsubstitutedPrimaryConstructor, null, 2, null);
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibility2 = classConstructorDescriptorMo1825getUnsubstitutedPrimaryConstructor.getVisibility();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(visibility2, "getVisibility(...)");
            renderVisibility(visibility2, sb);
            sb.append(renderKeyword("constructor"));
            java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = classConstructorDescriptorMo1825getUnsubstitutedPrimaryConstructor.getValueParameters();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
            renderValueParameters(valueParameters, classConstructorDescriptorMo1825getUnsubstitutedPrimaryConstructor.hasSynthesizedParameterNames(), sb);
        }
        renderSuperTypes(classDescriptor, sb);
        renderWhereSuffix(declaredTypeParameters, sb);
    }

    private final void renderSuperTypes(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, java.lang.StringBuilder sb) {
        if (getWithoutSuperTypes() || kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isNothing(classDescriptor.getDefaultType())) {
            return;
        }
        java.util.Collection<kotlin.reflect.jvm.internal.impl.types.KotlinType> collectionMo1836getSupertypes = classDescriptor.getTypeConstructor().mo1836getSupertypes();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionMo1836getSupertypes, "getSupertypes(...)");
        if (collectionMo1836getSupertypes.isEmpty()) {
            return;
        }
        if (collectionMo1836getSupertypes.size() == 1 && kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isAnyOrNullableAny(collectionMo1836getSupertypes.iterator().next())) {
            return;
        }
        renderSpaceIfNeeded(sb);
        sb.append(": ");
        kotlin.collections.CollectionsKt.joinTo(collectionMo1836getSupertypes, sb, (112 & 2) != 0 ? ", " : ", ", (112 & 4) != 0 ? "" : null, (112 & 8) != 0 ? "" : null, (112 & 16) != 0 ? -1 : 0, (112 & 32) != 0 ? "..." : null, (112 & 64) != 0 ? null : new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$$Lambda$4
            private final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.renderSuperTypes$lambda$36(this.arg$0, (kotlin.reflect.jvm.internal.impl.types.KotlinType) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.CharSequence renderSuperTypes$lambda$36(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl descriptorRendererImpl, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType) {
        kotlin.jvm.internal.Intrinsics.checkNotNull(kotlinType);
        return descriptorRendererImpl.renderType(kotlinType);
    }

    private final void renderClassKindPrefix(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, java.lang.StringBuilder sb) {
        sb.append(renderKeyword(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.Companion.getClassifierKindPrefix(classDescriptor)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderPackageView(kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor packageViewDescriptor, java.lang.StringBuilder sb) {
        renderPackageHeader(packageViewDescriptor.getFqName(), "package", sb);
        if (getDebugMode()) {
            sb.append(" in context of ");
            renderName(packageViewDescriptor.getModule(), sb, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderPackageFragment(kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor packageFragmentDescriptor, java.lang.StringBuilder sb) {
        renderPackageHeader(packageFragmentDescriptor.getFqName(), "package-fragment", sb);
        if (getDebugMode()) {
            sb.append(" in ");
            renderName(packageFragmentDescriptor.getContainingDeclaration(), sb, false);
        }
    }

    private final void renderPackageHeader(kotlin.reflect.jvm.internal.impl.name.FqName fqName, java.lang.String str, java.lang.StringBuilder sb) {
        sb.append(renderKeyword(str));
        java.lang.String strRenderFqName = renderFqName(fqName.toUnsafe());
        if (strRenderFqName.length() > 0) {
            sb.append(com.taobao.weex.el.parse.Operators.SPACE_STR);
            sb.append(strRenderFqName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderAccessorModifiers(kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor propertyAccessorDescriptor, java.lang.StringBuilder sb) {
        renderMemberModifiers(propertyAccessorDescriptor, sb);
    }

    /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
    private final class RenderDeclarationDescriptorVisitor implements kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor<kotlin.Unit, java.lang.StringBuilder> {

        /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy.values().length];
                try {
                    iArr[kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy.PRETTY.ordinal()] = 1;
                } catch (java.lang.NoSuchFieldError unused) {
                }
                try {
                    iArr[kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy.DEBUG.ordinal()] = 2;
                } catch (java.lang.NoSuchFieldError unused2) {
                }
                try {
                    iArr[kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy.NONE.ordinal()] = 3;
                } catch (java.lang.NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public RenderDeclarationDescriptorVisitor() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ kotlin.Unit visitClassDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor, java.lang.StringBuilder sb) {
            visitClassDescriptor2(classDescriptor, sb);
            return kotlin.Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ kotlin.Unit visitConstructorDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor constructorDescriptor, java.lang.StringBuilder sb) {
            visitConstructorDescriptor2(constructorDescriptor, sb);
            return kotlin.Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ kotlin.Unit visitFunctionDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor functionDescriptor, java.lang.StringBuilder sb) {
            visitFunctionDescriptor2(functionDescriptor, sb);
            return kotlin.Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ kotlin.Unit visitModuleDeclaration(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor moduleDescriptor, java.lang.StringBuilder sb) {
            visitModuleDeclaration2(moduleDescriptor, sb);
            return kotlin.Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ kotlin.Unit visitPackageFragmentDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor packageFragmentDescriptor, java.lang.StringBuilder sb) {
            visitPackageFragmentDescriptor2(packageFragmentDescriptor, sb);
            return kotlin.Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ kotlin.Unit visitPackageViewDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor packageViewDescriptor, java.lang.StringBuilder sb) {
            visitPackageViewDescriptor2(packageViewDescriptor, sb);
            return kotlin.Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ kotlin.Unit visitPropertyDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor propertyDescriptor, java.lang.StringBuilder sb) {
            visitPropertyDescriptor2(propertyDescriptor, sb);
            return kotlin.Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ kotlin.Unit visitPropertyGetterDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor propertyGetterDescriptor, java.lang.StringBuilder sb) {
            visitPropertyGetterDescriptor2(propertyGetterDescriptor, sb);
            return kotlin.Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ kotlin.Unit visitPropertySetterDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor propertySetterDescriptor, java.lang.StringBuilder sb) {
            visitPropertySetterDescriptor2(propertySetterDescriptor, sb);
            return kotlin.Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ kotlin.Unit visitReceiverParameterDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor receiverParameterDescriptor, java.lang.StringBuilder sb) {
            visitReceiverParameterDescriptor2(receiverParameterDescriptor, sb);
            return kotlin.Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ kotlin.Unit visitTypeAliasDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor typeAliasDescriptor, java.lang.StringBuilder sb) {
            visitTypeAliasDescriptor2(typeAliasDescriptor, sb);
            return kotlin.Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ kotlin.Unit visitTypeParameterDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor typeParameterDescriptor, java.lang.StringBuilder sb) {
            visitTypeParameterDescriptor2(typeParameterDescriptor, sb);
            return kotlin.Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        public /* bridge */ /* synthetic */ kotlin.Unit visitValueParameterDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor, java.lang.StringBuilder sb) {
            visitValueParameterDescriptor2(valueParameterDescriptor, sb);
            return kotlin.Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: visitValueParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitValueParameterDescriptor2(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor descriptor, java.lang.StringBuilder builder) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.this.renderValueParameter(descriptor, true, builder, true);
        }

        /* JADX INFO: renamed from: visitPropertyDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertyDescriptor2(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor descriptor, java.lang.StringBuilder builder) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.this.renderProperty(descriptor, builder);
        }

        /* JADX INFO: renamed from: visitPropertyGetterDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertyGetterDescriptor2(kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor descriptor, java.lang.StringBuilder builder) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
            visitPropertyAccessorDescriptor(descriptor, builder, "getter");
        }

        /* JADX INFO: renamed from: visitPropertySetterDescriptor, reason: avoid collision after fix types in other method */
        public void visitPropertySetterDescriptor2(kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor descriptor, java.lang.StringBuilder builder) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
            visitPropertyAccessorDescriptor(descriptor, builder, "setter");
        }

        private final void visitPropertyAccessorDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor propertyAccessorDescriptor, java.lang.StringBuilder sb, java.lang.String str) {
            int i = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.RenderDeclarationDescriptorVisitor.WhenMappings.$EnumSwitchMapping$0[kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.this.getPropertyAccessorRenderingPolicy().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    visitFunctionDescriptor2((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) propertyAccessorDescriptor, sb);
                    return;
                } else {
                    if (i != 3) {
                        throw new kotlin.NoWhenBranchMatchedException();
                    }
                    return;
                }
            }
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.this.renderAccessorModifiers(propertyAccessorDescriptor, sb);
            sb.append(str + " for ");
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl descriptorRendererImpl = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.this;
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor correspondingProperty = propertyAccessorDescriptor.getCorrespondingProperty();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(correspondingProperty, "getCorrespondingProperty(...)");
            descriptorRendererImpl.renderProperty(correspondingProperty, sb);
        }

        /* JADX INFO: renamed from: visitFunctionDescriptor, reason: avoid collision after fix types in other method */
        public void visitFunctionDescriptor2(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor descriptor, java.lang.StringBuilder builder) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.this.renderFunction(descriptor, builder);
        }

        /* JADX INFO: renamed from: visitReceiverParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitReceiverParameterDescriptor2(kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor descriptor, java.lang.StringBuilder builder) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
            builder.append(descriptor.getName());
        }

        /* JADX INFO: renamed from: visitConstructorDescriptor, reason: avoid collision after fix types in other method */
        public void visitConstructorDescriptor2(kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor constructorDescriptor, java.lang.StringBuilder builder) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(constructorDescriptor, "constructorDescriptor");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.this.renderConstructor(constructorDescriptor, builder);
        }

        /* JADX INFO: renamed from: visitTypeParameterDescriptor, reason: avoid collision after fix types in other method */
        public void visitTypeParameterDescriptor2(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor descriptor, java.lang.StringBuilder builder) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.this.renderTypeParameter(descriptor, builder, true);
        }

        /* JADX INFO: renamed from: visitPackageFragmentDescriptor, reason: avoid collision after fix types in other method */
        public void visitPackageFragmentDescriptor2(kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor descriptor, java.lang.StringBuilder builder) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.this.renderPackageFragment(descriptor, builder);
        }

        /* JADX INFO: renamed from: visitPackageViewDescriptor, reason: avoid collision after fix types in other method */
        public void visitPackageViewDescriptor2(kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor descriptor, java.lang.StringBuilder builder) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.this.renderPackageView(descriptor, builder);
        }

        /* JADX INFO: renamed from: visitModuleDeclaration, reason: avoid collision after fix types in other method */
        public void visitModuleDeclaration2(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor descriptor, java.lang.StringBuilder builder) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.this.renderName(descriptor, builder, true);
        }

        /* JADX INFO: renamed from: visitClassDescriptor, reason: avoid collision after fix types in other method */
        public void visitClassDescriptor2(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor descriptor, java.lang.StringBuilder builder) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.this.renderClass(descriptor, builder);
        }

        /* JADX INFO: renamed from: visitTypeAliasDescriptor, reason: avoid collision after fix types in other method */
        public void visitTypeAliasDescriptor2(kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor descriptor, java.lang.StringBuilder builder) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.this.renderTypeAlias(descriptor, builder);
        }
    }

    private final void renderSpaceIfNeeded(java.lang.StringBuilder sb) {
        int length = sb.length();
        if (length == 0 || sb.charAt(length - 1) != ' ') {
            sb.append(' ');
        }
    }

    private final boolean overridesSomething(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor) {
        return !callableMemberDescriptor.getOverriddenDescriptors().isEmpty();
    }

    private final void renderAbbreviatedTypeComment(java.lang.StringBuilder sb, kotlin.reflect.jvm.internal.impl.types.AbbreviatedType abbreviatedType) {
        if (getTextFormat() == kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.HTML) {
            sb.append("<font color=\"808080\"><i>");
        }
        sb.append(" /* ");
        sb.append("from: ");
        renderNormalizedTypeAsIs(sb, abbreviatedType.getAbbreviation());
        sb.append(" */");
        if (getTextFormat() == kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.HTML) {
            sb.append("</i></font>");
        }
    }

    private final void renderExpandedTypeComment(java.lang.StringBuilder sb, kotlin.reflect.jvm.internal.impl.types.AbbreviatedType abbreviatedType) {
        if (getTextFormat() == kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.HTML) {
            sb.append("<font color=\"808080\"><i>");
        }
        sb.append(" /* ");
        sb.append("= ");
        renderNormalizedTypeAsIs(sb, abbreviatedType.getExpandedType());
        sb.append(" */");
        if (getTextFormat() == kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.HTML) {
            sb.append("</i></font>");
        }
    }
}
