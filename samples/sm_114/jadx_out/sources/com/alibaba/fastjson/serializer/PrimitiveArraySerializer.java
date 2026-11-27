package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public class PrimitiveArraySerializer implements com.alibaba.fastjson.serializer.ObjectSerializer {
    public static com.alibaba.fastjson.serializer.PrimitiveArraySerializer instance = new com.alibaba.fastjson.serializer.PrimitiveArraySerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i) throws java.io.IOException {
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull(com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        int i2 = 0;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            serializeWriter.write(91);
            while (i2 < iArr.length) {
                if (i2 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeInt(iArr[i2]);
                i2++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            serializeWriter.write(91);
            while (i2 < sArr.length) {
                if (i2 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeInt(sArr[i2]);
                i2++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            serializeWriter.write(91);
            while (i2 < jArr.length) {
                if (i2 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.writeLong(jArr[i2]);
                i2++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            serializeWriter.write(91);
            while (i2 < zArr.length) {
                if (i2 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.write(zArr[i2]);
                i2++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            serializeWriter.write(91);
            while (i2 < fArr.length) {
                if (i2 != 0) {
                    serializeWriter.write(44);
                }
                float f = fArr[i2];
                if (java.lang.Float.isNaN(f)) {
                    serializeWriter.writeNull();
                } else {
                    serializeWriter.append((java.lang.CharSequence) java.lang.Float.toString(f));
                }
                i2++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            serializeWriter.write(91);
            while (i2 < dArr.length) {
                if (i2 != 0) {
                    serializeWriter.write(44);
                }
                double d = dArr[i2];
                if (java.lang.Double.isNaN(d)) {
                    serializeWriter.writeNull();
                } else {
                    serializeWriter.append((java.lang.CharSequence) java.lang.Double.toString(d));
                }
                i2++;
            }
            serializeWriter.write(93);
            return;
        }
        if (obj instanceof byte[]) {
            serializeWriter.writeByteArray((byte[]) obj);
        } else {
            serializeWriter.writeString((char[]) obj);
        }
    }
}
