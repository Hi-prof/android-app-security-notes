package com.alibaba.android.bindingx.core.internal;

/* JADX INFO: loaded from: classes.dex */
class Expression {
    private org.json.JSONObject root;

    Expression(java.lang.String str) {
        try {
            this.root = (org.json.JSONObject) new org.json.JSONTokener(str).nextValue();
        } catch (java.lang.Throwable th) {
            com.alibaba.android.bindingx.core.LogProxy.e("[Expression] expression is illegal. \n ", th);
        }
    }

    Expression(org.json.JSONObject jSONObject) {
        this.root = jSONObject;
    }

    java.lang.Object execute(java.util.Map<java.lang.String, java.lang.Object> map) throws org.json.JSONException, java.lang.IllegalArgumentException {
        return execute(this.root, map);
    }

    private double toNumber(java.lang.Object obj) {
        if (obj instanceof java.lang.String) {
            return java.lang.Double.parseDouble((java.lang.String) obj);
        }
        if (obj instanceof java.lang.Boolean) {
            return ((java.lang.Boolean) obj).booleanValue() ? 1.0d : 0.0d;
        }
        return ((java.lang.Double) obj).doubleValue();
    }

    private boolean toBoolean(java.lang.Object obj) {
        if (obj instanceof java.lang.String) {
            return "".equals(obj);
        }
        if (obj instanceof java.lang.Double) {
            return ((java.lang.Double) obj).doubleValue() != 0.0d;
        }
        return ((java.lang.Boolean) obj).booleanValue();
    }

    private java.lang.String toString(java.lang.Object obj) {
        if (obj instanceof java.lang.Boolean) {
            return ((java.lang.Boolean) obj).booleanValue() ? io.dcloud.common.constant.AbsoluteConst.TRUE : io.dcloud.common.constant.AbsoluteConst.FALSE;
        }
        if (obj instanceof java.lang.Double) {
            return java.lang.Double.toString(((java.lang.Double) obj).doubleValue());
        }
        return (java.lang.String) obj;
    }

    private boolean equal(java.lang.Object obj, java.lang.Object obj2) {
        if ((obj instanceof com.alibaba.android.bindingx.core.internal.JSObjectInterface) && (obj2 instanceof com.alibaba.android.bindingx.core.internal.JSObjectInterface)) {
            return obj == obj2;
        }
        if ((obj instanceof java.lang.String) && (obj2 instanceof java.lang.String)) {
            return obj.equals(obj2);
        }
        if ((obj instanceof java.lang.Boolean) && (obj2 instanceof java.lang.Boolean)) {
            return toBoolean(obj) == toBoolean(obj2);
        }
        return toNumber(obj) == toNumber(obj2);
    }

    private boolean strictlyEqual(java.lang.Object obj, java.lang.Object obj2) {
        if ((obj instanceof com.alibaba.android.bindingx.core.internal.JSObjectInterface) && !(obj2 instanceof com.alibaba.android.bindingx.core.internal.JSObjectInterface)) {
            return false;
        }
        if ((obj instanceof java.lang.Boolean) && !(obj2 instanceof java.lang.Boolean)) {
            return false;
        }
        if (!(obj instanceof java.lang.Double) || (obj2 instanceof java.lang.Double)) {
            return (!(obj instanceof java.lang.String) || (obj2 instanceof java.lang.String)) && obj == obj2;
        }
        return false;
    }

