package kotlin.reflect.jvm.internal.calls;

/* JADX INFO: compiled from: ValueClassAwareCaller.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0002()B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"J\u001b\u0010$\u001a\u0004\u0018\u00010%2\n\u0010&\u001a\u0006\u0012\u0002\b\u00030\u001dH\u0016¢\u0006\u0002\u0010'R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010#\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "oldCaller", "isDefault", "", "<init>", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "caller", "member", "getMember", "()Ljava/lang/reflect/Member;", "Ljava/lang/reflect/Member;", "returnType", "Ljava/lang/reflect/Type;", "getReturnType", "()Ljava/lang/reflect/Type;", "parameterTypes", "", "getParameterTypes", "()Ljava/util/List;", "isBoundInstanceCallWithValueClasses", "()Z", "data", "Lkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller$BoxUnboxData;", "slices", "", "Lkotlin/ranges/IntRange;", "[Lkotlin/ranges/IntRange;", "getRealSlicesOfParameters", "index", "", "hasMfvcParameters", androidx.core.app.NotificationCompat.CATEGORY_CALL, "", "args", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "MultiFieldValueClassPrimaryConstructorCaller", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ValueClassAwareCaller<M extends java.lang.reflect.Member> implements kotlin.reflect.jvm.internal.calls.Caller<M> {
    private final kotlin.reflect.jvm.internal.calls.Caller<M> caller;
    private final kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller.BoxUnboxData data;
    private final boolean hasMfvcParameters;
    private final boolean isDefault;
    private final M member;
    private final kotlin.ranges.IntRange[] slices;

    /* JADX WARN: Code duplicated, block: B:27:0x0084 A[LOOP:1: B:25:0x007e->B:27:0x0084, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x0142  */
    public ValueClassAwareCaller(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor descriptor, kotlin.reflect.jvm.internal.calls.Caller<? extends M> oldCaller, boolean z) {
        java.lang.Class inlineClass;
        kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller.BoxUnboxData boxUnboxData;
        int length;
        kotlin.reflect.jvm.internal.impl.types.KotlinType kotlinTypeSubstitutedUnderlyingType;
        java.util.ArrayList arrayList;
        java.util.Iterator<T> it;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(oldCaller, "oldCaller");
        this.isDefault = z;
        boolean z2 = false;
        if (oldCaller instanceof kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic) {
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor extensionReceiverParameter = descriptor.getExtensionReceiverParameter();
            extensionReceiverParameter = extensionReceiverParameter == null ? descriptor.getDispatchReceiverParameter() : extensionReceiverParameter;
            kotlin.reflect.jvm.internal.impl.types.KotlinType type = extensionReceiverParameter != null ? extensionReceiverParameter.getType() : null;
            if (type != null && kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.needsMfvcFlattening(type)) {
                if (z) {
                    java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> valueParameters = descriptor.getValueParameters();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameters, "getValueParameters(...)");
                    java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> list = valueParameters;
                    if (!(list instanceof java.util.Collection) || !list.isEmpty()) {
                        java.util.Iterator<T> it2 = list.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (((kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) it2.next()).declaresDefaultValue()) {
                                    java.util.List<java.lang.reflect.Method> mfvcUnboxMethods = kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.getMfvcUnboxMethods(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.asSimpleType(type));
                                    kotlin.jvm.internal.Intrinsics.checkNotNull(mfvcUnboxMethods);
                                    java.util.List<java.lang.reflect.Method> list2 = mfvcUnboxMethods;
                                    arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list2, 10));
                                    it = list2.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((java.lang.reflect.Method) it.next()).invoke(((kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic) oldCaller).getBoundReceiver(), null));
                                    }
                                    oldCaller = new kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStaticMultiFieldValueClass(((kotlin.reflect.jvm.internal.calls.CallerImpl.Method) oldCaller).mo1823getMember(), arrayList.toArray(new java.lang.Object[0]));
                                }
                            }
                        }
                    }
                } else {
                    java.util.List<java.lang.reflect.Method> mfvcUnboxMethods2 = kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.getMfvcUnboxMethods(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.asSimpleType(type));
                    kotlin.jvm.internal.Intrinsics.checkNotNull(mfvcUnboxMethods2);
                    java.util.List<java.lang.reflect.Method> list3 = mfvcUnboxMethods2;
                    arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list3, 10));
                    it = list3.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((java.lang.reflect.Method) it.next()).invoke(((kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic) oldCaller).getBoundReceiver(), null));
                    }
                    oldCaller = new kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStaticMultiFieldValueClass(((kotlin.reflect.jvm.internal.calls.CallerImpl.Method) oldCaller).mo1823getMember(), arrayList.toArray(new java.lang.Object[0]));
                }
            }
        }
        this.caller = (kotlin.reflect.jvm.internal.calls.Caller<M>) oldCaller;
        this.member = (M) oldCaller.mo1823getMember();
        kotlin.reflect.jvm.internal.impl.types.KotlinType returnType = descriptor.getReturnType();
        kotlin.jvm.internal.Intrinsics.checkNotNull(returnType);
        boolean z3 = descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
        java.lang.reflect.Method boxMethod = ((z3 && ((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) descriptor).isSuspend() && (kotlinTypeSubstitutedUnderlyingType = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.substitutedUnderlyingType(returnType)) != null && kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isPrimitiveType(kotlinTypeSubstitutedUnderlyingType)) || (inlineClass = kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.toInlineClass(returnType)) == null) ? null : kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.getBoxMethod(inlineClass, descriptor);
        if (kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfValueClass(descriptor)) {
            boxUnboxData = new kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller.BoxUnboxData(kotlin.ranges.IntRange.INSTANCE.getEMPTY(), new java.util.List[0], boxMethod);
        } else {
            kotlin.reflect.jvm.internal.calls.Caller<M> caller = this.caller;
            int i = -1;
            if (!(caller instanceof kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic) || ((kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic) caller).getIsCallByToValueClassMangledMethod()) {
                kotlin.reflect.jvm.internal.calls.Caller<M> caller2 = this.caller;
                if (!(caller2 instanceof kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStaticMultiFieldValueClass)) {
                    if (descriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) {
                        if (!(caller2 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller)) {
                            i = 0;
                        }
                    } else if (descriptor.getDispatchReceiverParameter() == null || (this.caller instanceof kotlin.reflect.jvm.internal.calls.BoundCaller)) {
                        i = 0;
                    } else {
                        kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(containingDeclaration, "getContainingDeclaration(...)");
                        if (kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isValueClass(containingDeclaration)) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    }
                }
            }
            kotlin.reflect.jvm.internal.calls.Caller<M> caller3 = this.caller;
            int i2 = caller3 instanceof kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStaticMultiFieldValueClass ? -((kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStaticMultiFieldValueClass) caller3).getReceiverComponentsCount() : i;
            java.util.List listMakeKotlinParameterTypes = kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.makeKotlinParameterTypes(descriptor, this.caller.mo1823getMember(), new kotlin.jvm.functions.Function1() { // from class: kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller$$Lambda$0
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public java.lang.Object invoke2(java.lang.Object obj) {
                    return java.lang.Boolean.valueOf(kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller.data$lambda$5$lambda$3((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) obj));
                }
            });
            java.util.Iterator it3 = listMakeKotlinParameterTypes.iterator();
            int size = 0;
            while (it3.hasNext()) {
                java.util.List<java.lang.reflect.Method> mfvcUnboxMethods3 = kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.getMfvcUnboxMethods(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.asSimpleType((kotlin.reflect.jvm.internal.impl.types.KotlinType) it3.next()));
                size += mfvcUnboxMethods3 != null ? mfvcUnboxMethods3.size() : 1;
            }
            int i3 = size + i2 + (this.isDefault ? ((size + 31) / 32) + 1 : 0) + ((z3 && ((kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) descriptor).isSuspend()) ? 1 : 0);
            kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.checkParametersSize(this, i3, descriptor, this.isDefault);
            kotlin.ranges.IntRange intRangeUntil = kotlin.ranges.RangesKt.until(java.lang.Math.max(i, 0), listMakeKotlinParameterTypes.size() + i);
            java.util.List[] listArr = new java.util.List[i3];
            int i4 = 0;
            while (i4 < i3) {
                listArr[i4] = (i4 > intRangeUntil.getLast() || intRangeUntil.getFirst() > i4) ? null : kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.getValueClassUnboxMethods(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.asSimpleType((kotlin.reflect.jvm.internal.impl.types.KotlinType) listMakeKotlinParameterTypes.get(i4 - i)), descriptor);
                i4++;
            }
            boxUnboxData = new kotlin.reflect.jvm.internal.calls.ValueClassAwareCaller.BoxUnboxData(intRangeUntil, listArr, boxMethod);
        }
        this.data = boxUnboxData;
        java.util.List listCreateListBuilder = kotlin.collections.CollectionsKt.createListBuilder();
        kotlin.reflect.jvm.internal.calls.Caller<M> caller4 = this.caller;
        if (caller4 instanceof kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStaticMultiFieldValueClass) {
            length = ((kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStaticMultiFieldValueClass) caller4).getBoundReceiverComponents().length;
        } else {
            length = caller4 instanceof kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic ? 1 : 0;
        }
        if (length > 0) {
            listCreateListBuilder.add(kotlin.ranges.RangesKt.until(0, length));
        }
        java.util.List<java.lang.reflect.Method>[] unboxParameters = boxUnboxData.getUnboxParameters();
        int length2 = unboxParameters.length;
        int i5 = 0;
        while (i5 < length2) {
            java.util.List<java.lang.reflect.Method> list4 = unboxParameters[i5];
            int size2 = (list4 != null ? list4.size() : 1) + length;
            listCreateListBuilder.add(kotlin.ranges.RangesKt.until(length, size2));
            i5++;
            length = size2;
        }
        this.slices = (kotlin.ranges.IntRange[]) kotlin.collections.CollectionsKt.build(listCreateListBuilder).toArray(new kotlin.ranges.IntRange[0]);
        java.lang.Iterable argumentRange = this.data.getArgumentRange();
        if (!(argumentRange instanceof java.util.Collection) || !((java.util.Collection) argumentRange).isEmpty()) {
            java.util.Iterator it4 = argumentRange.iterator();
            while (it4.hasNext()) {
                java.util.List<java.lang.reflect.Method> list5 = this.data.getUnboxParameters()[((kotlin.collections.IntIterator) it4).nextInt()];
                if (list5 != null && list5.size() > 1) {
                    z2 = true;
                    break;
                }
            }
        }
        this.hasMfvcParameters = z2;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* JADX INFO: renamed from: getMember */
    public M mo1823getMember() {
        return this.member;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public java.lang.reflect.Type getReturnType() {
        return this.caller.getReturnType();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public java.util.List<java.lang.reflect.Type> getParameterTypes() {
        return this.caller.getParameterTypes();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public boolean isBoundInstanceCallWithValueClasses() {
        return this.caller instanceof kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundInstance;
    }

    /* JADX INFO: compiled from: ValueClassAwareCaller.kt */
    @kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unboxParameters", "", "", "Ljava/lang/reflect/Method;", "box", "<init>", "(Lkotlin/ranges/IntRange;[Ljava/util/List;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getUnboxParameters", "()[Ljava/util/List;", "[Ljava/util/List;", "getBox", "()Ljava/lang/reflect/Method;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class BoxUnboxData {
        private final kotlin.ranges.IntRange argumentRange;
        private final java.lang.reflect.Method box;
        private final java.util.List<java.lang.reflect.Method>[] unboxParameters;

        public BoxUnboxData(kotlin.ranges.IntRange argumentRange, java.util.List<java.lang.reflect.Method>[] unboxParameters, java.lang.reflect.Method method) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(argumentRange, "argumentRange");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unboxParameters, "unboxParameters");
            this.argumentRange = argumentRange;
            this.unboxParameters = unboxParameters;
            this.box = method;
        }

        public final kotlin.ranges.IntRange getArgumentRange() {
            return this.argumentRange;
        }

        public final java.lang.reflect.Method getBox() {
            return this.box;
        }

        public final java.util.List<java.lang.reflect.Method>[] getUnboxParameters() {
            return this.unboxParameters;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean data$lambda$5$lambda$3(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor makeKotlinParameterTypes) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(makeKotlinParameterTypes, "$this$makeKotlinParameterTypes");
        return kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isValueClass(makeKotlinParameterTypes);
    }

    public final kotlin.ranges.IntRange getRealSlicesOfParameters(int index) {
        if (index >= 0) {
            kotlin.ranges.IntRange[] intRangeArr = this.slices;
            if (index < intRangeArr.length) {
                return intRangeArr[index];
            }
        }
        kotlin.ranges.IntRange[] intRangeArr2 = this.slices;
        if (intRangeArr2.length == 0) {
            return new kotlin.ranges.IntRange(index, index);
        }
        int length = (index - intRangeArr2.length) + ((kotlin.ranges.IntRange) kotlin.collections.ArraysKt.last(intRangeArr2)).getLast() + 1;
        return new kotlin.ranges.IntRange(length, length);
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    public java.lang.Object call(java.lang.Object[] args) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        java.lang.Object objInvoke;
        java.lang.Object objDefaultPrimitiveValue;
        java.lang.Object objDefaultPrimitiveValue2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(args, "args");
        kotlin.ranges.IntRange argumentRange = this.data.getArgumentRange();
        java.util.List<java.lang.reflect.Method>[] unboxParameters = this.data.getUnboxParameters();
        java.lang.reflect.Method box = this.data.getBox();
        if (!argumentRange.isEmpty()) {
            if (this.hasMfvcParameters) {
                java.util.List listCreateListBuilder = kotlin.collections.CollectionsKt.createListBuilder(args.length);
                int first = argumentRange.getFirst();
                for (int i = 0; i < first; i++) {
                    listCreateListBuilder.add(args[i]);
                }
                int first2 = argumentRange.getFirst();
                int last = argumentRange.getLast();
                if (first2 <= last) {
                    while (true) {
                        java.util.List<java.lang.reflect.Method> list = unboxParameters[first2];
                        java.lang.Object obj = args[first2];
                        if (list == null) {
                            java.lang.Boolean.valueOf(listCreateListBuilder.add(obj));
                        } else {
                            for (java.lang.reflect.Method method : list) {
                                java.util.List list2 = listCreateListBuilder;
                                if (obj != null) {
                                    objDefaultPrimitiveValue2 = method.invoke(obj, null);
                                } else {
                                    java.lang.Class<?> returnType = method.getReturnType();
                                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
                                    objDefaultPrimitiveValue2 = kotlin.reflect.jvm.internal.UtilKt.defaultPrimitiveValue(returnType);
                                }
                                list2.add(objDefaultPrimitiveValue2);
                            }
                        }
                        if (first2 == last) {
                            break;
                        }
                        first2++;
                    }
                }
                int last2 = argumentRange.getLast() + 1;
                int lastIndex = kotlin.collections.ArraysKt.getLastIndex(args);
                if (last2 <= lastIndex) {
                    while (true) {
                        listCreateListBuilder.add(args[last2]);
                        if (last2 == lastIndex) {
                            break;
                        }
                        last2++;
                    }
                }
                args = kotlin.collections.CollectionsKt.build(listCreateListBuilder).toArray(new java.lang.Object[0]);
            } else {
                int length = args.length;
                java.lang.Object[] objArr = new java.lang.Object[length];
                for (int i2 = 0; i2 < length; i2++) {
                    int first3 = argumentRange.getFirst();
                    if (i2 <= argumentRange.getLast() && first3 <= i2) {
                        java.util.List<java.lang.reflect.Method> list3 = unboxParameters[i2];
                        java.lang.reflect.Method method2 = list3 != null ? (java.lang.reflect.Method) kotlin.collections.CollectionsKt.single((java.util.List) list3) : null;
                        objDefaultPrimitiveValue = args[i2];
                        if (method2 != null) {
                            if (objDefaultPrimitiveValue != null) {
                                objDefaultPrimitiveValue = method2.invoke(objDefaultPrimitiveValue, null);
                            } else {
                                java.lang.Class<?> returnType2 = method2.getReturnType();
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(returnType2, "getReturnType(...)");
                                objDefaultPrimitiveValue = kotlin.reflect.jvm.internal.UtilKt.defaultPrimitiveValue(returnType2);
                            }
                        }
                    } else {
                        objDefaultPrimitiveValue = args[i2];
                    }
                    objArr[i2] = objDefaultPrimitiveValue;
                }
                args = objArr;
            }
        }
        java.lang.Object objCall = this.caller.call(args);
        return (objCall == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED() || box == null || (objInvoke = box.invoke(null, objCall)) == null) ? objCall : objInvoke;
    }

    /* JADX INFO: compiled from: ValueClassAwareCaller.kt */
    @kotlin.Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u001f\u001a\u0004\u0018\u00010 2\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\"H\u0016¢\u0006\u0002\u0010#R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R!\u0010\u0019\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\n0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001c¨\u0006$"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/ValueClassAwareCaller$MultiFieldValueClassPrimaryConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", com.taobao.weex.ui.component.WXBasicComponentType.CONTAINER, "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "constructorDesc", "", "originalParameters", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "<init>", "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/util/List;)V", "constructorImpl", "Ljava/lang/reflect/Method;", "boxMethod", "parameterUnboxMethods", "member", "getMember", "()Ljava/lang/Void;", "returnType", "Ljava/lang/reflect/Type;", "getReturnType", "()Ljava/lang/reflect/Type;", "originalParametersGroups", "Ljava/lang/Class;", "getOriginalParametersGroups", "()Ljava/util/List;", "parameterTypes", "getParameterTypes", androidx.core.app.NotificationCompat.CATEGORY_CALL, "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class MultiFieldValueClassPrimaryConstructorCaller implements kotlin.reflect.jvm.internal.calls.Caller {
        private final java.lang.reflect.Method boxMethod;
        private final java.lang.reflect.Method constructorImpl;
        private final java.util.List<java.util.List<java.lang.Class<?>>> originalParametersGroups;
        private final java.util.List<java.lang.reflect.Type> parameterTypes;
        private final java.util.List<java.util.List<java.lang.reflect.Method>> parameterUnboxMethods;

        public boolean default$isBoundInstanceCallWithValueClasses() {
            return false;
        }

        public java.lang.Void getMember() {
            return null;
        }

        public MultiFieldValueClassPrimaryConstructorCaller(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor descriptor, kotlin.reflect.jvm.internal.KDeclarationContainerImpl container, java.lang.String constructorDesc, java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor> originalParameters) {
            java.util.ArrayList arrayListListOf;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(container, "container");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(constructorDesc, "constructorDesc");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(originalParameters, "originalParameters");
            java.lang.reflect.Method methodFindMethodBySignature = container.findMethodBySignature("constructor-impl", constructorDesc);
            kotlin.jvm.internal.Intrinsics.checkNotNull(methodFindMethodBySignature);
            this.constructorImpl = methodFindMethodBySignature;
            java.lang.reflect.Method methodFindMethodBySignature2 = container.findMethodBySignature("box-impl", kotlin.text.StringsKt.removeSuffix(constructorDesc, (java.lang.CharSequence) "V") + kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.getDesc(container.getJClass()));
            kotlin.jvm.internal.Intrinsics.checkNotNull(methodFindMethodBySignature2);
            this.boxMethod = methodFindMethodBySignature2;
            java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor> list = originalParameters;
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
            java.util.Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                kotlin.reflect.jvm.internal.impl.types.KotlinType type = ((kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor) it.next()).getType();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
                arrayList.add(kotlin.reflect.jvm.internal.calls.ValueClassAwareCallerKt.getValueClassUnboxMethods(kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt.asSimpleType(type), descriptor));
            }
            this.parameterUnboxMethods = arrayList;
            java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
            int i = 0;
            for (java.lang.Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    kotlin.collections.CollectionsKt.throwIndexOverflow();
                }
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor classifierDescriptorMo1835getDeclarationDescriptor = ((kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor) obj).getType().getConstructor().mo1835getDeclarationDescriptor();
                kotlin.jvm.internal.Intrinsics.checkNotNull(classifierDescriptorMo1835getDeclarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor classDescriptor = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) classifierDescriptorMo1835getDeclarationDescriptor;
                java.util.List<java.lang.reflect.Method> list2 = this.parameterUnboxMethods.get(i);
                if (list2 == null) {
                    java.lang.Class<?> javaClass = kotlin.reflect.jvm.internal.UtilKt.toJavaClass(classDescriptor);
                    kotlin.jvm.internal.Intrinsics.checkNotNull(javaClass);
                    arrayListListOf = kotlin.collections.CollectionsKt.listOf(javaClass);
                } else {
                    java.util.List<java.lang.reflect.Method> list3 = list2;
                    java.util.ArrayList arrayList3 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list3, 10));
                    java.util.Iterator<T> it2 = list3.iterator();
                    while (it2.hasNext()) {
                        arrayList3.add(((java.lang.reflect.Method) it2.next()).getReturnType());
                    }
                    arrayListListOf = arrayList3;
                }
                arrayList2.add(arrayListListOf);
                i = i2;
            }
            java.util.ArrayList arrayList4 = arrayList2;
            this.originalParametersGroups = arrayList4;
            this.parameterTypes = kotlin.collections.CollectionsKt.flatten(arrayList4);
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        /* JADX INFO: renamed from: getMember */
        public /* bridge */ /* synthetic */ java.lang.reflect.Member mo1823getMember() {
            return (java.lang.reflect.Member) getMember();
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public boolean isBoundInstanceCallWithValueClasses() {
            return default$isBoundInstanceCallWithValueClasses();
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public java.lang.reflect.Type getReturnType() {
            java.lang.Class<?> returnType = this.boxMethod.getReturnType();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(returnType, "getReturnType(...)");
            return returnType;
        }

        public final java.util.List<java.util.List<java.lang.Class<?>>> getOriginalParametersGroups() {
            return this.originalParametersGroups;
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public java.util.List<java.lang.reflect.Type> getParameterTypes() {
            return this.parameterTypes;
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        public java.lang.Object call(java.lang.Object[] args) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
            java.util.ArrayList arrayListListOf;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(args, "args");
            java.util.List<kotlin.Pair> listZip = kotlin.collections.ArraysKt.zip(args, this.parameterUnboxMethods);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (kotlin.Pair pair : listZip) {
                java.lang.Object objComponent1 = pair.component1();
                java.util.List list = (java.util.List) pair.component2();
                if (list != null) {
                    java.util.List list2 = list;
                    java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list2, 10));
                    java.util.Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(((java.lang.reflect.Method) it.next()).invoke(objComponent1, null));
                    }
                    arrayListListOf = arrayList2;
                } else {
                    arrayListListOf = kotlin.collections.CollectionsKt.listOf(objComponent1);
                }
                kotlin.collections.CollectionsKt.addAll(arrayList, arrayListListOf);
            }
            java.lang.Object[] array = arrayList.toArray(new java.lang.Object[0]);
            this.constructorImpl.invoke(null, java.util.Arrays.copyOf(array, array.length));
            return this.boxMethod.invoke(null, java.util.Arrays.copyOf(array, array.length));
        }
    }
}
