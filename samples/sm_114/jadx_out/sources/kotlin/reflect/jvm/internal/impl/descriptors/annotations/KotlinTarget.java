package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

/* JADX INFO: compiled from: KotlinTarget.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum KotlinTarget {
    CLASS("class", false, 2, null),
    ANNOTATION_CLASS("annotation class", false, 2, null),
    TYPE_PARAMETER("type parameter", false),
    PROPERTY("property", false, 2, null),
    FIELD("field", false, 2, null),
    LOCAL_VARIABLE("local variable", false, 2, null),
    VALUE_PARAMETER("value parameter", false, 2, null),
    CONSTRUCTOR("constructor", false, 2, null),
    FUNCTION("function", false, 2, null),
    PROPERTY_GETTER("getter", false, 2, null),
    PROPERTY_SETTER("setter", false, 2, null),
    TYPE("type usage", false),
    EXPRESSION(com.alibaba.android.bindingx.core.internal.BindingXConstants.KEY_EXPRESSION, false),
    FILE("file", false),
    TYPEALIAS("typealias", false),
    TYPE_PROJECTION("type projection", false),
    STAR_PROJECTION("star projection", false),
    PROPERTY_PARAMETER("property constructor parameter", false),
    CLASS_ONLY("class", false),
    OBJECT("object", false),
    STANDALONE_OBJECT("standalone object", false),
    COMPANION_OBJECT("companion object", false),
    INTERFACE("interface", false),
    ENUM_CLASS("enum class", false),
    ENUM_ENTRY("enum entry", false),
    LOCAL_CLASS("local class", false),
    LOCAL_FUNCTION("local function", false),
    MEMBER_FUNCTION("member function", false),
    TOP_LEVEL_FUNCTION("top level function", false),
    MEMBER_PROPERTY("member property", false),
    MEMBER_PROPERTY_WITH_BACKING_FIELD("member property with backing field", false),
    MEMBER_PROPERTY_WITH_DELEGATE("member property with delegate", false),
    MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("member property without backing field or delegate", false),
    TOP_LEVEL_PROPERTY("top level property", false),
    TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD("top level property with backing field", false),
    TOP_LEVEL_PROPERTY_WITH_DELEGATE("top level property with delegate", false),
    TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("top level property without backing field or delegate", false),
    BACKING_FIELD("backing field", false, 2, null),
    INITIALIZER("initializer", false),
    DESTRUCTURING_DECLARATION("destructuring declaration", false),
    LAMBDA_EXPRESSION("lambda expression", false),
    ANONYMOUS_FUNCTION("anonymous function", false),
    OBJECT_LITERAL("object literal", false);

    private static final java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget> ALL_TARGET_SET;
    private static final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget> ANNOTATION_CLASS_LIST;
    private static final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget> CLASS_LIST;
    private static final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget> COMPANION_OBJECT_LIST;
    private static final java.util.Set<kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget> DEFAULT_TARGET_SET;
    private static final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget> ENUM_ENTRY_LIST;
    private static final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget> ENUM_LIST;
    private static final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget> FILE_LIST;
    private static final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget> FUNCTION_LIST;
    private static final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget> INTERFACE_LIST;
    private static final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget> LOCAL_CLASS_LIST;
    private static final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget> OBJECT_LIST;
    private static final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget> PROPERTY_GETTER_LIST;
    private static final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget> PROPERTY_SETTER_LIST;
    private static final java.util.Map<kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget, kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget> USE_SITE_MAPPING;
    private final java.lang.String description;
    private final boolean isDefault;
    private static final /* synthetic */ kotlin.enums.EnumEntries $ENTRIES = kotlin.enums.EnumEntriesKt.enumEntries(values());
    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget.Companion Companion = new kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget.Companion(null);
    private static final java.util.HashMap<java.lang.String, kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget> map = new java.util.HashMap<>();

    public static kotlin.enums.EnumEntries<kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget> getEntries() {
        return $ENTRIES;
    }

    KotlinTarget(java.lang.String str, boolean z) {
        this.description = str;
        this.isDefault = z;
    }

    /* synthetic */ KotlinTarget(java.lang.String str, boolean z, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? true : z);
    }

    static {
        for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget kotlinTarget : getEntries()) {
            map.put(kotlinTarget.name(), kotlinTarget);
        }
        kotlin.enums.EnumEntries<kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget> entries = getEntries();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget kotlinTarget2 : entries) {
            if (kotlinTarget2.isDefault) {
                arrayList.add(kotlinTarget2);
            }
        }
        DEFAULT_TARGET_SET = kotlin.collections.CollectionsKt.toSet(arrayList);
        ALL_TARGET_SET = kotlin.collections.CollectionsKt.toSet(getEntries());
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget kotlinTarget3 = CLASS;
        ANNOTATION_CLASS_LIST = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget[]{ANNOTATION_CLASS, kotlinTarget3});
        LOCAL_CLASS_LIST = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget[]{LOCAL_CLASS, kotlinTarget3});
        CLASS_LIST = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget[]{CLASS_ONLY, kotlinTarget3});
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget kotlinTarget4 = OBJECT;
        COMPANION_OBJECT_LIST = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget[]{COMPANION_OBJECT, kotlinTarget4, kotlinTarget3});
        OBJECT_LIST = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget[]{STANDALONE_OBJECT, kotlinTarget4, kotlinTarget3});
        INTERFACE_LIST = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget[]{INTERFACE, kotlinTarget3});
        ENUM_LIST = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget[]{ENUM_CLASS, kotlinTarget3});
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget kotlinTarget5 = PROPERTY;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget kotlinTarget6 = FIELD;
        ENUM_ENTRY_LIST = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget[]{ENUM_ENTRY, kotlinTarget5, kotlinTarget6});
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget kotlinTarget7 = PROPERTY_SETTER;
        PROPERTY_SETTER_LIST = kotlin.collections.CollectionsKt.listOf(kotlinTarget7);
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget kotlinTarget8 = PROPERTY_GETTER;
        PROPERTY_GETTER_LIST = kotlin.collections.CollectionsKt.listOf(kotlinTarget8);
        FUNCTION_LIST = kotlin.collections.CollectionsKt.listOf(FUNCTION);
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget kotlinTarget9 = FILE;
        FILE_LIST = kotlin.collections.CollectionsKt.listOf(kotlinTarget9);
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget annotationUseSiteTarget = kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget.CONSTRUCTOR_PARAMETER;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget kotlinTarget10 = VALUE_PARAMETER;
        USE_SITE_MAPPING = kotlin.collections.MapsKt.mapOf(kotlin.TuplesKt.to(annotationUseSiteTarget, kotlinTarget10), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget.FIELD, kotlinTarget6), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget.PROPERTY, kotlinTarget5), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget.FILE, kotlinTarget9), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget.PROPERTY_GETTER, kotlinTarget8), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget.PROPERTY_SETTER, kotlinTarget7), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget.RECEIVER, kotlinTarget10), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget.SETTER_PARAMETER, kotlinTarget10), kotlin.TuplesKt.to(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD, kotlinTarget6));
    }

    /* JADX INFO: compiled from: KotlinTarget.kt */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
