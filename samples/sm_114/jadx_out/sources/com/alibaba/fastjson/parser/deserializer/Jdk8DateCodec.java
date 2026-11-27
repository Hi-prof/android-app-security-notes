package com.alibaba.fastjson.parser.deserializer;

/* JADX INFO: loaded from: classes.dex */
public class Jdk8DateCodec extends com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer implements com.alibaba.fastjson.serializer.ObjectSerializer, com.alibaba.fastjson.serializer.ContextObjectSerializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    private static final java.lang.String formatter_iso8601_pattern_23 = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    private static final java.lang.String formatter_iso8601_pattern_29 = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS";
    public static final com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec instance = new com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec();
    private static final java.lang.String defaultPatttern = "yyyy-MM-dd HH:mm:ss";
    private static final java.time.format.DateTimeFormatter defaultFormatter = java.time.format.DateTimeFormatter.ofPattern(defaultPatttern);
    private static final java.time.format.DateTimeFormatter defaultFormatter_23 = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private static final java.time.format.DateTimeFormatter formatter_dt19_tw = java.time.format.DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static final java.time.format.DateTimeFormatter formatter_dt19_cn = java.time.format.DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm:ss");
    private static final java.time.format.DateTimeFormatter formatter_dt19_cn_1 = java.time.format.DateTimeFormatter.ofPattern("yyyy年M月d日 H时m分s秒");
    private static final java.time.format.DateTimeFormatter formatter_dt19_kr = java.time.format.DateTimeFormatter.ofPattern("yyyy년M월d일 HH:mm:ss");
    private static final java.time.format.DateTimeFormatter formatter_dt19_us = java.time.format.DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    private static final java.time.format.DateTimeFormatter formatter_dt19_eur = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final java.time.format.DateTimeFormatter formatter_dt19_de = java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    private static final java.time.format.DateTimeFormatter formatter_dt19_in = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private static final java.time.format.DateTimeFormatter formatter_d8 = java.time.format.DateTimeFormatter.ofPattern(io.dcloud.common.adapter.util.Logger.TIMESTAMP_YYYY_MM_DD);
    private static final java.time.format.DateTimeFormatter formatter_d10_tw = java.time.format.DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private static final java.time.format.DateTimeFormatter formatter_d10_cn = java.time.format.DateTimeFormatter.ofPattern("yyyy年M月d日");
    private static final java.time.format.DateTimeFormatter formatter_d10_kr = java.time.format.DateTimeFormatter.ofPattern("yyyy년M월d일");
    private static final java.time.format.DateTimeFormatter formatter_d10_us = java.time.format.DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private static final java.time.format.DateTimeFormatter formatter_d10_eur = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final java.time.format.DateTimeFormatter formatter_d10_de = java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final java.time.format.DateTimeFormatter formatter_d10_in = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final java.time.format.DateTimeFormatter ISO_FIXED_FORMAT = java.time.format.DateTimeFormatter.ofPattern(defaultPatttern).withZone(java.time.ZoneId.systemDefault());
    private static final java.lang.String formatter_iso8601_pattern = "yyyy-MM-dd'T'HH:mm:ss";
    private static final java.time.format.DateTimeFormatter formatter_iso8601 = java.time.format.DateTimeFormatter.ofPattern(formatter_iso8601_pattern);

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ContextObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj, java.lang.String str, int i) {
        java.lang.Long l;
        java.time.format.DateTimeFormatter dateTimeFormatterOfPattern;
        com.alibaba.fastjson.parser.JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (jSONLexer.token() == 4) {
            java.lang.String strStringVal = jSONLexer.stringVal();
            jSONLexer.nextToken();
            if (str == null) {
                dateTimeFormatterOfPattern = null;
            } else if (defaultPatttern.equals(str)) {
                dateTimeFormatterOfPattern = defaultFormatter;
            } else {
                dateTimeFormatterOfPattern = java.time.format.DateTimeFormatter.ofPattern(str);
            }
            if ("".equals(strStringVal)) {
                return null;
            }
            if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$9()) {
                if (strStringVal.length() == 10 || strStringVal.length() == 8) {
                    return (T) java.time.LocalDateTime.of(parseLocalDate(strStringVal, str, dateTimeFormatterOfPattern), java.time.LocalTime.MIN);
                }
                return (T) parseDateTime(strStringVal, dateTimeFormatterOfPattern);
            }
            if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$8()) {
                if (strStringVal.length() == 23) {
                    java.time.LocalDateTime localDateTime = java.time.LocalDateTime.parse(strStringVal);
                    return (T) java.time.LocalDate.of(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth());
                }
                return (T) parseLocalDate(strStringVal, str, dateTimeFormatterOfPattern);
            }
            int i2 = 0;
            if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m()) {
                if (strStringVal.length() == 23) {
                    java.time.LocalDateTime localDateTime2 = java.time.LocalDateTime.parse(strStringVal);
                    return (T) java.time.LocalTime.of(localDateTime2.getHour(), localDateTime2.getMinute(), localDateTime2.getSecond(), localDateTime2.getNano());
                }
                while (i2 < strStringVal.length()) {
                    char cCharAt = strStringVal.charAt(i2);
                    if (cCharAt < '0' || cCharAt > '9') {
                        return (T) java.time.LocalTime.parse(strStringVal);
                    }
                    i2++;
                }
                if (strStringVal.length() > 8 && strStringVal.length() < 19) {
                    return (T) java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(java.lang.Long.parseLong(strStringVal)), com.alibaba.fastjson.JSON.defaultTimeZone.toZoneId()).toLocalTime();
                }
                return (T) java.time.LocalTime.parse(strStringVal);
            }
            if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$1()) {
                if (dateTimeFormatterOfPattern == defaultFormatter) {
                    dateTimeFormatterOfPattern = ISO_FIXED_FORMAT;
                }
                if (dateTimeFormatterOfPattern == null && strStringVal.length() <= 19) {
                    com.alibaba.fastjson.parser.JSONScanner jSONScanner = new com.alibaba.fastjson.parser.JSONScanner(strStringVal);
                    java.util.TimeZone timeZone = defaultJSONParser.lexer.getTimeZone();
                    jSONScanner.setTimeZone(timeZone);
                    if (jSONScanner.scanISO8601DateIfMatch(false)) {
                        return (T) java.time.ZonedDateTime.ofInstant(jSONScanner.getCalendar().getTime().toInstant(), timeZone.toZoneId());
                    }
                }
                return (T) parseZonedDateTime(strStringVal, dateTimeFormatterOfPattern);
            }
            if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$2()) {
                return (T) java.time.OffsetDateTime.parse(strStringVal);
            }
            if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$3()) {
                return (T) java.time.OffsetTime.parse(strStringVal);
            }
            if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$4()) {
                return (T) java.time.ZoneId.of(strStringVal);
            }
            if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$5()) {
                return (T) java.time.Period.parse(strStringVal);
            }
            if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$6()) {
                return (T) java.time.Duration.parse(strStringVal);
            }
            if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$7()) {
                while (i2 < strStringVal.length()) {
                    char cCharAt2 = strStringVal.charAt(i2);
                    if (cCharAt2 < '0' || cCharAt2 > '9') {
                        return (T) java.time.Instant.parse(strStringVal);
                    }
                    i2++;
                }
                if (strStringVal.length() > 8 && strStringVal.length() < 19) {
                    return (T) java.time.Instant.ofEpochMilli(java.lang.Long.parseLong(strStringVal));
                }
                return (T) java.time.Instant.parse(strStringVal);
            }
        } else {
            if (jSONLexer.token() == 2) {
                long jLongValue = jSONLexer.longValue();
                jSONLexer.nextToken();
                if ("unixtime".equals(str)) {
                    jLongValue *= 1000;
                } else if ("yyyyMMddHHmmss".equals(str)) {
                    int i3 = (int) (jLongValue / 10000000000L);
                    int i4 = (int) ((jLongValue / 100000000) % 100);
                    int i5 = (int) ((jLongValue / 1000000) % 100);
                    int i6 = (int) ((jLongValue / 10000) % 100);
                    int i7 = (int) ((jLongValue / 100) % 100);
                    int i8 = (int) (jLongValue % 100);
                    if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$9()) {
                        return (T) java.time.LocalDateTime.of(i3, i4, i5, i6, i7, i8);
                    }
                }
                if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$9()) {
                    return (T) java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(jLongValue), com.alibaba.fastjson.JSON.defaultTimeZone.toZoneId());
                }
                if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$8()) {
                    return (T) java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(jLongValue), com.alibaba.fastjson.JSON.defaultTimeZone.toZoneId()).toLocalDate();
                }
                if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m()) {
                    return (T) java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(jLongValue), com.alibaba.fastjson.JSON.defaultTimeZone.toZoneId()).toLocalTime();
                }
                if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$1()) {
                    return (T) java.time.ZonedDateTime.ofInstant(java.time.Instant.ofEpochMilli(jLongValue), com.alibaba.fastjson.JSON.defaultTimeZone.toZoneId());
                }
                if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$7()) {
                    return (T) java.time.Instant.ofEpochMilli(jLongValue);
                }
                throw new java.lang.UnsupportedOperationException();
            }
            if (jSONLexer.token() == 12) {
                com.alibaba.fastjson.JSONObject object = defaultJSONParser.parseObject();
                if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$7()) {
                    java.lang.Object obj2 = object.get("epochSecond");
                    java.lang.Object obj3 = object.get("nano");
                    boolean z = obj2 instanceof java.lang.Number;
                    if (z && (obj3 instanceof java.lang.Number)) {
                        return (T) java.time.Instant.ofEpochSecond(com.alibaba.fastjson.util.TypeUtils.longExtractValue((java.lang.Number) obj2), com.alibaba.fastjson.util.TypeUtils.longExtractValue((java.lang.Number) obj3));
                    }
                    if (z) {
                        return (T) java.time.Instant.ofEpochSecond(com.alibaba.fastjson.util.TypeUtils.longExtractValue((java.lang.Number) obj2));
                    }
                } else if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$6() && (l = object.getLong("seconds")) != null) {
                    return (T) java.time.Duration.ofSeconds(l.longValue(), object.getLongValue("nano"));
                }
            } else {
                throw new java.lang.UnsupportedOperationException();
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00ec  */
    protected java.time.LocalDateTime parseDateTime(java.lang.String str, java.time.format.DateTimeFormatter dateTimeFormatter) {
        java.time.format.DateTimeFormatter dateTimeFormatter2;
        if (dateTimeFormatter == null) {
            if (str.length() == 19) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                char cCharAt3 = str.charAt(10);
                char cCharAt4 = str.charAt(13);
                char cCharAt5 = str.charAt(16);
                if (cCharAt4 != ':' || cCharAt5 != ':') {
                    dateTimeFormatter2 = dateTimeFormatter;
                } else if (cCharAt == '-' && cCharAt2 == '-') {
                    if (cCharAt3 == 'T') {
                        dateTimeFormatter2 = java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                    } else if (cCharAt3 == ' ') {
                        dateTimeFormatter2 = defaultFormatter;
                    } else {
                        dateTimeFormatter2 = dateTimeFormatter;
                    }
                } else if (cCharAt == '/' && cCharAt2 == '/') {
                    dateTimeFormatter2 = formatter_dt19_tw;
                } else {
                    char cCharAt6 = str.charAt(0);
                    char cCharAt7 = str.charAt(1);
                    char cCharAt8 = str.charAt(2);
                    char cCharAt9 = str.charAt(3);
                    char cCharAt10 = str.charAt(5);
                    if (cCharAt8 == '/' && cCharAt10 == '/') {
                        int i = ((cCharAt9 - '0') * 10) + (cCharAt - '0');
                        if (((cCharAt6 - '0') * 10) + (cCharAt7 - '0') > 12) {
                            dateTimeFormatter2 = formatter_dt19_eur;
                        } else if (i > 12) {
                            dateTimeFormatter2 = formatter_dt19_us;
                        } else {
                            java.lang.String country = java.util.Locale.getDefault().getCountry();
                            if (country.equals("US")) {
                                dateTimeFormatter2 = formatter_dt19_us;
                            } else if (country.equals("BR") || country.equals("AU")) {
                                dateTimeFormatter2 = formatter_dt19_eur;
                            } else {
                                dateTimeFormatter2 = dateTimeFormatter;
                            }
                        }
                    } else if (cCharAt8 == '.' && cCharAt10 == '.') {
                        dateTimeFormatter2 = formatter_dt19_de;
                    } else if (cCharAt8 == '-' && cCharAt10 == '-') {
                        dateTimeFormatter2 = formatter_dt19_in;
                    } else {
                        dateTimeFormatter2 = dateTimeFormatter;
                    }
                }
            } else if (str.length() == 23) {
                char cCharAt11 = str.charAt(4);
                char cCharAt12 = str.charAt(7);
                char cCharAt13 = str.charAt(10);
                char cCharAt14 = str.charAt(13);
                char cCharAt15 = str.charAt(16);
                char cCharAt16 = str.charAt(19);
                if (cCharAt14 == ':' && cCharAt15 == ':' && cCharAt11 == '-' && cCharAt12 == '-' && cCharAt13 == ' ' && cCharAt16 == '.') {
                    dateTimeFormatter2 = defaultFormatter_23;
                } else {
                    dateTimeFormatter2 = dateTimeFormatter;
                }
            } else {
                dateTimeFormatter2 = dateTimeFormatter;
            }
            if (str.length() >= 17) {
                char cCharAt17 = str.charAt(4);
                if (cCharAt17 == 24180) {
                    if (str.charAt(str.length() - 1) == 31186) {
                        dateTimeFormatter2 = formatter_dt19_cn_1;
                    } else {
                        dateTimeFormatter2 = formatter_dt19_cn;
                    }
                } else if (cCharAt17 == 45380) {
                    dateTimeFormatter2 = formatter_dt19_kr;
                }
            }
        } else {
            dateTimeFormatter2 = dateTimeFormatter;
        }
        if (dateTimeFormatter2 == null) {
            com.alibaba.fastjson.parser.JSONScanner jSONScanner = new com.alibaba.fastjson.parser.JSONScanner(str);
            if (jSONScanner.scanISO8601DateIfMatch(false)) {
                return java.time.LocalDateTime.ofInstant(jSONScanner.getCalendar().toInstant(), java.time.ZoneId.systemDefault());
            }
            for (int i2 = 0; i2 < str.length(); i2++) {
                char cCharAt18 = str.charAt(i2);
                if (cCharAt18 >= '0' && cCharAt18 <= '9') {
                }
            }
            if (str.length() > 8 && str.length() < 19) {
                return java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(java.lang.Long.parseLong(str)), com.alibaba.fastjson.JSON.defaultTimeZone.toZoneId());
            }
        }
        if (dateTimeFormatter2 == null) {
            return java.time.LocalDateTime.parse(str);
        }
        return java.time.LocalDateTime.parse(str, dateTimeFormatter2);
    }

    protected java.time.LocalDate parseLocalDate(java.lang.String str, java.lang.String str2, java.time.format.DateTimeFormatter dateTimeFormatter) {
        java.time.format.DateTimeFormatter dateTimeFormatter2;
        java.time.format.DateTimeFormatter dateTimeFormatter3;
        if (dateTimeFormatter == null) {
            if (str.length() == 8) {
                dateTimeFormatter = formatter_d8;
            }
            if (str.length() == 10) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                if (cCharAt == '/' && cCharAt2 == '/') {
                    dateTimeFormatter = formatter_d10_tw;
                }
                char cCharAt3 = str.charAt(0);
                char cCharAt4 = str.charAt(1);
                char cCharAt5 = str.charAt(2);
                char cCharAt6 = str.charAt(3);
                char cCharAt7 = str.charAt(5);
                if (cCharAt5 == '/' && cCharAt7 == '/') {
                    int i = ((cCharAt6 - '0') * 10) + (cCharAt - '0');
                    if (((cCharAt3 - '0') * 10) + (cCharAt4 - '0') > 12) {
                        dateTimeFormatter3 = formatter_d10_eur;
                    } else if (i > 12) {
                        dateTimeFormatter3 = formatter_d10_us;
                    } else {
                        java.lang.String country = java.util.Locale.getDefault().getCountry();
                        if (country.equals("US")) {
                            dateTimeFormatter3 = formatter_d10_us;
                        } else if (country.equals("BR") || country.equals("AU")) {
                            dateTimeFormatter3 = formatter_d10_eur;
                        }
                    }
                    dateTimeFormatter = dateTimeFormatter3;
                } else if (cCharAt5 == '.' && cCharAt7 == '.') {
                    dateTimeFormatter = formatter_d10_de;
                } else if (cCharAt5 == '-' && cCharAt7 == '-') {
                    dateTimeFormatter = formatter_d10_in;
                }
            }
            if (str.length() >= 9) {
                char cCharAt8 = str.charAt(4);
                if (cCharAt8 == 24180) {
                    dateTimeFormatter2 = formatter_d10_cn;
                } else if (cCharAt8 == 45380) {
                    dateTimeFormatter2 = formatter_d10_kr;
                }
                dateTimeFormatter = dateTimeFormatter2;
            }
            for (int i2 = 0; i2 < str.length(); i2++) {
                char cCharAt9 = str.charAt(i2);
                if (cCharAt9 >= '0' && cCharAt9 <= '9') {
                }
            }
            if (str.length() > 8 && str.length() < 19) {
                return java.time.LocalDateTime.ofInstant(java.time.Instant.ofEpochMilli(java.lang.Long.parseLong(str)), com.alibaba.fastjson.JSON.defaultTimeZone.toZoneId()).toLocalDate();
            }
        }
        if (dateTimeFormatter == null) {
            return java.time.LocalDate.parse(str);
        }
        return java.time.LocalDate.parse(str, dateTimeFormatter);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00bb  */
    protected java.time.ZonedDateTime parseZonedDateTime(java.lang.String str, java.time.format.DateTimeFormatter dateTimeFormatter) {
        java.time.format.DateTimeFormatter dateTimeFormatter2;
        if (dateTimeFormatter == null) {
            if (str.length() == 19) {
                char cCharAt = str.charAt(4);
                char cCharAt2 = str.charAt(7);
                char cCharAt3 = str.charAt(10);
                char cCharAt4 = str.charAt(13);
                char cCharAt5 = str.charAt(16);
                if (cCharAt4 != ':' || cCharAt5 != ':') {
                    dateTimeFormatter2 = dateTimeFormatter;
                } else if (cCharAt == '-' && cCharAt2 == '-') {
                    if (cCharAt3 == 'T') {
                        dateTimeFormatter2 = java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                    } else if (cCharAt3 == ' ') {
                        dateTimeFormatter2 = defaultFormatter;
                    } else {
                        dateTimeFormatter2 = dateTimeFormatter;
                    }
                } else if (cCharAt == '/' && cCharAt2 == '/') {
                    dateTimeFormatter2 = formatter_dt19_tw;
                } else {
                    char cCharAt6 = str.charAt(0);
                    char cCharAt7 = str.charAt(1);
                    char cCharAt8 = str.charAt(2);
                    char cCharAt9 = str.charAt(3);
                    char cCharAt10 = str.charAt(5);
                    if (cCharAt8 == '/' && cCharAt10 == '/') {
                        int i = ((cCharAt9 - '0') * 10) + (cCharAt - '0');
                        if (((cCharAt6 - '0') * 10) + (cCharAt7 - '0') > 12) {
                            dateTimeFormatter2 = formatter_dt19_eur;
                        } else if (i > 12) {
                            dateTimeFormatter2 = formatter_dt19_us;
                        } else {
                            java.lang.String country = java.util.Locale.getDefault().getCountry();
                            if (country.equals("US")) {
                                dateTimeFormatter2 = formatter_dt19_us;
                            } else if (country.equals("BR") || country.equals("AU")) {
                                dateTimeFormatter2 = formatter_dt19_eur;
                            } else {
                                dateTimeFormatter2 = dateTimeFormatter;
                            }
                        }
                    } else if (cCharAt8 == '.' && cCharAt10 == '.') {
                        dateTimeFormatter2 = formatter_dt19_de;
                    } else if (cCharAt8 == '-' && cCharAt10 == '-') {
                        dateTimeFormatter2 = formatter_dt19_in;
                    } else {
                        dateTimeFormatter2 = dateTimeFormatter;
                    }
                }
            } else {
                dateTimeFormatter2 = dateTimeFormatter;
            }
            if (str.length() >= 17) {
                char cCharAt11 = str.charAt(4);
                if (cCharAt11 == 24180) {
                    if (str.charAt(str.length() - 1) == 31186) {
                        dateTimeFormatter2 = formatter_dt19_cn_1;
                    } else {
                        dateTimeFormatter2 = formatter_dt19_cn;
                    }
                } else if (cCharAt11 == 45380) {
                    dateTimeFormatter2 = formatter_dt19_kr;
                }
            }
            for (int i2 = 0; i2 < str.length(); i2++) {
                char cCharAt12 = str.charAt(i2);
                if (cCharAt12 >= '0' && cCharAt12 <= '9') {
                }
            }
            if (str.length() > 8 && str.length() < 19) {
                return java.time.ZonedDateTime.ofInstant(java.time.Instant.ofEpochMilli(java.lang.Long.parseLong(str)), com.alibaba.fastjson.JSON.defaultTimeZone.toZoneId());
            }
        } else {
            dateTimeFormatter2 = dateTimeFormatter;
        }
        if (dateTimeFormatter2 == null) {
            return java.time.ZonedDateTime.parse(str);
        }
        return java.time.ZonedDateTime.parse(str, dateTimeFormatter2);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i) throws java.io.IOException {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        if (type == null) {
            type = obj.getClass();
        }
        if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$9()) {
            int mask = com.alibaba.fastjson.serializer.SerializerFeature.UseISO8601DateFormat.getMask();
            java.time.LocalDateTime localDateTimeM175m = androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m175m(obj);
            java.lang.String dateFormatPattern = jSONSerializer.getDateFormatPattern();
            if (dateFormatPattern == null) {
                int i2 = mask & i;
                dateFormatPattern = formatter_iso8601_pattern;
                if (i2 == 0 && !jSONSerializer.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.UseISO8601DateFormat)) {
                    if (jSONSerializer.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.WriteDateUseDateFormat)) {
                        dateFormatPattern = (jSONSerializer.getFastJsonConfigDateFormatPattern() == null || jSONSerializer.getFastJsonConfigDateFormatPattern().length() <= 0) ? com.alibaba.fastjson.JSON.DEFFAULT_DATE_FORMAT : jSONSerializer.getFastJsonConfigDateFormatPattern();
                    } else {
                        int nano = localDateTimeM175m.getNano();
                        if (nano != 0) {
                            dateFormatPattern = nano % kotlin.time.DurationKt.NANOS_IN_MILLIS == 0 ? formatter_iso8601_pattern_23 : formatter_iso8601_pattern_29;
                        }
                    }
                }
            }
            if (dateFormatPattern != null) {
                write(serializeWriter, localDateTimeM175m, dateFormatPattern);
                return;
            } else {
                serializeWriter.writeLong(localDateTimeM175m.atZone(com.alibaba.fastjson.JSON.defaultTimeZone.toZoneId()).toInstant().toEpochMilli());
                return;
            }
        }
        serializeWriter.writeString(obj.toString());
    }

    @Override // com.alibaba.fastjson.serializer.ContextObjectSerializer
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, com.alibaba.fastjson.serializer.BeanContext beanContext) throws java.io.IOException {
        write(jSONSerializer.out, androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m189m(obj), beanContext.getFormat());
    }

    private void write(com.alibaba.fastjson.serializer.SerializeWriter serializeWriter, java.time.temporal.TemporalAccessor temporalAccessor, java.lang.String str) {
        java.time.format.DateTimeFormatter dateTimeFormatterOfPattern;
        java.time.Instant instant;
        if ("unixtime".equals(str)) {
            if (androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m199m((java.lang.Object) temporalAccessor)) {
                serializeWriter.writeInt((int) androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m186m((java.lang.Object) temporalAccessor).toEpochSecond());
                return;
            } else if (androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$1(temporalAccessor)) {
                serializeWriter.writeInt((int) androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m175m((java.lang.Object) temporalAccessor).atZone(com.alibaba.fastjson.JSON.defaultTimeZone.toZoneId()).toEpochSecond());
                return;
            }
        }
        if ("millis".equals(str)) {
            if (androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m199m((java.lang.Object) temporalAccessor)) {
                instant = androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m186m((java.lang.Object) temporalAccessor).toInstant();
            } else {
                instant = androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$1(temporalAccessor) ? androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m175m((java.lang.Object) temporalAccessor).atZone(com.alibaba.fastjson.JSON.defaultTimeZone.toZoneId()).toInstant() : null;
            }
            if (instant != null) {
                serializeWriter.writeLong(instant.toEpochMilli());
                return;
            }
        }
        if (str == formatter_iso8601_pattern) {
            dateTimeFormatterOfPattern = formatter_iso8601;
        } else {
            dateTimeFormatterOfPattern = java.time.format.DateTimeFormatter.ofPattern(str);
        }
        serializeWriter.writeString(dateTimeFormatterOfPattern.format(temporalAccessor));
    }

    public static java.lang.Object castToLocalDateTime(java.lang.Object obj, java.lang.String str) {
        if (obj == null) {
            return null;
        }
        if (str == null) {
            str = defaultPatttern;
        }
        return java.time.LocalDateTime.parse(obj.toString(), java.time.format.DateTimeFormatter.ofPattern(str));
    }
}
