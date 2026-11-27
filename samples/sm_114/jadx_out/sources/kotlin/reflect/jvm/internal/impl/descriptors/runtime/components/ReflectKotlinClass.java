package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

/* JADX INFO: compiled from: ReflectKotlinClass.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectKotlinClass implements kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass {
    public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass.Factory Factory = new kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass.Factory(null);
    private final kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader classHeader;
    private final java.lang.Class<?> klass;

    public /* synthetic */ ReflectKotlinClass(java.lang.Class cls, kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader kotlinClassHeader, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, kotlinClassHeader);
    }

    private ReflectKotlinClass(java.lang.Class<?> cls, kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader kotlinClassHeader) {
        this.klass = cls;
        this.classHeader = kotlinClassHeader;
    }

    public final java.lang.Class<?> getKlass() {
        return this.klass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader getClassHeader() {
        return this.classHeader;
    }

    /* JADX INFO: compiled from: ReflectKotlinClass.kt */
    public static final class Factory {
        public /* synthetic */ Factory(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Factory() {
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass create(java.lang.Class<?> klass) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(klass, "klass");
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor readKotlinClassHeaderAnnotationVisitor = new kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor();
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectClassStructure.INSTANCE.loadClassAnnotations(klass, readKotlinClassHeaderAnnotationVisitor);
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader kotlinClassHeaderCreateHeaderWithDefaultMetadataVersion = readKotlinClassHeaderAnnotationVisitor.createHeaderWithDefaultMetadataVersion();
            kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker = null;
            if (kotlinClassHeaderCreateHeaderWithDefaultMetadataVersion == null) {
                return null;
            }
            return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass(klass, kotlinClassHeaderCreateHeaderWithDefaultMetadataVersion, defaultConstructorMarker);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public java.lang.String getLocation() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String name = this.klass.getName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        sb.append(kotlin.text.StringsKt.replace$default(name, com.taobao.weex.el.parse.Operators.DOT, '/', false, 4, (java.lang.Object) null));
        sb.append(".class");
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public kotlin.reflect.jvm.internal.impl.name.ClassId getClassId() {
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getClassId(this.klass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void loadClassAnnotations(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor visitor, byte[] bArr) throws java.lang.reflect.InvocationTargetException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visitor, "visitor");
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectClassStructure.INSTANCE.loadClassAnnotations(this.klass, visitor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void visitMembers(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor visitor, byte[] bArr) throws java.lang.reflect.InvocationTargetException {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(visitor, "visitor");
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectClassStructure.INSTANCE.visitMembers(this.klass, visitor);
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass) && kotlin.jvm.internal.Intrinsics.areEqual(this.klass, ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass) obj).klass);
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    public java.lang.String toString() {
        return getClass().getName() + ": " + this.klass;
    }
}
