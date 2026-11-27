package kotlin.reflect.jvm.internal.impl.km.internal;

/* JADX INFO: compiled from: WriteUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WriteUtilsKt {
    public static final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Builder writeAnnotation(kotlin.reflect.jvm.internal.impl.km.KmAnnotation kmAnnotation, kotlin.reflect.jvm.internal.impl.metadata.serialization.StringTable strings) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmAnnotation, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(strings, "strings");
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Builder builderNewBuilder = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.newBuilder();
        builderNewBuilder.setId(getClassNameIndex(strings, kmAnnotation.getClassName()));
        for (java.util.Map.Entry<java.lang.String, kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument> entry : kmAnnotation.getArguments().entrySet()) {
            java.lang.String key = entry.getKey();
            kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument value = entry.getValue();
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Builder builderNewBuilder2 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.newBuilder();
            builderNewBuilder2.setNameId(strings.getStringIndex(key));
            builderNewBuilder2.setValue(writeAnnotationArgument(value, strings).build());
            builderNewBuilder.addArgument(builderNewBuilder2);
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "apply(...)");
        return builderNewBuilder;
    }

    public static final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Builder writeAnnotationArgument(kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument kmAnnotationArgument, kotlin.reflect.jvm.internal.impl.metadata.serialization.StringTable strings) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(kmAnnotationArgument, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(strings, "strings");
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Builder builderNewBuilder = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.newBuilder();
        if (kmAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ByteValue) {
            builderNewBuilder.setType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.BYTE);
            builderNewBuilder.setIntValue(((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ByteValue) kmAnnotationArgument).getValue().byteValue());
        } else if (kmAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.CharValue) {
            builderNewBuilder.setType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.CHAR);
            builderNewBuilder.setIntValue(((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.CharValue) kmAnnotationArgument).getValue().charValue());
        } else if (kmAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ShortValue) {
            builderNewBuilder.setType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.SHORT);
            builderNewBuilder.setIntValue(((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ShortValue) kmAnnotationArgument).getValue().shortValue());
        } else if (kmAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.IntValue) {
            builderNewBuilder.setType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.INT);
            builderNewBuilder.setIntValue(((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.IntValue) kmAnnotationArgument).getValue().intValue());
        } else if (kmAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LongValue) {
            builderNewBuilder.setType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.LONG);
            builderNewBuilder.setIntValue(((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.LongValue) kmAnnotationArgument).getValue().longValue());
        } else if (kmAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.FloatValue) {
            builderNewBuilder.setType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.FLOAT);
            builderNewBuilder.setFloatValue(((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.FloatValue) kmAnnotationArgument).getValue().floatValue());
        } else if (kmAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.DoubleValue) {
            builderNewBuilder.setType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.DOUBLE);
            builderNewBuilder.setDoubleValue(((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.DoubleValue) kmAnnotationArgument).getValue().doubleValue());
        } else if (kmAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.BooleanValue) {
            builderNewBuilder.setType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN);
            builderNewBuilder.setIntValue(((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.BooleanValue) kmAnnotationArgument).getValue().booleanValue() ? 1L : 0L);
        } else if (kmAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.UByteValue) {
            builderNewBuilder.setType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.BYTE);
            builderNewBuilder.setIntValue(((long) ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.UByteValue) kmAnnotationArgument).m1828getValuew2LRezQ()) & 255);
            builderNewBuilder.setFlags(kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_UNSIGNED.toFlags((java.lang.Boolean) true));
        } else if (kmAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.UShortValue) {
            builderNewBuilder.setType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.SHORT);
            builderNewBuilder.setIntValue(((long) ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.UShortValue) kmAnnotationArgument).m1831getValueMh2AYeg()) & 65535);
            builderNewBuilder.setFlags(kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_UNSIGNED.toFlags((java.lang.Boolean) true));
        } else if (kmAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.UIntValue) {
            builderNewBuilder.setType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.INT);
            builderNewBuilder.setIntValue(((long) ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.UIntValue) kmAnnotationArgument).m1829getValuepVg5ArA()) & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_SIZE_LIMIT);
            builderNewBuilder.setFlags(kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_UNSIGNED.toFlags((java.lang.Boolean) true));
        } else if (kmAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ULongValue) {
            builderNewBuilder.setType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.LONG);
            builderNewBuilder.setIntValue(((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ULongValue) kmAnnotationArgument).m1830getValuesVKNKU());
            builderNewBuilder.setFlags(kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.IS_UNSIGNED.toFlags((java.lang.Boolean) true));
        } else if (kmAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.StringValue) {
            builderNewBuilder.setType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.STRING);
            builderNewBuilder.setStringValue(strings.getStringIndex(((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.StringValue) kmAnnotationArgument).getValue()));
        } else if (kmAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.KClassValue) {
            builderNewBuilder.setType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.CLASS);
            builderNewBuilder.setClassId(getClassNameIndex(strings, ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.KClassValue) kmAnnotationArgument).getClassName()));
        } else if (kmAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ArrayKClassValue) {
            builderNewBuilder.setType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.CLASS);
            kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ArrayKClassValue arrayKClassValue = (kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ArrayKClassValue) kmAnnotationArgument;
            builderNewBuilder.setClassId(getClassNameIndex(strings, arrayKClassValue.getClassName()));
            builderNewBuilder.setArrayDimensionCount(arrayKClassValue.getArrayDimensionCount());
        } else if (kmAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.EnumValue) {
            builderNewBuilder.setType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.ENUM);
            kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.EnumValue enumValue = (kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.EnumValue) kmAnnotationArgument;
            builderNewBuilder.setClassId(getClassNameIndex(strings, enumValue.getEnumClassName()));
            builderNewBuilder.setEnumValueId(strings.getStringIndex(enumValue.getEnumEntryName()));
        } else if (kmAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.AnnotationValue) {
            builderNewBuilder.setType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION);
            builderNewBuilder.setAnnotation(writeAnnotation(((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.AnnotationValue) kmAnnotationArgument).getAnnotation(), strings).build());
        } else {
            if (!(kmAnnotationArgument instanceof kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ArrayValue)) {
                throw new kotlin.NoWhenBranchMatchedException();
            }
            builderNewBuilder.setType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.ARRAY);
            java.util.Iterator<kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument> it = ((kotlin.reflect.jvm.internal.impl.km.KmAnnotationArgument.ArrayValue) kmAnnotationArgument).getElements().iterator();
            while (it.hasNext()) {
                builderNewBuilder.addArrayElement(writeAnnotationArgument(it.next(), strings));
            }
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "apply(...)");
        return builderNewBuilder;
    }

    public static final int getClassNameIndex(kotlin.reflect.jvm.internal.impl.metadata.serialization.StringTable stringTable, java.lang.String name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(stringTable, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        if (kotlin.reflect.jvm.internal.impl.km.ClassNameKt.isLocalClassName(name)) {
            java.lang.String strSubstring = name.substring(1);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return stringTable.getQualifiedClassNameIndex(strSubstring, true);
        }
        return stringTable.getQualifiedClassNameIndex(name, false);
    }
}
