package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

/* JADX INFO: compiled from: JvmProtoBufUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JvmProtoBufUtil {
    private static final kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite EXTENSION_REGISTRY;
    public static final kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil INSTANCE = new kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil();

    private JvmProtoBufUtil() {
    }

    static {
        kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite extensionRegistryLiteNewInstance = kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite.newInstance();
        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.registerAllExtensions(extensionRegistryLiteNewInstance);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(extensionRegistryLiteNewInstance, "apply(...)");
        EXTENSION_REGISTRY = extensionRegistryLiteNewInstance;
    }

    public final kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite getEXTENSION_REGISTRY() {
        return EXTENSION_REGISTRY;
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.Pair<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class> readClassDataFrom(java.lang.String[] data, java.lang.String[] strings) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(strings, "strings");
        byte[] bArrDecodeBytes = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.BitEncoding.decodeBytes(data);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bArrDecodeBytes, "decodeBytes(...)");
        return readClassDataFrom(bArrDecodeBytes, strings);
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.Pair<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class> readClassDataFrom(byte[] bytes, java.lang.String[] strings) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bytes, "bytes");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(strings, "strings");
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bytes);
        return new kotlin.Pair<>(INSTANCE.readNameResolver(byteArrayInputStream, strings), kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.Pair<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package> readPackageDataFrom(java.lang.String[] data, java.lang.String[] strings) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(strings, "strings");
        byte[] bArrDecodeBytes = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.BitEncoding.decodeBytes(data);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bArrDecodeBytes, "decodeBytes(...)");
        return readPackageDataFrom(bArrDecodeBytes, strings);
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.Pair<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package> readPackageDataFrom(byte[] bytes, java.lang.String[] strings) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bytes, "bytes");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(strings, "strings");
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bytes);
        return new kotlin.Pair<>(INSTANCE.readNameResolver(byteArrayInputStream, strings), kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.Pair<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function> readFunctionDataFrom(java.lang.String[] data, java.lang.String[] strings) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(data, "data");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(strings, "strings");
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.BitEncoding.decodeBytes(data));
        return new kotlin.Pair<>(INSTANCE.readNameResolver(byteArrayInputStream, strings), kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }

    private final kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver readNameResolver(java.io.InputStream inputStream, java.lang.String[] strArr) throws java.io.IOException {
        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes delimitedFrom = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.parseDelimitedFrom(inputStream, EXTENSION_REGISTRY);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(delimitedFrom, "parseDelimitedFrom(...)");
        return new kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver(delimitedFrom, strArr);
    }

    public final kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method getJvmMethodSignature(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function proto, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable) {
        java.lang.String string;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function, kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature> methodSignature = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.methodSignature;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(methodSignature, "methodSignature");
        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature) kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt.getExtensionOrNull(proto, methodSignature);
        int name = (jvmMethodSignature == null || !jvmMethodSignature.hasName()) ? proto.getName() : jvmMethodSignature.getName();
        if (jvmMethodSignature != null && jvmMethodSignature.hasDesc()) {
            string = nameResolver.getString(jvmMethodSignature.getDesc());
        } else {
            java.util.List listListOfNotNull = kotlin.collections.CollectionsKt.listOfNotNull(kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.receiverType(proto, typeTable));
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameterList, "getValueParameterList(...)");
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter> list = valueParameterList;
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
            for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter valueParameter : list) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(valueParameter);
                arrayList.add(kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.type(valueParameter, typeTable));
            }
            java.util.List listPlus = kotlin.collections.CollectionsKt.plus((java.util.Collection) listListOfNotNull, (java.lang.Iterable) arrayList);
            java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(listPlus, 10));
            java.util.Iterator it = listPlus.iterator();
            while (it.hasNext()) {
                java.lang.String strMapTypeDefault = INSTANCE.mapTypeDefault((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) it.next(), nameResolver);
                if (strMapTypeDefault == null) {
                    return null;
                }
                arrayList2.add(strMapTypeDefault);
            }
            java.util.ArrayList arrayList3 = arrayList2;
            java.lang.String strMapTypeDefault2 = mapTypeDefault(kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.returnType(proto, typeTable), nameResolver);
            if (strMapTypeDefault2 == null) {
                return null;
            }
            string = kotlin.collections.CollectionsKt.joinToString$default(arrayList3, "", com.taobao.weex.el.parse.Operators.BRACKET_START_STR, com.taobao.weex.el.parse.Operators.BRACKET_END_STR, 0, null, null, 56, null) + strMapTypeDefault2;
        }
        return new kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method(nameResolver.getString(name), string);
    }

    public final kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method getJvmConstructorSignature(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor proto, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable) {
        java.lang.String string;
        java.lang.String strJoinToString$default;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor, kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature> constructorSignature = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.constructorSignature;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(constructorSignature, "constructorSignature");
        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature) kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt.getExtensionOrNull(proto, constructorSignature);
        if (jvmMethodSignature != null && jvmMethodSignature.hasName()) {
            string = nameResolver.getString(jvmMethodSignature.getName());
        } else {
            string = "<init>";
        }
        if (jvmMethodSignature != null && jvmMethodSignature.hasDesc()) {
            strJoinToString$default = nameResolver.getString(jvmMethodSignature.getDesc());
        } else {
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameterList, "getValueParameterList(...)");
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter> list = valueParameterList;
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
            for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter valueParameter : list) {
                kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil jvmProtoBufUtil = INSTANCE;
                kotlin.jvm.internal.Intrinsics.checkNotNull(valueParameter);
                java.lang.String strMapTypeDefault = jvmProtoBufUtil.mapTypeDefault(kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.type(valueParameter, typeTable), nameResolver);
                if (strMapTypeDefault == null) {
                    return null;
                }
                arrayList.add(strMapTypeDefault);
            }
            strJoinToString$default = kotlin.collections.CollectionsKt.joinToString$default(arrayList, "", com.taobao.weex.el.parse.Operators.BRACKET_START_STR, ")V", 0, null, null, 56, null);
        }
        return new kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method(string, strJoinToString$default);
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Field getJvmFieldSignature$default(kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil jvmProtoBufUtil, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable, boolean z, int i, java.lang.Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return jvmProtoBufUtil.getJvmFieldSignature(property, nameResolver, typeTable, z);
    }

    public final kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Field getJvmFieldSignature(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property proto, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable, boolean z) {
        java.lang.String strMapTypeDefault;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property, kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature> propertySignature = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.propertySignature;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertySignature, "propertySignature");
        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature) kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt.getExtensionOrNull(proto, propertySignature);
        if (jvmPropertySignature == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature field = jvmPropertySignature.hasField() ? jvmPropertySignature.getField() : null;
        if (field == null && z) {
            return null;
        }
        int name = (field == null || !field.hasName()) ? proto.getName() : field.getName();
        if (field == null || !field.hasDesc()) {
            strMapTypeDefault = mapTypeDefault(kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.returnType(proto, typeTable), nameResolver);
            if (strMapTypeDefault == null) {
                return null;
            }
        } else {
            strMapTypeDefault = nameResolver.getString(field.getDesc());
        }
        return new kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Field(nameResolver.getString(name), strMapTypeDefault);
    }

    private final java.lang.String mapTypeDefault(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type type, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver) {
        if (type.hasClassName()) {
            return kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.ClassMapperLite.mapClass(nameResolver.getQualifiedClassName(type.getClassName()));
        }
        return null;
    }

    @kotlin.jvm.JvmStatic
    public static final boolean isMovedFromInterfaceCompanion(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property proto) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(proto, "proto");
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField is_moved_from_interface_companion = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmFlags.INSTANCE.getIS_MOVED_FROM_INTERFACE_COMPANION();
        java.lang.Object extension = proto.getExtension(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.flags);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(extension, "getExtension(...)");
        java.lang.Boolean bool = is_moved_from_interface_companion.get(((java.lang.Number) extension).intValue());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        return bool.booleanValue();
    }
}
