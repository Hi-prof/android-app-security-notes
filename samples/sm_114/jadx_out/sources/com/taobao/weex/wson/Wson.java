package com.taobao.weex.wson;

/* JADX INFO: loaded from: classes.dex */
public class Wson {
    private static final byte ARRAY_TYPE = 91;
    private static final byte BOOLEAN_TYPE_FALSE = 102;
    private static final byte BOOLEAN_TYPE_TRUE = 116;
    private static final int GLOBAL_STRING_CACHE_SIZE = 2048;
    private static final boolean IS_NATIVE_LITTLE_ENDIAN;
    private static final byte MAP_TYPE = 123;
    private static final java.lang.String METHOD_PREFIX_GET = "get";
    private static final java.lang.String METHOD_PREFIX_IS = "is";
    private static final byte NULL_TYPE = 48;
    private static final byte NUMBER_BIG_DECIMAL_TYPE = 101;
    private static final byte NUMBER_BIG_INTEGER_TYPE = 103;
    private static final byte NUMBER_DOUBLE_TYPE = 100;
    private static final byte NUMBER_FLOAT_TYPE = 70;
    private static final byte NUMBER_INT_TYPE = 105;
    private static final byte NUMBER_LONG_TYPE = 108;
    private static final byte STRING_TYPE = 115;
    public static final boolean WriteMapNullValue = false;
    private static androidx.collection.LruCache<java.lang.String, java.util.List<java.lang.reflect.Field>> fieldsCache;
    private static final java.lang.String[] globalStringBytesCache;
    private static final java.lang.ThreadLocal<char[]> localCharsBufferCache;
    private static androidx.collection.LruCache<java.lang.String, java.util.List<java.lang.reflect.Method>> methodsCache;
    private static androidx.collection.LruCache<java.lang.String, java.lang.Boolean> specialClass;

    static {
        IS_NATIVE_LITTLE_ENDIAN = java.nio.ByteOrder.nativeOrder() == java.nio.ByteOrder.LITTLE_ENDIAN;
        localCharsBufferCache = new java.lang.ThreadLocal<>();
        globalStringBytesCache = new java.lang.String[2048];
        methodsCache = new androidx.collection.LruCache<>(128);
        fieldsCache = new androidx.collection.LruCache<>(128);
        specialClass = new androidx.collection.LruCache<>(16);
    }

