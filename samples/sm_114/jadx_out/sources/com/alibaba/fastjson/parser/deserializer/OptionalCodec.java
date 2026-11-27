package com.alibaba.fastjson.parser.deserializer;

/* JADX INFO: loaded from: classes.dex */
public class OptionalCodec implements com.alibaba.fastjson.serializer.ObjectSerializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer {
    public static com.alibaba.fastjson.parser.deserializer.OptionalCodec instance = new com.alibaba.fastjson.parser.deserializer.OptionalCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser defaultJSONParser, java.lang.reflect.Type type, java.lang.Object obj) {
        if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$10()) {
            java.lang.Integer numCastToInt = com.alibaba.fastjson.util.TypeUtils.castToInt(defaultJSONParser.parseObject((java.lang.Class) java.lang.Integer.class));
            if (numCastToInt == null) {
                return (T) java.util.OptionalInt.empty();
            }
            return (T) java.util.OptionalInt.of(numCastToInt.intValue());
        }
        if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$11()) {
            java.lang.Long lCastToLong = com.alibaba.fastjson.util.TypeUtils.castToLong(defaultJSONParser.parseObject((java.lang.Class) java.lang.Long.class));
            if (lCastToLong == null) {
                return (T) java.util.OptionalLong.empty();
            }
            return (T) java.util.OptionalLong.of(lCastToLong.longValue());
        }
        if (type == androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$12()) {
            java.lang.Double dCastToDouble = com.alibaba.fastjson.util.TypeUtils.castToDouble(defaultJSONParser.parseObject((java.lang.Class) java.lang.Double.class));
            if (dCastToDouble == null) {
                return (T) java.util.OptionalDouble.empty();
            }
            return (T) java.util.OptionalDouble.of(dCastToDouble.doubleValue());
        }
        java.lang.Object object = defaultJSONParser.parseObject(com.alibaba.fastjson.util.TypeUtils.unwrapOptional(type));
        if (object == null) {
            return (T) java.util.Optional.empty();
        }
        return (T) java.util.Optional.of(object);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i) throws java.io.IOException {
        if (obj == null) {
            jSONSerializer.writeNull();
            return;
        }
        if (androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$4(obj)) {
            java.util.Optional optionalM414m = dc.squareup.okio.Okio$$ExternalSyntheticApiModelOutline0.m414m(obj);
            jSONSerializer.write(optionalM414m.isPresent() ? optionalM414m.get() : null);
            return;
        }
        if (androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$2(obj)) {
            java.util.OptionalDouble optionalDoubleM193m = androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m193m(obj);
            if (optionalDoubleM193m.isPresent()) {
                jSONSerializer.write(java.lang.Double.valueOf(optionalDoubleM193m.getAsDouble()));
                return;
            } else {
                jSONSerializer.writeNull();
                return;
            }
        }
        if (androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$3(obj)) {
            java.util.OptionalInt optionalIntM195m = androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m195m(obj);
            if (optionalIntM195m.isPresent()) {
                jSONSerializer.out.writeInt(optionalIntM195m.getAsInt());
                return;
            } else {
                jSONSerializer.writeNull();
                return;
            }
        }
        if (androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m$5(obj)) {
            java.util.OptionalLong optionalLongM198m = androidx.webkit.internal.ApiHelperForP$$ExternalSyntheticApiModelOutline6.m198m(obj);
            if (optionalLongM198m.isPresent()) {
                jSONSerializer.out.writeLong(optionalLongM198m.getAsLong());
                return;
            } else {
                jSONSerializer.writeNull();
                return;
            }
        }
        throw new com.alibaba.fastjson.JSONException("not support optional : " + obj.getClass());
    }
}
