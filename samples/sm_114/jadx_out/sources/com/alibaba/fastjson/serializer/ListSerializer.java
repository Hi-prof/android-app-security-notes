package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public final class ListSerializer implements com.alibaba.fastjson.serializer.ObjectSerializer {
    public static final com.alibaba.fastjson.serializer.ListSerializer instance = new com.alibaba.fastjson.serializer.ListSerializer();

    /* JADX WARN: Code duplicated, block: B:98:0x0188 A[Catch: all -> 0x019b, TRY_LEAVE, TryCatch #5 {all -> 0x019b, blocks: (B:95:0x017f, B:98:0x0188), top: B:127:0x017f }] */
    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer, java.lang.Object obj, java.lang.Object obj2, java.lang.reflect.Type type, int i) throws java.lang.Throwable {
        com.alibaba.fastjson.serializer.SerialContext serialContext;
        java.lang.reflect.Type type2;
        com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer2;
        java.lang.reflect.Type type3;
        java.lang.reflect.Type type4;
        com.alibaba.fastjson.serializer.SerialContext serialContext2;
        com.alibaba.fastjson.serializer.JSONSerializer jSONSerializer3 = jSONSerializer;
        int i2 = i;
        boolean z = jSONSerializer3.out.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName) || com.alibaba.fastjson.serializer.SerializerFeature.isEnabled(i2, com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName);
        com.alibaba.fastjson.serializer.SerializeWriter serializeWriter = jSONSerializer3.out;
        java.lang.reflect.Type collectionItemType = z ? com.alibaba.fastjson.util.TypeUtils.getCollectionItemType(type) : null;
        if (obj == null) {
            serializeWriter.writeNull(com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        java.util.List list = (java.util.List) obj;
        if (list.size() == 0) {
            serializeWriter.append((java.lang.CharSequence) "[]");
            return;
        }
        com.alibaba.fastjson.serializer.SerialContext serialContext3 = jSONSerializer3.context;
        java.lang.Object obj3 = obj2;
        jSONSerializer3.setContext(serialContext3, obj, obj3, 0);
        try {
            if (serializeWriter.isEnabled(com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat)) {
                try {
                    serializeWriter.append(com.taobao.weex.el.parse.Operators.ARRAY_START);
                    jSONSerializer3.incrementIndent();
                    int i3 = 0;
                    for (java.lang.Object obj4 : list) {
                        if (i3 != 0) {
                            serializeWriter.append(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR);
                        }
                        jSONSerializer3.println();
                        if (obj4 != null) {
                            if (jSONSerializer3.containsReference(obj4)) {
                                jSONSerializer3.writeReference(obj4);
                                type2 = collectionItemType;
                            } else {
                                com.alibaba.fastjson.serializer.ObjectSerializer objectWriter = jSONSerializer3.getObjectWriter(obj4.getClass());
                                jSONSerializer3.context = new com.alibaba.fastjson.serializer.SerialContext(serialContext3, obj, obj3, 0, 0);
                                java.lang.reflect.Type type5 = collectionItemType;
                                objectWriter.write(jSONSerializer3, obj4, java.lang.Integer.valueOf(i3), type5, i2);
                                type2 = type5;
                            }
                        } else {
                            type2 = collectionItemType;
                            jSONSerializer3.out.writeNull();
                        }
                        try {
                            i3++;
                            obj3 = obj2;
                            i2 = i;
                            collectionItemType = type2;
                            serialContext3 = serialContext3;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            serialContext = serialContext3;
                            jSONSerializer3.context = serialContext;
                            throw th;
                        }
                    }
                    serialContext3 = serialContext3;
                    jSONSerializer3.decrementIdent();
                    jSONSerializer3.println();
                    serializeWriter.append(com.taobao.weex.el.parse.Operators.ARRAY_END);
                    jSONSerializer3.context = serialContext3;
                    return;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    serialContext3 = serialContext3;
                }
            } else {
                serialContext = serialContext3;
                java.lang.reflect.Type type6 = collectionItemType;
                try {
                    serializeWriter.append(com.taobao.weex.el.parse.Operators.ARRAY_START);
                    int size = list.size();
                    int i4 = 0;
                    while (i4 < size) {
                        java.lang.Object obj5 = list.get(i4);
                        if (i4 != 0) {
                            serializeWriter.append(com.taobao.weex.el.parse.Operators.ARRAY_SEPRATOR);
                        }
                        if (obj5 == null) {
                            serializeWriter.append((java.lang.CharSequence) "null");
                        } else {
                            java.lang.Class<?> cls = obj5.getClass();
                            if (cls == java.lang.Integer.class) {
                                serializeWriter.writeInt(((java.lang.Integer) obj5).intValue());
                            } else {
                                if (cls == java.lang.Long.class) {
                                    long jLongValue = ((java.lang.Long) obj5).longValue();
                                    if (z) {
                                        serializeWriter.writeLong(jLongValue);
                                        serializeWriter.write(76);
                                    } else {
                                        serializeWriter.writeLong(jLongValue);
                                    }
                                } else if ((com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect.mask & i) != 0) {
                                    try {
                                        java.lang.reflect.Type type7 = type6;
                                        jSONSerializer3.getObjectWriter(obj5.getClass()).write(jSONSerializer3, obj5, java.lang.Integer.valueOf(i4), type7, i);
                                        jSONSerializer2 = jSONSerializer3;
                                        type3 = type7;
                                        jSONSerializer3 = jSONSerializer2;
                                        type4 = type3;
                                    } catch (java.lang.Throwable th3) {
                                        th = th3;
                                    }
                                } else {
                                    jSONSerializer2 = jSONSerializer3;
                                    type3 = type6;
                                    try {
                                        if (serializeWriter.disableCircularReferenceDetect) {
                                            serialContext2 = serialContext;
                                        } else {
                                            try {
                                                serialContext2 = serialContext;
                                                try {
                                                    jSONSerializer2.context = new com.alibaba.fastjson.serializer.SerialContext(serialContext2, obj, obj2, 0, 0);
                                                } catch (java.lang.Throwable th4) {
                                                    th = th4;
                                                    serialContext = serialContext2;
                                                    jSONSerializer3 = jSONSerializer2;
                                                }
                                            } catch (java.lang.Throwable th5) {
                                                th = th5;
                                            }
                                        }
                                        if (jSONSerializer2.containsReference(obj5)) {
                                            jSONSerializer2.writeReference(obj5);
                                            serialContext = serialContext2;
                                            jSONSerializer3 = jSONSerializer2;
                                            type4 = type3;
                                        } else {
                                            com.alibaba.fastjson.serializer.ObjectSerializer objectWriter2 = jSONSerializer2.getObjectWriter(obj5.getClass());
                                            if ((com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName.mask & i) != 0) {
                                                try {
                                                    if (objectWriter2 instanceof com.alibaba.fastjson.serializer.JavaBeanSerializer) {
                                                        type4 = type3;
                                                        serialContext = serialContext2;
                                                        try {
                                                            ((com.alibaba.fastjson.serializer.JavaBeanSerializer) objectWriter2).writeNoneASM(jSONSerializer2, obj5, java.lang.Integer.valueOf(i4), type4, i);
                                                            jSONSerializer3 = jSONSerializer;
                                                        } catch (java.lang.Throwable th6) {
                                                            th = th6;
                                                            jSONSerializer3 = jSONSerializer;
                                                            jSONSerializer3.context = serialContext;
                                                            throw th;
                                                        }
                                                    } else {
                                                        type4 = type3;
                                                        serialContext = serialContext2;
                                                        jSONSerializer3 = jSONSerializer;
                                                        objectWriter2.write(jSONSerializer3, obj5, java.lang.Integer.valueOf(i4), type4, i);
                                                    }
                                                } catch (java.lang.Throwable th7) {
                                                    th = th7;
                                                    serialContext = serialContext2;
                                                }
                                            } else {
                                                type4 = type3;
                                                serialContext = serialContext2;
                                                jSONSerializer3 = jSONSerializer;
                                                objectWriter2.write(jSONSerializer3, obj5, java.lang.Integer.valueOf(i4), type4, i);
                                            }
                                        }
                                    } catch (java.lang.Throwable th8) {
                                        th = th8;
                                    }
                                }
                                i4++;
                                type6 = type4;
                            }
                        }
                        type4 = type6;
                        i4++;
                        type6 = type4;
                    }
                    serializeWriter.append(com.taobao.weex.el.parse.Operators.ARRAY_END);
                    jSONSerializer3.context = serialContext;
                    return;
                } catch (java.lang.Throwable th9) {
                    th = th9;
                }
            }
        } catch (java.lang.Throwable th10) {
            th = th10;
            serialContext = serialContext3;
        }
        jSONSerializer3.context = serialContext;
        throw th;
    }
}
