package com.alibaba.fastjson.parser.deserializer;

/* JADX INFO: loaded from: classes.dex */
public class NumberDeserializer implements com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    public static final com.alibaba.fastjson.parser.deserializer.NumberDeserializer instance = new com.alibaba.fastjson.parser.deserializer.NumberDeserializer();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    /* JADX WARN: Type inference failed for: r5v30, types: [T, java.math.BigDecimal] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 2) {
            if (type == java.lang.Double.TYPE || type == java.lang.Double.class) {
                java.lang.String strNumberString = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) java.lang.Double.valueOf(java.lang.Double.parseDouble(strNumberString));
            }
            long jLongValue = jSONLexer.longValue();
            jSONLexer.nextToken(16);
            if (type == java.lang.Short.TYPE || type == java.lang.Short.class) {
                if (jLongValue > 32767 || jLongValue < -32768) {
                    throw new com.alibaba.fastjson.JSONException("short overflow : " + jLongValue);
                }
                return (T) java.lang.Short.valueOf((short) jLongValue);
            }
            if (type != java.lang.Byte.TYPE && type != java.lang.Byte.class) {
                if (jLongValue >= -2147483648L && jLongValue <= 2147483647L) {
                    return (T) java.lang.Integer.valueOf((int) jLongValue);
                }
                return (T) java.lang.Long.valueOf(jLongValue);
            }
            if (jLongValue > 127 || jLongValue < -128) {
                throw new com.alibaba.fastjson.JSONException("short overflow : " + jLongValue);
            }
            return (T) java.lang.Byte.valueOf((byte) jLongValue);
        }
        if (jSONLexer.token() == 3) {
            if (type == java.lang.Double.TYPE || type == java.lang.Double.class) {
                java.lang.String strNumberString2 = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) java.lang.Double.valueOf(java.lang.Double.parseDouble(strNumberString2));
            }
            if (type == java.lang.Short.TYPE || type == java.lang.Short.class) {
                java.math.BigDecimal bigDecimalDecimalValue = jSONLexer.decimalValue();
                jSONLexer.nextToken(16);
                return (T) java.lang.Short.valueOf(com.alibaba.fastjson.util.TypeUtils.shortValue(bigDecimalDecimalValue));
            }
            if (type == java.lang.Byte.TYPE || type == java.lang.Byte.class) {
                java.math.BigDecimal bigDecimalDecimalValue2 = jSONLexer.decimalValue();
                jSONLexer.nextToken(16);
                return (T) java.lang.Byte.valueOf(com.alibaba.fastjson.util.TypeUtils.byteValue(bigDecimalDecimalValue2));
            }
            ?? r5 = (T) jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            return jSONLexer.isEnabled(com.alibaba.fastjson.parser.Feature.UseBigDecimal) ? r5 : (T) java.lang.Double.valueOf(r5.doubleValue());
        }
        if (jSONLexer.token() == 18 && "NaN".equals(jSONLexer.stringVal())) {
            jSONLexer.nextToken();
            if (type == java.lang.Double.class) {
                return (T) java.lang.Double.valueOf(Double.NaN);
            }
            if (type == java.lang.Float.class) {
                return (T) java.lang.Float.valueOf(Float.NaN);
            }
            return null;
        }
        java.lang.Object obj2 = defaultJSONParser.parse();
        if (obj2 == null) {
            return null;
        }
        if (type == java.lang.Double.TYPE || type == java.lang.Double.class) {
            try {
                return (T) com.alibaba.fastjson.util.TypeUtils.castToDouble(obj2);
            } catch (java.lang.Exception e) {
                throw new com.alibaba.fastjson.JSONException("parseDouble error, field : " + obj, e);
            }
        }
        if (type == java.lang.Short.TYPE || type == java.lang.Short.class) {
            try {
                return (T) com.alibaba.fastjson.util.TypeUtils.castToShort(obj2);
            } catch (java.lang.Exception e2) {
                throw new com.alibaba.fastjson.JSONException("parseShort error, field : " + obj, e2);
            }
        }
        if (type == java.lang.Byte.TYPE || type == java.lang.Byte.class) {
            try {
                return (T) com.alibaba.fastjson.util.TypeUtils.castToByte(obj2);
            } catch (java.lang.Exception e3) {
                throw new com.alibaba.fastjson.JSONException("parseByte error, field : " + obj, e3);
            }
        }
        return (T) com.alibaba.fastjson.util.TypeUtils.castToBigDecimal(obj2);
    }
}
