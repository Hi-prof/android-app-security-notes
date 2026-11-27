package kotlin.reflect.jvm.internal.impl.km.internal;

/* JADX INFO: compiled from: Writers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WritersKt {

    /* JADX INFO: compiled from: Writers.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind.LANGUAGE_VERSION.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind.COMPILER_VERSION.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind.API_VERSION.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind.UNKNOWN.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel.values().length];
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel.WARNING.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel.ERROR.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel.HIDDEN.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[kotlin.reflect.jvm.internal.impl.km.KmEffectType.values().length];
            try {
                iArr3[kotlin.reflect.jvm.internal.impl.km.KmEffectType.RETURNS_CONSTANT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                iArr3[kotlin.reflect.jvm.internal.impl.km.KmEffectType.CALLS.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                iArr3[kotlin.reflect.jvm.internal.impl.km.KmEffectType.RETURNS_NOT_NULL.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[kotlin.reflect.jvm.internal.impl.km.KmEffectInvocationKind.values().length];
            try {
                iArr4[kotlin.reflect.jvm.internal.impl.km.KmEffectInvocationKind.AT_MOST_ONCE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                iArr4[kotlin.reflect.jvm.internal.impl.km.KmEffectInvocationKind.EXACTLY_ONCE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                iArr4[kotlin.reflect.jvm.internal.impl.km.KmEffectInvocationKind.AT_LEAST_ONCE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    private static final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Builder writeTypeParameter(kotlin.reflect.jvm.internal.impl.km.internal.WriteContext writeContext, kotlin.reflect.jvm.internal.impl.km.KmTypeParameter kmTypeParameter) {
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Builder builderNewBuilder = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.newBuilder();
        java.util.Iterator<T> it = kmTypeParameter.getUpperBounds().iterator();
        while (it.hasNext()) {
            builderNewBuilder.addUpperBound(writeType(writeContext, (kotlin.reflect.jvm.internal.impl.km.KmType) it.next()).build());
        }
        for (kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions metadataExtensions : writeContext.getExtensions$kotlin_metadata()) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(builderNewBuilder);
            metadataExtensions.writeTypeParameterExtensions(kmTypeParameter, builderNewBuilder, writeContext);
        }
        builderNewBuilder.setName(writeContext.get(kmTypeParameter.getName()));
        builderNewBuilder.setId(kmTypeParameter.getId());
        boolean zIsReified = kotlin.reflect.jvm.internal.impl.km.Attributes.isReified(kmTypeParameter);
        if (zIsReified != kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.getDefaultInstance().getReified()) {
            builderNewBuilder.setReified(zIsReified);
        }
        if (kmTypeParameter.getVariance() == kotlin.reflect.jvm.internal.impl.km.KmVariance.IN) {
            builderNewBuilder.setVariance(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Variance.IN);
        } else if (kmTypeParameter.getVariance() == kotlin.reflect.jvm.internal.impl.km.KmVariance.OUT) {
            builderNewBuilder.setVariance(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Variance.OUT);
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(builderNewBuilder);
        return builderNewBuilder;
    }

    private static final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Builder writeTypeProjection(kotlin.reflect.jvm.internal.impl.km.internal.WriteContext writeContext, kotlin.reflect.jvm.internal.impl.km.KmTypeProjection kmTypeProjection) {
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Builder builderNewBuilder = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.newBuilder();
        if (kotlin.jvm.internal.Intrinsics.areEqual(kmTypeProjection, kotlin.reflect.jvm.internal.impl.km.KmTypeProjection.STAR)) {
            builderNewBuilder.setProjection(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection.STAR);
        } else {
            kotlin.reflect.jvm.internal.impl.km.KmVariance kmVarianceComponent1 = kmTypeProjection.component1();
            kotlin.reflect.jvm.internal.impl.km.KmType kmTypeComponent2 = kmTypeProjection.component2();
            if (kmVarianceComponent1 == null || kmTypeComponent2 == null) {
                throw new kotlin.reflect.jvm.internal.impl.km.InconsistentKotlinMetadataException("Variance and type must be set for non-star type projection", null, 2, null);
            }
            if (kmVarianceComponent1 == kotlin.reflect.jvm.internal.impl.km.KmVariance.IN) {
                builderNewBuilder.setProjection(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection.IN);
            } else if (kmVarianceComponent1 == kotlin.reflect.jvm.internal.impl.km.KmVariance.OUT) {
                builderNewBuilder.setProjection(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection.OUT);
            }
            builderNewBuilder.setType(writeType(writeContext, kmTypeComponent2).build());
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(builderNewBuilder);
        return builderNewBuilder;
    }

    private static final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Builder writeType(kotlin.reflect.jvm.internal.impl.km.internal.WriteContext writeContext, kotlin.reflect.jvm.internal.impl.km.KmType kmType) {
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Builder builderNewBuilder = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.newBuilder();
        kotlin.reflect.jvm.internal.impl.km.KmClassifier classifier = kmType.getClassifier();
        if (classifier instanceof kotlin.reflect.jvm.internal.impl.km.KmClassifier.Class) {
            builderNewBuilder.setClassName(writeContext.getClassName$kotlin_metadata(((kotlin.reflect.jvm.internal.impl.km.KmClassifier.Class) classifier).getName()));
        } else if (classifier instanceof kotlin.reflect.jvm.internal.impl.km.KmClassifier.TypeAlias) {
            builderNewBuilder.setTypeAliasName(writeContext.getClassName$kotlin_metadata(((kotlin.reflect.jvm.internal.impl.km.KmClassifier.TypeAlias) classifier).getName()));
        } else {
            if (!(classifier instanceof kotlin.reflect.jvm.internal.impl.km.KmClassifier.TypeParameter)) {
                throw new kotlin.NoWhenBranchMatchedException();
            }
            builderNewBuilder.setTypeParameter(((kotlin.reflect.jvm.internal.impl.km.KmClassifier.TypeParameter) classifier).getId());
        }
        java.util.Iterator<T> it = kmType.getArguments().iterator();
        while (it.hasNext()) {
            builderNewBuilder.addArgument(writeTypeProjection(writeContext, (kotlin.reflect.jvm.internal.impl.km.KmTypeProjection) it.next()));
        }
        kotlin.reflect.jvm.internal.impl.km.KmType abbreviatedType = kmType.getAbbreviatedType();
        if (abbreviatedType != null) {
            builderNewBuilder.setAbbreviatedType(writeType(writeContext, abbreviatedType).build());
        }
        kotlin.reflect.jvm.internal.impl.km.KmType outerType = kmType.getOuterType();
        if (outerType != null) {
            builderNewBuilder.setOuterType(writeType(writeContext, outerType).build());
        }
        kotlin.reflect.jvm.internal.impl.km.KmFlexibleTypeUpperBound flexibleTypeUpperBound = kmType.getFlexibleTypeUpperBound();
        if (flexibleTypeUpperBound != null) {
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Builder builderWriteType = writeType(writeContext, flexibleTypeUpperBound.getType());
            java.lang.String typeFlexibilityId = flexibleTypeUpperBound.getTypeFlexibilityId();
            if (typeFlexibilityId != null) {
                builderNewBuilder.setFlexibleTypeCapabilitiesId(writeContext.get(typeFlexibilityId));
            }
            builderNewBuilder.setFlexibleUpperBound(builderWriteType.build());
        }
        for (kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions metadataExtensions : writeContext.getExtensions$kotlin_metadata()) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(builderNewBuilder);
            metadataExtensions.writeTypeExtensions(kmType, builderNewBuilder, writeContext);
        }
        if (kotlin.reflect.jvm.internal.impl.km.Attributes.isNullable(kmType)) {
            builderNewBuilder.setNullable(true);
        }
        int flags$kotlin_metadata = kmType.getFlags$kotlin_metadata() >> 1;
        if (flags$kotlin_metadata != kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.getDefaultInstance().getFlags()) {
            builderNewBuilder.setFlags(flags$kotlin_metadata);
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(builderNewBuilder);
        return builderNewBuilder;
    }

    public static final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.Builder writeProperty(kotlin.reflect.jvm.internal.impl.km.internal.WriteContext writeContext, kotlin.reflect.jvm.internal.impl.km.KmProperty kmProperty) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(writeContext, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmProperty, "kmProperty");
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.Builder builderNewBuilder = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.newBuilder();
        java.util.Iterator<T> it = kmProperty.getTypeParameters().iterator();
        while (it.hasNext()) {
            builderNewBuilder.addTypeParameter(writeTypeParameter(writeContext, (kotlin.reflect.jvm.internal.impl.km.KmTypeParameter) it.next()).build());
        }
        kotlin.reflect.jvm.internal.impl.km.KmType receiverParameterType = kmProperty.getReceiverParameterType();
        if (receiverParameterType != null) {
            builderNewBuilder.setReceiverType(writeType(writeContext, receiverParameterType).build());
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmType> contextReceiverTypes = kmProperty.getContextReceiverTypes();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(contextReceiverTypes, 10));
        java.util.Iterator<T> it2 = contextReceiverTypes.iterator();
        while (it2.hasNext()) {
            arrayList.add(writeType(writeContext, (kotlin.reflect.jvm.internal.impl.km.KmType) it2.next()).build());
        }
        builderNewBuilder.addAllContextReceiverType(arrayList);
        kotlin.reflect.jvm.internal.impl.km.KmValueParameter setterParameter = kmProperty.getSetterParameter();
        if (setterParameter != null) {
            builderNewBuilder.setSetterValueParameter(writeValueParameter(writeContext, setterParameter).build());
        }
        builderNewBuilder.setReturnType(writeType(writeContext, kmProperty.getReturnType()).build());
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement> versionRequirements = kmProperty.getVersionRequirements();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.Iterator<T> it3 = versionRequirements.iterator();
        while (it3.hasNext()) {
            java.lang.Integer numWriteVersionRequirement = writeVersionRequirement(writeContext, (kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement) it3.next());
            if (numWriteVersionRequirement != null) {
                arrayList2.add(numWriteVersionRequirement);
            }
        }
        builderNewBuilder.addAllVersionRequirement(arrayList2);
        for (kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions metadataExtensions : writeContext.getExtensions$kotlin_metadata()) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(builderNewBuilder);
            metadataExtensions.writePropertyExtensions(kmProperty, builderNewBuilder, writeContext);
        }
        builderNewBuilder.setName(writeContext.get(kmProperty.getName()));
        int flags$kotlin_metadata = kmProperty.getFlags$kotlin_metadata() | kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS.toFlags(java.lang.Boolean.valueOf(!kmProperty.getAnnotations().isEmpty()));
        if (flags$kotlin_metadata != kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.getDefaultInstance().getFlags()) {
            builderNewBuilder.setFlags(flags$kotlin_metadata);
        }
        builderNewBuilder.setGetterFlags(kmProperty.getGetter().getFlags$kotlin_metadata() | kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS.toFlags(java.lang.Boolean.valueOf(!kmProperty.getGetter().getAnnotations().isEmpty())));
        kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes setter = kmProperty.getSetter();
        if (setter != null) {
            builderNewBuilder.setSetterFlags(kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS.toFlags(java.lang.Boolean.valueOf(!setter.getAnnotations().isEmpty())) | setter.getFlags$kotlin_metadata());
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(builderNewBuilder);
        return builderNewBuilder;
    }

    private static final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter.Builder writeValueParameter(kotlin.reflect.jvm.internal.impl.km.internal.WriteContext writeContext, kotlin.reflect.jvm.internal.impl.km.KmValueParameter kmValueParameter) {
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter.Builder builderNewBuilder = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter.newBuilder();
        builderNewBuilder.setType(writeType(writeContext, kmValueParameter.getType()).build());
        kotlin.reflect.jvm.internal.impl.km.KmType varargElementType = kmValueParameter.getVarargElementType();
        if (varargElementType != null) {
            builderNewBuilder.setVarargElementType(writeType(writeContext, varargElementType).build());
        }
        kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument annotationParameterDefaultValue = kmValueParameter.getAnnotationParameterDefaultValue();
        if (annotationParameterDefaultValue != null) {
            builderNewBuilder.setAnnotationParameterDefaultValue(kotlin.reflect.jvm.internal.impl.km.internal.WriteUtilsKt.writeAnnotationArgument(annotationParameterDefaultValue, writeContext.getStrings()).build());
        }
        for (kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions metadataExtensions : writeContext.getExtensions$kotlin_metadata()) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(builderNewBuilder);
            metadataExtensions.writeValueParameterExtensions(kmValueParameter, builderNewBuilder, writeContext);
        }
        int flags$kotlin_metadata = kmValueParameter.getFlags$kotlin_metadata() | kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS.toFlags(java.lang.Boolean.valueOf(!kmValueParameter.getAnnotations().isEmpty()));
        if (flags$kotlin_metadata != kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter.getDefaultInstance().getFlags()) {
            builderNewBuilder.setFlags(flags$kotlin_metadata);
        }
        builderNewBuilder.setName(writeContext.get(kmValueParameter.getName()));
        kotlin.jvm.internal.Intrinsics.checkNotNull(builderNewBuilder);
        return builderNewBuilder;
    }

    private static final java.lang.Integer writeVersionRequirement(kotlin.reflect.jvm.internal.impl.km.internal.WriteContext writeContext, kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement kmVersionRequirement) {
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.VersionKind versionKind;
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.Level level;
        kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind kind = kmVersionRequirement.getKind();
        kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel level2 = kmVersionRequirement.getLevel();
        java.lang.Integer errorCode = kmVersionRequirement.getErrorCode();
        java.lang.String message = kmVersionRequirement.getMessage();
        final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.Builder builderNewBuilder = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.newBuilder();
        int i = kotlin.reflect.jvm.internal.impl.km.internal.WritersKt.WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
        if (i == 1) {
            versionKind = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.VersionKind.LANGUAGE_VERSION;
        } else if (i == 2) {
            versionKind = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.VersionKind.COMPILER_VERSION;
        } else {
            if (i != 3) {
                if (i == 4) {
                    return null;
                }
                throw new kotlin.NoWhenBranchMatchedException();
            }
            versionKind = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.VersionKind.API_VERSION;
        }
        if (versionKind != builderNewBuilder.getDefaultInstanceForType().getVersionKind()) {
            builderNewBuilder.setVersionKind(versionKind);
        }
        int i2 = kotlin.reflect.jvm.internal.impl.km.internal.WritersKt.WhenMappings.$EnumSwitchMapping$1[level2.ordinal()];
        if (i2 == 1) {
            level = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.Level.WARNING;
        } else if (i2 == 2) {
            level = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.Level.ERROR;
        } else {
            if (i2 != 3) {
                throw new kotlin.NoWhenBranchMatchedException();
            }
            level = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.Level.HIDDEN;
        }
        if (level != builderNewBuilder.getDefaultInstanceForType().getLevel()) {
            builderNewBuilder.setLevel(level);
        }
        if (errorCode != null) {
            builderNewBuilder.setErrorCode(errorCode.intValue());
        }
        if (message != null) {
            builderNewBuilder.setMessage(writeContext.get(message));
        }
        kotlin.reflect.jvm.internal.impl.km.KmVersion version = kmVersionRequirement.getVersion();
        new kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version(version.component1(), version.component2(), version.component3()).encode(new kotlin.jvm.functions.Function1(builderNewBuilder) { // from class: kotlin.reflect.jvm.internal.impl.km.internal.WritersKt$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.Builder arg$0;

            {
                this.arg$0 = builderNewBuilder;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.km.internal.WritersKt.writeVersionRequirement$lambda$32(this.arg$0, ((java.lang.Number) obj).intValue());
            }
        }, new kotlin.jvm.functions.Function1(builderNewBuilder) { // from class: kotlin.reflect.jvm.internal.impl.km.internal.WritersKt$$Lambda$1
            private final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.Builder arg$0;

            {
                this.arg$0 = builderNewBuilder;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.km.internal.WritersKt.writeVersionRequirement$lambda$33(this.arg$0, ((java.lang.Number) obj).intValue());
            }
        });
        kotlin.reflect.jvm.internal.impl.metadata.serialization.MutableVersionRequirementTable versionRequirements$kotlin_metadata = writeContext.getVersionRequirements$kotlin_metadata();
        kotlin.jvm.internal.Intrinsics.checkNotNull(builderNewBuilder);
        return java.lang.Integer.valueOf(versionRequirements$kotlin_metadata.get(builderNewBuilder));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit writeVersionRequirement$lambda$32(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.Builder builder, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNull(builder);
        builder.setVersion(i);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit writeVersionRequirement$lambda$33(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.Builder builder, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNull(builder);
        builder.setVersionFull(i);
        return kotlin.Unit.INSTANCE;
    }
}
