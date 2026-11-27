package com.alibaba.fastjson.parser;

/* JADX INFO: loaded from: classes.dex */
public class ParseContext {
    public final java.lang.Object fieldName;
    public final int level;
    public java.lang.Object object;
    public final com.alibaba.fastjson.parser.ParseContext parent;
    private transient java.lang.String path;
    public java.lang.reflect.Type type;

    public ParseContext(com.alibaba.fastjson.parser.ParseContext parseContext, java.lang.Object obj, java.lang.Object obj2) {
        this.parent = parseContext;
        this.object = obj;
        this.fieldName = obj2;
        this.level = parseContext == null ? 0 : parseContext.level + 1;
    }

    public java.lang.String toString() {
        if (this.path == null) {
            if (this.parent == null) {
                this.path = com.taobao.weex.el.parse.Operators.DOLLAR_STR;
            } else if (this.fieldName instanceof java.lang.Integer) {
                this.path = this.parent.toString() + com.taobao.weex.el.parse.Operators.ARRAY_START_STR + this.fieldName + com.taobao.weex.el.parse.Operators.ARRAY_END_STR;
            } else {
                this.path = this.parent.toString() + com.taobao.weex.el.parse.Operators.DOT_STR + this.fieldName;
            }
        }
        return this.path;
    }
}
