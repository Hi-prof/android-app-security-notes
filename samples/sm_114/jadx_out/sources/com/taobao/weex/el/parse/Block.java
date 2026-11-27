package com.taobao.weex.el.parse;

/* JADX INFO: loaded from: classes.dex */
class Block extends com.taobao.weex.el.parse.Token {
    private java.util.List<com.taobao.weex.el.parse.Token> tokens;

    public Block(java.util.List<com.taobao.weex.el.parse.Token> list, int i) {
        super("", i);
        this.tokens = list;
    }

    @Override // com.taobao.weex.el.parse.Token
    public java.lang.Object execute(java.lang.Object obj) {
        if (getType() == 7) {
            java.util.List<com.taobao.weex.el.parse.Token> list = this.tokens;
            if (list == null || list.size() == 0) {
                return new com.alibaba.fastjson.JSONArray(4);
            }
            com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray(this.tokens.size());
            for (int i = 0; i < this.tokens.size(); i++) {
                com.taobao.weex.el.parse.Token token = this.tokens.get(i);
                if (token == null) {
                    jSONArray.add(null);
                } else {
                    jSONArray.add(token.execute(obj));
                }
            }
            return jSONArray;
        }
        java.util.List<com.taobao.weex.el.parse.Token> list2 = this.tokens;
        if (list2 == null || list2.size() == 0) {
            return null;
        }
        return this.tokens.get(0).execute(obj);
    }

    @Override // com.taobao.weex.el.parse.Token
    public java.lang.String toString() {
        if (getType() == 7) {
            return "" + this.tokens + "";
        }
        java.util.List<com.taobao.weex.el.parse.Token> list = this.tokens;
        if (list != null && list.size() == 1) {
            return com.taobao.weex.el.parse.Operators.BLOCK_START_STR + this.tokens.get(0) + com.taobao.weex.el.parse.Operators.BLOCK_END;
        }
        return com.taobao.weex.el.parse.Operators.BLOCK_START_STR + this.tokens + com.taobao.weex.el.parse.Operators.BLOCK_END;
    }
}
