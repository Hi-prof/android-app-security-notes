package kotlin.reflect.jvm.internal.impl.renderer;

/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DescriptorRenderer {
    public static final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer COMPACT;
    public static final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer COMPACT_WITHOUT_SUPERTYPES;
    public static final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer COMPACT_WITH_MODIFIERS;
    public static final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer COMPACT_WITH_SHORT_TYPES;
    public static final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.Companion Companion;
    public static final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer DEBUG_TEXT;
    public static final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer FQ_NAMES_IN_TYPES;
    public static final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS;
    public static final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer HTML;
    public static final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer ONLY_NAMES_WITH_SHORT_TYPES;
    public static final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer SHORT_NAMES_IN_TYPES;
    public static final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer WITHOUT_MODIFIERS;

    public abstract java.lang.String render(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor);

    public abstract java.lang.String renderAnnotation(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget annotationUseSiteTarget);

    public abstract java.lang.String renderFlexibleType(java.lang.String str, java.lang.String str2, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns kotlinBuiltIns);

    public abstract java.lang.String renderFqName(kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe fqNameUnsafe);

    public abstract java.lang.String renderName(kotlin.reflect.jvm.internal.impl.name.Name name, boolean z);

    public abstract java.lang.String renderType(kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType);

    public abstract java.lang.String renderTypeProjection(kotlin.reflect.jvm.internal.impl.types.TypeProjection typeProjection);

    public final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer withOptions(kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions, kotlin.Unit> changeOptions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(changeOptions, "changeOptions");
        kotlin.jvm.internal.Intrinsics.checkNotNull(this, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
        kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl descriptorRendererOptionsImplCopy = ((kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl) this).getOptions().copy();
        changeOptions.invoke2(descriptorRendererOptionsImplCopy);
        descriptorRendererOptionsImplCopy.lock();
        return new kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl(descriptorRendererOptionsImplCopy);
    }

    public static /* synthetic */ java.lang.String renderAnnotation$default(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer descriptorRenderer, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor annotationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget annotationUseSiteTarget, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
        }
        if ((i & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        return descriptorRenderer.renderAnnotation(annotationDescriptor, annotationUseSiteTarget);
    }

    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public interface ValueParametersHandler {
        void appendAfterValueParameter(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor, int i, int i2, java.lang.StringBuilder sb);

        void appendAfterValueParameters(int i, java.lang.StringBuilder sb);

        void appendBeforeValueParameter(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor valueParameterDescriptor, int i, int i2, java.lang.StringBuilder sb);

        void appendBeforeValueParameters(int i, java.lang.StringBuilder sb);

        /* JADX INFO: compiled from: DescriptorRenderer.kt */
        public static final class DEFAULT implements kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler {
            public static final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler.DEFAULT INSTANCE = new kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler.DEFAULT();

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameter(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor parameter, int i, int i2, java.lang.StringBuilder builder) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parameter, "parameter");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
            }

            private DEFAULT() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendBeforeValueParameters(int i, java.lang.StringBuilder builder) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
                builder.append(com.taobao.weex.el.parse.Operators.BRACKET_START_STR);
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameters(int i, java.lang.StringBuilder builder) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
                builder.append(com.taobao.weex.el.parse.Operators.BRACKET_END_STR);
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
            public void appendAfterValueParameter(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor parameter, int i, int i2, java.lang.StringBuilder builder) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parameter, "parameter");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
                if (i != i2 - 1) {
                    builder.append(", ");
                }
            }
        }
    }

    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: DescriptorRenderer.kt */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.values().length];
                try {
                    iArr[kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS.ordinal()] = 1;
                } catch (java.lang.NoSuchFieldError unused) {
                }
                try {
                    iArr[kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE.ordinal()] = 2;
                } catch (java.lang.NoSuchFieldError unused2) {
                }
                try {
                    iArr[kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_CLASS.ordinal()] = 3;
                } catch (java.lang.NoSuchFieldError unused3) {
                }
                try {
                    iArr[kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.OBJECT.ordinal()] = 4;
                } catch (java.lang.NoSuchFieldError unused4) {
                }
                try {
                    iArr[kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
                } catch (java.lang.NoSuchFieldError unused5) {
                }
                try {
                    iArr[kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ENUM_ENTRY.ordinal()] = 6;
                } catch (java.lang.NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer withOptions(kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions, kotlin.Unit> changeOptions) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(changeOptions, "changeOptions");
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = new kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl();
            changeOptions.invoke2(descriptorRendererOptionsImpl);
            descriptorRendererOptionsImpl.lock();
            return new kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl(descriptorRendererOptionsImpl);
        }

        public final java.lang.String getClassifierKindPrefix(kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters classifier) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classifier, "classifier");
            if (classifier instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor) {
                return "typealias";
            }
            if (classifier instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) {
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifier;
                if (classDescriptor.isCompanionObject()) {
                    return "companion object";
                }
                switch (kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.Companion.WhenMappings.$EnumSwitchMapping$0[classDescriptor.getKind().ordinal()]) {
                    case 1:
                        return "class";
                    case 2:
                        return "interface";
                    case 3:
                        return "enum class";
                    case 4:
                        return "object";
                    case 5:
                        return "annotation class";
                    case 6:
                        return "enum entry";
                    default:
                        throw new kotlin.NoWhenBranchMatchedException();
                }
            }
            throw new java.lang.AssertionError("Unexpected classifier: " + classifier);
        }
    }

    static {
        kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.Companion companion = new kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.Companion(null);
        Companion = companion;
        WITHOUT_MODIFIERS = companion.withOptions(new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.WITHOUT_MODIFIERS$lambda$0((kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions) obj);
            }
        });
        COMPACT_WITH_MODIFIERS = companion.withOptions(new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.COMPACT_WITH_MODIFIERS$lambda$1((kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions) obj);
            }
        });
        COMPACT = companion.withOptions(new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$2
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.COMPACT$lambda$2((kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions) obj);
            }
        });
        COMPACT_WITHOUT_SUPERTYPES = companion.withOptions(new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$3
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.COMPACT_WITHOUT_SUPERTYPES$lambda$3((kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions) obj);
            }
        });
        COMPACT_WITH_SHORT_TYPES = companion.withOptions(new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$4
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.COMPACT_WITH_SHORT_TYPES$lambda$4((kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions) obj);
            }
        });
        ONLY_NAMES_WITH_SHORT_TYPES = companion.withOptions(new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$5
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ONLY_NAMES_WITH_SHORT_TYPES$lambda$5((kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions) obj);
            }
        });
        FQ_NAMES_IN_TYPES = companion.withOptions(new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$6
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.FQ_NAMES_IN_TYPES$lambda$6((kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions) obj);
            }
        });
        FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS = companion.withOptions(new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$7
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$lambda$7((kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions) obj);
            }
        });
        SHORT_NAMES_IN_TYPES = companion.withOptions(new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$8
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.SHORT_NAMES_IN_TYPES$lambda$8((kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions) obj);
            }
        });
        DEBUG_TEXT = companion.withOptions(new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$9
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.DEBUG_TEXT$lambda$9((kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions) obj);
            }
        });
        HTML = companion.withOptions(new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$$Lambda$10
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.HTML$lambda$10((kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit WITHOUT_MODIFIERS$lambda$0(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions withOptions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setModifiers(kotlin.collections.SetsKt.emptySet());
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit COMPACT_WITH_MODIFIERS$lambda$1(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions withOptions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setWithDefinedIn(false);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit COMPACT$lambda$2(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions withOptions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setWithDefinedIn(false);
        withOptions.setModifiers(kotlin.collections.SetsKt.emptySet());
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit COMPACT_WITHOUT_SUPERTYPES$lambda$3(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions withOptions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setWithDefinedIn(false);
        withOptions.setModifiers(kotlin.collections.SetsKt.emptySet());
        withOptions.setWithoutSuperTypes(true);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit COMPACT_WITH_SHORT_TYPES$lambda$4(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions withOptions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setModifiers(kotlin.collections.SetsKt.emptySet());
        withOptions.setClassifierNamePolicy(kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy.SHORT.INSTANCE);
        withOptions.setParameterNameRenderingPolicy(kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit ONLY_NAMES_WITH_SHORT_TYPES$lambda$5(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions withOptions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setWithDefinedIn(false);
        withOptions.setModifiers(kotlin.collections.SetsKt.emptySet());
        withOptions.setClassifierNamePolicy(kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy.SHORT.INSTANCE);
        withOptions.setWithoutTypeParameters(true);
        withOptions.setParameterNameRenderingPolicy(kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy.NONE);
        withOptions.setReceiverAfterName(true);
        withOptions.setRenderCompanionObjectName(true);
        withOptions.setWithoutSuperTypes(true);
        withOptions.setStartFromName(true);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit FQ_NAMES_IN_TYPES$lambda$6(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions withOptions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setModifiers(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$lambda$7(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions withOptions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setModifiers(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier.ALL);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit SHORT_NAMES_IN_TYPES$lambda$8(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions withOptions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setClassifierNamePolicy(kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy.SHORT.INSTANCE);
        withOptions.setParameterNameRenderingPolicy(kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit DEBUG_TEXT$lambda$9(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions withOptions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setDebugMode(true);
        withOptions.setClassifierNamePolicy(kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy.FULLY_QUALIFIED.INSTANCE);
        withOptions.setModifiers(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier.ALL);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit HTML$lambda$10(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions withOptions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(withOptions, "$this$withOptions");
        withOptions.setTextFormat(kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat.HTML);
        withOptions.setModifiers(kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererModifier.ALL);
        return kotlin.Unit.INSTANCE;
    }
}
