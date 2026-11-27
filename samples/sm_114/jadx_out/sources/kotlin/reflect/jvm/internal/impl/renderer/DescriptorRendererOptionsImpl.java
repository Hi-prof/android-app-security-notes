package kotlin.reflect.jvm.internal.impl.renderer;

/* JADX INFO: compiled from: DescriptorRendererOptionsImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DescriptorRendererOptionsImpl implements kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions {
    static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "withDefinedIn", "getWithDefinedIn()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "modifiers", "getModifiers()Ljava/util/Set;", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "startFromName", "getStartFromName()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, com.taobao.weex.common.WXConfig.debugMode, "getDebugMode()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "verbose", "getVerbose()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "unitReturnType", "getUnitReturnType()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "withoutReturnType", "getWithoutReturnType()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "enhancedTypes", "getEnhancedTypes()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "normalizedVisibilities", "getNormalizedVisibilities()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "renderDefaultVisibility", "getRenderDefaultVisibility()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "renderDefaultModality", "getRenderDefaultModality()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "renderConstructorDelegation", "getRenderConstructorDelegation()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "includePropertyConstant", "getIncludePropertyConstant()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "propertyConstantRenderer", "getPropertyConstantRenderer()Lkotlin/jvm/functions/Function1;", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "withoutTypeParameters", "getWithoutTypeParameters()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "withoutSuperTypes", "getWithoutSuperTypes()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "receiverAfterName", "getReceiverAfterName()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "renderCompanionObjectName", "getRenderCompanionObjectName()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "renderConstructorKeyword", "getRenderConstructorKeyword()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "renderTypeExpansions", "getRenderTypeExpansions()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "renderAbbreviatedTypeComments", "getRenderAbbreviatedTypeComments()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "renderFunctionContracts", "getRenderFunctionContracts()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z", 0)), kotlin.jvm.internal.Reflection.mutableProperty1(new kotlin.jvm.internal.MutablePropertyReference1Impl(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class, "informativeErrorType", "getInformativeErrorType()Z", 0))};
    private boolean isLocked;
    private final kotlin.properties.ReadWriteProperty classifierNamePolicy$delegate = property(kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy.SOURCE_CODE_QUALIFIED.INSTANCE);
    private final kotlin.properties.ReadWriteProperty withDefinedIn$delegate = property(true);
    private final kotlin.properties.ReadWriteProperty withSourceFileForTopLevel$delegate = property(true);
    private final kotlin.properties.ReadWriteProperty modifiers$delegate = property(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
    private final kotlin.properties.ReadWriteProperty startFromName$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty startFromDeclarationKeyword$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty debugMode$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty classWithPrimaryConstructor$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty verbose$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty unitReturnType$delegate = property(true);
    private final kotlin.properties.ReadWriteProperty withoutReturnType$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty enhancedTypes$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty normalizedVisibilities$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty renderDefaultVisibility$delegate = property(true);
    private final kotlin.properties.ReadWriteProperty renderDefaultModality$delegate = property(true);
    private final kotlin.properties.ReadWriteProperty renderConstructorDelegation$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty renderPrimaryConstructorParametersAsProperties$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty actualPropertiesInPrimaryConstructor$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty uninferredTypeParameterAsName$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty includePropertyConstant$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty propertyConstantRenderer$delegate = property(null);
    private final kotlin.properties.ReadWriteProperty withoutTypeParameters$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty withoutSuperTypes$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty typeNormalizer$delegate = property(new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl$$Lambda$0
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke */
        public java.lang.Object invoke2(java.lang.Object obj) {
            return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.typeNormalizer_delegate$lambda$2((kotlin.reflect.jvm.internal.impl.types.KotlinType) obj);
        }
    });
    private final kotlin.properties.ReadWriteProperty defaultParameterValueRenderer$delegate = property(new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl$$Lambda$1
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: invoke */
        public java.lang.Object invoke2(java.lang.Object obj) {
            return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.defaultParameterValueRenderer_delegate$lambda$3((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) obj);
        }
    });
    private final kotlin.properties.ReadWriteProperty secondaryConstructorsAsPrimary$delegate = property(true);
    private final kotlin.properties.ReadWriteProperty overrideRenderingPolicy$delegate = property(kotlin.reflect.jvm.internal.impl.renderer.OverrideRenderingPolicy.RENDER_OPEN);
    private final kotlin.properties.ReadWriteProperty valueParametersHandler$delegate = property(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler.DEFAULT.INSTANCE);
    private final kotlin.properties.ReadWriteProperty textFormat$delegate = property(kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.PLAIN);
    private final kotlin.properties.ReadWriteProperty parameterNameRenderingPolicy$delegate = property(kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy.ALL);
    private final kotlin.properties.ReadWriteProperty receiverAfterName$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty renderCompanionObjectName$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty propertyAccessorRenderingPolicy$delegate = property(kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy.DEBUG);
    private final kotlin.properties.ReadWriteProperty renderDefaultAnnotationArguments$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty eachAnnotationOnNewLine$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty excludedAnnotationClasses$delegate = property(kotlin.collections.SetsKt.emptySet());
    private final kotlin.properties.ReadWriteProperty excludedTypeAnnotationClasses$delegate = property(kotlin.reflect.jvm.internal.impl.renderer.ExcludedTypeAnnotations.INSTANCE.getInternalAnnotationsForResolve());
    private final kotlin.properties.ReadWriteProperty annotationFilter$delegate = property(null);
    private final kotlin.properties.ReadWriteProperty annotationArgumentsRenderingPolicy$delegate = property(kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy.NO_ARGUMENTS);
    private final kotlin.properties.ReadWriteProperty alwaysRenderModifiers$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty renderConstructorKeyword$delegate = property(true);
    private final kotlin.properties.ReadWriteProperty renderUnabbreviatedType$delegate = property(true);
    private final kotlin.properties.ReadWriteProperty renderTypeExpansions$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty renderAbbreviatedTypeComments$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty includeAdditionalModifiers$delegate = property(true);
    private final kotlin.properties.ReadWriteProperty parameterNamesInFunctionalTypes$delegate = property(true);
    private final kotlin.properties.ReadWriteProperty renderFunctionContracts$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty presentableUnresolvedTypes$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty boldOnlyForNamesInHtml$delegate = property(false);
    private final kotlin.properties.ReadWriteProperty informativeErrorType$delegate = property(true);

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType typeNormalizer_delegate$lambda$2(kotlin.reflect.jvm.internal.impl.types.KotlinType it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    public boolean getIncludeAnnotationArguments() {
        return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions.DefaultImpls.getIncludeAnnotationArguments(this);
    }

    public boolean getIncludeEmptyAnnotationArguments() {
        return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions.DefaultImpls.getIncludeEmptyAnnotationArguments(this);
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public final void lock() {
        this.isLocked = true;
    }

    public final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl copy() {
        kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = new kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl();
        java.util.Iterator it = kotlin.jvm.internal.ArrayIteratorKt.iterator(getClass().getDeclaredFields());
        while (it.hasNext()) {
            java.lang.reflect.Field field = (java.lang.reflect.Field) it.next();
            if ((field.getModifiers() & 8) == 0) {
                field.setAccessible(true);
                java.lang.Object obj = field.get(this);
                kotlin.properties.ObservableProperty observableProperty = obj instanceof kotlin.properties.ObservableProperty ? (kotlin.properties.ObservableProperty) obj : null;
                if (observableProperty != null) {
                    java.lang.String name = field.getName();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    kotlin.text.StringsKt.startsWith$default(name, "is", false, 2, (java.lang.Object) null);
                    kotlin.reflect.KClass orCreateKotlinClass = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.class);
                    java.lang.String name2 = field.getName();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("get");
                    java.lang.String name3 = field.getName();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
                    if (name3.length() > 0) {
                        char upperCase = java.lang.Character.toUpperCase(name3.charAt(0));
                        java.lang.String strSubstring = name3.substring(1);
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        name3 = upperCase + strSubstring;
                    }
                    sb.append(name3);
                    field.set(descriptorRendererOptionsImpl, descriptorRendererOptionsImpl.property(observableProperty.getValue(this, new kotlin.jvm.internal.PropertyReference1Impl(orCreateKotlinClass, name2, sb.toString()))));
                }
            }
        }
        return descriptorRendererOptionsImpl;
    }

    private final <T> kotlin.properties.ReadWriteProperty<kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl, T> property(final T t) {
        kotlin.properties.Delegates delegates = kotlin.properties.Delegates.INSTANCE;
        return new kotlin.properties.ObservableProperty<T>(t) { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl$property$$inlined$vetoable$1
            @Override // kotlin.properties.ObservableProperty
            protected boolean beforeChange(kotlin.reflect.KProperty<?> property, T t2, T t3) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
                if (this.isLocked()) {
                    throw new java.lang.IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
                }
                return true;
            }
        };
    }

    public kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy getClassifierNamePolicy() {
        return (kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy) this.classifierNamePolicy$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setClassifierNamePolicy(kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy classifierNamePolicy) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classifierNamePolicy, "<set-?>");
        this.classifierNamePolicy$delegate.setValue(this, $$delegatedProperties[0], classifierNamePolicy);
    }

    public boolean getWithDefinedIn() {
        return ((java.lang.Boolean) this.withDefinedIn$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithDefinedIn(boolean z) {
        this.withDefinedIn$delegate.setValue(this, $$delegatedProperties[1], java.lang.Boolean.valueOf(z));
    }

    public boolean getWithSourceFileForTopLevel() {
        return ((java.lang.Boolean) this.withSourceFileForTopLevel$delegate.getValue(this, $$delegatedProperties[2])).booleanValue();
    }

    public java.util.Set<kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier> getModifiers() {
        return (java.util.Set) this.modifiers$delegate.getValue(this, $$delegatedProperties[3]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setModifiers(java.util.Set<? extends kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier> set) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.modifiers$delegate.setValue(this, $$delegatedProperties[3], set);
    }

    public boolean getStartFromName() {
        return ((java.lang.Boolean) this.startFromName$delegate.getValue(this, $$delegatedProperties[4])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setStartFromName(boolean z) {
        this.startFromName$delegate.setValue(this, $$delegatedProperties[4], java.lang.Boolean.valueOf(z));
    }

    public boolean getStartFromDeclarationKeyword() {
        return ((java.lang.Boolean) this.startFromDeclarationKeyword$delegate.getValue(this, $$delegatedProperties[5])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getDebugMode() {
        return ((java.lang.Boolean) this.debugMode$delegate.getValue(this, $$delegatedProperties[6])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setDebugMode(boolean z) {
        this.debugMode$delegate.setValue(this, $$delegatedProperties[6], java.lang.Boolean.valueOf(z));
    }

    public boolean getClassWithPrimaryConstructor() {
        return ((java.lang.Boolean) this.classWithPrimaryConstructor$delegate.getValue(this, $$delegatedProperties[7])).booleanValue();
    }

    public boolean getVerbose() {
        return ((java.lang.Boolean) this.verbose$delegate.getValue(this, $$delegatedProperties[8])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setVerbose(boolean z) {
        this.verbose$delegate.setValue(this, $$delegatedProperties[8], java.lang.Boolean.valueOf(z));
    }

    public boolean getUnitReturnType() {
        return ((java.lang.Boolean) this.unitReturnType$delegate.getValue(this, $$delegatedProperties[9])).booleanValue();
    }

    public boolean getWithoutReturnType() {
        return ((java.lang.Boolean) this.withoutReturnType$delegate.getValue(this, $$delegatedProperties[10])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public boolean getEnhancedTypes() {
        return ((java.lang.Boolean) this.enhancedTypes$delegate.getValue(this, $$delegatedProperties[11])).booleanValue();
    }

    public boolean getNormalizedVisibilities() {
        return ((java.lang.Boolean) this.normalizedVisibilities$delegate.getValue(this, $$delegatedProperties[12])).booleanValue();
    }

    public boolean getRenderDefaultVisibility() {
        return ((java.lang.Boolean) this.renderDefaultVisibility$delegate.getValue(this, $$delegatedProperties[13])).booleanValue();
    }

    public boolean getRenderDefaultModality() {
        return ((java.lang.Boolean) this.renderDefaultModality$delegate.getValue(this, $$delegatedProperties[14])).booleanValue();
    }

    public boolean getRenderConstructorDelegation() {
        return ((java.lang.Boolean) this.renderConstructorDelegation$delegate.getValue(this, $$delegatedProperties[15])).booleanValue();
    }

    public boolean getRenderPrimaryConstructorParametersAsProperties() {
        return ((java.lang.Boolean) this.renderPrimaryConstructorParametersAsProperties$delegate.getValue(this, $$delegatedProperties[16])).booleanValue();
    }

    public boolean getActualPropertiesInPrimaryConstructor() {
        return ((java.lang.Boolean) this.actualPropertiesInPrimaryConstructor$delegate.getValue(this, $$delegatedProperties[17])).booleanValue();
    }

    public boolean getUninferredTypeParameterAsName() {
        return ((java.lang.Boolean) this.uninferredTypeParameterAsName$delegate.getValue(this, $$delegatedProperties[18])).booleanValue();
    }

    public boolean getIncludePropertyConstant() {
        return ((java.lang.Boolean) this.includePropertyConstant$delegate.getValue(this, $$delegatedProperties[19])).booleanValue();
    }

    public kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>, java.lang.String> getPropertyConstantRenderer() {
        return (kotlin.jvm.functions.Function1) this.propertyConstantRenderer$delegate.getValue(this, $$delegatedProperties[20]);
    }

    public boolean getWithoutTypeParameters() {
        return ((java.lang.Boolean) this.withoutTypeParameters$delegate.getValue(this, $$delegatedProperties[21])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutTypeParameters(boolean z) {
        this.withoutTypeParameters$delegate.setValue(this, $$delegatedProperties[21], java.lang.Boolean.valueOf(z));
    }

    public boolean getWithoutSuperTypes() {
        return ((java.lang.Boolean) this.withoutSuperTypes$delegate.getValue(this, $$delegatedProperties[22])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setWithoutSuperTypes(boolean z) {
        this.withoutSuperTypes$delegate.setValue(this, $$delegatedProperties[22], java.lang.Boolean.valueOf(z));
    }

    public kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.types.KotlinType> getTypeNormalizer() {
        return (kotlin.jvm.functions.Function1) this.typeNormalizer$delegate.getValue(this, $$delegatedProperties[23]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.String defaultParameterValueRenderer_delegate$lambda$3(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return "...";
    }

    public kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor, java.lang.String> getDefaultParameterValueRenderer() {
        return (kotlin.jvm.functions.Function1) this.defaultParameterValueRenderer$delegate.getValue(this, $$delegatedProperties[24]);
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        return ((java.lang.Boolean) this.secondaryConstructorsAsPrimary$delegate.getValue(this, $$delegatedProperties[25])).booleanValue();
    }

    public kotlin.reflect.jvm.internal.impl.renderer.OverrideRenderingPolicy getOverrideRenderingPolicy() {
        return (kotlin.reflect.jvm.internal.impl.renderer.OverrideRenderingPolicy) this.overrideRenderingPolicy$delegate.getValue(this, $$delegatedProperties[26]);
    }

    public kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler getValueParametersHandler() {
        return (kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler) this.valueParametersHandler$delegate.getValue(this, $$delegatedProperties[27]);
    }

    public kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat getTextFormat() {
        return (kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat) this.textFormat$delegate.getValue(this, $$delegatedProperties[28]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setTextFormat(kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat renderingFormat) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(renderingFormat, "<set-?>");
        this.textFormat$delegate.setValue(this, $$delegatedProperties[28], renderingFormat);
    }

    public kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy getParameterNameRenderingPolicy() {
        return (kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy) this.parameterNameRenderingPolicy$delegate.getValue(this, $$delegatedProperties[29]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setParameterNameRenderingPolicy(kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parameterNameRenderingPolicy, "<set-?>");
        this.parameterNameRenderingPolicy$delegate.setValue(this, $$delegatedProperties[29], parameterNameRenderingPolicy);
    }

    public boolean getReceiverAfterName() {
        return ((java.lang.Boolean) this.receiverAfterName$delegate.getValue(this, $$delegatedProperties[30])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setReceiverAfterName(boolean z) {
        this.receiverAfterName$delegate.setValue(this, $$delegatedProperties[30], java.lang.Boolean.valueOf(z));
    }

    public boolean getRenderCompanionObjectName() {
        return ((java.lang.Boolean) this.renderCompanionObjectName$delegate.getValue(this, $$delegatedProperties[31])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setRenderCompanionObjectName(boolean z) {
        this.renderCompanionObjectName$delegate.setValue(this, $$delegatedProperties[31], java.lang.Boolean.valueOf(z));
    }

    public kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy getPropertyAccessorRenderingPolicy() {
        return (kotlin.reflect.jvm.internal.impl.renderer.PropertyAccessorRenderingPolicy) this.propertyAccessorRenderingPolicy$delegate.getValue(this, $$delegatedProperties[32]);
    }

    public boolean getRenderDefaultAnnotationArguments() {
        return ((java.lang.Boolean) this.renderDefaultAnnotationArguments$delegate.getValue(this, $$delegatedProperties[33])).booleanValue();
    }

    public boolean getEachAnnotationOnNewLine() {
        return ((java.lang.Boolean) this.eachAnnotationOnNewLine$delegate.getValue(this, $$delegatedProperties[34])).booleanValue();
    }

    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> getExcludedAnnotationClasses() {
        return (java.util.Set) this.excludedAnnotationClasses$delegate.getValue(this, $$delegatedProperties[35]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> getExcludedTypeAnnotationClasses() {
        return (java.util.Set) this.excludedTypeAnnotationClasses$delegate.getValue(this, $$delegatedProperties[36]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setExcludedTypeAnnotationClasses(java.util.Set<kotlin.reflect.jvm.internal.impl.name.FqName> set) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.excludedTypeAnnotationClasses$delegate.setValue(this, $$delegatedProperties[36], set);
    }

    public kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor, java.lang.Boolean> getAnnotationFilter() {
        return (kotlin.jvm.functions.Function1) this.annotationFilter$delegate.getValue(this, $$delegatedProperties[37]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy() {
        return (kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy) this.annotationArgumentsRenderingPolicy$delegate.getValue(this, $$delegatedProperties[38]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
    public void setAnnotationArgumentsRenderingPolicy(kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotationArgumentsRenderingPolicy, "<set-?>");
        this.annotationArgumentsRenderingPolicy$delegate.setValue(this, $$delegatedProperties[38], annotationArgumentsRenderingPolicy);
    }

    public boolean getAlwaysRenderModifiers() {
        return ((java.lang.Boolean) this.alwaysRenderModifiers$delegate.getValue(this, $$delegatedProperties[39])).booleanValue();
    }

    public boolean getRenderConstructorKeyword() {
        return ((java.lang.Boolean) this.renderConstructorKeyword$delegate.getValue(this, $$delegatedProperties[40])).booleanValue();
    }

    public boolean getRenderUnabbreviatedType() {
        return ((java.lang.Boolean) this.renderUnabbreviatedType$delegate.getValue(this, $$delegatedProperties[41])).booleanValue();
    }

    public boolean getRenderTypeExpansions() {
        return ((java.lang.Boolean) this.renderTypeExpansions$delegate.getValue(this, $$delegatedProperties[42])).booleanValue();
    }

    public boolean getRenderAbbreviatedTypeComments() {
        return ((java.lang.Boolean) this.renderAbbreviatedTypeComments$delegate.getValue(this, $$delegatedProperties[43])).booleanValue();
    }

    public boolean getIncludeAdditionalModifiers() {
        return ((java.lang.Boolean) this.includeAdditionalModifiers$delegate.getValue(this, $$delegatedProperties[44])).booleanValue();
    }

    public boolean getParameterNamesInFunctionalTypes() {
        return ((java.lang.Boolean) this.parameterNamesInFunctionalTypes$delegate.getValue(this, $$delegatedProperties[45])).booleanValue();
    }

    public boolean getPresentableUnresolvedTypes() {
        return ((java.lang.Boolean) this.presentableUnresolvedTypes$delegate.getValue(this, $$delegatedProperties[47])).booleanValue();
    }

    public boolean getBoldOnlyForNamesInHtml() {
        return ((java.lang.Boolean) this.boldOnlyForNamesInHtml$delegate.getValue(this, $$delegatedProperties[48])).booleanValue();
    }

    public boolean getInformativeErrorType() {
        return ((java.lang.Boolean) this.informativeErrorType$delegate.getValue(this, $$delegatedProperties[49])).booleanValue();
    }
}
