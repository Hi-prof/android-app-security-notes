package kotlin.reflect.jvm.internal.impl.load.java;

/* JADX INFO: compiled from: SpecialGenericSignatures.kt */
/* JADX INFO: loaded from: classes2.dex */
public class SpecialGenericSignatures {
    public static final kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion Companion = new kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion(null);
    private static final java.util.List<java.lang.String> ERASED_COLLECTION_PARAMETER_NAMES;
    private static final java.util.List<kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature> ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
    private static final java.util.List<java.lang.String> ERASED_COLLECTION_PARAMETER_SIGNATURES;
    private static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> ERASED_VALUE_PARAMETERS_SHORT_NAMES;
    private static final java.util.Set<java.lang.String> ERASED_VALUE_PARAMETERS_SIGNATURES;
    private static final java.util.Map<kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature, kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription> GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP;
    private static final java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.name.Name> JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;
    private static final java.util.Set<java.lang.String> JVM_SIGNATURES_FOR_RENAMED_BUILT_INS;
    private static final java.util.Map<kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature, kotlin.reflect.jvm.internal.impl.name.Name> NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP;
    private static final java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> ORIGINAL_SHORT_NAMES;
    private static final kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature REMOVE_AT_NAME_AND_SIGNATURE;
    private static final java.util.Map<java.lang.String, kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription> SIGNATURE_TO_DEFAULT_VALUES_MAP;
    private static final java.util.Map<java.lang.String, kotlin.reflect.jvm.internal.impl.name.Name> SIGNATURE_TO_JVM_REPRESENTATION_NAME;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
    public static final class TypeSafeBarrierDescription {
        private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES;
        private static final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription[] $VALUES;
        private final java.lang.Object defaultValue;
        public static final kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription NULL = new kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription("NULL", 0, null);
        public static final kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription INDEX = new kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription("INDEX", 1, -1);
        public static final kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription FALSE = new kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription("FALSE", 2, false);
        public static final kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription MAP_GET_OR_DEFAULT = new kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT("MAP_GET_OR_DEFAULT", 3);

        private static final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription[] $values() {
            return new kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription[]{NULL, INDEX, FALSE, MAP_GET_OR_DEFAULT};
        }

        public /* synthetic */ TypeSafeBarrierDescription(java.lang.String str, int i, java.lang.Object obj, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, obj);
        }

        public static kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription valueOf(java.lang.String str) {
            return (kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription) java.lang.Enum.valueOf(kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription.class, str);
        }

        public static kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription[] values() {
            return (kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription[]) $VALUES.clone();
        }

        private TypeSafeBarrierDescription(java.lang.String str, int i, java.lang.Object obj) {
            super(str, i);
            this.defaultValue = obj;
        }

        static {
            kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription[] typeSafeBarrierDescriptionArr$values = $values();
            $VALUES = typeSafeBarrierDescriptionArr$values;
            $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(typeSafeBarrierDescriptionArr$values);
        }

