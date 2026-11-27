package io.dcloud.uts;

/* JADX INFO: compiled from: UTSPromise.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a \u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004\u001a$\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00072\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n\u001a\u001a\u0010\u000b\u001a\u00020\u00062\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\r\u001a\u00020\u000e\u001a\u001c\u0010\u000f\u001a\u00020\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u001a\u001c\u0010\u0011\u001a\u00020\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u001a\u0012\u0010\u0012\u001a\u00020\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n¨\u0006\u0013"}, d2 = {"callFunction", "", "fn", "args", "Lio/dcloud/uts/UTSArray;", "doResolveUTSPromise", "", "T", "Lkotlin/Function;", "self", "Lio/dcloud/uts/UTSPromise;", "handleUTSPromise", "promise", "deferred", "Lio/dcloud/uts/UTSPromiseHandler;", "resolveUTSPromise", "newValue", "rejectUTSPromise", "finaleUTSPromise", "utsplugin_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UTSPromiseKt {
    public static final java.lang.Object callFunction(final java.lang.Object fn, final io.dcloud.uts.UTSArray<java.lang.Object> args) {
        java.lang.reflect.Method method;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fn, "fn");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(args, "args");
        if (fn instanceof kotlin.Function) {
            java.lang.reflect.Method[] declaredMethods = fn.getClass().getDeclaredMethods();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            java.lang.reflect.Method[] methodArr = declaredMethods;
            int length = methodArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    method = null;
                    break;
                }
                method = methodArr[i];
                java.lang.reflect.Method method2 = method;
                if (kotlin.jvm.internal.Intrinsics.areEqual("invoke", method2.getName()) && !method2.isBridge()) {
                    break;
                }
                i++;
            }
            final java.lang.reflect.Method method3 = method;
            if (method3 != null) {
                method3.setAccessible(true);
                return new kotlin.jvm.functions.Function0() { // from class: io.dcloud.uts.UTSPromiseKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final java.lang.Object invoke() {
                        return io.dcloud.uts.UTSPromiseKt.callFunction$lambda$2(args, method3, fn);
                    }
                }.invoke();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.lang.Object callFunction$lambda$2(io.dcloud.uts.UTSArray<java.lang.Object> uTSArray, java.lang.reflect.Method method, java.lang.Object obj) throws java.lang.Throwable {
        io.dcloud.uts.UTSArray<java.lang.Object> uTSArraySlice = uTSArray.slice((java.lang.Number) 0, java.lang.Integer.valueOf(method.getParameterTypes().length));
        kotlin.jvm.internal.Intrinsics.checkNotNull(method);
        if (method.isVarArgs()) {
            int length = method.getParameterTypes().length - 1;
            java.lang.Class<?> cls = method.getParameterTypes()[length];
            kotlin.jvm.internal.Intrinsics.checkNotNull(cls);
            kotlin.jvm.internal.Intrinsics.checkNotNull(cls);
            java.lang.Class<?> componentType = cls.getComponentType();
            io.dcloud.uts.UTSArray uTSArraySlice$default = io.dcloud.uts.UTSArray.slice$default(uTSArray, java.lang.Integer.valueOf(length), null, 2, null);
            java.lang.Number length2 = uTSArraySlice$default.getLength();
            kotlin.jvm.internal.Intrinsics.checkNotNull(length2, "null cannot be cast to non-null type kotlin.Int");
            final java.lang.Object objNewInstance = java.lang.reflect.Array.newInstance(componentType, ((java.lang.Integer) length2).intValue());
            uTSArraySlice$default.forEach(new kotlin.jvm.functions.Function2() { // from class: io.dcloud.uts.UTSPromiseKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final java.lang.Object invoke(java.lang.Object obj2, java.lang.Object obj3) {
                    return io.dcloud.uts.UTSPromiseKt.callFunction$lambda$2$lambda$1(objNewInstance, obj2, (java.lang.Number) obj3);
                }
            });
            if (io.dcloud.uts.NumberKt.compareTo(uTSArraySlice.getLength(), java.lang.Integer.valueOf(length)) > 0) {
                uTSArraySlice.set(length, objNewInstance);
            } else {
                uTSArraySlice.push(objNewInstance);
            }
        }
        try {
            java.lang.Object[] array = uTSArraySlice.splice((java.lang.Number) 0, java.lang.Integer.valueOf(method.getParameterTypes().length)).toArray(new java.lang.Object[0]);
            return method.invoke(obj, java.util.Arrays.copyOf(array, array.length));
        } catch (java.lang.Throwable th) {
            if (th instanceof java.lang.reflect.InvocationTargetException) {
                java.lang.reflect.InvocationTargetException invocationTargetException = th;
                if (invocationTargetException.getCause() != null) {
                    java.lang.Throwable cause = invocationTargetException.getCause();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(cause);
                    throw cause;
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit callFunction$lambda$2$lambda$1(java.lang.Object obj, java.lang.Object obj2, java.lang.Number number) {
        kotlin.jvm.internal.Intrinsics.checkNotNull(number, "null cannot be cast to non-null type kotlin.Int");
        java.lang.reflect.Array.set(obj, ((java.lang.Integer) number).intValue(), obj2);
        return kotlin.Unit.INSTANCE;
    }

    public static final <T> void doResolveUTSPromise(kotlin.Function<?> fn, final io.dcloud.uts.UTSPromise<?> self) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(fn, "fn");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(self, "self");
        final kotlin.jvm.internal.Ref.BooleanRef booleanRef = new kotlin.jvm.internal.Ref.BooleanRef();
        try {
            callFunction(fn, io.dcloud.uts.UTSArrayKt.utsArrayOf(new kotlin.jvm.functions.Function1() { // from class: io.dcloud.uts.UTSPromiseKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public final java.lang.Object invoke2(java.lang.Object obj) {
                    return io.dcloud.uts.UTSPromiseKt.doResolveUTSPromise$lambda$3(booleanRef, self, obj);
                }
            }, new kotlin.jvm.functions.Function1() { // from class: io.dcloud.uts.UTSPromiseKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: invoke */
                public final java.lang.Object invoke2(java.lang.Object obj) {
                    return io.dcloud.uts.UTSPromiseKt.doResolveUTSPromise$lambda$4(booleanRef, self, obj);
                }
            }));
        } catch (java.lang.Throwable th) {
            if (booleanRef.element) {
                return;
            }
            booleanRef.element = true;
            rejectUTSPromise(self, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> kotlin.Unit doResolveUTSPromise$lambda$3(kotlin.jvm.internal.Ref.BooleanRef booleanRef, io.dcloud.uts.UTSPromise<?> uTSPromise, T t) {
        if (booleanRef.element) {
            return kotlin.Unit.INSTANCE;
        }
        booleanRef.element = true;
        resolveUTSPromise(uTSPromise, t);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit doResolveUTSPromise$lambda$4(kotlin.jvm.internal.Ref.BooleanRef booleanRef, io.dcloud.uts.UTSPromise<?> uTSPromise, java.lang.Object obj) {
        if (booleanRef.element) {
            return kotlin.Unit.INSTANCE;
        }
        booleanRef.element = true;
        rejectUTSPromise(uTSPromise, obj);
        return kotlin.Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v18, types: [T, io.dcloud.uts.UTSPromise] */
    public static final void handleUTSPromise(io.dcloud.uts.UTSPromise<?> promise, final io.dcloud.uts.UTSPromiseHandler deferred) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(promise, "promise");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(deferred, "deferred");
        final kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
        objectRef.element = promise;
        while (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) ((io.dcloud.uts.UTSPromise) objectRef.element).get_state(), (java.lang.Object) 3)) {
            java.lang.Object obj = ((io.dcloud.uts.UTSPromise) objectRef.element).get_value();
            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type io.dcloud.uts.UTSPromise<*>");
            objectRef.element = (io.dcloud.uts.UTSPromise) obj;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) ((io.dcloud.uts.UTSPromise) objectRef.element).get_state(), (java.lang.Object) 0)) {
            io.dcloud.uts.UTSArray<io.dcloud.uts.UTSPromiseHandler> uTSArray = ((io.dcloud.uts.UTSPromise) objectRef.element).get_deferreds();
            kotlin.jvm.internal.Intrinsics.checkNotNull(uTSArray);
            uTSArray.push(deferred);
        } else {
            ((io.dcloud.uts.UTSPromise) objectRef.element).set_handled(true);
            io.dcloud.uts.UTSPromise.INSTANCE._immediateFn(new kotlin.jvm.functions.Function0() { // from class: io.dcloud.uts.UTSPromiseKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final java.lang.Object invoke() {
                    return io.dcloud.uts.UTSPromiseKt.handleUTSPromise$lambda$5(objectRef, deferred);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit handleUTSPromise$lambda$5(kotlin.jvm.internal.Ref.ObjectRef<io.dcloud.uts.UTSPromise<?>> objectRef, io.dcloud.uts.UTSPromiseHandler uTSPromiseHandler) {
        kotlin.Function<?> onRejected;
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) objectRef.element.get_state(), (java.lang.Object) 1)) {
            onRejected = uTSPromiseHandler.getOnFulfilled();
        } else {
            onRejected = uTSPromiseHandler.getOnRejected();
        }
        if (onRejected == null) {
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) objectRef.element.get_state(), (java.lang.Object) 1)) {
                resolveUTSPromise(uTSPromiseHandler.getPromise(), objectRef.element.get_value());
            } else {
                rejectUTSPromise(uTSPromiseHandler.getPromise(), objectRef.element.get_value());
            }
            return kotlin.Unit.INSTANCE;
        }
        try {
            resolveUTSPromise(uTSPromiseHandler.getPromise(), callFunction(onRejected, io.dcloud.uts.UTSArrayKt.utsArrayOf(objectRef.element.get_value())));
            return kotlin.Unit.INSTANCE;
        } catch (java.lang.Throwable th) {
            rejectUTSPromise(uTSPromiseHandler.getPromise(), th);
            return kotlin.Unit.INSTANCE;
        }
    }

    public static final void resolveUTSPromise(io.dcloud.uts.UTSPromise<?> self, java.lang.Object obj) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(self, "self");
        try {
            if (obj == self) {
                throw new io.dcloud.uts.UTSError("A promise cannot be resolved with itself.");
            }
            if (obj != null && (obj instanceof io.dcloud.uts.UTSPromise)) {
                self.set_state((java.lang.Number) 3);
                self.set_value(obj);
                finaleUTSPromise(self);
            } else {
                self.set_state((java.lang.Number) 1);
                self.set_value(obj);
                finaleUTSPromise(self);
            }
        } catch (java.lang.Throwable th) {
            rejectUTSPromise(self, th);
        }
    }

    public static final void rejectUTSPromise(io.dcloud.uts.UTSPromise<?> self, java.lang.Object obj) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(self, "self");
        self.set_state((java.lang.Number) 2);
        self.set_value(obj);
        finaleUTSPromise(self);
    }

    public static final void finaleUTSPromise(final io.dcloud.uts.UTSPromise<?> self) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(self, "self");
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) self.get_state(), (java.lang.Object) 2)) {
            io.dcloud.uts.UTSArray<io.dcloud.uts.UTSPromiseHandler> uTSArray = self.get_deferreds();
            kotlin.jvm.internal.Intrinsics.checkNotNull(uTSArray);
            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) uTSArray.getLength(), (java.lang.Object) 0)) {
                io.dcloud.uts.UTSPromise.INSTANCE._immediateFn(new kotlin.jvm.functions.Function0() { // from class: io.dcloud.uts.UTSPromiseKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final java.lang.Object invoke() {
                        return io.dcloud.uts.UTSPromiseKt.finaleUTSPromise$lambda$6(self);
                    }
                });
            }
        }
        io.dcloud.uts.UTSArray<io.dcloud.uts.UTSPromiseHandler> uTSArray2 = self.get_deferreds();
        kotlin.jvm.internal.Intrinsics.checkNotNull(uTSArray2);
        java.lang.Number length = uTSArray2.getLength();
        for (java.lang.Integer numValueOf = (java.lang.Number) 0; io.dcloud.uts.NumberKt.compareTo(numValueOf, length) < 0; numValueOf = java.lang.Integer.valueOf(numValueOf.intValue() + 1)) {
            io.dcloud.uts.UTSArray<io.dcloud.uts.UTSPromiseHandler> uTSArray3 = self.get_deferreds();
            kotlin.jvm.internal.Intrinsics.checkNotNull(uTSArray3);
            io.dcloud.uts.UTSPromiseHandler uTSPromiseHandler = uTSArray3.get(numValueOf.intValue());
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(uTSPromiseHandler, "get(...)");
            handleUTSPromise(self, uTSPromiseHandler);
        }
        self.set_deferreds(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit finaleUTSPromise$lambda$6(io.dcloud.uts.UTSPromise<?> uTSPromise) {
        if (!uTSPromise.get_handled()) {
            io.dcloud.uts.UTSPromise.INSTANCE._unhandledRejectionFn(uTSPromise.get_value());
        }
        return kotlin.Unit.INSTANCE;
    }
}
