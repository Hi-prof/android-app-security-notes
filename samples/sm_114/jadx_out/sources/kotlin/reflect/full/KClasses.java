package kotlin.reflect.full;

/* JADX INFO: compiled from: KClasses.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0013\u001a\u001c\u0010S\u001a\u00020D*\u0006\u0012\u0002\b\u00030\u00042\n\u0010T\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0007\u001a\u001c\u0010U\u001a\u00020D*\u0006\u0012\u0002\b\u00030\u00042\n\u0010V\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0007\u001a+\u0010W\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\u0010X\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010Y\u001a-\u0010Z\u001a\u0004\u0018\u0001H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\u0010X\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010Y\u001a!\u0010[\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0010\"6\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"(\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\f\"$\u0010\r\u001a\u0004\u0018\u00010\u0003*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010\"\"\u0010\u0011\u001a\u00020\u0012*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015\",\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\u001b\",\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001e\u0010\u001b\",\u0010\u001f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u0006\u001a\u0004\b!\u0010\u001b\",\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0006\u001a\u0004\b$\u0010\u001b\",\u0010%\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0006\u001a\u0004\b'\u0010\u001b\",\u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0006\u001a\u0004\b*\u0010\u001b\",\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0006\u001a\u0004\b-\u0010\u001b\",\u0010.\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0006\u001a\u0004\b0\u0010\u001b\",\u00101\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u0003020\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0006\u001a\u0004\b4\u0010\u001b\">\u00105\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u0003060\u0017\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0006\u001a\u0004\b8\u0010\u001b\"B\u00109\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u0003\u0012\u0002\b\u00030:0\u0017\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0006\u001a\u0004\b<\u0010\u001b\">\u0010=\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u0003060\u0017\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b>\u0010\u0006\u001a\u0004\b?\u0010\u001b\"B\u0010@\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u0003\u0012\u0002\b\u00030:0\u0017\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\bA\u0010\u0006\u001a\u0004\bB\u0010\u001b\"\u001c\u0010C\u001a\u00020D*\u0006\u0012\u0002\b\u00030E8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010F\"\u001c\u0010G\u001a\u00020D*\u0006\u0012\u0002\b\u00030E8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010F\",\u0010H\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040I*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\bJ\u0010\u0006\u001a\u0004\bK\u0010L\"(\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\bN\u0010\u0006\u001a\u0004\bO\u0010\u001b\",\u0010P\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0017*\u0006\u0012\u0002\b\u00030\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\bQ\u0010\u0006\u001a\u0004\bR\u0010\u001b¨\u0006\\"}, d2 = {"primaryConstructor", "Lkotlin/reflect/KFunction;", "T", "", "Lkotlin/reflect/KClass;", "getPrimaryConstructor$annotations", "(Lkotlin/reflect/KClass;)V", "getPrimaryConstructor", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KFunction;", "companionObject", "getCompanionObject$annotations", "getCompanionObject", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KClass;", "companionObjectInstance", "getCompanionObjectInstance$annotations", "getCompanionObjectInstance", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "defaultType", "Lkotlin/reflect/KType;", "getDefaultType$annotations", "getDefaultType", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KType;", "declaredMembers", "", "Lkotlin/reflect/KCallable;", "getDeclaredMembers$annotations", "getDeclaredMembers", "(Lkotlin/reflect/KClass;)Ljava/util/Collection;", "functions", "getFunctions$annotations", "getFunctions", "staticFunctions", "getStaticFunctions$annotations", "getStaticFunctions", "memberFunctions", "getMemberFunctions$annotations", "getMemberFunctions", "memberExtensionFunctions", "getMemberExtensionFunctions$annotations", "getMemberExtensionFunctions", "declaredFunctions", "getDeclaredFunctions$annotations", "getDeclaredFunctions", "declaredMemberFunctions", "getDeclaredMemberFunctions$annotations", "getDeclaredMemberFunctions", "declaredMemberExtensionFunctions", "getDeclaredMemberExtensionFunctions$annotations", "getDeclaredMemberExtensionFunctions", "staticProperties", "Lkotlin/reflect/KProperty0;", "getStaticProperties$annotations", "getStaticProperties", "memberProperties", "Lkotlin/reflect/KProperty1;", "getMemberProperties$annotations", "getMemberProperties", "memberExtensionProperties", "Lkotlin/reflect/KProperty2;", "getMemberExtensionProperties$annotations", "getMemberExtensionProperties", "declaredMemberProperties", "getDeclaredMemberProperties$annotations", "getDeclaredMemberProperties", "declaredMemberExtensionProperties", "getDeclaredMemberExtensionProperties$annotations", "getDeclaredMemberExtensionProperties", "isExtension", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;)Z", "isNotExtension", "superclasses", "", "getSuperclasses$annotations", "getSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "allSupertypes", "getAllSupertypes$annotations", "getAllSupertypes", "allSuperclasses", "getAllSuperclasses$annotations", "getAllSuperclasses", "isSubclassOf", "base", "isSuperclassOf", "derived", "cast", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "safeCast", com.taobao.weex.bridge.WXBridgeManager.METHOD_CREATE_INSTANCE, "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KClasses {
    public static /* synthetic */ void getAllSuperclasses$annotations(kotlin.reflect.KClass kClass) {
    }

    public static /* synthetic */ void getAllSupertypes$annotations(kotlin.reflect.KClass kClass) {
    }

    public static /* synthetic */ void getCompanionObject$annotations(kotlin.reflect.KClass kClass) {
    }

    public static /* synthetic */ void getCompanionObjectInstance$annotations(kotlin.reflect.KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredFunctions$annotations(kotlin.reflect.KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredMemberExtensionFunctions$annotations(kotlin.reflect.KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredMemberExtensionProperties$annotations(kotlin.reflect.KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredMemberFunctions$annotations(kotlin.reflect.KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredMemberProperties$annotations(kotlin.reflect.KClass kClass) {
    }

    public static /* synthetic */ void getDeclaredMembers$annotations(kotlin.reflect.KClass kClass) {
    }

    @kotlin.Deprecated(message = "This function creates a type which rarely makes sense for generic classes. For example, such type can only be used in signatures of members of that class. Use starProjectedType or createType() for clearer semantics.")
    public static /* synthetic */ void getDefaultType$annotations(kotlin.reflect.KClass kClass) {
    }

    public static /* synthetic */ void getFunctions$annotations(kotlin.reflect.KClass kClass) {
    }

    public static /* synthetic */ void getMemberExtensionFunctions$annotations(kotlin.reflect.KClass kClass) {
    }

    public static /* synthetic */ void getMemberExtensionProperties$annotations(kotlin.reflect.KClass kClass) {
    }

    public static /* synthetic */ void getMemberFunctions$annotations(kotlin.reflect.KClass kClass) {
    }

    public static /* synthetic */ void getMemberProperties$annotations(kotlin.reflect.KClass kClass) {
    }

    public static /* synthetic */ void getPrimaryConstructor$annotations(kotlin.reflect.KClass kClass) {
    }

    public static /* synthetic */ void getStaticFunctions$annotations(kotlin.reflect.KClass kClass) {
    }

    public static /* synthetic */ void getStaticProperties$annotations(kotlin.reflect.KClass kClass) {
    }

    public static /* synthetic */ void getSuperclasses$annotations(kotlin.reflect.KClass kClass) {
    }

    public static final <T> kotlin.reflect.KFunction<T> getPrimaryConstructor(kotlin.reflect.KClass<T> kClass) {
        T next;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.util.Iterator<T> it = ((kotlin.reflect.jvm.internal.KClassImpl) kClass).getConstructors().iterator();
        while (it.hasNext()) {
            next = it.next();
            kotlin.reflect.KFunction kFunction = (kotlin.reflect.KFunction) next;
            kotlin.jvm.internal.Intrinsics.checkNotNull(kFunction, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KFunctionImpl");
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor descriptor = ((kotlin.reflect.jvm.internal.KFunctionImpl) kFunction).getDescriptor();
            kotlin.jvm.internal.Intrinsics.checkNotNull(descriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ConstructorDescriptor");
            if (((kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) descriptor).isPrimary()) {
                return (kotlin.reflect.KFunction) next;
            }
        }
        next = null;
        return (kotlin.reflect.KFunction) next;
    }

    public static final kotlin.reflect.KClass<?> getCompanionObject(kotlin.reflect.KClass<?> kClass) {
        java.lang.Object next;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.util.Iterator<T> it = kClass.getNestedClasses().iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((kotlin.reflect.KClass) next).isCompanion()) {
                return (kotlin.reflect.KClass) next;
            }
        }
        next = null;
        return (kotlin.reflect.KClass) next;
    }

    public static final java.lang.Object getCompanionObjectInstance(kotlin.reflect.KClass<?> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        kotlin.reflect.KClass<?> companionObject = getCompanionObject(kClass);
        if (companionObject != null) {
            return companionObject.getObjectInstance();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.reflect.Type _get_defaultType_$lambda$1(kotlin.reflect.KClass kClass) {
        return ((kotlin.reflect.jvm.internal.KClassImpl) kClass).getJClass();
    }

    public static final kotlin.reflect.KType getDefaultType(final kotlin.reflect.KClass<?> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        kotlin.reflect.jvm.internal.impl.types.SimpleType defaultType = ((kotlin.reflect.jvm.internal.KClassImpl) kClass).getDescriptor().getDefaultType();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
        return new kotlin.reflect.jvm.internal.KTypeImpl(defaultType, new kotlin.jvm.functions.Function0(kClass) { // from class: kotlin.reflect.full.KClasses$$Lambda$0
            private final kotlin.reflect.KClass arg$0;

            {
                this.arg$0 = kClass;
            }

            @Override // kotlin.jvm.functions.Function0
            public java.lang.Object invoke() {
                return kotlin.reflect.full.KClasses._get_defaultType_$lambda$1(this.arg$0);
            }
        });
    }

    public static final java.util.Collection<kotlin.reflect.KCallable<?>> getDeclaredMembers(kotlin.reflect.KClass<?> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        return ((kotlin.reflect.jvm.internal.KClassImpl.Data) ((kotlin.reflect.jvm.internal.KClassImpl) kClass).getData().getValue()).getDeclaredMembers();
    }

    public static final java.util.Collection<kotlin.reflect.KFunction<?>> getFunctions(kotlin.reflect.KClass<?> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.util.Collection<kotlin.reflect.KCallable<?>> members = kClass.getMembers();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : members) {
            if (obj instanceof kotlin.reflect.KFunction) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final java.util.Collection<kotlin.reflect.KFunction<?>> getStaticFunctions(kotlin.reflect.KClass<?> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> allStaticMembers = ((kotlin.reflect.jvm.internal.KClassImpl.Data) ((kotlin.reflect.jvm.internal.KClassImpl) kClass).getData().getValue()).getAllStaticMembers();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : allStaticMembers) {
            if (obj instanceof kotlin.reflect.KFunction) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final java.util.Collection<kotlin.reflect.KFunction<?>> getMemberFunctions(kotlin.reflect.KClass<?> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> allNonStaticMembers = ((kotlin.reflect.jvm.internal.KClassImpl.Data) ((kotlin.reflect.jvm.internal.KClassImpl) kClass).getData().getValue()).getAllNonStaticMembers();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : allNonStaticMembers) {
            kotlin.reflect.jvm.internal.KCallableImpl kCallableImpl = (kotlin.reflect.jvm.internal.KCallableImpl) obj;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof kotlin.reflect.KFunction)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final java.util.Collection<kotlin.reflect.KFunction<?>> getMemberExtensionFunctions(kotlin.reflect.KClass<?> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> allNonStaticMembers = ((kotlin.reflect.jvm.internal.KClassImpl.Data) ((kotlin.reflect.jvm.internal.KClassImpl) kClass).getData().getValue()).getAllNonStaticMembers();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : allNonStaticMembers) {
            kotlin.reflect.jvm.internal.KCallableImpl kCallableImpl = (kotlin.reflect.jvm.internal.KCallableImpl) obj;
            if (isExtension(kCallableImpl) && (kCallableImpl instanceof kotlin.reflect.KFunction)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final java.util.Collection<kotlin.reflect.KFunction<?>> getDeclaredFunctions(kotlin.reflect.KClass<?> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> declaredMembers = ((kotlin.reflect.jvm.internal.KClassImpl.Data) ((kotlin.reflect.jvm.internal.KClassImpl) kClass).getData().getValue()).getDeclaredMembers();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : declaredMembers) {
            if (obj instanceof kotlin.reflect.KFunction) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final java.util.Collection<kotlin.reflect.KFunction<?>> getDeclaredMemberFunctions(kotlin.reflect.KClass<?> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> declaredNonStaticMembers = ((kotlin.reflect.jvm.internal.KClassImpl.Data) ((kotlin.reflect.jvm.internal.KClassImpl) kClass).getData().getValue()).getDeclaredNonStaticMembers();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : declaredNonStaticMembers) {
            kotlin.reflect.jvm.internal.KCallableImpl kCallableImpl = (kotlin.reflect.jvm.internal.KCallableImpl) obj;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof kotlin.reflect.KFunction)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final java.util.Collection<kotlin.reflect.KFunction<?>> getDeclaredMemberExtensionFunctions(kotlin.reflect.KClass<?> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> declaredNonStaticMembers = ((kotlin.reflect.jvm.internal.KClassImpl.Data) ((kotlin.reflect.jvm.internal.KClassImpl) kClass).getData().getValue()).getDeclaredNonStaticMembers();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : declaredNonStaticMembers) {
            kotlin.reflect.jvm.internal.KCallableImpl kCallableImpl = (kotlin.reflect.jvm.internal.KCallableImpl) obj;
            if (isExtension(kCallableImpl) && (kCallableImpl instanceof kotlin.reflect.KFunction)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final java.util.Collection<kotlin.reflect.KProperty0<?>> getStaticProperties(kotlin.reflect.KClass<?> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> allStaticMembers = ((kotlin.reflect.jvm.internal.KClassImpl.Data) ((kotlin.reflect.jvm.internal.KClassImpl) kClass).getData().getValue()).getAllStaticMembers();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : allStaticMembers) {
            kotlin.reflect.jvm.internal.KCallableImpl kCallableImpl = (kotlin.reflect.jvm.internal.KCallableImpl) obj;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof kotlin.reflect.KProperty0)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final <T> java.util.Collection<kotlin.reflect.KProperty1<T, ?>> getMemberProperties(kotlin.reflect.KClass<T> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> allNonStaticMembers = ((kotlin.reflect.jvm.internal.KClassImpl) kClass).getData().getValue().getAllNonStaticMembers();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (T t : allNonStaticMembers) {
            kotlin.reflect.jvm.internal.KCallableImpl kCallableImpl = (kotlin.reflect.jvm.internal.KCallableImpl) t;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof kotlin.reflect.KProperty1)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final <T> java.util.Collection<kotlin.reflect.KProperty2<T, ?, ?>> getMemberExtensionProperties(kotlin.reflect.KClass<T> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> allNonStaticMembers = ((kotlin.reflect.jvm.internal.KClassImpl) kClass).getData().getValue().getAllNonStaticMembers();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (T t : allNonStaticMembers) {
            kotlin.reflect.jvm.internal.KCallableImpl kCallableImpl = (kotlin.reflect.jvm.internal.KCallableImpl) t;
            if (isExtension(kCallableImpl) && (kCallableImpl instanceof kotlin.reflect.KProperty2)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final <T> java.util.Collection<kotlin.reflect.KProperty1<T, ?>> getDeclaredMemberProperties(kotlin.reflect.KClass<T> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> declaredNonStaticMembers = ((kotlin.reflect.jvm.internal.KClassImpl) kClass).getData().getValue().getDeclaredNonStaticMembers();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (T t : declaredNonStaticMembers) {
            kotlin.reflect.jvm.internal.KCallableImpl kCallableImpl = (kotlin.reflect.jvm.internal.KCallableImpl) t;
            if (isNotExtension(kCallableImpl) && (kCallableImpl instanceof kotlin.reflect.KProperty1)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final <T> java.util.Collection<kotlin.reflect.KProperty2<T, ?, ?>> getDeclaredMemberExtensionProperties(kotlin.reflect.KClass<T> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> declaredNonStaticMembers = ((kotlin.reflect.jvm.internal.KClassImpl) kClass).getData().getValue().getDeclaredNonStaticMembers();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (T t : declaredNonStaticMembers) {
            kotlin.reflect.jvm.internal.KCallableImpl kCallableImpl = (kotlin.reflect.jvm.internal.KCallableImpl) t;
            if (isExtension(kCallableImpl) && (kCallableImpl instanceof kotlin.reflect.KProperty2)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    private static final boolean isExtension(kotlin.reflect.jvm.internal.KCallableImpl<?> kCallableImpl) {
        return kCallableImpl.getDescriptor().getExtensionReceiverParameter() != null;
    }

    private static final boolean isNotExtension(kotlin.reflect.jvm.internal.KCallableImpl<?> kCallableImpl) {
        return !isExtension(kCallableImpl);
    }

    public static final java.util.List<kotlin.reflect.KClass<?>> getSuperclasses(kotlin.reflect.KClass<?> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.util.List<kotlin.reflect.KType> supertypes = kClass.getSupertypes();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<T> it = supertypes.iterator();
        while (it.hasNext()) {
            kotlin.reflect.KClassifier classifier = ((kotlin.reflect.KType) it.next()).getClassifier();
            kotlin.reflect.KClass kClass2 = classifier instanceof kotlin.reflect.KClass ? (kotlin.reflect.KClass) classifier : null;
            if (kClass2 != null) {
                arrayList.add(kClass2);
            }
        }
        return arrayList;
    }

    public static final java.util.Collection<kotlin.reflect.KType> getAllSupertypes(kotlin.reflect.KClass<?> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.lang.Object objDfs = kotlin.reflect.jvm.internal.impl.utils.DFS.dfs(kClass.getSupertypes(), new kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors() { // from class: kotlin.reflect.full.KClasses$$Lambda$1
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public java.lang.Iterable getNeighbors(java.lang.Object obj) {
                return kotlin.reflect.full.KClasses._get_allSupertypes_$lambda$14((kotlin.reflect.KType) obj);
            }
        }, new kotlin.reflect.jvm.internal.impl.utils.DFS.VisitedWithSet(), new kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandlerWithListResult<kotlin.reflect.KType, kotlin.reflect.KType>() { // from class: kotlin.reflect.full.KClasses$allSupertypes$2
            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler, kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler
            public boolean beforeChildren(kotlin.reflect.KType current) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(current, "current");
                ((java.util.LinkedList) this.result).add(current);
                return true;
            }
        });
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(objDfs, "dfs(...)");
        return (java.util.Collection) objDfs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final java.lang.Iterable _get_allSupertypes_$lambda$14(kotlin.reflect.KType kType) {
        kotlin.reflect.KClassifier classifier = kType.getClassifier();
        kotlin.jvm.functions.Function0 function0 = null;
        java.lang.Object[] objArr = 0;
        kotlin.reflect.KClass kClass = classifier instanceof kotlin.reflect.KClass ? (kotlin.reflect.KClass) classifier : null;
        if (kClass == null) {
            throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Supertype not a class: " + kType);
        }
        java.util.List<kotlin.reflect.KType> supertypes = kClass.getSupertypes();
        if (kType.getArguments().isEmpty()) {
            return supertypes;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(kType, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
        kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor typeSubstitutorCreate = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.create(((kotlin.reflect.jvm.internal.KTypeImpl) kType).getType());
        java.util.List<kotlin.reflect.KType> list = supertypes;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        for (kotlin.reflect.KType kType2 : list) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(kType2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
            kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeSubstitute = typeSubstitutorCreate.substitute(((kotlin.reflect.jvm.internal.KTypeImpl) kType2).getType(), kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT);
            if (kotlinTypeSubstitute == null) {
                throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Type substitution failed: " + kType2 + " (" + kType + com.taobao.weex.el.parse.Operators.BRACKET_END);
            }
            arrayList.add(new kotlin.reflect.jvm.internal.KTypeImpl(kotlinTypeSubstitute, function0, 2, objArr == true ? 1 : 0));
        }
        return arrayList;
    }

    public static final java.util.Collection<kotlin.reflect.KClass<?>> getAllSuperclasses(kotlin.reflect.KClass<?> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.util.Collection<kotlin.reflect.KType> allSupertypes = getAllSupertypes(kClass);
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(allSupertypes, 10));
        for (kotlin.reflect.KType kType : allSupertypes) {
            kotlin.reflect.KClassifier classifier = kType.getClassifier();
            kotlin.reflect.KClass kClass2 = classifier instanceof kotlin.reflect.KClass ? (kotlin.reflect.KClass) classifier : null;
            if (kClass2 == null) {
                throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("Supertype not a class: " + kType);
            }
            arrayList.add(kClass2);
        }
        return arrayList;
    }

    public static final boolean isSubclassOf(kotlin.reflect.KClass<?> kClass, final kotlin.reflect.KClass<?> base) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(base, "base");
        if (kotlin.jvm.internal.Intrinsics.areEqual(kClass, base)) {
            return true;
        }
        java.util.List listListOf = kotlin.collections.CollectionsKt.listOf(kClass);
        final kotlin.reflect.full.KClasses.AnonymousClass1 anonymousClass1 = new kotlin.jvm.internal.PropertyReference1Impl() { // from class: kotlin.reflect.full.KClasses.isSubclassOf.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public java.lang.Object get(java.lang.Object obj) {
                return kotlin.reflect.full.KClasses.getSuperclasses((kotlin.reflect.KClass) obj);
            }
        };
        return kotlin.reflect.jvm.internal.impl.utils.DFS.ifAny(listListOf, new kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors(anonymousClass1) { // from class: kotlin.reflect.full.KClasses$$Lambda$2
            private final kotlin.reflect.KProperty1 arg$0;

            {
                this.arg$0 = anonymousClass1;
            }

            @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
            public java.lang.Iterable getNeighbors(java.lang.Object obj) {
                return kotlin.reflect.full.KClasses.isSubclassOf$lambda$16(this.arg$0, (kotlin.reflect.KClass) obj);
            }
        }, new kotlin.jvm.functions.Function1(base) { // from class: kotlin.reflect.full.KClasses$$Lambda$3
            private final kotlin.reflect.KClass arg$0;

            {
                this.arg$0 = base;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: invoke */
            public java.lang.Object invoke2(java.lang.Object obj) {
                return kotlin.reflect.full.KClasses.isSubclassOf$lambda$17(this.arg$0, (kotlin.reflect.KClass) obj);
            }
        }).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Iterable isSubclassOf$lambda$16(kotlin.reflect.KProperty1 kProperty1, kotlin.reflect.KClass kClass) {
        return (java.lang.Iterable) kProperty1.invoke2(kClass);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Boolean isSubclassOf$lambda$17(kotlin.reflect.KClass kClass, kotlin.reflect.KClass kClass2) {
        return java.lang.Boolean.valueOf(kotlin.jvm.internal.Intrinsics.areEqual(kClass2, kClass));
    }

    public static final boolean isSuperclassOf(kotlin.reflect.KClass<?> kClass, kotlin.reflect.KClass<?> derived) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(derived, "derived");
        return isSubclassOf(derived, kClass);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T cast(kotlin.reflect.KClass<T> kClass, java.lang.Object obj) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        if (!kClass.isInstance(obj)) {
            throw new kotlin.TypeCastException("Value cannot be cast to " + kClass.getQualifiedName());
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.cast");
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T safeCast(kotlin.reflect.KClass<T> kClass, java.lang.Object obj) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        if (!kClass.isInstance(obj)) {
            return null;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of kotlin.reflect.full.KClasses.safeCast");
        return obj;
    }

    public static final <T> T createInstance(kotlin.reflect.KClass<T> kClass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kClass, "<this>");
        java.util.Iterator<T> it = kClass.getConstructors().iterator();
        T t = null;
        boolean z = false;
        T t2 = null;
        while (true) {
            if (!it.hasNext()) {
                if (!z) {
                    break;
                }
                t = t2;
                break;
            }
            T next = it.next();
            java.util.List<kotlin.reflect.KParameter> parameters = ((kotlin.reflect.KFunction) next).getParameters();
            if (!(parameters instanceof java.util.Collection) || !parameters.isEmpty()) {
                java.util.Iterator<T> it2 = parameters.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!((kotlin.reflect.KParameter) it2.next()).isOptional()) {
                        }
                    }
                }
            }
            if (z) {
                break;
            }
            z = true;
            t2 = next;
        }
        kotlin.reflect.KFunction kFunction = (kotlin.reflect.KFunction) t;
        if (kFunction == null) {
            throw new java.lang.IllegalArgumentException("Class should have a single no-arg constructor: " + kClass);
        }
        return (T) kFunction.callBy(kotlin.collections.MapsKt.emptyMap());
    }
}
