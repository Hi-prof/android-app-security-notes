package com.alibaba.android.bindingx.core.internal;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractEventHandler implements com.alibaba.android.bindingx.core.IEventHandler {
    protected java.lang.String mAnchorInstanceId;
    protected com.alibaba.android.bindingx.core.BindingXCore.JavaScriptCallback mCallback;
    protected android.content.Context mContext;
    protected com.alibaba.android.bindingx.core.internal.ExpressionPair mExitExpressionPair;
    protected volatile java.util.Map<java.lang.String, java.util.List<com.alibaba.android.bindingx.core.internal.ExpressionHolder>> mExpressionHoldersMap;
    protected java.lang.Object[] mExtensionParams;
    protected java.lang.String mInstanceId;
    protected volatile java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.internal.ExpressionPair> mInterceptorsMap;
    protected com.alibaba.android.bindingx.core.PlatformManager mPlatformManager;
    protected java.lang.String mToken;
    protected final java.util.Map<java.lang.String, java.lang.Object> mScope = new java.util.HashMap();
    private com.alibaba.android.bindingx.core.internal.AbstractEventHandler.Cache<java.lang.String, com.alibaba.android.bindingx.core.internal.Expression> mCachedExpressionMap = new com.alibaba.android.bindingx.core.internal.AbstractEventHandler.Cache<>(16);

    protected abstract void onExit(java.util.Map<java.lang.String, java.lang.Object> map);

    protected abstract void onUserIntercept(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map);

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void setGlobalConfig(java.util.Map<java.lang.String, java.lang.Object> map) {
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0026  */
    public AbstractEventHandler(android.content.Context context, com.alibaba.android.bindingx.core.PlatformManager platformManager, java.lang.Object... objArr) {
        java.lang.String str;
        this.mContext = context;
        this.mPlatformManager = platformManager;
        if (objArr == null || objArr.length <= 0) {
            str = null;
        } else {
            java.lang.Object obj = objArr[0];
            if (obj instanceof java.lang.String) {
                str = (java.lang.String) obj;
            } else {
                str = null;
            }
        }
        this.mInstanceId = str;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void setAnchorInstanceId(java.lang.String str) {
        this.mAnchorInstanceId = str;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onBindExpression(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, com.alibaba.android.bindingx.core.internal.ExpressionPair expressionPair, java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list, com.alibaba.android.bindingx.core.BindingXCore.JavaScriptCallback javaScriptCallback) {
        clearExpressions();
        transformArgs(str, list);
        this.mCallback = javaScriptCallback;
        this.mExitExpressionPair = expressionPair;
        if (!this.mScope.isEmpty()) {
            this.mScope.clear();
        }
        applyFunctionsToScope();
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void onDestroy() {
        this.mCachedExpressionMap.clear();
        com.alibaba.android.bindingx.core.BindingXPropertyInterceptor.getInstance().clearCallbacks();
    }

    private void applyFunctionsToScope() {
        com.alibaba.android.bindingx.core.internal.JSMath.applyToScope(this.mScope);
        com.alibaba.android.bindingx.core.internal.TimingFunctions.applyToScope(this.mScope);
        java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.internal.JSFunctionInterface> jSFunctions = com.alibaba.android.bindingx.core.BindingXJSFunctionRegister.getInstance().getJSFunctions();
        if (jSFunctions == null || jSFunctions.isEmpty()) {
            return;
        }
        this.mScope.putAll(jSFunctions);
    }

    private void transformArgs(java.lang.String str, java.util.List<java.util.Map<java.lang.String, java.lang.Object>> list) {
        java.util.Map<java.lang.String, java.lang.Object> map;
        java.lang.String str2;
        if (this.mExpressionHoldersMap == null) {
            this.mExpressionHoldersMap = new java.util.HashMap();
        }
        for (java.util.Map<java.lang.String, java.lang.Object> map2 : list) {
            java.lang.String stringValue = com.alibaba.android.bindingx.core.internal.Utils.getStringValue(map2, com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_ELEMENT);
            java.lang.String stringValue2 = com.alibaba.android.bindingx.core.internal.Utils.getStringValue(map2, "instanceId");
            java.lang.String stringValue3 = com.alibaba.android.bindingx.core.internal.Utils.getStringValue(map2, "property");
            com.alibaba.android.bindingx.core.internal.ExpressionPair expressionPair = com.alibaba.android.bindingx.core.internal.Utils.getExpressionPair(map2, com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_EXPRESSION);
            java.lang.Object obj = map2.get(com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_CONFIG);
            if (obj == null || !(obj instanceof java.util.Map)) {
                map = null;
            } else {
                try {
                    map = com.alibaba.android.bindingx.core.internal.Utils.toMap(new org.json.JSONObject((java.util.Map) obj));
                } catch (java.lang.Exception e) {
                    com.alibaba.android.bindingx.core.LogProxy.e("parse config failed", e);
                    map = null;
                }
            }
            java.util.Map<java.lang.String, java.lang.Object> map3 = map;
            if (android.text.TextUtils.isEmpty(stringValue) || android.text.TextUtils.isEmpty(stringValue3) || expressionPair == null) {
                str2 = str;
                com.alibaba.android.bindingx.core.LogProxy.e("skip illegal binding args[" + stringValue + "," + stringValue3 + "," + expressionPair + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
            } else {
                str2 = str;
                com.alibaba.android.bindingx.core.internal.ExpressionHolder expressionHolder = new com.alibaba.android.bindingx.core.internal.ExpressionHolder(stringValue, stringValue2, expressionPair, stringValue3, str2, map3);
                java.util.List<com.alibaba.android.bindingx.core.internal.ExpressionHolder> list2 = this.mExpressionHoldersMap.get(stringValue);
                if (list2 == null) {
                    java.util.ArrayList arrayList = new java.util.ArrayList(4);
                    this.mExpressionHoldersMap.put(stringValue, arrayList);
                    arrayList.add(expressionHolder);
                } else if (!list2.contains(expressionHolder)) {
                    list2.add(expressionHolder);
                }
            }
            str = str2;
        }
    }

    protected boolean evaluateExitExpression(com.alibaba.android.bindingx.core.internal.ExpressionPair expressionPair, java.util.Map<java.lang.String, java.lang.Object> map) {
        boolean zBooleanValue;
        if (com.alibaba.android.bindingx.core.internal.ExpressionPair.isValid(expressionPair)) {
            try {
                zBooleanValue = ((java.lang.Boolean) new com.alibaba.android.bindingx.core.internal.Expression(expressionPair.transformed).execute(map)).booleanValue();
            } catch (java.lang.Exception e) {
                com.alibaba.android.bindingx.core.LogProxy.e("evaluateExitExpression failed. ", e);
                zBooleanValue = false;
            }
        } else {
            zBooleanValue = false;
        }
        if (zBooleanValue) {
            clearExpressions();
            try {
                onExit(map);
            } catch (java.lang.Exception e2) {
                com.alibaba.android.bindingx.core.LogProxy.e("execute exit expression failed: ", e2);
            }
            com.alibaba.android.bindingx.core.LogProxy.d("exit = true,consume finished");
        }
        return zBooleanValue;
    }

    @Override // com.alibaba.android.bindingx.core.IEventInterceptor
    public void setInterceptors(java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.internal.ExpressionPair> map) {
        this.mInterceptorsMap = map;
    }

    @Override // com.alibaba.android.bindingx.core.IEventInterceptor
    public void performInterceptIfNeeded(java.lang.String str, com.alibaba.android.bindingx.core.internal.ExpressionPair expressionPair, java.util.Map<java.lang.String, java.lang.Object> map) {
        boolean zBooleanValue;
        if (com.alibaba.android.bindingx.core.internal.ExpressionPair.isValid(expressionPair)) {
            try {
                zBooleanValue = ((java.lang.Boolean) new com.alibaba.android.bindingx.core.internal.Expression(expressionPair.transformed).execute(map)).booleanValue();
            } catch (java.lang.Exception e) {
                com.alibaba.android.bindingx.core.LogProxy.e("evaluate interceptor [" + str + "] expression failed. ", e);
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                onUserIntercept(str, map);
            }
        }
    }

    private void tryInterceptAllIfNeeded(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (this.mInterceptorsMap == null || this.mInterceptorsMap.isEmpty()) {
            return;
        }
        for (java.util.Map.Entry<java.lang.String, com.alibaba.android.bindingx.core.internal.ExpressionPair> entry : this.mInterceptorsMap.entrySet()) {
            java.lang.String key = entry.getKey();
            com.alibaba.android.bindingx.core.internal.ExpressionPair value = entry.getValue();
            if (!android.text.TextUtils.isEmpty(key) && value != null) {
                performInterceptIfNeeded(key, value, map);
            }
        }
    }

    protected void consumeExpression(java.util.Map<java.lang.String, java.util.List<com.alibaba.android.bindingx.core.internal.ExpressionHolder>> map, java.util.Map<java.lang.String, java.lang.Object> map2, java.lang.String str) throws org.json.JSONException, java.lang.IllegalArgumentException {
        java.util.Map<java.lang.String, java.lang.Object> map3 = map2;
        tryInterceptAllIfNeeded(map3);
        if (map == null) {
            com.alibaba.android.bindingx.core.LogProxy.e("expression args is null");
            return;
        }
        if (map.isEmpty()) {
            com.alibaba.android.bindingx.core.LogProxy.e("no expression need consumed");
            return;
        }
        if (com.alibaba.android.bindingx.core.LogProxy.sEnableLog) {
            com.alibaba.android.bindingx.core.LogProxy.d(java.lang.String.format(java.util.Locale.getDefault(), "consume expression with %d tasks. event type is %s", java.lang.Integer.valueOf(map.size()), str));
        }
        java.util.LinkedList linkedList = new java.util.LinkedList();
        java.util.Iterator<java.util.List<com.alibaba.android.bindingx.core.internal.ExpressionHolder>> it = map.values().iterator();
        while (it.hasNext()) {
            for (com.alibaba.android.bindingx.core.internal.ExpressionHolder expressionHolder : it.next()) {
                if (str.equals(expressionHolder.eventType)) {
                    linkedList.clear();
                    java.lang.Object[] objArr = this.mExtensionParams;
                    if (objArr != null && objArr.length > 0) {
                        java.util.Collections.addAll(linkedList, objArr);
                    }
                    java.lang.String str2 = android.text.TextUtils.isEmpty(expressionHolder.targetInstanceId) ? this.mInstanceId : expressionHolder.targetInstanceId;
                    if (!android.text.TextUtils.isEmpty(str2)) {
                        linkedList.add(str2);
                    }
                    com.alibaba.android.bindingx.core.internal.ExpressionPair expressionPair = expressionHolder.expressionPair;
                    if (com.alibaba.android.bindingx.core.internal.ExpressionPair.isValid(expressionPair)) {
                        com.alibaba.android.bindingx.core.internal.Expression expression = this.mCachedExpressionMap.get(expressionPair.transformed);
                        if (expression == null) {
                            expression = new com.alibaba.android.bindingx.core.internal.Expression(expressionPair.transformed);
                            this.mCachedExpressionMap.put(expressionPair.transformed, expression);
                        }
                        java.lang.Object objExecute = expression.execute(map3);
                        if (objExecute == null) {
                            com.alibaba.android.bindingx.core.LogProxy.e("failed to execute expression,expression result is null");
                        } else if (((objExecute instanceof java.lang.Double) && java.lang.Double.isNaN(((java.lang.Double) objExecute).doubleValue())) || ((objExecute instanceof java.lang.Float) && java.lang.Float.isNaN(((java.lang.Float) objExecute).floatValue()))) {
                            com.alibaba.android.bindingx.core.LogProxy.e("failed to execute expression,expression result is NaN");
                        } else {
                            android.view.View viewFindViewBy = this.mPlatformManager.getViewFinder().findViewBy(expressionHolder.targetRef, linkedList.toArray());
                            com.alibaba.android.bindingx.core.BindingXPropertyInterceptor.getInstance().performIntercept(viewFindViewBy, expressionHolder.prop, objExecute, this.mPlatformManager.getResolutionTranslator(), expressionHolder.config, expressionHolder.targetRef, str2);
                            if (viewFindViewBy == null) {
                                com.alibaba.android.bindingx.core.LogProxy.e("failed to execute expression,target view not found.[ref:" + expressionHolder.targetRef + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
                            } else {
                                this.mPlatformManager.getViewUpdater().synchronouslyUpdateViewOnUIThread(viewFindViewBy, expressionHolder.prop, objExecute, this.mPlatformManager.getResolutionTranslator(), expressionHolder.config, expressionHolder.targetRef, str2);
                            }
                            map3 = map2;
                        }
                    }
                } else {
                    com.alibaba.android.bindingx.core.LogProxy.d("skip expression with wrong event type.[expected:" + str + ",found:" + expressionHolder.eventType + com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
                }
            }
            map3 = map2;
        }
    }

    protected void clearExpressions() {
        com.alibaba.android.bindingx.core.LogProxy.d("all expression are cleared");
        if (this.mExpressionHoldersMap != null) {
            this.mExpressionHoldersMap.clear();
            this.mExpressionHoldersMap = null;
        }
        this.mExitExpressionPair = null;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void setToken(java.lang.String str) {
        this.mToken = str;
    }

    @Override // com.alibaba.android.bindingx.core.IEventHandler
    public void setExtensionParams(java.lang.Object[] objArr) {
        this.mExtensionParams = objArr;
    }

    static class Cache<K, V> extends java.util.LinkedHashMap<K, V> {
        private int maxSize;

        Cache(int i) {
            super(4, 0.75f, true);
            this.maxSize = java.lang.Math.max(i, 4);
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(java.util.Map.Entry entry) {
            return size() > this.maxSize;
        }
    }
}
