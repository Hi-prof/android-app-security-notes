package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public class CharArrayCodec implements com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        return (T) deserialze(defaultJSONParser);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser) {
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 4) {
            java.lang.String strStringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            return (T) strStringVal.toCharArray();
        }
        if (jSONLexer.token() == 2) {
            java.lang.Number numberIntegerValue = jSONLexer.integerValue();
            jSONLexer.nextToken(16);
            return (T) numberIntegerValue.toString().toCharArray();
        }
        java.lang.Object obj = defaultJSONParser.parse();
        if (obj instanceof java.lang.String) {
            return (T) ((java.lang.String) obj).toCharArray();
        }
        if (!(obj instanceof java.util.Collection)) {
            if (obj == null) {
                return null;
            }
            return (T) com.alibaba.fastjson.JSON.toJSONString(obj).toCharArray();
        }
        java.util.Collection collection = (java.util.Collection) obj;
        for (java.lang.Object obj2 : collection) {
            if ((obj2 instanceof java.lang.String) && ((java.lang.String) obj2).length() != 1) {
                throw new com.alibaba.fastjson.JSONException("can not cast to char[]");
            }
        }
        char[] cArr = new char[collection.size()];
        java.util.Iterator it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            cArr[i] = ((java.lang.String) it.next()).charAt(0);
            i++;
        }
        return cArr;
    }
}
