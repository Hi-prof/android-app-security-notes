package com.taobao.weex.el.parse;

/* JADX INFO: loaded from: classes.dex */
class Operator extends com.taobao.weex.el.parse.Token {
    public com.taobao.weex.el.parse.Token first;
    public com.taobao.weex.el.parse.Token second;
    public com.taobao.weex.el.parse.Token self;

    public Operator(java.lang.String str, int i) {
        super(str, i);
    }

    @Override // com.taobao.weex.el.parse.Token
    public java.lang.Object execute(java.lang.Object obj) {
        java.lang.String token = getToken();
        token.hashCode();
        boolean z = false;
        switch (token) {
            case "!":
                return java.lang.Boolean.valueOf(!com.taobao.weex.el.parse.Operators.tokenTrue(this.self, obj));
            case "%":
                return com.taobao.weex.el.parse.Operators.mod(this.first, this.second, obj);
            case "*":
                return com.taobao.weex.el.parse.Operators.mul(this.first, this.second, obj);
            case "+":
                return com.taobao.weex.el.parse.Operators.plus(this.first, this.second, obj);
            case "-":
                return com.taobao.weex.el.parse.Operators.sub(this.first, this.second, obj);
            case ".":
            case "[":
                return com.taobao.weex.el.parse.Operators.dot(this.first, this.second, obj);
            case "/":
                return com.taobao.weex.el.parse.Operators.div(this.first, this.second, obj);
            case "<":
                return java.lang.Boolean.valueOf(com.taobao.weex.el.parse.Operators.tokenNumber(this.first, obj) < com.taobao.weex.el.parse.Operators.tokenNumber(this.second, obj));
            case ">":
                return java.lang.Boolean.valueOf(com.taobao.weex.el.parse.Operators.tokenNumber(this.first, obj) > com.taobao.weex.el.parse.Operators.tokenNumber(this.second, obj));
            case "?":
                return com.taobao.weex.el.parse.Operators.condition(this.self, this.first, this.second, obj);
            case "!=":
            case "!==":
                return java.lang.Boolean.valueOf(!com.taobao.weex.el.parse.Operators.isEquals(this.first, this.second, obj));
            case "&&":
                if (com.taobao.weex.el.parse.Operators.tokenTrue(this.first, obj) && com.taobao.weex.el.parse.Operators.tokenTrue(this.second, obj)) {
                    z = true;
                }
                return java.lang.Boolean.valueOf(z);
            case "<=":
                return java.lang.Boolean.valueOf(com.taobao.weex.el.parse.Operators.tokenNumber(this.first, obj) <= com.taobao.weex.el.parse.Operators.tokenNumber(this.second, obj));
            case "==":
            case "===":
                return java.lang.Boolean.valueOf(com.taobao.weex.el.parse.Operators.isEquals(this.first, this.second, obj));
            case ">=":
                return java.lang.Boolean.valueOf(com.taobao.weex.el.parse.Operators.tokenNumber(this.first, obj) >= com.taobao.weex.el.parse.Operators.tokenNumber(this.second, obj));
            case "||":
                return java.lang.Boolean.valueOf(com.taobao.weex.el.parse.Operators.tokenTrue(this.first, obj) || com.taobao.weex.el.parse.Operators.tokenTrue(this.second, obj));
            default:
                throw new java.lang.IllegalArgumentException(token + " operator is not supported");
        }
    }

    @Override // com.taobao.weex.el.parse.Token
    public java.lang.String toString() {
        if (com.taobao.weex.el.parse.Operators.AND_NOT.equals(getToken())) {
            return "{!" + this.self + com.taobao.weex.el.parse.Operators.BLOCK_END_STR;
        }
        if (this.self == null) {
            return com.taobao.weex.el.parse.Operators.BLOCK_START_STR + this.first + getToken() + this.second + com.taobao.weex.el.parse.Operators.BLOCK_END_STR;
        }
        return com.taobao.weex.el.parse.Operators.BLOCK_START_STR + this.self + getToken() + this.first + ":" + this.second + com.taobao.weex.el.parse.Operators.BLOCK_END_STR;
    }
}
