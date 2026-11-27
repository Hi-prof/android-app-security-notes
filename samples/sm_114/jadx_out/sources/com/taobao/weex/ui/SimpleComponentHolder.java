package com.taobao.weex.ui;

/* JADX INFO: loaded from: classes.dex */
public class SimpleComponentHolder implements com.taobao.weex.ui.IFComponentHolder {
    public static final java.lang.String TAG = "SimpleComponentHolder";
    private final java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent> mClz;
    private com.taobao.weex.ui.ComponentCreator mCreator;
    private java.util.Map<java.lang.String, com.taobao.weex.bridge.Invoker> mMethodInvokers;
    private java.util.Map<java.lang.String, com.taobao.weex.bridge.Invoker> mPropertyInvokers;

    public static class ClazzComponentCreator implements com.taobao.weex.ui.ComponentCreator {
        private java.lang.reflect.Constructor<? extends com.taobao.weex.ui.component.WXComponent> mAbsConstructor;
        private final java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent> mCompClz;
        private java.lang.reflect.Constructor<? extends com.taobao.weex.ui.component.WXComponent> mConstructor;

        public ClazzComponentCreator(java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent> cls) {
            this.mCompClz = cls;
        }

        private java.lang.reflect.Constructor<? extends com.taobao.weex.ui.component.WXComponent> getComponentConstructor(java.lang.Boolean bool) {
            java.lang.Class<?> cls;
            java.lang.Class<?> cls2;
            java.lang.Class<?> cls3;
            java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent> cls4 = this.mCompClz;
            if (bool.booleanValue()) {
                cls = io.dcloud.feature.uniapp.UniSDKInstance.class;
                cls2 = io.dcloud.feature.uniapp.ui.component.AbsVContainer.class;
                cls3 = io.dcloud.feature.uniapp.ui.action.AbsComponentData.class;
            } else {
                cls = com.taobao.weex.WXSDKInstance.class;
                cls2 = com.taobao.weex.ui.component.WXVContainer.class;
                cls3 = com.taobao.weex.ui.action.BasicComponentData.class;
            }
            try {
                return cls4.getConstructor(cls, cls2, cls3);
            } catch (java.lang.NoSuchMethodException unused) {
                com.taobao.weex.utils.WXLogUtils.d("ClazzComponentCreator", "Use deprecated component constructor");
                try {
                    return cls4.getConstructor(cls, cls2, java.lang.Boolean.TYPE, cls3);
                } catch (java.lang.NoSuchMethodException unused2) {
                    try {
                        return cls4.getConstructor(cls, cls2, java.lang.String.class, java.lang.Boolean.TYPE, cls3);
                    } catch (java.lang.NoSuchMethodException unused3) {
                        throw new com.taobao.weex.common.WXRuntimeException("Can't find constructor of component.");
                    }
                }
            }
        }

        @Override // com.taobao.weex.ui.ComponentCreator
        public com.taobao.weex.ui.component.WXComponent createInstance(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
            java.lang.reflect.Constructor<? extends com.taobao.weex.ui.component.WXComponent> constructor;
            boolean z = io.dcloud.feature.uniapp.ui.component.UniVContainer.class.isAssignableFrom(this.mCompClz) || io.dcloud.feature.uniapp.ui.component.UniComponent.class.isAssignableFrom(this.mCompClz);
            if (z) {
                if (this.mAbsConstructor == null) {
                    this.mAbsConstructor = getComponentConstructor(java.lang.Boolean.valueOf(z));
                }
                constructor = this.mAbsConstructor;
            } else {
                if (this.mConstructor == null) {
                    this.mConstructor = getComponentConstructor(java.lang.Boolean.valueOf(z));
                }
                constructor = this.mConstructor;
            }
            int length = constructor.getParameterTypes().length;
            if (length == 3) {
                return constructor.newInstance(wXSDKInstance, wXVContainer, basicComponentData);
            }
            return length == 4 ? constructor.newInstance(wXSDKInstance, wXVContainer, false, basicComponentData) : constructor.newInstance(wXSDKInstance, wXVContainer, wXSDKInstance.getInstanceId(), java.lang.Boolean.valueOf(wXVContainer.isLazy()));
        }
    }

    public SimpleComponentHolder(java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent> cls) {
        this(cls, new com.taobao.weex.ui.SimpleComponentHolder.ClazzComponentCreator(cls));
    }

    public SimpleComponentHolder(java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent> cls, com.taobao.weex.ui.ComponentCreator componentCreator) {
        this.mClz = cls;
        this.mCreator = componentCreator;
    }

    @Override // io.dcloud.feature.uniapp.ui.AbsIComponentHolder
    public void loadIfNonLazy() {
        for (java.lang.annotation.Annotation annotation : this.mClz.getDeclaredAnnotations()) {
            if (annotation instanceof com.taobao.weex.annotation.Component) {
                if (((com.taobao.weex.annotation.Component) annotation).lazyload() || this.mMethodInvokers != null) {
                    return;
                }
                generate();
                return;
            }
        }
    }

