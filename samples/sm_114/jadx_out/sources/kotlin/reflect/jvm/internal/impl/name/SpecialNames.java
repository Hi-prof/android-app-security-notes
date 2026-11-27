package kotlin.reflect.jvm.internal.impl.name;

/* JADX INFO: compiled from: SpecialNames.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpecialNames {
    public static final kotlin.reflect.jvm.internal.impl.name.Name ANONYMOUS;
    public static final kotlin.reflect.jvm.internal.impl.name.FqName ANONYMOUS_FQ_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.Name ARRAY;
    public static final kotlin.reflect.jvm.internal.impl.name.Name DEFAULT_NAME_FOR_COMPANION_OBJECT;
    public static final kotlin.reflect.jvm.internal.impl.name.Name DESTRUCT;
    public static final kotlin.reflect.jvm.internal.impl.name.Name ENUM_GET_ENTRIES;
    public static final kotlin.reflect.jvm.internal.impl.name.Name IMPLICIT_SET_PARAMETER;
    public static final kotlin.reflect.jvm.internal.impl.name.Name INIT;
    public static final kotlin.reflect.jvm.internal.impl.name.SpecialNames INSTANCE = new kotlin.reflect.jvm.internal.impl.name.SpecialNames();
    public static final kotlin.reflect.jvm.internal.impl.name.Name ITERATOR;
    public static final kotlin.reflect.jvm.internal.impl.name.Name LOCAL;
    public static final kotlin.reflect.jvm.internal.impl.name.Name NO_NAME_PROVIDED;
    public static final kotlin.reflect.jvm.internal.impl.name.Name RECEIVER;
    public static final kotlin.reflect.jvm.internal.impl.name.Name ROOT_PACKAGE;
    public static final kotlin.reflect.jvm.internal.impl.name.Name SAFE_IDENTIFIER_FOR_NO_NAME;
    public static final kotlin.reflect.jvm.internal.impl.name.Name THIS;
    public static final kotlin.reflect.jvm.internal.impl.name.Name UNARY;
    public static final kotlin.reflect.jvm.internal.impl.name.Name UNDERSCORE_FOR_UNUSED_VAR;
    public static final kotlin.reflect.jvm.internal.impl.name.Name WHEN_SUBJECT;

    private SpecialNames() {
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.Name nameSpecial = kotlin.reflect.jvm.internal.impl.name.Name.special("<no name provided>");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameSpecial, "special(...)");
        NO_NAME_PROVIDED = nameSpecial;
        kotlin.reflect.jvm.internal.impl.name.Name nameSpecial2 = kotlin.reflect.jvm.internal.impl.name.Name.special("<root package>");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameSpecial2, "special(...)");
        ROOT_PACKAGE = nameSpecial2;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier = kotlin.reflect.jvm.internal.impl.name.Name.identifier("Companion");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(...)");
        DEFAULT_NAME_FOR_COMPANION_OBJECT = nameIdentifier;
        kotlin.reflect.jvm.internal.impl.name.Name nameIdentifier2 = kotlin.reflect.jvm.internal.impl.name.Name.identifier("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameIdentifier2, "identifier(...)");
        SAFE_IDENTIFIER_FOR_NO_NAME = nameIdentifier2;
        kotlin.reflect.jvm.internal.impl.name.Name nameSpecial3 = kotlin.reflect.jvm.internal.impl.name.Name.special("<anonymous>");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameSpecial3, "special(...)");
        ANONYMOUS = nameSpecial3;
        kotlin.reflect.jvm.internal.impl.name.FqName.Companion companion = kotlin.reflect.jvm.internal.impl.name.FqName.Companion;
        kotlin.reflect.jvm.internal.impl.name.Name nameSpecial4 = kotlin.reflect.jvm.internal.impl.name.Name.special("<anonymous>");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameSpecial4, "special(...)");
        ANONYMOUS_FQ_NAME = companion.topLevel(nameSpecial4);
        kotlin.reflect.jvm.internal.impl.name.Name nameSpecial5 = kotlin.reflect.jvm.internal.impl.name.Name.special("<unary>");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameSpecial5, "special(...)");
        UNARY = nameSpecial5;
        kotlin.reflect.jvm.internal.impl.name.Name nameSpecial6 = kotlin.reflect.jvm.internal.impl.name.Name.special("<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameSpecial6, "special(...)");
        THIS = nameSpecial6;
        kotlin.reflect.jvm.internal.impl.name.Name nameSpecial7 = kotlin.reflect.jvm.internal.impl.name.Name.special("<init>");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameSpecial7, "special(...)");
        INIT = nameSpecial7;
        kotlin.reflect.jvm.internal.impl.name.Name nameSpecial8 = kotlin.reflect.jvm.internal.impl.name.Name.special("<when-subject>");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameSpecial8, "special(...)");
        WHEN_SUBJECT = nameSpecial8;
        kotlin.reflect.jvm.internal.impl.name.Name nameSpecial9 = kotlin.reflect.jvm.internal.impl.name.Name.special("<iterator>");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameSpecial9, "special(...)");
        ITERATOR = nameSpecial9;
        kotlin.reflect.jvm.internal.impl.name.Name nameSpecial10 = kotlin.reflect.jvm.internal.impl.name.Name.special("<destruct>");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameSpecial10, "special(...)");
        DESTRUCT = nameSpecial10;
        kotlin.reflect.jvm.internal.impl.name.Name nameSpecial11 = kotlin.reflect.jvm.internal.impl.name.Name.special("<local>");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameSpecial11, "special(...)");
        LOCAL = nameSpecial11;
        kotlin.reflect.jvm.internal.impl.name.Name nameSpecial12 = kotlin.reflect.jvm.internal.impl.name.Name.special("<unused var>");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameSpecial12, "special(...)");
        UNDERSCORE_FOR_UNUSED_VAR = nameSpecial12;
        kotlin.reflect.jvm.internal.impl.name.Name nameSpecial13 = kotlin.reflect.jvm.internal.impl.name.Name.special("<set-?>");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameSpecial13, "special(...)");
        IMPLICIT_SET_PARAMETER = nameSpecial13;
        kotlin.reflect.jvm.internal.impl.name.Name nameSpecial14 = kotlin.reflect.jvm.internal.impl.name.Name.special("<array>");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameSpecial14, "special(...)");
        ARRAY = nameSpecial14;
        kotlin.reflect.jvm.internal.impl.name.Name nameSpecial15 = kotlin.reflect.jvm.internal.impl.name.Name.special("<receiver>");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameSpecial15, "special(...)");
        RECEIVER = nameSpecial15;
        kotlin.reflect.jvm.internal.impl.name.Name nameSpecial16 = kotlin.reflect.jvm.internal.impl.name.Name.special("<get-entries>");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(nameSpecial16, "special(...)");
        ENUM_GET_ENTRIES = nameSpecial16;
    }

    @kotlin.jvm.JvmStatic
    public static final kotlin.reflect.jvm.internal.impl.name.Name safeIdentifier(kotlin.reflect.jvm.internal.impl.name.Name name) {
        return (name == null || name.isSpecial()) ? SAFE_IDENTIFIER_FOR_NO_NAME : name;
    }

    public final boolean isSafeIdentifier(kotlin.reflect.jvm.internal.impl.name.Name name) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(name, "name");
        java.lang.String strAsString = name.asString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(strAsString, "asString(...)");
        return strAsString.length() > 0 && !name.isSpecial();
    }
}
