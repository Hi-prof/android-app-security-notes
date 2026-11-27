package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractBinaryClassAnnotationAndConstantLoader<A, C> extends kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader<A, kotlin.reflect.jvm.internal.impl.load.kotlin.AnnotationsContainerWithConstants<? extends A, ? extends C>> implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader<A, C> {
    private final kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull<kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass, kotlin.reflect.jvm.internal.impl.load.kotlin.AnnotationsContainerWithConstants<A, C>> storage;

    protected abstract C loadConstant(java.lang.String str, java.lang.Object obj);

    protected abstract C transformToUnsignedConstant(C c);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractBinaryClassAnnotationAndConstantLoader(kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder kotlinClassFinder) {
        super(kotlinClassFinder);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        this.storage = storageManager.createMemoizedFunction(new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$$Lambda$0
            private final kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.storage$lambda$0(this.arg$0, (kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.load.kotlin.AnnotationsContainerWithConstants storage$lambda$0(kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader abstractBinaryClassAnnotationAndConstantLoader, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass kotlinClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinClass, "kotlinClass");
        return abstractBinaryClassAnnotationAndConstantLoader.loadAnnotationsAndInitializers(kotlinClass);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    public kotlin.reflect.jvm.internal.impl.load.kotlin.AnnotationsContainerWithConstants<A, C> getAnnotationsContainer(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass binaryClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(binaryClass, "binaryClass");
        return this.storage.invoke2(binaryClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public C loadAnnotationDefaultValue(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer container, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property proto, kotlin.reflect.jvm.internal.impl.types.KotlinType expectedType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(expectedType, "expectedType");
        return loadConstantFromProperty(container, proto, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY_GETTER, expectedType, new kotlin.jvm.functions.Function2() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$$Lambda$1
            @Override // kotlin.jvm.functions.Function2
            public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                return kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.loadAnnotationDefaultValue$lambda$1((kotlin.reflect.jvm.internal.impl.load.kotlin.AnnotationsContainerWithConstants) obj, (kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Object loadAnnotationDefaultValue$lambda$1(kotlin.reflect.jvm.internal.impl.load.kotlin.AnnotationsContainerWithConstants loadConstantFromProperty, kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(loadConstantFromProperty, "$this$loadConstantFromProperty");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return loadConstantFromProperty.getAnnotationParametersDefaultValues().get(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Object loadPropertyConstant$lambda$2(kotlin.reflect.jvm.internal.impl.load.kotlin.AnnotationsContainerWithConstants loadConstantFromProperty, kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature it) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(loadConstantFromProperty, "$this$loadConstantFromProperty");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        return loadConstantFromProperty.getPropertyConstants().get(it);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader
    public C loadPropertyConstant(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer container, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property proto, kotlin.reflect.jvm.internal.impl.types.KotlinType expectedType) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(expectedType, "expectedType");
        return loadConstantFromProperty(container, proto, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind.PROPERTY, expectedType, new kotlin.jvm.functions.Function2() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$$Lambda$2
            @Override // kotlin.jvm.functions.Function2
            public java.lang.Object invoke(java.lang.Object obj, java.lang.Object obj2) {
                return kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.loadPropertyConstant$lambda$2((kotlin.reflect.jvm.internal.impl.load.kotlin.AnnotationsContainerWithConstants) obj, (kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature) obj2);
            }
        });
    }

    private final C loadConstantFromProperty(kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer protoContainer, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind annotatedCallableKind, kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinType, kotlin.jvm.functions.Function2<? super kotlin.reflect.jvm.internal.impl.load.kotlin.AnnotationsContainerWithConstants<? extends A, ? extends C>, ? super kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature, ? extends C> function2) {
        C cInvoke;
        kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass kotlinJvmBinaryClassFindClassWithAnnotationsAndInitializers = findClassWithAnnotationsAndInitializers(protoContainer, kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader.Companion.getSpecialCaseContainerClass(protoContainer, true, true, kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_CONST.get(property.getFlags()), kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.isMovedFromInterfaceCompanion(property), getKotlinClassFinder(), getMetadataVersion()));
        if (kotlinJvmBinaryClassFindClassWithAnnotationsAndInitializers == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature callableSignature = getCallableSignature(property, protoContainer.getNameResolver(), protoContainer.getTypeTable(), annotatedCallableKind, kotlinJvmBinaryClassFindClassWithAnnotationsAndInitializers.getClassHeader().getMetadataVersion().isAtLeast(kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver.Companion.getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm()));
        if (callableSignature == null || (cInvoke = function2.invoke(this.storage.invoke2(kotlinJvmBinaryClassFindClassWithAnnotationsAndInitializers), callableSignature)) == null) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes.isUnsignedType(kotlinType) ? transformToUnsignedConstant(cInvoke) : cInvoke;
    }

    private final kotlin.reflect.jvm.internal.impl.load.kotlin.AnnotationsContainerWithConstants<A, C> loadAnnotationsAndInitializers(final kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        final java.util.HashMap map = new java.util.HashMap();
        final java.util.HashMap map2 = new java.util.HashMap();
        final java.util.HashMap map3 = new java.util.HashMap();
        kotlinJvmBinaryClass.visitMembers(new kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor(this) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.loadAnnotationsAndInitializers.1
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader<A, C> this$0;

            {
                this.this$0 = this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor
            public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod(kotlin.reflect.jvm.internal.impl.name.Name name, java.lang.String desc) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(desc, "desc");
                kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion companion = kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion;
                java.lang.String strAsString = name.asString();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
                return new kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.AnonymousClass1.AnnotationVisitorForMethod(this, companion.fromMethodNameAndDesc(strAsString, desc));
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor
            public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor visitField(kotlin.reflect.jvm.internal.impl.name.Name name, java.lang.String desc, java.lang.Object obj) {
                C cLoadConstant;
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(desc, "desc");
                kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion companion = kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion;
                java.lang.String strAsString = name.asString();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
                kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature memberSignatureFromFieldNameAndDesc = companion.fromFieldNameAndDesc(strAsString, desc);
                if (obj != null && (cLoadConstant = this.this$0.loadConstant(desc, obj)) != null) {
                    map2.put(memberSignatureFromFieldNameAndDesc, cLoadConstant);
                }
                return new kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.AnonymousClass1.MemberAnnotationVisitor(this, memberSignatureFromFieldNameAndDesc);
            }

            /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1$AnnotationVisitorForMethod */
            /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
            public final class AnnotationVisitorForMethod extends kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.AnonymousClass1.MemberAnnotationVisitor implements kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MethodAnnotationVisitor {
                final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.AnonymousClass1 this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnnotationVisitorForMethod(kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.AnonymousClass1 anonymousClass1, kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature signature) {
                    super(anonymousClass1, signature);
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(signature, "signature");
                    this.this$0 = anonymousClass1;
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MethodAnnotationVisitor
                public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation(int i, kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
                    kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature memberSignatureFromMethodSignatureAndParameterIndex = kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion.fromMethodSignatureAndParameterIndex(getSignature(), i);
                    java.util.ArrayList arrayList = map.get(memberSignatureFromMethodSignatureAndParameterIndex);
                    if (arrayList == null) {
                        arrayList = new java.util.ArrayList();
                        map.put(memberSignatureFromMethodSignatureAndParameterIndex, arrayList);
                    }
                    return this.this$0.this$0.loadAnnotationIfNotSpecial(classId, source, arrayList);
                }
            }

            /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1$MemberAnnotationVisitor */
            /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
            public class MemberAnnotationVisitor implements kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor {
                private final java.util.ArrayList<A> result;
                private final kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature signature;
                final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.AnonymousClass1 this$0;

                public MemberAnnotationVisitor(kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.AnonymousClass1 anonymousClass1, kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature signature) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(signature, "signature");
                    this.this$0 = anonymousClass1;
                    this.signature = signature;
                    this.result = new java.util.ArrayList<>();
                }

                protected final kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature getSignature() {
                    return this.signature;
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
                public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(kotlin.reflect.jvm.internal.impl.name.ClassId classId, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
                    return this.this$0.this$0.loadAnnotationIfNotSpecial(classId, source, this.result);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor
                public void visitEnd() {
                    if (this.result.isEmpty()) {
                        return;
                    }
                    map.put(this.signature, this.result);
                }
            }
        }, getCachedFileContent(kotlinJvmBinaryClass));
        return new kotlin.reflect.jvm.internal.impl.load.kotlin.AnnotationsContainerWithConstants<>(map, map2, map3);
    }

    protected final boolean isRepeatableWithImplicitContainer(kotlin.reflect.jvm.internal.impl.name.ClassId annotationClassId, java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> arguments) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotationClassId, "annotationClassId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(arguments, "arguments");
        if (!kotlin.jvm.internal.Intrinsics.areEqual(annotationClassId, kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations.INSTANCE.getJAVA_LANG_ANNOTATION_REPEATABLE())) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> constantValue = arguments.get(kotlin.reflect.jvm.internal.impl.name.Name.identifier("value"));
        kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue kClassValue = constantValue instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue ? (kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue) constantValue : null;
        if (kClassValue == null) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value value = kClassValue.getValue();
        kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass normalClass = value instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass ? (kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass) value : null;
        if (normalClass == null) {
            return false;
        }
        return isImplicitRepeatableContainer(normalClass.getClassId());
    }
}
