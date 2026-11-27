package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public enum SerializerFeature {
    QuoteFieldNames,
    UseSingleQuotes,
    WriteMapNullValue,
    WriteEnumUsingToString,
    WriteEnumUsingName,
    UseISO8601DateFormat,
    WriteNullListAsEmpty,
    WriteNullStringAsEmpty,
    WriteNullNumberAsZero,
    WriteNullBooleanAsFalse,
    SkipTransientField,
    SortField,
    WriteTabAsSpecial,
    PrettyFormat,
    WriteClassName,
    DisableCircularReferenceDetect,
    WriteSlashAsSpecial,
    BrowserCompatible,
    WriteDateUseDateFormat,
    NotWriteRootClassName,
    DisableCheckSpecialChar,
    BeanToArray,
    WriteNonStringKeyAsString,
    NotWriteDefaultValue,
    BrowserSecure,
    IgnoreNonFieldGetter,
    WriteNonStringValueAsString,
    IgnoreErrorGetter,
    WriteBigDecimalAsPlain,
    MapSortField;

    public static final com.alibaba.fastjson.serializer.SerializerFeature[] EMPTY;
    public static final int WRITE_MAP_NULL_FEATURES;
    public final int mask = 1 << ordinal();

    static {
        com.alibaba.fastjson.serializer.SerializerFeature serializerFeature = WriteMapNullValue;
        com.alibaba.fastjson.serializer.SerializerFeature serializerFeature2 = WriteNullListAsEmpty;
        com.alibaba.fastjson.serializer.SerializerFeature serializerFeature3 = WriteNullStringAsEmpty;
        com.alibaba.fastjson.serializer.SerializerFeature serializerFeature4 = WriteNullNumberAsZero;
        com.alibaba.fastjson.serializer.SerializerFeature serializerFeature5 = WriteNullBooleanAsFalse;
        EMPTY = new com.alibaba.fastjson.serializer.SerializerFeature[0];
        WRITE_MAP_NULL_FEATURES = serializerFeature.getMask() | serializerFeature5.getMask() | serializerFeature2.getMask() | serializerFeature4.getMask() | serializerFeature3.getMask();
    }

    SerializerFeature() {
    }

    public final int getMask() {
        return this.mask;
    }

    public static boolean isEnabled(int i, com.alibaba.fastjson.serializer.SerializerFeature serializerFeature) {
        return (i & serializerFeature.mask) != 0;
    }

    public static boolean isEnabled(int i, int i2, com.alibaba.fastjson.serializer.SerializerFeature serializerFeature) {
        int i3 = serializerFeature.mask;
        return ((i & i3) == 0 && (i2 & i3) == 0) ? false : true;
    }

    public static int config(int i, com.alibaba.fastjson.serializer.SerializerFeature serializerFeature, boolean z) {
        if (z) {
            return i | serializerFeature.mask;
        }
        return i & (~serializerFeature.mask);
    }

    public static int of(com.alibaba.fastjson.serializer.SerializerFeature[] serializerFeatureArr) {
        if (serializerFeatureArr == null) {
            return 0;
        }
        int i = 0;
        for (com.alibaba.fastjson.serializer.SerializerFeature serializerFeature : serializerFeatureArr) {
            i |= serializerFeature.mask;
        }
        return i;
    }
}
