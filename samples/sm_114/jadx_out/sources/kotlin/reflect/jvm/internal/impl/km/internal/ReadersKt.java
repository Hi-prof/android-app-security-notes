package kotlin.reflect.jvm.internal.impl.km.internal;

/* JADX INFO: compiled from: Readers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReadersKt {

    /* JADX INFO: compiled from: Readers.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;

        static {
            int[] iArr = new int[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Variance.values().length];
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Variance.IN.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Variance.OUT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                iArr[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Variance.INV.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection.values().length];
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection.IN.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection.OUT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection.INV.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                iArr2[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection.STAR.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.VersionKind.values().length];
            try {
                iArr3[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.VersionKind.LANGUAGE_VERSION.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                iArr3[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.VersionKind.COMPILER_VERSION.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                iArr3[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.VersionKind.API_VERSION.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[kotlin.DeprecationLevel.values().length];
            try {
                iArr4[kotlin.DeprecationLevel.WARNING.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                iArr4[kotlin.DeprecationLevel.ERROR.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
            try {
                iArr4[kotlin.DeprecationLevel.HIDDEN.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$3 = iArr4;
            int[] iArr5 = new int[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.EffectType.values().length];
            try {
                iArr5[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.EffectType.RETURNS_CONSTANT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused14) {
            }
            try {
                iArr5[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.EffectType.CALLS.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused15) {
            }
            try {
                iArr5[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.EffectType.RETURNS_NOT_NULL.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused16) {
            }
            $EnumSwitchMapping$4 = iArr5;
            int[] iArr6 = new int[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.InvocationKind.values().length];
            try {
                iArr6[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.InvocationKind.AT_MOST_ONCE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused17) {
            }
            try {
                iArr6[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.InvocationKind.EXACTLY_ONCE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused18) {
            }
            try {
                iArr6[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.InvocationKind.AT_LEAST_ONCE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused19) {
            }
            $EnumSwitchMapping$5 = iArr6;
            int[] iArr7 = new int[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression.ConstantValue.values().length];
            try {
                iArr7[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression.ConstantValue.TRUE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused20) {
            }
            try {
                iArr7[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression.ConstantValue.FALSE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused21) {
            }
            try {
                iArr7[kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression.ConstantValue.NULL.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused22) {
            }
            $EnumSwitchMapping$6 = iArr7;
        }
    }

    public static /* synthetic */ kotlin.reflect.jvm.internal.impl.km.KmClass toKmClass$default(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class r0, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver nameResolver, boolean z, java.util.List list, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            list = kotlin.collections.CollectionsKt.emptyList();
        }
        return toKmClass(r0, nameResolver, z, list);
    }

    public static final kotlin.reflect.jvm.internal.impl.km.KmClass toKmClass(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class r10, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver strings, boolean z, java.util.List<? extends java.lang.Object> contextExtensions) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(strings, "strings");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(contextExtensions, "contextExtensions");
        kotlin.reflect.jvm.internal.impl.km.KmClass kmClass = new kotlin.reflect.jvm.internal.impl.km.KmClass();
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable typeTable = r10.getTypeTable();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeTable, "getTypeTable(...)");
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable typeTable2 = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable(typeTable);
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable.Companion companion = kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable.Companion;
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable versionRequirementTable = r10.getVersionRequirementTable();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(versionRequirementTable, "getVersionRequirementTable(...)");
        kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext = new kotlin.reflect.jvm.internal.impl.km.internal.ReadContext(strings, typeTable2, companion.create(versionRequirementTable), z, null, contextExtensions, 16, null);
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter> typeParameterList = r10.getTypeParameterList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContextWithTypeParameters$kotlin_metadata = readContext.withTypeParameters$kotlin_metadata(typeParameterList);
        kmClass.setFlags$kotlin_metadata(r10.getFlags());
        kmClass.setName(readContextWithTypeParameters$kotlin_metadata.className$kotlin_metadata(r10.getFqName()));
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter> typeParameterList2 = r10.getTypeParameterList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameterList2, "getTypeParameterList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmTypeParameter> typeParameters = kmClass.getTypeParameters();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter typeParameter : typeParameterList2) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(typeParameter);
            typeParameters.add(toKmTypeParameter(typeParameter, readContextWithTypeParameters$kotlin_metadata));
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type> listSupertypes = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.supertypes(r10, readContextWithTypeParameters$kotlin_metadata.getTypes());
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmType> supertypes = kmClass.getSupertypes();
        java.util.Iterator<T> it = listSupertypes.iterator();
        while (it.hasNext()) {
            supertypes.add(toKmType((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) it.next(), readContextWithTypeParameters$kotlin_metadata));
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor> constructorList = r10.getConstructorList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(constructorList, "getConstructorList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmConstructor> constructors = kmClass.getConstructors();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor constructor : constructorList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(constructor);
            constructors.add(toKmConstructor(constructor, readContextWithTypeParameters$kotlin_metadata));
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function> functionList = r10.getFunctionList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(functionList, "getFunctionList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property> propertyList = r10.getPropertyList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyList, "getPropertyList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias> typeAliasList = r10.getTypeAliasList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeAliasList, "getTypeAliasList(...)");
        visitDeclarations(kmClass, functionList, propertyList, typeAliasList, readContextWithTypeParameters$kotlin_metadata);
        if (r10.hasCompanionObjectName()) {
            kmClass.setCompanionObject(readContextWithTypeParameters$kotlin_metadata.get(r10.getCompanionObjectName()));
        }
        java.util.List<java.lang.Integer> nestedClassNameList = r10.getNestedClassNameList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nestedClassNameList, "getNestedClassNameList(...)");
        java.util.List<java.lang.String> nestedClasses = kmClass.getNestedClasses();
        for (java.lang.Integer num : nestedClassNameList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(num);
            nestedClasses.add(readContextWithTypeParameters$kotlin_metadata.get(num.intValue()));
        }
        java.util.Iterator<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry> it2 = r10.getEnumEntryList().iterator();
        while (true) {
            if (it2.hasNext()) {
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry next = it2.next();
                if (!next.hasName()) {
                    throw new kotlin.reflect.jvm.internal.impl.km.InconsistentKotlinMetadataException("No name for EnumEntry", null, 2, null);
                }
                kmClass.getEnumEntries().add(readContextWithTypeParameters$kotlin_metadata.get(next.getName()));
                java.util.List<kotlin.reflect.jvm.internal.impl.km.KmEnumEntry> kmEnumEntries = kmClass.getKmEnumEntries();
                kotlin.jvm.internal.Intrinsics.checkNotNull(next);
                kmEnumEntries.add(toKmEnumEntry(next, readContextWithTypeParameters$kotlin_metadata));
            } else {
                java.util.List<java.lang.Integer> sealedSubclassFqNameList = r10.getSealedSubclassFqNameList();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sealedSubclassFqNameList, "getSealedSubclassFqNameList(...)");
                java.util.List<java.lang.String> sealedSubclasses = kmClass.getSealedSubclasses();
                for (java.lang.Integer num2 : sealedSubclassFqNameList) {
                    kotlin.jvm.internal.Intrinsics.checkNotNull(num2);
                    sealedSubclasses.add(readContextWithTypeParameters$kotlin_metadata.className$kotlin_metadata(num2.intValue()));
                }
                if (r10.hasInlineClassUnderlyingPropertyName()) {
                    kmClass.setInlineClassUnderlyingPropertyName(readContextWithTypeParameters$kotlin_metadata.get(r10.getInlineClassUnderlyingPropertyName()));
                }
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type typeLoadInlineClassUnderlyingType = loadInlineClassUnderlyingType(r10, readContextWithTypeParameters$kotlin_metadata);
                kmClass.setInlineClassUnderlyingType(typeLoadInlineClassUnderlyingType != null ? toKmType(typeLoadInlineClassUnderlyingType, readContextWithTypeParameters$kotlin_metadata) : null);
                java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type> listContextReceiverTypes = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.contextReceiverTypes(r10, readContextWithTypeParameters$kotlin_metadata.getTypes());
                java.util.List<kotlin.reflect.jvm.internal.impl.km.KmType> contextReceiverTypes = kmClass.getContextReceiverTypes();
                java.util.Iterator<T> it3 = listContextReceiverTypes.iterator();
                while (it3.hasNext()) {
                    contextReceiverTypes.add(toKmType((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) it3.next(), readContextWithTypeParameters$kotlin_metadata));
                }
                java.util.List<java.lang.Integer> versionRequirementList = r10.getVersionRequirementList();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(versionRequirementList, "getVersionRequirementList(...)");
                java.util.List<kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement> versionRequirements = kmClass.getVersionRequirements();
                for (java.lang.Integer num3 : versionRequirementList) {
                    kotlin.jvm.internal.Intrinsics.checkNotNull(num3);
                    versionRequirements.add(readVersionRequirement(num3.intValue(), readContextWithTypeParameters$kotlin_metadata));
                }
                java.util.Iterator<T> it4 = readContextWithTypeParameters$kotlin_metadata.getExtensions$kotlin_metadata().iterator();
                while (it4.hasNext()) {
                    ((kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions) it4.next()).readClassExtensions(kmClass, r10, readContextWithTypeParameters$kotlin_metadata);
                }
                return kmClass;
            }
        }
    }

    private static final kotlin.reflect.jvm.internal.impl.km.KmEnumEntry toKmEnumEntry(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry enumEntry, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext) {
        kotlin.reflect.jvm.internal.impl.km.KmEnumEntry kmEnumEntry = new kotlin.reflect.jvm.internal.impl.km.KmEnumEntry(readContext.get(enumEntry.getName()));
        java.util.Iterator<T> it = readContext.getExtensions$kotlin_metadata().iterator();
        while (it.hasNext()) {
            ((kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions) it.next()).readEnumEntryExtensions(kmEnumEntry, enumEntry, readContext);
        }
        return kmEnumEntry;
    }

    private static final kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type loadInlineClassUnderlyingType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class r7, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext) {
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type typeInlineClassUnderlyingType = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.inlineClassUnderlyingType(r7, readContext.getTypes());
        if (typeInlineClassUnderlyingType != null) {
            return typeInlineClassUnderlyingType;
        }
        if (!r7.hasInlineClassUnderlyingPropertyName()) {
            return null;
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property> propertyList = r7.getPropertyList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(propertyList, "getPropertyList(...)");
        java.util.Iterator<T> it = propertyList.iterator();
        boolean z = false;
        java.lang.Object obj = null;
        while (true) {
            if (!it.hasNext()) {
                if (!z) {
                    break;
                }
                break;
            }
            java.lang.Object next = it.next();
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) next;
            kotlin.jvm.internal.Intrinsics.checkNotNull(property);
            if (kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.receiverType(property, readContext.getTypes()) == null && kotlin.jvm.internal.Intrinsics.areEqual(readContext.get(property.getName()), readContext.get(r7.getInlineClassUnderlyingPropertyName()))) {
                if (!z) {
                    z = true;
                    obj = next;
                }
            }
            obj = null;
            break;
        }
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property2 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) obj;
        if (property2 != null) {
            return kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.returnType(property2, readContext.getTypes());
        }
        return null;
    }

    private static final void visitDeclarations(kotlin.reflect.jvm.internal.impl.km.KmDeclarationContainer kmDeclarationContainer, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function> list, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property> list2, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias> list3, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext) {
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmFunction> functions = kmDeclarationContainer.getFunctions();
        java.util.Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            functions.add(toKmFunction((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) it.next(), readContext));
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmProperty> properties = kmDeclarationContainer.getProperties();
        java.util.Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            properties.add(toKmProperty((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) it2.next(), readContext));
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmTypeAlias> typeAliases = kmDeclarationContainer.getTypeAliases();
        java.util.Iterator<T> it3 = list3.iterator();
        while (it3.hasNext()) {
            typeAliases.add(toKmTypeAlias((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias) it3.next(), readContext));
        }
    }

    private static final kotlin.reflect.jvm.internal.impl.km.KmConstructor toKmConstructor(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor constructor, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext) {
        kotlin.reflect.jvm.internal.impl.km.KmConstructor kmConstructor = new kotlin.reflect.jvm.internal.impl.km.KmConstructor(constructor.getFlags());
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter> valueParameterList = constructor.getValueParameterList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameterList, "getValueParameterList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmValueParameter> valueParameters = kmConstructor.getValueParameters();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter valueParameter : valueParameterList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(valueParameter);
            valueParameters.add(toKmValueParameter(valueParameter, readContext));
        }
        java.util.List<java.lang.Integer> versionRequirementList = constructor.getVersionRequirementList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(versionRequirementList, "getVersionRequirementList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement> versionRequirements = kmConstructor.getVersionRequirements();
        for (java.lang.Integer num : versionRequirementList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(num);
            versionRequirements.add(readVersionRequirement(num.intValue(), readContext));
        }
        java.util.Iterator<T> it = readContext.getExtensions$kotlin_metadata().iterator();
        while (it.hasNext()) {
            ((kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions) it.next()).readConstructorExtensions(kmConstructor, constructor, readContext);
        }
        return kmConstructor;
    }

    private static final kotlin.reflect.jvm.internal.impl.km.KmFunction toKmFunction(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function function, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext) {
        kotlin.reflect.jvm.internal.impl.km.KmFunction kmFunction = new kotlin.reflect.jvm.internal.impl.km.KmFunction(function.getFlags(), readContext.get(function.getName()));
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter> typeParameterList = function.getTypeParameterList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContextWithTypeParameters$kotlin_metadata = readContext.withTypeParameters$kotlin_metadata(typeParameterList);
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter> typeParameterList2 = function.getTypeParameterList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameterList2, "getTypeParameterList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmTypeParameter> typeParameters = kmFunction.getTypeParameters();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter typeParameter : typeParameterList2) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(typeParameter);
            typeParameters.add(toKmTypeParameter(typeParameter, readContextWithTypeParameters$kotlin_metadata));
        }
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type typeReceiverType = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.receiverType(function, readContextWithTypeParameters$kotlin_metadata.getTypes());
        kmFunction.setReceiverParameterType(typeReceiverType != null ? toKmType(typeReceiverType, readContextWithTypeParameters$kotlin_metadata) : null);
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type> listContextReceiverTypes = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.contextReceiverTypes(function, readContextWithTypeParameters$kotlin_metadata.getTypes());
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmType> contextReceiverTypes = kmFunction.getContextReceiverTypes();
        java.util.Iterator<T> it = listContextReceiverTypes.iterator();
        while (it.hasNext()) {
            contextReceiverTypes.add(toKmType((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) it.next(), readContextWithTypeParameters$kotlin_metadata));
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter> valueParameterList = function.getValueParameterList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(valueParameterList, "getValueParameterList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmValueParameter> valueParameters = kmFunction.getValueParameters();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter valueParameter : valueParameterList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(valueParameter);
            valueParameters.add(toKmValueParameter(valueParameter, readContextWithTypeParameters$kotlin_metadata));
        }
        kmFunction.setReturnType(toKmType(kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.returnType(function, readContextWithTypeParameters$kotlin_metadata.getTypes()), readContextWithTypeParameters$kotlin_metadata));
        if (function.hasContract()) {
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract contract = function.getContract();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(contract, "getContract(...)");
            kmFunction.setContract(toKmContract(contract, readContextWithTypeParameters$kotlin_metadata));
        }
        java.util.List<java.lang.Integer> versionRequirementList = function.getVersionRequirementList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(versionRequirementList, "getVersionRequirementList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement> versionRequirements = kmFunction.getVersionRequirements();
        for (java.lang.Integer num : versionRequirementList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(num);
            versionRequirements.add(readVersionRequirement(num.intValue(), readContextWithTypeParameters$kotlin_metadata));
        }
        java.util.Iterator<T> it2 = readContextWithTypeParameters$kotlin_metadata.getExtensions$kotlin_metadata().iterator();
        while (it2.hasNext()) {
            ((kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions) it2.next()).readFunctionExtensions(kmFunction, function, readContextWithTypeParameters$kotlin_metadata);
        }
        return kmFunction;
    }

    public static final kotlin.reflect.jvm.internal.impl.km.KmProperty toKmProperty(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext outer) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(outer, "outer");
        kotlin.reflect.jvm.internal.impl.km.KmProperty kmProperty = new kotlin.reflect.jvm.internal.impl.km.KmProperty(property.getFlags(), outer.get(property.getName()), getPropertyGetterFlags(property), getPropertySetterFlags(property));
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter> typeParameterList = property.getTypeParameterList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContextWithTypeParameters$kotlin_metadata = outer.withTypeParameters$kotlin_metadata(typeParameterList);
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter> typeParameterList2 = property.getTypeParameterList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameterList2, "getTypeParameterList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmTypeParameter> typeParameters = kmProperty.getTypeParameters();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter typeParameter : typeParameterList2) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(typeParameter);
            typeParameters.add(toKmTypeParameter(typeParameter, readContextWithTypeParameters$kotlin_metadata));
        }
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type typeReceiverType = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.receiverType(property, readContextWithTypeParameters$kotlin_metadata.getTypes());
        kmProperty.setReceiverParameterType(typeReceiverType != null ? toKmType(typeReceiverType, readContextWithTypeParameters$kotlin_metadata) : null);
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type> listContextReceiverTypes = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.contextReceiverTypes(property, readContextWithTypeParameters$kotlin_metadata.getTypes());
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmType> contextReceiverTypes = kmProperty.getContextReceiverTypes();
        java.util.Iterator<T> it = listContextReceiverTypes.iterator();
        while (it.hasNext()) {
            contextReceiverTypes.add(toKmType((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) it.next(), readContextWithTypeParameters$kotlin_metadata));
        }
        if (property.hasSetterValueParameter()) {
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter setterValueParameter = property.getSetterValueParameter();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(setterValueParameter, "getSetterValueParameter(...)");
            kmProperty.setSetterParameter(toKmValueParameter(setterValueParameter, readContextWithTypeParameters$kotlin_metadata));
        }
        kmProperty.setReturnType(toKmType(kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.returnType(property, readContextWithTypeParameters$kotlin_metadata.getTypes()), readContextWithTypeParameters$kotlin_metadata));
        java.util.List<java.lang.Integer> versionRequirementList = property.getVersionRequirementList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(versionRequirementList, "getVersionRequirementList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement> versionRequirements = kmProperty.getVersionRequirements();
        for (java.lang.Integer num : versionRequirementList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(num);
            versionRequirements.add(readVersionRequirement(num.intValue(), readContextWithTypeParameters$kotlin_metadata));
        }
        java.util.Iterator<T> it2 = readContextWithTypeParameters$kotlin_metadata.getExtensions$kotlin_metadata().iterator();
        while (it2.hasNext()) {
            ((kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions) it2.next()).readPropertyExtensions(kmProperty, property, readContextWithTypeParameters$kotlin_metadata);
        }
        return kmProperty;
    }

    private static final kotlin.reflect.jvm.internal.impl.km.KmTypeAlias toKmTypeAlias(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias typeAlias, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext) {
        kotlin.reflect.jvm.internal.impl.km.KmTypeAlias kmTypeAlias = new kotlin.reflect.jvm.internal.impl.km.KmTypeAlias(typeAlias.getFlags(), readContext.get(typeAlias.getName()));
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter> typeParameterList = typeAlias.getTypeParameterList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameterList, "getTypeParameterList(...)");
        kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContextWithTypeParameters$kotlin_metadata = readContext.withTypeParameters$kotlin_metadata(typeParameterList);
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter> typeParameterList2 = typeAlias.getTypeParameterList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(typeParameterList2, "getTypeParameterList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmTypeParameter> typeParameters = kmTypeAlias.getTypeParameters();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter typeParameter : typeParameterList2) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(typeParameter);
            typeParameters.add(toKmTypeParameter(typeParameter, readContextWithTypeParameters$kotlin_metadata));
        }
        kmTypeAlias.setUnderlyingType(toKmType(kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.underlyingType(typeAlias, readContextWithTypeParameters$kotlin_metadata.getTypes()), readContextWithTypeParameters$kotlin_metadata));
        kmTypeAlias.setExpandedType(toKmType(kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.expandedType(typeAlias, readContextWithTypeParameters$kotlin_metadata.getTypes()), readContextWithTypeParameters$kotlin_metadata));
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation> annotationList = typeAlias.getAnnotationList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(annotationList, "getAnnotationList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmAnnotation> annotations = kmTypeAlias.getAnnotations();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation annotation : annotationList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(annotation);
            annotations.add(kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt.readAnnotation(annotation, readContextWithTypeParameters$kotlin_metadata.getStrings()));
        }
        java.util.List<java.lang.Integer> versionRequirementList = typeAlias.getVersionRequirementList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(versionRequirementList, "getVersionRequirementList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement> versionRequirements = kmTypeAlias.getVersionRequirements();
        for (java.lang.Integer num : versionRequirementList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(num);
            versionRequirements.add(readVersionRequirement(num.intValue(), readContextWithTypeParameters$kotlin_metadata));
        }
        java.util.Iterator<T> it = readContextWithTypeParameters$kotlin_metadata.getExtensions$kotlin_metadata().iterator();
        while (it.hasNext()) {
            ((kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions) it.next()).readTypeAliasExtensions(kmTypeAlias, typeAlias, readContextWithTypeParameters$kotlin_metadata);
        }
        return kmTypeAlias;
    }

    private static final kotlin.reflect.jvm.internal.impl.km.KmValueParameter toKmValueParameter(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter valueParameter, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext) {
        kotlin.reflect.jvm.internal.impl.km.KmValueParameter kmValueParameter = new kotlin.reflect.jvm.internal.impl.km.KmValueParameter(valueParameter.getFlags(), readContext.get(valueParameter.getName()));
        kmValueParameter.setType(toKmType(kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.type(valueParameter, readContext.getTypes()), readContext));
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type typeVarargElementType = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.varargElementType(valueParameter, readContext.getTypes());
        kmValueParameter.setVarargElementType(typeVarargElementType != null ? toKmType(typeVarargElementType, readContext) : null);
        if (valueParameter.hasAnnotationParameterDefaultValue()) {
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value annotationParameterDefaultValue = valueParameter.getAnnotationParameterDefaultValue();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(annotationParameterDefaultValue, "getAnnotationParameterDefaultValue(...)");
            kmValueParameter.setAnnotationParameterDefaultValue(kotlin.reflect.jvm.internal.impl.km.internal.ReadUtilsKt.readAnnotationArgument(annotationParameterDefaultValue, readContext.getStrings()));
        }
        java.util.Iterator<T> it = readContext.getExtensions$kotlin_metadata().iterator();
        while (it.hasNext()) {
            ((kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions) it.next()).readValueParameterExtensions(kmValueParameter, valueParameter, readContext);
        }
        return kmValueParameter;
    }

    private static final kotlin.reflect.jvm.internal.impl.km.KmTypeParameter toKmTypeParameter(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter typeParameter, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext) {
        kotlin.reflect.jvm.internal.impl.km.KmVariance kmVariance;
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Variance variance = typeParameter.getVariance();
        if (variance == null) {
            throw new java.lang.IllegalArgumentException("Required value was null.".toString());
        }
        int i = kotlin.reflect.jvm.internal.impl.km.internal.ReadersKt.WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
        if (i == 1) {
            kmVariance = kotlin.reflect.jvm.internal.impl.km.KmVariance.IN;
        } else if (i == 2) {
            kmVariance = kotlin.reflect.jvm.internal.impl.km.KmVariance.OUT;
        } else {
            if (i != 3) {
                throw new kotlin.NoWhenBranchMatchedException();
            }
            kmVariance = kotlin.reflect.jvm.internal.impl.km.KmVariance.INVARIANT;
        }
        kotlin.reflect.jvm.internal.impl.km.KmTypeParameter kmTypeParameter = new kotlin.reflect.jvm.internal.impl.km.KmTypeParameter(getTypeParameterFlags(typeParameter), readContext.get(typeParameter.getName()), typeParameter.getId(), kmVariance);
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type> listUpperBounds = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.upperBounds(typeParameter, readContext.getTypes());
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmType> upperBounds = kmTypeParameter.getUpperBounds();
        java.util.Iterator<T> it = listUpperBounds.iterator();
        while (it.hasNext()) {
            upperBounds.add(toKmType((kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) it.next(), readContext));
        }
        java.util.Iterator<T> it2 = readContext.getExtensions$kotlin_metadata().iterator();
        while (it2.hasNext()) {
            ((kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions) it2.next()).readTypeParameterExtensions(kmTypeParameter, typeParameter, readContext);
        }
        return kmTypeParameter;
    }

    private static final kotlin.reflect.jvm.internal.impl.km.KmType toKmType(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type type, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext) {
        kotlin.reflect.jvm.internal.impl.km.KmClassifier.TypeParameter typeParameter;
        kotlin.reflect.jvm.internal.impl.km.KmType kmType;
        kotlin.reflect.jvm.internal.impl.km.KmVariance kmVariance;
        kotlin.reflect.jvm.internal.impl.km.KmType kmType2 = new kotlin.reflect.jvm.internal.impl.km.KmType(getTypeFlags(type));
        kotlin.reflect.jvm.internal.impl.km.KmFlexibleTypeUpperBound kmFlexibleTypeUpperBound = null;
        kmFlexibleTypeUpperBound = null;
        if (type.hasClassName()) {
            typeParameter = new kotlin.reflect.jvm.internal.impl.km.KmClassifier.Class(readContext.className$kotlin_metadata(type.getClassName()));
        } else if (type.hasTypeAliasName()) {
            typeParameter = new kotlin.reflect.jvm.internal.impl.km.KmClassifier.TypeAlias(readContext.className$kotlin_metadata(type.getTypeAliasName()));
        } else if (type.hasTypeParameter()) {
            typeParameter = new kotlin.reflect.jvm.internal.impl.km.KmClassifier.TypeParameter(type.getTypeParameter());
        } else if (type.hasTypeParameterName()) {
            java.lang.Integer typeParameterId$kotlin_metadata = readContext.getTypeParameterId$kotlin_metadata(type.getTypeParameterName());
            if (typeParameterId$kotlin_metadata == null) {
                throw new kotlin.reflect.jvm.internal.impl.km.InconsistentKotlinMetadataException("No type parameter id for " + readContext.get(type.getTypeParameterName()), null, 2, null);
            }
            typeParameter = new kotlin.reflect.jvm.internal.impl.km.KmClassifier.TypeParameter(typeParameterId$kotlin_metadata.intValue());
        } else {
            throw new kotlin.reflect.jvm.internal.impl.km.InconsistentKotlinMetadataException("No classifier (class, type alias or type parameter) recorded for Type", null, 2, null);
        }
        kmType2.setClassifier(typeParameter);
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument argument : type.getArgumentList()) {
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection projection = argument.getProjection();
            if (projection == null) {
                throw new java.lang.IllegalArgumentException("Required value was null.".toString());
            }
            int i = kotlin.reflect.jvm.internal.impl.km.internal.ReadersKt.WhenMappings.$EnumSwitchMapping$1[projection.ordinal()];
            if (i == 1) {
                kmVariance = kotlin.reflect.jvm.internal.impl.km.KmVariance.IN;
            } else if (i == 2) {
                kmVariance = kotlin.reflect.jvm.internal.impl.km.KmVariance.OUT;
            } else if (i == 3) {
                kmVariance = kotlin.reflect.jvm.internal.impl.km.KmVariance.INVARIANT;
            } else {
                if (i != 4) {
                    throw new kotlin.NoWhenBranchMatchedException();
                }
                kmVariance = null;
            }
            if (kmVariance != null) {
                kotlin.jvm.internal.Intrinsics.checkNotNull(argument);
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type type2 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.type(argument, readContext.getTypes());
                if (type2 == null) {
                    throw new kotlin.reflect.jvm.internal.impl.km.InconsistentKotlinMetadataException("No type argument for non-STAR projection in Type", null, 2, null);
                }
                kmType2.getArguments().add(new kotlin.reflect.jvm.internal.impl.km.KmTypeProjection(kmVariance, toKmType(type2, readContext)));
            } else {
                kmType2.getArguments().add(kotlin.reflect.jvm.internal.impl.km.KmTypeProjection.STAR);
            }
        }
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type typeAbbreviatedType = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.abbreviatedType(type, readContext.getTypes());
        kmType2.setAbbreviatedType(typeAbbreviatedType != null ? toKmType(typeAbbreviatedType, readContext) : null);
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type typeOuterType = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.outerType(type, readContext.getTypes());
        kmType2.setOuterType(typeOuterType != null ? toKmType(typeOuterType, readContext) : null);
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type typeFlexibleUpperBound = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.flexibleUpperBound(type, readContext.getTypes());
        if (typeFlexibleUpperBound != null && (kmType = toKmType(typeFlexibleUpperBound, readContext)) != null) {
            kmFlexibleTypeUpperBound = new kotlin.reflect.jvm.internal.impl.km.KmFlexibleTypeUpperBound(kmType, type.hasFlexibleTypeCapabilitiesId() ? readContext.get(type.getFlexibleTypeCapabilitiesId()) : null);
        }
        kmType2.setFlexibleTypeUpperBound(kmFlexibleTypeUpperBound);
        java.util.Iterator<T> it = readContext.getExtensions$kotlin_metadata().iterator();
        while (it.hasNext()) {
            ((kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions) it.next()).readTypeExtensions(kmType2, type, readContext);
        }
        return kmType2;
    }

    private static final kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement readVersionRequirement(int i, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext) {
        kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind kmVersionRequirementVersionKind;
        kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel kmVersionRequirementLevel;
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version version;
        kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement kmVersionRequirement = new kotlin.reflect.jvm.internal.impl.km.KmVersionRequirement();
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement versionRequirementCreate = kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Companion.create(i, readContext.getStrings(), readContext.getVersionRequirements$kotlin_metadata());
        if (versionRequirementCreate == null && !readContext.getIgnoreUnknownVersionRequirements$kotlin_metadata()) {
            throw new kotlin.reflect.jvm.internal.impl.km.InconsistentKotlinMetadataException("No VersionRequirement with the given id in the table", null, 2, null);
        }
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.VersionKind kind = versionRequirementCreate != null ? versionRequirementCreate.getKind() : null;
        int i2 = kind == null ? -1 : kotlin.reflect.jvm.internal.impl.km.internal.ReadersKt.WhenMappings.$EnumSwitchMapping$2[kind.ordinal()];
        if (i2 == -1) {
            kmVersionRequirementVersionKind = kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind.UNKNOWN;
        } else if (i2 == 1) {
            kmVersionRequirementVersionKind = kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind.LANGUAGE_VERSION;
        } else if (i2 == 2) {
            kmVersionRequirementVersionKind = kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind.COMPILER_VERSION;
        } else {
            if (i2 != 3) {
                throw new kotlin.NoWhenBranchMatchedException();
            }
            kmVersionRequirementVersionKind = kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementVersionKind.API_VERSION;
        }
        kotlin.DeprecationLevel level = versionRequirementCreate != null ? versionRequirementCreate.getLevel() : null;
        int i3 = level == null ? -1 : kotlin.reflect.jvm.internal.impl.km.internal.ReadersKt.WhenMappings.$EnumSwitchMapping$3[level.ordinal()];
        if (i3 == -1) {
            kmVersionRequirementLevel = kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel.HIDDEN;
        } else if (i3 == 1) {
            kmVersionRequirementLevel = kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel.WARNING;
        } else if (i3 == 2) {
            kmVersionRequirementLevel = kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel.ERROR;
        } else {
            if (i3 != 3) {
                throw new kotlin.NoWhenBranchMatchedException();
            }
            kmVersionRequirementLevel = kotlin.reflect.jvm.internal.impl.km.KmVersionRequirementLevel.HIDDEN;
        }
        kmVersionRequirement.setKind(kmVersionRequirementVersionKind);
        kmVersionRequirement.setLevel(kmVersionRequirementLevel);
        kmVersionRequirement.setErrorCode(versionRequirementCreate != null ? versionRequirementCreate.getErrorCode() : null);
        kmVersionRequirement.setMessage(versionRequirementCreate != null ? versionRequirementCreate.getMessage() : null);
        if (versionRequirementCreate == null || (version = versionRequirementCreate.getVersion()) == null) {
            version = kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version.INFINITY;
        }
        kmVersionRequirement.setVersion(new kotlin.reflect.jvm.internal.impl.km.KmVersion(version.component1(), version.component2(), version.component3()));
        return kmVersionRequirement;
    }

    private static final kotlin.reflect.jvm.internal.impl.km.KmContract toKmContract(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract contract, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext) {
        kotlin.reflect.jvm.internal.impl.km.KmEffectType kmEffectType;
        kotlin.reflect.jvm.internal.impl.km.KmEffectInvocationKind kmEffectInvocationKind;
        kotlin.reflect.jvm.internal.impl.km.KmContract kmContract = new kotlin.reflect.jvm.internal.impl.km.KmContract();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect effect : contract.getEffectList()) {
            if (effect.hasEffectType()) {
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.EffectType effectType = effect.getEffectType();
                if (effectType == null) {
                    throw new java.lang.IllegalArgumentException("Required value was null.".toString());
                }
                int i = kotlin.reflect.jvm.internal.impl.km.internal.ReadersKt.WhenMappings.$EnumSwitchMapping$4[effectType.ordinal()];
                if (i == 1) {
                    kmEffectType = kotlin.reflect.jvm.internal.impl.km.KmEffectType.RETURNS_CONSTANT;
                } else if (i == 2) {
                    kmEffectType = kotlin.reflect.jvm.internal.impl.km.KmEffectType.CALLS;
                } else {
                    if (i != 3) {
                        throw new kotlin.NoWhenBranchMatchedException();
                    }
                    kmEffectType = kotlin.reflect.jvm.internal.impl.km.KmEffectType.RETURNS_NOT_NULL;
                }
                if (effect.hasKind()) {
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.InvocationKind kind = effect.getKind();
                    if (kind == null) {
                        throw new java.lang.IllegalArgumentException("Required value was null.".toString());
                    }
                    int i2 = kotlin.reflect.jvm.internal.impl.km.internal.ReadersKt.WhenMappings.$EnumSwitchMapping$5[kind.ordinal()];
                    if (i2 == 1) {
                        kmEffectInvocationKind = kotlin.reflect.jvm.internal.impl.km.KmEffectInvocationKind.AT_MOST_ONCE;
                    } else if (i2 == 2) {
                        kmEffectInvocationKind = kotlin.reflect.jvm.internal.impl.km.KmEffectInvocationKind.EXACTLY_ONCE;
                    } else {
                        if (i2 != 3) {
                            throw new kotlin.NoWhenBranchMatchedException();
                        }
                        kmEffectInvocationKind = kotlin.reflect.jvm.internal.impl.km.KmEffectInvocationKind.AT_LEAST_ONCE;
                    }
                } else {
                    kmEffectInvocationKind = null;
                }
                java.util.List<kotlin.reflect.jvm.internal.impl.km.KmEffect> effects = kmContract.getEffects();
                kotlin.jvm.internal.Intrinsics.checkNotNull(effect);
                effects.add(toKmEffect(effect, kmEffectType, kmEffectInvocationKind, readContext));
            }
        }
        return kmContract;
    }

    private static final kotlin.reflect.jvm.internal.impl.km.KmEffect toKmEffect(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect effect, kotlin.reflect.jvm.internal.impl.km.KmEffectType kmEffectType, kotlin.reflect.jvm.internal.impl.km.KmEffectInvocationKind kmEffectInvocationKind, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext) {
        kotlin.reflect.jvm.internal.impl.km.KmEffect kmEffect = new kotlin.reflect.jvm.internal.impl.km.KmEffect(kmEffectType, kmEffectInvocationKind);
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression> effectConstructorArgumentList = effect.getEffectConstructorArgumentList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(effectConstructorArgumentList, "getEffectConstructorArgumentList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmEffectExpression> constructorArguments = kmEffect.getConstructorArguments();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression expression : effectConstructorArgumentList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(expression);
            constructorArguments.add(toKmEffectExpression(expression, readContext));
        }
        if (effect.hasConclusionOfConditionalEffect()) {
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression conclusionOfConditionalEffect = effect.getConclusionOfConditionalEffect();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(conclusionOfConditionalEffect, "getConclusionOfConditionalEffect(...)");
            kmEffect.setConclusion(toKmEffectExpression(conclusionOfConditionalEffect, readContext));
        }
        return kmEffect;
    }

    private static final kotlin.reflect.jvm.internal.impl.km.KmEffectExpression toKmEffectExpression(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression expression, kotlin.reflect.jvm.internal.impl.km.internal.ReadContext readContext) {
        java.lang.Boolean bool;
        kotlin.reflect.jvm.internal.impl.km.KmEffectExpression kmEffectExpression = new kotlin.reflect.jvm.internal.impl.km.KmEffectExpression();
        kmEffectExpression.setFlags$kotlin_metadata(expression.getFlags());
        kmEffectExpression.setParameterIndex(expression.hasValueParameterReference() ? java.lang.Integer.valueOf(expression.getValueParameterReference()) : null);
        if (expression.hasConstantValue()) {
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression.ConstantValue constantValue = expression.getConstantValue();
            if (constantValue != null) {
                int i = kotlin.reflect.jvm.internal.impl.km.internal.ReadersKt.WhenMappings.$EnumSwitchMapping$6[constantValue.ordinal()];
                if (i == 1) {
                    bool = true;
                } else if (i == 2) {
                    bool = false;
                } else {
                    if (i != 3) {
                        throw new kotlin.NoWhenBranchMatchedException();
                    }
                    bool = null;
                }
                kmEffectExpression.setConstantValue(new kotlin.reflect.jvm.internal.impl.km.KmConstantValue(bool));
            } else {
                throw new java.lang.IllegalArgumentException("Required value was null.".toString());
            }
        }
        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type typeIsInstanceType = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.isInstanceType(expression, readContext.getTypes());
        kmEffectExpression.setInstanceType(typeIsInstanceType != null ? toKmType(typeIsInstanceType, readContext) : null);
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression> andArgumentList = expression.getAndArgumentList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(andArgumentList, "getAndArgumentList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmEffectExpression> andArguments = kmEffectExpression.getAndArguments();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression expression2 : andArgumentList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(expression2);
            andArguments.add(toKmEffectExpression(expression2, readContext));
        }
        java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression> orArgumentList = expression.getOrArgumentList();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(orArgumentList, "getOrArgumentList(...)");
        java.util.List<kotlin.reflect.jvm.internal.impl.km.KmEffectExpression> orArguments = kmEffectExpression.getOrArguments();
        for (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression expression3 : orArgumentList) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(expression3);
            orArguments.add(toKmEffectExpression(expression3, readContext));
        }
        return kmEffectExpression;
    }

    private static final int getTypeFlags(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type type) {
        boolean nullable = type.getNullable();
        return (nullable ? 1 : 0) + (type.getFlags() << 1);
    }

    private static final int getTypeParameterFlags(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter typeParameter) {
        return typeParameter.getReified() ? 1 : 0;
    }

    public static final int getPropertyGetterFlags(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        return property.hasGetterFlags() ? property.getGetterFlags() : getDefaultPropertyAccessorFlags(property.getFlags());
    }

    public static final int getPropertySetterFlags(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property property) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "<this>");
        return property.hasSetterFlags() ? property.getSetterFlags() : getDefaultPropertyAccessorFlags(property.getFlags());
    }

    public static final int getDefaultPropertyAccessorFlags(int i) {
        java.lang.Boolean bool = kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.HAS_ANNOTATIONS.get(i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        return kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.getAccessorFlags(bool.booleanValue(), kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.VISIBILITY.get(i), kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.MODALITY.get(i), false, false, false);
    }
}
