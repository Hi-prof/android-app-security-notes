package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

/* JADX INFO: compiled from: ReflectJavaClass.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReflectJavaClass extends kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement implements kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner, kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass {
    private final java.lang.Class<?> klass;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind getLightClassOriginKind() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean hasDefaultConstructor() {
        return false;
    }

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

    public ReflectJavaClass(java.lang.Class<?> klass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(klass, "klass");
        this.klass = klass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    public java.lang.Class<?> getElement() {
        return this.klass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isStatic() {
        return java.lang.reflect.Modifier.isStatic(getModifiers());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner
    public int getModifiers() {
        return this.klass.getModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isFinal() {
        return java.lang.reflect.Modifier.isFinal(getModifiers());
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

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> getInnerClassNames() {
        java.lang.Class<?>[] declaredClasses = this.klass.getDeclaredClasses();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaredClasses, "getDeclaredClasses(...)");
        return kotlin.sequences.SequencesKt.toList(kotlin.sequences.SequencesKt.mapNotNull(kotlin.sequences.SequencesKt.filterNot(kotlin.collections.ArraysKt.asSequence(declaredClasses), new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass._get_innerClassNames_$lambda$0((java.lang.Class) obj));
            }
        }), new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass._get_innerClassNames_$lambda$2((java.lang.Class) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _get_innerClassNames_$lambda$0(java.lang.Class cls) {
        java.lang.String simpleName = cls.getSimpleName();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        return simpleName.length() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.Name _get_innerClassNames_$lambda$2(java.lang.Class cls) {
        java.lang.String simpleName = cls.getSimpleName();
        if (!kotlin.reflect.jvm.internal.impl.name.Name.isValidIdentifier(simpleName)) {
            simpleName = null;
        }
        if (simpleName != null) {
            return kotlin.reflect.jvm.internal.impl.name.Name.identifier(simpleName);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public kotlin.reflect.jvm.internal.impl.name.FqName getFqName() {
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getClassId(this.klass).asSingleFqName();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass getOuterClass() {
        java.lang.Class<?> declaringClass = this.klass.getDeclaringClass();
        if (declaringClass != null) {
            return new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass(declaringClass);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType> getSupertypes() {
        if (kotlin.jvm.internal.Intrinsics.areEqual(this.klass, java.lang.Object.class)) {
            return kotlin.collections.CollectionsKt.emptyList();
        }
        kotlin.jvm.internal.SpreadBuilder spreadBuilder = new kotlin.jvm.internal.SpreadBuilder(2);
        java.lang.Class genericSuperclass = this.klass.getGenericSuperclass();
        if (genericSuperclass == null) {
        }
        spreadBuilder.add(genericSuperclass);
        spreadBuilder.addSpread(this.klass.getGenericInterfaces());
        java.util.List listListOf = kotlin.collections.CollectionsKt.listOf(spreadBuilder.toArray(new java.lang.reflect.Type[spreadBuilder.size()]));
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(listListOf, 10));
        java.util.Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            arrayList.add(new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClassifierType((java.lang.reflect.Type) it.next()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMethod> getMethods() {
        java.lang.reflect.Method[] declaredMethods = this.klass.getDeclaredMethods();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
        return kotlin.sequences.SequencesKt.toList(kotlin.sequences.SequencesKt.map(kotlin.sequences.SequencesKt.filter(kotlin.collections.ArraysKt.asSequence(declaredMethods), new kotlin.jvm.functions.Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$$Lambda$2
            private final kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass._get_methods_$lambda$7(this.arg$0, (java.lang.reflect.Method) obj));
            }
        }), kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$methods$2.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _get_methods_$lambda$7(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass reflectJavaClass, java.lang.reflect.Method method) {
        if (method.isSynthetic()) {
            return false;
        }
        if (!reflectJavaClass.isEnum()) {
            return true;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(method);
        return !reflectJavaClass.isEnumValuesOrValueOf(method);
    }

    private final boolean isEnumValuesOrValueOf(java.lang.reflect.Method method) {
        java.lang.String name = method.getName();
        if (kotlin.jvm.internal.Intrinsics.areEqual(name, "values")) {
            java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(parameterTypes, "getParameterTypes(...)");
            return parameterTypes.length == 0;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(name, "valueOf")) {
            return java.util.Arrays.equals(method.getParameterTypes(), new java.lang.Class[]{java.lang.String.class});
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaField> getFields() {
        java.lang.reflect.Field[] declaredFields = this.klass.getDeclaredFields();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaredFields, "getDeclaredFields(...)");
        return kotlin.sequences.SequencesKt.toList(kotlin.sequences.SequencesKt.map(kotlin.sequences.SequencesKt.filterNot(kotlin.collections.ArraysKt.asSequence(declaredFields), kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$fields$1.INSTANCE), kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$fields$2.INSTANCE));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaConstructor> getConstructors() {
        java.lang.reflect.Constructor<?>[] declaredConstructors = this.klass.getDeclaredConstructors();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaredConstructors, "getDeclaredConstructors(...)");
        return kotlin.sequences.SequencesKt.toList(kotlin.sequences.SequencesKt.map(kotlin.sequences.SequencesKt.filterNot(kotlin.collections.ArraysKt.asSequence(declaredConstructors), kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$constructors$1.INSTANCE), kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$constructors$2.INSTANCE));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    public kotlin.reflect.jvm.internal.impl.name.Name getName() {
        if (this.klass.isAnonymousClass()) {
            java.lang.String name = this.klass.getName();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(kotlin.text.StringsKt.substringAfterLast$default(name, com.taobao.weex.el.parse.Operators.DOT_STR, (java.lang.String) null, 2, (java.lang.Object) null));
            kotlin.jvm.internal.Intrinsics.checkNotNull(nameIdentifier);
            return nameIdentifier;
        }
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier2 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(this.klass.getSimpleName());
        kotlin.jvm.internal.Intrinsics.checkNotNull(nameIdentifier2);
        return nameIdentifier2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner
    public java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaTypeParameter> getTypeParameters() {
        java.lang.reflect.TypeVariable<java.lang.Class<?>>[] typeParameters = this.klass.getTypeParameters();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
        java.lang.reflect.TypeVariable<java.lang.Class<?>>[] typeVariableArr = typeParameters;
        java.util.ArrayList arrayList = new java.util.ArrayList(typeVariableArr.length);
        for (java.lang.reflect.TypeVariable<java.lang.Class<?>> typeVariable : typeVariableArr) {
            arrayList.add(new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaTypeParameter(typeVariable));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isInterface() {
        return this.klass.isInterface();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isAnnotationType() {
        return this.klass.isAnnotation();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isEnum() {
        return this.klass.isEnum();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isRecord() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        java.lang.Boolean boolLoadIsRecord = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16SealedRecordLoader.INSTANCE.loadIsRecord(this.klass);
        if (boolLoadIsRecord != null) {
            return boolLoadIsRecord.booleanValue();
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent> getRecordComponents() {
        java.lang.Object[] objArrLoadGetRecordComponents = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16SealedRecordLoader.INSTANCE.loadGetRecordComponents(this.klass);
        if (objArrLoadGetRecordComponents == null) {
            objArrLoadGetRecordComponents = new java.lang.Object[0];
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(objArrLoadGetRecordComponents.length);
        for (java.lang.Object obj : objArrLoadGetRecordComponents) {
            arrayList.add(new kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaRecordComponent(obj));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass
    public boolean isSealed() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        java.lang.Boolean boolLoadIsSealed = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java16SealedRecordLoader.INSTANCE.loadIsSealed(this.klass);
        if (boolLoadIsSealed != null) {
            return boolLoadIsSealed.booleanValue();
        }
        return false;
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass) && kotlin.jvm.internal.Intrinsics.areEqual(this.klass, ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass) obj).klass);
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    public java.lang.String toString() {
        return getClass().getName() + ": " + this.klass;
    }
}
