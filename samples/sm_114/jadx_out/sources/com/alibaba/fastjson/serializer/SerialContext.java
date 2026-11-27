package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public class SerialContext {
    public final int features;
    public final java.lang.Object fieldName;
    public final java.lang.Object object;
    public final com.alibaba.fastjson.serializer.SerialContext parent;

    public SerialContext(com.alibaba.fastjson.serializer.SerialContext serialContext, java.lang.Object obj, java.lang.Object obj2, int i, int i2) {
        this.parent = serialContext;
        this.object = obj;
        this.fieldName = obj2;
        this.features = i;
    }

    public java.lang.String toString() {
        if (this.parent == null) {
            return com.taobao.weex.el.parse.Operators.DOLLAR_STR;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        toString(sb);
        return sb.toString();
    }

    protected void toString(java.lang.StringBuilder sb) {
        com.alibaba.fastjson.serializer.SerialContext serialContext = this.parent;
        if (serialContext == null) {
            sb.append('$');
            return;
        }
        serialContext.toString(sb);
        java.lang.Object obj = this.fieldName;
        if (obj == null) {
            sb.append(".null");
            return;
        }
        if (obj instanceof java.lang.Integer) {
            sb.append(com.taobao.weex.el.parse.Operators.ARRAY_START);
            sb.append(((java.lang.Integer) this.fieldName).intValue());
            sb.append(com.taobao.weex.el.parse.Operators.ARRAY_END);
            return;
        }
        sb.append(com.taobao.weex.el.parse.Operators.DOT);
        java.lang.String string = this.fieldName.toString();
        for (int i = 0; i < string.length(); i++) {
            char cCharAt = string.charAt(i);
            if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt < 'a' || cCharAt > 'z') && cCharAt <= 128))) {
                for (int i2 = 0; i2 < string.length(); i2++) {
                    char cCharAt2 = string.charAt(i2);
                    if (cCharAt2 == '\\') {
                        sb.append('\\');
                        sb.append('\\');
                        sb.append('\\');
                    } else {
                        if ((cCharAt2 >= '0' && cCharAt2 <= '9') || ((cCharAt2 >= 'A' && cCharAt2 <= 'Z') || ((cCharAt2 >= 'a' && cCharAt2 <= 'z') || cCharAt2 > 128))) {
                            sb.append(cCharAt2);
                        } else if (cCharAt2 == '\"') {
                            sb.append('\\');
                            sb.append('\\');
                            sb.append('\\');
                        } else {
                            sb.append('\\');
                            sb.append('\\');
                        }
                    }
                    sb.append(cCharAt2);
                }
                return;
            }
        }
        sb.append(string);
    }

    public com.alibaba.fastjson.serializer.SerialContext getParent() {
        return this.parent;
    }

    public java.lang.Object getObject() {
        return this.object;
    }

    public java.lang.Object getFieldName() {
        return this.fieldName;
    }

    public java.lang.String getPath() {
        return toString();
    }
}
