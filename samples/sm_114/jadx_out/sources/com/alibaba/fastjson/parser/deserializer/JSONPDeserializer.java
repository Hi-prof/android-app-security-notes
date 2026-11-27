package com.alibaba.fastjson.parser.deserializer;

/* JADX INFO: loaded from: classes.dex */
public class JSONPDeserializer implements com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    public static final com.alibaba.fastjson.parser.deserializer.JSONPDeserializer instance = new com.alibaba.fastjson.parser.deserializer.JSONPDeserializer();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 0;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.alibaba.fastjson.JSONPObject] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        int i;
        com.alibaba.fastjson.parser.JSONLexerBase jSONLexerBase = (com.alibaba.fastjson.parser.JSONLexerBase) defaultJSONParser.getLexer();
        java.lang.String strScanSymbolUnQuoted = jSONLexerBase.scanSymbolUnQuoted(defaultJSONParser.getSymbolTable());
        jSONLexerBase.nextToken();
        int i2 = jSONLexerBase.token();
        if (i2 == 25) {
            java.lang.String strScanSymbolUnQuoted2 = jSONLexerBase.scanSymbolUnQuoted(defaultJSONParser.getSymbolTable());
            strScanSymbolUnQuoted = (strScanSymbolUnQuoted + com.taobao.weex.el.parse.Operators.DOT_STR) + strScanSymbolUnQuoted2;
            jSONLexerBase.nextToken();
            i2 = jSONLexerBase.token();
        }
        ?? r1 = (T) new com.alibaba.fastjson.JSONPObject(strScanSymbolUnQuoted);
        if (i2 != 10) {
            throw new com.alibaba.fastjson.JSONException("illegal jsonp : " + jSONLexerBase.info());
        }
        jSONLexerBase.nextToken();
        while (true) {
            r1.addParameter(defaultJSONParser.parse());
            i = jSONLexerBase.token();
            if (i != 16) {
                break;
            }
            jSONLexerBase.nextToken();
        }
        if (i != 11) {
            throw new com.alibaba.fastjson.JSONException("illegal jsonp : " + jSONLexerBase.info());
        }
        jSONLexerBase.nextToken();
        if (jSONLexerBase.token() == 24) {
            jSONLexerBase.nextToken();
        }
        return r1;
    }
}
