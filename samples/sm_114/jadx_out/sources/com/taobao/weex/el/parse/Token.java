package com.taobao.weex.el.parse;

/* JADX INFO: loaded from: classes.dex */
public class Token {
    public static final int TYPE_ARRAY = 7;
    public static final int TYPE_BLOCK = 6;
    public static final int TYPE_DOUBLE = 2;
    public static final int TYPE_IDENTIFIER = 0;
    public static final int TYPE_INT = 1;
    public static final int TYPE_KEYWORD = 4;
    public static final int TYPE_OPERATOR = 5;
    public static final int TYPE_STRING = 3;
    private java.lang.String token;
    private int type;

    public Token(java.lang.String str, int i) {
        this.token = str;
        this.type = i;
    }

    public java.lang.Object execute(java.lang.Object obj) {
        int i = this.type;
        if (i == 0) {
            return com.taobao.weex.el.parse.Operators.el(obj, this.token);
        }
        if (i == 3) {
            return this.token;
        }
        if (i == 1) {
            try {
                return java.lang.Integer.valueOf(java.lang.Integer.parseInt(this.token));
            } catch (java.lang.Exception unused) {
                return 0;
            }
        }
        if (i == 2) {
            try {
                return java.lang.Double.valueOf(java.lang.Double.parseDouble(this.token));
            } catch (java.lang.Exception unused2) {
                return 0;
            }
        }
        if (i == 4) {
            return com.taobao.weex.el.parse.Operators.KEYWORDS.get(this.token);
        }
        throw new java.lang.IllegalArgumentException("unhandled token type " + this.type);
    }

    public java.lang.String toString() {
        return com.taobao.weex.el.parse.Operators.BLOCK_START_STR + this.token + "," + this.type + com.taobao.weex.el.parse.Operators.BLOCK_END;
    }

    public java.lang.String getToken() {
        return this.token;
    }

    public int getType() {
        return this.type;
    }
}