    private synchronized void generate() {
        if (com.taobao.weex.WXEnvironment.isApkDebugable()) {
            com.taobao.weex.utils.WXLogUtils.d("SimpleComponentHolder", "Generate Component:" + this.mClz.getSimpleName());
        }
        android.util.Pair<java.util.Map<java.lang.String, com.taobao.weex.bridge.Invoker>, java.util.Map<java.lang.String, com.taobao.weex.bridge.Invoker>> methods = getMethods(this.mClz);
        this.mPropertyInvokers = (java.util.Map) methods.first;
        this.mMethodInvokers = (java.util.Map) methods.second;
    }

    public static android.util.Pair<java.util.Map<java.lang.String, com.taobao.weex.bridge.Invoker>, java.util.Map<java.lang.String, com.taobao.weex.bridge.Invoker>> getMethods(java.lang.Class cls) {
        java.util.HashMap map = new java.util.HashMap();
        java.util.HashMap map2 = new java.util.HashMap();
        try {
            for (java.lang.reflect.Method method : cls.getMethods()) {
                try {
                    for (java.lang.annotation.Annotation annotation : method.getDeclaredAnnotations()) {
                        if (annotation != null) {
                            if (annotation instanceof com.taobao.weex.ui.component.WXComponentProp) {
                                map.put(((com.taobao.weex.ui.component.WXComponentProp) annotation).name(), new com.taobao.weex.bridge.MethodInvoker(method, true));
                                break;
                            }
                            if (annotation instanceof com.taobao.weex.annotation.JSMethod) {
                                com.taobao.weex.annotation.JSMethod jSMethod = (com.taobao.weex.annotation.JSMethod) annotation;
                                java.lang.String strAlias = jSMethod.alias();
                                if ("_".equals(strAlias)) {
                                    strAlias = method.getName();
                                }
                                map2.put(strAlias, new com.taobao.weex.bridge.MethodInvoker(method, jSMethod.uiThread()));
                                break;
                            }
                            if (annotation instanceof io.dcloud.feature.uniapp.ui.component.UniComponentProp) {
                                map.put(((io.dcloud.feature.uniapp.ui.component.UniComponentProp) annotation).name(), new com.taobao.weex.bridge.MethodInvoker(method, true));
                                break;
                            }
                            if (annotation instanceof io.dcloud.feature.uniapp.annotation.UniJSMethod) {
                                io.dcloud.feature.uniapp.annotation.UniJSMethod uniJSMethod = (io.dcloud.feature.uniapp.annotation.UniJSMethod) annotation;
                                java.lang.String strAlias2 = uniJSMethod.alias();
                                if ("_".equals(strAlias2)) {
                                    strAlias2 = method.getName();
                                }
                                map2.put(strAlias2, new com.taobao.weex.bridge.MethodInvoker(method, uniJSMethod.uiThread()));
                                break;
                            }
                        }
                    }
                } catch (java.lang.ArrayIndexOutOfBoundsException | java.lang.IncompatibleClassChangeError unused) {
                }
            }
        } catch (java.lang.IndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (java.lang.Exception e2) {
            com.taobao.weex.utils.WXLogUtils.e("SimpleComponentHolder", e2);
        }
        return new android.util.Pair<>(map, map2);
    }

    @Override // com.taobao.weex.ui.ComponentCreator
    public synchronized com.taobao.weex.ui.component.WXComponent createInstance(com.taobao.weex.WXSDKInstance wXSDKInstance, com.taobao.weex.ui.component.WXVContainer wXVContainer, com.taobao.weex.ui.action.BasicComponentData basicComponentData) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
        com.taobao.weex.ui.component.WXComponent wXComponentCreateInstance;
        wXComponentCreateInstance = this.mCreator.createInstance(wXSDKInstance, wXVContainer, basicComponentData);
        wXComponentCreateInstance.bindHolder(this);
        return wXComponentCreateInstance;
    }

    @Override // io.dcloud.feature.uniapp.ui.AbsIComponentHolder
    public synchronized com.taobao.weex.bridge.Invoker getPropertyInvoker(java.lang.String str) {
        if (this.mPropertyInvokers == null) {
            generate();
        }
        return this.mPropertyInvokers.get(str);
    }

    @Override // com.taobao.weex.bridge.JavascriptInvokable
    public com.taobao.weex.bridge.Invoker getMethodInvoker(java.lang.String str) {
        if (this.mMethodInvokers == null) {
            generate();
        }
        return this.mMethodInvokers.get(str);
    }

    @Override // com.taobao.weex.bridge.JavascriptInvokable
    public synchronized java.lang.String[] getMethods() {
        java.util.Set<java.lang.String> setKeySet;
        if (this.mMethodInvokers == null) {
            generate();
        }
        setKeySet = this.mMethodInvokers.keySet();
        try {
        } catch (java.lang.Throwable unused) {
            java.lang.Class<? extends com.taobao.weex.ui.component.WXComponent> cls = this.mClz;
            if (cls != null) {
                com.taobao.weex.utils.WXExceptionUtils.commitCriticalExceptionRT(null, com.taobao.weex.common.WXErrorCode.WX_KEY_EXCEPTION_INVOKE_REGISTER_COMPONENT, com.taobao.weex.bridge.WXBridgeManager.METHOD_REGISTER_COMPONENTS, cls.getName() + ": gen methods failed", null);
            }
            return new java.lang.String[1];
        }
        return (java.lang.String[]) setKeySet.toArray(new java.lang.String[setKeySet.size()]);
    }
}
