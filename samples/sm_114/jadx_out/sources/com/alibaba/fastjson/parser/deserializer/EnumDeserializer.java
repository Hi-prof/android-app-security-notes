package com.alibaba.fastjson.parser.deserializer;

/* JADX INFO: loaded from: classes.dex */
public class EnumDeserializer implements com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    protected final java.lang.Class<?> enumClass;
    protected long[] enumNameHashCodes;
    protected final java.lang.Enum[] enums;
    protected final java.lang.Enum[] ordinalEnums;

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    public EnumDeserializer(java.lang.Class<?> cls) {
        com.alibaba.fastjson.annotation.JSONField jSONField;
        this.enumClass = cls;
        this.ordinalEnums = (java.lang.Enum[]) cls.getEnumConstants();
        java.util.HashMap map = new java.util.HashMap();
        int i = 0;
        while (true) {
            java.lang.Enum[] enumArr = this.ordinalEnums;
            if (i >= enumArr.length) {
                break;
            }
            java.lang.Enum r5 = enumArr[i];
            java.lang.String strName = r5.name();
            com.alibaba.fastjson.annotation.JSONField jSONField2 = null;
            try {
                jSONField = (com.alibaba.fastjson.annotation.JSONField) com.alibaba.fastjson.util.TypeUtils.getAnnotation(cls.getField(strName), com.alibaba.fastjson.annotation.JSONField.class);
                if (jSONField != null) {
                    try {
                        java.lang.String strName2 = jSONField.name();
                        if (strName2 != null && strName2.length() > 0) {
                            strName = strName2;
                        }
                    } catch (java.lang.Exception unused) {
                        jSONField2 = jSONField;
                        jSONField = jSONField2;
                    }
                }
            } catch (java.lang.Exception unused2) {
            }
            int i2 = 0;
            long j = com.alibaba.fastjson.util.TypeUtils.fnv1a_64_magic_hashcode;
            long j2 = com.alibaba.fastjson.util.TypeUtils.fnv1a_64_magic_hashcode;
            while (i2 < strName.length()) {
                int iCharAt = strName.charAt(i2);
                int i3 = i;
                long j3 = ((long) iCharAt) ^ j;
                if (iCharAt >= 65 && iCharAt <= 90) {
                    iCharAt += 32;
                }
                long j4 = j3 * com.alibaba.fastjson.util.TypeUtils.fnv1a_64_magic_prime;
                j2 = (((long) iCharAt) ^ j2) * com.alibaba.fastjson.util.TypeUtils.fnv1a_64_magic_prime;
                i2++;
                j = j4;
                i = i3;
            }
            int i4 = i;
            map.put(java.lang.Long.valueOf(j), r5);
            if (j != j2) {
                map.put(java.lang.Long.valueOf(j2), r5);
            }
            if (jSONField != null) {
                for (java.lang.String str : jSONField.alternateNames()) {
                    long jCharAt = com.alibaba.fastjson.util.TypeUtils.fnv1a_64_magic_hashcode;
                    for (int i5 = 0; i5 < str.length(); i5++) {
                        jCharAt = (jCharAt ^ ((long) str.charAt(i5))) * com.alibaba.fastjson.util.TypeUtils.fnv1a_64_magic_prime;
                    }
                    if (jCharAt != j && jCharAt != j2) {
                        map.put(java.lang.Long.valueOf(jCharAt), r5);
                    }
                }
            }
            i = i4 + 1;
        }
        this.enumNameHashCodes = new long[map.size()];
        java.util.Iterator it = map.keySet().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            this.enumNameHashCodes[i6] = ((java.lang.Long) it.next()).longValue();
            i6++;
        }
        java.util.Arrays.sort(this.enumNameHashCodes);
        this.enums = new java.lang.Enum[this.enumNameHashCodes.length];
        int i7 = 0;
        while (true) {
            long[] jArr = this.enumNameHashCodes;
            if (i7 >= jArr.length) {
                return;
            }
            this.enums[i7] = (java.lang.Enum) map.get(java.lang.Long.valueOf(jArr[i7]));
            i7++;
        }
    }

    public java.lang.Enum getEnumByHashCode(long j) {
        int iBinarySearch;
        if (this.enums != null && (iBinarySearch = java.util.Arrays.binarySearch(this.enumNameHashCodes, j)) >= 0) {
            return this.enums[iBinarySearch];
        }
        return null;
    }

    public java.lang.Enum<?> valueOf(int i) {
        return this.ordinalEnums[i];
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        try {
            com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i = jSONLexer.token();
            if (i == 2) {
                int iIntValue = jSONLexer.intValue();
                jSONLexer.nextToken(16);
                if (iIntValue >= 0) {
                    java.lang.Object[] objArr = this.ordinalEnums;
                    if (iIntValue < objArr.length) {
                        return (T) objArr[iIntValue];
                    }
                }
                throw new com.alibaba.fastjson.JSONException("parse enum " + this.enumClass.getName() + " error, value : " + iIntValue);
            }
            if (i != 4) {
                if (i == 8) {
                    jSONLexer.nextToken(16);
                    return null;
                }
                throw new com.alibaba.fastjson.JSONException("parse enum " + this.enumClass.getName() + " error, value : " + defaultJSONParser.parse());
            }
            java.lang.String strStringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            if (strStringVal.length() == 0) {
                return null;
            }
            long j = com.alibaba.fastjson.util.TypeUtils.fnv1a_64_magic_hashcode;
            long j2 = -3750763034362895579L;
            for (int i2 = 0; i2 < strStringVal.length(); i2++) {
                int iCharAt = strStringVal.charAt(i2);
                long j3 = j ^ ((long) iCharAt);
                if (iCharAt >= 65 && iCharAt <= 90) {
                    iCharAt += 32;
                }
                j = j3 * com.alibaba.fastjson.util.TypeUtils.fnv1a_64_magic_prime;
                j2 = (j2 ^ ((long) iCharAt)) * com.alibaba.fastjson.util.TypeUtils.fnv1a_64_magic_prime;
            }
            T t = (T) getEnumByHashCode(j);
            if (t == null && j2 != j) {
                t = (T) getEnumByHashCode(j2);
            }
            if (t == null && jSONLexer.isEnabled(com.alibaba.fastjson.parser.Feature.ErrorOnEnumNotMatch)) {
                throw new com.alibaba.fastjson.JSONException("not match enum value, " + this.enumClass.getName() + " : " + strStringVal);
            }
            return t;
        } catch (com.alibaba.fastjson.JSONException e) {
            throw e;
        } catch (java.lang.Exception e2) {
            throw new com.alibaba.fastjson.JSONException(e2.getMessage(), e2);
        }
    }
}
