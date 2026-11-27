package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public class FloatCodec implements com.alibaba.fastjson.serializer.ObjectSerializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    public static com.alibaba.fastjson.serializer.FloatCodec instance = new com.alibaba.fastjson.serializer.FloatCodec();
    private java.text.NumberFormat decimalFormat;

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    public FloatCodec() {
    }

    public FloatCodec(java.text.DecimalFormat decimalFormat) {
        this.decimalFormat = decimalFormat;
    }

    public FloatCodec(java.lang.String str) {
        this(new java.text.DecimalFormat(str));
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i) throws java.io.IOException {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        float fFloatValue = ((java.lang.Float) obj).floatValue();
        java.text.NumberFormat numberFormat = this.decimalFormat;
        if (numberFormat != null) {
            serializeWriter.write(numberFormat.format(fFloatValue));
        } else {
            serializeWriter.writeFloat(fFloatValue, true);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        try {
            return (T) deserialze(defaultJSONParser);
        } catch (java.lang.Exception e) {
            throw new com.alibaba.fastjson.JSONException("parseLong error, field : " + obj, e);
        }
    }

    public static <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser) {
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 2) {
            java.lang.String strNumberString = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return (T) java.lang.Float.valueOf(java.lang.Float.parseFloat(strNumberString));
        }
        if (jSONLexer.token() == 3) {
            float fFloatValue = jSONLexer.floatValue();
            jSONLexer.nextToken(16);
            return (T) java.lang.Float.valueOf(fFloatValue);
        }
        java.lang.Object obj = defaultJSONParser.parse();
        if (obj == null) {
            return null;
        }
        return (T) com.alibaba.fastjson.util.TypeUtils.castToFloat(obj);
    }
}
