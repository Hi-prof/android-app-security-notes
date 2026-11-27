package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1 implements kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {
    final /* synthetic */ kotlin.reflect.jvm.internal.impl.name.Name $name;
    private final java.util.ArrayList<kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> elements = new java.util.ArrayList<>();
    final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl this$0;
    final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor this$1;

    BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1(kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl, kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor abstractAnnotationArgumentVisitor) {
        this.this$0 = binaryClassAnnotationAndConstantLoaderImpl;
        this.$name = name;
        this.this$1 = abstractAnnotationArgumentVisitor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public void visit(java.lang.Object obj) {
        this.elements.add(this.this$0.createConstant(this.$name, obj));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public void visitEnum(kotlin.reflect.jvm.internal.impl.name.ClassId enumClassId, kotlin.reflect.jvm.internal.impl.name.Name enumEntryName) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(enumClassId, "enumClassId");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(enumEntryName, "enumEntryName");
        this.elements.add(new kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue(enumClassId, enumEntryName));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public void visitClassLiteral(kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue value) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        this.elements.add(new kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue(value));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(kotlin.reflect.jvm.internal.impl.name.ClassId classId) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId, "classId");
        final java.util.ArrayList arrayList = new java.util.ArrayList();
        kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl = this.this$0;
        kotlin.reflect.jvm.internal.impl.descriptors.SourceElement NO_SOURCE = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
        final kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitorLoadAnnotation = binaryClassAnnotationAndConstantLoaderImpl.loadAnnotation(classId, NO_SOURCE, arrayList);
        kotlin.jvm.internal.Intrinsics.checkNotNull(annotationArgumentVisitorLoadAnnotation);
        return new kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor(this, arrayList) { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1$visitAnnotation$1
            private final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor $$delegate_0;
            final /* synthetic */ java.util.ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> $list;
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1 this$0;

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visit(kotlin.reflect.jvm.internal.impl.name.Name name, java.lang.Object obj) {
                this.$$delegate_0.visit(name, obj);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.name.ClassId classId2) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classId2, "classId");
                return this.$$delegate_0.visitAnnotation(name, classId2);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(kotlin.reflect.jvm.internal.impl.name.Name name) {
                return this.$$delegate_0.visitArray(name);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visitClassLiteral(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue value) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
                this.$$delegate_0.visitClassLiteral(name, value);
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visitEnum(kotlin.reflect.jvm.internal.impl.name.Name name, kotlin.reflect.jvm.internal.impl.name.ClassId enumClassId, kotlin.reflect.jvm.internal.impl.name.Name enumEntryName) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(enumClassId, "enumClassId");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(enumEntryName, "enumEntryName");
                this.$$delegate_0.visitEnum(name, enumClassId, enumEntryName);
            }

            {
                this.this$0 = this;
                this.$list = arrayList;
                this.$$delegate_0 = this.$visitor;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
            public void visitEnd() {
                this.$visitor.visitEnd();
                this.this$0.elements.add(new kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue((kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor) kotlin.collections.CollectionsKt.single((java.util.List) this.$list)));
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public void visitEnd() {
        this.this$1.visitArrayValue(this.$name, this.elements);
    }
}
