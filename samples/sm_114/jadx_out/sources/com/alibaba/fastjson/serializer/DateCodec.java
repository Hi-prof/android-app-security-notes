package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public class DateCodec extends com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer implements com.alibaba.fastjson.serializer.ObjectSerializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    public static final com.alibaba.fastjson.serializer.DateCodec instance = new com.alibaba.fastjson.serializer.DateCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i) throws java.io.IOException {
        java.util.Date dateCastToDate;
        char[] charArray;
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        java.lang.Class<?> cls = obj.getClass();
        if (cls == java.sql.Date.class && !serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.WriteDateUseDateFormat)) {
            long time = ((java.sql.Date) obj).getTime();
            if ((time + ((long) jSONSerializer.timeZone.getOffset(time))) % 86400000 == 0 && !com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(serializeWriter.features, i, com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName)) {
                serializeWriter.writeString(obj.toString());
                return;
            }
        }
        if (cls == java.sql.Time.class) {
            long time2 = ((java.sql.Time) obj).getTime();
            if ("unixtime".equals(jSONSerializer.getDateFormatPattern())) {
                serializeWriter.writeLong(time2 / 1000);
                return;
            } else if ("millis".equals(jSONSerializer.getDateFormatPattern())) {
                serializeWriter.writeLong(time2);
                return;
            } else if (time2 < 86400000) {
                serializeWriter.writeString(obj.toString());
                return;
            }
        }
        int nanos = cls == java.sql.Timestamp.class ? ((java.sql.Timestamp) obj).getNanos() : 0;
        if (obj instanceof java.util.Date) {
            dateCastToDate = (java.util.Date) obj;
        } else {
            dateCastToDate = com.alibaba.fastjson.util.TypeUtils.castToDate(obj);
        }
        if ("unixtime".equals(jSONSerializer.getDateFormatPattern())) {
            serializeWriter.writeLong(dateCastToDate.getTime() / 1000);
            return;
        }
        if ("millis".equals(jSONSerializer.getDateFormatPattern())) {
            serializeWriter.writeLong(dateCastToDate.getTime());
            return;
        }
        if (serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.WriteDateUseDateFormat)) {
            java.text.DateFormat dateFormat = jSONSerializer.getDateFormat();
            if (dateFormat == null) {
                java.lang.String fastJsonConfigDateFormatPattern = jSONSerializer.getFastJsonConfigDateFormatPattern();
                if (fastJsonConfigDateFormatPattern == null) {
                    fastJsonConfigDateFormatPattern = com.alibaba.fastjson.JSON.DEFFAULT_DATE_FORMAT;
                }
                java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(fastJsonConfigDateFormatPattern, jSONSerializer.locale);
                simpleDateFormat.setTimeZone(jSONSerializer.timeZone);
                dateFormat = simpleDateFormat;
            }
            serializeWriter.writeString(dateFormat.format(dateCastToDate));
            return;
        }
        if (serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName) && cls != type) {
            if (cls == java.util.Date.class) {
                serializeWriter.write("new Date(");
                serializeWriter.writeLong(((java.util.Date) obj).getTime());
                serializeWriter.write(41);
                return;
            } else {
                serializeWriter.write(123);
                serializeWriter.writeFieldName(com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY);
                jSONSerializer.write(cls.getName());
                serializeWriter.writeFieldValue(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR, "val", ((java.util.Date) obj).getTime());
                serializeWriter.write(125);
                return;
            }
        }
        long time3 = dateCastToDate.getTime();
        if (serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.UseISO8601DateFormat)) {
            int i2 = serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes) ? 39 : 34;
            serializeWriter.write(i2);
            java.util.Calendar calendar = java.util.Calendar.getInstance(jSONSerializer.timeZone, jSONSerializer.locale);
            calendar.setTimeInMillis(time3);
            int i3 = calendar.get(1);
            int i4 = calendar.get(2) + 1;
            int i5 = calendar.get(5);
            int i6 = calendar.get(11);
            int i7 = calendar.get(12);
            int i8 = calendar.get(13);
            int i9 = calendar.get(14);
            if (nanos > 0) {
                charArray = "0000-00-00 00:00:00.000000000".toCharArray();
                com.alibaba.fastjson.util.IOUtils.getChars(nanos, 29, charArray);
                com.alibaba.fastjson.util.IOUtils.getChars(i8, 19, charArray);
                com.alibaba.fastjson.util.IOUtils.getChars(i7, 16, charArray);
                com.alibaba.fastjson.util.IOUtils.getChars(i6, 13, charArray);
                com.alibaba.fastjson.util.IOUtils.getChars(i5, 10, charArray);
                com.alibaba.fastjson.util.IOUtils.getChars(i4, 7, charArray);
                com.alibaba.fastjson.util.IOUtils.getChars(i3, 4, charArray);
            } else if (i9 != 0) {
                char[] charArray2 = "0000-00-00T00:00:00.000".toCharArray();
                com.alibaba.fastjson.util.IOUtils.getChars(i9, 23, charArray2);
                com.alibaba.fastjson.util.IOUtils.getChars(i8, 19, charArray2);
                com.alibaba.fastjson.util.IOUtils.getChars(i7, 16, charArray2);
                com.alibaba.fastjson.util.IOUtils.getChars(i6, 13, charArray2);
                com.alibaba.fastjson.util.IOUtils.getChars(i5, 10, charArray2);
                com.alibaba.fastjson.util.IOUtils.getChars(i4, 7, charArray2);
                com.alibaba.fastjson.util.IOUtils.getChars(i3, 4, charArray2);
                charArray = charArray2;
            } else if (i8 == 0 && i7 == 0 && i6 == 0) {
                char[] charArray3 = "0000-00-00".toCharArray();
                com.alibaba.fastjson.util.IOUtils.getChars(i5, 10, charArray3);
                com.alibaba.fastjson.util.IOUtils.getChars(i4, 7, charArray3);
                com.alibaba.fastjson.util.IOUtils.getChars(i3, 4, charArray3);
                charArray = charArray3;
            } else {
                charArray = "0000-00-00T00:00:00".toCharArray();
                com.alibaba.fastjson.util.IOUtils.getChars(i8, 19, charArray);
                com.alibaba.fastjson.util.IOUtils.getChars(i7, 16, charArray);
                com.alibaba.fastjson.util.IOUtils.getChars(i6, 13, charArray);
                com.alibaba.fastjson.util.IOUtils.getChars(i5, 10, charArray);
                com.alibaba.fastjson.util.IOUtils.getChars(i4, 7, charArray);
                com.alibaba.fastjson.util.IOUtils.getChars(i3, 4, charArray);
            }
            if (nanos > 0) {
                int i10 = 0;
                while (i10 < 9 && charArray[(charArray.length - i10) - 1] == '0') {
                    i10++;
                }
                serializeWriter.write(charArray, 0, charArray.length - i10);
                serializeWriter.write(i2);
                return;
            }
            serializeWriter.write(charArray);
            float offset = calendar.getTimeZone().getOffset(calendar.getTimeInMillis()) / 3600000.0f;
            int i11 = (int) offset;
            if (i11 == 0.0d) {
                serializeWriter.write(90);
            } else {
                if (i11 > 9) {
                    serializeWriter.write(43);
                    serializeWriter.writeInt(i11);
                } else if (i11 > 0) {
                    serializeWriter.write(43);
                    serializeWriter.write(48);
                    serializeWriter.writeInt(i11);
                } else if (i11 < -9) {
                    serializeWriter.write(45);
                    serializeWriter.writeInt(-i11);
                } else if (i11 < 0) {
                    serializeWriter.write(45);
                    serializeWriter.write(48);
                    serializeWriter.writeInt(-i11);
                }
                serializeWriter.write(58);
                serializeWriter.append((java.lang.CharSequence) java.lang.String.format("%02d", java.lang.Integer.valueOf((int) (java.lang.Math.abs(offset - i11) * 60.0f))));
            }
            serializeWriter.write(i2);
            return;
        }
        serializeWriter.writeLong(time3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v19, types: [T, java.util.Calendar] */
    /* JADX WARN: Type inference failed for: r5v25, types: [T, java.util.Calendar] */
    @Override // com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer
    public <T> T cast(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj, java.lang.Object obj2) {
        if (obj2 == 0) {
            return null;
        }
        if (obj2 instanceof java.util.Date) {
            return obj2;
        }
        if (obj2 instanceof java.math.BigDecimal) {
            return (T) new java.util.Date(com.alibaba.fastjson.util.TypeUtils.longValue((java.math.BigDecimal) obj2));
        }
        if (obj2 instanceof java.lang.Number) {
            return (T) new java.util.Date(((java.lang.Number) obj2).longValue());
        }
        if (obj2 instanceof java.lang.String) {
            java.lang.String strSubstring = (java.lang.String) obj2;
            if (strSubstring.length() == 0) {
                return null;
            }
            if (strSubstring.length() == 23 && strSubstring.endsWith(" 000")) {
                strSubstring = strSubstring.substring(0, 19);
            }
            com.alibaba.fastjson.parser.JSONScanner jSONScanner = new com.alibaba.fastjson.parser.JSONScanner(strSubstring);
            try {
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    ?? r5 = (T) jSONScanner.getCalendar();
                    if (type != java.util.Calendar.class) {
                        T t = (T) r5.getTime();
                        jSONScanner.close();
                        return t;
                    }
                    jSONScanner.close();
                    return r5;
                }
                jSONScanner.close();
                java.lang.String dateFomartPattern = defaultJSONParser.getDateFomartPattern();
                if (strSubstring.length() == dateFomartPattern.length() || ((strSubstring.length() == 22 && dateFomartPattern.equals("yyyyMMddHHmmssSSSZ")) || (strSubstring.indexOf(84) != -1 && dateFomartPattern.contains("'T'") && strSubstring.length() + 2 == dateFomartPattern.length()))) {
                    try {
                        return (T) defaultJSONParser.getDateFormat().parse(strSubstring);
                    } catch (java.text.ParseException unused) {
                    }
                }
                if (strSubstring.startsWith("/Date(") && strSubstring.endsWith(")/")) {
                    strSubstring = strSubstring.substring(6, strSubstring.length() - 2);
                }
                if ("0000-00-00".equals(strSubstring) || "0000-00-00T00:00:00".equalsIgnoreCase(strSubstring) || "0001-01-01T00:00:00+08:00".equalsIgnoreCase(strSubstring)) {
                    return null;
                }
                int iLastIndexOf = strSubstring.lastIndexOf(124);
                if (iLastIndexOf > 20) {
                    java.util.TimeZone timeZone = java.util.TimeZone.getTimeZone(strSubstring.substring(iLastIndexOf + 1));
                    if (!"GMT".equals(timeZone.getID())) {
                        com.alibaba.fastjson.parser.JSONScanner jSONScanner2 = new com.alibaba.fastjson.parser.JSONScanner(strSubstring.substring(0, iLastIndexOf));
                        try {
                            if (jSONScanner2.scanISO8601DateIfMatch(false)) {
                                ?? r6 = (T) jSONScanner2.getCalendar();
                                r6.setTimeZone(timeZone);
                                return type == java.util.Calendar.class ? r6 : (T) r6.getTime();
                            }
                        } finally {
                            jSONScanner2.close();
                        }
                    }
                }
                return (T) new java.util.Date(java.lang.Long.parseLong(strSubstring));
            } catch (java.lang.Throwable th) {
                jSONScanner.close();
                throw th;
            }
        }
        throw new com.alibaba.fastjson.JSONException("parse error");
    }
}
