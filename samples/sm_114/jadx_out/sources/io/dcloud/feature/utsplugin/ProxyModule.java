package io.dcloud.feature.utsplugin;

/* JADX INFO: compiled from: UTSProxyModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0003;<=B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J+\u0010\u0012\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0002\u0010\u0018J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001c2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J2\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010!2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001c2\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J,\u0010#\u001a\u0004\u0018\u00010$2\n\u0010%\u001a\u0006\u0012\u0002\b\u00030!2\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u0014H\u0086@¢\u0006\u0002\u0010'J:\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u001f2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001c2\b\u0010+\u001a\u0004\u0018\u00010$2\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/H\u0002J\"\u00100\u001a\u0004\u0018\u00010$2\u0006\u00101\u001a\u00020)2\b\u0010,\u001a\u0004\u0018\u00010-H\u0087@¢\u0006\u0002\u00102J6\u00103\u001a\u0002H4\"\u0004\b\u0000\u00104*\b\u0012\u0004\u0012\u0002H4052\u0016\u00106\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010$0\u0014\"\u0004\u0018\u00010$H\u0087@¢\u0006\u0002\u00107J \u00108\u001a\u00020\u00062\u0006\u00101\u001a\u00020)2\b\u0010,\u001a\u0004\u0018\u00010-H\u0097@¢\u0006\u0002\u00102J\b\u00109\u001a\u00020:H\u0016¨\u0006>"}, d2 = {"Lio/dcloud/feature/utsplugin/ProxyModule;", "Lio/dcloud/feature/uniapp/common/UniModule;", "Lio/dcloud/common/DHInterface/message/IObserveAble;", "<init>", "()V", "onActivityPause", "", "onActivityResult", com.taobao.weex.common.WXModule.REQUEST_CODE, "", com.taobao.weex.common.WXModule.RESULT_CODE, "data", "Landroid/content/Intent;", "onActivityResume", "onActivityStop", "onActivityDestroy", "onActivityBack", "", "onRequestPermissionsResult", "permissions", "", "", com.taobao.weex.common.WXModule.GRANT_RESULTS, "", "(I[Ljava/lang/String;[I)V", "findTargetMethod", "Ljava/lang/reflect/Method;", "javaClazz", "Ljava/lang/Class;", "methodName", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_OPTION, "Lio/dcloud/feature/utsplugin/ProxyModule$InputOption;", "findTargetFunc", "Lkotlin/reflect/KFunction;", "isCompanion", "getFunctionExecuteRet", "", "targetFunction", "paramArray", "(Lkotlin/reflect/KFunction;[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wrapDoTypeAction", "Lcom/alibaba/fastjson/JSONObject;", "inputOption", "targetInstance", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK, "Lcom/taobao/weex/bridge/JSCallback;", "errRet", "Lio/dcloud/feature/utsplugin/ReturnResult;", "invokeSync", "options", "(Lcom/alibaba/fastjson/JSONObject;Lcom/taobao/weex/bridge/JSCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callSuspend", "R", "Lkotlin/reflect/KCallable;", "args", "(Lkotlin/reflect/KCallable;[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeAsync", "getActionObserverID", "Lio/dcloud/common/DHInterface/message/EnumUniqueID;", "Companion", "InputOption", "ModuleChecker", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ProxyModule extends io.dcloud.feature.uniapp.common.UniModule implements io.dcloud.common.DHInterface.message.IObserveAble {
    private static int instanceDynamicId;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final io.dcloud.feature.utsplugin.ProxyModule.Companion INSTANCE = new io.dcloud.feature.utsplugin.ProxyModule.Companion(null);
    private static java.util.Map<java.lang.Integer, java.lang.Object> utsInstances = new java.util.LinkedHashMap();

    /* JADX INFO: renamed from: io.dcloud.feature.utsplugin.ProxyModule$callSuspend$1, reason: invalid class name */
    /* JADX INFO: compiled from: UTSProxyModule.kt */
    @kotlin.Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "io.dcloud.feature.utsplugin.ProxyModule", f = "UTSProxyModule.kt", i = {0, 0}, l = {1054}, m = "callSuspend", n = {"$this$callSuspend", "args"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1<R> extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        java.lang.Object L$0;
        java.lang.Object L$1;
        int label;
        /* synthetic */ java.lang.Object result;

        AnonymousClass1(kotlin.coroutines.Continuation<? super io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return io.dcloud.feature.utsplugin.ProxyModule.this.callSuspend(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.dcloud.feature.utsplugin.ProxyModule$getFunctionExecuteRet$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UTSProxyModule.kt */
    @kotlin.Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "io.dcloud.feature.utsplugin.ProxyModule", f = "UTSProxyModule.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {646, 647, 649}, m = "getFunctionExecuteRet", n = {"targetFunction", "paramArray", "targetFunction", "paramArray", "suspendRet", "targetFunction", "paramArray"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1"})
    static final class C01051 extends kotlin.coroutines.jvm.internal.ContinuationImpl {
        java.lang.Object L$0;
        java.lang.Object L$1;
        java.lang.Object L$2;
        int label;
        /* synthetic */ java.lang.Object result;

        C01051(kotlin.coroutines.Continuation<? super io.dcloud.feature.utsplugin.ProxyModule.C01051> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return io.dcloud.feature.utsplugin.ProxyModule.this.getFunctionExecuteRet(null, null, this);
        }
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityDestroy() {
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityPause() {
        java.util.Iterator<kotlin.jvm.functions.Function0<kotlin.Unit>> it = io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPauseListenFunc().iterator();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().invoke();
        }
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityResult(int requestCode, int resultCode, android.content.Intent data) {
        java.util.Iterator<kotlin.jvm.functions.Function3<java.lang.Integer, java.lang.Integer, android.content.Intent, kotlin.Unit>> it = io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getOnActivityResultListenFunc().iterator();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().invoke(java.lang.Integer.valueOf(requestCode), java.lang.Integer.valueOf(resultCode), data);
        }
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityResume() {
        java.util.Iterator<kotlin.jvm.functions.Function0<kotlin.Unit>> it = io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getResumeListenFunc().iterator();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().invoke();
        }
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityStop() {
        super.onActivityStop();
        java.util.Iterator<kotlin.jvm.functions.Function0<kotlin.Unit>> it = io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getStopListenFunc().iterator();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().invoke();
        }
    }

    @Override // com.taobao.weex.common.WXModule
    public boolean onActivityBack() {
        java.util.Iterator<kotlin.jvm.functions.Function0<kotlin.Unit>> it = io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getBackListenFunc().iterator();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().invoke();
        }
        return false;
    }

    @Override // com.taobao.weex.common.WXModule
    public void onRequestPermissionsResult(int requestCode, java.lang.String[] permissions, int[] grantResults) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(permissions, "permissions");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        java.util.List listMutableListOf = kotlin.collections.CollectionsKt.mutableListOf(java.util.Arrays.copyOf(permissions, permissions.length));
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i : grantResults) {
            arrayList.add(java.lang.Integer.valueOf(i));
        }
        java.util.Iterator<kotlin.jvm.functions.Function3<java.lang.Integer, io.dcloud.uts.UTSArray<java.lang.String>, io.dcloud.uts.UTSArray<java.lang.Number>, kotlin.Unit>> it = io.dcloud.uts.android.AndroidUTSContext.INSTANCE.getPermissionsResultListenFunc().iterator();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().invoke(java.lang.Integer.valueOf(requestCode), io.dcloud.uts.UTSArray.INSTANCE.fromNative(listMutableListOf), io.dcloud.uts.UTSArray.INSTANCE.fromNative(arrayList));
        }
    }

    private final java.lang.reflect.Method findTargetMethod(java.lang.Class<?> javaClazz, java.lang.String methodName, io.dcloud.feature.utsplugin.ProxyModule.InputOption option) {
        java.util.Iterator it = kotlin.jvm.internal.ArrayIteratorKt.iterator(javaClazz.getMethods());
        java.lang.reflect.Method method = null;
        while (it.hasNext()) {
            java.lang.reflect.Method method2 = (java.lang.reflect.Method) it.next();
            if (kotlin.jvm.internal.Intrinsics.areEqual(methodName, method2.getName()) && option.getParamArray().size() == kotlin.UByte$$ExternalSyntheticBackport0.m(method2)) {
                int iM = kotlin.UByte$$ExternalSyntheticBackport0.m(method2);
                boolean z = true;
                for (int i = 0; i < iM; i++) {
                    if (!method2.getParameterTypes()[i].isInstance(option.getParamArray().get(i))) {
                        z = false;
                    }
                }
                if (z) {
                    return method2;
                }
                method = method2;
            }
        }
        return method;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:39:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:46:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00d9 A[EDGE_INSN: B:59:0x00d9->B:45:0x00d9 BREAK  A[LOOP:2: B:12:0x0037->B:63:0x0037], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x00d1 A[SYNTHETIC] */
    private final kotlin.reflect.KFunction<?> findTargetFunc(java.lang.Class<?> javaClazz, boolean isCompanion, java.lang.String methodName, io.dcloud.feature.utsplugin.ProxyModule.InputOption option) {
        java.lang.reflect.Method method;
        java.lang.reflect.Method method2;
        int iM;
        boolean z;
        int i;
        int i2;
        java.util.List<kotlin.reflect.KParameter> parameters;
        if (isCompanion) {
            kotlin.reflect.KClass<?> companionObject = kotlin.reflect.full.KClasses.getCompanionObject(kotlin.jvm.JvmClassMappingKt.getKotlinClass(javaClazz));
            kotlin.jvm.internal.Intrinsics.checkNotNull(companionObject);
            for (kotlin.reflect.KFunction<?> kFunction : kotlin.reflect.full.KClasses.getMemberFunctions(companionObject)) {
                if (kotlin.jvm.internal.Intrinsics.areEqual(methodName, kFunction.getName())) {
                    return kFunction;
                }
            }
        } else {
            java.util.Iterator it = kotlin.jvm.internal.ArrayIteratorKt.iterator(javaClazz.getMethods());
            java.lang.reflect.Method method3 = null;
            loop1: while (true) {
                method = method3;
                while (true) {
                    if (!it.hasNext()) {
                        break loop1;
                    }
                    method2 = (java.lang.reflect.Method) it.next();
                    if (kotlin.jvm.internal.Intrinsics.areEqual(methodName, method2.getName())) {
                        if (option.getParamArray().size() == 0) {
                            kotlin.jvm.internal.Intrinsics.checkNotNull(method2);
                            kotlin.reflect.KFunction<?> kotlinFunction = kotlin.reflect.jvm.ReflectJvmMapping.getKotlinFunction(method2);
                            if (kotlinFunction == null || (parameters = kotlinFunction.getParameters()) == null) {
                                i2 = 0;
                            } else {
                                java.util.List<kotlin.reflect.KParameter> list = parameters;
                                java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
                                i2 = 0;
                                for (kotlin.reflect.KParameter kParameter : list) {
                                    if (!kParameter.getType().isMarkedNullable() && !kParameter.isOptional()) {
                                        i2++;
                                    }
                                    arrayList.add(kotlin.Unit.INSTANCE);
                                }
                            }
                            if (i2 == 0) {
                                break;
                            }
                            if (option.getParamArray().size() == kotlin.UByte$$ExternalSyntheticBackport0.m(method2)) {
                                iM = kotlin.UByte$$ExternalSyntheticBackport0.m(method2);
                                z = true;
                                for (i = 0; i < iM; i++) {
                                    if (!method2.getParameterTypes()[i].isInstance(option.getParamArray().get(i))) {
                                        z = false;
                                    }
                                }
                                if (z) {
                                    break;
                                }
                                method3 = method2;
                                method = method3;
                                break;
                            }
                            method = method2;
                        } else {
                            if (option.getParamArray().size() == kotlin.UByte$$ExternalSyntheticBackport0.m(method2)) {
                                iM = kotlin.UByte$$ExternalSyntheticBackport0.m(method2);
                                z = true;
                                while (i < iM) {
                                    if (!method2.getParameterTypes()[i].isInstance(option.getParamArray().get(i))) {
                                        z = false;
                                    }
                                }
                                if (z) {
                                    break;
                                    break;
                                }
                                method3 = method2;
                                method = method3;
                                break;
                            }
                            method = method2;
                        }
                    }
                }
                method3 = method2;
            }
            if (method3 != null) {
                return kotlin.reflect.jvm.ReflectJvmMapping.getKotlinFunction(method3);
            }
            if (method != null) {
                return kotlin.reflect.jvm.ReflectJvmMapping.getKotlinFunction(method);
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: UTSProxyModule.kt */
    @kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lio/dcloud/feature/utsplugin/ProxyModule$Companion;", "", "<init>", "()V", "instanceDynamicId", "", "getInstanceDynamicId", "()I", "setInstanceDynamicId", "(I)V", "utsInstances", "", "getUtsInstances", "()Ljava/util/Map;", "setUtsInstances", "(Ljava/util/Map;)V", "findTargetField", "Lkotlin/reflect/KCallable;", "javaClazz", "Ljava/lang/Class;", "isCompanion", "", "methodName", "", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getInstanceDynamicId() {
            return io.dcloud.feature.utsplugin.ProxyModule.instanceDynamicId;
        }

        public final void setInstanceDynamicId(int i) {
            io.dcloud.feature.utsplugin.ProxyModule.instanceDynamicId = i;
        }

        public final java.util.Map<java.lang.Integer, java.lang.Object> getUtsInstances() {
            return io.dcloud.feature.utsplugin.ProxyModule.utsInstances;
        }

        public final void setUtsInstances(java.util.Map<java.lang.Integer, java.lang.Object> map) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<set-?>");
            io.dcloud.feature.utsplugin.ProxyModule.utsInstances = map;
        }

        public final kotlin.reflect.KCallable<?> findTargetField(java.lang.Class<?> javaClazz, boolean isCompanion, java.lang.String methodName) {
            java.lang.reflect.Field[] declaredFields;
            java.util.Collection<kotlin.reflect.KProperty1> memberProperties;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(javaClazz, "javaClazz");
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(methodName, "methodName");
            if (isCompanion) {
                kotlin.reflect.KClass<?> companionObject = kotlin.reflect.full.KClasses.getCompanionObject(kotlin.jvm.JvmClassMappingKt.getKotlinClass(javaClazz));
                kotlin.jvm.internal.Intrinsics.checkNotNull(companionObject);
                for (kotlin.reflect.KCallable<?> kCallable : companionObject.getMembers()) {
                    if (kotlin.jvm.internal.Intrinsics.areEqual(methodName, kCallable.getName())) {
                        return kCallable;
                    }
                }
                return null;
            }
            try {
                memberProperties = kotlin.reflect.full.KClasses.getMemberProperties(kotlin.jvm.JvmClassMappingKt.getKotlinClass(javaClazz));
                declaredFields = null;
            } catch (java.lang.Exception unused) {
                declaredFields = javaClazz.getDeclaredFields();
                memberProperties = null;
            }
            if (memberProperties != null) {
                for (kotlin.reflect.KProperty1 kProperty1 : memberProperties) {
                    if (kotlin.jvm.internal.Intrinsics.areEqual(methodName, kProperty1.getName())) {
                        return kProperty1;
                    }
                }
                return null;
            }
            if (declaredFields == null || declaredFields.length == 0) {
                return null;
            }
            java.util.Iterator it = kotlin.jvm.internal.ArrayIteratorKt.iterator(declaredFields);
            while (it.hasNext()) {
                java.lang.reflect.Field field = (java.lang.reflect.Field) it.next();
                if (kotlin.jvm.internal.Intrinsics.areEqual(methodName, field.getName())) {
                    return kotlin.reflect.jvm.ReflectJvmMapping.getKotlinProperty(field);
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: UTSProxyModule.kt */
    @kotlin.Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010<2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010\"\u001a\u00020\u001cJ0\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010<2\n\u0010=\u001a\u0006\u0012\u0002\b\u00030A2\b\u0010?\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010\"\u001a\u00020\u001cH\u0016J\u0006\u0010B\u001a\u00020\u0007J\u0006\u0010D\u001a\u00020\u001cJ\u0006\u0010E\u001a\u00020\u0007R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001a\u0010\"\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001a\u0010$\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u001a\u0010'\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\t\"\u0004\b1\u0010\u000bR\u001a\u00102\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\t\"\u0004\b4\u0010\u000bR\u001a\u00105\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001d\"\u0004\b7\u0010\u001fR\u001a\u00108\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\t\"\u0004\b:\u0010\u000bR\u000e\u0010C\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lio/dcloud/feature/utsplugin/ProxyModule$InputOption;", "", "options", "Lcom/alibaba/fastjson/JSONObject;", "<init>", "(Lcom/alibaba/fastjson/JSONObject;)V", "packageName", "", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "className", "getClassName", "setClassName", "methodName", "getMethodName", "setMethodName", "paramArray", "Lcom/alibaba/fastjson/JSONArray;", "getParamArray", "()Lcom/alibaba/fastjson/JSONArray;", "setParamArray", "(Lcom/alibaba/fastjson/JSONArray;)V", "methodArray", "getMethodArray", "setMethodArray", "isConstructor", "", "()Z", "setConstructor", "(Z)V", "isCompanion", "setCompanion", "isField", "setField", "moduleName", "getModuleName", "setModuleName", "isInstanceAction", "setInstanceAction", "instanceId", "", "getInstanceId", "()I", "setInstanceId", "(I)V", "inputModuleName", "getInputModuleName", "setInputModuleName", "inputModuleType", "getInputModuleType", "setInputModuleType", "keepAlive", "getKeepAlive", "setKeepAlive", "type", "getType", "setType", "obtainParamsWithDefault", "", "targetFunction", "Ljava/lang/reflect/Method;", com.taobao.weex.bridge.WXBridgeManager.METHOD_CALLBACK, "Lcom/taobao/weex/bridge/JSCallback;", "Lkotlin/reflect/KFunction;", "getInputFlag", "checkErrorMsg", "isValid", "getErrorMsg", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class InputOption {
        private java.lang.String checkErrorMsg;
        private java.lang.String className;
        private java.lang.String inputModuleName;
        private java.lang.String inputModuleType;
        private int instanceId;
        private boolean isCompanion;
        private boolean isConstructor;
        private boolean isField;
        private boolean isInstanceAction;
        private boolean keepAlive;
        private com.alibaba.fastjson.JSONArray methodArray;
        private java.lang.String methodName;
        private java.lang.String moduleName;
        private java.lang.String packageName;
        private com.alibaba.fastjson.JSONArray paramArray;
        private java.lang.String type;

        public final java.lang.String getPackageName() {
            return this.packageName;
        }

        public final void setPackageName(java.lang.String str) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.packageName = str;
        }

        public final java.lang.String getClassName() {
            return this.className;
        }

        public final void setClassName(java.lang.String str) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.className = str;
        }

        public final java.lang.String getMethodName() {
            return this.methodName;
        }

        public final void setMethodName(java.lang.String str) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.methodName = str;
        }

        public final com.alibaba.fastjson.JSONArray getParamArray() {
            return this.paramArray;
        }

        public final void setParamArray(com.alibaba.fastjson.JSONArray jSONArray) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jSONArray, "<set-?>");
            this.paramArray = jSONArray;
        }

        public final com.alibaba.fastjson.JSONArray getMethodArray() {
            return this.methodArray;
        }

        public final void setMethodArray(com.alibaba.fastjson.JSONArray jSONArray) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(jSONArray, "<set-?>");
            this.methodArray = jSONArray;
        }

        /* JADX INFO: renamed from: isConstructor, reason: from getter */
        public final boolean getIsConstructor() {
            return this.isConstructor;
        }

        public final void setConstructor(boolean z) {
            this.isConstructor = z;
        }

        /* JADX INFO: renamed from: isCompanion, reason: from getter */
        public final boolean getIsCompanion() {
            return this.isCompanion;
        }

        public final void setCompanion(boolean z) {
            this.isCompanion = z;
        }

        /* JADX INFO: renamed from: isField, reason: from getter */
        public final boolean getIsField() {
            return this.isField;
        }

        public final void setField(boolean z) {
            this.isField = z;
        }

        public final java.lang.String getModuleName() {
            return this.moduleName;
        }

        public final void setModuleName(java.lang.String str) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.moduleName = str;
        }

        /* JADX INFO: renamed from: isInstanceAction, reason: from getter */
        public final boolean getIsInstanceAction() {
            return this.isInstanceAction;
        }

        public final void setInstanceAction(boolean z) {
            this.isInstanceAction = z;
        }

        public final int getInstanceId() {
            return this.instanceId;
        }

        public final void setInstanceId(int i) {
            this.instanceId = i;
        }

        public final java.lang.String getInputModuleName() {
            return this.inputModuleName;
        }

        public final void setInputModuleName(java.lang.String str) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.inputModuleName = str;
        }

        public final java.lang.String getInputModuleType() {
            return this.inputModuleType;
        }

        public final void setInputModuleType(java.lang.String str) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.inputModuleType = str;
        }

        public final boolean getKeepAlive() {
            return this.keepAlive;
        }

        public final void setKeepAlive(boolean z) {
            this.keepAlive = z;
        }

        public final java.lang.String getType() {
            return this.type;
        }

        public final void setType(java.lang.String str) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.type = str;
        }

        public InputOption(com.alibaba.fastjson.JSONObject options) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(options, "options");
            this.packageName = "";
            this.className = "";
            this.methodName = "";
            this.paramArray = new com.alibaba.fastjson.JSONArray();
            this.methodArray = new com.alibaba.fastjson.JSONArray();
            this.moduleName = "";
            this.inputModuleName = "";
            this.inputModuleType = "";
            this.type = "";
            this.checkErrorMsg = "";
            if (options.containsKey("moduleName")) {
                java.lang.Object obj = options.get("moduleName");
                kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.inputModuleName = (java.lang.String) obj;
            }
            if (options.containsKey("moduleType")) {
                java.lang.Object obj2 = options.get("moduleType");
                kotlin.jvm.internal.Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                this.inputModuleType = (java.lang.String) obj2;
            }
            if (options.containsKey("keepAlive")) {
                java.lang.Object obj3 = options.get("keepAlive");
                kotlin.jvm.internal.Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                this.keepAlive = ((java.lang.Boolean) obj3).booleanValue();
            }
            if (options.containsKey("package")) {
                java.lang.Object obj4 = options.get("package");
                kotlin.jvm.internal.Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
                this.packageName = (java.lang.String) obj4;
            }
            if (options.containsKey("class")) {
                java.lang.Object obj5 = options.get("class");
                kotlin.jvm.internal.Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.String");
                this.className = (java.lang.String) obj5;
            }
            if (options.containsKey("params")) {
                java.lang.Object obj6 = options.get("params");
                kotlin.jvm.internal.Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type com.alibaba.fastjson.JSONArray");
                this.paramArray = (com.alibaba.fastjson.JSONArray) obj6;
                this.isField = false;
            } else {
                this.isField = true;
            }
            if (options.containsKey("name")) {
                java.lang.Object obj7 = options.get("name");
                kotlin.jvm.internal.Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.String");
                this.methodName = (java.lang.String) obj7;
            }
            if (options.containsKey("id")) {
                java.lang.Object obj8 = options.get("id");
                kotlin.jvm.internal.Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type kotlin.Int");
                this.instanceId = ((java.lang.Integer) obj8).intValue();
                this.isInstanceAction = true;
                this.moduleName = this.methodName;
            } else {
                this.isInstanceAction = false;
                if (options.containsKey("companion")) {
                    java.lang.Object obj9 = options.get("companion");
                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type kotlin.Boolean");
                    this.isCompanion = ((java.lang.Boolean) obj9).booleanValue();
                } else {
                    this.isCompanion = false;
                }
                if (!this.isField && kotlin.jvm.internal.Intrinsics.areEqual("constructor", this.methodName)) {
                    this.isConstructor = true;
                }
                this.moduleName = java.lang.String.valueOf(this.packageName);
                if (!android.text.TextUtils.isEmpty(this.className)) {
                    this.moduleName = this.packageName + com.taobao.weex.el.parse.Operators.DOT + this.className;
                }
            }
            if (options.containsKey("method")) {
                com.alibaba.fastjson.JSONArray jSONArray = options.getJSONArray("method");
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(jSONArray, "getJSONArray(...)");
                this.methodArray = jSONArray;
            }
            if (options.containsKey("type")) {
                java.lang.String string = options.getString("type");
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                this.type = string;
            }
        }

        public static /* synthetic */ java.util.List obtainParamsWithDefault$default(io.dcloud.feature.utsplugin.ProxyModule.InputOption inputOption, java.lang.reflect.Method method, com.taobao.weex.bridge.JSCallback jSCallback, boolean z, int i, java.lang.Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return inputOption.obtainParamsWithDefault(method, jSCallback, z);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0088  */
        /* JADX WARN: Code duplicated, block: B:19:0x009d  */
        /* JADX WARN: Code duplicated, block: B:20:0x00a1  */
        /* JADX WARN: Code duplicated, block: B:21:0x00b0  */
        public final java.util.List<java.lang.Object> obtainParamsWithDefault(java.lang.reflect.Method targetFunction, com.taobao.weex.bridge.JSCallback callback, boolean isField) {
            java.lang.reflect.Type[] actualTypeArguments;
            java.lang.String name;
            io.dcloud.feature.utsplugin.ParamConvertHelper paramConvertHelper;
            com.alibaba.fastjson.JSONObject jSONObject;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(targetFunction, "targetFunction");
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (targetFunction.getParameters().length > 0) {
                java.util.Iterator it = kotlin.jvm.internal.ArrayIteratorKt.iterator(targetFunction.getParameters());
                int i = 0;
                int i2 = 0;
                while (it.hasNext()) {
                    java.lang.reflect.Parameter parameterM = io.dcloud.p.g4$$ExternalSyntheticApiModelOutline0.m(it.next());
                    if (isField) {
                        name = parameterM.getType().toString();
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "toString(...)");
                    } else {
                        if (parameterM.getType() != null) {
                            java.lang.Class type = parameterM.getType();
                            kotlin.jvm.internal.Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<*>");
                            name = type.getName();
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        } else {
                            io.dcloud.feature.utsplugin.ParamConvertHelper.Companion companion = io.dcloud.feature.utsplugin.ParamConvertHelper.INSTANCE;
                            java.lang.Class type2 = parameterM.getType();
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                            java.lang.String strTypeNameCompat = companion.typeNameCompat(type2);
                            java.lang.reflect.GenericDeclaration type3 = parameterM.getType();
                            kotlin.jvm.internal.Intrinsics.checkNotNull(type3, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
                            actualTypeArguments = ((java.lang.reflect.ParameterizedType) type3).getActualTypeArguments();
                            name = strTypeNameCompat;
                        }
                        paramConvertHelper = new io.dcloud.feature.utsplugin.ParamConvertHelper(name, actualTypeArguments, callback, this.keepAlive);
                        if (i >= this.paramArray.size()) {
                            java.lang.Object obj = this.methodArray.get(i2);
                            kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
                            jSONObject = (com.alibaba.fastjson.JSONObject) obj;
                            if (jSONObject.get("default") == null) {
                                arrayList.add(null);
                            } else {
                                java.lang.Object obj2 = jSONObject.get("default");
                                kotlin.jvm.internal.Intrinsics.checkNotNull(obj2);
                                arrayList.add(paramConvertHelper.getInstance(obj2));
                            }
                        } else {
                            arrayList.add(paramConvertHelper.getInstance(this.paramArray.get(i)));
                            i++;
                        }
                        i2++;
                    }
                    actualTypeArguments = null;
                    paramConvertHelper = new io.dcloud.feature.utsplugin.ParamConvertHelper(name, actualTypeArguments, callback, this.keepAlive);
                    if (i >= this.paramArray.size()) {
                        java.lang.Object obj3 = this.methodArray.get(i2);
                        kotlin.jvm.internal.Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
                        jSONObject = (com.alibaba.fastjson.JSONObject) obj3;
                        if (jSONObject.get("default") == null) {
                            arrayList.add(null);
                        } else {
                            java.lang.Object obj4 = jSONObject.get("default");
                            kotlin.jvm.internal.Intrinsics.checkNotNull(obj4);
                            arrayList.add(paramConvertHelper.getInstance(obj4));
                        }
                    } else {
                        arrayList.add(paramConvertHelper.getInstance(this.paramArray.get(i)));
                        i++;
                    }
                    i2++;
                }
            }
            return arrayList;
        }

        public static /* synthetic */ java.util.List obtainParamsWithDefault$default(io.dcloud.feature.utsplugin.ProxyModule.InputOption inputOption, kotlin.reflect.KFunction kFunction, com.taobao.weex.bridge.JSCallback jSCallback, boolean z, int i, java.lang.Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return inputOption.obtainParamsWithDefault((kotlin.reflect.KFunction<?>) kFunction, jSCallback, z);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x00a7  */
        /* JADX WARN: Code duplicated, block: B:26:0x00bc  */
        /* JADX WARN: Code duplicated, block: B:27:0x00c0  */
        /* JADX WARN: Code duplicated, block: B:28:0x00cf  */
        public java.util.List<java.lang.Object> obtainParamsWithDefault(kotlin.reflect.KFunction<?> targetFunction, com.taobao.weex.bridge.JSCallback callback, boolean isField) {
            java.lang.reflect.Type[] actualTypeArguments;
            java.lang.String name;
            io.dcloud.feature.utsplugin.ParamConvertHelper paramConvertHelper;
            com.alibaba.fastjson.JSONObject jSONObject;
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(targetFunction, "targetFunction");
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (targetFunction.getParameters().size() > 0) {
                int i = 0;
                int i2 = 0;
                for (kotlin.reflect.KParameter kParameter : targetFunction.getParameters()) {
                    if (kParameter.getKind() == kotlin.reflect.KParameter.Kind.INSTANCE) {
                        if (kParameter.getName() != null || kParameter.isOptional()) {
                        }
                    } else {
                        if (isField) {
                            name = kParameter.getType().toString();
                        } else {
                            if (kotlin.reflect.jvm.ReflectJvmMapping.getJavaType(kParameter.getType()) instanceof java.lang.Class) {
                                java.lang.reflect.Type javaType = kotlin.reflect.jvm.ReflectJvmMapping.getJavaType(kParameter.getType());
                                kotlin.jvm.internal.Intrinsics.checkNotNull(javaType, "null cannot be cast to non-null type java.lang.Class<*>");
                                name = ((java.lang.Class) javaType).getName();
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                            } else {
                                java.lang.String strTypeNameCompat = io.dcloud.feature.utsplugin.ParamConvertHelper.INSTANCE.typeNameCompat(kotlin.reflect.jvm.ReflectJvmMapping.getJavaType(kParameter.getType()));
                                java.lang.reflect.Type javaType2 = kotlin.reflect.jvm.ReflectJvmMapping.getJavaType(kParameter.getType());
                                kotlin.jvm.internal.Intrinsics.checkNotNull(javaType2, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
                                actualTypeArguments = ((java.lang.reflect.ParameterizedType) javaType2).getActualTypeArguments();
                                name = strTypeNameCompat;
                            }
                            paramConvertHelper = new io.dcloud.feature.utsplugin.ParamConvertHelper(name, actualTypeArguments, callback, this.keepAlive);
                            if (i >= this.paramArray.size()) {
                                java.lang.Object obj = this.methodArray.get(i2);
                                kotlin.jvm.internal.Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
                                jSONObject = (com.alibaba.fastjson.JSONObject) obj;
                                if (jSONObject.get("default") == null) {
                                    arrayList.add(null);
                                } else {
                                    java.lang.Object obj2 = jSONObject.get("default");
                                    kotlin.jvm.internal.Intrinsics.checkNotNull(obj2);
                                    arrayList.add(paramConvertHelper.getInstance(obj2));
                                }
                            } else {
                                arrayList.add(paramConvertHelper.getInstance(this.paramArray.get(i)));
                                i++;
                            }
                        }
                        actualTypeArguments = null;
                        paramConvertHelper = new io.dcloud.feature.utsplugin.ParamConvertHelper(name, actualTypeArguments, callback, this.keepAlive);
                        if (i >= this.paramArray.size()) {
                            java.lang.Object obj3 = this.methodArray.get(i2);
                            kotlin.jvm.internal.Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
                            jSONObject = (com.alibaba.fastjson.JSONObject) obj3;
                            if (jSONObject.get("default") == null) {
                                arrayList.add(null);
                            } else {
                                java.lang.Object obj4 = jSONObject.get("default");
                                kotlin.jvm.internal.Intrinsics.checkNotNull(obj4);
                                arrayList.add(paramConvertHelper.getInstance(obj4));
                            }
                        } else {
                            arrayList.add(paramConvertHelper.getInstance(this.paramArray.get(i)));
                            i++;
                        }
                    }
                    i2++;
                }
            }
            return arrayList;
        }

        public final java.lang.String getInputFlag() {
            return com.taobao.weex.el.parse.Operators.ARRAY_START_STR + this.moduleName + '-' + this.methodName + com.taobao.weex.el.parse.Operators.ARRAY_END;
        }

        public final boolean isValid() {
            if (!android.text.TextUtils.isEmpty(this.packageName) && !kotlin.text.StringsKt.startsWith$default(this.packageName, "uts.sdk.modules", false, 2, (java.lang.Object) null) && !kotlin.text.StringsKt.startsWith$default(this.packageName, "uts.sdk", false, 2, (java.lang.Object) null) && !kotlin.text.StringsKt.startsWith$default(this.packageName, "uts.modules", false, 2, (java.lang.Object) null)) {
                return false;
            }
            if (this.isInstanceAction) {
                return true;
            }
            if (!android.text.TextUtils.isEmpty(this.moduleName) && !android.text.TextUtils.isEmpty(this.methodName)) {
                return true;
            }
            this.checkErrorMsg = "param is null " + this.moduleName + ' ' + this.methodName;
            return false;
        }

        /* JADX INFO: renamed from: getErrorMsg, reason: from getter */
        public final java.lang.String getCheckErrorMsg() {
            return this.checkErrorMsg;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final java.lang.Object getFunctionExecuteRet(kotlin.reflect.KFunction<?> kFunction, java.lang.Object[] objArr, kotlin.coroutines.Continuation<java.lang.Object> continuation) {
        io.dcloud.feature.utsplugin.ProxyModule.C01051 c01051;
        if (continuation instanceof io.dcloud.feature.utsplugin.ProxyModule.C01051) {
            c01051 = (io.dcloud.feature.utsplugin.ProxyModule.C01051) continuation;
            if ((c01051.label & Integer.MIN_VALUE) != 0) {
                c01051.label -= Integer.MIN_VALUE;
            } else {
                c01051 = new io.dcloud.feature.utsplugin.ProxyModule.C01051(continuation);
            }
        } else {
            c01051 = new io.dcloud.feature.utsplugin.ProxyModule.C01051(continuation);
        }
        java.lang.Object objCallSuspend = c01051.result;
        java.lang.Object coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01051.label;
        if (i == 0) {
            kotlin.ResultKt.throwOnFailure(objCallSuspend);
            if (kFunction.isSuspend()) {
                java.lang.Object[] objArrCopyOf = java.util.Arrays.copyOf(objArr, objArr.length);
                c01051.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(kFunction);
                c01051.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(objArr);
                c01051.label = 1;
                objCallSuspend = callSuspend(kFunction, objArrCopyOf, c01051);
                if (objCallSuspend != coroutine_suspended) {
                }
            } else {
                java.lang.Object[] objArrCopyOf2 = java.util.Arrays.copyOf(objArr, objArr.length);
                c01051.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(kFunction);
                c01051.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(objArr);
                c01051.label = 3;
                java.lang.Object objCallSuspend2 = callSuspend(kFunction, objArrCopyOf2, c01051);
                if (objCallSuspend2 != coroutine_suspended) {
                    return objCallSuspend2;
                }
            }
        }
        if (i != 1) {
            if (i == 2) {
            } else if (i != 3) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(objCallSuspend);
            return objCallSuspend;
        }
        objArr = (java.lang.Object[]) c01051.L$1;
        kFunction = (kotlin.reflect.KFunction) c01051.L$0;
        kotlin.ResultKt.throwOnFailure(objCallSuspend);
        kotlin.jvm.internal.Intrinsics.checkNotNull(objCallSuspend, "null cannot be cast to non-null type kotlinx.coroutines.Deferred<kotlin.Any?>");
        kotlinx.coroutines.Deferred deferred = (kotlinx.coroutines.Deferred) objCallSuspend;
        c01051.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(kFunction);
        c01051.L$1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(objArr);
        c01051.L$2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(deferred);
        c01051.label = 2;
        java.lang.Object objAwait = deferred.await(c01051);
        return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final com.alibaba.fastjson.JSONObject wrapDoTypeAction(io.dcloud.feature.utsplugin.ProxyModule.InputOption inputOption, java.lang.Class<?> javaClazz, java.lang.Object targetInstance, com.taobao.weex.bridge.JSCallback callback, io.dcloud.feature.utsplugin.ReturnResult errRet) {
        java.lang.String strValueOf;
        java.lang.String methodName = inputOption.getMethodName();
        if (kotlin.text.StringsKt.equals("setter", inputOption.getType(), true)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("set");
            if (methodName.length() > 0) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                char cCharAt = methodName.charAt(0);
                if (java.lang.Character.isLowerCase(cCharAt)) {
                    java.util.Locale locale = java.util.Locale.getDefault();
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                    strValueOf = kotlin.text.CharsKt.titlecase(cCharAt, locale);
                } else {
                    strValueOf = java.lang.String.valueOf(cCharAt);
                }
                sb2.append((java.lang.Object) strValueOf);
                java.lang.String strSubstring = methodName.substring(1);
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                sb2.append(strSubstring);
                methodName = sb2.toString();
            }
            sb.append(methodName);
            java.lang.reflect.Method methodFindTargetMethod = findTargetMethod(javaClazz, sb.toString(), inputOption);
            if (methodFindTargetMethod == null) {
                errRet.updateError("method not found:" + inputOption.getInputFlag());
                return errRet.toJSON();
            }
            java.util.List listObtainParamsWithDefault$default = io.dcloud.feature.utsplugin.ProxyModule.InputOption.obtainParamsWithDefault$default(inputOption, methodFindTargetMethod, callback, false, 4, (java.lang.Object) null);
            kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
            try {
                kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(null, new io.dcloud.feature.utsplugin.ProxyModule.C01072(objectRef, errRet, methodFindTargetMethod, targetInstance, listObtainParamsWithDefault$default, null), 1, null);
            } catch (java.lang.Exception e) {
                objectRef.element = null;
                if (e.getCause() != null) {
                    errRet.updateError("targetMethod error::" + e.getCause());
                } else {
                    errRet.updateError("targetMethod error::" + e);
                }
            }
            if (objectRef.element != 0) {
                if (objectRef.element instanceof io.dcloud.uts.UTSJSONObject) {
                    T t = objectRef.element;
                    kotlin.jvm.internal.Intrinsics.checkNotNull(t, "null cannot be cast to non-null type io.dcloud.uts.UTSJSONObject");
                    errRet.updateJSON(((io.dcloud.uts.UTSJSONObject) t).toJSONObject());
                } else {
                    errRet.updateJSON(objectRef.element);
                }
                errRet.toJSON();
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: io.dcloud.feature.utsplugin.ProxyModule$wrapDoTypeAction$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UTSProxyModule.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "io.dcloud.feature.utsplugin.ProxyModule$wrapDoTypeAction$2", f = "UTSProxyModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01072 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlinx.coroutines.Job>, java.lang.Object> {
        final /* synthetic */ io.dcloud.feature.utsplugin.ReturnResult $errRet;
        final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> $executeRet;
        final /* synthetic */ java.util.List<java.lang.Object> $paramList;
        final /* synthetic */ java.lang.Object $targetInstance;
        final /* synthetic */ java.lang.reflect.Method $targetMethod;
        private /* synthetic */ java.lang.Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01072(kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> objectRef, io.dcloud.feature.utsplugin.ReturnResult returnResult, java.lang.reflect.Method method, java.lang.Object obj, java.util.List<java.lang.Object> list, kotlin.coroutines.Continuation<? super io.dcloud.feature.utsplugin.ProxyModule.C01072> continuation) {
            super(2, continuation);
            this.$executeRet = objectRef;
            this.$errRet = returnResult;
            this.$targetMethod = method;
            this.$targetInstance = obj;
            this.$paramList = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            io.dcloud.feature.utsplugin.ProxyModule.C01072 c01072 = new io.dcloud.feature.utsplugin.ProxyModule.C01072(this.$executeRet, this.$errRet, this.$targetMethod, this.$targetInstance, this.$paramList, continuation);
            c01072.L$0 = obj;
            return c01072;
        }

        @Override // kotlin.jvm.functions.Function2
        public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super kotlinx.coroutines.Job> continuation) {
            return ((io.dcloud.feature.utsplugin.ProxyModule.C01072) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object obj) {
            kotlinx.coroutines.CoroutineScope coroutineScope = (kotlinx.coroutines.CoroutineScope) this.L$0;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(obj);
            return kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(coroutineScope, new io.dcloud.feature.utsplugin.ProxyModule$wrapDoTypeAction$2$invokeSuspend$$inlined$CoroutineExceptionHandler$1(kotlinx.coroutines.CoroutineExceptionHandler.INSTANCE, this.$executeRet, this.$errRet), null, new io.dcloud.feature.utsplugin.ProxyModule.C01072.C00512(this.$executeRet, this.$targetMethod, this.$targetInstance, this.$paramList, null), 2, null);
        }

        /* JADX INFO: renamed from: io.dcloud.feature.utsplugin.ProxyModule$wrapDoTypeAction$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: UTSProxyModule.kt */
        @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @kotlin.coroutines.jvm.internal.DebugMetadata(c = "io.dcloud.feature.utsplugin.ProxyModule$wrapDoTypeAction$2$2", f = "UTSProxyModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00512 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
            final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> $executeRet;
            final /* synthetic */ java.util.List<java.lang.Object> $paramList;
            final /* synthetic */ java.lang.Object $targetInstance;
            final /* synthetic */ java.lang.reflect.Method $targetMethod;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00512(kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> objectRef, java.lang.reflect.Method method, java.lang.Object obj, java.util.List<java.lang.Object> list, kotlin.coroutines.Continuation<? super io.dcloud.feature.utsplugin.ProxyModule.C01072.C00512> continuation) {
                super(2, continuation);
                this.$executeRet = objectRef;
                this.$targetMethod = method;
                this.$targetInstance = obj;
                this.$paramList = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
                return new io.dcloud.feature.utsplugin.ProxyModule.C01072.C00512(this.$executeRet, this.$targetMethod, this.$targetInstance, this.$paramList, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
                return ((io.dcloud.feature.utsplugin.ProxyModule.C01072.C00512) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final java.lang.Object invokeSuspend(java.lang.Object obj) {
                kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.ResultKt.throwOnFailure(obj);
                kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> objectRef = this.$executeRet;
                java.lang.reflect.Method method = this.$targetMethod;
                java.lang.Object obj2 = this.$targetInstance;
                java.lang.Object[] array = this.$paramList.toArray(new java.lang.Object[0]);
                objectRef.element = method.invoke(obj2, java.util.Arrays.copyOf(array, array.length));
                return kotlin.Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [T, io.dcloud.feature.utsplugin.ReturnResult] */
    /* JADX WARN: Type inference failed for: r0v92, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r3v13, types: [T, kotlin.reflect.KFunction] */
    /* JADX WARN: Type inference failed for: r7v4, types: [T, kotlin.reflect.KFunction] */
    /* JADX WARN: Type inference failed for: r9v4, types: [T, java.util.List] */
    @io.dcloud.feature.uniapp.annotation.UniJSMethod(uiThread = false)
    public final java.lang.Object invokeSync(com.alibaba.fastjson.JSONObject jSONObject, com.taobao.weex.bridge.JSCallback jSCallback, kotlin.coroutines.Continuation<java.lang.Object> continuation) {
        kotlin.jvm.internal.Ref.ObjectRef objectRef;
        kotlin.jvm.internal.Ref.ObjectRef objectRef2;
        java.lang.String str;
        kotlin.jvm.internal.Ref.ObjectRef objectRef3;
        T t;
        java.lang.ExceptionInInitializerError exceptionInInitializerError;
        java.lang.Class<?> cls;
        boolean zIsFieldMethod;
        java.lang.Object objCall;
        kotlin.jvm.internal.Ref.ObjectRef objectRef4 = new kotlin.jvm.internal.Ref.ObjectRef();
        objectRef4.element = new io.dcloud.feature.utsplugin.ReturnResult();
        io.dcloud.uts.android.AndroidUTSContext androidUTSContext = io.dcloud.uts.android.AndroidUTSContext.INSTANCE;
        io.dcloud.feature.uniapp.AbsSDKInstance mUniSDKInstance = this.mUniSDKInstance;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(mUniSDKInstance, "mUniSDKInstance");
        androidUTSContext.initContext(mUniSDKInstance);
        io.dcloud.feature.utsplugin.ProxyModule.InputOption inputOption = new io.dcloud.feature.utsplugin.ProxyModule.InputOption(jSONObject);
        try {
            if (!inputOption.isValid()) {
                ((io.dcloud.feature.utsplugin.ReturnResult) objectRef4.element).updateError(inputOption.getCheckErrorMsg());
                return ((io.dcloud.feature.utsplugin.ReturnResult) objectRef4.element).toJSON();
            }
            kotlin.jvm.internal.Ref.ObjectRef objectRef5 = null;
            try {
                if (inputOption.getIsInstanceAction()) {
                    try {
                        if (utsInstances.get(kotlin.coroutines.jvm.internal.Boxing.boxInt(inputOption.getInstanceId())) == null) {
                            throw new java.lang.Exception("instance does not exists");
                        }
                        java.lang.Object obj = utsInstances.get(kotlin.coroutines.jvm.internal.Boxing.boxInt(inputOption.getInstanceId()));
                        kotlin.jvm.internal.Intrinsics.checkNotNull(obj);
                        java.lang.Class<?> cls2 = obj.getClass();
                        java.lang.Object obj2 = utsInstances.get(kotlin.coroutines.jvm.internal.Boxing.boxInt(inputOption.getInstanceId()));
                        if (inputOption.getIsField()) {
                            io.dcloud.feature.utsplugin.ProxyModule.Companion companion = INSTANCE;
                            kotlin.jvm.internal.Intrinsics.checkNotNull(obj2);
                            kotlin.reflect.KCallable<?> kCallableFindTargetField = companion.findTargetField(obj2.getClass(), false, inputOption.getMethodName());
                            if (kCallableFindTargetField == null) {
                                ((io.dcloud.feature.utsplugin.ReturnResult) objectRef4.element).updateError("field not found:" + inputOption.getInputFlag());
                                return ((io.dcloud.feature.utsplugin.ReturnResult) objectRef4.element).toJSON();
                            }
                            ((io.dcloud.feature.utsplugin.ReturnResult) objectRef4.element).updateJSON(kCallableFindTargetField.call(obj2));
                            return ((io.dcloud.feature.utsplugin.ReturnResult) objectRef4.element).toJSON();
                        }
                        if (inputOption.getType().length() > 0 && kotlin.jvm.internal.Intrinsics.areEqual(inputOption.getType(), "setter")) {
                            com.alibaba.fastjson.JSONObject jSONObjectWrapDoTypeAction = wrapDoTypeAction(inputOption, cls2, obj2, jSCallback, (io.dcloud.feature.utsplugin.ReturnResult) objectRef4.element);
                            return jSONObjectWrapDoTypeAction != null ? jSONObjectWrapDoTypeAction : ((io.dcloud.feature.utsplugin.ReturnResult) objectRef4.element).toJSON();
                        }
                        kotlin.reflect.KFunction<?> kFunctionFindTargetFunc = findTargetFunc(cls2, false, inputOption.getMethodName(), inputOption);
                        if (kFunctionFindTargetFunc == null) {
                            ((io.dcloud.feature.utsplugin.ReturnResult) objectRef4.element).updateError("method not found:" + inputOption.getInputFlag());
                            return ((io.dcloud.feature.utsplugin.ReturnResult) objectRef4.element).toJSON();
                        }
                        kotlin.jvm.internal.Ref.ObjectRef objectRef6 = new kotlin.jvm.internal.Ref.ObjectRef();
                        objectRef6.element = io.dcloud.feature.utsplugin.ProxyModule.InputOption.obtainParamsWithDefault$default(inputOption, (kotlin.reflect.KFunction) kFunctionFindTargetFunc, jSCallback, false, 4, (java.lang.Object) null);
                        ((java.util.List) objectRef6.element).add(0, obj2);
                        try {
                            kotlin.jvm.internal.Ref.ObjectRef objectRef7 = new kotlin.jvm.internal.Ref.ObjectRef();
                            try {
                                str = "targetMethod error::";
                                t = 0;
                                try {
                                    io.dcloud.feature.utsplugin.ProxyModule.C01062 c01062 = new io.dcloud.feature.utsplugin.ProxyModule.C01062(objectRef7, objectRef4, inputOption, objectRef6, cls2, this, kFunctionFindTargetFunc, null);
                                    objectRef3 = objectRef4;
                                    objectRef2 = objectRef7;
                                    try {
                                        kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(null, c01062, 1, null);
                                    } catch (java.lang.Exception e) {
                                        e = e;
                                        objectRef2.element = t;
                                        if (e.getCause() != null) {
                                            ((io.dcloud.feature.utsplugin.ReturnResult) objectRef3.element).updateError(str + e.getCause());
                                        } else {
                                            ((io.dcloud.feature.utsplugin.ReturnResult) objectRef3.element).updateError(str + e);
                                        }
                                    }
                                } catch (java.lang.Exception e2) {
                                    e = e2;
                                    objectRef3 = objectRef4;
                                    objectRef2 = objectRef7;
                                }
                            } catch (java.lang.Exception e3) {
                                e = e3;
                                objectRef2 = objectRef7;
                                str = "targetMethod error::";
                                objectRef3 = objectRef4;
                                t = 0;
                            }
                            if (objectRef2.element != 0) {
                                if (objectRef2.element instanceof io.dcloud.uts.UTSJSONObject) {
                                    T t2 = objectRef2.element;
                                    kotlin.jvm.internal.Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type io.dcloud.uts.UTSJSONObject");
                                    ((io.dcloud.feature.utsplugin.ReturnResult) objectRef3.element).updateJSON(((io.dcloud.uts.UTSJSONObject) t2).toJSONObject());
                                } else {
                                    ((io.dcloud.feature.utsplugin.ReturnResult) objectRef3.element).updateJSON(objectRef2.element);
                                }
                                objectRef = objectRef3;
                            } else {
                                return ((io.dcloud.feature.utsplugin.ReturnResult) objectRef3.element).toJSON();
                            }
                        } catch (java.lang.Exception e4) {
                            e = e4;
                            objectRef5 = objectRef4;
                            objectRef = objectRef5;
                            ((io.dcloud.feature.utsplugin.ReturnResult) objectRef.element).updateError(e.toString());
                        }
                    } catch (java.lang.Exception e5) {
                        e = e5;
                    }
                    objectRef5 = objectRef4;
                    objectRef = objectRef5;
                    ((io.dcloud.feature.utsplugin.ReturnResult) objectRef.element).updateError(e.toString());
                } else {
                    objectRef5 = objectRef4;
                    try {
                        cls = java.lang.Class.forName(inputOption.getModuleName());
                        exceptionInInitializerError = null;
                    } catch (java.lang.Throwable th) {
                        exceptionInInitializerError = th instanceof java.lang.ExceptionInInitializerError ? th : null;
                        cls = null;
                    }
                    if (cls == null) {
                        io.dcloud.feature.utsplugin.ProxyModule.ModuleChecker moduleChecker = new io.dcloud.feature.utsplugin.ProxyModule.ModuleChecker(inputOption);
                        if (moduleChecker.shallShowErrorDialog()) {
                            moduleChecker.showErrorDialog();
                        }
                        if (exceptionInInitializerError != null) {
                            ((io.dcloud.feature.utsplugin.ReturnResult) objectRef5.element).updateError("初始化 " + inputOption.getInputModuleName() + " 失败 - " + exceptionInInitializerError.getException().getMessage());
                        } else {
                            ((io.dcloud.feature.utsplugin.ReturnResult) objectRef5.element).updateError("error: " + inputOption.getInputModuleName() + " not found.");
                        }
                        return ((io.dcloud.feature.utsplugin.ReturnResult) objectRef5.element).toJSON();
                    }
                    if (inputOption.getIsField()) {
                        kotlin.reflect.KCallable<?> kCallableFindTargetField2 = INSTANCE.findTargetField(cls, inputOption.getIsCompanion(), inputOption.getMethodName());
                        if (kCallableFindTargetField2 == null) {
                            ((io.dcloud.feature.utsplugin.ReturnResult) objectRef5.element).updateError("field not found:" + inputOption.getInputFlag());
                            return ((io.dcloud.feature.utsplugin.ReturnResult) objectRef5.element).toJSON();
                        }
                        ((io.dcloud.feature.utsplugin.ReturnResult) objectRef5.element).updateJSON(inputOption.getIsCompanion() ? kCallableFindTargetField2.call(kotlin.reflect.full.KClasses.getCompanionObjectInstance(kotlin.jvm.JvmClassMappingKt.getKotlinClass(cls))) : kCallableFindTargetField2.call(cls));
                        return ((io.dcloud.feature.utsplugin.ReturnResult) objectRef5.element).toJSON();
                    }
                    if (inputOption.getIsConstructor()) {
                        java.util.Collection constructors = kotlin.jvm.JvmClassMappingKt.getKotlinClass(cls).getConstructors();
                        if (constructors.isEmpty()) {
                            objCall = cls.newInstance();
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(objCall, "newInstance(...)");
                        } else {
                            kotlin.reflect.KFunction kFunction = ((kotlin.reflect.KFunction[]) constructors.toArray(new kotlin.reflect.KFunction[0]))[0];
                            java.lang.Object[] array = io.dcloud.feature.utsplugin.ProxyModule.InputOption.obtainParamsWithDefault$default(inputOption, kFunction, jSCallback, false, 4, (java.lang.Object) null).toArray(new java.lang.Object[0]);
                            objCall = kFunction.call(java.util.Arrays.copyOf(array, array.length));
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(objCall, "call(...)");
                        }
                        int i = instanceDynamicId + 1;
                        instanceDynamicId = i;
                        utsInstances.put(kotlin.coroutines.jvm.internal.Boxing.boxInt(i), objCall);
                        ((io.dcloud.feature.utsplugin.ReturnResult) objectRef5.element).updateJSON(kotlin.coroutines.jvm.internal.Boxing.boxInt(instanceDynamicId));
                        return objectRef5.element;
                    }
                    objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
                    objectRef.element = findTargetFunc(cls, inputOption.getIsCompanion(), inputOption.getMethodName(), inputOption);
                    io.dcloud.feature.utsplugin.FieldMethodDetector fieldMethodDetector = new io.dcloud.feature.utsplugin.FieldMethodDetector(cls, inputOption);
                    if (objectRef.element == 0) {
                        fieldMethodDetector.init();
                        zIsFieldMethod = fieldMethodDetector.isFieldMethod();
                        objectRef.element = fieldMethodDetector.getTargetFunction();
                    } else {
                        zIsFieldMethod = false;
                    }
                    if (objectRef.element == 0) {
                        ((io.dcloud.feature.utsplugin.ReturnResult) objectRef5.element).updateError("method not found:" + inputOption.getInputFlag());
                        return ((io.dcloud.feature.utsplugin.ReturnResult) objectRef5.element).toJSON();
                    }
                    kotlin.jvm.internal.Ref.ObjectRef objectRef8 = new kotlin.jvm.internal.Ref.ObjectRef();
                    objectRef8.element = inputOption.obtainParamsWithDefault((kotlin.reflect.KFunction<?>) objectRef.element, jSCallback, zIsFieldMethod);
                    if (inputOption.getIsCompanion()) {
                        ((java.util.List) objectRef8.element).add(0, kotlin.reflect.full.KClasses.getCompanionObjectInstance(kotlin.jvm.JvmClassMappingKt.getKotlinClass(cls)));
                    }
                    kotlin.jvm.internal.Ref.ObjectRef objectRef9 = new kotlin.jvm.internal.Ref.ObjectRef();
                    try {
                        if (!zIsFieldMethod) {
                            try {
                                objectRef = objectRef5;
                                try {
                                    kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(null, new io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass3(objectRef9, objectRef, objectRef8, this, objectRef, null), 1, null);
                                } catch (java.lang.Exception e6) {
                                    e = e6;
                                    objectRef9.element = null;
                                    if (e.getCause() != null) {
                                        ((io.dcloud.feature.utsplugin.ReturnResult) objectRef.element).updateError("targetMethod error::" + e.getCause());
                                    } else {
                                        ((io.dcloud.feature.utsplugin.ReturnResult) objectRef.element).updateError("targetMethod error::" + e);
                                    }
                                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                                }
                            } catch (java.lang.Exception e7) {
                                e = e7;
                                objectRef = objectRef5;
                            }
                        } else {
                            objectRef = objectRef5;
                            java.lang.Object[] array2 = ((java.util.Collection) objectRef8.element).toArray(new java.lang.Object[0]);
                            java.lang.reflect.Method fieldFunMethod = fieldMethodDetector.getFieldFunMethod();
                            kotlin.jvm.internal.Intrinsics.checkNotNull(fieldFunMethod);
                            objectRef9.element = fieldFunMethod.invoke(fieldMethodDetector.getHostFunction(), java.util.Arrays.copyOf(array2, array2.length));
                        }
                        if (objectRef9.element != 0) {
                            if (objectRef9.element instanceof io.dcloud.uts.UTSJSONObject) {
                                T t3 = objectRef9.element;
                                kotlin.jvm.internal.Intrinsics.checkNotNull(t3, "null cannot be cast to non-null type io.dcloud.uts.UTSJSONObject");
                                ((io.dcloud.feature.utsplugin.ReturnResult) objectRef.element).updateJSON(((io.dcloud.uts.UTSJSONObject) t3).toJSONObject());
                            } else {
                                ((io.dcloud.feature.utsplugin.ReturnResult) objectRef.element).updateJSON(objectRef9.element);
                            }
                        } else {
                            return ((io.dcloud.feature.utsplugin.ReturnResult) objectRef.element).toJSON();
                        }
                    } catch (java.lang.Exception e8) {
                        e = e8;
                        ((io.dcloud.feature.utsplugin.ReturnResult) objectRef.element).updateError(e.toString());
                    }
                }
            } catch (java.lang.Exception e9) {
                e = e9;
            }
            return ((io.dcloud.feature.utsplugin.ReturnResult) objectRef.element).toJSON();
        } catch (java.lang.Exception e10) {
            e = e10;
            objectRef = objectRef4;
        }
    }

    /* JADX INFO: renamed from: io.dcloud.feature.utsplugin.ProxyModule$invokeSync$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UTSProxyModule.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "io.dcloud.feature.utsplugin.ProxyModule$invokeSync$2", f = "UTSProxyModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01062 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlinx.coroutines.Job>, java.lang.Object> {
        final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<io.dcloud.feature.utsplugin.ReturnResult> $errRet;
        final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> $executeRet;
        final /* synthetic */ io.dcloud.feature.utsplugin.ProxyModule.InputOption $inputOption;
        final /* synthetic */ java.lang.Class<java.lang.Object> $javaClazz;
        final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<java.util.List<java.lang.Object>> $paramList;
        final /* synthetic */ kotlin.reflect.KFunction<?> $targetFunction;
        private /* synthetic */ java.lang.Object L$0;
        int label;
        final /* synthetic */ io.dcloud.feature.utsplugin.ProxyModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01062(kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> objectRef, kotlin.jvm.internal.Ref.ObjectRef<io.dcloud.feature.utsplugin.ReturnResult> objectRef2, io.dcloud.feature.utsplugin.ProxyModule.InputOption inputOption, kotlin.jvm.internal.Ref.ObjectRef<java.util.List<java.lang.Object>> objectRef3, java.lang.Class<java.lang.Object> cls, io.dcloud.feature.utsplugin.ProxyModule proxyModule, kotlin.reflect.KFunction<?> kFunction, kotlin.coroutines.Continuation<? super io.dcloud.feature.utsplugin.ProxyModule.C01062> continuation) {
            super(2, continuation);
            this.$executeRet = objectRef;
            this.$errRet = objectRef2;
            this.$inputOption = inputOption;
            this.$paramList = objectRef3;
            this.$javaClazz = cls;
            this.this$0 = proxyModule;
            this.$targetFunction = kFunction;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            io.dcloud.feature.utsplugin.ProxyModule.C01062 c01062 = new io.dcloud.feature.utsplugin.ProxyModule.C01062(this.$executeRet, this.$errRet, this.$inputOption, this.$paramList, this.$javaClazz, this.this$0, this.$targetFunction, continuation);
            c01062.L$0 = obj;
            return c01062;
        }

        @Override // kotlin.jvm.functions.Function2
        public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super kotlinx.coroutines.Job> continuation) {
            return ((io.dcloud.feature.utsplugin.ProxyModule.C01062) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object obj) {
            kotlinx.coroutines.CoroutineScope coroutineScope = (kotlinx.coroutines.CoroutineScope) this.L$0;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(obj);
            return kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(coroutineScope, new io.dcloud.feature.utsplugin.ProxyModule$invokeSync$2$invokeSuspend$$inlined$CoroutineExceptionHandler$1(kotlinx.coroutines.CoroutineExceptionHandler.INSTANCE, this.$executeRet, this.$errRet), null, new io.dcloud.feature.utsplugin.ProxyModule.C01062.C00502(this.$inputOption, this.$paramList, this.$javaClazz, this.$executeRet, this.this$0, this.$targetFunction, null), 2, null);
        }

        /* JADX INFO: renamed from: io.dcloud.feature.utsplugin.ProxyModule$invokeSync$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: UTSProxyModule.kt */
        @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @kotlin.coroutines.jvm.internal.DebugMetadata(c = "io.dcloud.feature.utsplugin.ProxyModule$invokeSync$2$2", f = "UTSProxyModule.kt", i = {0}, l = {846}, m = "invokeSuspend", n = {"paramArray"}, s = {"L$0"})
        static final class C00502 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
            final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> $executeRet;
            final /* synthetic */ io.dcloud.feature.utsplugin.ProxyModule.InputOption $inputOption;
            final /* synthetic */ java.lang.Class<java.lang.Object> $javaClazz;
            final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<java.util.List<java.lang.Object>> $paramList;
            final /* synthetic */ kotlin.reflect.KFunction<?> $targetFunction;
            java.lang.Object L$0;
            java.lang.Object L$1;
            int label;
            final /* synthetic */ io.dcloud.feature.utsplugin.ProxyModule this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00502(io.dcloud.feature.utsplugin.ProxyModule.InputOption inputOption, kotlin.jvm.internal.Ref.ObjectRef<java.util.List<java.lang.Object>> objectRef, java.lang.Class<java.lang.Object> cls, kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> objectRef2, io.dcloud.feature.utsplugin.ProxyModule proxyModule, kotlin.reflect.KFunction<?> kFunction, kotlin.coroutines.Continuation<? super io.dcloud.feature.utsplugin.ProxyModule.C01062.C00502> continuation) {
                super(2, continuation);
                this.$inputOption = inputOption;
                this.$paramList = objectRef;
                this.$javaClazz = cls;
                this.$executeRet = objectRef2;
                this.this$0 = proxyModule;
                this.$targetFunction = kFunction;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
                return new io.dcloud.feature.utsplugin.ProxyModule.C01062.C00502(this.$inputOption, this.$paramList, this.$javaClazz, this.$executeRet, this.this$0, this.$targetFunction, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
                return ((io.dcloud.feature.utsplugin.ProxyModule.C01062.C00502) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final java.lang.Object invokeSuspend(java.lang.Object obj) {
                kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> objectRef;
                T t;
                java.lang.Object coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    if (this.$inputOption.getIsCompanion()) {
                        java.util.List<java.lang.Object> list = this.$paramList.element;
                        java.lang.Object companionObject = kotlin.reflect.full.KClasses.getCompanionObject(kotlin.jvm.JvmClassMappingKt.getKotlinClass(this.$javaClazz));
                        kotlin.jvm.internal.Intrinsics.checkNotNull(companionObject, "null cannot be cast to non-null type kotlin.Nothing");
                        list.add(0, (java.lang.Void) companionObject);
                    }
                    java.lang.Object[] array = this.$paramList.element.toArray(new java.lang.Object[0]);
                    kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> objectRef2 = this.$executeRet;
                    io.dcloud.feature.utsplugin.ProxyModule proxyModule = this.this$0;
                    kotlin.reflect.KFunction<?> kFunction = this.$targetFunction;
                    kotlin.jvm.internal.Intrinsics.checkNotNull(kFunction);
                    this.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(array);
                    this.L$1 = objectRef2;
                    this.label = 1;
                    java.lang.Object functionExecuteRet = proxyModule.getFunctionExecuteRet(kFunction, array, this);
                    if (functionExecuteRet == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                    t = functionExecuteRet;
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (kotlin.jvm.internal.Ref.ObjectRef) this.L$1;
                    kotlin.ResultKt.throwOnFailure(obj);
                    t = obj;
                }
                objectRef.element = t;
                return kotlin.Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: io.dcloud.feature.utsplugin.ProxyModule$invokeSync$3, reason: invalid class name */
    /* JADX INFO: compiled from: UTSProxyModule.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "io.dcloud.feature.utsplugin.ProxyModule$invokeSync$3", f = "UTSProxyModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlinx.coroutines.Job>, java.lang.Object> {
        final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<io.dcloud.feature.utsplugin.ReturnResult> $errRet;
        final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> $executeRet;
        final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<java.util.List<java.lang.Object>> $paramList;
        final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<kotlin.reflect.KFunction<?>> $targetFunction;
        private /* synthetic */ java.lang.Object L$0;
        int label;
        final /* synthetic */ io.dcloud.feature.utsplugin.ProxyModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> objectRef, kotlin.jvm.internal.Ref.ObjectRef<io.dcloud.feature.utsplugin.ReturnResult> objectRef2, kotlin.jvm.internal.Ref.ObjectRef<java.util.List<java.lang.Object>> objectRef3, io.dcloud.feature.utsplugin.ProxyModule proxyModule, kotlin.jvm.internal.Ref.ObjectRef<kotlin.reflect.KFunction<?>> objectRef4, kotlin.coroutines.Continuation<? super io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass3> continuation) {
            super(2, continuation);
            this.$executeRet = objectRef;
            this.$errRet = objectRef2;
            this.$paramList = objectRef3;
            this.this$0 = proxyModule;
            this.$targetFunction = objectRef4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass3 anonymousClass3 = new io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass3(this.$executeRet, this.$errRet, this.$paramList, this.this$0, this.$targetFunction, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super kotlinx.coroutines.Job> continuation) {
            return ((io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object obj) {
            kotlinx.coroutines.CoroutineScope coroutineScope = (kotlinx.coroutines.CoroutineScope) this.L$0;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(obj);
            return kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(coroutineScope, new io.dcloud.feature.utsplugin.ProxyModule$invokeSync$3$invokeSuspend$$inlined$CoroutineExceptionHandler$1(kotlinx.coroutines.CoroutineExceptionHandler.INSTANCE, this.$executeRet, this.$errRet), null, new io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass3.AnonymousClass2(this.$paramList, this.$executeRet, this.this$0, this.$targetFunction, null), 2, null);
        }

        /* JADX INFO: renamed from: io.dcloud.feature.utsplugin.ProxyModule$invokeSync$3$2, reason: invalid class name */
        /* JADX INFO: compiled from: UTSProxyModule.kt */
        @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @kotlin.coroutines.jvm.internal.DebugMetadata(c = "io.dcloud.feature.utsplugin.ProxyModule$invokeSync$3$2", f = "UTSProxyModule.kt", i = {0}, l = {1001}, m = "invokeSuspend", n = {"paramArray"}, s = {"L$0"})
        static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
            final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> $executeRet;
            final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<java.util.List<java.lang.Object>> $paramList;
            final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<kotlin.reflect.KFunction<?>> $targetFunction;
            java.lang.Object L$0;
            java.lang.Object L$1;
            int label;
            final /* synthetic */ io.dcloud.feature.utsplugin.ProxyModule this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(kotlin.jvm.internal.Ref.ObjectRef<java.util.List<java.lang.Object>> objectRef, kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> objectRef2, io.dcloud.feature.utsplugin.ProxyModule proxyModule, kotlin.jvm.internal.Ref.ObjectRef<kotlin.reflect.KFunction<?>> objectRef3, kotlin.coroutines.Continuation<? super io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass3.AnonymousClass2> continuation) {
                super(2, continuation);
                this.$paramList = objectRef;
                this.$executeRet = objectRef2;
                this.this$0 = proxyModule;
                this.$targetFunction = objectRef3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
                return new io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass3.AnonymousClass2(this.$paramList, this.$executeRet, this.this$0, this.$targetFunction, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
                return ((io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass3.AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final java.lang.Object invokeSuspend(java.lang.Object obj) {
                kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> objectRef;
                T t;
                java.lang.Object coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    kotlin.ResultKt.throwOnFailure(obj);
                    java.lang.Object[] array = this.$paramList.element.toArray(new java.lang.Object[0]);
                    kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> objectRef2 = this.$executeRet;
                    this.L$0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(array);
                    this.L$1 = objectRef2;
                    this.label = 1;
                    java.lang.Object functionExecuteRet = this.this$0.getFunctionExecuteRet(this.$targetFunction.element, array, this);
                    if (functionExecuteRet == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    objectRef = objectRef2;
                    t = functionExecuteRet;
                } else {
                    if (i != 1) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (kotlin.jvm.internal.Ref.ObjectRef) this.L$1;
                    kotlin.ResultKt.throwOnFailure(obj);
                    t = obj;
                }
                objectRef.element = t;
                return kotlin.Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final <R> java.lang.Object callSuspend(kotlin.reflect.KCallable<? extends R> kCallable, java.lang.Object[] objArr, kotlin.coroutines.Continuation<? super R> continuation) {
        io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass1 anonymousClass1;
        if (continuation instanceof io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass1) {
            anonymousClass1 = (io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass1(continuation);
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
            io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass1 anonymousClass2 = anonymousClass1;
            java.util.List mutableList = kotlin.collections.ArraysKt.toMutableList(objArr);
            mutableList.add(anonymousClass2);
            java.lang.Object[] array = mutableList.toArray(new java.lang.Object[0]);
            objCall = kCallable.call(java.util.Arrays.copyOf(array, array.length));
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

    /* JADX INFO: compiled from: UTSProxyModule.kt */
    @kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lio/dcloud/feature/utsplugin/ProxyModule$ModuleChecker;", "", "inputOption", "Lio/dcloud/feature/utsplugin/ProxyModule$InputOption;", "<init>", "(Lio/dcloud/feature/utsplugin/ProxyModule$InputOption;)V", "shallShowErrorDialog", "", "showErrorDialog", "", "utsplugin_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class ModuleChecker {
        private final io.dcloud.feature.utsplugin.ProxyModule.InputOption inputOption;

        public ModuleChecker(io.dcloud.feature.utsplugin.ProxyModule.InputOption inputOption) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(inputOption, "inputOption");
            this.inputOption = inputOption;
        }

        public final boolean shallShowErrorDialog() {
            if (kotlin.text.StringsKt.equals("built-in", this.inputOption.getInputModuleType(), true)) {
                return !kotlin.jvm.internal.Intrinsics.areEqual("uni-getLocation-tencent-uni1", this.inputOption.getInputModuleName());
            }
            return false;
        }

        public final void showErrorDialog() {
            if (io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity() != null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                android.app.Activity uniActivity = io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity();
                kotlin.jvm.internal.Intrinsics.checkNotNull(uniActivity);
                sb.append(uniActivity.getString(io.dcloud.base.R.string.dcloud_feature_error_tips2));
                sb.append("https://ask.dcloud.net.cn/article/283");
                io.dcloud.common.util.ErrorDialogUtil.getLossDialog(io.dcloud.uts.UTSAndroid.INSTANCE.getUniActivity(), io.dcloud.common.util.StringUtil.format(sb.toString(), this.inputOption.getInputModuleName()), "https://ask.dcloud.net.cn/article/283", this.inputOption.getInputModuleName()).show();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [T, kotlin.reflect.KFunction] */
    /* JADX WARN: Type inference failed for: r0v34, types: [T, kotlin.reflect.KFunction] */
    /* JADX WARN: Type inference failed for: r0v9, types: [T, kotlin.reflect.KFunction] */
    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.util.List] */
    @io.dcloud.feature.uniapp.annotation.UniJSMethod(uiThread = false)
    public java.lang.Object invokeAsync(com.alibaba.fastjson.JSONObject jSONObject, com.taobao.weex.bridge.JSCallback jSCallback, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        java.lang.Class<?> cls;
        io.dcloud.uts.android.AndroidUTSContext androidUTSContext = io.dcloud.uts.android.AndroidUTSContext.INSTANCE;
        io.dcloud.feature.uniapp.AbsSDKInstance mUniSDKInstance = this.mUniSDKInstance;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(mUniSDKInstance, "mUniSDKInstance");
        androidUTSContext.initContext(mUniSDKInstance);
        io.dcloud.feature.utsplugin.ProxyModule.InputOption inputOption = new io.dcloud.feature.utsplugin.ProxyModule.InputOption(jSONObject);
        try {
            if (!inputOption.isValid()) {
                io.dcloud.common.util.AppConsoleLogUtil.DCLog("UTS: " + inputOption.getCheckErrorMsg(), "ERROR");
                return kotlin.Unit.INSTANCE;
            }
            if (!inputOption.getIsInstanceAction()) {
                try {
                    cls = java.lang.Class.forName(inputOption.getModuleName());
                } catch (java.lang.ClassNotFoundException unused) {
                    cls = null;
                }
                if (cls == null) {
                    io.dcloud.feature.utsplugin.ProxyModule.ModuleChecker moduleChecker = new io.dcloud.feature.utsplugin.ProxyModule.ModuleChecker(inputOption);
                    if (moduleChecker.shallShowErrorDialog()) {
                        moduleChecker.showErrorDialog();
                    }
                    io.dcloud.common.util.AppConsoleLogUtil.DCLog("error: " + inputOption.getInputModuleName() + " not found.", "ERROR");
                    return kotlin.Unit.INSTANCE;
                }
                kotlin.jvm.internal.Ref.ObjectRef objectRef = new kotlin.jvm.internal.Ref.ObjectRef();
                objectRef.element = findTargetFunc(cls, inputOption.getIsCompanion(), inputOption.getMethodName(), inputOption);
                io.dcloud.feature.utsplugin.FieldMethodDetector fieldMethodDetector = new io.dcloud.feature.utsplugin.FieldMethodDetector(cls, inputOption);
                kotlin.jvm.internal.Ref.BooleanRef booleanRef = new kotlin.jvm.internal.Ref.BooleanRef();
                if (objectRef.element == 0) {
                    fieldMethodDetector.init();
                    booleanRef.element = fieldMethodDetector.isFieldMethod();
                    objectRef.element = fieldMethodDetector.getTargetFunction();
                }
                if (objectRef.element == 0) {
                    io.dcloud.common.util.AppConsoleLogUtil.DCLog("UTS: targetFunction not exists", "ERROR");
                    return kotlin.Unit.INSTANCE;
                }
                kotlin.jvm.internal.Ref.BooleanRef booleanRef2 = new kotlin.jvm.internal.Ref.BooleanRef();
                booleanRef2.element = !kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.KFunction) objectRef.element).getReturnType(), java.lang.Void.TYPE);
                java.lang.Class<?> cls2 = cls;
                kotlin.jvm.internal.Ref.ObjectRef objectRef2 = new kotlin.jvm.internal.Ref.ObjectRef();
                objectRef2.element = inputOption.obtainParamsWithDefault((kotlin.reflect.KFunction<?>) objectRef.element, jSCallback, booleanRef.element);
                if (inputOption.getIsCompanion()) {
                    ((java.util.List) objectRef2.element).add(0, kotlin.reflect.full.KClasses.getCompanionObjectInstance(kotlin.jvm.JvmClassMappingKt.getKotlinClass(cls2)));
                }
                try {
                    kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(kotlinx.coroutines.Dispatchers.getIO()), new io.dcloud.feature.utsplugin.ProxyModule$invokeAsync$$inlined$CoroutineExceptionHandler$1(kotlinx.coroutines.CoroutineExceptionHandler.INSTANCE), null, new io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass4(objectRef2, booleanRef2, booleanRef, this, objectRef, fieldMethodDetector, jSCallback, null), 2, null);
                } catch (java.lang.Exception e) {
                    io.dcloud.common.util.AppConsoleLogUtil.DCLog("UTS: targetFunction invoke error - " + (e.getCause() != null ? java.lang.String.valueOf(e.getCause()) : e.toString()), "ERROR");
                    kotlin.Unit unit = kotlin.Unit.INSTANCE;
                }
            } else {
                if (utsInstances.get(kotlin.coroutines.jvm.internal.Boxing.boxInt(inputOption.getInstanceId())) == null) {
                    io.dcloud.common.util.AppConsoleLogUtil.DCLog("UTS: instance does not exists", "ERROR");
                    return kotlin.Unit.INSTANCE;
                }
                java.lang.Object obj = utsInstances.get(kotlin.coroutines.jvm.internal.Boxing.boxInt(inputOption.getInstanceId()));
                kotlin.jvm.internal.Intrinsics.checkNotNull(obj);
                java.lang.Class<?> cls3 = obj.getClass();
                java.lang.Object obj2 = utsInstances.get(kotlin.coroutines.jvm.internal.Boxing.boxInt(inputOption.getInstanceId()));
                kotlin.jvm.internal.Ref.ObjectRef objectRef3 = new kotlin.jvm.internal.Ref.ObjectRef();
                objectRef3.element = findTargetFunc(cls3, false, inputOption.getMethodName(), inputOption);
                if (objectRef3.element == 0) {
                    io.dcloud.common.util.AppConsoleLogUtil.DCLog("UTS: targetFunction does not exists", "ERROR");
                    return kotlin.Unit.INSTANCE;
                }
                kotlin.jvm.internal.Ref.BooleanRef booleanRef3 = new kotlin.jvm.internal.Ref.BooleanRef();
                booleanRef3.element = !kotlin.jvm.internal.Intrinsics.areEqual(((kotlin.reflect.KFunction) objectRef3.element).getReturnType(), java.lang.Void.TYPE);
                kotlin.jvm.internal.Ref.ObjectRef objectRef4 = new kotlin.jvm.internal.Ref.ObjectRef();
                objectRef4.element = io.dcloud.feature.utsplugin.ProxyModule.InputOption.obtainParamsWithDefault$default(inputOption, (kotlin.reflect.KFunction) objectRef3.element, jSCallback, false, 4, (java.lang.Object) null);
                ((java.util.List) objectRef4.element).add(0, obj2);
                kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(kotlinx.coroutines.Dispatchers.getIO()), null, null, new io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass2(objectRef4, booleanRef3, this, objectRef3, jSCallback, null), 3, null);
            }
        } catch (java.lang.Exception e2) {
            io.dcloud.common.util.AppConsoleLogUtil.DCLog("UTS: targetFunction invoke error - " + (e2.getCause() != null ? java.lang.String.valueOf(e2.getCause()) : e2.toString()), "ERROR");
        }
        return kotlin.Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: io.dcloud.feature.utsplugin.ProxyModule$invokeAsync$2, reason: invalid class name */
    /* JADX INFO: compiled from: UTSProxyModule.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "io.dcloud.feature.utsplugin.ProxyModule$invokeAsync$2", f = "UTSProxyModule.kt", i = {0, 1, 1, 2}, l = {1169, 1170, 1181}, m = "invokeSuspend", n = {"paramArray", "paramArray", "deferredRet", "paramArray"}, s = {"L$0", "L$0", "L$1", "L$0"})
    static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ com.taobao.weex.bridge.JSCallback $callback;
        final /* synthetic */ kotlin.jvm.internal.Ref.BooleanRef $needReturn;
        final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<java.util.List<java.lang.Object>> $paramList;
        final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<kotlin.reflect.KFunction<?>> $targetFunction;
        java.lang.Object L$0;
        java.lang.Object L$1;
        int label;
        final /* synthetic */ io.dcloud.feature.utsplugin.ProxyModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(kotlin.jvm.internal.Ref.ObjectRef<java.util.List<java.lang.Object>> objectRef, kotlin.jvm.internal.Ref.BooleanRef booleanRef, io.dcloud.feature.utsplugin.ProxyModule proxyModule, kotlin.jvm.internal.Ref.ObjectRef<kotlin.reflect.KFunction<?>> objectRef2, com.taobao.weex.bridge.JSCallback jSCallback, kotlin.coroutines.Continuation<? super io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass2> continuation) {
            super(2, continuation);
            this.$paramList = objectRef;
            this.$needReturn = booleanRef;
            this.this$0 = proxyModule;
            this.$targetFunction = objectRef2;
            this.$callback = jSCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            return new io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass2(this.$paramList, this.$needReturn, this.this$0, this.$targetFunction, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return ((io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x008c  */
        /* JADX WARN: Code duplicated, block: B:29:0x0096 A[Catch: all -> 0x00d9, TryCatch #0 {all -> 0x00d9, blocks: (B:8:0x0015, B:34:0x00c6, B:13:0x002a, B:27:0x008d, B:29:0x0096, B:30:0x00a0, B:16:0x0032, B:24:0x006e, B:19:0x0039, B:21:0x004c, B:31:0x00a4), top: B:47:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:30:0x00a0 A[Catch: all -> 0x00d9, TryCatch #0 {all -> 0x00d9, blocks: (B:8:0x0015, B:34:0x00c6, B:13:0x002a, B:27:0x008d, B:29:0x0096, B:30:0x00a0, B:16:0x0032, B:24:0x006e, B:19:0x0039, B:21:0x004c, B:31:0x00a4), top: B:47:0x0009 }] */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00c3, code lost:
        
            if (r9.callSuspend(r3, java.util.Arrays.copyOf(r1, r1.length), r8) == r0) goto L33;
         */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                Method dump skipped, instruction units count: 258
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: io.dcloud.feature.utsplugin.ProxyModule$invokeAsync$4, reason: invalid class name */
    /* JADX INFO: compiled from: UTSProxyModule.kt */
    @kotlin.Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "io.dcloud.feature.utsplugin.ProxyModule$invokeAsync$4", f = "UTSProxyModule.kt", i = {0, 1, 1, 2}, l = {1269, 1274, 1292}, m = "invokeSuspend", n = {"paramArray", "paramArray", "deferredRet", "paramArray"}, s = {"L$0", "L$0", "L$1", "L$0"})
    static final class AnonymousClass4 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        final /* synthetic */ com.taobao.weex.bridge.JSCallback $callback;
        final /* synthetic */ io.dcloud.feature.utsplugin.FieldMethodDetector $fieldMethodDetector;
        final /* synthetic */ kotlin.jvm.internal.Ref.BooleanRef $isFieldMethod;
        final /* synthetic */ kotlin.jvm.internal.Ref.BooleanRef $needReturn;
        final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<java.util.List<java.lang.Object>> $paramList;
        final /* synthetic */ kotlin.jvm.internal.Ref.ObjectRef<kotlin.reflect.KFunction<?>> $targetFunction;
        java.lang.Object L$0;
        java.lang.Object L$1;
        int label;
        final /* synthetic */ io.dcloud.feature.utsplugin.ProxyModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(kotlin.jvm.internal.Ref.ObjectRef<java.util.List<java.lang.Object>> objectRef, kotlin.jvm.internal.Ref.BooleanRef booleanRef, kotlin.jvm.internal.Ref.BooleanRef booleanRef2, io.dcloud.feature.utsplugin.ProxyModule proxyModule, kotlin.jvm.internal.Ref.ObjectRef<kotlin.reflect.KFunction<?>> objectRef2, io.dcloud.feature.utsplugin.FieldMethodDetector fieldMethodDetector, com.taobao.weex.bridge.JSCallback jSCallback, kotlin.coroutines.Continuation<? super io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass4> continuation) {
            super(2, continuation);
            this.$paramList = objectRef;
            this.$needReturn = booleanRef;
            this.$isFieldMethod = booleanRef2;
            this.this$0 = proxyModule;
            this.$targetFunction = objectRef2;
            this.$fieldMethodDetector = fieldMethodDetector;
            this.$callback = jSCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(java.lang.Object obj, kotlin.coroutines.Continuation<?> continuation) {
            return new io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass4(this.$paramList, this.$needReturn, this.$isFieldMethod, this.this$0, this.$targetFunction, this.$fieldMethodDetector, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final java.lang.Object invoke(kotlinx.coroutines.CoroutineScope coroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return ((io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0071, code lost:
        
            if (r10 == r0) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x00ad, code lost:
        
            if (r10 == r0) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00ed, code lost:
        
            if (r9.this$0.callSuspend(r9.$targetFunction.element, java.util.Arrays.copyOf(r1, r1.length), r9) == r0) goto L32;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
            /*
                Method dump skipped, instruction units count: 292
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.dcloud.feature.utsplugin.ProxyModule.AnonymousClass4.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // io.dcloud.common.DHInterface.message.IObserveAble
    public io.dcloud.common.DHInterface.message.EnumUniqueID getActionObserverID() {
        return io.dcloud.common.DHInterface.message.EnumUniqueID.FEATURE_UTS;
    }
}
