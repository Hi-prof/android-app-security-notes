package kotlin.reflect.jvm.internal;

/* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u0000 B2\u00020\u0001:\u0004?@ABB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\t2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H&J\"\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0004J\u0016\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dJ\u0016\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dJE\u0010 \u001a\u0004\u0018\u00010!*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u000f\u001a\u00020\u001d2\u0010\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050#2\n\u0010$\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010%\u001a\u00020&H\u0002¢\u0006\u0002\u0010'J=\u0010(\u001a\u0004\u0018\u00010!*\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u000f\u001a\u00020\u001d2\u0010\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050#2\n\u0010$\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002¢\u0006\u0002\u0010)J(\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010+*\u0006\u0012\u0002\b\u00030\u00052\u0010\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050,H\u0002J\u0018\u0010-\u001a\u0004\u0018\u00010!2\u0006\u0010\u000f\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u001dJ \u0010/\u001a\u0004\u0018\u00010!2\u0006\u0010\u000f\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u001d2\u0006\u00100\u001a\u00020&J\u0014\u00101\u001a\b\u0012\u0002\b\u0003\u0018\u00010+2\u0006\u0010.\u001a\u00020\u001dJ\u0014\u00102\u001a\b\u0012\u0002\b\u0003\u0018\u00010+2\u0006\u0010.\u001a\u00020\u001dJ4\u00103\u001a\u0002042\u0010\u00105\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005062\u0010\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050,2\u0006\u00108\u001a\u00020&H\u0002J\u0018\u00109\u001a\u00020:2\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020&H\u0002J$\u0010<\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u0015H\u0002R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006C"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "<init>", "()V", "methodOwner", "Ljava/lang/Class;", "getMethodOwner", "()Ljava/lang/Class;", "constructorDescriptors", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "getProperties", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "name", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "getFunctions", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getLocalProperty", "index", "", "getMembers", "Lkotlin/reflect/jvm/internal/KCallableImpl;", com.taobao.weex.common.Constants.Name.SCOPE, "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "belonginess", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "findPropertyDescriptor", "", "signature", "findFunctionDescriptor", "lookupMethod", "Ljava/lang/reflect/Method;", "parameterTypes", "", "returnType", "isStaticDefault", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "tryGetMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "tryGetConstructor", "Ljava/lang/reflect/Constructor;", "", "findMethodBySignature", "desc", "findDefaultMethod", "isMember", "findConstructorBySignature", "findDefaultConstructor", "addParametersAndMasks", "", "result", "", "valueParameters", "isConstructor", "parseJvmDescriptor", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$FunctionJvmDescriptor;", "parseReturnType", "parseType", "begin", "end", "Data", "MemberBelonginess", "FunctionJvmDescriptor", "Companion", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class KDeclarationContainerImpl implements kotlin.jvm.internal.ClassBasedDeclarationContainer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final kotlin.reflect.jvm.internal.KDeclarationContainerImpl.Companion INSTANCE = new kotlin.reflect.jvm.internal.KDeclarationContainerImpl.Companion(null);
    private static final java.lang.Class<?> DEFAULT_CONSTRUCTOR_MARKER = java.lang.Class.forName("kotlin.jvm.internal.DefaultConstructorMarker");
    private static final kotlin.text.Regex LOCAL_PROPERTY_SIGNATURE = new kotlin.text.Regex("<v#(\\d+)>");

    public abstract java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor> getConstructorDescriptors();

    public abstract java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor> getFunctions(kotlin.reflect.jvm.internal.impl.name.Name name);

    public abstract kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor getLocalProperty(int index);

    public abstract java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> getProperties(kotlin.reflect.jvm.internal.impl.name.Name name);

    /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b¦\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "moduleData", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public abstract class Data {
        static final /* synthetic */ kotlin.reflect.KProperty<java.lang.Object>[] $$delegatedProperties = {kotlin.jvm.internal.Reflection.property1(new kotlin.jvm.internal.PropertyReference1Impl(kotlin.reflect.jvm.internal.KDeclarationContainerImpl.Data.class, "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", 0))};

        /* JADX INFO: renamed from: moduleData$delegate, reason: from kotlin metadata */
        private final kotlin.reflect.jvm.internal.ReflectProperties.LazySoftVal moduleData;

        public Data() {
            this.moduleData = kotlin.reflect.jvm.internal.ReflectProperties.lazySoft(new kotlin.jvm.functions.Function0(kotlin.reflect.jvm.internal.KDeclarationContainerImpl.this) { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$Data$$Lambda$0
                private final kotlin.reflect.jvm.internal.KDeclarationContainerImpl arg$0;

                {
                    this.arg$0 = kDeclarationContainerImpl;
                }

                @Override // kotlin.jvm.functions.Function0
                public java.lang.Object invoke() {
                    return kotlin.reflect.jvm.internal.KDeclarationContainerImpl.Data.moduleData_delegate$lambda$0(this.arg$0);
                }
            });
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData getModuleData() {
            T value = this.moduleData.getValue(this, $$delegatedProperties[0]);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData moduleData_delegate$lambda$0(kotlin.reflect.jvm.internal.KDeclarationContainerImpl kDeclarationContainerImpl) {
            return kotlin.reflect.jvm.internal.ModuleByClassLoaderKt.getOrCreateModule(kDeclarationContainerImpl.getJClass());
        }
    }

    protected java.lang.Class<?> getMethodOwner() {
        java.lang.Class<?> wrapperByPrimitive = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getWrapperByPrimitive(getJClass());
        return wrapperByPrimitive == null ? getJClass() : wrapperByPrimitive;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0055  */
    protected final java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> getMembers(kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope scope, kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess belonginess) {
        kotlin.reflect.jvm.internal.KCallableImpl kCallableImpl;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(scope, "scope");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(belonginess, "belonginess");
        kotlin.reflect.jvm.internal.CreateKCallableVisitor createKCallableVisitor = new kotlin.reflect.jvm.internal.CreateKCallableVisitor(this) { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$getMembers$visitor$1
            {
                super(this);
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
            public kotlin.reflect.jvm.internal.KCallableImpl<?> visitConstructorDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor descriptor, kotlin.Unit data) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
                throw new java.lang.IllegalStateException("No constructors should appear here: " + descriptor);
            }
        };
        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor> contributedDescriptors$default = kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.DefaultImpls.getContributedDescriptors$default(scope, null, null, 3, null);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor declarationDescriptor : contributedDescriptors$default) {
            if (declarationDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) {
                kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor callableMemberDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) declarationDescriptor;
                if (kotlin.jvm.internal.Intrinsics.areEqual(callableMemberDescriptor.getVisibility(), kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.INVISIBLE_FAKE) || !belonginess.accept(callableMemberDescriptor)) {
                    kCallableImpl = null;
                } else {
                    kCallableImpl = (kotlin.reflect.jvm.internal.KCallableImpl) declarationDescriptor.accept(createKCallableVisitor, kotlin.Unit.INSTANCE);
                }
            } else {
                kCallableImpl = null;
            }
            if (kCallableImpl != null) {
                arrayList.add(kCallableImpl);
            }
        }
        return kotlin.collections.CollectionsKt.toList(arrayList);
    }

    /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0084\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tj\u0002\b\u0004j\u0002\b\u0005¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "<init>", "(Ljava/lang/String;I)V", "DECLARED", "INHERITED", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    protected enum MemberBelonginess {
        DECLARED,
        INHERITED;

        private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());

        public final boolean accept(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor member) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(member, "member");
            return member.getKind().isReal() == (this == DECLARED);
        }
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor findPropertyDescriptor(java.lang.String name, java.lang.String signature) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(signature, "signature");
        kotlin.text.MatchResult matchResultMatchEntire = LOCAL_PROPERTY_SIGNATURE.matchEntire(signature);
        if (matchResultMatchEntire != null) {
            java.lang.String str = matchResultMatchEntire.getDestructured().getMatch().getGroupValues().get(1);
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor localProperty = getLocalProperty(java.lang.Integer.parseInt(str));
            if (localProperty != null) {
                return localProperty;
            }
            throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Local property #" + str + " not found in " + getJClass());
        }
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(name);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor> properties = getProperties(nameIdentifier);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : properties) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE.mapPropertySignature((kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) obj).getString(), signature)) {
                arrayList.add(obj);
            }
        }
        java.util.ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Property '" + name + "' (JVM signature: " + signature + ") not resolved in " + this);
        }
        if (arrayList2.size() == 1) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) kotlin.collections.CollectionsKt.single((java.util.List) arrayList2);
        }
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        for (java.lang.Object obj2 : arrayList2) {
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility visibility = ((kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) obj2).getVisibility();
            java.lang.Object obj3 = linkedHashMap.get(visibility);
            if (obj3 == null) {
                obj3 = (java.util.List) new java.util.ArrayList();
                linkedHashMap.put(visibility, obj3);
            }
            ((java.util.List) obj3).add(obj2);
        }
        final kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$0 kDeclarationContainerImpl$$Lambda$0 = new kotlin.jvm.functions.Function2() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$0
            @Override // kotlin.jvm.functions.Function2
            public java.lang.Object invoke(java.lang.Object obj4, java.lang.Object obj5) {
                return java.lang.Integer.valueOf(kotlin.reflect.jvm.internal.KDeclarationContainerImpl.findPropertyDescriptor$lambda$3((kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility) obj4, (kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility) obj5));
            }
        };
        java.util.Collection collectionValues = kotlin.collections.MapsKt.toSortedMap(linkedHashMap, new java.util.Comparator(kDeclarationContainerImpl$$Lambda$0) { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$1
            private final kotlin.jvm.functions.Function2 arg$0;

            {
                this.arg$0 = kDeclarationContainerImpl$$Lambda$0;
            }

            @Override // java.util.Comparator
            public int compare(java.lang.Object obj4, java.lang.Object obj5) {
                return kotlin.reflect.jvm.internal.KDeclarationContainerImpl.findPropertyDescriptor$lambda$4(this.arg$0, obj4, obj5);
            }
        }).values();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        java.util.List list = (java.util.List) kotlin.collections.CollectionsKt.last(collectionValues);
        if (list.size() == 1) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(list);
            return (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) kotlin.collections.CollectionsKt.first(list);
        }
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier2 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(name);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier2, "identifier(...)");
        java.lang.String strJoinToString$default = kotlin.collections.CollectionsKt.joinToString$default(getProperties(nameIdentifier2), "\n", null, null, 0, null, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$2
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj4) {
                return kotlin.reflect.jvm.internal.KDeclarationContainerImpl.findPropertyDescriptor$lambda$5((kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) obj4);
            }
        }, 30, null);
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Property '");
        sb.append(name);
        sb.append("' (JVM signature: ");
        sb.append(signature);
        sb.append(") not resolved in ");
        sb.append(this);
        sb.append(com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE);
        sb.append(strJoinToString$default.length() == 0 ? " no members found" : "\n" + strJoinToString$default);
        throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int findPropertyDescriptor$lambda$4(kotlin.jvm.functions.Function2 function2, java.lang.Object obj, java.lang.Object obj2) {
        return ((java.lang.Number) function2.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int findPropertyDescriptor$lambda$3(kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility descriptorVisibility2) {
        java.lang.Integer numCompare = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.compare(descriptorVisibility, descriptorVisibility2);
        if (numCompare != null) {
            return numCompare.intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.CharSequence findPropertyDescriptor$lambda$5(kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor descriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.DEBUG_TEXT.render(descriptor) + " | " + kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE.mapPropertySignature(descriptor).getString();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x00b5  */
    public final kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor findFunctionDescriptor(java.lang.String name, java.lang.String signature) {
        java.util.List functions;
        java.util.ArrayList arrayList;
        java.lang.String strAsString;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(signature, "signature");
        if (kotlin.jvm.internal.Intrinsics.areEqual(name, "<init>")) {
            functions = kotlin.collections.CollectionsKt.toList(getConstructorDescriptors());
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            for (java.lang.Object obj : functions) {
                kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor constructorDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) obj;
                if (constructorDescriptor.isPrimary()) {
                    kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters containingDeclaration = constructorDescriptor.getContainingDeclaration();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
                    if (kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isMultiFieldValueClass(containingDeclaration)) {
                        java.lang.String strAsString2 = kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE.mapSignature(constructorDescriptor).get_signature();
                        if (!kotlin.text.StringsKt.startsWith$default(strAsString2, "constructor-impl", false, 2, (java.lang.Object) null) || !kotlin.text.StringsKt.endsWith$default(strAsString2, ")V", false, 2, (java.lang.Object) null)) {
                            throw new java.lang.IllegalArgumentException(("Invalid signature of " + constructorDescriptor + ": " + strAsString2).toString());
                        }
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(kotlin.text.StringsKt.removeSuffix(strAsString2, (java.lang.CharSequence) "V"));
                        kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters containingDeclaration2 = constructorDescriptor.getContainingDeclaration();
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "getContainingDeclaration(...)");
                        sb.append(kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.toJvmDescriptor(containingDeclaration2));
                        strAsString = sb.toString();
                    } else {
                        strAsString = kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE.mapSignature(constructorDescriptor).get_signature();
                    }
                } else {
                    strAsString = kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE.mapSignature(constructorDescriptor).get_signature();
                }
                if (kotlin.jvm.internal.Intrinsics.areEqual(strAsString, signature)) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        } else {
            kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(name);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
            functions = getFunctions(nameIdentifier);
            java.util.ArrayList arrayList3 = new java.util.ArrayList();
            for (java.lang.Object obj2 : functions) {
                if (kotlin.jvm.internal.Intrinsics.areEqual(kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE.mapSignature((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) obj2).get_signature(), signature)) {
                    arrayList3.add(obj2);
                }
            }
            arrayList = arrayList3;
        }
        if (arrayList.size() != 1) {
            java.lang.String strJoinToString$default = kotlin.collections.CollectionsKt.joinToString$default(functions, "\n", null, null, 0, null, new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$$Lambda$3
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public java.lang.Object invoke2(java.lang.Object obj3) {
                    return kotlin.reflect.jvm.internal.KDeclarationContainerImpl.findFunctionDescriptor$lambda$9((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) obj3);
                }
            }, 30, null);
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("Function '");
            sb2.append(name);
            sb2.append("' (JVM signature: ");
            sb2.append(signature);
            sb2.append(") not resolved in ");
            sb2.append(this);
            sb2.append(com.taobao.weex.el.parse.Operators.CONDITION_IF_MIDDLE);
            sb2.append(strJoinToString$default.length() == 0 ? " no members found" : "\n" + strJoinToString$default);
            throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError(sb2.toString());
        }
        return (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) kotlin.collections.CollectionsKt.single((java.util.List) arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.CharSequence findFunctionDescriptor$lambda$9(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor descriptor) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.DEBUG_TEXT.render(descriptor) + " | " + kotlin.reflect.jvm.internal.RuntimeTypeMapper.INSTANCE.mapSignature(descriptor).get_signature();
    }

    private final java.lang.reflect.Method lookupMethod(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>[] clsArr, java.lang.Class<?> cls2, boolean z) {
        java.lang.String str2;
        java.lang.Class<?>[] clsArr2;
        java.lang.Class<?> cls3;
        boolean z2;
        if (z) {
            clsArr[0] = cls;
        }
        java.lang.reflect.Method methodTryGetMethod = tryGetMethod(cls, str, clsArr, cls2);
        if (methodTryGetMethod != null) {
            return methodTryGetMethod;
        }
        java.lang.Class<? super java.lang.Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            java.lang.reflect.Method methodLookupMethod = lookupMethod(superclass, str, clsArr, cls2, z);
            str2 = str;
            clsArr2 = clsArr;
            cls3 = cls2;
            z2 = z;
            if (methodLookupMethod != null) {
                return methodLookupMethod;
            }
        } else {
            str2 = str;
            clsArr2 = clsArr;
            cls3 = cls2;
            z2 = z;
        }
        java.util.Iterator it = kotlin.jvm.internal.ArrayIteratorKt.iterator(cls.getInterfaces());
        while (it.hasNext()) {
            java.lang.Class<?> cls4 = (java.lang.Class) it.next();
            kotlin.jvm.internal.Intrinsics.checkNotNull(cls4);
            java.lang.reflect.Method methodLookupMethod2 = lookupMethod(cls4, str2, clsArr2, cls3, z2);
            if (methodLookupMethod2 != null) {
                return methodLookupMethod2;
            }
            if (z2) {
                java.lang.Class<?> clsTryLoadClass = kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt.tryLoadClass(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getSafeClassLoader(cls4), cls4.getName() + "$DefaultImpls");
                if (clsTryLoadClass != null) {
                    clsArr2[0] = cls4;
                    java.lang.reflect.Method methodTryGetMethod2 = tryGetMethod(clsTryLoadClass, str2, clsArr2, cls3);
                    if (methodTryGetMethod2 != null) {
                        return methodTryGetMethod2;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    private final java.lang.reflect.Method tryGetMethod(java.lang.Class<?> cls, java.lang.String str, java.lang.Class<?>[] clsArr, java.lang.Class<?> cls2) {
        java.lang.reflect.Method method;
        try {
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod(str, (java.lang.Class[]) java.util.Arrays.copyOf(clsArr, clsArr.length));
            if (kotlin.jvm.internal.Intrinsics.areEqual(declaredMethod.getReturnType(), cls2)) {
                return declaredMethod;
            }
            java.lang.reflect.Method[] declaredMethods = cls.getDeclaredMethods();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            java.lang.reflect.Method[] methodArr = declaredMethods;
            int length = methodArr.length;
            for (int i = 0; i < length; i++) {
                method = methodArr[i];
                java.lang.reflect.Method method2 = method;
                if (kotlin.jvm.internal.Intrinsics.areEqual(method2.getName(), str) && kotlin.jvm.internal.Intrinsics.areEqual(method2.getReturnType(), cls2) && java.util.Arrays.equals(method2.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
            method = null;
            return method;
        } catch (java.lang.NoSuchMethodException unused) {
            return null;
        }
    }

    private final java.lang.reflect.Constructor<?> tryGetConstructor(java.lang.Class<?> cls, java.util.List<? extends java.lang.Class<?>> list) {
        try {
            java.lang.Class[] clsArr = (java.lang.Class[]) list.toArray(new java.lang.Class[0]);
            return cls.getDeclaredConstructor((java.lang.Class[]) java.util.Arrays.copyOf(clsArr, clsArr.length));
        } catch (java.lang.NoSuchMethodException unused) {
            return null;
        }
    }

    public final java.lang.reflect.Method findMethodBySignature(java.lang.String name, java.lang.String desc) {
        java.lang.reflect.Method methodLookupMethod;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(desc, "desc");
        if (kotlin.jvm.internal.Intrinsics.areEqual(name, "<init>")) {
            return null;
        }
        kotlin.reflect.jvm.internal.KDeclarationContainerImpl.FunctionJvmDescriptor jvmDescriptor = parseJvmDescriptor(desc, true);
        java.lang.Class<?>[] clsArr = (java.lang.Class[]) jvmDescriptor.getParameters().toArray(new java.lang.Class[0]);
        java.lang.Class<?> returnType = jvmDescriptor.getReturnType();
        kotlin.jvm.internal.Intrinsics.checkNotNull(returnType);
        java.lang.reflect.Method methodLookupMethod2 = lookupMethod(getMethodOwner(), name, clsArr, returnType, false);
        if (methodLookupMethod2 != null) {
            return methodLookupMethod2;
        }
        if (!getMethodOwner().isInterface() || (methodLookupMethod = lookupMethod(java.lang.Object.class, name, clsArr, returnType, false)) == null) {
            return null;
        }
        return methodLookupMethod;
    }

    public final java.lang.reflect.Method findDefaultMethod(java.lang.String name, java.lang.String desc, boolean isMember) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(desc, "desc");
        if (kotlin.jvm.internal.Intrinsics.areEqual(name, "<init>")) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (isMember) {
            arrayList.add(getJClass());
        }
        kotlin.reflect.jvm.internal.KDeclarationContainerImpl.FunctionJvmDescriptor jvmDescriptor = parseJvmDescriptor(desc, true);
        addParametersAndMasks(arrayList, jvmDescriptor.getParameters(), false);
        java.lang.Class<?> methodOwner = getMethodOwner();
        java.lang.String str = name + "$default";
        java.lang.Class<?>[] clsArr = (java.lang.Class[]) arrayList.toArray(new java.lang.Class[0]);
        java.lang.Class<?> returnType = jvmDescriptor.getReturnType();
        kotlin.jvm.internal.Intrinsics.checkNotNull(returnType);
        return lookupMethod(methodOwner, str, clsArr, returnType, isMember);
    }

    public final java.lang.reflect.Constructor<?> findConstructorBySignature(java.lang.String desc) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(desc, "desc");
        return tryGetConstructor(getJClass(), parseJvmDescriptor(desc, false).getParameters());
    }

    public final java.lang.reflect.Constructor<?> findDefaultConstructor(java.lang.String desc) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(desc, "desc");
        java.lang.Class<?> jClass = getJClass();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        addParametersAndMasks(arrayList, parseJvmDescriptor(desc, false).getParameters(), true);
        kotlin.Unit unit = kotlin.Unit.INSTANCE;
        return tryGetConstructor(jClass, arrayList);
    }

    private final void addParametersAndMasks(java.util.List<java.lang.Class<?>> result, java.util.List<? extends java.lang.Class<?>> valueParameters, boolean isConstructor) {
        if (kotlin.jvm.internal.Intrinsics.areEqual(kotlin.collections.CollectionsKt.lastOrNull((java.util.List) valueParameters), DEFAULT_CONSTRUCTOR_MARKER)) {
            valueParameters = valueParameters.subList(0, valueParameters.size() - 1);
        }
        result.addAll(valueParameters);
        int size = (valueParameters.size() + 31) / 32;
        for (int i = 0; i < size; i++) {
            java.lang.Class<?> TYPE = java.lang.Integer.TYPE;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
            result.add(TYPE);
        }
        java.lang.Class<?> cls = isConstructor ? DEFAULT_CONSTRUCTOR_MARKER : java.lang.Object.class;
        kotlin.jvm.internal.Intrinsics.checkNotNull(cls);
        result.add(cls);
    }

    /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
    @kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u001b\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$FunctionJvmDescriptor;", "", "parameters", "", "Ljava/lang/Class;", "returnType", "<init>", "(Ljava/util/List;Ljava/lang/Class;)V", "getParameters", "()Ljava/util/List;", "getReturnType", "()Ljava/lang/Class;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class FunctionJvmDescriptor {
        private final java.util.List<java.lang.Class<?>> parameters;
        private final java.lang.Class<?> returnType;

        /* JADX WARN: Multi-variable type inference failed */
        public FunctionJvmDescriptor(java.util.List<? extends java.lang.Class<?>> parameters, java.lang.Class<?> cls) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parameters, "parameters");
            this.parameters = parameters;
            this.returnType = cls;
        }

        public final java.util.List<java.lang.Class<?>> getParameters() {
            return this.parameters;
        }

        public final java.lang.Class<?> getReturnType() {
            return this.returnType;
        }
    }

    private final kotlin.reflect.jvm.internal.KDeclarationContainerImpl.FunctionJvmDescriptor parseJvmDescriptor(java.lang.String desc, boolean parseReturnType) {
        int iIndexOf$default;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = 1;
        while (true) {
            if (desc.charAt(i) != ')') {
                int i2 = i;
                while (desc.charAt(i2) == '[') {
                    i2++;
                }
                char cCharAt = desc.charAt(i2);
                if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) "VZCBSIFJD", cCharAt, false, 2, (java.lang.Object) null)) {
                    iIndexOf$default = i2 + 1;
                } else if (cCharAt == 'L') {
                    iIndexOf$default = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) desc, ';', i, false, 4, (java.lang.Object) null) + 1;
                } else {
                    throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Unknown type prefix in the method signature: " + desc);
                }
                arrayList.add(parseType(desc, i, iIndexOf$default));
                i = iIndexOf$default;
            } else {
                return new kotlin.reflect.jvm.internal.KDeclarationContainerImpl.FunctionJvmDescriptor(arrayList, parseReturnType ? parseType(desc, i + 1, desc.length()) : null);
            }
        }
    }

    private final java.lang.Class<?> parseType(java.lang.String desc, int begin, int end) throws java.lang.ClassNotFoundException {
        char cCharAt = desc.charAt(begin);
        if (cCharAt == 'F') {
            return java.lang.Float.TYPE;
        }
        if (cCharAt == 'L') {
            java.lang.ClassLoader safeClassLoader = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getSafeClassLoader(getJClass());
            java.lang.String strSubstring = desc.substring(begin + 1, end - 1);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            java.lang.Class<?> clsLoadClass = safeClassLoader.loadClass(kotlin.text.StringsKt.replace$default(strSubstring, '/', com.taobao.weex.el.parse.Operators.DOT, false, 4, (java.lang.Object) null));
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(clsLoadClass, "loadClass(...)");
            return clsLoadClass;
        }
        if (cCharAt == 'S') {
            return java.lang.Short.TYPE;
        }
        if (cCharAt == 'V') {
            java.lang.Class<?> TYPE = java.lang.Void.TYPE;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
            return TYPE;
        }
        if (cCharAt == 'I') {
            return java.lang.Integer.TYPE;
        }
        if (cCharAt == 'J') {
            return java.lang.Long.TYPE;
        }
        if (cCharAt == 'Z') {
            return java.lang.Boolean.TYPE;
        }
        if (cCharAt == '[') {
            return kotlin.reflect.jvm.internal.UtilKt.createArrayType(parseType(desc, begin + 1, end));
        }
        switch (cCharAt) {
            case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_BASELINE /* 66 */:
                return java.lang.Byte.TYPE;
            case 'C':
                return java.lang.Character.TYPE;
            case 'D':
                return java.lang.Double.TYPE;
            default:
                throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Unknown type prefix in the method signature: " + desc);
        }
    }

    /* JADX INFO: compiled from: KDeclarationContainerImpl.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Companion;", "", "<init>", "()V", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection", "()Lkotlin/text/Regex;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.text.Regex getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection() {
            return kotlin.reflect.jvm.internal.KDeclarationContainerImpl.LOCAL_PROPERTY_SIGNATURE;
        }
    }
}