    private java.lang.Object execute(org.json.JSONObject jSONObject, java.util.Map<java.lang.String, java.lang.Object> map) throws org.json.JSONException, java.lang.IllegalArgumentException {
        java.lang.String string = jSONObject.getString("type");
        org.json.JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(com.taobao.weex.ui.component.richtext.node.RichTextNode.CHILDREN);
        string.hashCode();
        switch (string) {
            case "CallExpression":
                com.alibaba.android.bindingx.core.internal.JSFunctionInterface jSFunctionInterface = (com.alibaba.android.bindingx.core.internal.JSFunctionInterface) execute(jSONArrayOptJSONArray.getJSONObject(0), map);
                java.util.ArrayList<java.lang.Object> arrayList = new java.util.ArrayList<>();
                org.json.JSONArray jSONArray = jSONArrayOptJSONArray.getJSONObject(1).getJSONArray(com.taobao.weex.ui.component.richtext.node.RichTextNode.CHILDREN);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(execute(jSONArray.getJSONObject(i), map));
                }
                return jSFunctionInterface.execute(arrayList);
            case "!":
                return java.lang.Boolean.valueOf(!toBoolean(execute(jSONArrayOptJSONArray.getJSONObject(0), map)));
            case "%":
                return java.lang.Double.valueOf(toNumber(execute(jSONArrayOptJSONArray.getJSONObject(0), map)) % toNumber(execute(jSONArrayOptJSONArray.getJSONObject(1), map)));
            case "*":
                return java.lang.Double.valueOf(toNumber(execute(jSONArrayOptJSONArray.getJSONObject(0), map)) * toNumber(execute(jSONArrayOptJSONArray.getJSONObject(1), map)));
            case "+":
                return java.lang.Double.valueOf(toNumber(execute(jSONArrayOptJSONArray.getJSONObject(0), map)) + toNumber(execute(jSONArrayOptJSONArray.getJSONObject(1), map)));
            case "-":
                return java.lang.Double.valueOf(toNumber(execute(jSONArrayOptJSONArray.getJSONObject(0), map)) - toNumber(execute(jSONArrayOptJSONArray.getJSONObject(1), map)));
            case "/":
                return java.lang.Double.valueOf(toNumber(execute(jSONArrayOptJSONArray.getJSONObject(0), map)) / toNumber(execute(jSONArrayOptJSONArray.getJSONObject(1), map)));
            case "<":
                return java.lang.Boolean.valueOf(toNumber(execute(jSONArrayOptJSONArray.getJSONObject(0), map)) < toNumber(execute(jSONArrayOptJSONArray.getJSONObject(1), map)));
            case ">":
                return java.lang.Boolean.valueOf(toNumber(execute(jSONArrayOptJSONArray.getJSONObject(0), map)) > toNumber(execute(jSONArrayOptJSONArray.getJSONObject(1), map)));
            case "?":
                if (((java.lang.Boolean) execute(jSONArrayOptJSONArray.getJSONObject(0), map)).booleanValue()) {
                    return execute(jSONArrayOptJSONArray.getJSONObject(1), map);
                }
                return execute(jSONArrayOptJSONArray.getJSONObject(2), map);
            case "!=":
                return java.lang.Boolean.valueOf(!equal(execute(jSONArrayOptJSONArray.getJSONObject(0), map), execute(jSONArrayOptJSONArray.getJSONObject(1), map)));
            case "&&":
                java.lang.Object objExecute = execute(jSONArrayOptJSONArray.getJSONObject(0), map);
                return !toBoolean(objExecute) ? objExecute : execute(jSONArrayOptJSONArray.getJSONObject(1), map);
            case "**":
                return java.lang.Double.valueOf(java.lang.Math.pow(toNumber(execute(jSONArrayOptJSONArray.getJSONObject(0), map)), toNumber(execute(jSONArrayOptJSONArray.getJSONObject(1), map))));
            case "<=":
                return java.lang.Boolean.valueOf(toNumber(execute(jSONArrayOptJSONArray.getJSONObject(0), map)) <= toNumber(execute(jSONArrayOptJSONArray.getJSONObject(1), map)));
            case "==":
                return java.lang.Boolean.valueOf(equal(execute(jSONArrayOptJSONArray.getJSONObject(0), map), execute(jSONArrayOptJSONArray.getJSONObject(1), map)));
            case ">=":
                return java.lang.Boolean.valueOf(toNumber(execute(jSONArrayOptJSONArray.getJSONObject(0), map)) >= toNumber(execute(jSONArrayOptJSONArray.getJSONObject(1), map)));
            case "||":
                java.lang.Object objExecute2 = execute(jSONArrayOptJSONArray.getJSONObject(0), map);
                return toBoolean(objExecute2) ? objExecute2 : execute(jSONArrayOptJSONArray.getJSONObject(1), map);
            case "!==":
                return java.lang.Boolean.valueOf(!strictlyEqual(execute(jSONArrayOptJSONArray.getJSONObject(0), map), execute(jSONArrayOptJSONArray.getJSONObject(1), map)));
            case "===":
                return java.lang.Boolean.valueOf(strictlyEqual(execute(jSONArrayOptJSONArray.getJSONObject(0), map), execute(jSONArrayOptJSONArray.getJSONObject(1), map)));
            case "NumericLiteral":
                return java.lang.Double.valueOf(jSONObject.getDouble("value"));
            case "Identifier":
                return map.get(jSONObject.getString("value"));
            case "StringLiteral":
                return jSONObject.getString("value");
            case "BooleanLiteral":
                return java.lang.Boolean.valueOf(jSONObject.getBoolean("value"));
            default:
                return null;
        }
    }
}
