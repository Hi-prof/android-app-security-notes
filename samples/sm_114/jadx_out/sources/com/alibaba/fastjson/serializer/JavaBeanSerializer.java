package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public class JavaBeanSerializer extends com.alibaba.fastjson.serializer.SerializeFilterable implements com.alibaba.fastjson.serializer.ObjectSerializer {
    protected final com.alibaba.fastjson.serializer.SerializeBeanInfo beanInfo;
    protected final com.alibaba.fastjson.serializer.FieldSerializer[] getters;
    private volatile transient long[] hashArray;
    private volatile transient short[] hashArrayMapping;
    protected final com.alibaba.fastjson.serializer.FieldSerializer[] sortedGetters;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JavaBeanSerializer(java.lang.Class<?> cls) {
        this(cls, (java.util.Map<java.lang.String, java.lang.String>) null);
    }

    public JavaBeanSerializer(java.lang.Class<?> cls, java.lang.String... strArr) {
        this(cls, createAliasMap(strArr));
    }

    static java.util.Map<java.lang.String, java.lang.String> createAliasMap(java.lang.String... strArr) {
        java.util.HashMap map = new java.util.HashMap();
        for (java.lang.String str : strArr) {
            map.put(str, str);
        }
        return map;
    }

    public com.alibaba.fastjson.annotation.JSONType getJSONType() {
        return this.beanInfo.jsonType;
    }

    public java.lang.Class<?> getType() {
        return this.beanInfo.beanType;
    }

    public JavaBeanSerializer(java.lang.Class<?> cls, java.util.Map<java.lang.String, java.lang.String> map) {
        this(com.alibaba.fastjson.util.TypeUtils.buildBeanInfo(cls, map, null));
    }

    public JavaBeanSerializer(com.alibaba.fastjson.serializer.SerializeBeanInfo serializeBeanInfo) {
        this.beanInfo = serializeBeanInfo;
        this.sortedGetters = new com.alibaba.fastjson.serializer.FieldSerializer[serializeBeanInfo.sortedFields.length];
        int i = 0;
        while (true) {
            com.alibaba.fastjson.serializer.FieldSerializer[] fieldSerializerArr = this.sortedGetters;
            if (i >= fieldSerializerArr.length) {
                break;
            }
            fieldSerializerArr[i] = new com.alibaba.fastjson.serializer.FieldSerializer(serializeBeanInfo.beanType, serializeBeanInfo.sortedFields[i]);
            i++;
        }
        if (serializeBeanInfo.fields == serializeBeanInfo.sortedFields) {
            this.getters = this.sortedGetters;
        } else {
            this.getters = new com.alibaba.fastjson.serializer.FieldSerializer[serializeBeanInfo.fields.length];
            for (int i2 = 0; i2 < this.getters.length; i2++) {
                com.alibaba.fastjson.serializer.FieldSerializer fieldSerializer = getFieldSerializer(serializeBeanInfo.fields[i2].name);
                if (fieldSerializer != null) {
                    this.getters[i2] = fieldSerializer;
                } else {
                    com.alibaba.fastjson.serializer.FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                    java.lang.System.arraycopy(fieldSerializerArr2, 0, this.getters, 0, fieldSerializerArr2.length);
                    break;
                }
            }
        }
        if (serializeBeanInfo.jsonType != null) {
            for (java.lang.Class<? extends com.alibaba.fastjson.serializer.SerializeFilter> cls : serializeBeanInfo.jsonType.serialzeFilters()) {
                try {
                    addFilter(cls.getConstructor(null).newInstance(null));
                } catch (java.lang.Exception unused) {
                }
            }
        }
    }

    public void writeDirectNonContext(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i) throws java.lang.Throwable {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeAsArray(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i) throws java.lang.Throwable {
        write(jSONSerializer, obj, obj2, type, i);
    }

    public void writeAsArrayNonContext(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i) throws java.lang.Throwable {
        write(jSONSerializer, obj, obj2, type, i);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i) throws java.lang.Throwable {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    public void writeNoneASM(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i) throws java.lang.Throwable {
        write(jSONSerializer, obj, obj2, type, i, false);
    }

    /* JADX WARN: Code duplicated, block: B:245:0x034b  */
    /* JADX WARN: Code duplicated, block: B:247:0x034f A[Catch: Exception -> 0x04b3, all -> 0x04c3, TryCatch #2 {all -> 0x04c3, blocks: (B:196:0x02be, B:198:0x02c2, B:200:0x02c6, B:203:0x02d1, B:205:0x02d5, B:207:0x02d9, B:210:0x02e4, B:212:0x02e8, B:214:0x02ec, B:217:0x02f7, B:219:0x02fb, B:221:0x02ff, B:224:0x030d, B:226:0x0311, B:228:0x0315, B:231:0x0323, B:233:0x0327, B:235:0x032b, B:238:0x0339, B:240:0x033d, B:242:0x0341, B:247:0x034f, B:249:0x0353, B:251:0x0357, B:254:0x0362, B:256:0x036f, B:260:0x0379, B:262:0x037f, B:319:0x0444, B:321:0x0448, B:323:0x044c, B:326:0x0455, B:328:0x045d, B:329:0x0465, B:331:0x046b, B:267:0x038a, B:268:0x038d, B:270:0x0393, B:272:0x039f, B:279:0x03b4, B:284:0x03be, B:288:0x03d0, B:291:0x03da, B:294:0x03e4, B:296:0x03ec, B:297:0x03f9, B:299:0x0402, B:301:0x0409, B:302:0x040d, B:304:0x0414, B:305:0x0418, B:306:0x041c, B:308:0x0421, B:309:0x0425, B:310:0x0429, B:312:0x042d, B:314:0x0431, B:317:0x043d, B:318:0x0441, B:285:0x03c8, B:335:0x0476, B:349:0x049e, B:351:0x04a4, B:353:0x04ac, B:358:0x04bb), top: B:401:0x02be }] */
    /* JADX WARN: Code duplicated, block: B:249:0x0353 A[Catch: Exception -> 0x04b3, all -> 0x04c3, TryCatch #2 {all -> 0x04c3, blocks: (B:196:0x02be, B:198:0x02c2, B:200:0x02c6, B:203:0x02d1, B:205:0x02d5, B:207:0x02d9, B:210:0x02e4, B:212:0x02e8, B:214:0x02ec, B:217:0x02f7, B:219:0x02fb, B:221:0x02ff, B:224:0x030d, B:226:0x0311, B:228:0x0315, B:231:0x0323, B:233:0x0327, B:235:0x032b, B:238:0x0339, B:240:0x033d, B:242:0x0341, B:247:0x034f, B:249:0x0353, B:251:0x0357, B:254:0x0362, B:256:0x036f, B:260:0x0379, B:262:0x037f, B:319:0x0444, B:321:0x0448, B:323:0x044c, B:326:0x0455, B:328:0x045d, B:329:0x0465, B:331:0x046b, B:267:0x038a, B:268:0x038d, B:270:0x0393, B:272:0x039f, B:279:0x03b4, B:284:0x03be, B:288:0x03d0, B:291:0x03da, B:294:0x03e4, B:296:0x03ec, B:297:0x03f9, B:299:0x0402, B:301:0x0409, B:302:0x040d, B:304:0x0414, B:305:0x0418, B:306:0x041c, B:308:0x0421, B:309:0x0425, B:310:0x0429, B:312:0x042d, B:314:0x0431, B:317:0x043d, B:318:0x0441, B:285:0x03c8, B:335:0x0476, B:349:0x049e, B:351:0x04a4, B:353:0x04ac, B:358:0x04bb), top: B:401:0x02be }] */
    /* JADX WARN: Code duplicated, block: B:256:0x036f A[Catch: Exception -> 0x04b3, all -> 0x04c3, TryCatch #2 {all -> 0x04c3, blocks: (B:196:0x02be, B:198:0x02c2, B:200:0x02c6, B:203:0x02d1, B:205:0x02d5, B:207:0x02d9, B:210:0x02e4, B:212:0x02e8, B:214:0x02ec, B:217:0x02f7, B:219:0x02fb, B:221:0x02ff, B:224:0x030d, B:226:0x0311, B:228:0x0315, B:231:0x0323, B:233:0x0327, B:235:0x032b, B:238:0x0339, B:240:0x033d, B:242:0x0341, B:247:0x034f, B:249:0x0353, B:251:0x0357, B:254:0x0362, B:256:0x036f, B:260:0x0379, B:262:0x037f, B:319:0x0444, B:321:0x0448, B:323:0x044c, B:326:0x0455, B:328:0x045d, B:329:0x0465, B:331:0x046b, B:267:0x038a, B:268:0x038d, B:270:0x0393, B:272:0x039f, B:279:0x03b4, B:284:0x03be, B:288:0x03d0, B:291:0x03da, B:294:0x03e4, B:296:0x03ec, B:297:0x03f9, B:299:0x0402, B:301:0x0409, B:302:0x040d, B:304:0x0414, B:305:0x0418, B:306:0x041c, B:308:0x0421, B:309:0x0425, B:310:0x0429, B:312:0x042d, B:314:0x0431, B:317:0x043d, B:318:0x0441, B:285:0x03c8, B:335:0x0476, B:349:0x049e, B:351:0x04a4, B:353:0x04ac, B:358:0x04bb), top: B:401:0x02be }] */
    /* JADX WARN: Code duplicated, block: B:257:0x0373  */
    /* JADX WARN: Code duplicated, block: B:259:0x0377 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:260:0x0379 A[Catch: Exception -> 0x04b3, all -> 0x04c3, TryCatch #2 {all -> 0x04c3, blocks: (B:196:0x02be, B:198:0x02c2, B:200:0x02c6, B:203:0x02d1, B:205:0x02d5, B:207:0x02d9, B:210:0x02e4, B:212:0x02e8, B:214:0x02ec, B:217:0x02f7, B:219:0x02fb, B:221:0x02ff, B:224:0x030d, B:226:0x0311, B:228:0x0315, B:231:0x0323, B:233:0x0327, B:235:0x032b, B:238:0x0339, B:240:0x033d, B:242:0x0341, B:247:0x034f, B:249:0x0353, B:251:0x0357, B:254:0x0362, B:256:0x036f, B:260:0x0379, B:262:0x037f, B:319:0x0444, B:321:0x0448, B:323:0x044c, B:326:0x0455, B:328:0x045d, B:329:0x0465, B:331:0x046b, B:267:0x038a, B:268:0x038d, B:270:0x0393, B:272:0x039f, B:279:0x03b4, B:284:0x03be, B:288:0x03d0, B:291:0x03da, B:294:0x03e4, B:296:0x03ec, B:297:0x03f9, B:299:0x0402, B:301:0x0409, B:302:0x040d, B:304:0x0414, B:305:0x0418, B:306:0x041c, B:308:0x0421, B:309:0x0425, B:310:0x0429, B:312:0x042d, B:314:0x0431, B:317:0x043d, B:318:0x0441, B:285:0x03c8, B:335:0x0476, B:349:0x049e, B:351:0x04a4, B:353:0x04ac, B:358:0x04bb), top: B:401:0x02be }] */
    /* JADX WARN: Code duplicated, block: B:261:0x037e  */
    /* JADX WARN: Code duplicated, block: B:264:0x0385  */
    /* JADX WARN: Code duplicated, block: B:266:0x0388 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:267:0x038a A[Catch: Exception -> 0x04b3, all -> 0x04c3, TryCatch #2 {all -> 0x04c3, blocks: (B:196:0x02be, B:198:0x02c2, B:200:0x02c6, B:203:0x02d1, B:205:0x02d5, B:207:0x02d9, B:210:0x02e4, B:212:0x02e8, B:214:0x02ec, B:217:0x02f7, B:219:0x02fb, B:221:0x02ff, B:224:0x030d, B:226:0x0311, B:228:0x0315, B:231:0x0323, B:233:0x0327, B:235:0x032b, B:238:0x0339, B:240:0x033d, B:242:0x0341, B:247:0x034f, B:249:0x0353, B:251:0x0357, B:254:0x0362, B:256:0x036f, B:260:0x0379, B:262:0x037f, B:319:0x0444, B:321:0x0448, B:323:0x044c, B:326:0x0455, B:328:0x045d, B:329:0x0465, B:331:0x046b, B:267:0x038a, B:268:0x038d, B:270:0x0393, B:272:0x039f, B:279:0x03b4, B:284:0x03be, B:288:0x03d0, B:291:0x03da, B:294:0x03e4, B:296:0x03ec, B:297:0x03f9, B:299:0x0402, B:301:0x0409, B:302:0x040d, B:304:0x0414, B:305:0x0418, B:306:0x041c, B:308:0x0421, B:309:0x0425, B:310:0x0429, B:312:0x042d, B:314:0x0431, B:317:0x043d, B:318:0x0441, B:285:0x03c8, B:335:0x0476, B:349:0x049e, B:351:0x04a4, B:353:0x04ac, B:358:0x04bb), top: B:401:0x02be }] */
    /* JADX WARN: Code duplicated, block: B:269:0x0391 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:270:0x0393 A[Catch: Exception -> 0x04b3, all -> 0x04c3, TryCatch #2 {all -> 0x04c3, blocks: (B:196:0x02be, B:198:0x02c2, B:200:0x02c6, B:203:0x02d1, B:205:0x02d5, B:207:0x02d9, B:210:0x02e4, B:212:0x02e8, B:214:0x02ec, B:217:0x02f7, B:219:0x02fb, B:221:0x02ff, B:224:0x030d, B:226:0x0311, B:228:0x0315, B:231:0x0323, B:233:0x0327, B:235:0x032b, B:238:0x0339, B:240:0x033d, B:242:0x0341, B:247:0x034f, B:249:0x0353, B:251:0x0357, B:254:0x0362, B:256:0x036f, B:260:0x0379, B:262:0x037f, B:319:0x0444, B:321:0x0448, B:323:0x044c, B:326:0x0455, B:328:0x045d, B:329:0x0465, B:331:0x046b, B:267:0x038a, B:268:0x038d, B:270:0x0393, B:272:0x039f, B:279:0x03b4, B:284:0x03be, B:288:0x03d0, B:291:0x03da, B:294:0x03e4, B:296:0x03ec, B:297:0x03f9, B:299:0x0402, B:301:0x0409, B:302:0x040d, B:304:0x0414, B:305:0x0418, B:306:0x041c, B:308:0x0421, B:309:0x0425, B:310:0x0429, B:312:0x042d, B:314:0x0431, B:317:0x043d, B:318:0x0441, B:285:0x03c8, B:335:0x0476, B:349:0x049e, B:351:0x04a4, B:353:0x04ac, B:358:0x04bb), top: B:401:0x02be }] */
    /* JADX WARN: Code duplicated, block: B:272:0x039f A[Catch: Exception -> 0x04b3, all -> 0x04c3, TryCatch #2 {all -> 0x04c3, blocks: (B:196:0x02be, B:198:0x02c2, B:200:0x02c6, B:203:0x02d1, B:205:0x02d5, B:207:0x02d9, B:210:0x02e4, B:212:0x02e8, B:214:0x02ec, B:217:0x02f7, B:219:0x02fb, B:221:0x02ff, B:224:0x030d, B:226:0x0311, B:228:0x0315, B:231:0x0323, B:233:0x0327, B:235:0x032b, B:238:0x0339, B:240:0x033d, B:242:0x0341, B:247:0x034f, B:249:0x0353, B:251:0x0357, B:254:0x0362, B:256:0x036f, B:260:0x0379, B:262:0x037f, B:319:0x0444, B:321:0x0448, B:323:0x044c, B:326:0x0455, B:328:0x045d, B:329:0x0465, B:331:0x046b, B:267:0x038a, B:268:0x038d, B:270:0x0393, B:272:0x039f, B:279:0x03b4, B:284:0x03be, B:288:0x03d0, B:291:0x03da, B:294:0x03e4, B:296:0x03ec, B:297:0x03f9, B:299:0x0402, B:301:0x0409, B:302:0x040d, B:304:0x0414, B:305:0x0418, B:306:0x041c, B:308:0x0421, B:309:0x0425, B:310:0x0429, B:312:0x042d, B:314:0x0431, B:317:0x043d, B:318:0x0441, B:285:0x03c8, B:335:0x0476, B:349:0x049e, B:351:0x04a4, B:353:0x04ac, B:358:0x04bb), top: B:401:0x02be }] */
    /* JADX WARN: Code duplicated, block: B:274:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:279:0x03b4 A[Catch: Exception -> 0x04b3, all -> 0x04c3, TryCatch #2 {all -> 0x04c3, blocks: (B:196:0x02be, B:198:0x02c2, B:200:0x02c6, B:203:0x02d1, B:205:0x02d5, B:207:0x02d9, B:210:0x02e4, B:212:0x02e8, B:214:0x02ec, B:217:0x02f7, B:219:0x02fb, B:221:0x02ff, B:224:0x030d, B:226:0x0311, B:228:0x0315, B:231:0x0323, B:233:0x0327, B:235:0x032b, B:238:0x0339, B:240:0x033d, B:242:0x0341, B:247:0x034f, B:249:0x0353, B:251:0x0357, B:254:0x0362, B:256:0x036f, B:260:0x0379, B:262:0x037f, B:319:0x0444, B:321:0x0448, B:323:0x044c, B:326:0x0455, B:328:0x045d, B:329:0x0465, B:331:0x046b, B:267:0x038a, B:268:0x038d, B:270:0x0393, B:272:0x039f, B:279:0x03b4, B:284:0x03be, B:288:0x03d0, B:291:0x03da, B:294:0x03e4, B:296:0x03ec, B:297:0x03f9, B:299:0x0402, B:301:0x0409, B:302:0x040d, B:304:0x0414, B:305:0x0418, B:306:0x041c, B:308:0x0421, B:309:0x0425, B:310:0x0429, B:312:0x042d, B:314:0x0431, B:317:0x043d, B:318:0x0441, B:285:0x03c8, B:335:0x0476, B:349:0x049e, B:351:0x04a4, B:353:0x04ac, B:358:0x04bb), top: B:401:0x02be }] */
    /* JADX WARN: Code duplicated, block: B:284:0x03be A[Catch: Exception -> 0x04b3, all -> 0x04c3, TryCatch #2 {all -> 0x04c3, blocks: (B:196:0x02be, B:198:0x02c2, B:200:0x02c6, B:203:0x02d1, B:205:0x02d5, B:207:0x02d9, B:210:0x02e4, B:212:0x02e8, B:214:0x02ec, B:217:0x02f7, B:219:0x02fb, B:221:0x02ff, B:224:0x030d, B:226:0x0311, B:228:0x0315, B:231:0x0323, B:233:0x0327, B:235:0x032b, B:238:0x0339, B:240:0x033d, B:242:0x0341, B:247:0x034f, B:249:0x0353, B:251:0x0357, B:254:0x0362, B:256:0x036f, B:260:0x0379, B:262:0x037f, B:319:0x0444, B:321:0x0448, B:323:0x044c, B:326:0x0455, B:328:0x045d, B:329:0x0465, B:331:0x046b, B:267:0x038a, B:268:0x038d, B:270:0x0393, B:272:0x039f, B:279:0x03b4, B:284:0x03be, B:288:0x03d0, B:291:0x03da, B:294:0x03e4, B:296:0x03ec, B:297:0x03f9, B:299:0x0402, B:301:0x0409, B:302:0x040d, B:304:0x0414, B:305:0x0418, B:306:0x041c, B:308:0x0421, B:309:0x0425, B:310:0x0429, B:312:0x042d, B:314:0x0431, B:317:0x043d, B:318:0x0441, B:285:0x03c8, B:335:0x0476, B:349:0x049e, B:351:0x04a4, B:353:0x04ac, B:358:0x04bb), top: B:401:0x02be }] */
    /* JADX WARN: Code duplicated, block: B:285:0x03c8 A[Catch: Exception -> 0x04b3, all -> 0x04c3, TryCatch #2 {all -> 0x04c3, blocks: (B:196:0x02be, B:198:0x02c2, B:200:0x02c6, B:203:0x02d1, B:205:0x02d5, B:207:0x02d9, B:210:0x02e4, B:212:0x02e8, B:214:0x02ec, B:217:0x02f7, B:219:0x02fb, B:221:0x02ff, B:224:0x030d, B:226:0x0311, B:228:0x0315, B:231:0x0323, B:233:0x0327, B:235:0x032b, B:238:0x0339, B:240:0x033d, B:242:0x0341, B:247:0x034f, B:249:0x0353, B:251:0x0357, B:254:0x0362, B:256:0x036f, B:260:0x0379, B:262:0x037f, B:319:0x0444, B:321:0x0448, B:323:0x044c, B:326:0x0455, B:328:0x045d, B:329:0x0465, B:331:0x046b, B:267:0x038a, B:268:0x038d, B:270:0x0393, B:272:0x039f, B:279:0x03b4, B:284:0x03be, B:288:0x03d0, B:291:0x03da, B:294:0x03e4, B:296:0x03ec, B:297:0x03f9, B:299:0x0402, B:301:0x0409, B:302:0x040d, B:304:0x0414, B:305:0x0418, B:306:0x041c, B:308:0x0421, B:309:0x0425, B:310:0x0429, B:312:0x042d, B:314:0x0431, B:317:0x043d, B:318:0x0441, B:285:0x03c8, B:335:0x0476, B:349:0x049e, B:351:0x04a4, B:353:0x04ac, B:358:0x04bb), top: B:401:0x02be }] */
    /* JADX WARN: Code duplicated, block: B:286:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:288:0x03d0 A[Catch: Exception -> 0x04b3, all -> 0x04c3, TryCatch #2 {all -> 0x04c3, blocks: (B:196:0x02be, B:198:0x02c2, B:200:0x02c6, B:203:0x02d1, B:205:0x02d5, B:207:0x02d9, B:210:0x02e4, B:212:0x02e8, B:214:0x02ec, B:217:0x02f7, B:219:0x02fb, B:221:0x02ff, B:224:0x030d, B:226:0x0311, B:228:0x0315, B:231:0x0323, B:233:0x0327, B:235:0x032b, B:238:0x0339, B:240:0x033d, B:242:0x0341, B:247:0x034f, B:249:0x0353, B:251:0x0357, B:254:0x0362, B:256:0x036f, B:260:0x0379, B:262:0x037f, B:319:0x0444, B:321:0x0448, B:323:0x044c, B:326:0x0455, B:328:0x045d, B:329:0x0465, B:331:0x046b, B:267:0x038a, B:268:0x038d, B:270:0x0393, B:272:0x039f, B:279:0x03b4, B:284:0x03be, B:288:0x03d0, B:291:0x03da, B:294:0x03e4, B:296:0x03ec, B:297:0x03f9, B:299:0x0402, B:301:0x0409, B:302:0x040d, B:304:0x0414, B:305:0x0418, B:306:0x041c, B:308:0x0421, B:309:0x0425, B:310:0x0429, B:312:0x042d, B:314:0x0431, B:317:0x043d, B:318:0x0441, B:285:0x03c8, B:335:0x0476, B:349:0x049e, B:351:0x04a4, B:353:0x04ac, B:358:0x04bb), top: B:401:0x02be }] */
    /* JADX WARN: Code duplicated, block: B:290:0x03d8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:310:0x0429 A[Catch: Exception -> 0x04b3, all -> 0x04c3, TryCatch #2 {all -> 0x04c3, blocks: (B:196:0x02be, B:198:0x02c2, B:200:0x02c6, B:203:0x02d1, B:205:0x02d5, B:207:0x02d9, B:210:0x02e4, B:212:0x02e8, B:214:0x02ec, B:217:0x02f7, B:219:0x02fb, B:221:0x02ff, B:224:0x030d, B:226:0x0311, B:228:0x0315, B:231:0x0323, B:233:0x0327, B:235:0x032b, B:238:0x0339, B:240:0x033d, B:242:0x0341, B:247:0x034f, B:249:0x0353, B:251:0x0357, B:254:0x0362, B:256:0x036f, B:260:0x0379, B:262:0x037f, B:319:0x0444, B:321:0x0448, B:323:0x044c, B:326:0x0455, B:328:0x045d, B:329:0x0465, B:331:0x046b, B:267:0x038a, B:268:0x038d, B:270:0x0393, B:272:0x039f, B:279:0x03b4, B:284:0x03be, B:288:0x03d0, B:291:0x03da, B:294:0x03e4, B:296:0x03ec, B:297:0x03f9, B:299:0x0402, B:301:0x0409, B:302:0x040d, B:304:0x0414, B:305:0x0418, B:306:0x041c, B:308:0x0421, B:309:0x0425, B:310:0x0429, B:312:0x042d, B:314:0x0431, B:317:0x043d, B:318:0x0441, B:285:0x03c8, B:335:0x0476, B:349:0x049e, B:351:0x04a4, B:353:0x04ac, B:358:0x04bb), top: B:401:0x02be }] */
    /* JADX WARN: Code duplicated, block: B:312:0x042d A[Catch: Exception -> 0x04b3, all -> 0x04c3, TryCatch #2 {all -> 0x04c3, blocks: (B:196:0x02be, B:198:0x02c2, B:200:0x02c6, B:203:0x02d1, B:205:0x02d5, B:207:0x02d9, B:210:0x02e4, B:212:0x02e8, B:214:0x02ec, B:217:0x02f7, B:219:0x02fb, B:221:0x02ff, B:224:0x030d, B:226:0x0311, B:228:0x0315, B:231:0x0323, B:233:0x0327, B:235:0x032b, B:238:0x0339, B:240:0x033d, B:242:0x0341, B:247:0x034f, B:249:0x0353, B:251:0x0357, B:254:0x0362, B:256:0x036f, B:260:0x0379, B:262:0x037f, B:319:0x0444, B:321:0x0448, B:323:0x044c, B:326:0x0455, B:328:0x045d, B:329:0x0465, B:331:0x046b, B:267:0x038a, B:268:0x038d, B:270:0x0393, B:272:0x039f, B:279:0x03b4, B:284:0x03be, B:288:0x03d0, B:291:0x03da, B:294:0x03e4, B:296:0x03ec, B:297:0x03f9, B:299:0x0402, B:301:0x0409, B:302:0x040d, B:304:0x0414, B:305:0x0418, B:306:0x041c, B:308:0x0421, B:309:0x0425, B:310:0x0429, B:312:0x042d, B:314:0x0431, B:317:0x043d, B:318:0x0441, B:285:0x03c8, B:335:0x0476, B:349:0x049e, B:351:0x04a4, B:353:0x04ac, B:358:0x04bb), top: B:401:0x02be }] */
    /* JADX WARN: Code duplicated, block: B:318:0x0441 A[Catch: Exception -> 0x04b3, all -> 0x04c3, TryCatch #2 {all -> 0x04c3, blocks: (B:196:0x02be, B:198:0x02c2, B:200:0x02c6, B:203:0x02d1, B:205:0x02d5, B:207:0x02d9, B:210:0x02e4, B:212:0x02e8, B:214:0x02ec, B:217:0x02f7, B:219:0x02fb, B:221:0x02ff, B:224:0x030d, B:226:0x0311, B:228:0x0315, B:231:0x0323, B:233:0x0327, B:235:0x032b, B:238:0x0339, B:240:0x033d, B:242:0x0341, B:247:0x034f, B:249:0x0353, B:251:0x0357, B:254:0x0362, B:256:0x036f, B:260:0x0379, B:262:0x037f, B:319:0x0444, B:321:0x0448, B:323:0x044c, B:326:0x0455, B:328:0x045d, B:329:0x0465, B:331:0x046b, B:267:0x038a, B:268:0x038d, B:270:0x0393, B:272:0x039f, B:279:0x03b4, B:284:0x03be, B:288:0x03d0, B:291:0x03da, B:294:0x03e4, B:296:0x03ec, B:297:0x03f9, B:299:0x0402, B:301:0x0409, B:302:0x040d, B:304:0x0414, B:305:0x0418, B:306:0x041c, B:308:0x0421, B:309:0x0425, B:310:0x0429, B:312:0x042d, B:314:0x0431, B:317:0x043d, B:318:0x0441, B:285:0x03c8, B:335:0x0476, B:349:0x049e, B:351:0x04a4, B:353:0x04ac, B:358:0x04bb), top: B:401:0x02be }] */
    /* JADX WARN: Code duplicated, block: B:321:0x0448 A[Catch: Exception -> 0x04b3, all -> 0x04c3, TryCatch #2 {all -> 0x04c3, blocks: (B:196:0x02be, B:198:0x02c2, B:200:0x02c6, B:203:0x02d1, B:205:0x02d5, B:207:0x02d9, B:210:0x02e4, B:212:0x02e8, B:214:0x02ec, B:217:0x02f7, B:219:0x02fb, B:221:0x02ff, B:224:0x030d, B:226:0x0311, B:228:0x0315, B:231:0x0323, B:233:0x0327, B:235:0x032b, B:238:0x0339, B:240:0x033d, B:242:0x0341, B:247:0x034f, B:249:0x0353, B:251:0x0357, B:254:0x0362, B:256:0x036f, B:260:0x0379, B:262:0x037f, B:319:0x0444, B:321:0x0448, B:323:0x044c, B:326:0x0455, B:328:0x045d, B:329:0x0465, B:331:0x046b, B:267:0x038a, B:268:0x038d, B:270:0x0393, B:272:0x039f, B:279:0x03b4, B:284:0x03be, B:288:0x03d0, B:291:0x03da, B:294:0x03e4, B:296:0x03ec, B:297:0x03f9, B:299:0x0402, B:301:0x0409, B:302:0x040d, B:304:0x0414, B:305:0x0418, B:306:0x041c, B:308:0x0421, B:309:0x0425, B:310:0x0429, B:312:0x042d, B:314:0x0431, B:317:0x043d, B:318:0x0441, B:285:0x03c8, B:335:0x0476, B:349:0x049e, B:351:0x04a4, B:353:0x04ac, B:358:0x04bb), top: B:401:0x02be }] */
    /* JADX WARN: Code duplicated, block: B:333:0x0471  */
    /* JADX WARN: Code duplicated, block: B:373:0x04da A[Catch: all -> 0x04d0, TRY_LEAVE, TryCatch #0 {all -> 0x04d0, blocks: (B:24:0x0051, B:25:0x0054, B:27:0x0057, B:29:0x005f, B:30:0x0065, B:32:0x0073, B:34:0x007a, B:45:0x009d, B:49:0x00ac, B:51:0x00bd, B:59:0x00e9, B:67:0x00f9, B:75:0x0111, B:92:0x013f, B:95:0x014b, B:100:0x0164, B:102:0x0172, B:104:0x0181, B:106:0x018b, B:189:0x02a0, B:191:0x02ac, B:373:0x04da, B:376:0x04fa, B:384:0x054c, B:386:0x0552, B:387:0x056a, B:389:0x056e, B:394:0x0578, B:395:0x057d, B:378:0x0511, B:380:0x0515, B:382:0x051b, B:383:0x0536, B:109:0x0195, B:111:0x01a3, B:113:0x01a7, B:116:0x01b0, B:118:0x01b4, B:119:0x01ba, B:121:0x01c0, B:123:0x01c7, B:126:0x01d1, B:128:0x01df, B:130:0x01e3, B:133:0x01ed, B:136:0x01f4, B:138:0x01fa, B:141:0x0202, B:143:0x020a, B:145:0x0218, B:147:0x021c, B:150:0x0226, B:152:0x022a, B:153:0x0230, B:155:0x0236, B:157:0x023d, B:158:0x0242, B:160:0x024a, B:162:0x0258, B:164:0x025c, B:167:0x0266, B:169:0x026a, B:170:0x026d, B:172:0x0273, B:174:0x027a, B:176:0x027f, B:178:0x0283, B:180:0x028d, B:80:0x011c, B:36:0x0080, B:38:0x0086, B:40:0x008a, B:43:0x0092), top: B:398:0x004f }] */
    /* JADX WARN: Code duplicated, block: B:376:0x04fa A[Catch: all -> 0x04d0, TRY_ENTER, TryCatch #0 {all -> 0x04d0, blocks: (B:24:0x0051, B:25:0x0054, B:27:0x0057, B:29:0x005f, B:30:0x0065, B:32:0x0073, B:34:0x007a, B:45:0x009d, B:49:0x00ac, B:51:0x00bd, B:59:0x00e9, B:67:0x00f9, B:75:0x0111, B:92:0x013f, B:95:0x014b, B:100:0x0164, B:102:0x0172, B:104:0x0181, B:106:0x018b, B:189:0x02a0, B:191:0x02ac, B:373:0x04da, B:376:0x04fa, B:384:0x054c, B:386:0x0552, B:387:0x056a, B:389:0x056e, B:394:0x0578, B:395:0x057d, B:378:0x0511, B:380:0x0515, B:382:0x051b, B:383:0x0536, B:109:0x0195, B:111:0x01a3, B:113:0x01a7, B:116:0x01b0, B:118:0x01b4, B:119:0x01ba, B:121:0x01c0, B:123:0x01c7, B:126:0x01d1, B:128:0x01df, B:130:0x01e3, B:133:0x01ed, B:136:0x01f4, B:138:0x01fa, B:141:0x0202, B:143:0x020a, B:145:0x0218, B:147:0x021c, B:150:0x0226, B:152:0x022a, B:153:0x0230, B:155:0x0236, B:157:0x023d, B:158:0x0242, B:160:0x024a, B:162:0x0258, B:164:0x025c, B:167:0x0266, B:169:0x026a, B:170:0x026d, B:172:0x0273, B:174:0x027a, B:176:0x027f, B:178:0x0283, B:180:0x028d, B:80:0x011c, B:36:0x0080, B:38:0x0086, B:40:0x008a, B:43:0x0092), top: B:398:0x004f }] */
    /* JADX WARN: Code duplicated, block: B:377:0x050f  */
    /* JADX WARN: Code duplicated, block: B:378:0x0511 A[Catch: all -> 0x04d0, TryCatch #0 {all -> 0x04d0, blocks: (B:24:0x0051, B:25:0x0054, B:27:0x0057, B:29:0x005f, B:30:0x0065, B:32:0x0073, B:34:0x007a, B:45:0x009d, B:49:0x00ac, B:51:0x00bd, B:59:0x00e9, B:67:0x00f9, B:75:0x0111, B:92:0x013f, B:95:0x014b, B:100:0x0164, B:102:0x0172, B:104:0x0181, B:106:0x018b, B:189:0x02a0, B:191:0x02ac, B:373:0x04da, B:376:0x04fa, B:384:0x054c, B:386:0x0552, B:387:0x056a, B:389:0x056e, B:394:0x0578, B:395:0x057d, B:378:0x0511, B:380:0x0515, B:382:0x051b, B:383:0x0536, B:109:0x0195, B:111:0x01a3, B:113:0x01a7, B:116:0x01b0, B:118:0x01b4, B:119:0x01ba, B:121:0x01c0, B:123:0x01c7, B:126:0x01d1, B:128:0x01df, B:130:0x01e3, B:133:0x01ed, B:136:0x01f4, B:138:0x01fa, B:141:0x0202, B:143:0x020a, B:145:0x0218, B:147:0x021c, B:150:0x0226, B:152:0x022a, B:153:0x0230, B:155:0x0236, B:157:0x023d, B:158:0x0242, B:160:0x024a, B:162:0x0258, B:164:0x025c, B:167:0x0266, B:169:0x026a, B:170:0x026d, B:172:0x0273, B:174:0x027a, B:176:0x027f, B:178:0x0283, B:180:0x028d, B:80:0x011c, B:36:0x0080, B:38:0x0086, B:40:0x008a, B:43:0x0092), top: B:398:0x004f }] */
    /* JADX WARN: Code duplicated, block: B:382:0x051b A[Catch: all -> 0x04d0, TryCatch #0 {all -> 0x04d0, blocks: (B:24:0x0051, B:25:0x0054, B:27:0x0057, B:29:0x005f, B:30:0x0065, B:32:0x0073, B:34:0x007a, B:45:0x009d, B:49:0x00ac, B:51:0x00bd, B:59:0x00e9, B:67:0x00f9, B:75:0x0111, B:92:0x013f, B:95:0x014b, B:100:0x0164, B:102:0x0172, B:104:0x0181, B:106:0x018b, B:189:0x02a0, B:191:0x02ac, B:373:0x04da, B:376:0x04fa, B:384:0x054c, B:386:0x0552, B:387:0x056a, B:389:0x056e, B:394:0x0578, B:395:0x057d, B:378:0x0511, B:380:0x0515, B:382:0x051b, B:383:0x0536, B:109:0x0195, B:111:0x01a3, B:113:0x01a7, B:116:0x01b0, B:118:0x01b4, B:119:0x01ba, B:121:0x01c0, B:123:0x01c7, B:126:0x01d1, B:128:0x01df, B:130:0x01e3, B:133:0x01ed, B:136:0x01f4, B:138:0x01fa, B:141:0x0202, B:143:0x020a, B:145:0x0218, B:147:0x021c, B:150:0x0226, B:152:0x022a, B:153:0x0230, B:155:0x0236, B:157:0x023d, B:158:0x0242, B:160:0x024a, B:162:0x0258, B:164:0x025c, B:167:0x0266, B:169:0x026a, B:170:0x026d, B:172:0x0273, B:174:0x027a, B:176:0x027f, B:178:0x0283, B:180:0x028d, B:80:0x011c, B:36:0x0080, B:38:0x0086, B:40:0x008a, B:43:0x0092), top: B:398:0x004f }] */
    /* JADX WARN: Code duplicated, block: B:383:0x0536 A[Catch: all -> 0x04d0, TryCatch #0 {all -> 0x04d0, blocks: (B:24:0x0051, B:25:0x0054, B:27:0x0057, B:29:0x005f, B:30:0x0065, B:32:0x0073, B:34:0x007a, B:45:0x009d, B:49:0x00ac, B:51:0x00bd, B:59:0x00e9, B:67:0x00f9, B:75:0x0111, B:92:0x013f, B:95:0x014b, B:100:0x0164, B:102:0x0172, B:104:0x0181, B:106:0x018b, B:189:0x02a0, B:191:0x02ac, B:373:0x04da, B:376:0x04fa, B:384:0x054c, B:386:0x0552, B:387:0x056a, B:389:0x056e, B:394:0x0578, B:395:0x057d, B:378:0x0511, B:380:0x0515, B:382:0x051b, B:383:0x0536, B:109:0x0195, B:111:0x01a3, B:113:0x01a7, B:116:0x01b0, B:118:0x01b4, B:119:0x01ba, B:121:0x01c0, B:123:0x01c7, B:126:0x01d1, B:128:0x01df, B:130:0x01e3, B:133:0x01ed, B:136:0x01f4, B:138:0x01fa, B:141:0x0202, B:143:0x020a, B:145:0x0218, B:147:0x021c, B:150:0x0226, B:152:0x022a, B:153:0x0230, B:155:0x0236, B:157:0x023d, B:158:0x0242, B:160:0x024a, B:162:0x0258, B:164:0x025c, B:167:0x0266, B:169:0x026a, B:170:0x026d, B:172:0x0273, B:174:0x027a, B:176:0x027f, B:178:0x0283, B:180:0x028d, B:80:0x011c, B:36:0x0080, B:38:0x0086, B:40:0x008a, B:43:0x0092), top: B:398:0x004f }] */
    /* JADX WARN: Code duplicated, block: B:386:0x0552 A[Catch: all -> 0x04d0, TryCatch #0 {all -> 0x04d0, blocks: (B:24:0x0051, B:25:0x0054, B:27:0x0057, B:29:0x005f, B:30:0x0065, B:32:0x0073, B:34:0x007a, B:45:0x009d, B:49:0x00ac, B:51:0x00bd, B:59:0x00e9, B:67:0x00f9, B:75:0x0111, B:92:0x013f, B:95:0x014b, B:100:0x0164, B:102:0x0172, B:104:0x0181, B:106:0x018b, B:189:0x02a0, B:191:0x02ac, B:373:0x04da, B:376:0x04fa, B:384:0x054c, B:386:0x0552, B:387:0x056a, B:389:0x056e, B:394:0x0578, B:395:0x057d, B:378:0x0511, B:380:0x0515, B:382:0x051b, B:383:0x0536, B:109:0x0195, B:111:0x01a3, B:113:0x01a7, B:116:0x01b0, B:118:0x01b4, B:119:0x01ba, B:121:0x01c0, B:123:0x01c7, B:126:0x01d1, B:128:0x01df, B:130:0x01e3, B:133:0x01ed, B:136:0x01f4, B:138:0x01fa, B:141:0x0202, B:143:0x020a, B:145:0x0218, B:147:0x021c, B:150:0x0226, B:152:0x022a, B:153:0x0230, B:155:0x0236, B:157:0x023d, B:158:0x0242, B:160:0x024a, B:162:0x0258, B:164:0x025c, B:167:0x0266, B:169:0x026a, B:170:0x026d, B:172:0x0273, B:174:0x027a, B:176:0x027f, B:178:0x0283, B:180:0x028d, B:80:0x011c, B:36:0x0080, B:38:0x0086, B:40:0x008a, B:43:0x0092), top: B:398:0x004f }] */
    /* JADX WARN: Code duplicated, block: B:389:0x056e A[Catch: all -> 0x04d0, TryCatch #0 {all -> 0x04d0, blocks: (B:24:0x0051, B:25:0x0054, B:27:0x0057, B:29:0x005f, B:30:0x0065, B:32:0x0073, B:34:0x007a, B:45:0x009d, B:49:0x00ac, B:51:0x00bd, B:59:0x00e9, B:67:0x00f9, B:75:0x0111, B:92:0x013f, B:95:0x014b, B:100:0x0164, B:102:0x0172, B:104:0x0181, B:106:0x018b, B:189:0x02a0, B:191:0x02ac, B:373:0x04da, B:376:0x04fa, B:384:0x054c, B:386:0x0552, B:387:0x056a, B:389:0x056e, B:394:0x0578, B:395:0x057d, B:378:0x0511, B:380:0x0515, B:382:0x051b, B:383:0x0536, B:109:0x0195, B:111:0x01a3, B:113:0x01a7, B:116:0x01b0, B:118:0x01b4, B:119:0x01ba, B:121:0x01c0, B:123:0x01c7, B:126:0x01d1, B:128:0x01df, B:130:0x01e3, B:133:0x01ed, B:136:0x01f4, B:138:0x01fa, B:141:0x0202, B:143:0x020a, B:145:0x0218, B:147:0x021c, B:150:0x0226, B:152:0x022a, B:153:0x0230, B:155:0x0236, B:157:0x023d, B:158:0x0242, B:160:0x024a, B:162:0x0258, B:164:0x025c, B:167:0x0266, B:169:0x026a, B:170:0x026d, B:172:0x0273, B:174:0x027a, B:176:0x027f, B:178:0x0283, B:180:0x028d, B:80:0x011c, B:36:0x0080, B:38:0x0086, B:40:0x008a, B:43:0x0092), top: B:398:0x004f }] */
    /* JADX WARN: Code duplicated, block: B:390:0x0573  */
    /* JADX WARN: Code duplicated, block: B:392:0x0576  */
    /* JADX WARN: Code duplicated, block: B:393:0x0577  */
    /* JADX WARN: Code duplicated, block: B:44:0x009c  */
    /* JADX WARN: Code duplicated, block: B:88:0x0133 A[PHI: r20
  0x0133: PHI (r20v10 com.alibaba.fastjson.serializer.FieldSerializer) = 
  (r20v1 com.alibaba.fastjson.serializer.FieldSerializer)
  (r20v6 com.alibaba.fastjson.serializer.FieldSerializer)
  (r20v6 com.alibaba.fastjson.serializer.FieldSerializer)
  (r20v6 com.alibaba.fastjson.serializer.FieldSerializer)
  (r20v6 com.alibaba.fastjson.serializer.FieldSerializer)
  (r20v6 com.alibaba.fastjson.serializer.FieldSerializer)
  (r20v6 com.alibaba.fastjson.serializer.FieldSerializer)
  (r20v1 com.alibaba.fastjson.serializer.FieldSerializer)
  (r20v1 com.alibaba.fastjson.serializer.FieldSerializer)
  (r20v1 com.alibaba.fastjson.serializer.FieldSerializer)
 binds: [B:71:0x0104, B:87:0x0131, B:182:0x0292, B:166:0x0264, B:149:0x0224, B:132:0x01eb, B:115:0x01af, B:76:0x0115, B:63:0x00f0, B:60:0x00eb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Instruction removed from duplicated block: B:373:0x04da, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:376:0x04fa, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:382:0x051b, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:383:0x0536, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:386:0x0552, please report this as an issue */
    protected void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i, boolean z) throws java.lang.Throwable {
        com.alibaba.fastjson.serializer.FieldSerializer[] fieldSerializerArr;
        com.alibaba.fastjson.serializer.FieldSerializer fieldSerializer;
        java.lang.Exception exc;
        java.lang.String str;
        com.alibaba.fastjson.util.FieldInfo fieldInfo;
        java.lang.Throwable cause;
        java.lang.Exception exc2;
        char c;
        com.alibaba.fastjson.serializer.SerialContext serialContext;
        java.lang.Exception e;
        boolean z2;
        java.lang.Object propertyValueDirect;
        java.lang.Object obj3;
        java.lang.Object objDefaultValue;
        char c2;
        java.lang.reflect.Type type2 = type;
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        if (writeReference(jSONSerializer, obj, i)) {
            return;
        }
        if (serializeWriter.sortField) {
            fieldSerializerArr = this.sortedGetters;
        } else {
            fieldSerializerArr = this.getters;
        }
        com.alibaba.fastjson.serializer.FieldSerializer[] fieldSerializerArr2 = fieldSerializerArr;
        com.alibaba.fastjson.serializer.SerialContext serialContext2 = jSONSerializer.context;
        if (!this.beanInfo.beanType.isEnum()) {
            jSONSerializer.setContext(serialContext2, obj, obj2, this.beanInfo.features, i);
        }
        com.alibaba.fastjson.serializer.SerialContext serialContext3 = serialContext2;
        boolean zIsWriteAsArray = isWriteAsArray(jSONSerializer, i);
        char c3 = zIsWriteAsArray ? com.taobao.weex.el.parse.Operators.ARRAY_START : com.taobao.weex.el.parse.Operators.BLOCK_START;
        char c4 = zIsWriteAsArray ? com.taobao.weex.el.parse.Operators.ARRAY_END : com.taobao.weex.el.parse.Operators.BLOCK_END;
        try {
            if (!z) {
                try {
                    serializeWriter.append(c3);
                } catch (java.lang.Exception e2) {
                    fieldSerializer = null;
                    exc = e2;
                    str = "write javaBean error, fastjson version 1.2.83";
                    if (obj != null) {
                        str = "write javaBean error, fastjson version 1.2.83, class " + obj.getClass().getName();
                    }
                    if (obj2 != null) {
                        str = str + ", fieldName : " + obj2;
                    } else if (fieldSerializer != null) {
                        fieldInfo = fieldSerializer.fieldInfo;
                        if (fieldInfo.method != null) {
                            str = str + ", method : " + fieldInfo.method.getName();
                        } else {
                            str = str + ", fieldName : " + fieldSerializer.fieldInfo.name;
                        }
                    }
                    if (exc.getMessage() != null) {
                        str = str + ", " + exc.getMessage();
                    }
                    if (exc instanceof java.lang.reflect.InvocationTargetException) {
                        cause = exc.getCause();
                    } else {
                        cause = null;
                    }
                    if (cause == null) {
                        exc2 = exc;
                    } else {
                        exc2 = cause;
                    }
                    throw new com.alibaba.fastjson.JSONException(str, exc2);
                }
            }
            if (fieldSerializerArr2.length > 0 && serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat)) {
                jSONSerializer.incrementIndent();
                jSONSerializer.println();
            }
            if ((this.beanInfo.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName.mask) == 0 && (com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName.mask & i) == 0 && !jSONSerializer.isWriteClassName(type2, obj)) {
                c = 0;
            } else {
                java.lang.Class<?> cls = obj.getClass();
                if (cls != ((cls == type2 || !(type2 instanceof java.lang.reflect.WildcardType)) ? type2 : com.alibaba.fastjson.util.TypeUtils.getClass(type2))) {
                    writeClassName(jSONSerializer, this.beanInfo.typeKey, obj);
                    c = com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR;
                } else {
                    c = 0;
                }
            }
            boolean zIsEnabled = serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName);
            boolean z3 = writeBefore(jSONSerializer, obj, c) == ',';
            boolean zIsEnabled2 = serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.SkipTransientField);
            boolean zIsEnabled3 = serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.IgnoreNonFieldGetter);
            boolean z4 = z3;
            int i2 = 0;
            com.alibaba.fastjson.serializer.FieldSerializer fieldSerializer2 = null;
            while (i2 < fieldSerializerArr2.length) {
                try {
                    try {
                        try {
                            fieldSerializer = fieldSerializerArr2[i2];
                            java.lang.reflect.Field field = fieldSerializer.fieldInfo.field;
                            boolean z5 = zIsWriteAsArray;
                            com.alibaba.fastjson.util.FieldInfo fieldInfo2 = fieldSerializer.fieldInfo;
                            java.lang.String str2 = fieldInfo2.name;
                            java.lang.Class<?> cls2 = fieldInfo2.fieldClass;
                            int i3 = i2;
                            boolean zIsEnabled4 = com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(serializeWriter.features, fieldInfo2.serialzeFeatures, com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes);
                            boolean z6 = serializeWriter.quoteFieldNames && !zIsEnabled4;
                            if ((zIsEnabled2 && fieldInfo2.fieldTransient) || (zIsEnabled3 && field == null)) {
                                serialContext = serialContext3;
                            } else {
                                if (applyName(jSONSerializer, obj, str2) && applyLabel(jSONSerializer, fieldInfo2.label)) {
                                    z2 = false;
                                } else if (z5) {
                                    z2 = true;
                                } else {
                                    serialContext = serialContext3;
                                }
                                if (str2.equals(this.beanInfo.typeKey) && jSONSerializer.isWriteClassName(type2, obj)) {
                                    serialContext = serialContext3;
                                } else {
                                    if (z2) {
                                        propertyValueDirect = null;
                                    } else {
                                        try {
                                            propertyValueDirect = fieldSerializer.getPropertyValueDirect(obj);
                                        } catch (java.lang.reflect.InvocationTargetException e3) {
                                            try {
                                                if (!serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.IgnoreErrorGetter)) {
                                                    serialContext = serialContext3;
                                                    try {
                                                        throw e3;
                                                    } catch (java.lang.Exception e4) {
                                                        e = e4;
                                                        exc = e;
                                                        str = "write javaBean error, fastjson version 1.2.83";
                                                        if (obj != null) {
                                                            str = "write javaBean error, fastjson version 1.2.83, class " + obj.getClass().getName();
                                                        }
                                                        if (obj2 != null) {
                                                            str = str + ", fieldName : " + obj2;
                                                        } else if (fieldSerializer != null) {
                                                            fieldInfo = fieldSerializer.fieldInfo;
                                                            if (fieldInfo.method != null) {
                                                                str = str + ", method : " + fieldInfo.method.getName();
                                                            } else {
                                                                str = str + ", fieldName : " + fieldSerializer.fieldInfo.name;
                                                            }
                                                        }
                                                        if (exc.getMessage() != null) {
                                                            str = str + ", " + exc.getMessage();
                                                        }
                                                        if (exc instanceof java.lang.reflect.InvocationTargetException) {
                                                            cause = exc.getCause();
                                                        } else {
                                                            cause = null;
                                                        }
                                                        if (cause == null) {
                                                            exc2 = exc;
                                                        } else {
                                                            exc2 = cause;
                                                        }
                                                        throw new com.alibaba.fastjson.JSONException(str, exc2);
                                                    }
                                                }
                                                fieldSerializer2 = fieldSerializer;
                                                propertyValueDirect = null;
                                            } catch (java.lang.Exception e5) {
                                                exc = e5;
                                                str = "write javaBean error, fastjson version 1.2.83";
                                                if (obj != null) {
                                                    str = "write javaBean error, fastjson version 1.2.83, class " + obj.getClass().getName();
                                                }
                                                if (obj2 != null) {
                                                    str = str + ", fieldName : " + obj2;
                                                } else if (fieldSerializer != null) {
                                                    fieldInfo = fieldSerializer.fieldInfo;
                                                    if (fieldInfo.method != null) {
                                                        str = str + ", method : " + fieldInfo.method.getName();
                                                    } else {
                                                        str = str + ", fieldName : " + fieldSerializer.fieldInfo.name;
                                                    }
                                                }
                                                if (exc.getMessage() != null) {
                                                    str = str + ", " + exc.getMessage();
                                                }
                                                if (exc instanceof java.lang.reflect.InvocationTargetException) {
                                                    cause = exc.getCause();
                                                } else {
                                                    cause = null;
                                                }
                                                if (cause == null) {
                                                    exc2 = exc;
                                                } else {
                                                    exc2 = cause;
                                                }
                                                throw new com.alibaba.fastjson.JSONException(str, exc2);
                                            }
                                        }
                                    }
                                    if (apply(jSONSerializer, obj, str2, propertyValueDirect)) {
                                        if (cls2 == java.lang.String.class && io.dcloud.common.constant.AbsoluteConst.XML_TRIM.equals(fieldInfo2.format) && propertyValueDirect != null) {
                                            propertyValueDirect = ((java.lang.String) propertyValueDirect).trim();
                                        }
                                        java.lang.Object obj4 = propertyValueDirect;
                                        java.lang.String strProcessKey = processKey(jSONSerializer, obj, str2, obj4);
                                        java.lang.Object objProcessValue = processValue(jSONSerializer, fieldSerializer.fieldContext, obj, str2, obj4, i);
                                        if (objProcessValue == null) {
                                            int iOf = fieldInfo2.serialzeFeatures;
                                            com.alibaba.fastjson.annotation.JSONField annotation = fieldInfo2.getAnnotation();
                                            obj3 = objProcessValue;
                                            if (this.beanInfo.jsonType != null) {
                                                iOf |= com.alibaba.fastjson.serializer.SerializerFeature.of(this.beanInfo.jsonType.serialzeFeatures());
                                            }
                                            if (annotation != null && !"".equals(annotation.defaultValue())) {
                                                objDefaultValue = annotation.defaultValue();
                                            } else if (cls2 == java.lang.Boolean.class) {
                                                int i4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse.mask;
                                                int i5 = i4 | com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.mask;
                                                if (!z5 && (iOf & i5) == 0 && (serializeWriter.features & i5) == 0) {
                                                    serialContext = serialContext3;
                                                } else if ((iOf & i4) != 0) {
                                                    objDefaultValue = false;
                                                } else if ((serializeWriter.features & i4) != 0 && (com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.mask & iOf) == 0) {
                                                    objDefaultValue = false;
                                                }
                                            } else if (cls2 == java.lang.String.class) {
                                                int i6 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty.mask;
                                                int i7 = i6 | com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.mask;
                                                if (!z5 && (iOf & i7) == 0 && (serializeWriter.features & i7) == 0) {
                                                    serialContext = serialContext3;
                                                } else if ((iOf & i6) != 0 || ((serializeWriter.features & i6) != 0 && (com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.mask & iOf) == 0)) {
                                                    objDefaultValue = "";
                                                }
                                            } else if (java.lang.Number.class.isAssignableFrom(cls2)) {
                                                int i8 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero.mask;
                                                int i9 = i8 | com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.mask;
                                                if (!z5 && (iOf & i9) == 0 && (serializeWriter.features & i9) == 0) {
                                                    serialContext = serialContext3;
                                                } else if ((iOf & i8) != 0) {
                                                    objDefaultValue = 0;
                                                } else if ((serializeWriter.features & i8) != 0 && (com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.mask & iOf) == 0) {
                                                    objDefaultValue = 0;
                                                }
                                            } else if (java.util.Collection.class.isAssignableFrom(cls2)) {
                                                int i10 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty.mask;
                                                int i11 = i10 | com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.mask;
                                                if (!z5 && (iOf & i11) == 0 && (serializeWriter.features & i11) == 0) {
                                                    serialContext = serialContext3;
                                                } else if ((iOf & i10) != 0) {
                                                    objDefaultValue = java.util.Collections.EMPTY_LIST;
                                                } else if ((serializeWriter.features & i10) != 0 && (com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.mask & iOf) == 0) {
                                                    objDefaultValue = java.util.Collections.EMPTY_LIST;
                                                }
                                            } else if (!z5 && !fieldSerializer.writeNull && !serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.mask) && (com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.mask & iOf) == 0) {
                                                serialContext = serialContext3;
                                            }
                                            if (objDefaultValue != null || (!serializeWriter.notWriteDefaultValue && (fieldInfo2.serialzeFeatures & com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue.mask) == 0 && (this.beanInfo.features & com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue.mask) == 0)) {
                                                serialContext = serialContext3;
                                            } else {
                                                java.lang.Class<?> cls3 = fieldInfo2.fieldClass;
                                                serialContext = serialContext3;
                                                try {
                                                    try {
                                                        if ((cls3 != java.lang.Byte.TYPE || !(objDefaultValue instanceof java.lang.Byte) || ((java.lang.Byte) objDefaultValue).byteValue() != 0) && ((cls3 != java.lang.Short.TYPE || !(objDefaultValue instanceof java.lang.Short) || ((java.lang.Short) objDefaultValue).shortValue() != 0) && ((cls3 != java.lang.Integer.TYPE || !(objDefaultValue instanceof java.lang.Integer) || ((java.lang.Integer) objDefaultValue).intValue() != 0) && ((cls3 != java.lang.Long.TYPE || !(objDefaultValue instanceof java.lang.Long) || ((java.lang.Long) objDefaultValue).longValue() != 0) && ((cls3 != java.lang.Float.TYPE || !(objDefaultValue instanceof java.lang.Float) || ((java.lang.Float) objDefaultValue).floatValue() != 0.0f) && ((cls3 != java.lang.Double.TYPE || !(objDefaultValue instanceof java.lang.Double) || ((java.lang.Double) objDefaultValue).doubleValue() != 0.0d) && (cls3 != java.lang.Boolean.TYPE || !(objDefaultValue instanceof java.lang.Boolean) || ((java.lang.Boolean) objDefaultValue).booleanValue()))))))) {
                                                        }
                                                    } catch (java.lang.Throwable th) {
                                                        th = th;
                                                        serialContext3 = serialContext;
                                                        jSONSerializer.context = serialContext3;
                                                        throw th;
                                                    }
                                                } catch (java.lang.Exception e6) {
                                                    e = e6;
                                                    fieldSerializer = fieldSerializer2;
                                                    exc = e;
                                                    str = "write javaBean error, fastjson version 1.2.83";
                                                    if (obj != null) {
                                                        str = "write javaBean error, fastjson version 1.2.83, class " + obj.getClass().getName();
                                                    }
                                                    if (obj2 != null) {
                                                        str = str + ", fieldName : " + obj2;
                                                    } else if (fieldSerializer != null) {
                                                        fieldInfo = fieldSerializer.fieldInfo;
                                                        if (fieldInfo.method != null) {
                                                            str = str + ", method : " + fieldInfo.method.getName();
                                                        } else {
                                                            str = str + ", fieldName : " + fieldSerializer.fieldInfo.name;
                                                        }
                                                    }
                                                    if (exc.getMessage() != null) {
                                                        str = str + ", " + exc.getMessage();
                                                    }
                                                    if (exc instanceof java.lang.reflect.InvocationTargetException) {
                                                        cause = exc.getCause();
                                                    } else {
                                                        cause = null;
                                                    }
                                                    if (cause == null) {
                                                        exc2 = exc;
                                                    } else {
                                                        exc2 = cause;
                                                    }
                                                    throw new com.alibaba.fastjson.JSONException(str, exc2);
                                                }
                                            }
                                            if (z4) {
                                                if (fieldInfo2.unwrapped || !(objDefaultValue instanceof java.util.Map) || ((java.util.Map) objDefaultValue).size() != 0) {
                                                    serializeWriter.write(44);
                                                    if (serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat)) {
                                                        jSONSerializer.println();
                                                    }
                                                }
                                            }
                                            if (strProcessKey != str2) {
                                                if (!z5) {
                                                    serializeWriter.writeFieldName(strProcessKey, true);
                                                }
                                                jSONSerializer.write(objDefaultValue);
                                            } else if (obj4 != objDefaultValue) {
                                                if (!z5) {
                                                    fieldSerializer.writePrefix(jSONSerializer);
                                                }
                                                jSONSerializer.write(objDefaultValue);
                                            } else {
                                                if (z5) {
                                                    c2 = 0;
                                                } else {
                                                    boolean zIsAssignableFrom = java.util.Map.class.isAssignableFrom(cls2);
                                                    boolean z7 = (cls2.isPrimitive() && !cls2.getName().startsWith("java.")) || cls2 == java.lang.Object.class;
                                                    if (zIsEnabled && fieldInfo2.unwrapped && (zIsAssignableFrom || z7)) {
                                                        c2 = 0;
                                                    } else if (z6) {
                                                        c2 = 0;
                                                        serializeWriter.write(fieldInfo2.name_chars, 0, fieldInfo2.name_chars.length);
                                                    } else {
                                                        c2 = 0;
                                                        fieldSerializer.writePrefix(jSONSerializer);
                                                    }
                                                }
                                                if (!z5) {
                                                    com.alibaba.fastjson.annotation.JSONField annotation2 = fieldInfo2.getAnnotation();
                                                    if (cls2 == java.lang.String.class || !(annotation2 == null || annotation2.serializeUsing() == java.lang.Void.class)) {
                                                        if (!fieldInfo2.unwrapped && (objDefaultValue instanceof java.util.Map) && ((java.util.Map) objDefaultValue).size() == 0) {
                                                            z4 = false;
                                                        } else {
                                                            fieldSerializer.writeValue(jSONSerializer, objDefaultValue);
                                                        }
                                                    } else if (objDefaultValue == null) {
                                                        int iOf2 = fieldSerializer.features;
                                                        if (this.beanInfo.jsonType != null) {
                                                            iOf2 |= com.alibaba.fastjson.serializer.SerializerFeature.of(this.beanInfo.jsonType.serialzeFeatures());
                                                        }
                                                        if (((serializeWriter.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty.mask) != 0 && (com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.mask & iOf2) == 0) || (iOf2 & com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty.mask) != 0) {
                                                            serializeWriter.writeString("");
                                                        } else {
                                                            serializeWriter.writeNull();
                                                        }
                                                    } else {
                                                        java.lang.String str3 = (java.lang.String) objDefaultValue;
                                                        if (zIsEnabled4) {
                                                            serializeWriter.writeStringWithSingleQuote(str3);
                                                        } else {
                                                            serializeWriter.writeStringWithDoubleQuote(str3, c2);
                                                        }
                                                    }
                                                } else {
                                                    fieldSerializer.writeValue(jSONSerializer, objDefaultValue);
                                                }
                                                if (!fieldInfo2.unwrapped || !(objDefaultValue instanceof java.util.Map)) {
                                                    z4 = true;
                                                    break;
                                                }
                                                java.util.Map map = (java.util.Map) objDefaultValue;
                                                if (map.size() != 0) {
                                                    if (jSONSerializer.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue)) {
                                                        z4 = true;
                                                        break;
                                                        break;
                                                    }
                                                    java.util.Iterator it = map.values().iterator();
                                                    while (it.hasNext()) {
                                                        if (it.next() != null) {
                                                            z4 = true;
                                                            break;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                            if (!fieldInfo2.unwrapped) {
                                                z4 = true;
                                                break;
                                                break;
                                            } else {
                                                z4 = true;
                                                break;
                                                break;
                                            }
                                        }
                                        obj3 = objProcessValue;
                                        objDefaultValue = obj3;
                                        if (objDefaultValue != null) {
                                            serialContext = serialContext3;
                                            if (z4) {
                                                if (fieldInfo2.unwrapped) {
                                                }
                                                serializeWriter.write(44);
                                                if (serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat)) {
                                                    jSONSerializer.println();
                                                }
                                            }
                                            if (strProcessKey != str2) {
                                                if (obj4 != objDefaultValue) {
                                                    if (!z5) {
                                                        fieldSerializer.writePrefix(jSONSerializer);
                                                    }
                                                    jSONSerializer.write(objDefaultValue);
                                                } else {
                                                    if (z5) {
                                                        boolean zIsAssignableFrom2 = java.util.Map.class.isAssignableFrom(cls2);
                                                        if (cls2.isPrimitive()) {
                                                        }
                                                        if (zIsEnabled) {
                                                        }
                                                        if (z6) {
                                                            c2 = 0;
                                                            serializeWriter.write(fieldInfo2.name_chars, 0, fieldInfo2.name_chars.length);
                                                        } else {
                                                            c2 = 0;
                                                            fieldSerializer.writePrefix(jSONSerializer);
                                                        }
                                                    } else {
                                                        c2 = 0;
                                                    }
                                                    if (!z5) {
                                                        com.alibaba.fastjson.annotation.JSONField annotation3 = fieldInfo2.getAnnotation();
                                                        if (cls2 == java.lang.String.class) {
                                                            if (!fieldInfo2.unwrapped) {
                                                            }
                                                            fieldSerializer.writeValue(jSONSerializer, objDefaultValue);
                                                        } else {
                                                            if (!fieldInfo2.unwrapped) {
                                                            }
                                                            fieldSerializer.writeValue(jSONSerializer, objDefaultValue);
                                                        }
                                                    } else {
                                                        fieldSerializer.writeValue(jSONSerializer, objDefaultValue);
                                                    }
                                                    if (!fieldInfo2.unwrapped) {
                                                        z4 = true;
                                                        break;
                                                        break;
                                                    } else {
                                                        z4 = true;
                                                        break;
                                                        break;
                                                    }
                                                }
                                            } else {
                                                if (!z5) {
                                                    serializeWriter.writeFieldName(strProcessKey, true);
                                                }
                                                jSONSerializer.write(objDefaultValue);
                                            }
                                            if (!fieldInfo2.unwrapped) {
                                                z4 = true;
                                                break;
                                                break;
                                            } else {
                                                z4 = true;
                                                break;
                                                break;
                                            }
                                        }
                                        serialContext = serialContext3;
                                        if (z4) {
                                            if (fieldInfo2.unwrapped) {
                                            }
                                            serializeWriter.write(44);
                                            if (serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat)) {
                                                jSONSerializer.println();
                                            }
                                        }
                                        if (strProcessKey != str2) {
                                            if (obj4 != objDefaultValue) {
                                                if (!z5) {
                                                    fieldSerializer.writePrefix(jSONSerializer);
                                                }
                                                jSONSerializer.write(objDefaultValue);
                                            } else {
                                                if (z5) {
                                                    boolean zIsAssignableFrom3 = java.util.Map.class.isAssignableFrom(cls2);
                                                    if (cls2.isPrimitive()) {
                                                    }
                                                    if (zIsEnabled) {
                                                    }
                                                    if (z6) {
                                                        c2 = 0;
                                                        serializeWriter.write(fieldInfo2.name_chars, 0, fieldInfo2.name_chars.length);
                                                    } else {
                                                        c2 = 0;
                                                        fieldSerializer.writePrefix(jSONSerializer);
                                                    }
                                                } else {
                                                    c2 = 0;
                                                }
                                                if (!z5) {
                                                    com.alibaba.fastjson.annotation.JSONField annotation4 = fieldInfo2.getAnnotation();
                                                    if (cls2 == java.lang.String.class) {
                                                        if (!fieldInfo2.unwrapped) {
                                                        }
                                                        fieldSerializer.writeValue(jSONSerializer, objDefaultValue);
                                                    } else {
                                                        if (!fieldInfo2.unwrapped) {
                                                        }
                                                        fieldSerializer.writeValue(jSONSerializer, objDefaultValue);
                                                    }
                                                } else {
                                                    fieldSerializer.writeValue(jSONSerializer, objDefaultValue);
                                                }
                                                if (!fieldInfo2.unwrapped) {
                                                    z4 = true;
                                                    break;
                                                    break;
                                                } else {
                                                    z4 = true;
                                                    break;
                                                    break;
                                                }
                                            }
                                        } else {
                                            if (!z5) {
                                                serializeWriter.writeFieldName(strProcessKey, true);
                                            }
                                            jSONSerializer.write(objDefaultValue);
                                        }
                                        if (!fieldInfo2.unwrapped) {
                                            z4 = true;
                                            break;
                                            break;
                                        } else {
                                            z4 = true;
                                            break;
                                            break;
                                        }
                                    }
                                    serialContext = serialContext3;
                                }
                            }
                            i2 = i3 + 1;
                            type2 = type;
                            zIsWriteAsArray = z5;
                            serialContext3 = serialContext;
                        } catch (java.lang.Exception e7) {
                            e = e7;
                            fieldSerializer = fieldSerializer2;
                            exc = e;
                            str = "write javaBean error, fastjson version 1.2.83";
                            if (obj != null) {
                                str = "write javaBean error, fastjson version 1.2.83, class " + obj.getClass().getName();
                            }
                            if (obj2 != null) {
                                str = str + ", fieldName : " + obj2;
                            } else if (fieldSerializer != null && fieldSerializer.fieldInfo != null) {
                                fieldInfo = fieldSerializer.fieldInfo;
                                if (fieldInfo.method != null) {
                                    str = str + ", method : " + fieldInfo.method.getName();
                                } else {
                                    str = str + ", fieldName : " + fieldSerializer.fieldInfo.name;
                                }
                            }
                            if (exc.getMessage() != null) {
                                str = str + ", " + exc.getMessage();
                            }
                            if (exc instanceof java.lang.reflect.InvocationTargetException) {
                                cause = exc.getCause();
                            } else {
                                cause = null;
                            }
                            if (cause == null) {
                                exc2 = exc;
                            } else {
                                exc2 = cause;
                            }
                            throw new com.alibaba.fastjson.JSONException(str, exc2);
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                    }
                } catch (java.lang.Exception e8) {
                    e = e8;
                }
            }
            serialContext = serialContext3;
            try {
                writeAfter(jSONSerializer, obj, z4 ? com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR : (char) 0);
                if (fieldSerializerArr2.length > 0 && serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat)) {
                    jSONSerializer.decrementIdent();
                    jSONSerializer.println();
                }
                if (!z) {
                    serializeWriter.append(c4);
                }
                jSONSerializer.context = serialContext;
            } catch (java.lang.Exception e9) {
                e = e9;
                fieldSerializer = fieldSerializer2;
                exc = e;
                str = "write javaBean error, fastjson version 1.2.83";
                if (obj != null) {
                    str = "write javaBean error, fastjson version 1.2.83, class " + obj.getClass().getName();
                }
                if (obj2 != null) {
                    str = str + ", fieldName : " + obj2;
                } else if (fieldSerializer != null) {
                    fieldInfo = fieldSerializer.fieldInfo;
                    if (fieldInfo.method != null) {
                        str = str + ", method : " + fieldInfo.method.getName();
                    } else {
                        str = str + ", fieldName : " + fieldSerializer.fieldInfo.name;
                    }
                }
                if (exc.getMessage() != null) {
                    str = str + ", " + exc.getMessage();
                }
                if (exc instanceof java.lang.reflect.InvocationTargetException) {
                    cause = exc.getCause();
                } else {
                    cause = null;
                }
                if (cause == null) {
                    exc2 = exc;
                } else {
                    exc2 = cause;
                }
                throw new com.alibaba.fastjson.JSONException(str, exc2);
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    protected void writeClassName(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.String str, java.lang.Object obj) {
        if (str == null) {
            str = jSONSerializer.config.typeKey;
        }
        jSONSerializer.out.writeFieldName(str, false);
        java.lang.String name = this.beanInfo.typeName;
        if (name == null) {
            java.lang.Class<?> superclass = obj.getClass();
            if (com.alibaba.fastjson.util.TypeUtils.isProxy(superclass)) {
                superclass = superclass.getSuperclass();
            }
            name = superclass.getName();
        }
        jSONSerializer.write(name);
    }

    public boolean writeReference(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, int i) {
        com.alibaba.fastjson.serializer.SerialContext serialContext = jSONSerializer.context;
        int i2 = com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect.mask;
        if (serialContext == null || (serialContext.features & i2) != 0 || (i & i2) != 0 || jSONSerializer.references == null || !jSONSerializer.references.containsKey(obj)) {
            return false;
        }
        jSONSerializer.writeReference(obj);
        return true;
    }

    protected boolean isWriteAsArray(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer) {
        return isWriteAsArray(jSONSerializer, 0);
    }

    protected boolean isWriteAsArray(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, int i) {
        int i2 = com.alibaba.fastjson.serializer.SerializerFeature.BeanToArray.mask;
        return ((this.beanInfo.features & i2) == 0 && !jSONSerializer.out.beanToArray && (i & i2) == 0) ? false : true;
    }

    public java.lang.Object getFieldValue(java.lang.Object obj, java.lang.String str) {
        com.alibaba.fastjson.serializer.FieldSerializer fieldSerializer = getFieldSerializer(str);
        if (fieldSerializer == null) {
            throw new com.alibaba.fastjson.JSONException("field not found. " + str);
        }
        try {
            return fieldSerializer.getPropertyValue(obj);
        } catch (java.lang.IllegalAccessException e) {
            throw new com.alibaba.fastjson.JSONException("getFieldValue error." + str, e);
        } catch (java.lang.reflect.InvocationTargetException e2) {
            throw new com.alibaba.fastjson.JSONException("getFieldValue error." + str, e2);
        }
    }

    public java.lang.Object getFieldValue(java.lang.Object obj, java.lang.String str, long j, boolean z) {
        com.alibaba.fastjson.serializer.FieldSerializer fieldSerializer = getFieldSerializer(j);
        if (fieldSerializer == null) {
            if (!z) {
                return null;
            }
            throw new com.alibaba.fastjson.JSONException("field not found. " + str);
        }
        try {
            return fieldSerializer.getPropertyValue(obj);
        } catch (java.lang.IllegalAccessException e) {
            throw new com.alibaba.fastjson.JSONException("getFieldValue error." + str, e);
        } catch (java.lang.reflect.InvocationTargetException e2) {
            throw new com.alibaba.fastjson.JSONException("getFieldValue error." + str, e2);
        }
    }

    public com.alibaba.fastjson.serializer.FieldSerializer getFieldSerializer(java.lang.String str) {
        if (str == null) {
            return null;
        }
        int length = this.sortedGetters.length - 1;
        int i = 0;
        while (i <= length) {
            int i2 = (i + length) >>> 1;
            int iCompareTo = this.sortedGetters[i2].fieldInfo.name.compareTo(str);
            if (iCompareTo < 0) {
                i = i2 + 1;
            } else {
                if (iCompareTo <= 0) {
                    return this.sortedGetters[i2];
                }
                length = i2 - 1;
            }
        }
        return null;
    }

    public com.alibaba.fastjson.serializer.FieldSerializer getFieldSerializer(long j) {
        com.alibaba.fastjson.PropertyNamingStrategy[] propertyNamingStrategyArrValues;
        int iBinarySearch;
        if (this.hashArray == null) {
            propertyNamingStrategyArrValues = com.alibaba.fastjson.PropertyNamingStrategy.values();
            long[] jArr = new long[this.sortedGetters.length * propertyNamingStrategyArrValues.length];
            int i = 0;
            int i2 = 0;
            while (true) {
                com.alibaba.fastjson.serializer.FieldSerializer[] fieldSerializerArr = this.sortedGetters;
                if (i >= fieldSerializerArr.length) {
                    break;
                }
                java.lang.String str = fieldSerializerArr[i].fieldInfo.name;
                jArr[i2] = com.alibaba.fastjson.util.TypeUtils.fnv1a_64(str);
                i2++;
                for (com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy : propertyNamingStrategyArrValues) {
                    java.lang.String strTranslate = propertyNamingStrategy.translate(str);
                    if (!str.equals(strTranslate)) {
                        jArr[i2] = com.alibaba.fastjson.util.TypeUtils.fnv1a_64(strTranslate);
                        i2++;
                    }
                }
                i++;
            }
            java.util.Arrays.sort(jArr, 0, i2);
            this.hashArray = new long[i2];
            java.lang.System.arraycopy(jArr, 0, this.hashArray, 0, i2);
        } else {
            propertyNamingStrategyArrValues = null;
        }
        int iBinarySearch2 = java.util.Arrays.binarySearch(this.hashArray, j);
        if (iBinarySearch2 < 0) {
            return null;
        }
        if (this.hashArrayMapping == null) {
            if (propertyNamingStrategyArrValues == null) {
                propertyNamingStrategyArrValues = com.alibaba.fastjson.PropertyNamingStrategy.values();
            }
            short[] sArr = new short[this.hashArray.length];
            java.util.Arrays.fill(sArr, (short) -1);
            int i3 = 0;
            while (true) {
                com.alibaba.fastjson.serializer.FieldSerializer[] fieldSerializerArr2 = this.sortedGetters;
                if (i3 >= fieldSerializerArr2.length) {
                    break;
                }
                java.lang.String str2 = fieldSerializerArr2[i3].fieldInfo.name;
                int iBinarySearch3 = java.util.Arrays.binarySearch(this.hashArray, com.alibaba.fastjson.util.TypeUtils.fnv1a_64(str2));
                if (iBinarySearch3 >= 0) {
                    sArr[iBinarySearch3] = (short) i3;
                }
                for (com.alibaba.fastjson.PropertyNamingStrategy propertyNamingStrategy2 : propertyNamingStrategyArrValues) {
                    java.lang.String strTranslate2 = propertyNamingStrategy2.translate(str2);
                    if (!str2.equals(strTranslate2) && (iBinarySearch = java.util.Arrays.binarySearch(this.hashArray, com.alibaba.fastjson.util.TypeUtils.fnv1a_64(strTranslate2))) >= 0) {
                        sArr[iBinarySearch] = (short) i3;
                    }
                }
                i3++;
            }
            this.hashArrayMapping = sArr;
        }
        short s = this.hashArrayMapping[iBinarySearch2];
        if (s != -1) {
            return this.sortedGetters[s];
        }
        return null;
    }

    public java.util.List<java.lang.Object> getFieldValues(java.lang.Object obj) throws java.lang.Exception {
        java.util.ArrayList arrayList = new java.util.ArrayList(this.sortedGetters.length);
        for (com.alibaba.fastjson.serializer.FieldSerializer fieldSerializer : this.sortedGetters) {
            arrayList.add(fieldSerializer.getPropertyValue(obj));
        }
        return arrayList;
    }

    public java.util.List<java.lang.Object> getObjectFieldValues(java.lang.Object obj) throws java.lang.Exception {
        java.util.ArrayList arrayList = new java.util.ArrayList(this.sortedGetters.length);
        for (com.alibaba.fastjson.serializer.FieldSerializer fieldSerializer : this.sortedGetters) {
            java.lang.Class<?> cls = fieldSerializer.fieldInfo.fieldClass;
            if (!cls.isPrimitive() && !cls.getName().startsWith("java.lang.")) {
                arrayList.add(fieldSerializer.getPropertyValue(obj));
            }
        }
        return arrayList;
    }

    public int getSize(java.lang.Object obj) throws java.lang.Exception {
        int i = 0;
        for (com.alibaba.fastjson.serializer.FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                i++;
            }
        }
        return i;
    }

    public java.util.Set<java.lang.String> getFieldNames(java.lang.Object obj) throws java.lang.Exception {
        java.util.HashSet hashSet = new java.util.HashSet();
        for (com.alibaba.fastjson.serializer.FieldSerializer fieldSerializer : this.sortedGetters) {
            if (fieldSerializer.getPropertyValueDirect(obj) != null) {
                hashSet.add(fieldSerializer.fieldInfo.name);
            }
        }
        return hashSet;
    }

    public java.util.Map<java.lang.String, java.lang.Object> getFieldValuesMap(java.lang.Object obj) throws java.lang.Exception {
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(this.sortedGetters.length);
        for (com.alibaba.fastjson.serializer.FieldSerializer fieldSerializer : this.sortedGetters) {
            boolean zIsEnabled = com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(fieldSerializer.features, com.alibaba.fastjson.serializer.SerializerFeature.SkipTransientField);
            com.alibaba.fastjson.util.FieldInfo fieldInfo = fieldSerializer.fieldInfo;
            if (!zIsEnabled || fieldInfo == null || !fieldInfo.fieldTransient) {
                if (fieldSerializer.fieldInfo.unwrapped) {
                    java.lang.Object json = com.alibaba.fastjson.JSON.toJSON(fieldSerializer.getPropertyValue(obj));
                    if (json instanceof java.util.Map) {
                        linkedHashMap.putAll((java.util.Map) json);
                    } else {
                        linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
                    }
                } else {
                    linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
                }
            }
        }
        return linkedHashMap;
    }

    protected com.alibaba.fastjson.serializer.BeanContext getBeanContext(int i) {
        return this.sortedGetters[i].fieldContext;
    }

    protected java.lang.reflect.Type getFieldType(int i) {
        return this.sortedGetters[i].fieldInfo.fieldType;
    }

    protected char writeBefore(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, char c) {
        if (jSONSerializer.beforeFilters != null) {
            java.util.Iterator<com.alibaba.fastjson.serializer.BeforeFilter> it = jSONSerializer.beforeFilters.iterator();
            while (it.hasNext()) {
                c = it.next().writeBefore(jSONSerializer, obj, c);
            }
        }
        if (this.beforeFilters != null) {
            java.util.Iterator<com.alibaba.fastjson.serializer.BeforeFilter> it2 = this.beforeFilters.iterator();
            while (it2.hasNext()) {
                c = it2.next().writeBefore(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    protected char writeAfter(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, char c) {
        if (jSONSerializer.afterFilters != null) {
            java.util.Iterator<com.alibaba.fastjson.serializer.AfterFilter> it = jSONSerializer.afterFilters.iterator();
            while (it.hasNext()) {
                c = it.next().writeAfter(jSONSerializer, obj, c);
            }
        }
        if (this.afterFilters != null) {
            java.util.Iterator<com.alibaba.fastjson.serializer.AfterFilter> it2 = this.afterFilters.iterator();
            while (it2.hasNext()) {
                c = it2.next().writeAfter(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    protected boolean applyLabel(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.String str) {
        if (jSONSerializer.labelFilters != null) {
            java.util.Iterator<com.alibaba.fastjson.serializer.LabelFilter> it = jSONSerializer.labelFilters.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(str)) {
                    return false;
                }
            }
        }
        if (this.labelFilters == null) {
            return true;
        }
        java.util.Iterator<com.alibaba.fastjson.serializer.LabelFilter> it2 = this.labelFilters.iterator();
        while (it2.hasNext()) {
            if (!it2.next().apply(str)) {
                return false;
            }
        }
        return true;
    }
}
