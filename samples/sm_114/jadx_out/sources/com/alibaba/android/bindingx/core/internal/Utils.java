package com.alibaba.android.bindingx.core.internal;

/* JADX INFO: loaded from: classes.dex */
public final class Utils {
    public static float normalizeRotation(float f) {
        float f2 = f % 360.0f;
        if (f2 >= 0.0f) {
            if (f2 < 0.0f || f2 > 180.0f) {
                return (f2 % 180.0f) - 180.0f;
            }
        } else if (f2 <= -180.0f || f2 >= 0.0f) {
            return (f2 % 180.0f) + 180.0f;
        }
        return f2;
    }

    private Utils() {
    }

    public static java.util.Map<java.lang.String, java.lang.Object> toMap(org.json.JSONObject jSONObject) throws org.json.JSONException {
        if (jSONObject == null) {
            return java.util.Collections.EMPTY_MAP;
        }
        java.util.HashMap map = new java.util.HashMap();
        java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            java.lang.String next = itKeys.next();
            map.put(next, fromJson(jSONObject.get(next)));
        }
        return map;
    }

    public static java.util.List toList(org.json.JSONArray jSONArray) throws org.json.JSONException {
        if (jSONArray == null) {
            return java.util.Collections.EMPTY_LIST;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(fromJson(jSONArray.get(i)));
        }
        return arrayList;
    }

    private static java.lang.Object fromJson(java.lang.Object obj) throws org.json.JSONException {
        if (obj == org.json.JSONObject.NULL) {
            return null;
        }
        if (obj instanceof org.json.JSONObject) {
            return toMap((org.json.JSONObject) obj);
        }
        return obj instanceof org.json.JSONArray ? toList((org.json.JSONArray) obj) : obj;
    }

    public static java.lang.String getStringValue(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str) {
        java.lang.Object obj = map.get(str);
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.lang.String) {
            return (java.lang.String) obj;
        }
        return obj.toString();
    }

    public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getRuntimeProps(java.util.Map<java.lang.String, java.lang.Object> map) {
        java.lang.Object obj = map.get(com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_RUNTIME_PROPS);
        if (obj == null) {
            return null;
        }
        try {
            return (java.util.List) obj;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.util.Map<java.lang.String, com.alibaba.android.bindingx.core.internal.ExpressionPair> getCustomInterceptors(java.util.Map<java.lang.String, java.lang.Object> map) {
        com.alibaba.android.bindingx.core.internal.ExpressionPair expressionPair;
        java.lang.Object obj = map.get(com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_INTERCEPTORS);
        if (obj == null || !(obj instanceof java.util.Map)) {
            return null;
        }
        java.util.HashMap map2 = new java.util.HashMap(8);
        for (java.util.Map.Entry entry : ((java.util.Map) obj).entrySet()) {
            java.lang.Object key = entry.getKey();
            java.lang.Object value = entry.getValue();
            if ((key instanceof java.lang.String) && (value instanceof java.util.Map)) {
                try {
                    expressionPair = getExpressionPair((java.util.Map) value, com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_EXPRESSION);
                } catch (java.lang.Exception unused) {
                    expressionPair = null;
                }
                if (expressionPair != null) {
                    map2.put((java.lang.String) key, expressionPair);
                }
            }
        }
        return map2;
    }

    public static com.alibaba.android.bindingx.core.internal.ExpressionPair getExpressionPair(java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String str) {
        org.json.JSONObject jSONObject;
        java.lang.Object obj = map.get(str);
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.lang.String) {
            return com.alibaba.android.bindingx.core.internal.ExpressionPair.create(null, (java.lang.String) obj);
        }
        if (!(obj instanceof java.util.Map)) {
            return null;
        }
        try {
            jSONObject = new org.json.JSONObject((java.util.Map) obj);
        } catch (java.lang.Throwable th) {
            com.alibaba.android.bindingx.core.LogProxy.e("unexpected json parse error.", th);
            jSONObject = null;
        }
        if (jSONObject == null) {
            return com.alibaba.android.bindingx.core.internal.ExpressionPair.create(null, null);
        }
        java.lang.String strOptString = jSONObject.optString("origin", null);
        java.lang.String strOptString2 = jSONObject.optString(com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_TRANSFORMED, null);
        if (android.text.TextUtils.isEmpty(strOptString) && android.text.TextUtils.isEmpty(strOptString2)) {
            return com.alibaba.android.bindingx.core.internal.ExpressionPair.create(null, null);
        }
        return com.alibaba.android.bindingx.core.internal.ExpressionPair.create(strOptString, strOptString2);
    }

    @java.lang.SafeVarargs
    public static <E> java.util.HashSet<E> newHashSet(E... eArr) {
        java.util.HashSet<E> hashSet = new java.util.HashSet<>(eArr.length);
        java.util.Collections.addAll(hashSet, eArr);
        return hashSet;
    }

    @java.lang.SafeVarargs
    public static <E> java.util.ArrayList<E> newArrayList(E... eArr) {
        java.util.ArrayList<E> arrayList = new java.util.ArrayList<>(eArr.length);
        java.util.Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    public static int normalizedPerspectiveValue(android.content.Context context, int i) {
        return (int) (context.getApplicationContext().getResources().getDisplayMetrics().density * i * 5.0f);
    }

    public static android.util.Pair<java.lang.Float, java.lang.Float> parseTransformOrigin(java.lang.String str, android.view.View view) {
        int iIndexOf;
        int width;
        float f;
        int height;
        if (!android.text.TextUtils.isEmpty(str) && (iIndexOf = str.indexOf(32)) != -1) {
            int i = iIndexOf;
            while (i < str.length() && str.charAt(i) == ' ') {
                i++;
            }
            if (i < str.length() && str.charAt(i) != ' ') {
                java.lang.String strTrim = str.substring(0, iIndexOf).trim();
                java.lang.String strTrim2 = str.substring(i, str.length()).trim();
                float f2 = 0.0f;
                if ("left".equals(strTrim)) {
                    f = 0.0f;
                } else {
                    if ("right".equals(strTrim)) {
                        width = view.getWidth();
                    } else if ("center".equals(strTrim)) {
                        width = view.getWidth() / 2;
                    } else {
                        width = view.getWidth() / 2;
                    }
                    f = width;
                }
                if (!"top".equals(strTrim2)) {
                    if ("bottom".equals(strTrim2)) {
                        height = view.getHeight();
                    } else if ("center".equals(strTrim2)) {
                        height = view.getHeight() / 2;
                    } else {
                        height = view.getHeight() / 2;
                    }
                    f2 = height;
                }
                return new android.util.Pair<>(java.lang.Float.valueOf(f), java.lang.Float.valueOf(f2));
            }
        }
        return null;
    }
}
