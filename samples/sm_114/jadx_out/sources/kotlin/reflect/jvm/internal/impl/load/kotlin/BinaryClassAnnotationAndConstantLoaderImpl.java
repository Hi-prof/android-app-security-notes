package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BinaryClassAnnotationAndConstantLoaderImpl extends kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor, kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> {
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer annotationDeserializer;
    private kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion metadataVersion;
    private final kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module;
    private final kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses notFoundClasses;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinaryClassAnnotationAndConstantLoaderImpl(kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor module, kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses notFoundClasses, kotlin.reflect.jvm.internal.impl.storage.StorageManager storageManager, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder kotlinClassFinder) {
        super(storageManager, kotlinClassFinder);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(module, "module");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        this.module = module;
        this.notFoundClasses = notFoundClasses;
        this.annotationDeserializer = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer(module, notFoundClasses);
        this.metadataVersion = kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    public kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion getMetadataVersion() {
        return this.metadataVersion;
    }

    public void setMetadataVersion(kotlin.reflect.jvm.internal.impl.metadata.deserialization.MetadataVersion metadataVersion) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(metadataVersion, "<set-?>");
        this.metadataVersion = metadataVersion;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor loadAnnotation(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation proto, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        return this.annotationDeserializer.deserializeAnnotation(proto, nameResolver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    public kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> loadConstant(java.lang.String desc, java.lang.Object initializer) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(desc, "desc");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(initializer, "initializer");
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) "ZBCS", (java.lang.CharSequence) desc, false, 2, (java.lang.Object) null)) {
            int iIntValue = ((java.lang.Integer) initializer).intValue();
            int iHashCode = desc.hashCode();
            if (iHashCode == 66) {
                if (desc.equals("B")) {
                    initializer = java.lang.Byte.valueOf((byte) iIntValue);
                }
                throw new java.lang.AssertionError(desc);
            }
            if (iHashCode == 67) {
                if (desc.equals("C")) {
                    initializer = java.lang.Character.valueOf((char) iIntValue);
                }
                throw new java.lang.AssertionError(desc);
            }
            if (iHashCode == 83) {
                if (desc.equals("S")) {
                    initializer = java.lang.Short.valueOf((short) iIntValue);
                }
                throw new java.lang.AssertionError(desc);
            }
            if (iHashCode == 90 && desc.equals("Z")) {
                initializer = java.lang.Boolean.valueOf(iIntValue != 0);
            }
            throw new java.lang.AssertionError(desc);
        }
        return kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory.INSTANCE.createConstantValue(initializer, this.module);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    public kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> transformToUnsignedConstant(kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> constant) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(constant, "constant");
        if (constant instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue) {
            return new kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue(((kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue) constant).getValue().byteValue());
        }
        if (constant instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue) {
            return new kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue(((kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue) constant).getValue().shortValue());
        }
        if (constant instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue) {
            return new kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue(((kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue) constant).getValue().intValue());
        }
        return constant instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue ? new kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue(((kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue) constant).getValue().longValue()) : constant;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    protected kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(final kotlin.reflect.jvm.internal.impl.name.ClassId annotationClassId, final kotlin.reflect.jvm.internal.impl.descriptors.SourceElement source, final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> result) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(annotationClassId, "annotationClassId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptorResolveClass = resolveClass(annotationClassId);
        return new kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl.loadAnnotation.1
            private final java.util.HashMap<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> arguments;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                this.arguments = new java.util.HashMap<>();
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor
            public void visitConstantValue(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> value) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
                if (name != null) {
                    this.arguments.put(name, value);
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor
            public void visitArrayValue(kotlin.reflect.jvm.internal.impl.name.Name name, java.util.ArrayList<kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> elements) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
                if (name == null) {
                    return;
                }
                kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor annotationParameterByName = kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils.getAnnotationParameterByName(name, classDescriptorResolveClass);
                if (annotationParameterByName != null) {
                    java.util.HashMap<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> map = this.arguments;
                    kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory constantValueFactory = kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory.INSTANCE;
                    java.util.List<? extends kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> listCompact = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compact(elements);
                    kotlin.reflect.jvm.internal.impl.types.KotlinType type = annotationParameterByName.getType();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                    map.put(name, constantValueFactory.createArrayValue(listCompact, type));
                    return;
                }
                if (kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl.this.isImplicitRepeatableContainer(annotationClassId) && kotlin.jvm.internal.Intrinsics.areEqual(name.asString(), "value")) {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    for (java.lang.Object obj : elements) {
                        if (obj instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue) {
                            arrayList.add(obj);
                        }
                    }
                    java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> list = result;
                    java.util.Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        list.add(((kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue) it.next()).getValue());
                    }
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visitEnd() {
                if (kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl.this.isRepeatableWithImplicitContainer(annotationClassId, this.arguments) || kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl.this.isImplicitRepeatableContainer(annotationClassId)) {
                    return;
                }
                result.add(new kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl(classDescriptorResolveClass.getDefaultType(), this.arguments, source));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
    abstract class AbstractAnnotationArgumentVisitor implements kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        public abstract void visitArrayValue(kotlin.reflect.jvm.internal.impl.name.Name name, java.util.ArrayList<kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> arrayList);

        public abstract void visitConstantValue(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> constantValue);

        public AbstractAnnotationArgumentVisitor() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(kotlin.reflect.jvm.internal.impl.name.Name name, java.lang.Object obj) {
            visitConstantValue(name, kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl.this.createConstant(name, obj));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue value) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
            visitConstantValue(name, new kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue(value));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.name.ClassId enumClassId, kotlin.reflect.jvm.internal.impl.name.Name enumEntryName) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(enumClassId, "enumClassId");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(enumEntryName, "enumEntryName");
            visitConstantValue(name, new kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue(enumClassId, enumEntryName));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(kotlin.reflect.jvm.internal.impl.name.Name name) {
            return new kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1(kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl.this, name, this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(final kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
            final java.util.ArrayList arrayList = new java.util.ArrayList();
            kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl = kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl.this;
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement NO_SOURCE = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
            final kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitorLoadAnnotation = binaryClassAnnotationAndConstantLoaderImpl.loadAnnotation(classId, NO_SOURCE, arrayList);
            kotlin.jvm.internal.Intrinsics.checkNotNull(annotationArgumentVisitorLoadAnnotation);
            return new kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor(this, name, arrayList) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitAnnotation$1
                private final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor $$delegate_0;
                final /* synthetic */ java.util.ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> $list;
                final /* synthetic */ kotlin.reflect.jvm.internal.impl.name.Name $name;
                final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor this$0;

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                public void visit(kotlin.reflect.jvm.internal.impl.name.Name name2, java.lang.Object obj) {
                    this.$$delegate_0.visit(name2, obj);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(kotlin.reflect.jvm.internal.impl.name.Name name2, kotlin.reflect.jvm.internal.impl.name.ClassId classId2) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId2, "classId");
                    return this.$$delegate_0.visitAnnotation(name2, classId2);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(kotlin.reflect.jvm.internal.impl.name.Name name2) {
                    return this.$$delegate_0.visitArray(name2);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                public void visitClassLiteral(kotlin.reflect.jvm.internal.impl.name.Name name2, kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue value) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
                    this.$$delegate_0.visitClassLiteral(name2, value);
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                public void visitEnum(kotlin.reflect.jvm.internal.impl.name.Name name2, kotlin.reflect.jvm.internal.impl.name.ClassId enumClassId, kotlin.reflect.jvm.internal.impl.name.Name enumEntryName) {
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(enumClassId, "enumClassId");
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(enumEntryName, "enumEntryName");
                    this.$$delegate_0.visitEnum(name2, enumClassId, enumEntryName);
                }

                {
                    this.this$0 = this;
                    this.$name = name;
                    this.$list = arrayList;
                    this.$$delegate_0 = this.$visitor;
                }

                @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
                public void visitEnd() {
                    this.$visitor.visitEnd();
                    this.this$0.visitConstantValue(this.$name, new kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue((kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor) kotlin.collections.CollectionsKt.single((java.util.List) this.$list)));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> createConstant(kotlin.reflect.jvm.internal.impl.name.Name name, java.lang.Object obj) {
        kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?> constantValueCreateConstantValue = kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory.INSTANCE.createConstantValue(obj, this.module);
        if (constantValueCreateConstantValue != null) {
            return constantValueCreateConstantValue;
        }
        return kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue.Companion.create("Unsupported annotation argument: " + name);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor resolveClass(kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
        return kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, classId, this.notFoundClasses);
    }
}
