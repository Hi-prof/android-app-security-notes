package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ReflectJavaMember extends kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement implements kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner, kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember {
    public abstract java.lang.reflect.Member getMember();

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation findAnnotation(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        return findAnnotation(fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public /* bridge */ /* synthetic */ java.util.Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation> getAnnotations() {
        java.lang.annotation.Annotation[] declaredAnnotations;
        java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation> annotations;
        java.lang.reflect.AnnotatedElement element = getElement();
        return (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null || (annotations = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwnerKt.getAnnotations(declaredAnnotations)) == null) ? kotlin.collections.CollectionsKt.emptyList() : annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isAbstract() {
        return java.lang.reflect.Modifier.isAbstract(getModifiers());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation findAnnotation(kotlin.reflect.jvm.internal.impl.name.FqName fqName) {
        java.lang.annotation.Annotation[] declaredAnnotations;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fqName, "fqName");
        java.lang.reflect.AnnotatedElement element = getElement();
        if (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwnerKt.findAnnotation(declaredAnnotations, fqName);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isStatic() {
        return java.lang.reflect.Modifier.isStatic(getModifiers());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    public java.lang.reflect.AnnotatedElement getElement() {
        java.lang.reflect.Member member = getMember();
        kotlin.jvm.internal.Intrinsics.checkNotNull(member, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        return (java.lang.reflect.AnnotatedElement) member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner
    public int getModifiers() {
        return getMember().getModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isFinal() {
        return java.lang.reflect.Modifier.isFinal(getModifiers());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    public kotlin.reflect.jvm.internal.impl.name.Name getName() {
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier;
        java.lang.String name = getMember().getName();
        return (name == null || (nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(name)) == null) ? kotlin.reflect.jvm.internal.impl.name.SpecialNames.NO_NAME_PROVIDED : nameIdentifier;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public kotlin.reflect.jvm.internal.impl.descriptors.Visibility getVisibility() {
        int modifiers = getModifiers();
        if (java.lang.reflect.Modifier.isPublic(modifiers)) {
            return kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Public.INSTANCE;
        }
        if (java.lang.reflect.Modifier.isPrivate(modifiers)) {
            return kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Private.INSTANCE;
        }
        if (java.lang.reflect.Modifier.isProtected(modifiers)) {
            return java.lang.reflect.Modifier.isStatic(modifiers) ? kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities.ProtectedStaticVisibility.INSTANCE : kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities.ProtectedAndPackage.INSTANCE;
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities.PackageVisibility.INSTANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember
    public kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass getContainingClass() {
        java.lang.Class<?> declaringClass = getMember().getDeclaringClass();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
        return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass(declaringClass);
    }

    protected final java.util.List<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter> getValueParameters(java.lang.reflect.Type[] parameterTypes, java.lang.annotation.Annotation[][] parameterAnnotations, boolean z) {
        java.lang.String str;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parameterAnnotations, "parameterAnnotations");
        java.util.ArrayList arrayList = new java.util.ArrayList(parameterTypes.length);
        java.util.List<java.lang.String> listLoadParameterNames = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader.INSTANCE.loadParameterNames(getMember());
        int size = listLoadParameterNames != null ? listLoadParameterNames.size() - parameterTypes.length : 0;
        int length = parameterTypes.length;
        int i = 0;
        while (i < length) {
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType reflectJavaTypeCreate = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType.Factory.create(parameterTypes[i]);
            if (listLoadParameterNames != null) {
                str = (java.lang.String) kotlin.collections.CollectionsKt.getOrNull(listLoadParameterNames, i + size);
                if (str == null) {
                    throw new java.lang.IllegalStateException(("No parameter with index " + i + '+' + size + " (name=" + getName() + " type=" + reflectJavaTypeCreate + ") in " + this).toString());
                }
            } else {
                str = null;
            }
            arrayList.add(new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaValueParameter(reflectJavaTypeCreate, parameterAnnotations[i], str, z && i == kotlin.collections.ArraysKt.getLastIndex(parameterTypes)));
            i++;
        }
        return arrayList;
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember) && kotlin.jvm.internal.Intrinsics.areEqual(getMember(), ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember) obj).getMember());
    }

    public int hashCode() {
        return getMember().hashCode();
    }

    public java.lang.String toString() {
        return getClass().getName() + ": " + getMember();
    }
}