        /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
        static final class MAP_GET_OR_DEFAULT extends kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription {
            /* JADX WARN: Illegal instructions before constructor call */
            MAP_GET_OR_DEFAULT(java.lang.String str, int i) {
                kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker = null;
                super(str, i, defaultConstructorMarker, defaultConstructorMarker);
            }
        }
    }

    /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
    public enum SpecialSignatureInfo {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);

        private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());
        private final boolean isObjectReplacedWithTypeParameter;
        private final java.lang.String valueParametersSignature;

        SpecialSignatureInfo(java.lang.String str, boolean z) {
            this.valueParametersSignature = str;
            this.isObjectReplacedWithTypeParameter = z;
        }
    }

    /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.SpecialSignatureInfo getSpecialSignatureInfo(java.lang.String builtinSignature) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builtinSignature, "builtinSignature");
            if (getERASED_COLLECTION_PARAMETER_SIGNATURES().contains(builtinSignature)) {
                return kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
            }
            if (((kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription) kotlin.collections.MapsKt.getValue(getSIGNATURE_TO_DEFAULT_VALUES_MAP(), builtinSignature)) == kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription.NULL) {
                return kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC;
            }
            return kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
        }

        /* JADX INFO: compiled from: SpecialGenericSignatures.kt */
        public static final class NameAndSignature {
            private final java.lang.String classInternalName;
            private final kotlin.reflect.jvm.internal.impl.name.Name name;
            private final java.lang.String parameters;
            private final java.lang.String returnType;
            private final java.lang.String signature;

            public static /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature copy$default(kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature nameAndSignature, java.lang.String str, kotlin.reflect.jvm.internal.impl.name.Name name, java.lang.String str2, java.lang.String str3, int i, java.lang.Object obj) {
                if ((i & 1) != 0) {
                    str = nameAndSignature.classInternalName;
                }
                if ((i & 2) != 0) {
                    name = nameAndSignature.name;
                }
                if ((i & 4) != 0) {
                    str2 = nameAndSignature.parameters;
                }
                if ((i & 8) != 0) {
                    str3 = nameAndSignature.returnType;
                }
                return nameAndSignature.copy(str, name, str2, str3);
            }

            public final kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature copy(java.lang.String classInternalName, kotlin.reflect.jvm.internal.impl.name.Name name, java.lang.String parameters, java.lang.String returnType) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classInternalName, "classInternalName");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parameters, "parameters");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(returnType, "returnType");
                return new kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature(classInternalName, name, parameters, returnType);
            }

            public boolean equals(java.lang.Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature)) {
                    return false;
                }
                kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature nameAndSignature = (kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature) obj;
                return kotlin.jvm.internal.Intrinsics.areEqual(this.classInternalName, nameAndSignature.classInternalName) && kotlin.jvm.internal.Intrinsics.areEqual(this.name, nameAndSignature.name) && kotlin.jvm.internal.Intrinsics.areEqual(this.parameters, nameAndSignature.parameters) && kotlin.jvm.internal.Intrinsics.areEqual(this.returnType, nameAndSignature.returnType);
            }

            public int hashCode() {
                return (((((this.classInternalName.hashCode() * 31) + this.name.hashCode()) * 31) + this.parameters.hashCode()) * 31) + this.returnType.hashCode();
            }

            public java.lang.String toString() {
                return "NameAndSignature(classInternalName=" + this.classInternalName + ", name=" + this.name + ", parameters=" + this.parameters + ", returnType=" + this.returnType + com.taobao.weex.el.parse.Operators.BRACKET_END;
            }

            public NameAndSignature(java.lang.String classInternalName, kotlin.reflect.jvm.internal.impl.name.Name name, java.lang.String parameters, java.lang.String returnType) {
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(classInternalName, "classInternalName");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parameters, "parameters");
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(returnType, "returnType");
                this.classInternalName = classInternalName;
                this.name = name;
                this.parameters = parameters;
                this.returnType = returnType;
                this.signature = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE.signature(classInternalName, name + com.taobao.weex.el.parse.Operators.BRACKET_START + parameters + com.taobao.weex.el.parse.Operators.BRACKET_END + returnType);
            }

            public final kotlin.reflect.jvm.internal.impl.name.Name getName() {
                return this.name;
            }

            public final java.lang.String getSignature() {
                return this.signature;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature method(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier(str2);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
            return new kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature(str, nameIdentifier, str3, str4);
        }

        public final java.util.List<java.lang.String> getERASED_COLLECTION_PARAMETER_SIGNATURES() {
            return kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.ERASED_COLLECTION_PARAMETER_SIGNATURES;
        }

        public final java.util.Map<java.lang.String, kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription> getSIGNATURE_TO_DEFAULT_VALUES_MAP() {
            return kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.SIGNATURE_TO_DEFAULT_VALUES_MAP;
        }

        public final java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getERASED_VALUE_PARAMETERS_SHORT_NAMES() {
            return kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.ERASED_VALUE_PARAMETERS_SHORT_NAMES;
        }

        public final java.util.Set<java.lang.String> getERASED_VALUE_PARAMETERS_SIGNATURES() {
            return kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.ERASED_VALUE_PARAMETERS_SIGNATURES;
        }

        public final kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature getREMOVE_AT_NAME_AND_SIGNATURE() {
            return kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.REMOVE_AT_NAME_AND_SIGNATURE;
        }

        public final java.util.Map<java.lang.String, kotlin.reflect.jvm.internal.impl.name.Name> getSIGNATURE_TO_JVM_REPRESENTATION_NAME() {
            return kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.SIGNATURE_TO_JVM_REPRESENTATION_NAME;
        }

        public final java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getORIGINAL_SHORT_NAMES() {
            return kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.ORIGINAL_SHORT_NAMES;
        }

        public final java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.name.Name> getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP() {
            return kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;
        }

        public final kotlin.reflect.jvm.internal.impl.name.Name getBuiltinFunctionNamesByJvmName(kotlin.reflect.jvm.internal.impl.name.Name name) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
            return getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP().get(name);
        }

        public final boolean getSameAsRenamedInJvmBuiltin(kotlin.reflect.jvm.internal.impl.name.Name name) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "<this>");
            return getORIGINAL_SHORT_NAMES().contains(name);
        }
    }

    static {
        java.util.Set<java.lang.String> of = kotlin.collections.SetsKt.setOf((java.lang.Object[]) new java.lang.String[]{"containsAll", "removeAll", "retainAll"});
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(of, 10));
        for (java.lang.String str : of) {
            kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion companion = Companion;
            java.lang.String desc = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.BOOLEAN.getDesc();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(desc, "getDesc(...)");
            arrayList.add(companion.method("java/util/Collection", str, "Ljava/util/Collection;", desc));
        }
        java.util.ArrayList arrayList2 = arrayList;
        ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES = arrayList2;
        java.util.ArrayList arrayList3 = arrayList2;
        java.util.ArrayList arrayList4 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        java.util.Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            arrayList4.add(((kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature) it.next()).getSignature());
        }
        ERASED_COLLECTION_PARAMETER_SIGNATURES = arrayList4;
        java.util.List<kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature> list = ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
        java.util.ArrayList arrayList5 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(list, 10));
        java.util.Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList5.add(((kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature) it2.next()).getName().asString());
        }
        ERASED_COLLECTION_PARAMETER_NAMES = arrayList5;
        kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents signatureBuildingComponents = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE;
        kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion companion2 = Companion;
        java.lang.String strJavaUtil = signatureBuildingComponents.javaUtil("Collection");
        java.lang.String desc2 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.BOOLEAN.getDesc();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(desc2, "getDesc(...)");
        java.lang.String strJavaUtil2 = signatureBuildingComponents.javaUtil("Collection");
        java.lang.String desc3 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.BOOLEAN.getDesc();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(desc3, "getDesc(...)");
        java.lang.String strJavaUtil3 = signatureBuildingComponents.javaUtil("Map");
        java.lang.String desc4 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.BOOLEAN.getDesc();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(desc4, "getDesc(...)");
        java.lang.String strJavaUtil4 = signatureBuildingComponents.javaUtil("Map");
        java.lang.String desc5 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.BOOLEAN.getDesc();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(desc5, "getDesc(...)");
        java.lang.String strJavaUtil5 = signatureBuildingComponents.javaUtil("Map");
        java.lang.String desc6 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.BOOLEAN.getDesc();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(desc6, "getDesc(...)");
        java.lang.String strJavaUtil6 = signatureBuildingComponents.javaUtil("List");
        java.lang.String desc7 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.INT.getDesc();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(desc7, "getDesc(...)");
        java.lang.String strJavaUtil7 = signatureBuildingComponents.javaUtil("List");
        java.lang.String desc8 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.INT.getDesc();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(desc8, "getDesc(...)");
        java.util.Map<kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature, kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription> mapMapOf = kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to(companion2.method(strJavaUtil, "contains", "Ljava/lang/Object;", desc2), kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription.FALSE), kotlin.TuplesKt.to(companion2.method(strJavaUtil2, io.dcloud.common.constant.AbsoluteConst.XML_REMOVE, "Ljava/lang/Object;", desc3), kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription.FALSE), kotlin.TuplesKt.to(companion2.method(strJavaUtil3, "containsKey", "Ljava/lang/Object;", desc4), kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription.FALSE), kotlin.TuplesKt.to(companion2.method(strJavaUtil4, "containsValue", "Ljava/lang/Object;", desc5), kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription.FALSE), kotlin.TuplesKt.to(companion2.method(strJavaUtil5, io.dcloud.common.constant.AbsoluteConst.XML_REMOVE, "Ljava/lang/Object;Ljava/lang/Object;", desc6), kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription.FALSE), kotlin.TuplesKt.to(companion2.method(signatureBuildingComponents.javaUtil("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT), kotlin.TuplesKt.to(companion2.method(signatureBuildingComponents.javaUtil("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription.NULL), kotlin.TuplesKt.to(companion2.method(signatureBuildingComponents.javaUtil("Map"), io.dcloud.common.constant.AbsoluteConst.XML_REMOVE, "Ljava/lang/Object;", "Ljava/lang/Object;"), kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription.NULL), kotlin.TuplesKt.to(companion2.method(strJavaUtil6, "indexOf", "Ljava/lang/Object;", desc7), kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription.INDEX), kotlin.TuplesKt.to(companion2.method(strJavaUtil7, "lastIndexOf", "Ljava/lang/Object;", desc8), kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription.INDEX));
        GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP = mapMapOf;
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(kotlin.collections.MapsKt.mapCapacity(mapMapOf.size()));
        java.util.Iterator<T> it3 = mapMapOf.entrySet().iterator();
        while (it3.hasNext()) {
            java.util.Map.Entry entry = (java.util.Map.Entry) it3.next();
            linkedHashMap.put(((kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature) entry.getKey()).getSignature(), entry.getValue());
        }
        SIGNATURE_TO_DEFAULT_VALUES_MAP = linkedHashMap;
        java.util.Set setPlus = kotlin.collections.SetsKt.plus((java.util.Set) GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP.keySet(), (java.lang.Iterable) ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES);
        java.util.ArrayList arrayList6 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(setPlus, 10));
        java.util.Iterator it4 = setPlus.iterator();
        while (it4.hasNext()) {
            arrayList6.add(((kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature) it4.next()).getName());
        }
        ERASED_VALUE_PARAMETERS_SHORT_NAMES = kotlin.collections.CollectionsKt.toSet(arrayList6);
        java.util.ArrayList arrayList7 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(setPlus, 10));
        java.util.Iterator it5 = setPlus.iterator();
        while (it5.hasNext()) {
            arrayList7.add(((kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature) it5.next()).getSignature());
        }
        ERASED_VALUE_PARAMETERS_SIGNATURES = kotlin.collections.CollectionsKt.toSet(arrayList7);
        kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion companion3 = Companion;
        java.lang.String desc9 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.INT.getDesc();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(desc9, "getDesc(...)");
        kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature nameAndSignatureMethod = companion3.method("java/util/List", "removeAt", desc9, "Ljava/lang/Object;");
        REMOVE_AT_NAME_AND_SIGNATURE = nameAndSignatureMethod;
        kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents signatureBuildingComponents2 = kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.INSTANCE;
        java.lang.String strJavaLang = signatureBuildingComponents2.javaLang("Number");
        java.lang.String desc10 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.BYTE.getDesc();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(desc10, "getDesc(...)");
        java.lang.String strJavaLang2 = signatureBuildingComponents2.javaLang("Number");
        java.lang.String desc11 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.SHORT.getDesc();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(desc11, "getDesc(...)");
        java.lang.String strJavaLang3 = signatureBuildingComponents2.javaLang("Number");
        java.lang.String desc12 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.INT.getDesc();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(desc12, "getDesc(...)");
        java.lang.String strJavaLang4 = signatureBuildingComponents2.javaLang("Number");
        java.lang.String desc13 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.LONG.getDesc();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(desc13, "getDesc(...)");
        java.lang.String strJavaLang5 = signatureBuildingComponents2.javaLang("Number");
        java.lang.String desc14 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.FLOAT.getDesc();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(desc14, "getDesc(...)");
        java.lang.String strJavaLang6 = signatureBuildingComponents2.javaLang("Number");
        java.lang.String desc15 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.DOUBLE.getDesc();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(desc15, "getDesc(...)");
        java.lang.String strJavaLang7 = signatureBuildingComponents2.javaLang("CharSequence");
        java.lang.String desc16 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.INT.getDesc();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(desc16, "getDesc(...)");
        java.lang.String desc17 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType.CHAR.getDesc();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(desc17, "getDesc(...)");
        java.util.Map<kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature, kotlin.reflect.jvm.internal.impl.name.Name> mapMapOf2 = kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to(companion3.method(strJavaLang, "toByte", "", desc10), kotlin.reflect.jvm.internal.impl.name.Name.identifier("byteValue")), kotlin.TuplesKt.to(companion3.method(strJavaLang2, "toShort", "", desc11), kotlin.reflect.jvm.internal.impl.name.Name.identifier("shortValue")), kotlin.TuplesKt.to(companion3.method(strJavaLang3, "toInt", "", desc12), kotlin.reflect.jvm.internal.impl.name.Name.identifier("intValue")), kotlin.TuplesKt.to(companion3.method(strJavaLang4, "toLong", "", desc13), kotlin.reflect.jvm.internal.impl.name.Name.identifier("longValue")), kotlin.TuplesKt.to(companion3.method(strJavaLang5, "toFloat", "", desc14), kotlin.reflect.jvm.internal.impl.name.Name.identifier("floatValue")), kotlin.TuplesKt.to(companion3.method(strJavaLang6, "toDouble", "", desc15), kotlin.reflect.jvm.internal.impl.name.Name.identifier("doubleValue")), kotlin.TuplesKt.to(nameAndSignatureMethod, kotlin.reflect.jvm.internal.impl.name.Name.identifier(io.dcloud.common.constant.AbsoluteConst.XML_REMOVE)), kotlin.TuplesKt.to(companion3.method(strJavaLang7, "get", desc16, desc17), kotlin.reflect.jvm.internal.impl.name.Name.identifier("charAt")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicInteger"), "load", "", "I"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("get")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicInteger"), "store", "I", "V"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("set")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicInteger"), "exchange", "I", "I"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("getAndSet")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicInteger"), "fetchAndAdd", "I", "I"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("getAndAdd")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicInteger"), "addAndFetch", "I", "I"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("addAndGet")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLong"), "load", "", "J"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("get")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLong"), "store", "J", "V"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("set")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLong"), "exchange", "J", "J"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("getAndSet")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLong"), "fetchAndAdd", "J", "J"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("getAndAdd")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLong"), "addAndFetch", "J", "J"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("addAndGet")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicBoolean"), "load", "", "Z"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("get")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicBoolean"), "store", "Z", "V"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("set")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicBoolean"), "exchange", "Z", "Z"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("getAndSet")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicReference"), "load", "", "Ljava/lang/Object;"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("get")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicReference"), "store", "Ljava/lang/Object;", "V"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("set")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicReference"), "exchange", "Ljava/lang/Object;", "Ljava/lang/Object;"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("getAndSet")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicIntegerArray"), "loadAt", "I", "I"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("get")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicIntegerArray"), "storeAt", "II", "V"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("set")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicIntegerArray"), "exchangeAt", "II", "I"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("getAndSet")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicIntegerArray"), "compareAndSetAt", "III", "Z"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("compareAndSet")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicIntegerArray"), "fetchAndAddAt", "II", "I"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("getAndAdd")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicIntegerArray"), "addAndFetchAt", "II", "I"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("addAndGet")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLongArray"), "loadAt", "I", "J"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("get")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLongArray"), "storeAt", "IJ", "V"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("set")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLongArray"), "exchangeAt", "IJ", "J"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("getAndSet")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLongArray"), "compareAndSetAt", "IJJ", "Z"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("compareAndSet")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLongArray"), "fetchAndAddAt", "IJ", "J"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("getAndAdd")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicLongArray"), "addAndFetchAt", "IJ", "J"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("addAndGet")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicReferenceArray"), "loadAt", "I", "Ljava/lang/Object;"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("get")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicReferenceArray"), "storeAt", "ILjava/lang/Object;", "V"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("set")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicReferenceArray"), "exchangeAt", "ILjava/lang/Object;", "Ljava/lang/Object;"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("getAndSet")), kotlin.TuplesKt.to(companion3.method(signatureBuildingComponents2.javaUtilConcurrentAtomic("AtomicReferenceArray"), "compareAndSetAt", "ILjava/lang/Object;Ljava/lang/Object;", "Z"), kotlin.reflect.jvm.internal.impl.name.Name.identifier("compareAndSet")));
        NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP = mapMapOf2;
        java.util.LinkedHashMap linkedHashMap2 = new java.util.LinkedHashMap(kotlin.collections.MapsKt.mapCapacity(mapMapOf2.size()));
        java.util.Iterator<T> it6 = mapMapOf2.entrySet().iterator();
        while (it6.hasNext()) {
            java.util.Map.Entry entry2 = (java.util.Map.Entry) it6.next();
            linkedHashMap2.put(((kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature) entry2.getKey()).getSignature(), entry2.getValue());
        }
        SIGNATURE_TO_JVM_REPRESENTATION_NAME = linkedHashMap2;
        java.util.Map<kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature, kotlin.reflect.jvm.internal.impl.name.Name> map = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP;
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet();
        for (java.util.Map.Entry<kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature, kotlin.reflect.jvm.internal.impl.name.Name> entry3 : map.entrySet()) {
            linkedHashSet.add(kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature.copy$default(entry3.getKey(), null, entry3.getValue(), null, null, 13, null).getSignature());
        }
        JVM_SIGNATURES_FOR_RENAMED_BUILT_INS = linkedHashSet;
        java.util.Set<kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature> setKeySet = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.keySet();
        java.util.HashSet hashSet = new java.util.HashSet();
        java.util.Iterator<T> it7 = setKeySet.iterator();
        while (it7.hasNext()) {
            hashSet.add(((kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature) it7.next()).getName());
        }
        ORIGINAL_SHORT_NAMES = hashSet;
        java.util.Set<java.util.Map.Entry<kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature, kotlin.reflect.jvm.internal.impl.name.Name>> setEntrySet = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.entrySet();
        java.util.ArrayList arrayList8 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(setEntrySet, 10));
        java.util.Iterator<T> it8 = setEntrySet.iterator();
        while (it8.hasNext()) {
            java.util.Map.Entry entry4 = (java.util.Map.Entry) it8.next();
            arrayList8.add(new kotlin.Pair(((kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.Companion.NameAndSignature) entry4.getKey()).getName(), entry4.getValue()));
        }
        java.util.ArrayList<kotlin.Pair> arrayList9 = arrayList8;
        java.util.LinkedHashMap linkedHashMap3 = new java.util.LinkedHashMap(kotlin.ranges.RangesKt.coerceAtLeast(kotlin.collections.MapsKt.mapCapacity(kotlin.collections.CollectionsKt.collectionSizeOrDefault(arrayList9, 10)), 16));
        for (kotlin.Pair pair : arrayList9) {
            linkedHashMap3.put((kotlin.reflect.jvm.internal.impl.name.Name) pair.getSecond(), (kotlin.reflect.jvm.internal.impl.name.Name) pair.getFirst());
        }
        JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP = linkedHashMap3;
    }
}
