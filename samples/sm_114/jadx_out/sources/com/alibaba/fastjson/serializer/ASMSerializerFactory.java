package com.alibaba.fastjson.serializer;

/* JADX INFO: loaded from: classes.dex */
public class ASMSerializerFactory implements com.alibaba.fastjson.asm.Opcodes {
    static final java.lang.String JSONSerializer = com.alibaba.fastjson.util.ASMUtils.type(com.alibaba.fastjson.serializer.JSONSerializer.class);
    static final java.lang.String JavaBeanSerializer;
    static final java.lang.String JavaBeanSerializer_desc;
    static final java.lang.String ObjectSerializer;
    static final java.lang.String ObjectSerializer_desc;
    static final java.lang.String SerialContext_desc;
    static final java.lang.String SerializeFilterable_desc;
    static final java.lang.String SerializeWriter;
    static final java.lang.String SerializeWriter_desc;
    protected final com.alibaba.fastjson.util.ASMClassLoader classLoader = new com.alibaba.fastjson.util.ASMClassLoader();
    private final java.util.concurrent.atomic.AtomicLong seed = new java.util.concurrent.atomic.AtomicLong();

    static {
        java.lang.String strType = com.alibaba.fastjson.util.ASMUtils.type(com.alibaba.fastjson.serializer.ObjectSerializer.class);
        ObjectSerializer = strType;
        ObjectSerializer_desc = "L" + strType + ";";
        java.lang.String strType2 = com.alibaba.fastjson.util.ASMUtils.type(com.alibaba.fastjson.serializer.SerializeWriter.class);
        SerializeWriter = strType2;
        SerializeWriter_desc = "L" + strType2 + ";";
        JavaBeanSerializer = com.alibaba.fastjson.util.ASMUtils.type(com.alibaba.fastjson.serializer.JavaBeanSerializer.class);
        JavaBeanSerializer_desc = "L" + com.alibaba.fastjson.util.ASMUtils.type(com.alibaba.fastjson.serializer.JavaBeanSerializer.class) + ";";
        SerialContext_desc = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) com.alibaba.fastjson.serializer.SerialContext.class);
        SerializeFilterable_desc = com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) com.alibaba.fastjson.serializer.SerializeFilterable.class);
    }

    static class Context {
        static final int features = 5;
        static int fieldName = 6;
        static final int obj = 2;
        static int original = 7;
        static final int paramFieldName = 3;
        static final int paramFieldType = 4;
        static int processValue = 8;
        static final int serializer = 1;
        private final com.alibaba.fastjson.serializer.SerializeBeanInfo beanInfo;
        private final java.lang.String className;
        private final com.alibaba.fastjson.util.FieldInfo[] getters;
        private final boolean nonContext;
        private final boolean writeDirect;
        private java.util.Map<java.lang.String, java.lang.Integer> variants = new java.util.HashMap();
        private int variantIndex = 9;

        public Context(com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr, com.alibaba.fastjson.serializer.SerializeBeanInfo serializeBeanInfo, java.lang.String str, boolean z, boolean z2) {
            this.getters = fieldInfoArr;
            this.className = str;
            this.beanInfo = serializeBeanInfo;
            this.writeDirect = z;
            this.nonContext = z2 || serializeBeanInfo.beanType.isEnum();
        }

        public int var(java.lang.String str) {
            if (this.variants.get(str) == null) {
                java.util.Map<java.lang.String, java.lang.Integer> map = this.variants;
                int i = this.variantIndex;
                this.variantIndex = i + 1;
                map.put(str, java.lang.Integer.valueOf(i));
            }
            return this.variants.get(str).intValue();
        }

        public int var(java.lang.String str, int i) {
            if (this.variants.get(str) == null) {
                this.variants.put(str, java.lang.Integer.valueOf(this.variantIndex));
                this.variantIndex += i;
            }
            return this.variants.get(str).intValue();
        }

        public int getFieldOrinal(java.lang.String str) {
            int length = this.getters.length;
            for (int i = 0; i < length; i++) {
                if (this.getters[i].name.equals(str)) {
                    return i;
                }
            }
            return -1;
        }
    }

    public com.alibaba.fastjson.serializer.JavaBeanSerializer createJavaBeanSerializer(com.alibaba.fastjson.serializer.SerializeBeanInfo serializeBeanInfo) throws java.lang.Exception {
        java.lang.String str;
        boolean z;
        boolean z2;
        com.alibaba.fastjson.asm.ClassWriter classWriter;
        java.lang.String str2;
        boolean z3;
        boolean z4;
        java.lang.String str3;
        boolean z5;
        boolean z6;
        int i;
        com.alibaba.fastjson.serializer.SerializeBeanInfo serializeBeanInfo2 = serializeBeanInfo;
        java.lang.Class<?> cls = serializeBeanInfo2.beanType;
        if (cls.isPrimitive()) {
            throw new com.alibaba.fastjson.JSONException("unsupportd class " + cls.getName());
        }
        com.alibaba.fastjson.annotation.JSONType jSONType = (com.alibaba.fastjson.annotation.JSONType) com.alibaba.fastjson.util.TypeUtils.getAnnotation(cls, com.alibaba.fastjson.annotation.JSONType.class);
        com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr = serializeBeanInfo2.fields;
        for (com.alibaba.fastjson.util.FieldInfo fieldInfo : fieldInfoArr) {
            if (fieldInfo.field == null && fieldInfo.method != null && fieldInfo.method.getDeclaringClass().isInterface()) {
                return new com.alibaba.fastjson.serializer.JavaBeanSerializer(serializeBeanInfo2);
            }
        }
        com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr2 = serializeBeanInfo2.sortedFields;
        boolean z7 = serializeBeanInfo2.sortedFields == serializeBeanInfo2.fields;
        if (fieldInfoArr2.length > 256) {
            return new com.alibaba.fastjson.serializer.JavaBeanSerializer(serializeBeanInfo2);
        }
        for (com.alibaba.fastjson.util.FieldInfo fieldInfo2 : fieldInfoArr2) {
            if (!com.alibaba.fastjson.util.ASMUtils.checkName(fieldInfo2.getMember().getName())) {
                return new com.alibaba.fastjson.serializer.JavaBeanSerializer(serializeBeanInfo2);
            }
        }
        java.lang.String str4 = "ASMSerializer_" + this.seed.incrementAndGet() + "_" + cls.getSimpleName();
        java.lang.Package r4 = com.alibaba.fastjson.serializer.ASMSerializerFactory.class.getPackage();
        if (r4 != null) {
            java.lang.String name = r4.getName();
            java.lang.String str5 = name.replace(com.taobao.weex.el.parse.Operators.DOT, '/') + "/" + str4;
            str4 = name + com.taobao.weex.el.parse.Operators.DOT_STR + str4;
            str = str5;
        } else {
            str = str4;
        }
        com.alibaba.fastjson.asm.ClassWriter classWriter2 = new com.alibaba.fastjson.asm.ClassWriter();
        classWriter2.visit(49, 33, str, JavaBeanSerializer, new java.lang.String[]{ObjectSerializer});
        com.alibaba.fastjson.asm.ClassWriter classWriter3 = classWriter2;
        int length = fieldInfoArr2.length;
        int i2 = 0;
        while (i2 < length) {
            com.alibaba.fastjson.util.FieldInfo fieldInfo3 = fieldInfoArr2[i2];
            if (!fieldInfo3.fieldClass.isPrimitive() && fieldInfo3.fieldClass != java.lang.String.class) {
                new com.alibaba.fastjson.asm.FieldWriter(classWriter3, 1, fieldInfo3.name + "_asm_fieldType", "Ljava/lang/reflect/Type;").visitEnd();
                if (java.util.List.class.isAssignableFrom(fieldInfo3.fieldClass)) {
                    new com.alibaba.fastjson.asm.FieldWriter(classWriter3, 1, fieldInfo3.name + "_asm_list_item_ser_", ObjectSerializer_desc).visitEnd();
                }
                new com.alibaba.fastjson.asm.FieldWriter(classWriter3, 1, fieldInfo3.name + "_asm_ser_", ObjectSerializer_desc).visitEnd();
            }
            i2++;
            str4 = str4;
        }
        java.lang.String str6 = str4;
        com.alibaba.fastjson.asm.MethodWriter methodWriter = new com.alibaba.fastjson.asm.MethodWriter(classWriter3, 1, "<init>", com.taobao.weex.el.parse.Operators.BRACKET_START_STR + com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) com.alibaba.fastjson.serializer.SerializeBeanInfo.class) + ")V", null, null);
        int i3 = 25;
        methodWriter.visitVarInsn(25, 0);
        methodWriter.visitVarInsn(25, 1);
        methodWriter.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESPECIAL, JavaBeanSerializer, "<init>", com.taobao.weex.el.parse.Operators.BRACKET_START_STR + com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) com.alibaba.fastjson.serializer.SerializeBeanInfo.class) + ")V");
        int i4 = 0;
        while (i4 < fieldInfoArr2.length) {
            com.alibaba.fastjson.util.FieldInfo fieldInfo4 = fieldInfoArr2[i4];
            if (!fieldInfo4.fieldClass.isPrimitive() && fieldInfo4.fieldClass != java.lang.String.class) {
                methodWriter.visitVarInsn(i3, 0);
                if (fieldInfo4.method != null) {
                    methodWriter.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(com.alibaba.fastjson.util.ASMUtils.desc(fieldInfo4.declaringClass)));
                    methodWriter.visitLdcInsn(fieldInfo4.method.getName());
                    methodWriter.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, com.alibaba.fastjson.util.ASMUtils.type(com.alibaba.fastjson.util.ASMUtils.class), "getMethodType", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;");
                } else {
                    methodWriter.visitVarInsn(25, 0);
                    methodWriter.visitLdcInsn(java.lang.Integer.valueOf(i4));
                    methodWriter.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESPECIAL, JavaBeanSerializer, "getFieldType", "(I)Ljava/lang/reflect/Type;");
                }
                methodWriter.visitFieldInsn(com.alibaba.fastjson.asm.Opcodes.PUTFIELD, str, fieldInfo4.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            }
            i4++;
            i3 = 25;
        }
        methodWriter.visitInsn(com.alibaba.fastjson.asm.Opcodes.RETURN);
        methodWriter.visitMaxs(4, 4);
        methodWriter.visitEnd();
        if (jSONType == null) {
            z = false;
            break;
        }
        com.alibaba.fastjson.serializer.SerializerFeature[] serializerFeatureArrSerialzeFeatures = jSONType.serialzeFeatures();
        int length2 = serializerFeatureArrSerialzeFeatures.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length2) {
                z = false;
                break;
            }
            if (serializerFeatureArrSerialzeFeatures[i5] == com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect) {
                z = true;
                break;
            }
            i5++;
        }
        int i6 = 0;
        while (true) {
            com.alibaba.fastjson.annotation.JSONType jSONType2 = jSONType;
            z2 = z7;
            if (i6 >= 3) {
                break;
            }
            if (i6 == 0) {
                str3 = "write";
                z6 = z;
                z5 = true;
            } else if (i6 == 1) {
                str3 = "writeNormal";
                z6 = z;
                z5 = false;
            } else {
                str3 = "writeDirectNonContext";
                z5 = true;
                z6 = true;
            }
            java.lang.String str7 = str6;
            com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context = new com.alibaba.fastjson.serializer.ASMSerializerFactory.Context(fieldInfoArr2, serializeBeanInfo2, str, z5, z6);
            int i7 = i6;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("(L");
            java.lang.String str8 = JSONSerializer;
            sb.append(str8);
            sb.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            com.alibaba.fastjson.asm.MethodWriter methodWriter2 = new com.alibaba.fastjson.asm.MethodWriter(classWriter3, 1, str3, sb.toString(), null, new java.lang.String[]{"java/io/IOException"});
            com.alibaba.fastjson.asm.Label label = new com.alibaba.fastjson.asm.Label();
            methodWriter2.visitVarInsn(25, 2);
            methodWriter2.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFNONNULL, label);
            methodWriter2.visitVarInsn(25, 1);
            boolean z8 = z6;
            methodWriter2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str8, "writeNull", "()V");
            methodWriter2.visitInsn(com.alibaba.fastjson.asm.Opcodes.RETURN);
            methodWriter2.visitLabel(label);
            methodWriter2.visitVarInsn(25, 1);
            methodWriter2.visitFieldInsn(180, str8, "out", SerializeWriter_desc);
            methodWriter2.visitVarInsn(58, context.var("out"));
            if (!z2 && !context.writeDirect && (jSONType2 == null || jSONType2.alphabetic())) {
                com.alibaba.fastjson.asm.Label label2 = new com.alibaba.fastjson.asm.Label();
                methodWriter2.visitVarInsn(25, context.var("out"));
                methodWriter2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "isSortField", "()Z");
                methodWriter2.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFNE, label2);
                methodWriter2.visitVarInsn(25, 0);
                methodWriter2.visitVarInsn(25, 1);
                methodWriter2.visitVarInsn(25, 2);
                methodWriter2.visitVarInsn(25, 3);
                methodWriter2.visitVarInsn(25, 4);
                methodWriter2.visitVarInsn(21, 5);
                methodWriter2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str, "writeUnsorted", "(L" + str8 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                methodWriter2.visitInsn(com.alibaba.fastjson.asm.Opcodes.RETURN);
                methodWriter2.visitLabel(label2);
            }
            if (!context.writeDirect || z8) {
                i = com.alibaba.fastjson.asm.Opcodes.RETURN;
            } else {
                com.alibaba.fastjson.asm.Label label3 = new com.alibaba.fastjson.asm.Label();
                com.alibaba.fastjson.asm.Label label4 = new com.alibaba.fastjson.asm.Label();
                methodWriter2.visitVarInsn(25, 0);
                methodWriter2.visitVarInsn(25, 1);
                methodWriter2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "writeDirect", "(L" + str8 + ";)Z");
                methodWriter2.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFNE, label4);
                methodWriter2.visitVarInsn(25, 0);
                methodWriter2.visitVarInsn(25, 1);
                methodWriter2.visitVarInsn(25, 2);
                methodWriter2.visitVarInsn(25, 3);
                methodWriter2.visitVarInsn(25, 4);
                methodWriter2.visitVarInsn(21, 5);
                methodWriter2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str, "writeNormal", "(L" + str8 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                methodWriter2.visitInsn(com.alibaba.fastjson.asm.Opcodes.RETURN);
                methodWriter2.visitLabel(label4);
                methodWriter2.visitVarInsn(25, context.var("out"));
                methodWriter2.visitLdcInsn(java.lang.Integer.valueOf(com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect.mask));
                methodWriter2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
                methodWriter2.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label3);
                methodWriter2.visitVarInsn(25, 0);
                methodWriter2.visitVarInsn(25, 1);
                methodWriter2.visitVarInsn(25, 2);
                methodWriter2.visitVarInsn(25, 3);
                methodWriter2.visitVarInsn(25, 4);
                methodWriter2.visitVarInsn(21, 5);
                methodWriter2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str, "writeDirectNonContext", "(L" + str8 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                i = com.alibaba.fastjson.asm.Opcodes.RETURN;
                methodWriter2.visitInsn(com.alibaba.fastjson.asm.Opcodes.RETURN);
                methodWriter2.visitLabel(label3);
            }
            methodWriter2.visitVarInsn(25, 2);
            methodWriter2.visitTypeInsn(192, com.alibaba.fastjson.util.ASMUtils.type(cls));
            methodWriter2.visitVarInsn(58, context.var("entity"));
            generateWriteMethod(cls, methodWriter2, fieldInfoArr2, context);
            methodWriter2.visitInsn(i);
            methodWriter2.visitMaxs(7, context.variantIndex + 2);
            methodWriter2.visitEnd();
            i6 = i7 + 1;
            serializeBeanInfo2 = serializeBeanInfo;
            jSONType = jSONType2;
            z7 = z2;
            str6 = str7;
            classWriter3 = classWriter3;
            fieldInfoArr = fieldInfoArr;
        }
        com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr3 = fieldInfoArr;
        com.alibaba.fastjson.asm.ClassWriter classWriter4 = classWriter3;
        java.lang.String str9 = "(L";
        java.lang.String str10 = str6;
        if (z2) {
            classWriter = classWriter4;
        } else {
            com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context2 = new com.alibaba.fastjson.serializer.ASMSerializerFactory.Context(fieldInfoArr2, serializeBeanInfo, str, false, z);
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder(str9);
            java.lang.String str11 = JSONSerializer;
            sb2.append(str11);
            sb2.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            str9 = str9;
            classWriter = classWriter4;
            com.alibaba.fastjson.asm.MethodWriter methodWriter3 = new com.alibaba.fastjson.asm.MethodWriter(classWriter, 1, "writeUnsorted", sb2.toString(), null, new java.lang.String[]{"java/io/IOException"});
            methodWriter3.visitVarInsn(25, 1);
            methodWriter3.visitFieldInsn(180, str11, "out", SerializeWriter_desc);
            methodWriter3.visitVarInsn(58, context2.var("out"));
            methodWriter3.visitVarInsn(25, 2);
            methodWriter3.visitTypeInsn(192, com.alibaba.fastjson.util.ASMUtils.type(cls));
            methodWriter3.visitVarInsn(58, context2.var("entity"));
            generateWriteMethod(cls, methodWriter3, fieldInfoArr3, context2);
            methodWriter3.visitInsn(com.alibaba.fastjson.asm.Opcodes.RETURN);
            methodWriter3.visitMaxs(7, context2.variantIndex + 2);
            methodWriter3.visitEnd();
        }
        int i8 = 0;
        while (i8 < 3) {
            if (i8 == 0) {
                str2 = "writeAsArray";
                z4 = z;
                z3 = true;
            } else if (i8 == 1) {
                str2 = "writeAsArrayNormal";
                z4 = z;
                z3 = false;
            } else {
                str2 = "writeAsArrayNonContext";
                z3 = true;
                z4 = true;
            }
            java.lang.String str12 = str9;
            com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context3 = new com.alibaba.fastjson.serializer.ASMSerializerFactory.Context(fieldInfoArr2, serializeBeanInfo, str, z3, z4);
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder(str12);
            java.lang.String str13 = JSONSerializer;
            sb3.append(str13);
            sb3.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            com.alibaba.fastjson.asm.MethodWriter methodWriter4 = new com.alibaba.fastjson.asm.MethodWriter(classWriter, 1, str2, sb3.toString(), null, new java.lang.String[]{"java/io/IOException"});
            methodWriter4.visitVarInsn(25, 1);
            methodWriter4.visitFieldInsn(180, str13, "out", SerializeWriter_desc);
            methodWriter4.visitVarInsn(58, context3.var("out"));
            methodWriter4.visitVarInsn(25, 2);
            methodWriter4.visitTypeInsn(192, com.alibaba.fastjson.util.ASMUtils.type(cls));
            methodWriter4.visitVarInsn(58, context3.var("entity"));
            generateWriteAsArray(cls, methodWriter4, fieldInfoArr2, context3);
            methodWriter4.visitInsn(com.alibaba.fastjson.asm.Opcodes.RETURN);
            methodWriter4.visitMaxs(7, context3.variantIndex + 2);
            methodWriter4.visitEnd();
            i8++;
            str9 = str12;
        }
        byte[] byteArray = classWriter.toByteArray();
        return (com.alibaba.fastjson.serializer.JavaBeanSerializer) this.classLoader.defineClassPublic(str10, byteArray, 0, byteArray.length).getConstructor(com.alibaba.fastjson.serializer.SerializeBeanInfo.class).newInstance(serializeBeanInfo);
    }

    private void generateWriteAsArray(java.lang.Class<?> cls, com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context) throws java.lang.Exception {
        java.lang.String str;
        com.alibaba.fastjson.serializer.ASMSerializerFactory aSMSerializerFactory;
        int i;
        java.lang.reflect.Type type;
        java.lang.Class<?> cls2;
        java.lang.Class<?> cls3;
        java.lang.String str2;
        int i2;
        int i3;
        java.lang.String str3;
        int i4;
        com.alibaba.fastjson.serializer.ASMSerializerFactory aSMSerializerFactory2 = this;
        com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr2 = fieldInfoArr;
        com.alibaba.fastjson.asm.Label label = new com.alibaba.fastjson.asm.Label();
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 0);
        java.lang.String str4 = JSONSerializer;
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str4, "hasPropertyFilters", com.taobao.weex.el.parse.Operators.BRACKET_START_STR + SerializeFilterable_desc + ")Z");
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFNE, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(25, 3);
        methodVisitor.visitVarInsn(25, 4);
        methodVisitor.visitVarInsn(21, 5);
        java.lang.String str5 = JavaBeanSerializer;
        java.lang.String str6 = "(L";
        java.lang.StringBuilder sb = new java.lang.StringBuilder("(L");
        sb.append(str4);
        java.lang.String str7 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V";
        sb.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESPECIAL, str5, "writeNoneASM", sb.toString());
        methodVisitor.visitInsn(com.alibaba.fastjson.asm.Opcodes.RETURN);
        methodVisitor.visitLabel(label);
        java.lang.String str8 = "out";
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(16, 91);
        java.lang.String str9 = SerializeWriter;
        java.lang.String str10 = "(I)V";
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str9, "write", "(I)V");
        char c = 0;
        int length = fieldInfoArr2.length;
        if (length == 0) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(16, 93);
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str9, "write", "(I)V");
            return;
        }
        int i5 = 0;
        while (i5 < length) {
            int i6 = i5 == length + (-1) ? 93 : 44;
            com.alibaba.fastjson.util.FieldInfo fieldInfo = fieldInfoArr2[i5];
            java.lang.Class<?> cls4 = fieldInfo.fieldClass;
            methodVisitor.visitLdcInsn(fieldInfo.name);
            methodVisitor.visitVarInsn(58, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
            if (cls4 == java.lang.Byte.TYPE || cls4 == java.lang.Short.TYPE || cls4 == java.lang.Integer.TYPE) {
                str8 = str8;
                int i7 = i6;
                length = length;
                i5 = i5;
                str6 = str6;
                str10 = str10;
                str = str7;
                methodVisitor.visitVarInsn(25, context.var(str8));
                methodVisitor.visitInsn(89);
                aSMSerializerFactory = this;
                aSMSerializerFactory._get(methodVisitor, context, fieldInfo);
                java.lang.String str11 = SerializeWriter;
                methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str11, "writeInt", str10);
                methodVisitor.visitVarInsn(16, i7);
                methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str11, "write", str10);
            } else {
                if (cls4 == java.lang.Long.TYPE) {
                    methodVisitor.visitVarInsn(25, context.var(str8));
                    methodVisitor.visitInsn(89);
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    java.lang.String str12 = SerializeWriter;
                    methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str12, "writeLong", "(J)V");
                    methodVisitor.visitVarInsn(16, i6);
                    methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str12, "write", str10);
                } else if (cls4 == java.lang.Float.TYPE) {
                    methodVisitor.visitVarInsn(25, context.var(str8));
                    methodVisitor.visitInsn(89);
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    methodVisitor.visitInsn(4);
                    java.lang.String str13 = SerializeWriter;
                    methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str13, "writeFloat", "(FZ)V");
                    methodVisitor.visitVarInsn(16, i6);
                    methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str13, "write", str10);
                } else if (cls4 == java.lang.Double.TYPE) {
                    methodVisitor.visitVarInsn(25, context.var(str8));
                    methodVisitor.visitInsn(89);
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    methodVisitor.visitInsn(4);
                    java.lang.String str14 = SerializeWriter;
                    methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str14, "writeDouble", "(DZ)V");
                    methodVisitor.visitVarInsn(16, i6);
                    methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str14, "write", str10);
                } else if (cls4 == java.lang.Boolean.TYPE) {
                    methodVisitor.visitVarInsn(25, context.var(str8));
                    methodVisitor.visitInsn(89);
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    java.lang.String str15 = SerializeWriter;
                    methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str15, "write", "(Z)V");
                    methodVisitor.visitVarInsn(16, i6);
                    methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str15, "write", str10);
                } else if (cls4 == java.lang.Character.TYPE) {
                    methodVisitor.visitVarInsn(25, context.var(str8));
                    aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                    methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Character", "toString", "(C)Ljava/lang/String;");
                    methodVisitor.visitVarInsn(16, i6);
                    methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeString", "(Ljava/lang/String;C)V");
                } else {
                    if (cls4 == java.lang.String.class) {
                        methodVisitor.visitVarInsn(25, context.var(str8));
                        aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                        methodVisitor.visitVarInsn(16, i6);
                        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeString", "(Ljava/lang/String;C)V");
                    } else if (cls4.isEnum()) {
                        methodVisitor.visitVarInsn(25, context.var(str8));
                        methodVisitor.visitInsn(89);
                        aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                        java.lang.String str16 = SerializeWriter;
                        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str16, "writeEnum", "(Ljava/lang/Enum;)V");
                        methodVisitor.visitVarInsn(16, i6);
                        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str16, "write", str10);
                    } else if (java.util.List.class.isAssignableFrom(cls4)) {
                        java.lang.reflect.Type type2 = fieldInfo.fieldType;
                        if (type2 instanceof java.lang.Class) {
                            type = java.lang.Object.class;
                        } else {
                            type = ((java.lang.reflect.ParameterizedType) type2).getActualTypeArguments()[c];
                        }
                        if (!(type instanceof java.lang.Class) || (cls2 = (java.lang.Class) type) == java.lang.Object.class) {
                            cls2 = null;
                        }
                        aSMSerializerFactory2._get(methodVisitor, context, fieldInfo);
                        java.lang.reflect.Type type3 = type;
                        methodVisitor.visitTypeInsn(192, "java/util/List");
                        length = length;
                        methodVisitor.visitVarInsn(58, context.var(com.taobao.weex.ui.component.WXBasicComponentType.LIST));
                        if (cls2 == java.lang.String.class && context.writeDirect) {
                            methodVisitor.visitVarInsn(25, context.var(str8));
                            methodVisitor.visitVarInsn(25, context.var(com.taobao.weex.ui.component.WXBasicComponentType.LIST));
                            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "write", "(Ljava/util/List;)V");
                            str2 = str8;
                            str6 = str6;
                            str3 = str10;
                            i3 = 16;
                            i2 = 25;
                            str = str7;
                            i4 = com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL;
                        } else {
                            com.alibaba.fastjson.asm.Label label2 = new com.alibaba.fastjson.asm.Label();
                            com.alibaba.fastjson.asm.Label label3 = new com.alibaba.fastjson.asm.Label();
                            methodVisitor.visitVarInsn(25, context.var(com.taobao.weex.ui.component.WXBasicComponentType.LIST));
                            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFNONNULL, label3);
                            methodVisitor.visitVarInsn(25, context.var(str8));
                            java.lang.String str17 = SerializeWriter;
                            java.lang.String str18 = str7;
                            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str17, "writeNull", "()V");
                            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label2);
                            methodVisitor.visitLabel(label3);
                            methodVisitor.visitVarInsn(25, context.var(com.taobao.weex.ui.component.WXBasicComponentType.LIST));
                            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEINTERFACE, "java/util/List", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, "()I");
                            methodVisitor.visitVarInsn(54, context.var(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE));
                            methodVisitor.visitVarInsn(25, context.var(str8));
                            methodVisitor.visitVarInsn(16, 91);
                            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str17, "write", str10);
                            com.alibaba.fastjson.asm.Label label4 = new com.alibaba.fastjson.asm.Label();
                            com.alibaba.fastjson.asm.Label label5 = new com.alibaba.fastjson.asm.Label();
                            com.alibaba.fastjson.asm.Label label6 = new com.alibaba.fastjson.asm.Label();
                            methodVisitor.visitInsn(3);
                            java.lang.String str19 = str6;
                            methodVisitor.visitVarInsn(54, context.var(com.facebook.common.callercontext.ContextChain.TAG_INFRA));
                            methodVisitor.visitLabel(label4);
                            methodVisitor.visitVarInsn(21, context.var(com.facebook.common.callercontext.ContextChain.TAG_INFRA));
                            methodVisitor.visitVarInsn(21, context.var(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE));
                            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IF_ICMPGE, label6);
                            methodVisitor.visitVarInsn(21, context.var(com.facebook.common.callercontext.ContextChain.TAG_INFRA));
                            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label5);
                            methodVisitor.visitVarInsn(25, context.var(str8));
                            methodVisitor.visitVarInsn(16, 44);
                            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str17, "write", str10);
                            methodVisitor.visitLabel(label5);
                            methodVisitor.visitVarInsn(25, context.var(com.taobao.weex.ui.component.WXBasicComponentType.LIST));
                            methodVisitor.visitVarInsn(21, context.var(com.facebook.common.callercontext.ContextChain.TAG_INFRA));
                            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEINTERFACE, "java/util/List", "get", "(I)Ljava/lang/Object;");
                            methodVisitor.visitVarInsn(58, context.var("list_item"));
                            com.alibaba.fastjson.asm.Label label7 = new com.alibaba.fastjson.asm.Label();
                            com.alibaba.fastjson.asm.Label label8 = new com.alibaba.fastjson.asm.Label();
                            java.lang.String str20 = str10;
                            methodVisitor.visitVarInsn(25, context.var("list_item"));
                            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFNONNULL, label8);
                            methodVisitor.visitVarInsn(25, context.var(str8));
                            java.lang.String str21 = str8;
                            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str17, "writeNull", "()V");
                            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label7);
                            methodVisitor.visitLabel(label8);
                            com.alibaba.fastjson.asm.Label label9 = new com.alibaba.fastjson.asm.Label();
                            com.alibaba.fastjson.asm.Label label10 = new com.alibaba.fastjson.asm.Label();
                            if (cls2 == null || !java.lang.reflect.Modifier.isPublic(cls2.getModifiers())) {
                                label4 = label4;
                                cls3 = cls2;
                                str = str18;
                                str6 = str19;
                                label7 = label7;
                            } else {
                                methodVisitor.visitVarInsn(25, context.var("list_item"));
                                methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                                methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(com.alibaba.fastjson.util.ASMUtils.desc(cls2)));
                                methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IF_ACMPNE, label10);
                                aSMSerializerFactory2._getListFieldItemSer(context, methodVisitor, fieldInfo, cls2);
                                methodVisitor.visitVarInsn(58, context.var("list_item_desc"));
                                com.alibaba.fastjson.asm.Label label11 = new com.alibaba.fastjson.asm.Label();
                                com.alibaba.fastjson.asm.Label label12 = new com.alibaba.fastjson.asm.Label();
                                if (context.writeDirect) {
                                    methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                                    java.lang.String str22 = JavaBeanSerializer;
                                    methodVisitor.visitTypeInsn(com.alibaba.fastjson.asm.Opcodes.INSTANCEOF, str22);
                                    methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label11);
                                    cls3 = cls2;
                                    methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                                    methodVisitor.visitTypeInsn(192, str22);
                                    methodVisitor.visitVarInsn(25, 1);
                                    methodVisitor.visitVarInsn(25, context.var("list_item"));
                                    if (context.nonContext) {
                                        methodVisitor.visitInsn(1);
                                    } else {
                                        methodVisitor.visitVarInsn(21, context.var(com.facebook.common.callercontext.ContextChain.TAG_INFRA));
                                        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                    }
                                    methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(com.alibaba.fastjson.util.ASMUtils.desc(cls3)));
                                    methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(fieldInfo.serialzeFeatures));
                                    str6 = str19;
                                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder(str6);
                                    sb2.append(JSONSerializer);
                                    str = str18;
                                    sb2.append(str);
                                    methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str22, "writeAsArrayNonContext", sb2.toString());
                                    methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label12);
                                    methodVisitor.visitLabel(label11);
                                } else {
                                    label4 = label4;
                                    cls3 = cls2;
                                    str = str18;
                                    str6 = str19;
                                }
                                methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                                methodVisitor.visitVarInsn(25, 1);
                                methodVisitor.visitVarInsn(25, context.var("list_item"));
                                if (context.nonContext) {
                                    methodVisitor.visitInsn(1);
                                } else {
                                    methodVisitor.visitVarInsn(21, context.var(com.facebook.common.callercontext.ContextChain.TAG_INFRA));
                                    methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                }
                                methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(com.alibaba.fastjson.util.ASMUtils.desc(cls3)));
                                methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(fieldInfo.serialzeFeatures));
                                methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEINTERFACE, ObjectSerializer, "write", str6 + JSONSerializer + str);
                                methodVisitor.visitLabel(label12);
                                methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label9);
                            }
                            methodVisitor.visitLabel(label10);
                            methodVisitor.visitVarInsn(25, 1);
                            methodVisitor.visitVarInsn(25, context.var("list_item"));
                            if (context.nonContext) {
                                methodVisitor.visitInsn(1);
                            } else {
                                methodVisitor.visitVarInsn(21, context.var(com.facebook.common.callercontext.ContextChain.TAG_INFRA));
                                methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                            }
                            if (cls3 != null && java.lang.reflect.Modifier.isPublic(cls3.getModifiers())) {
                                methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) type3)));
                                methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(fieldInfo.serialzeFeatures));
                                methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                            } else {
                                methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                            }
                            methodVisitor.visitLabel(label9);
                            methodVisitor.visitLabel(label7);
                            methodVisitor.visitIincInsn(context.var(com.facebook.common.callercontext.ContextChain.TAG_INFRA), 1);
                            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label4);
                            methodVisitor.visitLabel(label6);
                            str2 = str21;
                            i2 = 25;
                            methodVisitor.visitVarInsn(25, context.var(str2));
                            i3 = 16;
                            methodVisitor.visitVarInsn(16, 93);
                            str3 = str20;
                            i4 = com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL;
                            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str17, "write", str3);
                            methodVisitor.visitLabel(label2);
                        }
                        methodVisitor.visitVarInsn(i2, context.var(str2));
                        methodVisitor.visitVarInsn(i3, i6);
                        methodVisitor.visitMethodInsn(i4, SerializeWriter, "write", str3);
                        aSMSerializerFactory = this;
                        str8 = str2;
                        str10 = str3;
                    } else {
                        java.lang.String str23 = str8;
                        int i8 = i6;
                        length = length;
                        i5 = i5;
                        str6 = str6;
                        java.lang.String str24 = str10;
                        str = str7;
                        com.alibaba.fastjson.asm.Label label13 = new com.alibaba.fastjson.asm.Label();
                        com.alibaba.fastjson.asm.Label label14 = new com.alibaba.fastjson.asm.Label();
                        _get(methodVisitor, context, fieldInfo);
                        methodVisitor.visitInsn(89);
                        methodVisitor.visitVarInsn(58, context.var("field_" + fieldInfo.fieldClass.getName()));
                        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFNONNULL, label14);
                        methodVisitor.visitVarInsn(25, context.var(str23));
                        java.lang.String str25 = SerializeWriter;
                        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str25, "writeNull", "()V");
                        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label13);
                        methodVisitor.visitLabel(label14);
                        com.alibaba.fastjson.asm.Label label15 = new com.alibaba.fastjson.asm.Label();
                        com.alibaba.fastjson.asm.Label label16 = new com.alibaba.fastjson.asm.Label();
                        methodVisitor.visitVarInsn(25, context.var("field_" + fieldInfo.fieldClass.getName()));
                        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                        methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(com.alibaba.fastjson.util.ASMUtils.desc(cls4)));
                        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IF_ACMPNE, label16);
                        _getFieldSer(context, methodVisitor, fieldInfo);
                        methodVisitor.visitVarInsn(58, context.var("fied_ser"));
                        com.alibaba.fastjson.asm.Label label17 = new com.alibaba.fastjson.asm.Label();
                        com.alibaba.fastjson.asm.Label label18 = new com.alibaba.fastjson.asm.Label();
                        if (context.writeDirect && java.lang.reflect.Modifier.isPublic(cls4.getModifiers())) {
                            methodVisitor.visitVarInsn(25, context.var("fied_ser"));
                            java.lang.String str26 = JavaBeanSerializer;
                            methodVisitor.visitTypeInsn(com.alibaba.fastjson.asm.Opcodes.INSTANCEOF, str26);
                            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label17);
                            methodVisitor.visitVarInsn(25, context.var("fied_ser"));
                            methodVisitor.visitTypeInsn(192, str26);
                            methodVisitor.visitVarInsn(25, 1);
                            methodVisitor.visitVarInsn(25, context.var("field_" + fieldInfo.fieldClass.getName()));
                            methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
                            methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(com.alibaba.fastjson.util.ASMUtils.desc(cls4)));
                            methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(fieldInfo.serialzeFeatures));
                            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str26, "writeAsArrayNonContext", str6 + JSONSerializer + str);
                            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label18);
                            methodVisitor.visitLabel(label17);
                        }
                        methodVisitor.visitVarInsn(25, context.var("fied_ser"));
                        methodVisitor.visitVarInsn(25, 1);
                        methodVisitor.visitVarInsn(25, context.var("field_" + fieldInfo.fieldClass.getName()));
                        methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
                        methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(com.alibaba.fastjson.util.ASMUtils.desc(cls4)));
                        methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(fieldInfo.serialzeFeatures));
                        java.lang.String str27 = ObjectSerializer;
                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder(str6);
                        java.lang.String str28 = JSONSerializer;
                        sb3.append(str28);
                        sb3.append(str);
                        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEINTERFACE, str27, "write", sb3.toString());
                        methodVisitor.visitLabel(label18);
                        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label15);
                        methodVisitor.visitLabel(label16);
                        java.lang.String format = fieldInfo.getFormat();
                        methodVisitor.visitVarInsn(25, 1);
                        methodVisitor.visitVarInsn(25, context.var("field_" + fieldInfo.fieldClass.getName()));
                        if (format != null) {
                            methodVisitor.visitLdcInsn(format);
                            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str28, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
                            i = com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL;
                        } else {
                            methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
                            if ((fieldInfo.fieldType instanceof java.lang.Class) && ((java.lang.Class) fieldInfo.fieldType).isPrimitive()) {
                                i = com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL;
                                methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str28, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                            } else {
                                methodVisitor.visitVarInsn(25, 0);
                                methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                                methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(fieldInfo.serialzeFeatures));
                                i = com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL;
                                methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str28, r7, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                            }
                        }
                        methodVisitor.visitLabel(label15);
                        methodVisitor.visitLabel(label13);
                        str8 = str23;
                        methodVisitor.visitVarInsn(25, context.var(str8));
                        methodVisitor.visitVarInsn(16, i8);
                        str10 = str24;
                        methodVisitor.visitMethodInsn(i, str25, "write", str10);
                        aSMSerializerFactory = this;
                    }
                    str = str7;
                    aSMSerializerFactory = aSMSerializerFactory2;
                }
                str = str7;
                aSMSerializerFactory = aSMSerializerFactory2;
            }
            i5++;
            str6 = str6;
            aSMSerializerFactory2 = aSMSerializerFactory;
            str7 = str;
            length = length;
            c = 0;
            str8 = str8;
            str10 = str10;
            fieldInfoArr2 = fieldInfoArr;
        }
    }

    private void generateWriteMethod(java.lang.Class<?> cls, com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo[] fieldInfoArr, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context) throws java.lang.Exception {
        java.lang.String str;
        int i;
        com.alibaba.fastjson.serializer.ASMSerializerFactory aSMSerializerFactory = this;
        com.alibaba.fastjson.asm.MethodVisitor methodVisitor2 = methodVisitor;
        com.alibaba.fastjson.asm.Label label = new com.alibaba.fastjson.asm.Label();
        if (!context.writeDirect) {
            com.alibaba.fastjson.asm.Label label2 = new com.alibaba.fastjson.asm.Label();
            com.alibaba.fastjson.asm.Label label3 = new com.alibaba.fastjson.asm.Label();
            methodVisitor2.visitVarInsn(25, context.var("out"));
            methodVisitor2.visitLdcInsn(java.lang.Integer.valueOf(com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat.mask));
            methodVisitor2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor2.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFNE, label3);
            int length = fieldInfoArr.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    if (fieldInfoArr[i2].method != null) {
                        methodVisitor2.visitVarInsn(25, context.var("out"));
                        methodVisitor2.visitLdcInsn(java.lang.Integer.valueOf(com.alibaba.fastjson.serializer.SerializerFeature.IgnoreErrorGetter.mask));
                        methodVisitor2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
                        methodVisitor2.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label2);
                        break;
                    }
                    i2++;
                } else {
                    methodVisitor2.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label2);
                    break;
                }
            }
            methodVisitor2.visitLabel(label3);
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitVarInsn(25, 4);
            methodVisitor2.visitVarInsn(21, 5);
            methodVisitor2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESPECIAL, JavaBeanSerializer, "write", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor2.visitInsn(com.alibaba.fastjson.asm.Opcodes.RETURN);
            methodVisitor2.visitLabel(label2);
        }
        if (!context.nonContext) {
            com.alibaba.fastjson.asm.Label label4 = new com.alibaba.fastjson.asm.Label();
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(21, 5);
            methodVisitor2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "writeReference", "(L" + JSONSerializer + ";Ljava/lang/Object;I)Z");
            methodVisitor2.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label4);
            methodVisitor2.visitInsn(com.alibaba.fastjson.asm.Opcodes.RETURN);
            methodVisitor2.visitLabel(label4);
        }
        if (context.writeDirect) {
            if (context.nonContext) {
                str = "writeAsArrayNonContext";
            } else {
                str = "writeAsArray";
            }
        } else {
            str = "writeAsArrayNormal";
        }
        if ((context.beanInfo.features & com.alibaba.fastjson.serializer.SerializerFeature.BeanToArray.mask) == 0) {
            com.alibaba.fastjson.asm.Label label5 = new com.alibaba.fastjson.asm.Label();
            methodVisitor2.visitVarInsn(25, context.var("out"));
            methodVisitor2.visitLdcInsn(java.lang.Integer.valueOf(com.alibaba.fastjson.serializer.SerializerFeature.BeanToArray.mask));
            methodVisitor2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor2.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label5);
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitVarInsn(25, 4);
            methodVisitor2.visitVarInsn(21, 5);
            methodVisitor2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, context.className, str, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor2.visitInsn(com.alibaba.fastjson.asm.Opcodes.RETURN);
            methodVisitor2.visitLabel(label5);
        } else {
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitVarInsn(25, 4);
            methodVisitor2.visitVarInsn(21, 5);
            methodVisitor2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, context.className, str, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor2.visitInsn(com.alibaba.fastjson.asm.Opcodes.RETURN);
        }
        java.lang.String str2 = "parent";
        if (!context.nonContext) {
            methodVisitor2.visitVarInsn(25, 1);
            java.lang.String str3 = JSONSerializer;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("()");
            java.lang.String str4 = SerialContext_desc;
            sb.append(str4);
            methodVisitor2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str3, "getContext", sb.toString());
            methodVisitor2.visitVarInsn(58, context.var("parent"));
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, context.var("parent"));
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitLdcInsn(java.lang.Integer.valueOf(context.beanInfo.features));
            methodVisitor2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str3, "setContext", com.taobao.weex.el.parse.Operators.BRACKET_START_STR + str4 + "Ljava/lang/Object;Ljava/lang/Object;I)V");
        }
        boolean z = (context.beanInfo.features & com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName.mask) != 0;
        if (z || !context.writeDirect) {
            com.alibaba.fastjson.asm.Label label6 = new com.alibaba.fastjson.asm.Label();
            com.alibaba.fastjson.asm.Label label7 = new com.alibaba.fastjson.asm.Label();
            com.alibaba.fastjson.asm.Label label8 = new com.alibaba.fastjson.asm.Label();
            if (z) {
                i = com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL;
            } else {
                methodVisitor2.visitVarInsn(25, 1);
                methodVisitor2.visitVarInsn(25, 4);
                methodVisitor2.visitVarInsn(25, 2);
                java.lang.String str5 = JSONSerializer;
                i = com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL;
                methodVisitor2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str5, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
                methodVisitor2.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label7);
            }
            methodVisitor2.visitVarInsn(25, 4);
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitMethodInsn(i, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            methodVisitor2.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IF_ACMPEQ, label7);
            methodVisitor2.visitLabel(label8);
            methodVisitor2.visitVarInsn(25, context.var("out"));
            methodVisitor2.visitVarInsn(16, 123);
            methodVisitor2.visitMethodInsn(i, SerializeWriter, "write", "(I)V");
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitVarInsn(25, 1);
            if (context.beanInfo.typeKey != null) {
                methodVisitor2.visitLdcInsn(context.beanInfo.typeKey);
            } else {
                methodVisitor2.visitInsn(1);
            }
            methodVisitor2.visitVarInsn(25, 2);
            methodVisitor2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "writeClassName", "(L" + JSONSerializer + ";Ljava/lang/String;Ljava/lang/Object;)V");
            methodVisitor2.visitVarInsn(16, 44);
            methodVisitor2.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label6);
            methodVisitor2.visitLabel(label7);
            methodVisitor2.visitVarInsn(16, 123);
            methodVisitor2.visitLabel(label6);
        } else {
            methodVisitor2.visitVarInsn(16, 123);
            str2 = "parent";
        }
        methodVisitor2.visitVarInsn(54, context.var("seperator"));
        if (!context.writeDirect) {
            aSMSerializerFactory._before(methodVisitor2, context);
        }
        if (!context.writeDirect) {
            methodVisitor2.visitVarInsn(25, context.var("out"));
            methodVisitor2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "isNotWriteDefaultValue", "()Z");
            methodVisitor2.visitVarInsn(54, context.var("notWriteDefaultValue"));
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 0);
            java.lang.String str6 = JSONSerializer;
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder(com.taobao.weex.el.parse.Operators.BRACKET_START_STR);
            java.lang.String str7 = SerializeFilterable_desc;
            sb2.append(str7);
            sb2.append(")Z");
            methodVisitor2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str6, "checkValue", sb2.toString());
            methodVisitor2.visitVarInsn(54, context.var("checkValue"));
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str6, "hasNameFilters", com.taobao.weex.el.parse.Operators.BRACKET_START_STR + str7 + ")Z");
            methodVisitor2.visitVarInsn(54, context.var("hasNameFilters"));
        }
        for (com.alibaba.fastjson.util.FieldInfo fieldInfo : fieldInfoArr) {
            java.lang.Class<?> cls2 = fieldInfo.fieldClass;
            methodVisitor2.visitLdcInsn(fieldInfo.name);
            methodVisitor2.visitVarInsn(58, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
            if (cls2 == java.lang.Byte.TYPE || cls2 == java.lang.Short.TYPE || cls2 == java.lang.Integer.TYPE) {
                aSMSerializerFactory._int(cls, methodVisitor2, fieldInfo, context, context.var(cls2.getName()), 'I');
            } else if (cls2 == java.lang.Long.TYPE) {
                aSMSerializerFactory._long(cls, methodVisitor2, fieldInfo, context);
            } else if (cls2 == java.lang.Float.TYPE) {
                aSMSerializerFactory._float(cls, methodVisitor2, fieldInfo, context);
            } else if (cls2 == java.lang.Double.TYPE) {
                aSMSerializerFactory._double(cls, methodVisitor2, fieldInfo, context);
            } else if (cls2 == java.lang.Boolean.TYPE) {
                aSMSerializerFactory._int(cls, methodVisitor2, fieldInfo, context, context.var("boolean"), 'Z');
                aSMSerializerFactory = this;
                methodVisitor2 = methodVisitor;
            } else if (cls2 == java.lang.Character.TYPE) {
                aSMSerializerFactory = this;
                methodVisitor2 = methodVisitor;
                aSMSerializerFactory._int(cls, methodVisitor2, fieldInfo, context, context.var("char"), 'C');
            } else {
                aSMSerializerFactory = this;
                methodVisitor2 = methodVisitor;
                if (cls2 == java.lang.String.class) {
                    aSMSerializerFactory._string(cls, methodVisitor2, fieldInfo, context);
                } else if (cls2 == java.math.BigDecimal.class) {
                    aSMSerializerFactory._decimal(cls, methodVisitor2, fieldInfo, context);
                } else if (java.util.List.class.isAssignableFrom(cls2)) {
                    aSMSerializerFactory._list(cls, methodVisitor2, fieldInfo, context);
                } else if (cls2.isEnum()) {
                    aSMSerializerFactory._enum(cls, methodVisitor2, fieldInfo, context);
                } else {
                    aSMSerializerFactory._object(cls, methodVisitor2, fieldInfo, context);
                }
            }
        }
        if (!context.writeDirect) {
            aSMSerializerFactory._after(methodVisitor2, context);
        }
        com.alibaba.fastjson.asm.Label label9 = new com.alibaba.fastjson.asm.Label();
        com.alibaba.fastjson.asm.Label label10 = new com.alibaba.fastjson.asm.Label();
        methodVisitor2.visitVarInsn(21, context.var("seperator"));
        methodVisitor2.visitIntInsn(16, 123);
        methodVisitor2.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IF_ICMPNE, label9);
        methodVisitor2.visitVarInsn(25, context.var("out"));
        methodVisitor2.visitVarInsn(16, 123);
        java.lang.String str8 = SerializeWriter;
        methodVisitor2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str8, "write", "(I)V");
        methodVisitor2.visitLabel(label9);
        methodVisitor2.visitVarInsn(25, context.var("out"));
        methodVisitor2.visitVarInsn(16, 125);
        methodVisitor2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str8, "write", "(I)V");
        methodVisitor2.visitLabel(label10);
        methodVisitor2.visitLabel(label);
        if (context.nonContext) {
            return;
        }
        methodVisitor2.visitVarInsn(25, 1);
        methodVisitor2.visitVarInsn(25, context.var(str2));
        methodVisitor2.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JSONSerializer, "setContext", com.taobao.weex.el.parse.Operators.BRACKET_START_STR + SerialContext_desc + ")V");
    }

    private void _object(java.lang.Class<?> cls, com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo fieldInfo, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context) {
        com.alibaba.fastjson.asm.Label label = new com.alibaba.fastjson.asm.Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(58, context.var("object"));
        _filters(methodVisitor, fieldInfo, context, label);
        _writeObject(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitLabel(label);
    }

    private void _enum(java.lang.Class<?> cls, com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo fieldInfo, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context) {
        com.alibaba.fastjson.asm.Label label = new com.alibaba.fastjson.asm.Label();
        com.alibaba.fastjson.asm.Label label2 = new com.alibaba.fastjson.asm.Label();
        com.alibaba.fastjson.asm.Label label3 = new com.alibaba.fastjson.asm.Label();
        _nameApply(methodVisitor, fieldInfo, context, label3);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitTypeInsn(192, "java/lang/Enum");
        methodVisitor.visitVarInsn(58, context.var("enum"));
        _filters(methodVisitor, fieldInfo, context, label3);
        methodVisitor.visitVarInsn(25, context.var("enum"));
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFNONNULL, label);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label2);
        methodVisitor.visitLabel(label);
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var("enum"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, "java/lang/Enum", "name", "()Ljava/lang/String;");
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValueStringWithDoubleQuote", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            java.lang.String str = SerializeWriter;
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str, "write", "(I)V");
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
            methodVisitor.visitInsn(3);
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str, "writeFieldName", "(Ljava/lang/String;Z)V");
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("enum"));
            methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
            methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(com.alibaba.fastjson.util.ASMUtils.desc(fieldInfo.fieldClass)));
            methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(fieldInfo.serialzeFeatures));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        }
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label2);
        methodVisitor.visitLabel(label3);
    }

    private void _int(java.lang.Class<?> cls, com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo fieldInfo, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context, int i, char c) {
        com.alibaba.fastjson.asm.Label label = new com.alibaba.fastjson.asm.Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(54, i);
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
        methodVisitor.visitVarInsn(21, i);
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;" + c + ")V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _long(java.lang.Class<?> cls, com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo fieldInfo, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context) {
        com.alibaba.fastjson.asm.Label label = new com.alibaba.fastjson.asm.Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(55, context.var("long", 2));
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
        methodVisitor.visitVarInsn(22, context.var("long", 2));
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;J)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _float(java.lang.Class<?> cls, com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo fieldInfo, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context) {
        com.alibaba.fastjson.asm.Label label = new com.alibaba.fastjson.asm.Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(56, context.var("float"));
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
        methodVisitor.visitVarInsn(23, context.var("float"));
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;F)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _double(java.lang.Class<?> cls, com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo fieldInfo, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context) {
        com.alibaba.fastjson.asm.Label label = new com.alibaba.fastjson.asm.Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(57, context.var("double", 2));
        _filters(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
        methodVisitor.visitVarInsn(24, context.var("double", 2));
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;D)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label);
    }

    private void _get(com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context, com.alibaba.fastjson.util.FieldInfo fieldInfo) {
        java.lang.reflect.Method method = fieldInfo.method;
        if (method != null) {
            methodVisitor.visitVarInsn(25, context.var("entity"));
            java.lang.Class<?> declaringClass = method.getDeclaringClass();
            methodVisitor.visitMethodInsn(declaringClass.isInterface() ? com.alibaba.fastjson.asm.Opcodes.INVOKEINTERFACE : com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, com.alibaba.fastjson.util.ASMUtils.type(declaringClass), method.getName(), com.alibaba.fastjson.util.ASMUtils.desc(method));
            if (method.getReturnType().equals(fieldInfo.fieldClass)) {
                return;
            }
            methodVisitor.visitTypeInsn(192, com.alibaba.fastjson.util.ASMUtils.type(fieldInfo.fieldClass));
            return;
        }
        methodVisitor.visitVarInsn(25, context.var("entity"));
        java.lang.reflect.Field field = fieldInfo.field;
        methodVisitor.visitFieldInsn(180, com.alibaba.fastjson.util.ASMUtils.type(fieldInfo.declaringClass), field.getName(), com.alibaba.fastjson.util.ASMUtils.desc(field.getType()));
        if (field.getType().equals(fieldInfo.fieldClass)) {
            return;
        }
        methodVisitor.visitTypeInsn(192, com.alibaba.fastjson.util.ASMUtils.type(fieldInfo.fieldClass));
    }

    private void _decimal(java.lang.Class<?> cls, com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo fieldInfo, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context) {
        com.alibaba.fastjson.asm.Label label = new com.alibaba.fastjson.asm.Label();
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(58, context.var("decimal"));
        _filters(methodVisitor, fieldInfo, context, label);
        com.alibaba.fastjson.asm.Label label2 = new com.alibaba.fastjson.asm.Label();
        com.alibaba.fastjson.asm.Label label3 = new com.alibaba.fastjson.asm.Label();
        com.alibaba.fastjson.asm.Label label4 = new com.alibaba.fastjson.asm.Label();
        methodVisitor.visitLabel(label2);
        methodVisitor.visitVarInsn(25, context.var("decimal"));
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFNONNULL, label3);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label4);
        methodVisitor.visitLabel(label3);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
        methodVisitor.visitVarInsn(25, context.var("decimal"));
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/math/BigDecimal;)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label4);
        methodVisitor.visitLabel(label4);
        methodVisitor.visitLabel(label);
    }

    private void _string(java.lang.Class<?> cls, com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo fieldInfo, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context) {
        com.alibaba.fastjson.asm.Label label = new com.alibaba.fastjson.asm.Label();
        if (fieldInfo.name.equals(context.beanInfo.typeKey)) {
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 4);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JSONSerializer, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFNE, label);
        }
        _nameApply(methodVisitor, fieldInfo, context, label);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitVarInsn(58, context.var("string"));
        _filters(methodVisitor, fieldInfo, context, label);
        com.alibaba.fastjson.asm.Label label2 = new com.alibaba.fastjson.asm.Label();
        com.alibaba.fastjson.asm.Label label3 = new com.alibaba.fastjson.asm.Label();
        methodVisitor.visitVarInsn(25, context.var("string"));
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFNONNULL, label2);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label3);
        methodVisitor.visitLabel(label2);
        if (io.dcloud.common.constant.AbsoluteConst.XML_TRIM.equals(fieldInfo.format)) {
            methodVisitor.visitVarInsn(25, context.var("string"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, "java/lang/String", io.dcloud.common.constant.AbsoluteConst.XML_TRIM, "()Ljava/lang/String;");
            methodVisitor.visitVarInsn(58, context.var("string"));
        }
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var("string"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValueStringWithDoubleQuoteCheck", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
            methodVisitor.visitVarInsn(25, context.var("string"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
        }
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label3);
        methodVisitor.visitLabel(label);
    }

    private void _list(java.lang.Class<?> cls, com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo fieldInfo, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context) {
        java.lang.Class<?> cls2;
        com.alibaba.fastjson.asm.Label label;
        com.alibaba.fastjson.util.FieldInfo fieldInfo2;
        int i;
        int i2;
        int i3;
        java.lang.reflect.Type collectionItemType = com.alibaba.fastjson.util.TypeUtils.getCollectionItemType(fieldInfo.fieldType);
        java.lang.Class<?> cls3 = null;
        java.lang.Class<?> cls4 = collectionItemType instanceof java.lang.Class ? (java.lang.Class) collectionItemType : null;
        if (cls4 != java.lang.Object.class && cls4 != java.io.Serializable.class) {
            cls3 = cls4;
        }
        com.alibaba.fastjson.asm.Label label2 = new com.alibaba.fastjson.asm.Label();
        com.alibaba.fastjson.asm.Label label3 = new com.alibaba.fastjson.asm.Label();
        com.alibaba.fastjson.asm.Label label4 = new com.alibaba.fastjson.asm.Label();
        _nameApply(methodVisitor, fieldInfo, context, label2);
        _get(methodVisitor, context, fieldInfo);
        methodVisitor.visitTypeInsn(192, "java/util/List");
        methodVisitor.visitVarInsn(58, context.var(com.taobao.weex.ui.component.WXBasicComponentType.LIST));
        _filters(methodVisitor, fieldInfo, context, label2);
        methodVisitor.visitVarInsn(25, context.var(com.taobao.weex.ui.component.WXBasicComponentType.LIST));
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFNONNULL, label3);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label4);
        methodVisitor.visitLabel(label3);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        java.lang.String str = SerializeWriter;
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str, "write", "(I)V");
        _writeFieldName(methodVisitor, context);
        methodVisitor.visitVarInsn(25, context.var(com.taobao.weex.ui.component.WXBasicComponentType.LIST));
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEINTERFACE, "java/util/List", io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE, "()I");
        methodVisitor.visitVarInsn(54, context.var(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE));
        com.alibaba.fastjson.asm.Label label5 = new com.alibaba.fastjson.asm.Label();
        com.alibaba.fastjson.asm.Label label6 = new com.alibaba.fastjson.asm.Label();
        methodVisitor.visitVarInsn(21, context.var(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE));
        methodVisitor.visitInsn(3);
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IF_ICMPNE, label5);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitLdcInsn("[]");
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str, "write", "(Ljava/lang/String;)V");
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label6);
        methodVisitor.visitLabel(label5);
        if (!context.nonContext) {
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var(com.taobao.weex.ui.component.WXBasicComponentType.LIST));
            methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JSONSerializer, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)V");
        }
        if (collectionItemType == java.lang.String.class && context.writeDirect) {
            i2 = 25;
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, context.var(com.taobao.weex.ui.component.WXBasicComponentType.LIST));
            i3 = com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL;
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str, "write", "(Ljava/util/List;)V");
            i = 1;
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(16, 91);
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str, "write", "(I)V");
            com.alibaba.fastjson.asm.Label label7 = new com.alibaba.fastjson.asm.Label();
            com.alibaba.fastjson.asm.Label label8 = new com.alibaba.fastjson.asm.Label();
            com.alibaba.fastjson.asm.Label label9 = new com.alibaba.fastjson.asm.Label();
            methodVisitor.visitInsn(3);
            methodVisitor.visitVarInsn(54, context.var(com.facebook.common.callercontext.ContextChain.TAG_INFRA));
            methodVisitor.visitLabel(label7);
            methodVisitor.visitVarInsn(21, context.var(com.facebook.common.callercontext.ContextChain.TAG_INFRA));
            methodVisitor.visitVarInsn(21, context.var(io.dcloud.common.constant.AbsoluteConst.JSON_KEY_SIZE));
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IF_ICMPGE, label9);
            methodVisitor.visitVarInsn(21, context.var(com.facebook.common.callercontext.ContextChain.TAG_INFRA));
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label8);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(16, 44);
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str, "write", "(I)V");
            methodVisitor.visitLabel(label8);
            methodVisitor.visitVarInsn(25, context.var(com.taobao.weex.ui.component.WXBasicComponentType.LIST));
            methodVisitor.visitVarInsn(21, context.var(com.facebook.common.callercontext.ContextChain.TAG_INFRA));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEINTERFACE, "java/util/List", "get", "(I)Ljava/lang/Object;");
            methodVisitor.visitVarInsn(58, context.var("list_item"));
            com.alibaba.fastjson.asm.Label label10 = new com.alibaba.fastjson.asm.Label();
            com.alibaba.fastjson.asm.Label label11 = new com.alibaba.fastjson.asm.Label();
            methodVisitor.visitVarInsn(25, context.var("list_item"));
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFNONNULL, label11);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str, "writeNull", "()V");
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label10);
            methodVisitor.visitLabel(label11);
            com.alibaba.fastjson.asm.Label label12 = new com.alibaba.fastjson.asm.Label();
            com.alibaba.fastjson.asm.Label label13 = new com.alibaba.fastjson.asm.Label();
            if (cls3 == null || !java.lang.reflect.Modifier.isPublic(cls3.getModifiers())) {
                label10 = label10;
                cls2 = cls3;
                label = label12;
                fieldInfo2 = fieldInfo;
            } else {
                methodVisitor.visitVarInsn(25, context.var("list_item"));
                methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(com.alibaba.fastjson.util.ASMUtils.desc(cls3)));
                methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IF_ACMPNE, label13);
                fieldInfo2 = fieldInfo;
                _getListFieldItemSer(context, methodVisitor, fieldInfo2, cls3);
                cls2 = cls3;
                methodVisitor.visitVarInsn(58, context.var("list_item_desc"));
                com.alibaba.fastjson.asm.Label label14 = new com.alibaba.fastjson.asm.Label();
                com.alibaba.fastjson.asm.Label label15 = new com.alibaba.fastjson.asm.Label();
                if (context.writeDirect) {
                    java.lang.String str2 = (context.nonContext && context.writeDirect) ? "writeDirectNonContext" : "write";
                    methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                    java.lang.String str3 = JavaBeanSerializer;
                    methodVisitor.visitTypeInsn(com.alibaba.fastjson.asm.Opcodes.INSTANCEOF, str3);
                    methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label14);
                    methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                    methodVisitor.visitTypeInsn(192, str3);
                    methodVisitor.visitVarInsn(25, 1);
                    methodVisitor.visitVarInsn(25, context.var("list_item"));
                    if (context.nonContext) {
                        methodVisitor.visitInsn(1);
                    } else {
                        methodVisitor.visitVarInsn(21, context.var(com.facebook.common.callercontext.ContextChain.TAG_INFRA));
                        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    }
                    methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(com.alibaba.fastjson.util.ASMUtils.desc(cls2)));
                    methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(fieldInfo2.serialzeFeatures));
                    methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str3, str2, "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                    methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label15);
                    methodVisitor.visitLabel(label14);
                }
                methodVisitor.visitVarInsn(25, context.var("list_item_desc"));
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitVarInsn(25, context.var("list_item"));
                if (context.nonContext) {
                    methodVisitor.visitInsn(1);
                } else {
                    methodVisitor.visitVarInsn(21, context.var(com.facebook.common.callercontext.ContextChain.TAG_INFRA));
                    methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                }
                methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(com.alibaba.fastjson.util.ASMUtils.desc(cls2)));
                methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(fieldInfo2.serialzeFeatures));
                methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEINTERFACE, ObjectSerializer, "write", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                methodVisitor.visitLabel(label15);
                label = label12;
                methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label);
            }
            methodVisitor.visitLabel(label13);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("list_item"));
            if (context.nonContext) {
                methodVisitor.visitInsn(1);
            } else {
                methodVisitor.visitVarInsn(21, context.var(com.facebook.common.callercontext.ContextChain.TAG_INFRA));
                methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            }
            if (cls2 != null && java.lang.reflect.Modifier.isPublic(cls2.getModifiers())) {
                methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) collectionItemType)));
                methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(fieldInfo2.serialzeFeatures));
                methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            } else {
                methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            }
            methodVisitor.visitLabel(label);
            methodVisitor.visitLabel(label10);
            i = 1;
            methodVisitor.visitIincInsn(context.var(com.facebook.common.callercontext.ContextChain.TAG_INFRA), 1);
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label7);
            methodVisitor.visitLabel(label9);
            i2 = 25;
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(16, 93);
            i3 = com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL;
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str, "write", "(I)V");
        }
        methodVisitor.visitVarInsn(i2, i);
        methodVisitor.visitMethodInsn(i3, JSONSerializer, "popContext", "()V");
        methodVisitor.visitLabel(label6);
        _seperator(methodVisitor, context);
        methodVisitor.visitLabel(label4);
        methodVisitor.visitLabel(label2);
    }

    private void _filters(com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo fieldInfo, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context, com.alibaba.fastjson.asm.Label label) {
        if (fieldInfo.fieldTransient) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(com.alibaba.fastjson.serializer.SerializerFeature.SkipTransientField.mask));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFNE, label);
        }
        _notWriteDefault(methodVisitor, fieldInfo, context, label);
        if (context.writeDirect) {
            return;
        }
        _apply(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label);
        _processKey(methodVisitor, fieldInfo, context);
        _processValue(methodVisitor, fieldInfo, context, label);
    }

    private void _nameApply(com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo fieldInfo, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context, com.alibaba.fastjson.asm.Label label) {
        if (!context.writeDirect) {
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, 2);
            methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "applyName", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;)Z");
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label);
            _labelApply(methodVisitor, fieldInfo, context, label);
        }
        if (fieldInfo.field == null) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(com.alibaba.fastjson.serializer.SerializerFeature.IgnoreNonFieldGetter.mask));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFNE, label);
        }
    }

    private void _labelApply(com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo fieldInfo, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context, com.alibaba.fastjson.asm.Label label) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(fieldInfo.label);
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "applyLabel", "(L" + JSONSerializer + ";Ljava/lang/String;)Z");
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label);
    }

    private void _writeObject(com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo fieldInfo, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context, com.alibaba.fastjson.asm.Label label) {
        com.alibaba.fastjson.asm.Label label2;
        com.alibaba.fastjson.asm.Label label3;
        java.lang.String str;
        java.lang.String format = fieldInfo.getFormat();
        java.lang.Class<?> cls = fieldInfo.fieldClass;
        com.alibaba.fastjson.asm.Label label4 = new com.alibaba.fastjson.asm.Label();
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("object"));
        } else {
            methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.processValue);
        }
        methodVisitor.visitInsn(89);
        methodVisitor.visitVarInsn(58, context.var("object"));
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFNONNULL, label4);
        _if_write_null(methodVisitor, fieldInfo, context);
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label);
        methodVisitor.visitLabel(label4);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "write", "(I)V");
        _writeFieldName(methodVisitor, context);
        com.alibaba.fastjson.asm.Label label5 = new com.alibaba.fastjson.asm.Label();
        com.alibaba.fastjson.asm.Label label6 = new com.alibaba.fastjson.asm.Label();
        if (!java.lang.reflect.Modifier.isPublic(cls.getModifiers()) || com.alibaba.fastjson.parser.ParserConfig.isPrimitive2(cls)) {
            label2 = label5;
            label3 = label6;
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(com.alibaba.fastjson.util.ASMUtils.desc(cls)));
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IF_ACMPNE, label6);
            _getFieldSer(context, methodVisitor, fieldInfo);
            methodVisitor.visitVarInsn(58, context.var("fied_ser"));
            com.alibaba.fastjson.asm.Label label7 = new com.alibaba.fastjson.asm.Label();
            com.alibaba.fastjson.asm.Label label8 = new com.alibaba.fastjson.asm.Label();
            methodVisitor.visitVarInsn(25, context.var("fied_ser"));
            java.lang.String str2 = JavaBeanSerializer;
            methodVisitor.visitTypeInsn(com.alibaba.fastjson.asm.Opcodes.INSTANCEOF, str2);
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label7);
            boolean z = (fieldInfo.serialzeFeatures & com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect.mask) != 0;
            boolean z2 = (fieldInfo.serialzeFeatures & com.alibaba.fastjson.serializer.SerializerFeature.BeanToArray.mask) != 0;
            if (z || (context.nonContext && context.writeDirect)) {
                str = z2 ? "writeAsArrayNonContext" : "writeDirectNonContext";
            } else {
                str = z2 ? "writeAsArray" : "write";
            }
            methodVisitor.visitVarInsn(25, context.var("fied_ser"));
            methodVisitor.visitTypeInsn(192, str2);
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("object"));
            methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(fieldInfo.serialzeFeatures));
            java.lang.StringBuilder sb = new java.lang.StringBuilder("(L");
            java.lang.String str3 = JSONSerializer;
            sb.append(str3);
            sb.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str2, str, sb.toString());
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label8);
            methodVisitor.visitLabel(label7);
            methodVisitor.visitVarInsn(25, context.var("fied_ser"));
            methodVisitor.visitVarInsn(25, 1);
            methodVisitor.visitVarInsn(25, context.var("object"));
            methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
            methodVisitor.visitVarInsn(25, 0);
            methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(fieldInfo.serialzeFeatures));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEINTERFACE, ObjectSerializer, "write", "(L" + str3 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            methodVisitor.visitLabel(label8);
            label2 = label5;
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label2);
            label3 = label6;
        }
        methodVisitor.visitLabel(label3);
        methodVisitor.visitVarInsn(25, 1);
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("object"));
        } else {
            methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.processValue);
        }
        if (format != 0) {
            methodVisitor.visitLdcInsn(format);
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
            if ((fieldInfo.fieldType instanceof java.lang.Class) && ((java.lang.Class) fieldInfo.fieldType).isPrimitive()) {
                methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                if (fieldInfo.fieldClass == java.lang.String.class) {
                    methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) java.lang.String.class)));
                } else {
                    methodVisitor.visitVarInsn(25, 0);
                    methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                }
                methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(fieldInfo.serialzeFeatures));
                methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JSONSerializer, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
        }
        methodVisitor.visitLabel(label2);
        _seperator(methodVisitor, context);
    }

    private void _before(com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "writeBefore", "(L" + JSONSerializer + ";Ljava/lang/Object;C)C");
        methodVisitor.visitVarInsn(54, context.var("seperator"));
    }

    private void _after(com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context) {
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "writeAfter", "(L" + JSONSerializer + ";Ljava/lang/Object;C)C");
        methodVisitor.visitVarInsn(54, context.var("seperator"));
    }

    private void _notWriteDefault(com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo fieldInfo, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context, com.alibaba.fastjson.asm.Label label) {
        if (context.writeDirect) {
            return;
        }
        com.alibaba.fastjson.asm.Label label2 = new com.alibaba.fastjson.asm.Label();
        methodVisitor.visitVarInsn(21, context.var("notWriteDefaultValue"));
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label2);
        java.lang.Class<?> cls = fieldInfo.fieldClass;
        if (cls == java.lang.Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("boolean"));
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label);
        } else if (cls == java.lang.Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label);
        } else if (cls == java.lang.Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label);
        } else if (cls == java.lang.Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("int"));
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label);
        } else if (cls == java.lang.Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long"));
            methodVisitor.visitInsn(9);
            methodVisitor.visitInsn(com.alibaba.fastjson.asm.Opcodes.LCMP);
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label);
        } else if (cls == java.lang.Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var("float"));
            methodVisitor.visitInsn(11);
            methodVisitor.visitInsn(com.alibaba.fastjson.asm.Opcodes.FCMPL);
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label);
        } else if (cls == java.lang.Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double"));
            methodVisitor.visitInsn(14);
            methodVisitor.visitInsn(com.alibaba.fastjson.asm.Opcodes.DCMPL);
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label);
        }
        methodVisitor.visitLabel(label2);
    }

    private void _apply(com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo fieldInfo, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context) {
        java.lang.Class<?> cls = fieldInfo.fieldClass;
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
        if (cls == java.lang.Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == java.lang.Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == java.lang.Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("int"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == java.lang.Character.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("char"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == java.lang.Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long", 2));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == java.lang.Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var("float"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == java.lang.Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double", 2));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == java.lang.Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("boolean"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == java.math.BigDecimal.class) {
            methodVisitor.visitVarInsn(25, context.var("decimal"));
        } else if (cls == java.lang.String.class) {
            methodVisitor.visitVarInsn(25, context.var("string"));
        } else if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("enum"));
        } else if (java.util.List.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var(com.taobao.weex.ui.component.WXBasicComponentType.LIST));
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
        }
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "apply", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
    }

    private void _processValue(com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo fieldInfo, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context, com.alibaba.fastjson.asm.Label label) {
        com.alibaba.fastjson.asm.Label label2 = new com.alibaba.fastjson.asm.Label();
        java.lang.Class<?> cls = fieldInfo.fieldClass;
        if (cls.isPrimitive()) {
            com.alibaba.fastjson.asm.Label label3 = new com.alibaba.fastjson.asm.Label();
            methodVisitor.visitVarInsn(21, context.var("checkValue"));
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFNE, label3);
            methodVisitor.visitInsn(1);
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.original);
            methodVisitor.visitVarInsn(58, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.processValue);
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label2);
            methodVisitor.visitLabel(label3);
        }
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(context.getFieldOrinal(fieldInfo.name)));
        java.lang.String str = JavaBeanSerializer;
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str, "getBeanContext", "(I)" + com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) com.alibaba.fastjson.serializer.BeanContext.class));
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
        if (cls == java.lang.Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.original);
        } else if (cls == java.lang.Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.original);
        } else if (cls == java.lang.Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("int"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.original);
        } else if (cls == java.lang.Character.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("char"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.original);
        } else if (cls == java.lang.Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long", 2));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.original);
        } else if (cls == java.lang.Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var("float"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.original);
        } else if (cls == java.lang.Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double", 2));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.original);
        } else if (cls == java.lang.Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("boolean"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
            methodVisitor.visitInsn(89);
            methodVisitor.visitVarInsn(58, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.original);
        } else if (cls == java.math.BigDecimal.class) {
            methodVisitor.visitVarInsn(25, context.var("decimal"));
            methodVisitor.visitVarInsn(58, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.original);
            methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.original);
        } else if (cls == java.lang.String.class) {
            methodVisitor.visitVarInsn(25, context.var("string"));
            methodVisitor.visitVarInsn(58, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.original);
            methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.original);
        } else if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("enum"));
            methodVisitor.visitVarInsn(58, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.original);
            methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.original);
        } else if (java.util.List.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var(com.taobao.weex.ui.component.WXBasicComponentType.LIST));
            methodVisitor.visitVarInsn(58, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.original);
            methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.original);
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
            methodVisitor.visitVarInsn(58, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.original);
            methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.original);
        }
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str, "processValue", "(L" + JSONSerializer + ";" + com.alibaba.fastjson.util.ASMUtils.desc((java.lang.Class<?>) com.alibaba.fastjson.serializer.BeanContext.class) + "Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;");
        methodVisitor.visitVarInsn(58, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.processValue);
        methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.original);
        methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.processValue);
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IF_ACMPEQ, label2);
        _writeObject(methodVisitor, fieldInfo, context, label);
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label);
        methodVisitor.visitLabel(label2);
    }

    private void _processKey(com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo fieldInfo, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context) {
        com.alibaba.fastjson.asm.Label label = new com.alibaba.fastjson.asm.Label();
        methodVisitor.visitVarInsn(21, context.var("hasNameFilters"));
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label);
        java.lang.Class<?> cls = fieldInfo.fieldClass;
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
        if (cls == java.lang.Byte.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("byte"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == java.lang.Short.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("short"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == java.lang.Integer.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("int"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == java.lang.Character.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("char"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == java.lang.Long.TYPE) {
            methodVisitor.visitVarInsn(22, context.var("long", 2));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == java.lang.Float.TYPE) {
            methodVisitor.visitVarInsn(23, context.var("float"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == java.lang.Double.TYPE) {
            methodVisitor.visitVarInsn(24, context.var("double", 2));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == java.lang.Boolean.TYPE) {
            methodVisitor.visitVarInsn(21, context.var("boolean"));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == java.math.BigDecimal.class) {
            methodVisitor.visitVarInsn(25, context.var("decimal"));
        } else if (cls == java.lang.String.class) {
            methodVisitor.visitVarInsn(25, context.var("string"));
        } else if (cls.isEnum()) {
            methodVisitor.visitVarInsn(25, context.var("enum"));
        } else if (java.util.List.class.isAssignableFrom(cls)) {
            methodVisitor.visitVarInsn(25, context.var(com.taobao.weex.ui.component.WXBasicComponentType.LIST));
        } else {
            methodVisitor.visitVarInsn(25, context.var("object"));
        }
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JavaBeanSerializer, "processKey", "(L" + JSONSerializer + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
        methodVisitor.visitVarInsn(58, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
        methodVisitor.visitLabel(label);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0094  */
    /* JADX WARN: Code duplicated, block: B:44:0x0130  */
    private void _if_write_null(com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo fieldInfo, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context) {
        int i;
        int mask;
        int mask2;
        java.lang.Class<?> cls = fieldInfo.fieldClass;
        com.alibaba.fastjson.asm.Label label = new com.alibaba.fastjson.asm.Label();
        com.alibaba.fastjson.asm.Label label2 = new com.alibaba.fastjson.asm.Label();
        com.alibaba.fastjson.asm.Label label3 = new com.alibaba.fastjson.asm.Label();
        com.alibaba.fastjson.asm.Label label4 = new com.alibaba.fastjson.asm.Label();
        methodVisitor.visitLabel(label);
        com.alibaba.fastjson.annotation.JSONField annotation = fieldInfo.getAnnotation();
        int iOf = annotation != null ? com.alibaba.fastjson.serializer.SerializerFeature.of(annotation.serialzeFeatures()) : 0;
        com.alibaba.fastjson.annotation.JSONType jSONType = context.beanInfo.jsonType;
        if (jSONType != null) {
            iOf |= com.alibaba.fastjson.serializer.SerializerFeature.of(jSONType.serialzeFeatures());
        }
        if (cls == java.lang.String.class) {
            mask = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.getMask();
            mask2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty.getMask();
        } else if (java.lang.Number.class.isAssignableFrom(cls)) {
            mask = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.getMask();
            mask2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero.getMask();
        } else if (java.util.Collection.class.isAssignableFrom(cls)) {
            mask = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.getMask();
            mask2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty.getMask();
        } else {
            if (java.lang.Boolean.class == cls) {
                mask = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue.getMask();
                mask2 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse.getMask();
            } else {
                i = com.alibaba.fastjson.serializer.SerializerFeature.WRITE_MAP_NULL_FEATURES;
            }
            if ((iOf & i) == 0) {
                methodVisitor.visitVarInsn(25, context.var("out"));
                methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(i));
                methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
                methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label2);
            }
            methodVisitor.visitLabel(label3);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(21, context.var("seperator"));
            java.lang.String str = SerializeWriter;
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str, "write", "(I)V");
            _writeFieldName(methodVisitor, context);
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(iOf));
            if (cls != java.lang.String.class || cls == java.lang.Character.class) {
                methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty.mask));
            } else if (java.lang.Number.class.isAssignableFrom(cls)) {
                methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero.mask));
            } else if (cls == java.lang.Boolean.class) {
                methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse.mask));
            } else if (java.util.Collection.class.isAssignableFrom(cls) || cls.isArray()) {
                methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty.mask));
            } else {
                methodVisitor.visitLdcInsn(0);
            }
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str, "writeNull", "(II)V");
            _seperator(methodVisitor, context);
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label4);
            methodVisitor.visitLabel(label2);
            methodVisitor.visitLabel(label4);
        }
        i = mask | mask2;
        if ((iOf & i) == 0) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(i));
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "isEnabled", "(I)Z");
            methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFEQ, label2);
        }
        methodVisitor.visitLabel(label3);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitVarInsn(21, context.var("seperator"));
        java.lang.String str2 = SerializeWriter;
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str2, "write", "(I)V");
        _writeFieldName(methodVisitor, context);
        methodVisitor.visitVarInsn(25, context.var("out"));
        methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(iOf));
        if (cls != java.lang.String.class) {
            methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty.mask));
        } else {
            methodVisitor.visitLdcInsn(java.lang.Integer.valueOf(com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty.mask));
        }
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, str2, "writeNull", "(II)V");
        _seperator(methodVisitor, context);
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.GOTO, label4);
        methodVisitor.visitLabel(label2);
        methodVisitor.visitLabel(label4);
    }

    private void _writeFieldName(com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context) {
        if (context.writeDirect) {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldNameDirect", "(Ljava/lang/String;)V");
        } else {
            methodVisitor.visitVarInsn(25, context.var("out"));
            methodVisitor.visitVarInsn(25, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context.fieldName);
            methodVisitor.visitInsn(3);
            methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, SerializeWriter, "writeFieldName", "(Ljava/lang/String;Z)V");
        }
    }

    private void _seperator(com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context) {
        methodVisitor.visitVarInsn(16, 44);
        methodVisitor.visitVarInsn(54, context.var("seperator"));
    }

    private void _getListFieldItemSer(com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context, com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo fieldInfo, java.lang.Class<?> cls) {
        com.alibaba.fastjson.asm.Label label = new com.alibaba.fastjson.asm.Label();
        methodVisitor.visitVarInsn(25, 0);
        java.lang.String str = context.className;
        java.lang.String str2 = fieldInfo.name + "_asm_list_item_ser_";
        java.lang.String str3 = ObjectSerializer_desc;
        methodVisitor.visitFieldInsn(180, str, str2, str3);
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFNONNULL, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(com.alibaba.fastjson.util.ASMUtils.desc(cls)));
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JSONSerializer, "getObjectWriter", "(Ljava/lang/Class;)" + str3);
        methodVisitor.visitFieldInsn(com.alibaba.fastjson.asm.Opcodes.PUTFIELD, context.className, fieldInfo.name + "_asm_list_item_ser_", str3);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_list_item_ser_", str3);
    }

    private void _getFieldSer(com.alibaba.fastjson.serializer.ASMSerializerFactory.Context context, com.alibaba.fastjson.asm.MethodVisitor methodVisitor, com.alibaba.fastjson.util.FieldInfo fieldInfo) {
        com.alibaba.fastjson.asm.Label label = new com.alibaba.fastjson.asm.Label();
        methodVisitor.visitVarInsn(25, 0);
        java.lang.String str = context.className;
        java.lang.String str2 = fieldInfo.name + "_asm_ser_";
        java.lang.String str3 = ObjectSerializer_desc;
        methodVisitor.visitFieldInsn(180, str, str2, str3);
        methodVisitor.visitJumpInsn(com.alibaba.fastjson.asm.Opcodes.IFNONNULL, label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitVarInsn(25, 1);
        methodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(com.alibaba.fastjson.util.ASMUtils.desc(fieldInfo.fieldClass)));
        methodVisitor.visitMethodInsn(com.alibaba.fastjson.asm.Opcodes.INVOKEVIRTUAL, JSONSerializer, "getObjectWriter", "(Ljava/lang/Class;)" + str3);
        methodVisitor.visitFieldInsn(com.alibaba.fastjson.asm.Opcodes.PUTFIELD, context.className, fieldInfo.name + "_asm_ser_", str3);
        methodVisitor.visitLabel(label);
        methodVisitor.visitVarInsn(25, 0);
        methodVisitor.visitFieldInsn(180, context.className, fieldInfo.name + "_asm_ser_", str3);
    }
}
