package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

/* JADX INFO: compiled from: JvmMetadataExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmMetadataExtensions implements kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions {
    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmEnumEntryExtension createEnumEntryExtension() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeAliasExtension createTypeAliasExtension() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmValueParameterExtension createValueParameterExtension() {
        return null;
    }

    public void readModuleFragmentExtensions(kotlin.reflect.jvm.internal.impl.km.internal.common.KmModuleFragment kmModuleFragment, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment proto, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmModuleFragment, "kmModuleFragment");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readTypeAliasExtensions(kotlin.reflect.jvm.internal.impl.km.KmTypeAlias kmTypeAlias, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias proto, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmTypeAlias, "kmTypeAlias");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
    }

    public void writeModuleFragmentExtensions(kotlin.reflect.jvm.internal.impl.km.internal.common.KmModuleFragment kmModuleFragment, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment.Builder proto, kotlin.reflect.jvm.internal.impl.km.internal.WriteContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmModuleFragment, "kmModuleFragment");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
    }

    public void writeTypeAliasExtensions(kotlin.reflect.jvm.internal.impl.km.KmTypeAlias typeAlias, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias.Builder proto, kotlin.reflect.jvm.internal.impl.km.internal.WriteContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeAlias, "typeAlias");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readClassExtensions(kotlin.reflect.jvm.internal.impl.km.KmClass kmClass, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class proto, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext c) {
        java.lang.String str;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmClass, "kmClass");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmClassExtension jvm = kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmExtensionNodesKt.getJvm(kmClass);
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation> annotationList = proto.getAnnotationList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(annotationList, "getAnnotationList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations = kmClass.getAnnotations();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation annotation : annotationList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(annotation);
            annotations.add(kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt.readAnnotation(annotation, c.getStrings()));
        }
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class r5 = proto;
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class, java.lang.Integer> anonymousObjectOriginName = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.anonymousObjectOriginName;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(anonymousObjectOriginName, "anonymousObjectOriginName");
        java.lang.Integer num = (java.lang.Integer) kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt.getExtensionOrNull(r5, anonymousObjectOriginName);
        if (num != null) {
            jvm.setAnonymousObjectOriginName(c.get(num.intValue()));
        }
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property : (java.util.List) proto.getExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.classLocalVariable)) {
            java.util.List<kotlin.reflect.jvm.internal.impl.km.KmProperty> localDelegatedProperties = jvm.getLocalDelegatedProperties();
            kotlin.jvm.internal.Intrinsics.checkNotNull(property);
            localDelegatedProperties.add(kotlin.reflect.jvm.internal.impl.km.internal.ReadersKt.toKmProperty(property, c));
        }
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class, java.lang.Integer> classModuleName = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.classModuleName;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(classModuleName, "classModuleName");
        java.lang.Integer num2 = (java.lang.Integer) kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt.getExtensionOrNull(r5, classModuleName);
        if (num2 == null || (str = c.get(num2.intValue())) == null) {
            str = "main";
        }
        jvm.setModuleName(str);
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class, java.lang.Integer> jvmClassFlags = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.jvmClassFlags;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(jvmClassFlags, "jvmClassFlags");
        java.lang.Integer num3 = (java.lang.Integer) kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt.getExtensionOrNull(r5, jvmClassFlags);
        if (num3 != null) {
            jvm.setJvmFlags(num3.intValue());
        }
    }

    public void readPackageExtensions(kotlin.reflect.jvm.internal.impl.km.KmPackage kmPackage, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package proto, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext c) {
        java.lang.String str;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmPackage, "kmPackage");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmPackageExtension jvm = kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmExtensionNodesKt.getJvm(kmPackage);
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property : (java.util.List) proto.getExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.packageLocalVariable)) {
            java.util.List<kotlin.reflect.jvm.internal.impl.km.KmProperty> localDelegatedProperties = jvm.getLocalDelegatedProperties();
            kotlin.jvm.internal.Intrinsics.checkNotNull(property);
            localDelegatedProperties.add(kotlin.reflect.jvm.internal.impl.km.internal.ReadersKt.toKmProperty(property, c));
        }
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package, java.lang.Integer> packageModuleName = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.packageModuleName;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(packageModuleName, "packageModuleName");
        java.lang.Integer num = (java.lang.Integer) kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt.getExtensionOrNull(proto, packageModuleName);
        if (num == null || (str = c.get(num.intValue())) == null) {
            str = "main";
        }
        jvm.setModuleName(str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readFunctionExtensions(kotlin.reflect.jvm.internal.impl.km.KmFunction kmFunction, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function proto, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmFunction, "kmFunction");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmFunctionExtension jvm = kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmExtensionNodesKt.getJvm(kmFunction);
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation> annotationList = proto.getAnnotationList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(annotationList, "getAnnotationList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations = kmFunction.getAnnotations();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation annotation : annotationList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(annotation);
            annotations.add(kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt.readAnnotation(annotation, c.getStrings()));
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation> extensionReceiverAnnotationList = proto.getExtensionReceiverAnnotationList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(extensionReceiverAnnotationList, "getExtensionReceiverAnnotationList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> extensionReceiverParameterAnnotations = kmFunction.getExtensionReceiverParameterAnnotations();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation annotation2 : extensionReceiverAnnotationList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(annotation2);
            extensionReceiverParameterAnnotations.add(kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt.readAnnotation(annotation2, c.getStrings()));
        }
        kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method jvmMethodSignature = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.INSTANCE.getJvmMethodSignature(proto, c.getStrings(), c.getTypes());
        jvm.setSignature(jvmMethodSignature != null ? kotlin.reflect.jvm.internal.impl.km.jvm.JvmMemberSignatureKt.wrapAsPublic(jvmMethodSignature) : null);
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function, java.lang.Integer> lambdaClassOriginName = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.lambdaClassOriginName;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lambdaClassOriginName, "lambdaClassOriginName");
        java.lang.Integer num = (java.lang.Integer) kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt.getExtensionOrNull(proto, lambdaClassOriginName);
        if (num != null) {
            jvm.setLambdaClassOriginName(c.get(num.intValue()));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readPropertyExtensions(kotlin.reflect.jvm.internal.impl.km.KmProperty kmProperty, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property proto, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmProperty, "kmProperty");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmPropertyExtension jvm = kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmExtensionNodesKt.getJvm(kmProperty);
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation> annotationList = proto.getAnnotationList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(annotationList, "getAnnotationList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations = kmProperty.getAnnotations();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation annotation : annotationList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(annotation);
            annotations.add(kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt.readAnnotation(annotation, c.getStrings()));
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation> getterAnnotationList = proto.getGetterAnnotationList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(getterAnnotationList, "getGetterAnnotationList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations2 = kmProperty.getGetter().getAnnotations();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation annotation2 : getterAnnotationList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(annotation2);
            annotations2.add(kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt.readAnnotation(annotation2, c.getStrings()));
        }
        kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes setter = kmProperty.getSetter();
        if (setter != null) {
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation> setterAnnotationList = proto.getSetterAnnotationList();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(setterAnnotationList, "getSetterAnnotationList(...)");
            java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations3 = setter.getAnnotations();
            for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation annotation3 : setterAnnotationList) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(annotation3);
                annotations3.add(kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt.readAnnotation(annotation3, c.getStrings()));
            }
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation> extensionReceiverAnnotationList = proto.getExtensionReceiverAnnotationList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(extensionReceiverAnnotationList, "getExtensionReceiverAnnotationList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> extensionReceiverParameterAnnotations = kmProperty.getExtensionReceiverParameterAnnotations();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation annotation4 : extensionReceiverAnnotationList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(annotation4);
            extensionReceiverParameterAnnotations.add(kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt.readAnnotation(annotation4, c.getStrings()));
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation> backingFieldAnnotationList = proto.getBackingFieldAnnotationList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(backingFieldAnnotationList, "getBackingFieldAnnotationList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> backingFieldAnnotations = kmProperty.getBackingFieldAnnotations();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation annotation5 : backingFieldAnnotationList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(annotation5);
            backingFieldAnnotations.add(kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt.readAnnotation(annotation5, c.getStrings()));
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation> delegateFieldAnnotationList = proto.getDelegateFieldAnnotationList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(delegateFieldAnnotationList, "getDelegateFieldAnnotationList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> delegateFieldAnnotations = kmProperty.getDelegateFieldAnnotations();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation annotation6 : delegateFieldAnnotationList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(annotation6);
            delegateFieldAnnotations.add(kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt.readAnnotation(annotation6, c.getStrings()));
        }
        kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Field jvmFieldSignature$default = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.getJvmFieldSignature$default(kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.INSTANCE, proto, c.getStrings(), c.getTypes(), false, 8, null);
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature> propertySignature = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.propertySignature;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertySignature, "propertySignature");
        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature) kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt.getExtensionOrNull(proto, propertySignature);
        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature getter = (jvmPropertySignature == null || !jvmPropertySignature.hasGetter()) ? null : jvmPropertySignature.getGetter();
        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature setter2 = (jvmPropertySignature == null || !jvmPropertySignature.hasSetter()) ? null : jvmPropertySignature.getSetter();
        java.lang.Object extension = proto.getExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.flags);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(extension, "getExtension(...)");
        jvm.setJvmFlags(((java.lang.Number) extension).intValue());
        jvm.setFieldSignature(jvmFieldSignature$default != null ? kotlin.reflect.jvm.internal.impl.km.jvm.JvmMemberSignatureKt.wrapAsPublic(jvmFieldSignature$default) : null);
        jvm.setGetterSignature(getter != null ? new kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature(c.get(getter.getName()), c.get(getter.getDesc())) : null);
        jvm.setSetterSignature(setter2 != null ? new kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature(c.get(setter2.getName()), c.get(setter2.getDesc())) : null);
        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature syntheticMethod = (jvmPropertySignature == null || !jvmPropertySignature.hasSyntheticMethod()) ? null : jvmPropertySignature.getSyntheticMethod();
        jvm.setSyntheticMethodForAnnotations(syntheticMethod != null ? new kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature(c.get(syntheticMethod.getName()), c.get(syntheticMethod.getDesc())) : null);
        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature delegateMethod = (jvmPropertySignature == null || !jvmPropertySignature.hasDelegateMethod()) ? null : jvmPropertySignature.getDelegateMethod();
        jvm.setSyntheticMethodForDelegate(delegateMethod != null ? new kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature(c.get(delegateMethod.getName()), c.get(delegateMethod.getDesc())) : null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readConstructorExtensions(kotlin.reflect.jvm.internal.impl.km.KmConstructor kmConstructor, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor proto, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmConstructor, "kmConstructor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmConstructorExtension jvm = kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmExtensionNodesKt.getJvm(kmConstructor);
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation> annotationList = proto.getAnnotationList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(annotationList, "getAnnotationList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations = kmConstructor.getAnnotations();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation annotation : annotationList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(annotation);
            annotations.add(kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt.readAnnotation(annotation, c.getStrings()));
        }
        kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method jvmConstructorSignature = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.INSTANCE.getJvmConstructorSignature(proto, c.getStrings(), c.getTypes());
        jvm.setSignature(jvmConstructorSignature != null ? kotlin.reflect.jvm.internal.impl.km.jvm.JvmMemberSignatureKt.wrapAsPublic(jvmConstructorSignature) : null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readTypeParameterExtensions(kotlin.reflect.jvm.internal.impl.km.KmTypeParameter kmTypeParameter, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter proto, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmTypeParameter, "kmTypeParameter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmTypeParameterExtension jvm = kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmExtensionNodesKt.getJvm(kmTypeParameter);
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation annotation : (java.util.List) proto.getExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.typeParameterAnnotation)) {
            java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations = jvm.getAnnotations();
            kotlin.jvm.internal.Intrinsics.checkNotNull(annotation);
            annotations.add(kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt.readAnnotation(annotation, c.getStrings()));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readEnumEntryExtensions(kotlin.reflect.jvm.internal.impl.km.KmEnumEntry kmEnumEntry, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry proto, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmEnumEntry, "kmEnumEntry");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation annotation : proto.getAnnotationList()) {
            java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations = kmEnumEntry.getAnnotations();
            kotlin.jvm.internal.Intrinsics.checkNotNull(annotation);
            annotations.add(kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt.readAnnotation(annotation, c.getStrings()));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readTypeExtensions(kotlin.reflect.jvm.internal.impl.km.KmType kmType, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type proto, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmType, "kmType");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmTypeExtension jvm = kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmExtensionNodesKt.getJvm(kmType);
        java.lang.Object extension = proto.getExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.isRaw);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(extension, "getExtension(...)");
        jvm.setRaw(((java.lang.Boolean) extension).booleanValue());
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation annotation : (java.util.List) proto.getExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.typeAnnotation)) {
            java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations = jvm.getAnnotations();
            kotlin.jvm.internal.Intrinsics.checkNotNull(annotation);
            annotations.add(kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt.readAnnotation(annotation, c.getStrings()));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void readValueParameterExtensions(kotlin.reflect.jvm.internal.impl.km.KmValueParameter kmValueParameter, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter proto, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmValueParameter, "kmValueParameter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation> annotationList = proto.getAnnotationList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(annotationList, "getAnnotationList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations = kmValueParameter.getAnnotations();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation annotation : annotationList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(annotation);
            annotations.add(kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt.readAnnotation(annotation, c.getStrings()));
        }
    }

    public void writeClassExtensions(kotlin.reflect.jvm.internal.impl.km.KmClass kmClass, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Builder proto, kotlin.reflect.jvm.internal.impl.km.internal.WriteContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmClass, "kmClass");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmClassExtension jvm = kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmExtensionNodesKt.getJvm(kmClass);
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations = kmClass.getAnnotations();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(annotations, 10));
        java.util.Iterator<T> it = annotations.iterator();
        while (it.hasNext()) {
            arrayList.add(kotlin.reflect.jvm.internal.impl.km.internal.WriteUtilsKt.writeAnnotation((kotlin.reflect.jvm.internal.impl.km.KmAnnotation) it.next(), c.getStrings()).build());
        }
        proto.addAllAnnotation(arrayList);
        java.lang.String anonymousObjectOriginName = jvm.getAnonymousObjectOriginName();
        if (anonymousObjectOriginName != null) {
            proto.setExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.anonymousObjectOriginName, java.lang.Integer.valueOf(c.get(anonymousObjectOriginName)));
        }
        java.util.Iterator<T> it2 = jvm.getLocalDelegatedProperties().iterator();
        while (it2.hasNext()) {
            proto.addExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.classLocalVariable, kotlin.reflect.jvm.internal.impl.km.internal.WritersKt.writeProperty(c, (kotlin.reflect.jvm.internal.impl.km.KmProperty) it2.next()).build());
        }
        java.lang.String moduleName = jvm.getModuleName();
        if (moduleName != null && !kotlin.jvm.internal.Intrinsics.areEqual(moduleName, "main")) {
            proto.setExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.classModuleName, java.lang.Integer.valueOf(c.get(moduleName)));
        }
        if (jvm.getJvmFlags() != 0) {
            proto.setExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.jvmClassFlags, java.lang.Integer.valueOf(jvm.getJvmFlags()));
        }
    }

    public void writePackageExtensions(kotlin.reflect.jvm.internal.impl.km.KmPackage kmPackage, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package.Builder proto, kotlin.reflect.jvm.internal.impl.km.internal.WriteContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmPackage, "kmPackage");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmPackageExtension jvm = kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmExtensionNodesKt.getJvm(kmPackage);
        java.util.Iterator<T> it = jvm.getLocalDelegatedProperties().iterator();
        while (it.hasNext()) {
            proto.addExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.packageLocalVariable, kotlin.reflect.jvm.internal.impl.km.internal.WritersKt.writeProperty(c, (kotlin.reflect.jvm.internal.impl.km.KmProperty) it.next()).build());
        }
        java.lang.String moduleName = jvm.getModuleName();
        if (moduleName == null || kotlin.jvm.internal.Intrinsics.areEqual(moduleName, "main")) {
            return;
        }
        proto.setExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.packageModuleName, java.lang.Integer.valueOf(c.get(moduleName)));
    }

    public void writeFunctionExtensions(kotlin.reflect.jvm.internal.impl.km.KmFunction kmFunction, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.Builder proto, kotlin.reflect.jvm.internal.impl.km.internal.WriteContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmFunction, "kmFunction");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmFunctionExtension jvm = kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmExtensionNodesKt.getJvm(kmFunction);
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations = kmFunction.getAnnotations();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(annotations, 10));
        java.util.Iterator<T> it = annotations.iterator();
        while (it.hasNext()) {
            arrayList.add(kotlin.reflect.jvm.internal.impl.km.internal.WriteUtilsKt.writeAnnotation((kotlin.reflect.jvm.internal.impl.km.KmAnnotation) it.next(), c.getStrings()).build());
        }
        proto.addAllAnnotation(arrayList);
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> extensionReceiverParameterAnnotations = kmFunction.getExtensionReceiverParameterAnnotations();
        java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(extensionReceiverParameterAnnotations, 10));
        java.util.Iterator<T> it2 = extensionReceiverParameterAnnotations.iterator();
        while (it2.hasNext()) {
            arrayList2.add(kotlin.reflect.jvm.internal.impl.km.internal.WriteUtilsKt.writeAnnotation((kotlin.reflect.jvm.internal.impl.km.KmAnnotation) it2.next(), c.getStrings()).build());
        }
        proto.addAllExtensionReceiverAnnotation(arrayList2);
        kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature signature = jvm.getSignature();
        if (signature != null) {
            proto.setExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.methodSignature, toJvmMethodSignature(signature, c));
        }
        java.lang.String lambdaClassOriginName = jvm.getLambdaClassOriginName();
        if (lambdaClassOriginName != null) {
            proto.setExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.lambdaClassOriginName, java.lang.Integer.valueOf(c.get(lambdaClassOriginName)));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void writePropertyExtensions(kotlin.reflect.jvm.internal.impl.km.KmProperty kmProperty, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.Builder proto, kotlin.reflect.jvm.internal.impl.km.internal.WriteContext c) {
        boolean z;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmProperty, "kmProperty");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmPropertyExtension jvm = kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmExtensionNodesKt.getJvm(kmProperty);
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations = kmProperty.getAnnotations();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(annotations, 10));
        java.util.Iterator<T> it = annotations.iterator();
        while (it.hasNext()) {
            arrayList.add(kotlin.reflect.jvm.internal.impl.km.internal.WriteUtilsKt.writeAnnotation((kotlin.reflect.jvm.internal.impl.km.KmAnnotation) it.next(), c.getStrings()).build());
        }
        proto.addAllAnnotation(arrayList);
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations2 = kmProperty.getGetter().getAnnotations();
        java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(annotations2, 10));
        java.util.Iterator<T> it2 = annotations2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(kotlin.reflect.jvm.internal.impl.km.internal.WriteUtilsKt.writeAnnotation((kotlin.reflect.jvm.internal.impl.km.KmAnnotation) it2.next(), c.getStrings()).build());
        }
        proto.addAllGetterAnnotation(arrayList2);
        kotlin.reflect.jvm.internal.impl.km.KmPropertyAccessorAttributes setter = kmProperty.getSetter();
        if (setter != null) {
            java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations3 = setter.getAnnotations();
            java.util.ArrayList arrayList3 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(annotations3, 10));
            java.util.Iterator<T> it3 = annotations3.iterator();
            while (it3.hasNext()) {
                arrayList3.add(kotlin.reflect.jvm.internal.impl.km.internal.WriteUtilsKt.writeAnnotation((kotlin.reflect.jvm.internal.impl.km.KmAnnotation) it3.next(), c.getStrings()).build());
            }
            proto.addAllSetterAnnotation(arrayList3);
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> extensionReceiverParameterAnnotations = kmProperty.getExtensionReceiverParameterAnnotations();
        java.util.ArrayList arrayList4 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(extensionReceiverParameterAnnotations, 10));
        java.util.Iterator<T> it4 = extensionReceiverParameterAnnotations.iterator();
        while (it4.hasNext()) {
            arrayList4.add(kotlin.reflect.jvm.internal.impl.km.internal.WriteUtilsKt.writeAnnotation((kotlin.reflect.jvm.internal.impl.km.KmAnnotation) it4.next(), c.getStrings()).build());
        }
        proto.addAllExtensionReceiverAnnotation(arrayList4);
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> backingFieldAnnotations = kmProperty.getBackingFieldAnnotations();
        java.util.ArrayList arrayList5 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(backingFieldAnnotations, 10));
        java.util.Iterator<T> it5 = backingFieldAnnotations.iterator();
        while (it5.hasNext()) {
            arrayList5.add(kotlin.reflect.jvm.internal.impl.km.internal.WriteUtilsKt.writeAnnotation((kotlin.reflect.jvm.internal.impl.km.KmAnnotation) it5.next(), c.getStrings()).build());
        }
        proto.addAllBackingFieldAnnotation(arrayList5);
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> delegateFieldAnnotations = kmProperty.getDelegateFieldAnnotations();
        java.util.ArrayList arrayList6 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(delegateFieldAnnotations, 10));
        java.util.Iterator<T> it6 = delegateFieldAnnotations.iterator();
        while (it6.hasNext()) {
            arrayList6.add(kotlin.reflect.jvm.internal.impl.km.internal.WriteUtilsKt.writeAnnotation((kotlin.reflect.jvm.internal.impl.km.KmAnnotation) it6.next(), c.getStrings()).build());
        }
        proto.addAllDelegateFieldAnnotation(arrayList6);
        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature.Builder builderNewBuilder = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature.newBuilder();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder(...)");
        boolean z2 = true;
        if (jvm.getFieldSignature() != null) {
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature.Builder builderNewBuilder2 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature.newBuilder();
            kotlin.reflect.jvm.internal.impl.km.jvm.JvmFieldSignature fieldSignature = jvm.getFieldSignature();
            kotlin.jvm.internal.Intrinsics.checkNotNull(fieldSignature);
            builderNewBuilder2.setName(c.get(fieldSignature.getName()));
            kotlin.reflect.jvm.internal.impl.km.jvm.JvmFieldSignature fieldSignature2 = jvm.getFieldSignature();
            kotlin.jvm.internal.Intrinsics.checkNotNull(fieldSignature2);
            builderNewBuilder2.setDesc(c.get(fieldSignature2.getDescriptor()));
            builderNewBuilder.setField(builderNewBuilder2.build());
            z = true;
        } else {
            z = false;
        }
        if (jvm.getGetterSignature() != null) {
            kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature getterSignature = jvm.getGetterSignature();
            kotlin.jvm.internal.Intrinsics.checkNotNull(getterSignature);
            builderNewBuilder.setGetter(toJvmMethodSignature(getterSignature, c));
            z = true;
        }
        if (jvm.getSetterSignature() != null) {
            kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature setterSignature = jvm.getSetterSignature();
            kotlin.jvm.internal.Intrinsics.checkNotNull(setterSignature);
            builderNewBuilder.setSetter(toJvmMethodSignature(setterSignature, c));
        } else {
            z2 = z;
        }
        if (z2 && jvm.getSyntheticMethodForAnnotations() != null) {
            kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature syntheticMethodForAnnotations = jvm.getSyntheticMethodForAnnotations();
            kotlin.jvm.internal.Intrinsics.checkNotNull(syntheticMethodForAnnotations);
            builderNewBuilder.setSyntheticMethod(toJvmMethodSignature(syntheticMethodForAnnotations, c));
        }
        if (z2 && jvm.getSyntheticMethodForDelegate() != null) {
            kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature syntheticMethodForDelegate = jvm.getSyntheticMethodForDelegate();
            kotlin.jvm.internal.Intrinsics.checkNotNull(syntheticMethodForDelegate);
            builderNewBuilder.setDelegateMethod(toJvmMethodSignature(syntheticMethodForDelegate, c));
        }
        int jvmFlags = jvm.getJvmFlags();
        java.lang.Integer num = (java.lang.Integer) kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.getDefaultInstance().getExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.flags);
        if (num == null || jvmFlags != num.intValue()) {
            proto.setExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.flags, java.lang.Integer.valueOf(jvm.getJvmFlags()));
        }
        if (z2) {
            proto.setExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.propertySignature, builderNewBuilder.build());
        }
    }

    public void writeConstructorExtensions(kotlin.reflect.jvm.internal.impl.km.KmConstructor kmConstructor, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor.Builder proto, kotlin.reflect.jvm.internal.impl.km.internal.WriteContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmConstructor, "kmConstructor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmConstructorExtension jvm = kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmExtensionNodesKt.getJvm(kmConstructor);
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations = kmConstructor.getAnnotations();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(annotations, 10));
        java.util.Iterator<T> it = annotations.iterator();
        while (it.hasNext()) {
            arrayList.add(kotlin.reflect.jvm.internal.impl.km.internal.WriteUtilsKt.writeAnnotation((kotlin.reflect.jvm.internal.impl.km.KmAnnotation) it.next(), c.getStrings()).build());
        }
        proto.addAllAnnotation(arrayList);
        kotlin.reflect.jvm.internal.impl.km.jvm.JvmMethodSignature signature = jvm.getSignature();
        if (signature != null) {
            proto.setExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.constructorSignature, toJvmMethodSignature(signature, c));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void writeTypeParameterExtensions(kotlin.reflect.jvm.internal.impl.km.KmTypeParameter kmTypeParameter, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Builder proto, kotlin.reflect.jvm.internal.impl.km.internal.WriteContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmTypeParameter, "kmTypeParameter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        java.util.Iterator<T> it = kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmExtensionNodesKt.getJvm(kmTypeParameter).getAnnotations().iterator();
        while (it.hasNext()) {
            proto.addExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.typeParameterAnnotation, kotlin.reflect.jvm.internal.impl.km.internal.WriteUtilsKt.writeAnnotation((kotlin.reflect.jvm.internal.impl.km.KmAnnotation) it.next(), c.getStrings()).build());
        }
    }

    public void writeEnumEntryExtensions(kotlin.reflect.jvm.internal.impl.km.KmEnumEntry enumEntry, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry.Builder proto, kotlin.reflect.jvm.internal.impl.km.internal.WriteContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(enumEntry, "enumEntry");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        java.util.Iterator<T> it = enumEntry.getAnnotations().iterator();
        while (it.hasNext()) {
            proto.addAnnotation(kotlin.reflect.jvm.internal.impl.km.internal.WriteUtilsKt.writeAnnotation((kotlin.reflect.jvm.internal.impl.km.KmAnnotation) it.next(), c.getStrings()).build());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void writeTypeExtensions(kotlin.reflect.jvm.internal.impl.km.KmType type, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Builder proto, kotlin.reflect.jvm.internal.impl.km.internal.WriteContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(type, "type");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmTypeExtension jvm = kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmExtensionNodesKt.getJvm(type);
        if (jvm.isRaw()) {
            proto.setExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.isRaw, true);
        }
        java.util.Iterator<T> it = jvm.getAnnotations().iterator();
        while (it.hasNext()) {
            proto.addExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.typeAnnotation, kotlin.reflect.jvm.internal.impl.km.internal.WriteUtilsKt.writeAnnotation((kotlin.reflect.jvm.internal.impl.km.KmAnnotation) it.next(), c.getStrings()).build());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public void writeValueParameterExtensions(kotlin.reflect.jvm.internal.impl.km.KmValueParameter valueParameter, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter.Builder proto, kotlin.reflect.jvm.internal.impl.km.internal.WriteContext c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(valueParameter, "valueParameter");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations = valueParameter.getAnnotations();
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(annotations, 10));
        java.util.Iterator<T> it = annotations.iterator();
        while (it.hasNext()) {
            arrayList.add(kotlin.reflect.jvm.internal.impl.km.internal.WriteUtilsKt.writeAnnotation((kotlin.reflect.jvm.internal.impl.km.KmAnnotation) it.next(), c.getStrings()).build());
        }
        proto.addAllAnnotation(arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmClassExtension createClassExtension() {
        return new kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmClassExtension();
    }

    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPackageExtension createPackageExtension() {
        return new kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmPackageExtension();
    }

    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmModuleFragmentExtension createModuleFragmentExtensions() {
        return new kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmModuleFragmentExtension() { // from class: kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmMetadataExtensions.createModuleFragmentExtensions.1
            private final kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType type = new kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType(kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmModuleFragmentExtension.class));

            @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtension
            public kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType getType() {
                return this.type;
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmFunctionExtension createFunctionExtension() {
        return new kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmFunctionExtension();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmPropertyExtension createPropertyExtension() {
        return new kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmPropertyExtension();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmConstructorExtension createConstructorExtension() {
        return new kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmConstructorExtension();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeParameterExtension createTypeParameterExtension() {
        return new kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmTypeParameterExtension();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmTypeExtension createTypeExtension() {
        return new kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmTypeExtension();
    }

    private final kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature toJvmMethodSignature(kotlin.reflect.jvm.internal.impl.km.jvm.JvmMemberSignature jvmMemberSignature, kotlin.reflect.jvm.internal.impl.km.internal.WriteContext writeContext) {
        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.Builder builderNewBuilder = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.newBuilder();
        builderNewBuilder.setName(writeContext.get(jvmMemberSignature.getName()));
        builderNewBuilder.setDesc(writeContext.get(jvmMemberSignature.getDescriptor()));
        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature jvmMethodSignatureBuild = builderNewBuilder.build();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(jvmMethodSignatureBuild, "build(...)");
        return jvmMethodSignatureBuild;
    }
}