    public static final java.lang.Object parse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            com.taobao.weex.wson.Wson.Parser parser = new com.taobao.weex.wson.Wson.Parser(bArr);
            java.lang.Object obj = parser.parse();
            parser.close();
            return obj;
        } catch (java.lang.Exception e) {
            com.taobao.weex.utils.WXLogUtils.e("parseWson", e);
            return null;
        }
    }

    public static final byte[] toWson(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        com.taobao.weex.wson.Wson.Builder builder = new com.taobao.weex.wson.Wson.Builder();
        byte[] wson = builder.toWson(obj);
        builder.close();
        return wson;
    }

    private static final class Parser {
        private byte[] buffer;
        private char[] charsBuffer;
        private int position;

        private Parser(byte[] bArr) {
            this.position = 0;
            this.buffer = bArr;
            char[] cArr = (char[]) com.taobao.weex.wson.Wson.localCharsBufferCache.get();
            this.charsBuffer = cArr;
            if (cArr != null) {
                com.taobao.weex.wson.Wson.localCharsBufferCache.set(null);
            } else {
                this.charsBuffer = new char[512];
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final java.lang.Object parse() {
            return readObject();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void close() {
            this.position = 0;
            this.buffer = null;
            if (this.charsBuffer != null) {
                com.taobao.weex.wson.Wson.localCharsBufferCache.set(this.charsBuffer);
            }
            this.charsBuffer = null;
        }

        private final java.lang.Object readObject() {
            byte type = readType();
            if (type == 48) {
                return null;
            }
            if (type == 70) {
                return readFloat();
            }
            if (type == 91) {
                return readArray();
            }
            if (type == 105) {
                return java.lang.Integer.valueOf(readVarInt());
            }
            if (type == 108) {
                return java.lang.Long.valueOf(readLong());
            }
            if (type == 123) {
                return readMap();
            }
            if (type == 115) {
                return readUTF16String();
            }
            if (type != 116) {
                switch (type) {
                    case 100:
                        return readDouble();
                    case 101:
                        return new java.math.BigDecimal(readUTF16String());
                    case 102:
                        return java.lang.Boolean.FALSE;
                    case 103:
                        return new java.math.BigInteger(readUTF16String());
                    default:
                        throw new java.lang.RuntimeException("wson unhandled type " + ((int) type) + com.taobao.weex.el.parse.Operators.SPACE_STR + this.position + " length " + this.buffer.length);
                }
            }
            return java.lang.Boolean.TRUE;
        }

        private final java.lang.Object readMap() {
            int uInt = readUInt();
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            for (int i = 0; i < uInt; i++) {
                jSONObject.put(readMapKeyUTF16(), readObject());
            }
            return jSONObject;
        }

        private final java.lang.Object readArray() {
            int uInt = readUInt();
            com.alibaba.fastjson.JSONArray jSONArray = new com.alibaba.fastjson.JSONArray(uInt);
            for (int i = 0; i < uInt; i++) {
                jSONArray.add(readObject());
            }
            return jSONArray;
        }

        private final byte readType() {
            byte[] bArr = this.buffer;
            int i = this.position;
            byte b = bArr[i];
            this.position = i + 1;
            return b;
        }

        private final java.lang.String readMapKeyUTF16() {
            int uInt = readUInt() / 2;
            if (this.charsBuffer.length < uInt) {
                this.charsBuffer = new char[uInt];
            }
            int i = 5381;
            if (com.taobao.weex.wson.Wson.IS_NATIVE_LITTLE_ENDIAN) {
                for (int i2 = 0; i2 < uInt; i2++) {
                    byte[] bArr = this.buffer;
                    int i3 = this.position;
                    char c = (char) ((bArr[i3] & 255) + (bArr[i3 + 1] << 8));
                    this.charsBuffer[i2] = c;
                    i = (i << 5) + i + c;
                    this.position = i3 + 2;
                }
            } else {
                for (int i4 = 0; i4 < uInt; i4++) {
                    byte[] bArr2 = this.buffer;
                    int i5 = this.position;
                    char c2 = (char) ((bArr2[i5 + 1] & 255) + (bArr2[i5] << 8));
                    this.charsBuffer[i4] = c2;
                    i = (i << 5) + i + c2;
                    this.position = i5 + 2;
                }
            }
            int length = (com.taobao.weex.wson.Wson.globalStringBytesCache.length - 1) & i;
            java.lang.String str = com.taobao.weex.wson.Wson.globalStringBytesCache[length];
            if (str != null && str.length() == uInt) {
                for (int i6 = 0; i6 < uInt; i6++) {
                    if (this.charsBuffer[i6] == str.charAt(i6)) {
                    }
                }
                return str;
            }
            java.lang.String str2 = new java.lang.String(this.charsBuffer, 0, uInt);
            if (uInt < 64) {
                com.taobao.weex.wson.Wson.globalStringBytesCache[length] = str2;
            }
            return str2;
        }

        private final java.lang.String readUTF16String() {
            int uInt = readUInt() / 2;
            if (this.charsBuffer.length < uInt) {
                this.charsBuffer = new char[uInt];
            }
            if (com.taobao.weex.wson.Wson.IS_NATIVE_LITTLE_ENDIAN) {
                for (int i = 0; i < uInt; i++) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.charsBuffer[i] = (char) ((bArr[i2] & 255) + (bArr[i2 + 1] << 8));
                    this.position = i2 + 2;
                }
            } else {
                for (int i3 = 0; i3 < uInt; i3++) {
                    byte[] bArr2 = this.buffer;
                    int i4 = this.position;
                    this.charsBuffer[i3] = (char) ((bArr2[i4 + 1] & 255) + (bArr2[i4] << 8));
                    this.position = i4 + 2;
                }
            }
            return new java.lang.String(this.charsBuffer, 0, uInt);
        }

        private final int readVarInt() {
            int uInt = readUInt();
            return (uInt & Integer.MIN_VALUE) ^ ((((uInt << 31) >> 31) ^ uInt) >> 1);
        }

        private final int readUInt() {
            int i = 0;
            int i2 = 0;
            do {
                byte[] bArr = this.buffer;
                int i3 = this.position;
                byte b = bArr[i3];
                if ((b & kotlin.jvm.internal.ByteCompanionObject.MIN_VALUE) != 0) {
                    i |= (b & kotlin.jvm.internal.ByteCompanionObject.MAX_VALUE) << i2;
                    i2 += 7;
                    this.position = i3 + 1;
                } else {
                    this.position = i3 + 1;
                    return i | (b << i2);
                }
            } while (i2 <= 35);
            throw new java.lang.IllegalArgumentException("Variable length quantity is too long");
        }

        private final long readLong() {
            byte[] bArr = this.buffer;
            int i = this.position;
            long j = (((long) bArr[i + 7]) & 255) + ((((long) bArr[i + 6]) & 255) << 8) + ((((long) bArr[i + 5]) & 255) << 16) + ((((long) bArr[i + 4]) & 255) << 24) + ((((long) bArr[i + 3]) & 255) << 32) + ((((long) bArr[i + 2]) & 255) << 40) + ((255 & ((long) bArr[i + 1])) << 48) + (((long) bArr[i]) << 56);
            this.position = i + 8;
            return j;
        }

        private final java.lang.Object readDouble() {
            double dLongBitsToDouble = java.lang.Double.longBitsToDouble(readLong());
            if (dLongBitsToDouble > 2.147483647E9d) {
                long j = (long) dLongBitsToDouble;
                if (dLongBitsToDouble - j < Double.MIN_NORMAL) {
                    return java.lang.Long.valueOf(j);
                }
            }
            return java.lang.Double.valueOf(dLongBitsToDouble);
        }

        private java.lang.Object readFloat() {
            byte[] bArr = this.buffer;
            int i = this.position;
            int i2 = (bArr[i + 3] & 255) + ((bArr[i + 2] & 255) << 8) + ((bArr[i + 1] & 255) << 16) + ((bArr[i] & 255) << 24);
            this.position = i + 4;
            return java.lang.Float.valueOf(java.lang.Float.intBitsToFloat(i2));
        }
    }

    private static final class Builder {
        private static final java.lang.ThreadLocal<byte[]> bufLocal = new java.lang.ThreadLocal<>();
        private static final java.lang.ThreadLocal<java.util.ArrayList> refsLocal = new java.lang.ThreadLocal<>();
        private byte[] buffer;
        private int position;
        private java.util.ArrayList refs;

        private Builder() {
            java.lang.ThreadLocal<byte[]> threadLocal = bufLocal;
            byte[] bArr = threadLocal.get();
            this.buffer = bArr;
            if (bArr != null) {
                threadLocal.set(null);
            } else {
                this.buffer = new byte[1024];
            }
            java.lang.ThreadLocal<java.util.ArrayList> threadLocal2 = refsLocal;
            java.util.ArrayList arrayList = threadLocal2.get();
            this.refs = arrayList;
            if (arrayList != null) {
                threadLocal2.set(null);
            } else {
                this.refs = new java.util.ArrayList(16);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final byte[] toWson(java.lang.Object obj) {
            writeObject(obj);
            int i = this.position;
            byte[] bArr = new byte[i];
            java.lang.System.arraycopy(this.buffer, 0, bArr, 0, i);
            return bArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void close() {
            byte[] bArr = this.buffer;
            if (bArr.length <= 16384) {
                bufLocal.set(bArr);
            }
            if (this.refs.isEmpty()) {
                refsLocal.set(this.refs);
            } else {
                this.refs.clear();
            }
            this.refs = null;
            this.buffer = null;
            this.position = 0;
        }

        private final void writeObject(java.lang.Object obj) {
            if (obj instanceof java.lang.CharSequence) {
                ensureCapacity(2);
                writeByte(com.taobao.weex.wson.Wson.STRING_TYPE);
                writeUTF16String((java.lang.CharSequence) obj);
                return;
            }
            if (obj instanceof java.util.Map) {
                if (this.refs.contains(obj)) {
                    ensureCapacity(2);
                    writeByte(com.taobao.weex.wson.Wson.NULL_TYPE);
                    return;
                } else {
                    this.refs.add(obj);
                    writeMap((java.util.Map) obj);
                    java.util.ArrayList arrayList = this.refs;
                    arrayList.remove(arrayList.size() - 1);
                    return;
                }
            }
            if (obj instanceof java.util.List) {
                if (this.refs.contains(obj)) {
                    ensureCapacity(2);
                    writeByte(com.taobao.weex.wson.Wson.NULL_TYPE);
                    return;
                }
                this.refs.add(obj);
                ensureCapacity(8);
                java.util.List list = (java.util.List) obj;
                writeByte(com.taobao.weex.wson.Wson.ARRAY_TYPE);
                writeUInt(list.size());
                java.util.Iterator it = list.iterator();
                while (it.hasNext()) {
                    writeObject(it.next());
                }
                java.util.ArrayList arrayList2 = this.refs;
                arrayList2.remove(arrayList2.size() - 1);
                return;
            }
            if (obj instanceof java.lang.Number) {
                writeNumber((java.lang.Number) obj);
                return;
            }
            if (obj instanceof java.lang.Boolean) {
                ensureCapacity(2);
                if (((java.lang.Boolean) obj).booleanValue()) {
                    writeByte(com.taobao.weex.wson.Wson.BOOLEAN_TYPE_TRUE);
                    return;
                } else {
                    writeByte(com.taobao.weex.wson.Wson.BOOLEAN_TYPE_FALSE);
                    return;
                }
            }
            if (obj == null) {
                ensureCapacity(2);
                writeByte(com.taobao.weex.wson.Wson.NULL_TYPE);
                return;
            }
            if (obj.getClass().isArray()) {
                if (this.refs.contains(obj)) {
                    ensureCapacity(2);
                    writeByte(com.taobao.weex.wson.Wson.NULL_TYPE);
                    return;
                }
                this.refs.add(obj);
                ensureCapacity(8);
                int length = java.lang.reflect.Array.getLength(obj);
                writeByte(com.taobao.weex.wson.Wson.ARRAY_TYPE);
                writeUInt(length);
                for (int i = 0; i < length; i++) {
                    writeObject(java.lang.reflect.Array.get(obj, i));
                }
                java.util.ArrayList arrayList3 = this.refs;
                arrayList3.remove(arrayList3.size() - 1);
                return;
            }
            if (obj instanceof java.util.Date) {
                ensureCapacity(10);
                double time = ((java.util.Date) obj).getTime();
                writeByte(com.taobao.weex.wson.Wson.NUMBER_DOUBLE_TYPE);
                writeDouble(time);
                return;
            }
            if (obj instanceof java.util.Calendar) {
                ensureCapacity(10);
                double time2 = ((java.util.Calendar) obj).getTime().getTime();
                writeByte(com.taobao.weex.wson.Wson.NUMBER_DOUBLE_TYPE);
                writeDouble(time2);
                return;
            }
            if (obj instanceof java.util.Collection) {
                if (this.refs.contains(obj)) {
                    ensureCapacity(2);
                    writeByte(com.taobao.weex.wson.Wson.NULL_TYPE);
                    return;
                }
                this.refs.add(obj);
                ensureCapacity(8);
                java.util.Collection collection = (java.util.Collection) obj;
                writeByte(com.taobao.weex.wson.Wson.ARRAY_TYPE);
                writeUInt(collection.size());
                java.util.Iterator it2 = collection.iterator();
                while (it2.hasNext()) {
                    writeObject(it2.next());
                }
                java.util.ArrayList arrayList4 = this.refs;
                arrayList4.remove(arrayList4.size() - 1);
                return;
            }
            if (this.refs.contains(obj)) {
                ensureCapacity(2);
                writeByte(com.taobao.weex.wson.Wson.NULL_TYPE);
                return;
            }
            this.refs.add(obj);
            if (obj.getClass().isEnum()) {
                writeObject(com.alibaba.fastjson.JSON.toJSONString(obj));
            } else {
                writeAdapterObject(obj);
            }
            java.util.ArrayList arrayList5 = this.refs;
            arrayList5.remove(arrayList5.size() - 1);
        }

        private final void writeNumber(java.lang.Number number) {
            ensureCapacity(12);
            if (number instanceof java.lang.Integer) {
                writeByte(com.taobao.weex.wson.Wson.NUMBER_INT_TYPE);
                writeVarInt(number.intValue());
                return;
            }
            if (number instanceof java.lang.Float) {
                writeByte(com.taobao.weex.wson.Wson.NUMBER_FLOAT_TYPE);
                writeFloat(number.floatValue());
                return;
            }
            if (number instanceof java.lang.Double) {
                writeByte(com.taobao.weex.wson.Wson.NUMBER_DOUBLE_TYPE);
                writeDouble(number.doubleValue());
                return;
            }
            if (number instanceof java.lang.Long) {
                writeByte(com.taobao.weex.wson.Wson.NUMBER_LONG_TYPE);
                writeLong(number.longValue());
                return;
            }
            if ((number instanceof java.lang.Short) || (number instanceof java.lang.Byte)) {
                writeByte(com.taobao.weex.wson.Wson.NUMBER_INT_TYPE);
                writeVarInt(number.intValue());
                return;
            }
            if (number instanceof java.math.BigInteger) {
                writeByte(com.taobao.weex.wson.Wson.NUMBER_BIG_INTEGER_TYPE);
                writeUTF16String(number.toString());
                return;
            }
            if (number instanceof java.math.BigDecimal) {
                java.lang.String string = number.toString();
                double dDoubleValue = number.doubleValue();
                if (string.equals(java.lang.Double.toString(dDoubleValue))) {
                    writeByte(com.taobao.weex.wson.Wson.NUMBER_DOUBLE_TYPE);
                    writeDouble(dDoubleValue);
                    return;
                } else {
                    writeByte(com.taobao.weex.wson.Wson.NUMBER_BIG_DECIMAL_TYPE);
                    writeUTF16String(string);
                    return;
                }
            }
            writeByte(com.taobao.weex.wson.Wson.STRING_TYPE);
            writeUTF16String(number.toString());
        }

        private final void writeMap(java.util.Map map) {
            java.util.Set<java.util.Map.Entry> setEntrySet = map.entrySet();
            java.util.Iterator it = setEntrySet.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (((java.util.Map.Entry) it.next()).getValue() == null) {
                    i++;
                }
            }
            ensureCapacity(8);
            writeByte(com.taobao.weex.wson.Wson.MAP_TYPE);
            writeUInt(map.size() - i);
            for (java.util.Map.Entry entry : setEntrySet) {
                if (entry.getValue() != null) {
                    writeMapKeyUTF16(entry.getKey().toString());
                    writeObject(entry.getValue());
                }
            }
        }

        private final void writeByte(byte b) {
            byte[] bArr = this.buffer;
            int i = this.position;
            bArr[i] = b;
            this.position = i + 1;
        }

        private final void writeAdapterObject(java.lang.Object obj) {
            if (com.taobao.weex.wson.Wson.specialClass.get(obj.getClass().getName()) != null) {
                writeObject(com.alibaba.fastjson.JSON.toJSON(obj));
                return;
            }
            try {
                writeMap(toMap(obj));
            } catch (java.lang.Exception unused) {
                com.taobao.weex.wson.Wson.specialClass.put(obj.getClass().getName(), true);
                writeObject(com.alibaba.fastjson.JSON.toJSON(obj));
            }
        }

        private final java.util.Map toMap(java.lang.Object obj) {
            java.lang.Object obj2;
            java.lang.Object objInvoke;
            com.alibaba.fastjson.JSONObject jSONObject = new com.alibaba.fastjson.JSONObject();
            try {
                java.lang.Class<?> cls = obj.getClass();
                java.lang.String name = cls.getName();
                for (java.lang.reflect.Method method : com.taobao.weex.wson.Wson.getBeanMethod(name, cls)) {
                    java.lang.String name2 = method.getName();
                    if (name2.startsWith(com.taobao.weex.wson.Wson.METHOD_PREFIX_GET)) {
                        java.lang.Object objInvoke2 = method.invoke(obj, null);
                        if (objInvoke2 != null) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder(method.getName().substring(3));
                            sb.setCharAt(0, java.lang.Character.toLowerCase(sb.charAt(0)));
                            jSONObject.put(sb.toString(), objInvoke2);
                        }
                    } else if (name2.startsWith(com.taobao.weex.wson.Wson.METHOD_PREFIX_IS) && (objInvoke = method.invoke(obj, null)) != null) {
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder(method.getName().substring(2));
                        sb2.setCharAt(0, java.lang.Character.toLowerCase(sb2.charAt(0)));
                        jSONObject.put(sb2.toString(), objInvoke);
                    }
                }
                for (java.lang.reflect.Field field : com.taobao.weex.wson.Wson.getBeanFields(name, cls)) {
                    java.lang.String name3 = field.getName();
                    if (!jSONObject.containsKey(name3) && (obj2 = field.get(obj)) != null) {
                        jSONObject.put(name3, obj2);
                    }
                }
                return jSONObject;
            } catch (java.lang.Exception e) {
                if (e instanceof java.lang.RuntimeException) {
                    throw ((java.lang.RuntimeException) e);
                }
                throw new java.lang.RuntimeException(e);
            }
        }

        private final void writeMapKeyUTF16(java.lang.String str) {
            writeUTF16String(str);
        }

        private final void writeUTF16String(java.lang.CharSequence charSequence) {
            int length = charSequence.length();
            int i = length * 2;
            ensureCapacity(i + 8);
            writeUInt(i);
            int i2 = 0;
            if (com.taobao.weex.wson.Wson.IS_NATIVE_LITTLE_ENDIAN) {
                while (i2 < length) {
                    char cCharAt = charSequence.charAt(i2);
                    byte[] bArr = this.buffer;
                    int i3 = this.position;
                    bArr[i3] = (byte) cCharAt;
                    bArr[i3 + 1] = (byte) (cCharAt >>> '\b');
                    this.position = i3 + 2;
                    i2++;
                }
                return;
            }
            while (i2 < length) {
                char cCharAt2 = charSequence.charAt(i2);
                byte[] bArr2 = this.buffer;
                int i4 = this.position;
                bArr2[i4 + 1] = (byte) cCharAt2;
                bArr2[i4] = (byte) (cCharAt2 >>> '\b');
                this.position = i4 + 2;
                i2++;
            }
        }

        private final void writeDouble(double d) {
            writeLong(java.lang.Double.doubleToLongBits(d));
        }

        private final void writeFloat(float f) {
            int iFloatToIntBits = java.lang.Float.floatToIntBits(f);
            byte[] bArr = this.buffer;
            int i = this.position;
            bArr[i + 3] = (byte) iFloatToIntBits;
            bArr[i + 2] = (byte) (iFloatToIntBits >>> 8);
            bArr[i + 1] = (byte) (iFloatToIntBits >>> 16);
            bArr[i] = (byte) (iFloatToIntBits >>> 24);
            this.position = i + 4;
        }

        private final void writeLong(long j) {
            byte[] bArr = this.buffer;
            int i = this.position;
            bArr[i + 7] = (byte) j;
            bArr[i + 6] = (byte) (j >>> 8);
            bArr[i + 5] = (byte) (j >>> 16);
            bArr[i + 4] = (byte) (j >>> 24);
            bArr[i + 3] = (byte) (j >>> 32);
            bArr[i + 2] = (byte) (j >>> 40);
            bArr[i + 1] = (byte) (j >>> 48);
            bArr[i] = (byte) (j >>> 56);
            this.position = i + 8;
        }

        private final void writeVarInt(int i) {
            writeUInt((i >> 31) ^ (i << 1));
        }

        private final void writeUInt(int i) {
            while ((i & (-128)) != 0) {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                bArr[i2] = (byte) ((i & kotlinx.coroutines.scheduling.WorkQueueKt.MASK) | 128);
                this.position = i2 + 1;
                i >>>= 7;
            }
            byte[] bArr2 = this.buffer;
            int i3 = this.position;
            bArr2[i3] = (byte) (i & kotlinx.coroutines.scheduling.WorkQueueKt.MASK);
            this.position = i3 + 1;
        }

        private final void ensureCapacity(int i) {
            int i2 = i + this.position;
            byte[] bArr = this.buffer;
            if (i2 - bArr.length > 0) {
                int length = bArr.length << 1;
                if (length < 16384) {
                    length = 16384;
                }
                if (length - i2 >= 0) {
                    i2 = length;
                }
                this.buffer = java.util.Arrays.copyOf(bArr, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List<java.lang.reflect.Method> getBeanMethod(java.lang.String str, java.lang.Class cls) {
        java.util.List<java.lang.reflect.Method> arrayList = methodsCache.get(str);
        if (arrayList == null) {
            arrayList = new java.util.ArrayList<>();
            for (java.lang.reflect.Method method : cls.getMethods()) {
                if (method.getDeclaringClass() != java.lang.Object.class && (method.getModifiers() & 8) == 0) {
                    java.lang.String name = method.getName();
                    if (name.startsWith(METHOD_PREFIX_GET) || name.startsWith(METHOD_PREFIX_IS)) {
                        if (method.getAnnotation(com.alibaba.fastjson.annotation.JSONField.class) != null) {
                            throw new java.lang.UnsupportedOperationException("getBeanMethod JSONField Annotation Not Handled, Use toJSON");
                        }
                        arrayList.add(method);
                    }
                }
            }
            methodsCache.put(str, arrayList);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final java.util.List<java.lang.reflect.Field> getBeanFields(java.lang.String str, java.lang.Class cls) {
        java.util.List<java.lang.reflect.Field> arrayList = fieldsCache.get(str);
        if (arrayList == null) {
            java.lang.reflect.Field[] fields = cls.getFields();
            arrayList = new java.util.ArrayList<>(fields.length);
            for (java.lang.reflect.Field field : fields) {
                if ((field.getModifiers() & 8) == 0) {
                    if (field.getAnnotation(com.alibaba.fastjson.annotation.JSONField.class) != null) {
                        throw new java.lang.UnsupportedOperationException("getBeanMethod JSONField Annotation Not Handled, Use toJSON");
                    }
                    arrayList.add(field);
                }
            }
            fieldsCache.put(str, arrayList);
        }
        return arrayList;
    }
}
