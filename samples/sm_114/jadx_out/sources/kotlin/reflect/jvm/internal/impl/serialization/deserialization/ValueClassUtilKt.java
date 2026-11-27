package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

/* JADX INFO: compiled from: ValueClassUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ValueClassUtilKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker> kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation<T> loadValueClassRepresentation(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class r1, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type, ? extends T> typeDeserializer, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.Name, ? extends T> typeOfPublicProperty) {
        T tInvoke2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeDeserializer, "typeDeserializer");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeOfPublicProperty, "typeOfPublicProperty");
        if (r1.getMultiFieldValueClassUnderlyingNameCount() > 0) {
            kotlin.Pair<java.util.List<kotlin.reflect.jvm.internal.impl.name.Name>, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type>> pairLoadMultiFieldValueClassRepresentation = loadMultiFieldValueClassRepresentation(r1, nameResolver, typeTable);
            java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> listComponent1 = pairLoadMultiFieldValueClassRepresentation.component1();
            java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type> listComponent2 = pairLoadMultiFieldValueClassRepresentation.component2();
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(listComponent2, 10));
            java.util.Iterator<T> it = listComponent2.iterator();
            while (it.hasNext()) {
                arrayList.add(typeDeserializer.invoke2(it.next()));
            }
            return new kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation(kotlin.collections.CollectionsKt.zip(listComponent1, arrayList));
        }
        if (!r1.hasInlineClassUnderlyingPropertyName()) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.name.Name name = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(nameResolver, r1.getInlineClassUnderlyingPropertyName());
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type typeInlineClassUnderlyingType = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.inlineClassUnderlyingType(r1, typeTable);
        if ((typeInlineClassUnderlyingType == null || (tInvoke2 = typeDeserializer.invoke2(typeInlineClassUnderlyingType)) == null) && (tInvoke2 = typeOfPublicProperty.invoke2(name)) == null) {
            throw new java.lang.IllegalStateException(("cannot determine underlying type for value class " + kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(nameResolver, r1.getFqName()) + " with property " + name).toString());
        }
        return new kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation(name, tInvoke2);
    }

    public static final kotlin.Pair<java.util.List<kotlin.reflect.jvm.internal.impl.name.Name>, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type>> loadMultiFieldValueClassRepresentation(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class r6, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable) {
        java.util.ArrayList multiFieldValueClassUnderlyingTypeList;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        java.util.List<java.lang.Integer> multiFieldValueClassUnderlyingNameList = r6.getMultiFieldValueClassUnderlyingNameList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(multiFieldValueClassUnderlyingNameList, "getMultiFieldValueClassUnderlyingNameList(...)");
        java.util.List<java.lang.Integer> list = multiFieldValueClassUnderlyingNameList;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        for (java.lang.Integer num : list) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(num);
            arrayList.add(kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(nameResolver, num.intValue()));
        }
        java.util.ArrayList arrayList2 = arrayList;
        kotlin.Pair pair = kotlin.TuplesKt.to(java.lang.Integer.valueOf(r6.getMultiFieldValueClassUnderlyingTypeIdCount()), java.lang.Integer.valueOf(r6.getMultiFieldValueClassUnderlyingTypeCount()));
        if (!kotlin.jvm.internal.Intrinsics.areEqual(pair, kotlin.TuplesKt.to(java.lang.Integer.valueOf(arrayList2.size()), 0))) {
            if (!kotlin.jvm.internal.Intrinsics.areEqual(pair, kotlin.TuplesKt.to(0, java.lang.Integer.valueOf(arrayList2.size())))) {
                throw new java.lang.IllegalStateException(("class " + kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(nameResolver, r6.getFqName()) + " has illegal multi-field value class representation").toString());
            }
            multiFieldValueClassUnderlyingTypeList = r6.getMultiFieldValueClassUnderlyingTypeList();
        } else {
            java.util.List<java.lang.Integer> multiFieldValueClassUnderlyingTypeIdList = r6.getMultiFieldValueClassUnderlyingTypeIdList();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(multiFieldValueClassUnderlyingTypeIdList, "getMultiFieldValueClassUnderlyingTypeIdList(...)");
            java.util.List<java.lang.Integer> list2 = multiFieldValueClassUnderlyingTypeIdList;
            java.util.ArrayList arrayList3 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (java.lang.Integer num2 : list2) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(num2);
                arrayList3.add(typeTable.get(num2.intValue()));
            }
            multiFieldValueClassUnderlyingTypeList = arrayList3;
        }
        return kotlin.TuplesKt.to(arrayList2, multiFieldValueClassUnderlyingTypeList);
    }
}
