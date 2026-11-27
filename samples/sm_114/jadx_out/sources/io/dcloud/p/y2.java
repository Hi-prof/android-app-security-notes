package io.dcloud.p;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class y2 implements java.lang.reflect.InvocationHandler {
    java.lang.String a = null;
    java.lang.Object b = null;
    java.lang.Class c;
    io.dcloud.common.DHInterface.IWebview d;
    java.lang.String e;
    java.util.ArrayList f;

    public y2(io.dcloud.common.DHInterface.IWebview iWebview, java.lang.String str, org.json.JSONArray jSONArray, java.lang.String str2) {
        this.c = null;
        this.f = null;
        try {
            this.d = iWebview;
            this.e = str2;
            this.f = new java.util.ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.f.add(io.dcloud.common.util.JSONUtil.getString(jSONArray, i));
            }
            this.c = java.lang.Class.forName(str);
        } catch (java.lang.ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.lang.IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }

    public java.lang.Object a(org.json.JSONArray jSONArray) {
        java.lang.Object objNewProxyInstance = java.lang.reflect.Proxy.newProxyInstance(this.c.getClassLoader(), new java.lang.Class[]{this.c}, this);
        this.b = objNewProxyInstance;
        return objNewProxyInstance;
    }

    @Override // java.lang.reflect.InvocationHandler
    public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) throws java.lang.Throwable {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(com.taobao.weex.el.parse.Operators.ARRAY_START_STR);
        java.lang.String name = method.getName();
        if (this.f.contains(name)) {
            if (objArr != null) {
                int length = objArr.length;
                for (int i = 0; i < length; i++) {
                    java.lang.Object obj2 = objArr[i];
                    if (obj2 == null) {
                        stringBuffer.append(com.taobao.weex.common.Constants.Name.UNDEFINED);
                    } else {
                        stringBuffer.append(io.dcloud.p.x2.b(this.d, obj2));
                    }
                    if (i != length - 1) {
                        stringBuffer.append(",");
                    }
                }
            }
            stringBuffer.append(com.taobao.weex.el.parse.Operators.ARRAY_END_STR);
            io.dcloud.common.util.Deprecated_JSUtil.execCallback(this.d, this.e, io.dcloud.common.util.StringUtil.format("{method:'%s',arguments:%s}", method.getName(), stringBuffer.toString()), io.dcloud.common.util.JSUtil.OK, true, true);
            return null;
        }
        if ("hashCode".equals(name)) {
            return java.lang.Integer.valueOf(hashCode());
        }
        if ("equals".equals(name)) {
            return java.lang.Boolean.valueOf(equals(objArr));
        }
        if ("getClass".equals(name)) {
            return this.c;
        }
        if ("finalize".equals(name)) {
            finalize();
        } else if ("notify".equals(name)) {
            notify();
        } else if ("notifyAll".equals(name)) {
            notifyAll();
        } else {
            if ("toString".equals(name)) {
                return this.a + this.c.toString();
            }
            if (!"wait".equals(name)) {
                try {
                    return method.invoke(this.b, objArr);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            } else if (objArr.length == 0) {
                wait();
            } else if (objArr.length == 1) {
                wait(java.lang.Long.parseLong(java.lang.String.valueOf(objArr[0])));
            } else if (objArr.length == 2) {
                wait(java.lang.Long.parseLong(java.lang.String.valueOf(objArr[0])), java.lang.Integer.parseInt(java.lang.String.valueOf(objArr[0])));
            }
        }
        return null;
    }
}
