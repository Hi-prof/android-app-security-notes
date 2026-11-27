package kotlin.reflect.full;

/* JADX INFO: compiled from: KCallables.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\u001a\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a6\u0010\u0012\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u00022\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00160\u0015\"\u0004\u0018\u00010\u0016H\u0087@¢\u0006\u0002\u0010\u0017\u001a4\u0010\u0018\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u00022\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0019H\u0087@¢\u0006\u0002\u0010\u001a\"$\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"$\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"instanceParameter", "Lkotlin/reflect/KParameter;", "Lkotlin/reflect/KCallable;", "getInstanceParameter$annotations", "(Lkotlin/reflect/KCallable;)V", "getInstanceParameter", "(Lkotlin/reflect/KCallable;)Lkotlin/reflect/KParameter;", "extensionReceiverParameter", "getExtensionReceiverParameter$annotations", "getExtensionReceiverParameter", "valueParameters", "", "getValueParameters$annotations", "getValueParameters", "(Lkotlin/reflect/KCallable;)Ljava/util/List;", "findParameterByName", "name", "", "callSuspend", "R", "args", "", "", "(Lkotlin/reflect/KCallable;[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callSuspendBy", "", "(Lkotlin/reflect/KCallable;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KCallables {

    /* JADX INFO: renamed from: kotlin.reflect.full.KCallables$callSuspend$1, reason: invalid class name */
    /* JADX INFO: compiled from: KCallables.kt */
    @kotlin.Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final class AnonymousClass1<R> extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        java.lang.Object L$0;
        java.lang.Object L$1;
        int label;
        /* synthetic */ java.lang.Object result;

        AnonymousClass1(kotlin.coroutines.Continuation<? super kotlin.reflect.full.KCallables.AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return kotlin.reflect.full.KCallables.callSuspend(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.full.KCallables$callSuspendBy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: KCallables.kt */
    @kotlin.Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final class C01211<R> extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        int label;
        /* synthetic */ java.lang.Object result;

        C01211(kotlin.coroutines.Continuation<? super kotlin.reflect.full.KCallables.C01211> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return kotlin.reflect.full.KCallables.callSuspendBy(null, null, this);
        }
    }

    public static /* synthetic */ void getExtensionReceiverParameter$annotations(kotlin.reflect.KCallable kCallable) {
    }

    public static /* synthetic */ void getInstanceParameter$annotations(kotlin.reflect.KCallable kCallable) {
    }

    public static /* synthetic */ void getValueParameters$annotations(kotlin.reflect.KCallable kCallable) {
    }

    public static final kotlin.reflect.KParameter getInstanceParameter(kotlin.reflect.KCallable<?> kCallable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kCallable, "<this>");
        java.lang.Object obj = null;
        boolean z = false;
        java.lang.Object obj2 = null;
        for (java.lang.Object obj3 : kCallable.getParameters()) {
            if (((kotlin.reflect.KParameter) obj3).getKind() == kotlin.reflect.KParameter.Kind.INSTANCE) {
                if (z) {
                    return (kotlin.reflect.KParameter) obj;
                }
                z = true;
                obj2 = obj3;
            }
        }
        if (z) {
            obj = obj2;
        }
        return (kotlin.reflect.KParameter) obj;
    }

    public static final kotlin.reflect.KParameter getExtensionReceiverParameter(kotlin.reflect.KCallable<?> kCallable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kCallable, "<this>");
        java.lang.Object obj = null;
        boolean z = false;
        java.lang.Object obj2 = null;
        for (java.lang.Object obj3 : kCallable.getParameters()) {
            if (((kotlin.reflect.KParameter) obj3).getKind() == kotlin.reflect.KParameter.Kind.EXTENSION_RECEIVER) {
                if (z) {
                    return (kotlin.reflect.KParameter) obj;
                }
                z = true;
                obj2 = obj3;
            }
        }
        if (z) {
            obj = obj2;
        }
        return (kotlin.reflect.KParameter) obj;
    }

    public static final java.util.List<kotlin.reflect.KParameter> getValueParameters(kotlin.reflect.KCallable<?> kCallable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kCallable, "<this>");
        java.util.List<kotlin.reflect.KParameter> parameters = kCallable.getParameters();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : parameters) {
            if (((kotlin.reflect.KParameter) obj).getKind() == kotlin.reflect.KParameter.Kind.VALUE) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final kotlin.reflect.KParameter findParameterByName(kotlin.reflect.KCallable<?> kCallable, java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kCallable, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        java.lang.Object obj = null;
        boolean z = false;
        java.lang.Object obj2 = null;
        for (java.lang.Object obj3 : kCallable.getParameters()) {
            if (kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.KParameter) obj3).getName(), name)) {
                if (z) {
                    return (kotlin.reflect.KParameter) obj;
                }
                z = true;
                obj2 = obj3;
            }
        }
        if (z) {
            obj = obj2;
        }
        return (kotlin.reflect.KParameter) obj;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <R> java.lang.Object callSuspend(kotlin.reflect.KCallable<? extends R> kCallable, java.lang.Object[] objArr, kotlin.coroutines.Continuation<? super R> continuation) {
        kotlin.reflect.full.KCallables.AnonymousClass1 anonymousClass1;
        if (continuation instanceof kotlin.reflect.full.KCallables.AnonymousClass1) {
            anonymousClass1 = (kotlin.reflect.full.KCallables.AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new kotlin.reflect.full.KCallables.AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new kotlin.reflect.full.KCallables.AnonymousClass1(continuation);
        }
        java.lang.Object objCall = anonymousClass1.result;
        java.lang.Object coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            kotlin.ResultKt.throwOnFailure(objCall);
            if (!kCallable.isSuspend()) {
                return kCallable.call(java.util.Arrays.copyOf(objArr, objArr.length));
            }
            if (!(kCallable instanceof kotlin.reflect.KFunction)) {
                throw new java.lang.IllegalArgumentException("Cannot callSuspend on a property " + kCallable + ": suspend properties are not supported yet");
            }
            anonymousClass1.L$0 = kCallable;
            anonymousClass1.L$1 = objArr;
            anonymousClass1.label = 1;
            kotlin.reflect.full.KCallables.AnonymousClass1 anonymousClass2 = anonymousClass1;
            kotlin.jvm.internal.SpreadBuilder spreadBuilder = new kotlin.jvm.internal.SpreadBuilder(2);
            spreadBuilder.addSpread(objArr);
            spreadBuilder.add(anonymousClass2);
            objCall = kCallable.call(spreadBuilder.toArray(new java.lang.Object[spreadBuilder.size()]));
            if (objCall == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(anonymousClass2);
            }
            if (objCall == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kCallable = (kotlin.reflect.KCallable) anonymousClass1.L$0;
            kotlin.ResultKt.throwOnFailure(objCall);
        }
        kotlin.reflect.KFunction kFunction = (kotlin.reflect.KFunction) kCallable;
        return (!kotlin.jvm.internal.Intrinsics.areEqual(kFunction.getReturnType().getClassifier(), kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(kotlin.Unit.class)) || kFunction.getReturnType().isMarkedNullable()) ? objCall : kotlin.Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <R> java.lang.Object callSuspendBy(kotlin.reflect.KCallable<? extends R> kCallable, java.util.Map<kotlin.reflect.KParameter, ? extends java.lang.Object> map, kotlin.coroutines.Continuation<? super R> continuation) throws kotlin.reflect.full.IllegalCallableAccessException {
        kotlin.reflect.full.KCallables.C01211 c01211;
        if (continuation instanceof kotlin.reflect.full.KCallables.C01211) {
            c01211 = (kotlin.reflect.full.KCallables.C01211) continuation;
            if ((c01211.label & Integer.MIN_VALUE) != 0) {
                c01211.label -= Integer.MIN_VALUE;
            } else {
                c01211 = new kotlin.reflect.full.KCallables.C01211(continuation);
            }
        } else {
            c01211 = new kotlin.reflect.full.KCallables.C01211(continuation);
        }
        java.lang.Object objCallDefaultMethod$kotlin_reflection = c01211.result;
        java.lang.Object coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01211.label;
        if (i == 0) {
            kotlin.ResultKt.throwOnFailure(objCallDefaultMethod$kotlin_reflection);
            if (!kCallable.isSuspend()) {
                return kCallable.callBy(map);
            }
            if (!(kCallable instanceof kotlin.reflect.KFunction)) {
                throw new java.lang.IllegalArgumentException("Cannot callSuspendBy on a property " + kCallable + ": suspend properties are not supported yet");
            }
            kotlin.reflect.jvm.internal.KCallableImpl<?> kCallableImplAsKCallableImpl = kotlin.reflect.jvm.internal.UtilKt.asKCallableImpl(kCallable);
            if (kCallableImplAsKCallableImpl == null) {
                throw new kotlin.reflect.jvm.internal.KotlinReflectionInternalError("This callable does not support a default call: " + kCallable);
            }
            c01211.L$0 = kCallable;
            c01211.L$1 = map;
            c01211.L$2 = kCallableImplAsKCallableImpl;
            c01211.label = 1;
            kotlin.reflect.full.KCallables.C01211 c01212 = c01211;
            objCallDefaultMethod$kotlin_reflection = kCallableImplAsKCallableImpl.callDefaultMethod$kotlin_reflection(map, c01212);
            if (objCallDefaultMethod$kotlin_reflection == kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(c01212);
            }
            if (objCallDefaultMethod$kotlin_reflection == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kCallable = (kotlin.reflect.KCallable) c01211.L$0;
            kotlin.ResultKt.throwOnFailure(objCallDefaultMethod$kotlin_reflection);
        }
        kotlin.reflect.KFunction kFunction = (kotlin.reflect.KFunction) kCallable;
        return (!kotlin.jvm.internal.Intrinsics.areEqual(kFunction.getReturnType().getClassifier(), kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(kotlin.Unit.class)) || kFunction.getReturnType().isMarkedNullable()) ? objCallDefaultMethod$kotlin_reflection : kotlin.Unit.INSTANCE;
    }
}
