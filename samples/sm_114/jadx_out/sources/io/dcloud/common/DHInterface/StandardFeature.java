package io.dcloud.common.DHInterface;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes.dex */
public class StandardFeature extends io.dcloud.common.DHInterface.BaseFeature implements io.dcloud.common.DHInterface.IReflectAble {
    private java.util.HashMap<java.lang.String, java.lang.reflect.Method> mInnerClassMethod = null;

    private void arrangeInnerMethod() {
        this.mInnerClassMethod = new java.util.HashMap<>(1);
        for (java.lang.reflect.Method method : getClass().getDeclaredMethods()) {
            int modifiers = method.getModifiers();
            if (!java.lang.reflect.Modifier.isStatic(modifiers) && java.lang.reflect.Modifier.isPublic(modifiers) && isStandardFeatureMethod(method.getParameterTypes())) {
                this.mInnerClassMethod.put(method.getName(), method);
            }
        }
    }

    private java.lang.String executeAction(java.lang.String str, io.dcloud.common.DHInterface.IWebview iWebview, org.json.JSONArray jSONArray) {
        java.lang.reflect.Method method = this.mInnerClassMethod.get(str);
        if (method == null) {
            return io.dcloud.common.util.JSUtil.wrapJsVar("not found the " + str + " function");
        }
        try {
            java.lang.Object objInvoke = method.invoke(this, iWebview, jSONArray);
            if (objInvoke != null) {
                return objInvoke.toString();
            }
            return null;
        } catch (java.lang.IllegalAccessException e) {
            java.lang.String strWrapJsVar = io.dcloud.common.util.JSUtil.wrapJsVar(e.getMessage());
            e.printStackTrace();
            return strWrapJsVar;
        } catch (java.lang.IllegalArgumentException e2) {
            java.lang.String strWrapJsVar2 = io.dcloud.common.util.JSUtil.wrapJsVar(e2.getMessage());
            e2.printStackTrace();
            return strWrapJsVar2;
        } catch (java.lang.reflect.InvocationTargetException e3) {
            java.lang.String strWrapJsVar3 = io.dcloud.common.util.JSUtil.wrapJsVar(e3.getMessage());
            e3.printStackTrace();
            return strWrapJsVar3;
        }
    }

    private boolean isStandardFeatureMethod(java.lang.Class[] clsArr) {
        if (clsArr != null) {
            try {
                if (clsArr.length == 2 && clsArr[0].equals(io.dcloud.common.DHInterface.IWebview.class) && clsArr[1].equals(org.json.JSONArray.class)) {
                    return true;
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // io.dcloud.common.DHInterface.BaseFeature
    public final java.lang.String execute(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONArray jSONArray) {
        return executeAction(str, iWebview, jSONArray);
    }

    @Override // io.dcloud.common.DHInterface.BaseFeature, io.dcloud.common.DHInterface.IFeature
    public void init(io.dcloud.common.DHInterface.AbsMgr absMgr, java.lang.String str) {
        super.init(absMgr, str);
        arrangeInnerMethod();
    }
}
